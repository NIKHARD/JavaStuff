package com.thread.thread03;

import java.util.ArrayList;

/**
 * ClassName:SafeThreadByBlock02
 * package:com.thread.thread03
 * Description:
 *
 * @date:2019/2/20 17:31
 * @author: NIK
 */

public class SafeThreadByBlock02 {

    public static void main(String[] args) throws InterruptedException {

        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {

            new Thread(()->{

                synchronized (list) {
                    list.add(Thread.currentThread().getName());
                }

            }).start();

        }

        Thread.sleep(10000);

        System.out.println(list.size());

    }

}