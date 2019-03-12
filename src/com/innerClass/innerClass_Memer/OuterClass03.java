package com.innerClass.innerClass_Memer;

/**
 * ClassName:OuterClass03
 * package:com.innerClass.innerClass_intro
 * Description:
 *             成员内部类：
 *                  成员内部类也是最普通的内部类，它是外围类的一个成员，
 *                  所以他是可以无限制的访问外围类的所有成员属性和方法，
 *                  尽管是private的，但是外围类要访问内部类的成员属性和方法则需要通过内部类实例来访问。
 *             1.成员内部类中不能存在任何static的变量和方法；
 *             2.成员内部类是依附于外围类的，所以只有先创建了外围类才能够创建内部类；
 * @date:2019/3/2 21:04
 * @author: NIK
 */
public class OuterClass03 {

    private String str;

    public void outDisplay() {
        System.out.println("hanging out....");
    }

    public class InnerClass {

        public void innerDisplay() {

            str = "i'm out";
            System.out.println(str);
            outDisplay();

        }

    }

    //推荐使用getInnerClass()来获取成员内部类，尤其是该内部类的构造方法没有参数时；
    public InnerClass getInnerClass() {

        return new InnerClass();

    }

    public static void main(String[] args) {

        OuterClass03 outerClass03 = new OuterClass03();
        OuterClass03.InnerClass innerClass = outerClass03.getInnerClass();

        innerClass.innerDisplay();

    }

}
