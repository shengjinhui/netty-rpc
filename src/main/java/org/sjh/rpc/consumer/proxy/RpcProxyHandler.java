package org.sjh.rpc.consumer.proxy;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.Getter;

/**
 * @Author: yichuan
 * @Date: 2020/7/13 4:45 下午
 * @Description: 接收网络调用的返回值
 */
public class RpcProxyHandler extends ChannelInboundHandlerAdapter {

    @Getter
    private Object response;


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("RpcProxyHandler" + msg);
        response = msg;
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("client exception is general");
    }

}
