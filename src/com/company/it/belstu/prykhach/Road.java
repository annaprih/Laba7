package com.company.it.belstu.prykhach;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Created by Anna on 25.03.2017.
 */
public class Road {

    public boolean rightOrLeft = false;
    public Semaphore semaphore = new Semaphore(1, true);
    public ArrayList<Car> leftlist = new ArrayList<Car>();
    public ArrayList<Car> rightlist = new ArrayList<Car>();


    public synchronized boolean driveleft() throws InterruptedException {
        if (rightOrLeft == false) {
            try {
                wait();
                if (semaphore.tryAcquire(1000, TimeUnit.MILLISECONDS)) {
                    System.out.println("Машина " + leftlist.get(0).name + " слева не успела проехать");
                    leftlist.remove(0);

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Машина " + this.leftlist.get(0).name + " слева поехала");
        try {

            Thread.sleep(1000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Машина " + this.leftlist.get(0).name + " слева проехала");
        this.leftlist.remove(0);
        rightOrLeft = false;
        notify();
        return true;

    }

    public synchronized boolean driveright()

    {

        if (rightOrLeft == true) {
            try {
                wait();
                if (!(semaphore.tryAcquire(1000, TimeUnit.MILLISECONDS))) {
                    System.out.println("Машина " + rightlist.get(0).name + " слева не успела проехать");
                    rightlist.remove(0);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Машина " + this.rightlist.get(0).name + " справа поехала");
        try {

            Thread.sleep(1000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Машина " + this.rightlist.get(0).name + " справа проехала");
        this.rightlist.remove(0);
        rightOrLeft = true;
        notify();

        return true;
    }
}



