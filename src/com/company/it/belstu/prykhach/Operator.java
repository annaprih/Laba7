package com.company.it.belstu.prykhach;

/**
 * Created by Anna on 31.03.2017.
 */
public class Operator {
    public String ID;

    public Operator(String ID) {
        this.ID = ID;
    }
public void talking()
{
    System.out.println("Оператор " + this.ID + " разговаривает с клиентом");
    try {
        Thread.sleep(1020);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}
}
