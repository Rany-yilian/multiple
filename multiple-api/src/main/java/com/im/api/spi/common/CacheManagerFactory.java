package com.im.api.spi.common;

import com.im.api.spi.Factory;
import com.im.api.spi.SpiLoader;

public interface CacheManagerFactory extends Factory<CacheManager> {

    static CacheManager create(){
        return SpiLoader.load(CacheManagerFactory.class).get();
    }
}
