package com.im.api.spi.common;

public interface MQMessageReceiver {
    void receive(String topic,Object message);
}

