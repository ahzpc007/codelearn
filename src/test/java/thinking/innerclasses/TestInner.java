package thinking.innerclasses;

public class TestInner extends WithInner.Inner{
    public TestInner(WithInner inner,int i){
        inner.super();
    }

    class InnerOfi{

    }

    public static void main(String[] args) {
        WithInner inner = new WithInner();
        WithInner.Inner2 inner2 = new WithInner.Inner2();

    }
}
class WithInner{
    class Inner{
        public Inner(){

        }
    }

    public static class Inner2{
        public Inner2(){

        }
        public void test2(){

        }
    }
}