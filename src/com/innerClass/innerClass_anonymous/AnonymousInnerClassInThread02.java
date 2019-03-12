package com.innerClass.innerClass_anonymous;

/**
 * ClassName:AnonymousInnerClassInThread02
 * package:com.innerClass.innerClass_anonymous
 * Description:
 *             匿名内部类在多线程中的实现02
 * @date:2019/3/2 23:56
 * @author: NIK
 */
public class AnonymousInnerClassInThread02 {

    public static void main(String[] args) {

        Runnable runnable = new Runnable(){

            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println(Thread.currentThread().getName() + " " + i);
                }
            }

        };

        Thread thread = new Thread(runnable);
        thread.start();

    }

}
