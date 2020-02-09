package com.im.test.func;

public class TestCharSequence {

    public static void main(String []args){
        CharSequence str = "hello world";
        CharSequence sub = str.subSequence(6,11);
        System.out.println(sub);
    }
}
