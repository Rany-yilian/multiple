package com.im.test.func;

import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class TestAtomic implements Runnable {

    //没有使用线程安全
    /*private String name;

    private static boolean exists = false;

    public TestAtomic(String name){
        this.name = name;
    }

    @Override
    public void run(){
        if(!exists){
            try {
                TimeUnit.SECONDS.sleep(1);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            exists = true;
            System.out.println(name+":enter");
            try {
                TimeUnit.SECONDS.sleep(2);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(name+":leave");
            exists = false;
        }else {
            System.out.println(name+":give up");
        }
    }*/

    //使用线程安全的类
    private String  name;
    private static AtomicBoolean exists = new AtomicBoolean(false);

    public TestAtomic(String name){
        this.name = name;
    }

    @Override
    public void run(){
        if(exists.compareAndSet(false,true)){
            System.out.println(name+":enter");
            try {
                TimeUnit.SECONDS.sleep(2);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(name+":leave");
            exists.set(false);
        }else {
            System.out.println(name+":give up");
        }
    }

    public static void main(String[] args){
        TestAtomic bar1 = new TestAtomic("bar1");
        TestAtomic bar2 = new TestAtomic("bar2");
        new Thread(bar1).start();
        new Thread(bar2).start();
    }
}
