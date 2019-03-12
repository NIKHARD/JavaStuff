package com.thread.thread01;

/**
 * ClassName:StartThread1
 * package:com.thread.thread01
 * Description:
 *             创建线程方式1:
 *             1.创建：继承Thread类+重写run
 *             2.启动：创建实现类对象然后调用start()方法
 * @date:2019/2/18 22:29
 * @author: NIK
 */
public class StartThread1 extends Thread {

    @Override
    public void run() {

        for (int i = 0; i < 5; i++) {

            System.out.println(Thread.currentThread().getName()+" :singing");

        }

    }

    public static void main(String[] args) {

        StartThread1 startThread = new StartThread1();

        //开启一个新的线程，不保证立即运行由cpu调用
        startThread.start();

        //仍然是旧线程
        //startThread.run();

        for (int i = 0; i < 5; i++) {

            System.out.println(Thread.currentThread().getName()+" :coding");

        }

    }
}
