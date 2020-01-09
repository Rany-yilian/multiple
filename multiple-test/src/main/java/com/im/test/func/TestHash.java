package com.im.test.func;

import org.junit.Test;

public class TestHash {


    @Test
    public void test(){
        String ip = "127.0.0.1";
        int result = ip.hashCode()*31;
        System.out.println(result);
    }
}
