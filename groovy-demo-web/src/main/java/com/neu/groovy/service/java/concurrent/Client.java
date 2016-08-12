package com.neu.groovy.service.java.concurrent;

import java.util.Map;
import java.util.Set;

/**
 * @author guojiang.xiong@dmall.com
 * @description
 * @since 2016-08-08 14:19
 */
public class Client {
    public static void main(String[] args) {
        //实例化一个有5个Worker的Master
        long start = System.currentTimeMillis();
        Master m = new Master(new PlusWorker(), 5);
        for (int i = 0; i <= 1000; i++) {
            m.submit(i);
        }
        m.execute();
        int re = 0;
        Map<String, Object> resultMap = m.getResultMap();
        //只要有一个Worker计算完成，则开始计算
        while (resultMap.size() > 0 || !m.isComplete()) {
            Set<String> keys = resultMap.keySet();
            String key = null;
            //每次获取一个结果
            for (String k : keys) {
                key = k;
                break;
            }
            Integer i = null;
            if (key != null) {
                i = (Integer) resultMap.get(key);
                //将结果相加
                if (i != null) {
                    re += i;
                }
                //删除已经计算过的子结果
                resultMap.remove(key);
            }
        }
        long time = System.currentTimeMillis() - start;
        System.out.println("The result is:" + re + ",time:" + time);
    }

}