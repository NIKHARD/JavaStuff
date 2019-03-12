package com.thread.thread02;

/**
 * ClassName:PriorityTest
 * package:com.thread.thread02
 * Description:
 *             线程的优先级
 *             1.NORM_PRIORITY 5
 *             2.MIN_PRIORITY 1
 *             3.MAX_PRIORITY 10
 *             优先级高的，优先执行的概率会高些
 *
 * @date:2019/2/19 18:40
 * @author: NIK
 */
public class PriorityTest {

    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getName() + ": " + Thread.currentThread().getPriority());

        MyPriority mp = new MyPriority();
        Thread t1 = new Thread(mp);
        Thread t2 = new Thread(mp);
        Thread t3 = new Thread(mp);
        Thread t4 = new Thread(mp);
        Thread t5 = new Thread(mp);
        Thread t6 = new Thread(mp);

        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);
        t3.setPriority(Thread.MAX_PRIORITY);
        t4.setPriority(Thread.MIN_PRIORITY);
        t5.setPriority(Thread.MIN_PRIORITY);
        t6.setPriority(Thread.MIN_PRIORITY);


        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
    }

}

class MyPriority implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": " + Thread.currentThread().getPriority());
    }
}
