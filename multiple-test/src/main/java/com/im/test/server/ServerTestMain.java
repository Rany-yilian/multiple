package com.im.test.server;

import com.im.bootstrap.Main;
import org.junit.Test;

public class ServerTestMain {

    public static void main(String[] args){start();}

    @Test
    public void testServer(){
        start();
    }

    public static void start(){
        Main.main(null);
    }
}
