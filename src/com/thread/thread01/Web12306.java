package com.thread.thread01;

/**
 * ClassName:Web12306
 * package:com.thread.thread01
 * Description:
 *             共享资源，并发线程安全
 * @date:2019/2/19 0:27
 * @author: NIK
 */
public class Web12306 implements Runnable {

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

            System.out.println(Thread.currentThread().getName()+": "+ticketNums);

        }

    }

    public static void main(String[] args) {

        //一份资源
        Web12306 web12306 = new Web12306();

        System.out.println(Thread.currentThread().getName());

        //多个代理
        new Thread(web12306,"thread").start();
        new Thread(web12306,"zoe").start();
        new Thread(web12306,"north").start();

    }

}
