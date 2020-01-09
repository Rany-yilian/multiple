package com.im.test.func;

import com.im.bootstrap.BootJob;
import com.im.tools.config.data.RedisNode;
import org.junit.Test;

public class TestClass {


    @Test
    public void test(){
        RedisNode rn = new RedisNode();
        System.out.println(rn.getClass());
        System.out.println(rn.getClass().getName());
    }
}
