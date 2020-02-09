package com.im.api;

import com.im.api.common.Monitor;
import com.im.api.spi.common.CacheManager;
import com.im.api.spi.common.MQClient;
import com.im.api.srd.ServiceDiscovery;
import com.im.api.srd.ServiceRegistry;

public interface MPushContext {

    Monitor getMonitor();

    ServiceDiscovery getDiscovery();

    ServiceRegistry getRegistry();

    CacheManager getCacheManager();

    MQClient getMQClient();
}
