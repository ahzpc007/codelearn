package thinking.innerclasses;

import jmm.InnerTest;
import main.InnerTestImpl;

public class C extends InnerTestImpl{

    public InnerTest getImpl(){
        a = 1;
        return new InnerImpl();
    }
}
class Test{
    public static void main(String[] args) {
        InnerTestImpl innerTest = new InnerTestImpl();
    }
}

