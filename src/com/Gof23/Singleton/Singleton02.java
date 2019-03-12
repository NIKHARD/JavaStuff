package com.Gof23.Singleton;

/**
 * ClassName:Singleton02
 * package:com.Gof23.Singleton
 * Description:
 *             单例模式(懒汉式在饿汉式的基础上实现延迟加载)：
 *                  1.这次改良主要是从JVM加载类的原理上进行改良的，
 *                    上面的代码在初始化类的时候给instance赋予null,确保系统启动的时候没有额外的负载，
 *                    其次，在getInstance方法中加入判断单例是否存在，不存在才new。
 *                  2.但是getInstance()方法必须是同步的，否则多线程环境下，可能线程1正在创建单例时，
 *                    线程2判断单例instance为空，就会创建多个实例。
 *                    但是上面的写法，存在性能问题，在多线程下，它的耗时远远大于第一种单例。
 * @date:2019/3/3 14:56
 * @author: NIK
 */
public class Singleton02 {

    private Singleton02() {
        System.out.println("create a Singleton02");
    }

    private static Singleton02 instance = null;

    public static synchronized Singleton02 getInstance() {

        if (instance == null) {
            instance = new Singleton02();
        }
        return instance;

    }

    public static void createString() {
        System.out.println("create A String");
    }

}

class Test02 {

    public static void main(String[] args) {
        Singleton02.createString();
    }

}
