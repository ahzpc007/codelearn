package main;

import com.alibaba.fastjson.JSONObject;
import jmm.A;
import org.json.JSONString;


public class B extends A {

     public B(){
         super(0);
         System.out.println("b1");
     }

    B(int i){
        super(i);
        System.out.println("b2");
    }
    public void run(A a){
        System.out.println("run b");
    }

    public static void main(String[] args){
        A a = new B(1);
        B b = new B(2);
        b.run(b);
        B.go();
        A.go();
    }
}
