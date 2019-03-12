package com.thread.thread02;

/**
 * ClassName:YieldThread02
 * package:com.thread.thread02
 * Description:
 *
 * @date:2019/2/19 15:49
 * @author: NIK
 */
public class YieldThread02 {

    public static void main(String[] args) {

        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                System.out.println("lambda: " + i);
            }
        }).start();

        for (int i = 0; i < 100; i++) {

            if (i % 20 == 0) {
                Thread.yield();
            }
            System.out.println("main: "+i);

        }

    }

}
