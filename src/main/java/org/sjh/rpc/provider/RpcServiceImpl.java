package org.sjh.rpc.provider;

import org.sjh.rpc.api.RpcService;

/**
 * @Author: yichuan
 * @Date: 2020/7/10 3:56 下午
 * @Description:
 */
public class RpcServiceImpl implements RpcService {

    @Override
    public String helloNetty(String msg) {
        return msg;
    }
}
