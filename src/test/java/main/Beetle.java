package main;

public class Beetle extends Insect{
    private int k = printInit("Beetle.k init");
    public Beetle(){
        System.out.println("k = " + k);
        System.out.println("j = " + j);
    }
    private static int x2 = printInit("static Beetle.x2 init");

    public static void main(String[] args){
        System.out.println("Beetle constructor");
        Beetle b = new Beetle();
    }
}
class Insect{
    private int h = printInit("Insect.h init");
    private int i = 9;
    protected int j;
    Insect(){
        System.out.println("in = " + i + ",j=" + j);
        j = 39;
    }
    private static int x1 = printInit("static Insect.x1 init");

    static int printInit(String s){
        System.out.println(s);
        return 47;
    }
}