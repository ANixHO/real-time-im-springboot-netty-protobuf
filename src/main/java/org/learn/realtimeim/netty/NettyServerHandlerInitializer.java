package org.learn.realtimeim.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import io.netty.handler.timeout.IdleStateHandler;
import org.learn.realtimeim.protocol.message.Message;

import java.util.concurrent.TimeUnit;

/**
 * This class is for specific implementation for netty server
 *
 * @author choejeongho
 * @version 08/01/2025
 */

public class NettyServerHandlerInitializer  extends ChannelInitializer<SocketChannel> {

    protected void initChannel(SocketChannel socketChannel) throws Exception{
        ChannelPipeline ph = socketChannel.pipeline();

        // idle handler, params: reader idle time, writer idle time, all idle time
        ph.addLast(new IdleStateHandler(5, 0, 0, TimeUnit.SECONDS));

        // encoder and decoder, these should be same in server and client
        ph.addLast(new ProtobufVarint32FrameDecoder());
        ph.addLast(new ProtobufDecoder(Message.getDefaultInstance()));
        ph.addLast(new ProtobufVarint32LengthFieldPrepender());
        ph.addLast(new ProtobufEncoder());

        // business logic handler
        ph.addLast("nettyServiceHandler", new NettyServerHandler());
    }
}
