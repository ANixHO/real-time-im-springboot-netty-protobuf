package org.learn.realtimeim.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.InetSocketAddress;

/**
 * This class is for netty server
 *
 * @author choejeongho
 * @version 07/01/2025
 */

@Component
@Slf4j
public class NettyServer {
    /**
     * boss accepts incoming connection and registers accepted connection to the worker
     */
    private EventLoopGroup boss = new NioEventLoopGroup();

    /**
     * work handles the accepted traffic
     */
    private EventLoopGroup work = new NioEventLoopGroup();

    /**
     * channel future
     */
    private ChannelFuture channelFuture;

    @Value("${netty.port}")
    private Integer nettyPort;

    @PostConstruct
    public void start() throws InterruptedException {
        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(boss, work)
                .channel(NioServerSocketChannel.class)
                .localAddress(new InetSocketAddress(nettyPort))
//                .option(ChannelOption.SO_BACKLOG, 1024)
//                .childOption(ChannelOption.SO_KEEPALIVE, true)
//                .childOption(ChannelOption.TCP_NODELAY, true)
                // when NioServerSocketChannel processes traffic, logging handler will logging the info
//                .handler(new LoggingHandler(LogLevel.INFO))
                .childHandler(new NettyServerHandlerInitializer());

        channelFuture = bootstrap.bind().sync();
        if (channelFuture.isSuccess()) {
            log.info("Netty server started!");
        }

    }

    @PreDestroy
    public void destroy() throws InterruptedException {
        channelFuture.channel().closeFuture().sync();
        work.shutdownGracefully().sync();
        boss.shutdownGracefully().sync();
        log.info("Netty server stopped!");
    }

}
