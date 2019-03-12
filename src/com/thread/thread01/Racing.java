package com.thread.thread01;

/**
 * ClassName:Racing
 * package:com.thread.thread01
 * Description:
 *
 * @date:2019/2/19 0:45
 * @author: NIK
 */
public class Racing implements Runnable {

    private static String winner;

    @Override
    public void run() {

        for (int steps = 1; steps <= 100; steps++) {

            if (Thread.currentThread().getName().equals("rabbit") && steps % 10 == 0) {

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

            System.out.println(Thread.currentThread().getName()+": "+steps);

            boolean flag = gameOver(steps);

            if (flag) {
                break;
            }

        }

    }

    public boolean gameOver(int steps) {

        if (winner != null) {

            return true;

        } else {

            if (steps == 100) {

                winner = Thread.currentThread().getName();
                System.out.println("winner: "+winner);

                return true;

            }

        }

        return false;

    }

    public static void main(String[] args) {

        Racing racing = new Racing();

        new Thread(racing,"tortoise").start();
        new Thread(racing,"rabbit").start();

    }

}
