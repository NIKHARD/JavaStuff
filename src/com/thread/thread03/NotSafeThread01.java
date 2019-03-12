package com.thread.thread03;

/**
 * ClassName:NotSafeThread01
 * package:com.thread.thread03
 * Description:
 *             线程不安全：抢票
 *
 * @date:2019/2/20 15:29
 * @author: NIK
 */
public class NotSafeThread01 {

    public static void main(String[] args) {

        //一份资源
        NotSafe12306 notSafe12306 = new NotSafe12306();

        System.out.println(Thread.currentThread().getName());

        //多个代理
        new Thread(notSafe12306, "thread").start();
        new Thread(notSafe12306, "zoe").start();
        new Thread(notSafe12306, "north").start();

    }
}

class NotSafe12306 implements Runnable {

    private int ticketNums = 33;
    private boolean flag = true;

    @Override
    public void run() {

        while (flag) {

            test();

        }

    }

    public void test() {

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