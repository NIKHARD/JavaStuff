package com.thread.thread04;

/**
 * ClassName:Cooperation02
 * package:com.thread.thread04
 * Description:
 *             生产者消费者实现方式2：信号灯法
 *             借助标志位
 *
 * @date:2019/2/23 23:38
 * @author: NIK
 */
public class Cooperation02 {

    public static void main(String[] args) {

        Tv tv = new Tv();

        new Actor(tv).start();
        new Audience(tv).start();

    }

}

//生产者 演员
class Actor extends Thread {

    Tv tv;

    public Actor(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void run() {

        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0) {
                this.tv.play("Ellen Show");
            } else {

                this.tv.play("Friends");

            }
        }

    }
}

//消费者 观众
class Audience extends Thread {

    Tv tv;

    public Audience(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void run() {

        for (int i = 0; i < 20; i++) {
            tv.watch();
        }

    }
}

//同一资源 电视

class Tv {

    String voice;

    //信号灯
    //T表示演员表演 观众等待
    //F表示观众观看 演员等待
    boolean flag = true;

    //表演
    public synchronized void play(String voice) {
        //演员等待
        if (!flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //表演
        System.out.println("said " + voice);
        this.voice = voice;

        //唤醒
        this.notifyAll();

        //切换标志
        this.flag = !this.flag;

    }

    //观看
    public synchronized void watch() {

        //观众等待
        if (flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //观看
        System.out.println("heard " + voice);

        //唤醒
        this.notifyAll();

        //切换标志
        this.flag = !this.flag;

    }

}
