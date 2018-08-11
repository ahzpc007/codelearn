package main;

import jmm.InnerTest;

public class InnerTestImpl {

    protected int a;
    protected class InnerImpl implements InnerTest{
        private int b = 1;
        public InnerImpl(){

        }
        @Override
        public void inner() {
            V1 v1 = new V1();
            a = 2;
        }
    }

    private class V1{

    }

    public void test3(){
        //b = 2;
    }

/*    public InnerImpl getImpl(){
        return new InnerImpl();
    }*/
}
class test1 extends InnerTestImpl{

    public InnerTest getImpl(){
        a = 1;
        return new InnerImpl();
    }
}

class test2 {

    public InnerTest getImpl(){
        InnerTestImpl i = new InnerTestImpl();
        return i.new InnerImpl();
    }
}