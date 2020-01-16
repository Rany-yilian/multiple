package com.im.test.thread;


//https://blog.csdn.net/weixin_44270183/article/details/87904296
public class ThreadOps {

    public static void main(String[] args) throws InterruptedException{
        //BLOCKED
//        Runnable runnable = ()->ThreadOps.synRun();
//        Thread thread1 = new Thread(runnable,"thread1");
//        Thread thread2 = new Thread(runnable,"thread2");
//        thread1.start();
//        thread2.start();
//        System.out.println("thread2 state:"+thread2.getState());
//        Thread.sleep(1000);
//        System.out.println("thread2 state:"+thread2.getState());
        //object.notify

        //例子中构建了两个线程，thread1调用了ThreadOps.runWait()，在这个方法中，调用了this.wait();，会导致线程thread1进入WAITING状态，
        // 直到持有ThreadOps对象监视器的线程调用notify()或notifyAll()：thread2 在睡眠1秒钟后持有了ThreadOps对象监视器，并调用了notify()方法；
        // 最终thread1获得监视器，重新进入RUNNABLE状态
        ThreadOps ops = new ThreadOps();
        Thread thread1 = new Thread(()->{
            try {
                ops.runWait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        },"thread1");

        Thread thread2 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (ops) {
                ops.notify();
            }
        }, "thread2");

        thread1.start();
        thread2.start();
        System.out.println("thread1 state:" + thread1.getState());
        Thread.sleep(500);
        System.out.println("thread1 state:" + thread1.getState());

    }
    //解释
    //当线程thread1，thread2都创建并且调用start()方法时，synRun()方法开始执行，thread1预先执行，但是
    //Thread.sleep(10000);睡眠了10秒，在此期间thread2尝试调用synRun()，被阻塞，状态为BLOCKED。

    public static synchronized void synRun(){
        Thread thread = Thread.currentThread();
        System.out.println(String.format("current thread nam:%s,status:%s",thread.getName(),thread.getState()));
        try {
            Thread.sleep(10000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public void runWait() throws InterruptedException{
        synchronized(this){
            System.out.println("start waiting...");
            this.wait();
            Thread thread = Thread.currentThread();
            System.out.println(String.format("after wait().current thread name:%s,status:%s",thread.getName(),thread.getState()));
        }
    }
}
