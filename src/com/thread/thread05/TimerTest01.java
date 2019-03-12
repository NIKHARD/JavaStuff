package com.thread.thread05;

import java.util.*;

/**
 * ClassName:TimerTest01
 * package:com.thread.thread05
 * Description:
 *             定时调度：Timer和TimerTask类
 * @date:2019/2/24 0:28
 * @author: NIK
 */
public class TimerTest01 {

    public static void main(String[] args) {

        Timer timer = new Timer();

        //执行任务一次
        //timer.schedule(new TheTask(),3000);

        //执行多次
        //timer.schedule(new TheTask(), 1000, 200);

        Calendar cal = new GregorianCalendar(2019,2,25,3,33,33);

        //5秒开始
        timer.schedule(new TheTask(), cal.getTime(), 2000);

    }

}

class TheTask extends TimerTask {

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {

            System.out.println("take a break");

        }

    }
}