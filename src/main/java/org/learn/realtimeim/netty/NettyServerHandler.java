package org.learn.realtimeim.netty;

import io.netty.channel.*;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;
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
 * @author Jayden Choe
 * @version 08/01/2025
 */
@Slf4j
@ChannelHandler.Sharable
public class NettyServerHandler extends SimpleChannelInboundHandler<Message> {

    private AtomicInteger idle_count = new AtomicInteger(1);
    private AtomicInteger connect_count = new AtomicInteger(1);

    /**
     * when a channel active, send a message
     */
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        log.info("Connect to client: {}", ctx.channel().remoteAddress());

        ctx.writeAndFlush("Hello! Channel active!");
        super.channelActive(ctx);

    }

    /**
     * traffic handling logic
     */
    @Override
    public void channelRead0(ChannelHandlerContext ctx, Message message) throws Exception {
        log.info("Get {}th message from client", connect_count);

        try {
            Message.ContentType msgType = message.getType();
            switch (msgType) {
                case PING_SIGNAL:
                    handlePingPong(ctx,message);
                    break;
                case PRIVATE_CHAT:
                    handlePrivateChat(ctx, message);
                    break;
                case GROUP_CHAT:
                    handleGroupChat(ctx, message);
                    break;
                default:
                    log.info("Unknown data: {}", message);
                    break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ReferenceCountUtil.release(message);
        }
        connect_count.getAndIncrement();
    }

    private void handleGroupChat(ChannelHandlerContext ctx, Message message) {
        log.info("Get the group chat message: [sender: {} ; chat: {}; content: {}]",
                message.getSenderId(),
                message.getChatId(),
                message.getContent()
        );
    }


    private void handlePrivateChat(ChannelHandlerContext ctx, Message message) {
        log.info("Get the private chat message: [sender: {} ; chat: {}; content: {}]",
                message.getSenderId(),
                message.getChatId(),
                message.getContent()
        );

        Message response = Message.newBuilder()
                .setType(Message.ContentType.PRIVATE_CHAT)
                .setChatId("1")
                .setSenderId("2")
                .setContent("Server: get your message : " + message.getContent())
                .build();

        ctx.writeAndFlush(response);

    }

    private void handlePingPong(ChannelHandlerContext ctx, Message message) {
        log.info("Get the PING message from: {}", ctx.channel().remoteAddress());
        // due to 'react-use-websocket' library only accept string as pong signal
        // need to return String 'pong' here, rather than serialised message by protobuf

        TextWebSocketFrame pong = new TextWebSocketFrame("pong");

        ctx.writeAndFlush(pong);

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
