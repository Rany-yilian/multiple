package com.im.test.func;

@FunctionalInterface
interface Fug{
    public void test();

    public boolean equals(Object va);

    public default void defaultMethod(){
        System.out.println("hello");
    }

    public static void staticMethod(){

    }
}

public class TestFuncInt{

}
