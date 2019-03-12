package com.thread.thread04;

/**
 * ClassName:Cooperation01
 * package:com.thread.thread04
 * Description:
 *             协作模式：生产者消费者实现方式1：管程法
 * @date:2019/2/22 18:14
 * @author: NIK
 */
public class Cooperation01 {

    public static void main(String[] args) {

        SynContainer synContainer = new SynContainer();
        new Productor(synContainer).start();
        new Consumer(synContainer).start();

    }

}

class Productor extends Thread {

    SynContainer synContainer;

    public Productor(SynContainer synContainer) {
        this.synContainer = synContainer;
    }

    @Override
    public void run() {

        for (int i = 0; i < 100; i++) {

            System.out.println("producing " +i+" cars");
            synContainer.push(new Car(i));

        }

    }

}

class Consumer extends Thread {

    SynContainer synContainer;

    public Consumer(SynContainer synContainer) {
        this.synContainer = synContainer;
    }

    @Override
    public void run() {

        for (int i = 0; i < 100; i++) {

            System.out.println("consume "+synContainer.pop().id+" cars");

        }

    }

}

class SynContainer {

    Car[] cars = new Car[10];
    int count = 0;

    public synchronized void push(Car car) {

        if (count == cars.length) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        cars[count] = car;
        count++;

        this.notifyAll();

    }

    public synchronized Car pop() {

        if (count == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        count--;
        Car car = cars[count];

        this.notifyAll();

        return car;

    }

}

class Car {

    int id;

    public Car(int id) {
        this.id = id;
    }

}