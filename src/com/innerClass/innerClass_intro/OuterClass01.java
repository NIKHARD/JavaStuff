package com.innerClass.innerClass_intro;

/**
 * ClassName:OuterClass01
 * package:com.innerClass.innerClass_intro
 * Description:
 *              InnerClass：
 *                  引用内部类我们需要指明这个对象的类型：OuterClasName.InnerClassName。
 *                  同时如果我们需要创建某个内部类对象，必须要利用外部类的对象通过.new来创建内部类：
 *                  OuterClass.InnerClass innerClass = outerClass.new InnerClass();
 *
 *              1、内部类可以用多个实例，每个实例都有自己的状态信息，并且与其他外围对象的信息相互独立。
 *              2、在单个外围类中，可以让多个内部类以不同的方式实现同一个接口，或者继承同一个类。
 *              3、创建内部类对象的时刻并不依赖于外围类对象的创建。
 *              4、内部类并没有令人迷惑的“is-a”关系，他就是一个独立的实体。
 *              5、内部类提供了更好的封装，除了该外围类，其他类都不能访问。
 * @date:2019/3/2 20:25
 * @author: NIK
 */
public class OuterClass01 {

    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public class InnerClass {

        public InnerClass() {

            name = "nik";
            age = 25;

        }

        public void display() {

            System.out.println("name: " + getName() + " age: " + getAge());

        }

    }

    public static void main(String[] args) {

        OuterClass01 outerClass01 = new OuterClass01();
        OuterClass01.InnerClass innerClass = outerClass01.new InnerClass();

        innerClass.display();

    }

}
