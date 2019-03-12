package com.thread.thread03;

/**
 * ClassName:DeadLock
 * package:com.thread.thread03
 * Description:
 *             过多的同步可能造成相互不释放资源
 *             从而相互等待，一般发生于同步中持有多个对象的锁
 *             解决死锁：不要在同一个代码块中同时持有多个对象锁
 * @date:2019/2/21 1:01
 * @author: NIK
 */
public class DeadLock {

    public static void main(String[] args) {

        Makeup zoe = new Makeup(1, "zoe");
        Makeup north = new Makeup(0, "north");

        zoe.start();
        north.start();

    }

}

class Lipstick {
}

class Mirror {
}

class Makeup extends Thread {

    static Lipstick lipstick = new Lipstick();
    static Mirror mirror = new Mirror();

    int choice;
    String someone;

    public Makeup(int choice, String someone) {
        this.choice = choice;
        this.someone = someone;
    }

    @Override
    public void run() {
        try {
            makeup();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //相互持有对方的对象锁：可能造成死锁
    public void makeup() throws InterruptedException {

        if (choice == 0) {

            synchronized (lipstick) {
                System.out.println(this.someone+" get the lipstick");
                //故意造成时间间隔，容易造成相互不释放资源
                Thread.sleep(1000);

                /*synchronized (mirror) {
                    System.out.println(this.someone+" get the mirror");
                }*/
            }
            synchronized (mirror) {
                System.out.println(this.someone+" get the mirror");
            }

        } else {

            synchronized (mirror) {
                System.out.println(this.someone+" get the mirror");

                Thread.sleep(2000);

                /*synchronized (lipstick) {
                    System.out.println(this.someone+" get the lipstick");
                }*/
            }
            synchronized (lipstick) {
                System.out.println(this.someone+" get the lipstick");
            }

        }

    }

}
