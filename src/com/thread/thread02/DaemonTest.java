package com.thread.thread02;

/**
 * ClassName:DaemonTest
 * package:com.thread.thread02
 * Description:
 *             守护线程：是为用户线程服务的；jvm停止不用等待守护线程停止
 *             默认：用户线程；jvm等待用户线程执行完毕才会停止
 * @date:2019/2/20 14:44
 * @author: NIK
 */
public class DaemonTest {

    public static void main(String[] args) {

        God god = new God();
        Human human = new Human();

        Thread t1 = new Thread(god);
        Thread t2 = new Thread(human);

        //将用户线程设置为守护线程
        t1.setDaemon(true);
        t1.start();
        t2.start();

    }

}

class God implements Runnable {

    @Override
    public void run() {
        while (true) {
            System.out.println("bless you");
        }
    }
}

class Human implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i <= 365; i++) {

            System.out.println("have a gorgeous life");

        }
        System.out.println("sleeping.....");
    }
}
