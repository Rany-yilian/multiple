package com.im.test.func;

import org.junit.Test;

import java.net.URL;
import java.util.Objects;

public class TestObject {


    @Test
    public void test(){
        method("127.0.0.1:80");
    }

    public static void method(String obj){
        Objects.requireNonNull(obj,"对象是null");
        String[] host_port = Objects.requireNonNull(obj,"对象是null").split(":");
        System.out.println(host_port[0]);
        System.out.println(host_port[1]);
    }

    @Test
    public void testString(){
        String url = "http://baidu.com:9001/xxx/xxx/aaa/bbb?s=nc=1";
        try {
            String e = testTranslate(new URL(url),"127.0.0.1",80);
            System.out.println(e);
        }catch (Exception e){
            e.printStackTrace();
        }

    }


    public String  testTranslate(URL uri,String ip,int port){
        StringBuilder sb = new StringBuilder(123);
        sb.append(uri.getProtocol()).append("://")
                .append(ip)
                .append(':')
                .append(port)
                .append(uri.getPath());
        String query = uri.getQuery();
        if(query!=null){
            sb.append('?').append(query);
        }
        return sb.toString();
    }
}
