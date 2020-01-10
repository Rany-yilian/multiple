package com.im.bootstrap;

import com.im.tools.config.CC;

public class Main {

    public static void main(String[] args){
        System.out.println(CC.mp.net.connect_server_port);
        System.out.println(CC.mp.http.loadMapping());
    }
}
