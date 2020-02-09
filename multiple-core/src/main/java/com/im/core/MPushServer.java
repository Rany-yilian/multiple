package com.im.core;
import com.im.api.MPushContext;
import com.im.api.common.Monitor;
import com.im.api.srd.ServiceNode;
import com.im.common.ServerNodes;
public class MPushServer  {

    public MPushServer(){
        System.out.println("---");
        ServiceNode connServerNode = ServerNodes.cs();
        System.out.println("conn--"+connServerNode);

        ServiceNode gatewayServerNode = ServerNodes.gs();
        System.out.println("gate--"+gatewayServerNode);
        ServiceNode websocketServerNode = ServerNodes.ws();
        System.out.println("websock--"+websocketServerNode);
    }

}
