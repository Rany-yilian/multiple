package com.im.monitor.quota;

public interface InfoQuota extends MonitorQuota {

    String pid();

    double load();
}
