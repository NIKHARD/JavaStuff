package com.thread.thread02;

/**
 * ClassName:BlockedJoin02
 * package:com.thread.thread02
 * Description:
 *
 * @date:2019/2/19 17:06
 * @author: NIK
 */
public class BlockedJoin02 {

    static class Dad extends Thread {

        @Override
        public void run() {

            System.out.println("son fetch a patch of cigarette for me");

            Thread tSon = new Thread(new Son());
            tSon.start();

            try {
                tSon.join();
                System.out.println("okey, that's ur tip");
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("lost my son");
            }

        }

    }

    static class Son extends Thread {

        @Override
        public void run() {

            System.out.println("OK, i'm already on my way");
            System.out.println("oh, i wanna gaming for a second");

            for (int i = 0; i < 10; i++) {

                System.out.println("after " + i + " seconds");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

            System.out.println("get the cigarette to my dad ");

        }

    }

    public static void main(String[] args) {

        System.out.println("go get the cigarette story............");

        new Thread(new Dad()).start();
    }

}
