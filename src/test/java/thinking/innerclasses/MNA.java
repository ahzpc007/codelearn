package thinking.innerclasses;

public class MNA {
    private void f(){

    }
    class A{
        private void g(){

        }
        public class B{
            void h(){
                g();
                f();
            }
        }
    }

    public static void main(String[] args) {
        MNA mna = new MNA();
        MNA.A a = mna.new A();
        MNA.A.B b = a.new B();
        b.h();
    }
}
