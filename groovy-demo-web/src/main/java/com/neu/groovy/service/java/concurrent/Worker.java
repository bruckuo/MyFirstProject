package com.neu.groovy.service.java.concurrent;

import java.util.Map;
import java.util.Queue;

/**
 * @author guojiang.xiong@dmall.com
 * @description
 * @since 2016-08-08 14:19
 */
public class Worker implements Runnable {
    // 任务队列，用于取得子任务
    private Queue<Object> workQueue;
    // 子任务处理结果集
    private Map<String, Object> resultMap;

    public void setWorkQueue(Queue<Object> workQueue) {
        this.workQueue = workQueue;
    }

    public void setResultMap(Map<String, Object> resultMap) {
        this.resultMap = resultMap;
    }

    // 子类处理的业务逻辑，在子类中实现具体逻辑
    public Object handle(Object input) {
        return input;
    }

    @Override
    public void run() {
        while (true) {
            //获取子任务
            Object input = this.workQueue.poll();
            if (input == null)
                break;
            //处理子任务
            Object re = this.handle(input);
            //将处理结果写回结果集
            this.resultMap.put(Integer.toString(input.hashCode()), re);
        }
    }
}
