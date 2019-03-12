package com.innerClass.innerClass_anonymous;

/**
 * ClassName:AnonymousInnerClass
 * package:com.innerClass.innerClass_anonymous
 * Description:
 *             匿名内部类：
 *                  只要一个类是抽象的或是一个接口，那么其子类中的方法都可以使用匿名内部类来实现
 * @date:2019/3/2 23:44
 * @author: NIK
 */

interface Car {
    public void run();
}

public class AnonymousInnerClass {

    public static void main(String[] args) {

        Car car = new Car(){

            @Override
            public void run() {
                System.out.println("running so fast...");
            }

        };

        car.run();

    }

}
