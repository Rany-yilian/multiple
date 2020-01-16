package com.im.test.thread;

import java.util.Random;
import java.util.concurrent.*;


public class FutureTest {

    public static void main(String[] args){
//        第一种方式
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        Future<Integer> result = executorService.submit(new Callable<Integer>(){
//            public Integer call() throws Exception{
//                return new Random().nextInt();
//            }
//        });
//        executorService.shutdown();
//        try {
//            System.out.println("result:"+result.get());
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }catch (ExecutionException e){
//            e.printStackTrace();
//        }
          //第二种方式
//          FutureTask<Integer> task = new FutureTask<Integer>(new Callable<Integer>() {
//              @Override
//              public Integer call() throws Exception {
//                  return new Random().nextInt();
//              }
//          });
//          new Thread(task).start();
//          try {
//              System.out.println("result:"+task.get());
//          }catch (InterruptedException e){
//              e.printStackTrace();
//          }catch (ExecutionException e){
//              e.printStackTrace();
//          }
          //第三种方式
          ExecutorService executorService = Executors.newSingleThreadExecutor();
          FutureTask<Integer> task = new FutureTask<Integer>(new Callable<Integer>() {
              @Override
              public Integer call() throws Exception {
                  return new Random().nextInt();
              }
          });
          executorService.submit(task);
          try {
              System.out.println("task:"+task.get());
          }catch (InterruptedException e){
              e.printStackTrace();
          }catch (ExecutionException e){
              e.printStackTrace();
          }


    }
}
