package com.thread.thread03;

/**
 * ClassName:Tickets12306
 * package:com.thread.thread03
 * Description:
 *
 * @date:2019/2/20 23:58
 * @author: NIK
 */

public class Tickets12306 {

    public static void main(String[] args) {

        Web12306 c = new Web12306(4, "LA");

        new Passenger(c, "thread", 2).start();
        new Passenger(c, "zoe", 3).start();

    }

}

class Passenger extends Thread {

    int totalSeats;

    public Passenger(Runnable target, String name, int totalSeats) {
        super(target, name);
        this.totalSeats = totalSeats;
    }

}

class Web12306 implements Runnable {

    int availableSeats;
    String name;

    public Web12306(int availableSeats, String name) {
        this.availableSeats = availableSeats;
        this.name = name;
    }

    @Override
    public void run() {

        Passenger p = (Passenger) Thread.currentThread();
        boolean flag = this.bookTickets(p.totalSeats);

        if (flag) {
            System.out.println(Thread.currentThread().getName() + " you got " + p.totalSeats + " seats");
        } else {
            System.out.println(Thread.currentThread().getName() + " there's no available " + p.totalSeats + " seats for u");
        }

    }

    public synchronized boolean bookTickets(int totalseats) {

        System.out.println("the availableSeats is " + availableSeats);
        if (availableSeats < totalseats) {
            return false;
        }

        availableSeats -= totalseats;
        return true;

    }

}