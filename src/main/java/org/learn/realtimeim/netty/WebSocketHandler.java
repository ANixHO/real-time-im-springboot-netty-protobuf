package org.learn.realtimeim.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * This class is for xxxx
 *
 * @author choejeongho
 * @version 14/01/2025
 */

@Slf4j
public class WebSocketHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    private AtomicInteger msg_count = new AtomicInteger(1);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) {
        Channel channel = ctx.channel();
        log.info("{}: {}", channel.remoteAddress(), msg.text());
        ctx.channel().writeAndFlush(new TextWebSocketFrame("Get the " + msg_count + "th message from you.: " + msg.text()));
        msg_count.getAndIncrement();
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        log.info("Channel Added: {}", ctx.channel().id().asLongText());
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        log.info("Channel Removed: {}", ctx.channel().id().asLongText());

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.channel().close();
    }


//    private final ConcurrentHashMap<String, Channel> channels = new ConcurrentHashMap<>();
//    private AtomicInteger msg_count = new AtomicInteger(1);
//
//    @Override
//    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) {
//        Channel channel = ctx.channel();
//        log.info("{}: {}", channel.remoteAddress(), msg.text());
//
//        // 处理 ping 消息
//        if ("ping".equals(msg.text())) {
//            ctx.writeAndFlush(new TextWebSocketFrame("pong"));
//            return;
//        }
//
//        ctx.writeAndFlush(new TextWebSocketFrame("Get the " + msg_count.getAndIncrement() + "th message from you.: ") + msg.text());
//    }
//
//    @Override
//    public void handlerAdded(ChannelHandlerContext ctx) {
//        Channel channel = ctx.channel();
//        channels.put(channel.id().asLongText(), channel);
//        log.info("Channel Added: {}", channel.id().asLongText());
//    }
//
//    @Override
//    public void handlerRemoved(ChannelHandlerContext ctx) {
//        Channel channel = ctx.channel();
//        channels.remove(channel.id().asLongText());
//        log.info("Channel Removed: {}", channel.id().asLongText());
//    }
//
//    @Override
//    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
//        if (evt instanceof IdleStateEvent) {
//            IdleStateEvent event = (IdleStateEvent) evt;
//            if (event.state() == IdleState.READER_IDLE) {
//                log.info("Idle check triggered - closing channel");
//                ctx.close();
//            }
//        }
//        super.userEventTriggered(ctx, evt);
//    }
//
//    @Override
//    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
//        log.error("Channel error", cause);
//        ctx.close();
//    }
}
