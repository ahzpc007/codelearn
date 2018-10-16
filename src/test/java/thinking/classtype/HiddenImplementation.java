package thinking.classtype;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author wuliqing
 */
public class HiddenImplementation {

    static void callHiddenMethod(Object a, String methodName) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = a.getClass().getDeclaredMethod(methodName);
        method.setAccessible(true);
        method.invoke(a);
    }

    static void modifyPrivateFields(Object a, String fieldName) throws InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        Field field = a.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        Object o = field.get(a);
        field.set(a,"1");
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        A a = new C();
        callHiddenMethod(a,"f");
        callHiddenMethod(a,"g");
        callHiddenMethod(a,"u");
    }
}

class C implements A{

    @Override
    public void f() {
        System.out.println("public C.f()");
    }

    public void g() {
        System.out.println("public C.g()");
    }

    void u() {
        System.out.println("public C.u()");
    }
}
interface A {
    void f();
}