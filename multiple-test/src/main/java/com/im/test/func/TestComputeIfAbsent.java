package com.im.test.func;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.*;

public class TestComputeIfAbsent {

    static Map<Integer, Integer> cache = new ConcurrentHashMap<>();

    public static void main(String[] args) throws InterruptedException {
        cache.put(0, 0);
        cache.put(1, 1);
        System.out.println("fibonacci=" + fibonacci(7));
        System.out.println("-------------------------------");
        ;
        System.out.println("fibonacci=" + fibonacciJava8(7));
        System.out.println("-------------------------------");
        ;
        System.out.println("fibonacci=" + fibonacciJava7(7));

        //构建多值map样例代码
        Map<String, HashSet<String>> map1 = new HashMap<>();
        map1.computeIfAbsent("fruits", k -> genValue(k)).add("apple");
        map1.computeIfAbsent("fruits",k->genValue(k)).add("orange");
        map1.computeIfAbsent("fruits",k->genValue(k)).add("pear");
        map1.computeIfAbsent("fruits",k->genValue(k)).add("banana");
        map1.computeIfAbsent("fruits",k->genValue(k)).add("water");
        System.out.println(map1);

        //测试多线程并发处理，是否同步操作
        Map<String,String> map2 = new ConcurrentHashMap<>();
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i =0;i<5;i++){
            exec.execute(()->{
                map2.computeIfAbsent("name",k->genValue2(k));
                map2.computeIfAbsent("addr",k->genValue2(k));
                map2.computeIfAbsent("email",k->genValue2(k));
                map2.computeIfAbsent("mobile",k->genValue2(k));
            });
        }
        exec.shutdown();
        exec.awaitTermination(1, TimeUnit.SECONDS);
        System.out.println(map2);
    }

    static HashSet<String> genValue(String str) {
        return new HashSet<String>();
    }

    static String  genValue2(String str) {
        System.out.println("===");
        return str+"2";
    }

    static int fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        System.out.println("calculating Fibonacci(" + n + ")");
        return fibonacci(n - 2) + fibonacci(n - 1);
    }

    static int fibonacciJava8(int n) {
        return cache.computeIfAbsent(n, (key) -> {
            System.out.println("calculating Fibonacci(" + n + ")");
            return fibonacciJava8(n - 2) + fibonacciJava8(n - 1);
        });
    }

    static int fibonacciJava7(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        Integer result = cache.get(n);
        if (result == null) {
            synchronized (cache) {
                result = cache.get(n);
                if (result == null) {
                    System.out.println("calculating FibonacciJava7(" + n + ")");
                    result = fibonacciJava7(n - 2) + fibonacciJava7(n - 1);
                    cache.put(n, result);
                }
            }
        }
        return result;
    }
}
