package com.im.api.spi;

import com.im.api.MPushContext;

public interface Plugin {

    default void init(MPushContext context){

    }

    default void destroy(){

    }
}
