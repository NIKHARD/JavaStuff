package com.thread.thread02;

/**
 * ClassName:TerminateThread
 * package:com.thread.thread02
 * Description:
 *
 * @date:2019/2/19 14:43
 * @author: NIK
 */
public class TerminateThread implements Runnable {

    //1.加入标识，标记线程是否可以用
    private boolean flag = true;
    private String name;

    public TerminateThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {

        int i=0;

        //2.关联标识true运行，false停止
        while (flag) {

            System.out.println(name + ": " + i++);

        }

    }

    //3.对外提供方法改变标识
    public void terminate() {

        this.flag = false;

    }

    public static void main(String[] args) {

        TerminateThread terminateThread = new TerminateThread("thread");

        new Thread(terminateThread).start();

        for (int i = 0; i <= 99; i++) {

            if (i == 88) {
                terminateThread.terminate();
                System.out.println("terminateThread gameover");
            }

            System.out.println("main: " + i);

        }

    }

}
