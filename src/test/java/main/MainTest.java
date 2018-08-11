package main;


import org.apache.commons.collections.CollectionUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class MainTest {

    public final String a;
    public static final String b;


    MainTest() {
        a = "a";
        System.out.println("MainTest start!");
    }

    static {
        b = "b";
        System.out.println("static model start!");
    }
    public static void fun() {
        System.out.println("fun start!");
    }

    public static void main(String[] args) {
        Integer i = 123;
        String abc = String.valueOf(i);
        String a = abc.substring(0,1);
        String b = abc.substring(1,2);
        String c = abc.substring(2);
        System.out.println(a + ":" + b + ":" + c);
    }


    public static int[] twoSum(int[] nums, int target) {
        int start = 0;
        int end = 0;

        String str = "111";
        str.charAt(1);

        return new int[]{start,end};
    }
}
