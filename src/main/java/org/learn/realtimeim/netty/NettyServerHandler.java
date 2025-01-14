package org.learn.realtimeim.netty;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.ReferenceCountUtil;
import lombok.extern.slf4j.Slf4j;
import org.learn.realtimeim.protocol.message.Message;
import org.w3c.dom.Text;

import java.util.concurrent.atomic.AtomicInteger;


/**
 * This class is for handling traffic
 *
 * @author choejeongho
 * @version 08/01/2025
 */
@Slf4j
@ChannelHandler.Sharable
public class NettyServerHandler extends ChannelInboundHandlerAdapter {

    private AtomicInteger idle_count = new AtomicInteger(1);
    private AtomicInteger connect_count = new AtomicInteger(1);

    /**
     * when a channel active, send a message
     */
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        log.info("Connect to client: {}", ctx.channel().remoteAddress());
//        Message message = Message.newBuilder()
//                .setMessageId("0")
//                .setChatId("0")
//                .setSenderId("0")
//                .setContent("Channel Active!")
//                .build();
//
//        ctx.writeAndFlush(message);

        ctx.writeAndFlush("Hello! Channel active!");
        super.channelActive(ctx);

    }

    /**
     * traffic handling logic
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object message) throws Exception {
        log.info("Get {}th message from client", connect_count);

        try {
            if (message instanceof TextWebSocketFrame msg){
                log.info("Here is the message: {}", msg.text());
                TextWebSocketFrame res = new TextWebSocketFrame("Get the {}th message from client");
                ctx.writeAndFlush(res);
//            if (message instanceof Message msg) {
//                log.info("Get message from client: {}", msg.toString());
//                Message responseMessage = Message.newBuilder()
//                        .setMessageId("1")
//                        .setChatId("1")
//                        .setSenderId("1")
//                        .setContent("Message received")
//                        .build();
//                ctx.writeAndFlush(responseMessage);
            } else {
                log.info("Unknown data: {}", message);
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ReferenceCountUtil.release(message);
        }
        connect_count.getAndIncrement();
    }

    /**
     * handling overtime, this executes when haven't received heartbeat from client for 5 secs
     * if it happens twice, the channel will close
     */
    public void userEventTriggered(ChannelHandlerContext ctx, Object object) throws Exception {
        if (object instanceof IdleStateEvent event) {
            if (IdleState.READER_IDLE.equals(event.state())) {
                log.info("Haven't been received data from client for 5 seconds");
                if (idle_count.get() > 10) {
                    log.info("Close this inactive channel");
                    ctx.channel().close();
                }
                idle_count.getAndIncrement();
            }

        } else {
            super.userEventTriggered(ctx, object);
        }

    }

    /**
     * Exception handling
     */
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
