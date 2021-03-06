package com.im.monitor.data;

import com.im.monitor.quota.impl.*;
import com.im.monitor.service.ThreadPoolManager;

import java.util.HashMap;
import java.util.Map;

public class ResultCollector {

   private final JVMInfo jvmInfo;

   private final JVMGC jvmgc;

   private final JVMMemory jvmMemory;

   private final JVMThread jvmThread;

   private final JVMThreadPool jvmThreadPool;

   public ResultCollector(ThreadPoolManager threadPoolManager){
      this.jvmInfo = new JVMInfo();
      this.jvmgc = new JVMGC();
      this.jvmMemory = new JVMMemory();
      this.jvmThread = new JVMThread();
      this.jvmThreadPool = new JVMThreadPool(threadPoolManager);
   }

   public MonitorResult collect(){
      MonitorResult result = new MonitorResult();
      result.addResult("jvm-info",jvmInfo.monitor());
      result.addResult("jvm-gc",jvmgc.monitor());
      result.addResult("jvm-memory",jvmMemory.monitor());
      result.addResult("jvm-thread",jvmThread.monitor());
      result.addResult("jvm-thread-pool",jvmThreadPool.monitor());
      return result;
   }

   public JVMInfo getJvmInfo(){
      return jvmInfo;
   }

   public JVMGC getJvmgc(){
      return jvmgc;
   }

   public JVMMemory getJvmMemory(){
      return jvmMemory;
   }

   public JVMThread getJvmThread(){
      return jvmThread;
   }

   public JVMThreadPool getJvmThreadPool(){
      return jvmThreadPool;
   }
}
