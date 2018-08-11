package jmm;

import main.B;

public class A {
    int a = 1;
    final B b;
    public void run(A a){
        System.out.println("run a");
    }


    public A(int i){
        b = new B();
        System.out.println("a");
    }

    protected static void go(){

    }
}
