package com.neu.groovy.service.java.string;

/**
 * @author guojiang.xiong@dmall.com
 * @description
 * @since 2016-08-08 10:33
 */
public class TestString {
    public static void main(String[] args) {
        int n = 1000 ;
        String str = "dfdjfkdsj";
        long t1 = System.currentTimeMillis();
        for (Integer i = 0; i < n; i++) {
            str += i + "";
        }
        long time1 = System.currentTimeMillis() - t1;
        System.out.println("time1:" + time1);
        System.out.println(str);

        str = "dfdjfkdsj";
        long t2 = System.currentTimeMillis();
        for (Integer i = 0; i < n; i++) {
            str += String.valueOf(i);
        }
        long time2 = System.currentTimeMillis() - t2;
        System.out.println("time2:" + time2);
        System.out.println(str);


        str = "dfdjfkdsj";
        long t3 = System.currentTimeMillis();
        for (Integer i = 0; i < n; i++) {
            str += i.toString();
        }
        long time3 = System.currentTimeMillis() - t3;
        System.out.println("time3:" + time3);
        System.out.println(str);


        //最近看网关代码的时候，看到了不少非String类型转String采用在非String类型后+"",怀疑这种用法好奇做了个测试，只做参考，小小好奇而已
        Integer i = 10;
        //方法1
        String str1 = i + "";
        //方法2
        String str2 = String.valueOf(i);
        //方法3
        String str3 = i.toString();
        //速度最慢方法1：最快方法3，而且方法1慢方法2 10%左右，慢方法3 20%左右。。
    }
}
