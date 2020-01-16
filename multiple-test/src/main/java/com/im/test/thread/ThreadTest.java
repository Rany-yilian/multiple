package com.im.test.thread;

public class ThreadTest extends Thread{

    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) throws InterruptedException{
        System.out.println("main:"+Thread.currentThread().getName());
        //第一种
        //new ThreadTest().start();
        //第二种传递runable参数
//        Runnable runnable = ()->{
//            System.out.println(Thread.currentThread().getName());
//        };
//        new Thread(runnable).start();
        //查看thread状态
//        Runnable runnable = ()->{
////            System.out.println("new thread name:"+Thread.currentThread().getName());
////        };
////        Thread thread = new Thread(runnable);
////        System.out.println(thread.getState());
////        thread.start();
////        System.out.println(thread.getState());
////        Thread.sleep(100);
////        System.out.println(thread.getState());
        //State.BLOCKED

    }


}
