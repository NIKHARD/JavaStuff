package com.thread.thread03;

import java.util.*;

/**
 * ClassName:TicketsThread2
 * package:com.thread.thread03
 * Description:
 *
 * @date:2019/2/20 20:11
 * @author: NIK
 */

public class TicketsThread2 {

    public static void main(String[] args) {

        List<Integer> available = new ArrayList<Integer>();
        available.add(1);
        available.add(2);
        available.add(3);
        available.add(5);
        available.add(6);

        List<Integer> seat1 = new ArrayList<Integer>();
        seat1.add(1);
        seat1.add(2);
        seat1.add(3);

        List<Integer> seat2 = new ArrayList<Integer>();
        seat2.add(5);
        seat2.add(7);

        Cinema2 wanda = new Cinema2(available, "wanda");
        new Thread(new Customer2(wanda,seat1),"thread").start();
        new Thread(new Customer2(wanda,seat2),"west").start();

    }

}

class Customer2 implements Runnable {

    Cinema2 cinema;
    List<Integer> seatLo;

    public Customer2(Cinema2 cinema, List<Integer> seatLo) {
        this.cinema = cinema;
        this.seatLo = seatLo;
    }

    @Override
    public void run() {

        synchronized (cinema) {
            boolean flag = cinema.bookTickets(seatLo);

            if (flag) {
                System.out.println(Thread.currentThread().getName() + " you got " + seatLo + " seats");
            } else {
                System.out.println(Thread.currentThread().getName() + " there's no available " + seatLo + " seats for u");
            }
        }

    }
}

class Cinema2 {

    List<Integer> availableSeats;
    String name;

    public Cinema2(List<Integer> availableSeats, String name) {
        this.availableSeats = availableSeats;
        this.name = name;
    }

    public boolean bookTickets(List<Integer> seatLo) {

        System.out.println("the availableSeats is " + availableSeats);

        List<Integer> copy = new ArrayList<Integer>();
        copy.addAll(availableSeats);

        copy.removeAll(seatLo);

        if (availableSeats.size() - copy.size() != seatLo.size()) {
            return false;
        }

        availableSeats = copy;
        return true;

    }
}