package com.im.test.func;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TestScheduledExecutorService {

    public static void main(String[] args){
        //线程池1个
        /*ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        long start = System.currentTimeMillis();
        System.out.println("开始时间:"+start);
        System.out.println("第一次提交");
        executorService.schedule(()->{
            System.out.println(System.currentTimeMillis()-start);
            try {
                Thread.sleep(4000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        },3, TimeUnit.SECONDS);
        System.out.println("------------");
        System.out.println("第二次提交:");
        System.out.println(System.currentTimeMillis()-start);
        executorService.schedule(()->{
            System.out.println(System.currentTimeMillis()-start);
        },3,TimeUnit.SECONDS);*/
        //线程池2个
        /*ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
        long start = System.currentTimeMillis();
        System.out.println("开始时间:"+start);
        System.out.println("第一次提交");
        executorService.schedule(()->{
            System.out.println(System.currentTimeMillis()-start);
            try {
                Thread.sleep(4000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        },3, TimeUnit.SECONDS);
        System.out.println("------------");
        System.out.println("第二次提交:");
        System.out.println(System.currentTimeMillis()-start);
        executorService.schedule(()->{
            System.out.println(System.currentTimeMillis()-start);
        },3,TimeUnit.SECONDS);*/

        //线程池1个
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        long start = System.currentTimeMillis();
        System.out.println("第一次提交");
        executorService.schedule(()->{
            System.out.println(System.currentTimeMillis() - start);
            try {
                // 注意此处休眠4秒
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, 3, TimeUnit.SECONDS);
        System.out.println("第二次提交");
        // 注意此处延迟时间改为2s
        executorService.schedule(()->{
            System.out.println(System.currentTimeMillis() - start);
        }, 2, TimeUnit.SECONDS);
    }
}
