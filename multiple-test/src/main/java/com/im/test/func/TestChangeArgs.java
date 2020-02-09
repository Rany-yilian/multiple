package com.im.test.func;

public class TestChangeArgs {

    public static void main(String[] args){
        out(1,2,3);
    }
    public static void out(Object... args){
        for (int i=0;i<args.length;i++){
            System.out.println(args);
        }

    }
}
