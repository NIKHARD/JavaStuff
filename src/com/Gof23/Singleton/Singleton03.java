package com.Gof23.Singleton;

/**
 * ClassName:Singleton03
 * package:com.Gof23.Singleton
 * Description:
 *             单例设计模式(利用静态内部类来保护单例)：
 *                  1.这就是现在最完整的单例写法，内部类实现单例，除了effctive java中阐述的枚举单例实现，
 *                    这种方法是目前最好的实现方式。
 *                  2.在这个实现中，用内部类来保护单例，当Singleton类被加载时，内部类不会被初始化，
 *                    所以可以确保Singleton类被载入JVM时，不会初始化单例类，当getInstance方法被调用时，
 *                    才会加载SingleHolder，从而初始化instance，同时，由于实例的建立是在类加载时完成的，
 *                    故天生对多线程友好，getInstance（）方法也不需要使用synchronized修饰，
 *                    因此，这种实现能兼顾前两种写法的优点（延迟加载，非同步）。
 * @date:2019/3/3 15:19
 * @author: NIK
 */
public class Singleton03 {

    private Singleton03() {
        System.out.println("create Singleton03");
    }

    public static class SingletonHolder {

        private static Singleton03 instance = new Singleton03();

    }

    public static Singleton03 getInstance() {

        return SingletonHolder.instance;

    }

    public static void createString() {
        System.out.println("create A String");
    }

}

class test03 {

    public static void main(String[] args) {
        Singleton03.createString();
    }

}
