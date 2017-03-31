package com.company.it.belstu.prykhach;

/**
 * Created by Anna on 31.03.2017.
 */
public class Client implements Runnable{
    public CallCenter callCenter;
    public boolean ansOrNo = false;
    public String name;

    public Client(String name, CallCenter call) {
        this.callCenter = call;
        this.name = name;
    }

    @Override

    public void run() {
        while(ansOrNo != true)
        {
        Operator operator = null;
        try {


            operator = callCenter.getOperator(500);
            ansOrNo = true;
            System.out.println("Клиент " + this.name + " дозвонился");
            operator.talking();

        } catch (Exception ex) {
            System.out.println(this.name + " " + ex.getMessage());
        } finally {
            if(operator != null){
                callCenter.takeOperator(operator);
                System.out.println("Клиент " + this.name + " закончил говорить");
            }
        }

    }
    }
}

