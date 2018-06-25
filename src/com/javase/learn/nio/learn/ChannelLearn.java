package com.javase.learn.nio.learn;

import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelLearn {

    /**
     * FileChannel与ByteBuffer
     * 注意：FileChannel这个通道只有阻塞模式，而套接字通道能切换到非阻塞模式
     * @throws IOException
     */
    @Test
    public void fileChannelAndByteBuffer() throws IOException {
        RandomAccessFile file = new RandomAccessFile("/export/Logs/JavaSeLearn/123.txt", "rw");
        //文件通道
        FileChannel fileChannel = file.getChannel();
        //字节缓存分配
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        //内容写入缓存
        int hasRead = fileChannel.read(byteBuffer);

        while(hasRead != -1){
            //翻转缓存，由写模式变为读模式
            byteBuffer.flip();

            //如果缓冲通道里有数据，则读取
            while (byteBuffer.hasRemaining()){
                System.out.println(byteBuffer.get());
            }

            byteBuffer.clear();
            hasRead = fileChannel.read(byteBuffer);
        }

        file.close();
    }

    /**
     * 从一个文件读取内容，写入到另一个文件中
     * @throws IOException
     */
    @Test
    public void fileChannelReadAndWrite() throws IOException {
        //fileChannel获取
        File fileRead = new File("/export/Logs/JavaSeLearn/read.txt");
        FileInputStream fileInputStream = new FileInputStream(fileRead);
        File fileWrite = new File("/export/Logs/JavaSeLearn/write.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(fileWrite);
        FileChannel fileChannelRead = fileInputStream.getChannel();
        FileChannel fileChannelWrite = fileOutputStream.getChannel();

        //read操作
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        int hasRead = fileChannelRead.read(byteBuffer);

        while (hasRead != -1){
            byteBuffer.flip();//翻转Buffer变为写
            while (byteBuffer.hasRemaining()){
                //write操作
                fileChannelWrite.write(byteBuffer);
            }

            byteBuffer.clear();
            hasRead = fileChannelRead.read(byteBuffer);
        }

        fileChannelRead.close();
    }

    @Test
    public void fileChannelTransferForm() throws IOException {
        RandomAccessFile fromFile = new RandomAccessFile("/export/Logs/JavaSeLearn/fromFile.txt","rw");
        FileChannel fromChannel = fromFile.getChannel();

        RandomAccessFile toFile = new RandomAccessFile("/export/Logs/JavaSeLearn/toFile.txt","rw");
        FileChannel toChannel = toFile.getChannel();

        long position = 0;
        long count = fromChannel.size();

        //把fromChannel中的数据写入toChannel中
        toChannel.transferFrom(fromChannel, position, count);
    }
}
