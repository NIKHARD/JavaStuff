package com.thread.thread02;

/**
 * ClassName:BlockedSleep01
 * package:com.thread.thread02
 * Description:
 *             Sleep()模拟网络延迟发现问题
 *
 * @date:2019/2/19 15:59
 * @author: NIK
 */
public class BlockedSleep01 implements Runnable {

    private int ticketNums = 33;

    @Override
    public void run() {

        while (true) {

            ticketNums--;

            if (ticketNums < 0) {
                break;
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + ": " + ticketNums);

        }

    }

    public static void main(String[] args) {

        //一份资源
        com.thread.thread01.Web12306 web12306 = new com.thread.thread01.Web12306();

        System.out.println(Thread.currentThread().getName());

        //多个代理
        new Thread(web12306, "thread").start();
        new Thread(web12306, "zoe").start();
        new Thread(web12306, "north").start();

    }

}