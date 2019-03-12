package com.innerClass.innerClass_anonymous;

/**
 * ClassName:NoAnonymous
 * package:com.innerClass.innerClass_anonymous
 * Description:
 *             不用匿名内部类实现的方式：
 *                  创建了一个Kido类去继承Person类重写eat()方法
 *                  new 一个Kido类通过多态上转型指向Person类，然后调用重写的方法
 *                  假如此方法只用到一次可以使用匿名内部类简写代码
 * @date:2019/3/2 23:36
 * @author: NIK
 */

abstract class Person {
    public abstract void eat();
}

class Kido extends Person {

    @Override
    public void eat() {
        System.out.println("sucking.....");
    }

}

public class NoAnonymous {

    public static void main(String[] args) {
        Person p = new Kido();
        p.eat();
    }

}
