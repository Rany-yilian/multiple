package com.im.monitor.service;

import com.im.api.common.Monitor;
import com.im.api.service.BaseService;
import com.im.monitor.data.MonitorResult;
import com.im.monitor.data.ResultCollector;
import com.im.tools.config.CC;
import com.im.tools.log.Logs;
import sun.rmi.runtime.Log;

import java.util.concurrent.Executor;

public class MonitorService extends BaseService implements Monitor,Runnable {

    private static final int FIRST_DUMP_JSTACK_LOAD_AVG = 2,
            SECOND_DUMP_JSTACK_LOAD_AVG =4,
            THIRD_DUMP_JSTACK_LOAD_AVG =6,
            FIRST_DUMP_JMAP_LOAD_AVG = 4;

    private static final String dumpLogDir = CC.mp.monitor.dump_dir;

    private static final boolean dumpEnabled = CC.mp.monitor.dump_stack;

    private static final boolean printLog = CC.mp.monitor.print_log;

    private static final long dumpPeriod = CC.mp.monitor.dump_period.getSeconds();

    private volatile boolean dumpFirstJstack = false;

    private volatile boolean dumpSecondJstack = false;

    private volatile boolean dumpThirdJstack = false;

    private volatile boolean dumpJmap = false;

    private final ThreadPoolManager threadPoolManager;

    private final ResultCollector collector;

    public MonitorService(){
        threadPoolManager = new ThreadPoolManager();
        collector = new ResultCollector(threadPoolManager);
    }

    private Thread thread;


    @Override
    public void run(){
        while (isRunning()){
            MonitorResult result = collector.collect();
            if(printLog){
                Logs.MONITOR.info(result.toJson());
            }
            if(dumpEnabled){

            }
        }
    }

    @Override
    public void monitor(String name,Thread thread){

    }

    @Override
    public void monitor(String name, Executor executor){
    }

    private void dump(){
        double load = collector.getJvmInfo().load();
        if (load > FIRST_DUMP_JMAP_LOAD_AVG){
            if(!dumpFirstJstack){
                dumpFirstJstack = true;
            }
        }
    }
}
