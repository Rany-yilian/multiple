package com.im.test.loader;

import org.junit.Test;

import java.util.ServiceLoader;

public class loadTest {

    @Test
    public void test(){
        ServiceLoader<LogService> loader = ServiceLoader.load(LogService.class);
        for (LogService service:loader){
            System.out.println(service.getClass());
        }
    }
}
