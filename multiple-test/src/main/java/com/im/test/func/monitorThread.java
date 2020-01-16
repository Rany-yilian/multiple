package com.im.test.func;

class MyThread2 extends Thread{
    boolean waiting = true;
    boolean ready = false;
    MyThread2(){

    }

    public void run(){
        String thrdName = Thread.currentThread().getName();
        System.out.println(thrdName+" starting.");
        while (waiting){
            System.out.println("waiting:"+waiting);
        }
        System.out.println("waiting...");
        startWait();
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            System.out.println(thrdName+" interrupted");
        }
        System.out.println(thrdName+"terminating");
    }

    synchronized void startWait(){
        try {
            while (!ready){
                wait();
            }
        }catch (InterruptedException exec){
            System.out.println("wait() interrupted");
        }
    }

    synchronized void notice() {
        ready = true;
        notify();
    }
}
public class monitorThread {
    public static void main(String []args) throws Exception{
        MyThread2 thrd = new MyThread2();
        thrd.setName("mythod#1");
        showThreadStatus(thrd);
        thrd.start();

        Thread.sleep(50);
        showThreadStatus(thrd);
        thrd.waiting = false;

        Thread.sleep(50);
        showThreadStatus(thrd);
        thrd.notice();

        Thread.sleep(50);
        showThreadStatus(thrd);

        while (thrd.isAlive())
            System.out.println("alive");
        showThreadStatus(thrd);
    }

    static void showThreadStatus(Thread thrd) {
        System.out.println(thrd.getName() + "  Alive:=" + thrd.isAlive() + " State:=" + thrd.getState());
    }
}
