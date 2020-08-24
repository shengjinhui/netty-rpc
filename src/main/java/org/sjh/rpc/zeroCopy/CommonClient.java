package org.sjh.rpc.zeroCopy;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.Socket;


public class CommonClient {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket(ZeroCopyConstant.host, ZeroCopyConstant.port);

        InputStream inputStream = new FileInputStream(ZeroCopyConstant.fileAddress);

        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

        byte[] buffer = new byte[4096];
        long readCount;
        long total = 0;

        long startTime = System.currentTimeMillis();

        while ((readCount = inputStream.read(buffer)) >= 0) {
            total += readCount;
            dataOutputStream.write(buffer);
        }

        System.out.println("[simple loop] total byte: " + total + ", time cost: " + (System.currentTimeMillis() - startTime));

        dataOutputStream.close();
        socket.close();
        inputStream.close();
    }
}
