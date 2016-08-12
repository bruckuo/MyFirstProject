package com.neu.groovy.service.java.concurrent;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author guojiang.xiong@dmall.com
 * @description
 * @since 2016-08-08 14:18
 */
public class Master {
    //任务队列，保存所有的任务
    private Queue<Object> workQueue = new ConcurrentLinkedQueue<>();
    //Worker进程队列
    private Map<String, Thread> threadMap = new HashMap<>();

    //任务处理结果集
    private Map<String, Object> resultMap = new ConcurrentHashMap<>();

    //判断是否所有子任务都完成了
    public boolean isComplete() {
        for (Map.Entry<String, Thread> entry : threadMap.entrySet()) {
            if (entry.getValue().getState() != Thread.State.TERMINATED) {
                return false;
            }
        }
        return true;
    }

    //Master的构造，需要一个Worker进程实例，和需要的worker进程数量
    public Master(Worker worker, int count) {
        worker.setResultMap(resultMap);
        worker.setWorkQueue(workQueue);
        for (int i = 0; i < count; i++) {
            threadMap.put(Integer.toString(i), new Thread(worker, Integer.toString(i)));
        }
    }

    //提交一个任务
    public void submit(Object job) {
        workQueue.add(job);
    }

    //返回子任务结果集
    public Map<String, Object> getResultMap() {
        return resultMap;
    }

    //开始运行所有的Worker进程，进行处理
    public void execute() {
        for (Map.Entry<String, Thread> entry : threadMap.entrySet()) {
            entry.getValue().start();
        }
    }
}