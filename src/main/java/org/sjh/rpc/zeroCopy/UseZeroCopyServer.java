package org.sjh.rpc.zeroCopy;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;


public class UseZeroCopyServer {
    public static void main(String[] args) throws Exception {
        InetSocketAddress address = new InetSocketAddress(ZeroCopyConstant.port);

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        ServerSocket serverSocket = serverSocketChannel.socket();
        serverSocket.setReuseAddress(true);
        serverSocket.bind(address);

        ByteBuffer byteBuffer = ByteBuffer.allocate(4096);

        while (true) {
            SocketChannel socketChannel = serverSocketChannel.accept();
            // 返回来的socket channel默认就是阻塞的，
            // 如果要注册到selector上，必须设置成非阻塞的
            socketChannel.configureBlocking(true);

            int readCount = 0;

            while (-1 != readCount) {
                try {
                    readCount = socketChannel.read(byteBuffer);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                byteBuffer.rewind();//重新读
            }

        }
    }
}
