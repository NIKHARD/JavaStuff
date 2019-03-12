package com.Gof23.Singleton;

/**
 * ClassName:Singleton01
 * package:com.Gof23.Singleton
 * Description:
 *             单例设计模式(饿汉式)：
 *                1.单例类必须要有一个private访问级别的构造函数，只有这样，
 *                  才能确保单例不会在系统中的其他代码内被实例化，这点是相当重要的；
 *                  其次，instance成员和getInstance（）方法必须是static的。
 *                2.这种单例的实现方式非常简单，而且十分可靠，它唯一的不足仅是无法对instance实例做延迟加载，
 *                  假如单例的创建过程很慢，而由于instance成员变量是static定义的，因此在JVM加载单例类时，
 *                  单例对象就会被建立，如果此时，这个单例类在系统中还扮演其他角色，
 *                  那么在任何使用这个单例类的地方都会初始化这个单例变量，根本就不会管是否被用到。
 *                  比如单例String工厂，用于创建一些字符串（该类既用于创建单例Singleton，又用于创建String对象）。
 *                运行结果：
 *                      create a Singelton01
 *                      create a String
 *
 *                      Process finished with exit code 0
 *                3.假如单例类里面有getInstance以外的其它静态方法，跟单例没啥关系的方法，
 *                  如果使用了Singleton.CreateString（）这种调用，就会自动创建Singleton这个类实例
 *                 （虽然private构造已经防止了你人为去new这个单例），这是开发人员不愿看到的，
 *                  我运行下面代码（此代码调用了上面代码的createString（）方法）
 * @date:2019/3/3 14:38
 * @author: NIK
 */
public class Singleton01 {

    private Singleton01() {
        System.out.println("create a Singelton01");
    }

    private static Singleton01 instance = new Singleton01();

    public static Singleton01 getInstance() {

        return instance;

    }

    public static void createString() {

        System.out.println("create a String");

    }

}

class Test01 {

    public static void main(String[] args) {
        Singleton01.createString();
    }

}


