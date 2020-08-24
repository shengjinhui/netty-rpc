package org.sjh.rpc.consumer;

import org.sjh.rpc.api.RpcService;
import org.sjh.rpc.consumer.proxy.RpcProxy;

/**
 * @Author: yichuan
 * @Date: 2020/7/11 5:14 下午
 * @Description:
 */
public class RpcConsumer {
    public static void main(String[] args) {
        RpcService rpcService = RpcProxy.create(RpcService.class);
        System.out.println("result:" + rpcService.helloNetty("Hello Netty!"));
    }
}
