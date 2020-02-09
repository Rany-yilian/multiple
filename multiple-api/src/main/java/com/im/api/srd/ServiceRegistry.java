package com.im.api.srd;

import com.im.api.service.Service;

public interface ServiceRegistry extends Service {

    void register(ServiceNode node);

    void deregister(ServiceNode node);
}
