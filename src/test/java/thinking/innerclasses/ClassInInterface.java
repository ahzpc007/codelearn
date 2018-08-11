package thinking.innerclasses;

public interface ClassInInterface {
    void howdy();

    class Test extends Parcel4 implements ClassInInterface,Contents{

        @Override
        public void howdy() {
            System.out.println("Howdy");
        }

        public static void main(String[] args) {
            new Test().howdy();
        }

        @Override
        public int value() {
            return 0;
        }
    }

    class Test2{

        public void test2(ClassInInterface i){
            i.howdy();
        }

        public static void main(String[] args) {
            System.out.println("test2");
            new Test2().test2(new Test());
        }
    }
}
