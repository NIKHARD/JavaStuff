package com.thread.thread01;

/**
 * ClassName:StartThread2
 * package:com.thread.thread01
 * Description:
 *             创建线程方式2:
 *             1.创建：实现Runnable接口+重写run
 *             2.启动：创建实现类对象，创建Thread对象，然后调用start()方法
 *             推件使用，因为可以避免单继承的局限性，方便共享资源
 * @date:2019/2/19 0:03
 * @author: NIK
 */
public class StartThread2 implements Runnable {

    @Override
    public void run() {

        for (int i = 0; i < 5; i++) {

            System.out.println(Thread.currentThread().getName()+" :sing");

        }

    }

    public static void main(String[] args) {

        //创建实现类对象
        //StartThread2 startThread2 = new StartThread2();

        //创建代理类对象
        //Thread thread01 = new Thread(startThread2);

        new Thread(new StartThread2()).start();

        //thread01.start();

        for (int i = 0; i < 5; i++) {

            System.out.println(Thread.currentThread().getName()+ ":coding");

        }

    }

}
