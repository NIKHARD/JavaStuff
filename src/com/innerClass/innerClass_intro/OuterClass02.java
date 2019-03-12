package com.innerClass.innerClass_intro;

/**
 * ClassName:OuterClass02
 * package:com.innerClass.innerClass_intro
 * Description:
 *             1.如果我们需要生成对外部类对象的引用，可以使用OuterClassName.this，
 *             这样就能够产生一个正确引用外部类的引用了。当然这点是在编译期就知晓了，没有任何运行时的成本。
 *             2.对于一个名为OuterClass的外围类和一个名为InnerClass的内部类，
 *             在编译成功后，会出现这样两个class文件：OuterClass.class和OuterClass$InnerClass.class。
 * @date:2019/3/2 20:36
 * @author: NIK
 */
public class OuterClass02 {

    public void display() {
        System.out.println("hi there");
    }

    public class InnerClass {

        public OuterClass02 getOutClass() {
            return OuterClass02.this;
        }

    }

    public static void main(String[] args) {

        OuterClass02 outerClass02 = new OuterClass02();
        OuterClass02.InnerClass innerClass = outerClass02.new InnerClass();

        innerClass.getOutClass().display();

    }

}
