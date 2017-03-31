package com.company;

import com.company.it.belstu.prykhach.*;

public class Main {

    public static void main(String[] args) {

       /* Road road = new Road();
        road.rightlist.add(new Car("1"));
        road.rightlist.add(new Car("2"));
        road.rightlist.add(new Car("3"));
        road.leftlist.add(new Car("1"));
        road.leftlist.add(new Car("2"));
        road.leftlist.add(new Car("3"));
        CarRight carRight = new CarRight(road);
        CarLeft carLeft = new CarLeft(road);
        new Thread(carRight).start();
        new Thread(carLeft).start();*/


        CallCenter callCenter = new CallCenter();
        Client client1 = new Client("Anya", callCenter);
        Client client2 = new Client("Olya", callCenter);
        Client client3 = new Client("Sasha", callCenter);
        Client client4 = new Client("Masha", callCenter);
        Client client5 = new Client("Dasha", callCenter);
        Client client6 = new Client("Kira", callCenter);
        Client client7 = new Client("Nadya", callCenter);

        Thread a = new Thread(client1);
        a.setPriority(Thread.MIN_PRIORITY);
        Thread b = new Thread(client2);
        b.setPriority(Thread.MIN_PRIORITY);
        Thread c = new Thread(client3);
        c.setPriority(Thread.MIN_PRIORITY);
        Thread d = new Thread(client4);
        d.setPriority(Thread.MIN_PRIORITY);
        Thread e = new Thread(client5);
        e.setPriority(Thread.MIN_PRIORITY);
        Thread f = new Thread(client6);
        f.setPriority(Thread.MIN_PRIORITY);
        Thread g = new Thread(client7);
        g.setPriority(Thread.MIN_PRIORITY);
        a.start();
        b.start();
        c.start();
        d.start();
        e.start();
        f.start();
        g.start();


    }
}
