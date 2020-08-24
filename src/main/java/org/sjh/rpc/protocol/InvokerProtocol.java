package org.sjh.rpc.protocol;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: yichuan
 * @Date: 2020/7/13 3:53 下午
 * @Description: 自定义传输协议
 */
@Data
public class InvokerProtocol implements Serializable {
    /**
     * 类名
     */
    private String className;

    /**
     * 函数名称
     */
    private String methodName;

    /**
     * 参数类型
     */
    private Class<?>[] params;

    /**
     * 参数列表
     */
    private Object[] values;
}
