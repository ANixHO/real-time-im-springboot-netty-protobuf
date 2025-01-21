package org.learn.realtimeim.async;

import io.netty.channel.Channel;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ConcurrentHashMap;

/**
 * This class is for mapping the active userId and his channel
 *
 * @author Jayden Choe
 * @version 18/01/2025
 */

@Slf4j
public class UserChannelMap {
    // user and channel mapping, k: userId , v: channel
    private static volatile ConcurrentHashMap<String, Channel> userChannelMap = null;
    // user and channel mapping, k: channel, v: userId
    private static volatile ConcurrentHashMap<Channel, String> channelUserMap = null;

    public UserChannelMap() {
    }

    private static ConcurrentHashMap<Channel, String> getChannelUserMap() {
        return channelUserMap;
    }

    public static ConcurrentHashMap<String, Channel> getUserChannelMap() {
        if (userChannelMap == null) {
            synchronized (UserChannelMap.class) {
                if (userChannelMap == null) {
                    userChannelMap = new ConcurrentHashMap<>();
                    channelUserMap = new ConcurrentHashMap<>();
                }
            }
        }
        return userChannelMap;
    }

    public static Channel getUserChannel(String userId) {
        return getUserChannelMap().get(userId);
    }

    public static void addUserChannel(String userId, Channel channel) {
        getUserChannelMap().put(userId, channel);
        getChannelUserMap().put(channel, userId);
        log.info("Add user and channel mapping to userChannelMap: userId:{} ; channel remote address:{}",
                userId, channel.remoteAddress());
    }

    public static void removeUserChannel(Channel channel) {
        String userId = getChannelUserMap().get(channel);
        String address = channel.remoteAddress().toString();
        if (getChannelUserMap().contains(channel)) {
            getChannelUserMap().remove(channel);
        }
        if (getUserChannelMap().contains(userId)) {
            getUserChannelMap().remove(userId);
        }
        log.info("User is removed from userChannelMap: userId: {} , channel remote address: {} ",
                userId, address);
    }
}

