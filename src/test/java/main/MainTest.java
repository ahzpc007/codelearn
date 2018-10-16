package main;


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
        int[] nums = new int[5];
        nums[0] = 1;
        int target = 2;
        while (true){
            twoSum(nums,target);
        }
    }


    public static int[] twoSum(int[] nums, int target) {
        int start = 0;
        int end = 0;

        String str = "111";
        str.charAt(1);

        return new int[]{start,end};
    }

}
