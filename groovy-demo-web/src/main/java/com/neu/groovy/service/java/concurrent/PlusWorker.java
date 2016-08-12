package com.neu.groovy.service.java.concurrent;

/**
 * @author guojiang.xiong@dmall.com
 * @description
 * @since 2016-08-08 15:27
 */
public class PlusWorker extends Worker {
    @Override
    public Object handle(Object input){
        Integer i=(Integer)input;
        return i*i*i;
    }
}
