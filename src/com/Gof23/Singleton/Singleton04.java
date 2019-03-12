package com.Gof23.Singleton;

/**
 * ClassName:Singleton04
 * package:com.Gof23.Singleton
 * Description:
 *             单例设计模式(通过双重检测加锁的方法)：
 *                  1.通过这个方法程序在获取对象时无论怎么样都只会进入加锁区一次，
 *                    例如最开始两个线程在竞争时，其中一个线程进入了加锁后创建了对象，
 *                    以后所有的进程在执行getInstance方法时直接判断instance非null，
 *                    就能直接返回对象了，不需要再进入加锁区了。
 *                    这样即使程序频繁地获取对象也不会再进入加锁区了，相对第二种方法就大大节省了资源。
 * @date:2019/3/3 15:48
 * @author: NIK
 */
public class Singleton04 {

    private Singleton04() {
        System.out.println("create a Singleton04");
    }

    private static Singleton04 instance = null;

    public static Singleton04 getInstance() {

        if (instance == null) {

            synchronized (Singleton04.class) {

                if (instance == null) {
                    instance = new Singleton04();
                }

            }

        }

        return instance;

    }

    public static void createString() {

        System.out.println("create A String");

    }

}

class Test04 {

    public static void main(String[] args) {
        Singleton04.createString();
    }

}
