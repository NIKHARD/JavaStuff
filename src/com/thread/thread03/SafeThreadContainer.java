package com.thread.thread03;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * ClassName:SafeThreadContainer
 * package:com.thread.thread03
 * Description:
 *
 * @date:2019/2/21 0:28
 * @author: NIK
 */
public class SafeThreadContainer {

    public static void main(String[] args) throws InterruptedException {

        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<String>();

        for (int i = 0; i < 10000; i++) {

            new Thread(()->{

                list.add(Thread.currentThread().getName());

            }).start();

        }

        Thread.sleep(10000);
        System.out.println(list.size());

    }

}