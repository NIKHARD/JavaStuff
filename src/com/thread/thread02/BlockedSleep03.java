package com.thread.thread02;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ClassName:BlockedSleep03
 * package:com.thread.thread02
 * Description:
 *             利用sleep()实现一个倒计时
 *
 * @date:2019/2/19 15:21
 * @author: NIK
 */
public class BlockedSleep03 {

    public static void main(String[] args) throws InterruptedException {

        Date endDate = new Date(System.currentTimeMillis() + 1000 * 10);
        long endDateTime = endDate.getTime();

        while (true) {

            System.out.println(new SimpleDateFormat("yyyy MM-dd HH:mm:ss").format(endDate));

            Thread.sleep(1000);

            endDate = new Date(endDate.getTime() - 1000);

            if (endDateTime - endDate.getTime() > 10000) {
                break;
            }

        }

    }

}
