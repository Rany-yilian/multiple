package com.im.common;

import com.im.api.srd.CommonServiceNode;
import com.im.api.srd.ServiceNames;
import com.im.api.srd.ServiceNode;
import com.im.tools.config.CC;
import com.im.tools.config.ConfigTools;

public class ServerNodes {

    public static ServiceNode cs(){
        CommonServiceNode node = new CommonServiceNode();
        node.setHost(ConfigTools.getConnectServerRegisterIp());
        node.setPort(CC.mp.net.connect_server_port);
        node.setPersistent(false);
        node.setServiceName(ServiceNames.CONN_SERVER);
        node.setAttrs(CC.mp.net.connect_server_register_attr);
        return node;
    }

    public static ServiceNode ws(){
        CommonServiceNode node = new CommonServiceNode();
        node.setHost(ConfigTools.getConnectServerRegisterIp());
        node.setPort(CC.mp.net.ws_server_port);
        node.setPersistent(false);
        node.setServiceName(ServiceNames.WS_SERVER);
        return node;
    }

    public static ServiceNode gs(){
        CommonServiceNode node = new CommonServiceNode();
        node.setHost(ConfigTools.getGatewayServerRegisterIp());
        node.setPort(CC.mp.net.gateway_server_port);
        node.setPersistent(false);
        node.setServiceName(ServiceNames.GATEWAY_SERVER);
        return node;
    }
}
