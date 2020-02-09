package com.im.test.jvm;

import org.junit.Test;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.lang.management.RuntimeMXBean;

public class testRuntime {

    private static final RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();

    private String currentPid;

    public static void main(String[] args){
     System.out.println("bootClassParg-->\n"+runtimeMXBean.getBootClassPath());
     System.out.println("the pid is "+populateProcessID());
     System.out.println("spec name is "+runtimeMXBean.getSpecName());
     System.out.println("spec vendor is"+runtimeMXBean.getSpecVendor());
     System.out.println("vm name is "+runtimeMXBean.getVmName());
     System.out.println("Vm vendor is" +runtimeMXBean.getVmVendor());
     System.out.println("VM version is"+runtimeMXBean.getVmVersion());

     System.out.println("System properties "+runtimeMXBean.getSystemProperties());

    }

    private static String populateProcessID(){
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        return runtimeMXBean.getName().split("@")[0];
    }

    @Test
    public void pid(){
        if (currentPid==null){
            currentPid = runtimeMXBean.getName().split("@")[0];
        }
        System.out.println(currentPid);
    }
}
