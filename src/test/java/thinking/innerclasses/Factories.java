package thinking.innerclasses;

public class Factories {
    public static void serviceConsumer(ServiceFactory factory){

    }
}
interface Service{
    void method1();
    void method2();
}
interface ServiceFactory{
    Service getService();
}


class Impl1 implements Service{

    private Impl1(){

    }
    @Override
    public void method1() {
        System.out.println("impl1 method1");
    }

    @Override
    public void method2() {
        System.out.println("impl1 method2");
    }

    public static ServiceFactory factory = new ServiceFactory() {
        @Override
        public Service getService() {
            return new Impl1();
        }
    };
}
class Impl2 implements Service{

    private Impl2(){

    }
    @Override
    public void method1() {
        System.out.println("impl2 method1");
    }

    @Override
    public void method2() {
        System.out.println("impl2 method2");
    }

    public static ServiceFactory factory = new ServiceFactory() {
        @Override
        public Service getService() {
            return new Impl2();
        }
    };
}