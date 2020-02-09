package com.im.api.spi.common;

import com.im.api.spi.Factory;
import com.im.api.spi.SpiLoader;
import com.im.api.srd.ServiceDiscovery;

public interface ServiceDiscoveryFactory extends Factory<ServiceDiscovery> {

    static ServiceDiscovery create() {
        return SpiLoader.load(ServiceDiscoveryFactory.class).get();
    }
}
