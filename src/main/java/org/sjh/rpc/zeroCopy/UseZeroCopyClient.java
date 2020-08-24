package org.sjh.rpc.zeroCopy;

import java.io.FileInputStream;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;


public class UseZeroCopyClient {
    /**
     * 实现简单的上传
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress(ZeroCopyConstant.host, ZeroCopyConstant.port));
        // 这里设置为阻塞,方便一次性读取完
        socketChannel.configureBlocking(true);

        // 从本地读取文件
        FileChannel fileChannel = new FileInputStream(ZeroCopyConstant.fileAddress).getChannel();
        long startTime = System.currentTimeMillis();
        long transferCount = fileChannel.transferTo(0, fileChannel.size(), socketChannel);
        System.out.println("[use zero copy] total byte:" + transferCount + ", time cost: " + (System.currentTimeMillis() - startTime));
        fileChannel.close();
    }
}
