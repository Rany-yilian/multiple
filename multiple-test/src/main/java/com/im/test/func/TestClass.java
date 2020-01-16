package com.im.test.func;

import com.im.bootstrap.BootJob;
import com.im.tools.config.CC;
import com.im.tools.config.data.RedisNode;
import org.junit.Test;

public class TestClass {


    @Test
    public void test(){
        RedisNode rn = new RedisNode();
        System.out.println(RedisNode.class);
        System.out.println(rn.getClass());
        System.out.println(rn.getClass().getName());
        printCC();
        System.out.println(String.class.getClass());
        System.out.println(String.class.getName());
        System.out.println(String.class.getSimpleName());
    }

    public void printCC(){
        System.out.println(CC.mp.http.loadMapping());
    }
}
