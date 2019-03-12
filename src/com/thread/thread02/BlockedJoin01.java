package com.thread.thread02;

/**
 * ClassName:BlockedJoin01
 * package:com.thread.thread02
 * Description:
 *             join()插队
 *
 * @date:2019/2/19 16:04
 * @author: NIK
 */
public class BlockedJoin01 {

    public static void main(String[] args) throws InterruptedException {

        Thread thread =new Thread(()->{

            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName()+": " + i);
            }

        });

        thread.start();

        for (int i = 0; i < 100; i++) {

            if (i == 20) {
                thread.join();
            }

            System.out.println(Thread.currentThread().getName()+": "+i);

        }

    }

}
