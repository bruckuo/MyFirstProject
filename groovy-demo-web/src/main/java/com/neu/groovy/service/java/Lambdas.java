package com.neu.groovy.service.java;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author guojiang.xiong@dmall.com
 * @description
 * @since 2016-08-03 14:44
 */
public class Lambdas {
    public static void main(String[] args) {
        String[] players1 = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka", "David Ferrer",
                "Roger Federer", "Andy Murray",
                "Tomas Berdych", "Juan Martin Del Potro",
                "Richard Gasquet", "John Isner"};
        String[] players2 = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka", "David Ferrer",
                "Roger Federer", "Andy Murray",
                "Tomas Berdych", "Juan Martin Del Potro",
                "Richard Gasquet", "John Isner"};
        String[] players3 = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka", "David Ferrer",
                "Roger Federer", "Andy Murray",
                "Tomas Berdych", "Juan Martin Del Potro",
                "Richard Gasquet", "John Isner"};
        long t1 = System.currentTimeMillis();
        sort(players1);
        System.out.println(System.currentTimeMillis() - t1);

        long t2 = System.currentTimeMillis();
        lambdasSort1(players2);
        System.out.println(System.currentTimeMillis() - t2);

        long t3 = System.currentTimeMillis();
        lambdasSort2(players3);
        System.out.println(System.currentTimeMillis() - t3);

    }

    private static String[] sort(String[] players) {
        // 1.1 使用匿名内部类根据 name 排序 players
        Arrays.sort(players, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s1.compareTo(s2));
            }
        });
        for (String str: players)
            System.out.println(str);
        return players;
    }

    private static String[] lambdasSort1(String[] players) {
        // 1.2 使用 lambda expression 排序 players
        Comparator<String> sortByName = (String s1, String s2) -> (s1.compareTo(s2));
        Arrays.sort(players, sortByName);
        Arrays.asList(players).forEach((player) -> System.out.println(player + "; "));
        return players;
    }

    private static String[] lambdasSort2(String[] players) {
        // 1.3 也可以采用如下形式:
        Arrays.sort(players, (String s1, String s2) -> (s1.compareTo(s2)));
        Arrays.asList(players).forEach(System.out::println);
        return players;
    }
}
