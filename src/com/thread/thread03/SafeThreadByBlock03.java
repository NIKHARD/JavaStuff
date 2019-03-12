package com.thread.thread03;

/**
 * ClassName:SafeThreadByBlock03
 * package:com.thread.thread03
 * Description:
 *
 * @date:2019/2/20 17:40
 * @author: NIK
 */

public class SafeThreadByBlock03 {

    public static void main(String[] args) {

        //一份资源
        Safe12306Block safe12306 = new Safe12306Block();

        System.out.println(Thread.currentThread().getName());

        //多个代理
        new Thread(safe12306, "thread").start();
        new Thread(safe12306, "zoe").start();
        new Thread(safe12306, "north").start();

    }
}

class Safe12306Block implements Runnable {

    private int ticketNums = 33;
    private boolean flag = true;

    @Override
    public void run() {

        while (flag) {
            //test01();
            //test02();
            //test03();
            //test04();
            test05();
        }

    }

    public synchronized void test01() {

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

    //范围太大性能低下
    public void test02() {

        synchronized (this) {

            if (ticketNums <= 0) {
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

    //线程不安全ticketNums对象一直在变
    public void test03() {

        synchronized ((Integer)ticketNums) {

            if (ticketNums <= 0) {
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

    //范围太小锁不住
    public void test04() {

        synchronized (this) {

            if (ticketNums <= 0) {
                flag = false;
                return;
            }

        }

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + ": " + ticketNums--);

    }

    //尽可能锁定合理的范围（不是指代码，指数据的完整性）
    public void test05() {

        //double checking（双重检测）
        //考虑的是没有票的情况
        if (ticketNums <= 0) {
            flag = false;
            return;
        }

        synchronized (this) {

            //考虑到最后的一张票
            if (ticketNums <= 0) {
                flag = false;
                return;
            }

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + ": " + ticketNums--);

        }

    }

}