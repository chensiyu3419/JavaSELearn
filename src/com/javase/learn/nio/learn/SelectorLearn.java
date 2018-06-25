package com.javase.learn.nio.learn;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class SelectorLearn {

    public void selectorCreate() throws IOException {
        //选择器的创建
        Selector selector = Selector.open();
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("http://www.baidu.com", 80));

        socketChannel.configureBlocking(false);
        socketChannel.register(selector, SelectionKey.OP_READ);
        while (true){
            int readyChannels = selector.select();
            if(readyChannels == 0){
                continue;
            }
            Set selectedKeys = selector.selectedKeys();
            Iterator keysIterator = selectedKeys.iterator();
            while (keysIterator.hasNext()){
                SelectionKey selectionKey = (SelectionKey) keysIterator.next();
                if (selectionKey.isAcceptable()){

                } else if(selectionKey.isConnectable()){

                } else if(selectionKey.isReadable()){

                } else if(selectionKey.isWritable()){

                }

                keysIterator.remove();
            }
        }
    }
}
