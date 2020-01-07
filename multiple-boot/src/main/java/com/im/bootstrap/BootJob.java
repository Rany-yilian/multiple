package com.im.bootstrap;

import java.util.function.Supplier;

public abstract class BootJob {
    protected BootJob next;

    protected abstract void start();

    protected abstract void stop();

    public void startNext(){
        if(next!=null){
            next.start();
        }
    }

    public void stopNext(){
        if(next!=null){
            next.stop();
        }
    }

    public BootJob setNext(BootJob next){
        this.next = next;
        return next;
    }

    public BootJob setNext(Supplier<BootJob> next,boolean enabled){
        if (enabled){
            return setNext(next.get());
        }
        return this;
    }

    protected String getNextName(){
        return next.getNextName();
    }

    protected String getName(){
        return this.getClass().getSimpleName();
    }
}
