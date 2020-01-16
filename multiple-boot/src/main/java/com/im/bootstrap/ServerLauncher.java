package com.im.bootstrap;

import com.im.core.MPushServer;

public class ServerLauncher {

    private MPushServer mPushServer;

    public void init(){
        if(mPushServer==null){
            mPushServer = new MPushServer();
        }
    }
}
