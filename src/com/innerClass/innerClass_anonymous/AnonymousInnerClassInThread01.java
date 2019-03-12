package com.innerClass.innerClass_anonymous;

/**
 * ClassName:AnonymousInnerClassInThread01
 * package:com.innerClass.innerClass_anonymous
 * Description:
 *             匿名内部类在实现线程时候的应用01
 * @date:2019/3/2 23:52
 * @author: NIK
 */
public class AnonymousInnerClassInThread01 {

    public static void main(String[] args) {

        Thread thread = new Thread(){

            public void run() {

                for(int i=0; i<5; i++){
                    System.out.println(Thread.currentThread().getName() + " " + i);
                }

            }

        };

        thread.start();

    }

}
