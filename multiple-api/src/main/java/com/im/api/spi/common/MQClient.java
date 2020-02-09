package com.im.api.spi.common;

import com.im.api.spi.Plugin;

public interface MQClient extends Plugin {

    void subscribe(String topic,MQMessageReceiver receiver);

    void publish(String topic,Object message);
}
