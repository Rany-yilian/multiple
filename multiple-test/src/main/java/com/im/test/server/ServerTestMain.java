package com.im.test.server;

import com.im.bootstrap.Main;
import org.junit.Test;

public class ServerTestMain {

    public static void main(String[] args){start();}

    @Test
    public void testServer(){
        //start();
        Main.main(null);
    }

    public static void start(){
        System.out.println("start ");
    }
}
