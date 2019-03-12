package com.thread.thread03;

/**
 * ClassName:TicketsThread
 * package:com.thread.thread03
 * Description:
 *
 * @date:2019/2/20 18:55
 * @author: NIK
 */
public class TicketsThread {

    public static void main(String[] args) {

        Cinema wanda = new Cinema(2, "wanda");
        new Thread(new Customer(wanda,2),"thread").start();
        new Thread(new Customer(wanda,1),"west").start();

    }

}

class Customer implements Runnable {

    Cinema cinema;
    int totalSeats;

    public Customer(Cinema cinema, int totalSeats) {
        this.cinema = cinema;
        this.totalSeats = totalSeats;
    }

    @Override
    public void run() {

        synchronized (cinema) {
            boolean flag = cinema.bookTickets(totalSeats);

            if (flag) {
                System.out.println(Thread.currentThread().getName() + " you got " + totalSeats + " seats");
            } else {
                System.out.println(Thread.currentThread().getName() + " there's no available " + totalSeats + " seats for u");
            }
        }

    }
}

class Cinema {

    int availableSeats;
    String name;

    public Cinema(int availableSeats, String name) {
        this.availableSeats = availableSeats;
        this.name = name;
    }

    public boolean bookTickets(int totalseats) {

        System.out.println("the availableSeats is " + availableSeats);
        if (availableSeats < totalseats) {
            return false;
        }

        availableSeats -= totalseats;
        return true;

    }
}
