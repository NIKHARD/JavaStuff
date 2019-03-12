package com.thread.thread02;

/**
 * ClassName:YieldThread01
 * package:com.thread.thread02
 * Description:
 *             Yield()礼让线程
 *
 * @date:2019/2/19 15:44
 * @author: NIK
 */
public class YieldThread01 implements Runnable {
    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName()+": start");

        Thread.yield();

        System.out.println(Thread.currentThread().getName()+": end");

    }

    public static void main(String[] args) {

        YieldThread01 yieldThread01 = new YieldThread01();

        new Thread(yieldThread01,"thread").start();
        new Thread(yieldThread01,"zoe").start();

    }
}
