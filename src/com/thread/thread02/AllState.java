package com.thread.thread02;

/**
 * ClassName:AllState
 * package:com.thread.thread02
 * Description:
 *             查看线程的状态
 *
 * @date:2019/2/19 17:46
 * @author: NIK
 */
public class AllState {

    public static void main(String[] args) {

        Thread thread = new Thread(() -> {

            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("--------");
            }

        });

        //NEW
        System.out.println(thread.getState());

        //RUNNABLE
        thread.start();
        System.out.println(thread.getState());

        //TIMED_WAITING || TERMINATED
        while (thread.getState() != Thread.State.TERMINATED) {

            try {
                thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(thread.getState());

        }

        /*while (true) {

            int activeCount = Thread.activeCount();

            System.out.println(activeCount);

            if (activeCount == 2) {

                break;

            }

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(thread.getState());

        }*/

    }

}
