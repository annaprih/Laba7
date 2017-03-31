package com.company.it.belstu.prykhach;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Created by Anna on 30.03.2017.
 */
public class CarLeft implements Runnable {
    Road road;

    public CarLeft(Road road) {
        this.road = road;
    }

    @Override
    public void run() {
        while (!(road.leftlist.isEmpty())) {

            try {
                road.driveleft();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

            }
        }


