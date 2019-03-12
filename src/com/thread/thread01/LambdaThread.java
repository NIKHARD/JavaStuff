package com.thread.thread01;

/**
 * ClassName:LambdaThread
 * package:com.thread.thread01
 * Description:
 *             JDK8 Lambda表达式对新建线程的简化
 *
 * @date:2019/2/19 13:56
 * @author: NIK
 */
public class LambdaThread {

    //静态内部类
    /*static class Test implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName()+": singing");
            }
        }
    }*/

    public static void main(String[] args) {

        //局部内部类
        /*class Test implements Runnable {

            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println(Thread.currentThread().getName()+": singing");
                }
            }
        }

        new Thread(new Test()).start();*/

        //匿名内部类，必须借助接口或者父类
        /*new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println(Thread.currentThread().getName()+": singing");
                }
            }
        }).start();*/

        //JDK8简化 lambda表达式
        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName()+" singing");
            }
        }).start();


    }
}
