package com.thread.thread03;

import java.util.ArrayList;

/**
 * ClassName:NotSafeThread03
 * package:com.thread.thread03
 * Description:
 *             线程不安全：容器
 *
 * @date:2019/2/20 16:25
 * @author: NIK
 */
public class NotSafeThread03 {

    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i <= 10000; i++) {

            new Thread(()->{

                list.add(Thread.currentThread().getName());

            }).start();

        }

        System.out.println(list.size());

    }

}
