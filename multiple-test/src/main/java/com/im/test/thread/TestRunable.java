package com.im.test.thread;

public class TestRunable implements Runnable {

    private int tickets = 10;

    @Override
    public void run(){
        for (int i=0;i<=100;i++){
            if (tickets>0){
                System.out.println(Thread.currentThread().getName()+"--卖出票："+tickets--);
            }
        }
    }

    public static void main(String[] args){
        TestRunable fu = new TestRunable();
        Thread thread1 = new Thread(fu,"窗口一");
        Thread thread2 = new Thread(fu,"窗口二");
        Thread thread3 = new Thread(fu,"窗口三");
        thread1.start();
        thread2.start();
        thread3.start();

    }
}
