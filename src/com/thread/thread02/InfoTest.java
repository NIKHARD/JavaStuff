package com.thread.thread02;

/**
 * ClassName:InfoTest
 * package:com.thread.thread02
 * Description:
 *
 * @date:2019/2/20 15:05
 * @author: NIK
 */
public class InfoTest {

    public static void main(String[] args) throws InterruptedException {

        MyInfo myInfo = new MyInfo("thread");

        Thread thread = new Thread(myInfo);

        thread.setName("zoe");
        thread.start();
        thread.sleep(2000);
        System.out.println(thread.isAlive());

    }

}

class MyInfo implements Runnable {

    private String name;

    public MyInfo(String name) {
        this.name = name;
    }

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() + ": " + name);

    }
}
