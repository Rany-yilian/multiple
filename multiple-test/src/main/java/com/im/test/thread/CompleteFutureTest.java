package com.im.test.thread;

import java.util.concurrent.CompletableFuture;

public class CompleteFutureTest {

    public static void main(String [] args){
        //变换结果
//        String result = CompletableFuture.supplyAsync(()->{return "hello";}).thenApplyAsync(v->v+"world").join();
//        System.out.println(result);
        //消费结果
//        CompletableFuture.supplyAsync(()->{return "hello";}).thenAccept(v->{System.out.println("consumer:"+v);});

        //结合两个completionstage的结果，进行转换后返回
//        String result = CompletableFuture.supplyAsync(()->{
//            try{
//                Thread.sleep(1000);
//            }catch (InterruptedException e){
//                e.printStackTrace();
//            }
//            return "hello";
//        }).thenCombine(CompletableFuture.supplyAsync(()->{
//            try {
//                Thread.sleep(2000);
//            }catch (InterruptedException e){
//                e.printStackTrace();
//            }
//            return "world";
//        }),(s1,s2)->{return s1+""+s2;}).join();
//        System.out.println(result);

        //两个completionStage，谁计算的快，就用那个completionStage的结果进行下一步的处理
//        String result = CompletableFuture.supplyAsync(()->{
//            try {
//                Thread.sleep(100);
//            }catch (InterruptedException e){
//                e.printStackTrace();
//            }
//            return "hi boy";
//        }).applyToEither(CompletableFuture.supplyAsync(()->{
//            try {
//                Thread.sleep(99);
//            }catch (InterruptedException e){
//                e.printStackTrace();
//            }
//            return "hi girl";
//        }),(s)->{return s;}).join();
//        System.out.println(result);
        //exceptionally补偿
        String result = CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            if(true){
                throw  new RuntimeException("exeception test");
            }
            return "hi boy";
        }).exceptionally(e->{
            System.out.println(e.getMessage());
            return "hello world";
        }).join();
        System.out.println(result);
    }
}
