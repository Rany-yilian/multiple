package com.im.api.spi.common;

import com.im.api.spi.Factory;
import com.im.api.spi.SpiLoader;
import com.im.api.srd.ServiceRegistry;

public interface ServiceRegistryFactory extends Factory<ServiceRegistry> {

    static ServiceRegistry create(){
        return SpiLoader.load(ServiceRegistryFactory.class).get();
    }
}
