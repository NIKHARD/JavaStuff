package com.thread.thread03;

/**
 * ClassName:SafeThread01
 * package:com.thread.thread03
 * Description:
 *             线程安全：抢票
 *             在并发时保证数据的安全性，效率尽可能高
 *             synchronized
 *             1.同步方法
 *             2.同步块
 * @date:2019/2/20 16:46
 * @author: NIK
 */
public class SafeThread01 {

    public static void main(String[] args) {

        //一份资源
        Safe12306 safe12306 = new Safe12306();

        System.out.println(Thread.currentThread().getName());

        //多个代理
        new Thread(safe12306, "thread").start();
        new Thread(safe12306, "zoe").start();
        new Thread(safe12306, "north").start();

    }
}

class Safe12306 implements Runnable {

    private int ticketNums = 33;
    private boolean flag = true;

    @Override
    public void run() {

        while (flag) {
            test();
        }

    }

    public synchronized void test() {

        if (ticketNums < 0) {
            flag = false;
            return;
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + ": " + ticketNums--);

    }

}
