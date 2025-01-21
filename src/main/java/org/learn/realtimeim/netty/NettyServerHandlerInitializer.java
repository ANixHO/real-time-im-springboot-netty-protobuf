package org.learn.realtimeim.netty;

import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageOrBuilder;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.MessageToMessageDecoder;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.stream.ChunkedWriteHandler;
import io.netty.handler.timeout.IdleStateHandler;
import lombok.extern.slf4j.Slf4j;
import org.learn.realtimeim.protocol.message.Message;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static io.netty.buffer.Unpooled.wrappedBuffer;

/**
 * This class is for specific implementation for netty server
 *
 * @author Jayden Choe
 * @version 08/01/2025
 */
@Slf4j
public class NettyServerHandlerInitializer  extends ChannelInitializer<SocketChannel> {

    protected void initChannel(SocketChannel socketChannel) throws Exception{
        ChannelPipeline ph = socketChannel.pipeline();

        // idle handler, params: reader idle time, writer idle time, all idle time
        ph.addLast(new IdleStateHandler(10, 0, 0, TimeUnit.SECONDS));

        ph.addLast(new HttpServerCodec());
        ph.addLast(new ChunkedWriteHandler());
        ph.addLast(new HttpObjectAggregator(65536));
        ph.addLast(new WebSocketServerProtocolHandler("/ws", null, true,65536, false, true));
        ph.addLast(new MessageToMessageDecoder<WebSocketFrame>() {
            @Override
            protected void decode(ChannelHandlerContext channelHandlerContext, WebSocketFrame frame, List<Object> list) throws Exception {
                log.info("Get websocketframe: {}", frame.content().toString()  );
                ByteBuf buf = ((BinaryWebSocketFrame) frame).content();
                list.add(buf);
                buf.retain();
            }
        });
        ph.addLast(new MessageToMessageEncoder<MessageOrBuilder>() {

            @Override
            protected void encode(ChannelHandlerContext channelHandlerContext, MessageOrBuilder messageOrBuilder, List<Object> list) throws Exception {
                ByteBuf result = null;
                if (messageOrBuilder instanceof MessageLite msg){
                    result = wrappedBuffer(msg.toByteArray());
                }

                if (messageOrBuilder instanceof MessageLite.Builder msg){
                    result = wrappedBuffer(msg.build().toByteArray());
                }

                WebSocketFrame frame = new BinaryWebSocketFrame(result);
                list.add(frame);
            }
        });
        // encoder and decoder, these should be same in server and client
//        ph.addLast(new ProtobufVarint32FrameDecoder());
        ph.addLast(new ProtobufDecoder(Message.getDefaultInstance()));
//        ph.addLast(new ProtobufVarint32LengthFieldPrepender());
//        ph.addLast(new ProtobufEncoder());
//        ph.addLast(new StringEncoder());
//        ph.addLast(new StringDecoder());

        // business logic handler
        ph.addLast("nettyServiceHandler", new NettyServerHandler());
//        ph.addLast(new WebSocketHandler());
    }
}
