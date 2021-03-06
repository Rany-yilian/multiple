package com.im.api.srd;


import com.im.api.service.Service;

import java.util.List;

public interface ServiceDiscovery extends Service {

    List<ServiceNode> lookup(String path);

    void subscribe(String path,ServiceListener listener);

    void unsubscribe(String path,ServiceListener listener);
}
