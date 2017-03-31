package com.company.it.belstu.prykhach;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Created by Anna on 31.03.2017.
 */
public class CallCenter {
    public ArrayDeque<Operator> dequeClient = new ArrayDeque<Operator>();
    public final int countOfOperators = 5;
    public Semaphore semaphore = new Semaphore(countOfOperators, true);

    public CallCenter() {
        this.dequeClient.add(new Operator("1"));
        this.dequeClient.add(new Operator("2"));
        this.dequeClient.add(new Operator("3"));
        this.dequeClient.add(new Operator("4"));
        this.dequeClient.add(new Operator("5"));
    }

    public Operator getOperator(long time) throws Exception
    {
        try {
            if(semaphore.tryAcquire(time, TimeUnit.MILLISECONDS)){
               return dequeClient.poll();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        throw new Exception("Время ожидания истекло");

    }

    public void takeOperator(Operator operator){
        this.dequeClient.add(operator);
        semaphore.release();
    }




}
