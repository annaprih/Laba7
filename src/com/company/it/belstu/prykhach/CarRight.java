package com.company.it.belstu.prykhach;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Created by Anna on 25.03.2017.
 */
public class CarRight implements Runnable {
    Road road;

    public CarRight(Road road) {
        this.road = road;
    }

    @Override
    public void run() {
        while (!(road.rightlist.isEmpty())) {

            road.driveright();
        }

    }
}
