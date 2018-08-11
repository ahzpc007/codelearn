package thinking;

public class Wind extends Ins{
    public void play(Note n){
        System.out.println("Wind.play()" + n);
    }

    public void play(int n){
        System.out.println("Wind.play()" + n);
    }
    public static void tune(Ins ins){
        ins.play(Note.MIDDLE_C);
    }

    public int test(){
        System.out.println("Wind2.test()");
        return 0;
    }

    public void test3(int a){
        System.out.println("Wind.test3()");
        return;
    }
    public void test2(){
        this.test();
    }
    public static void main(String[] args) {
        //Wind wind = new Wind();
        //tune(wind);
        Ins ins = new Wind();
        ins.test2();
    }
}
class Ins{
    private Meal meal = new Meal();
    public void play(Note n){
        System.out.println("Ins.play()");
    }

    private void test(){
        System.out.println("Ins.test()");
    }

    public void test2(){
        this.test();
    }

    public void test3(int a){
        System.out.println("Ins.test3()");
    }

    private static void test4(){
        System.out.println("Ins.test4()");
    }

    public static void main(String[] args) {
        Ins ins = new Wind();
        ins.test3(1);
    }
}
class Meal{

    Meal(){
        System.out.println("Meal created");
    }
}
enum Note{
    MIDDLE_C,C_S,B_F;
}
abstract class Testa{
    abstract void add();
}
interface Testb{
    void add();
}

class Testc extends Testa implements Testb{

    @Override
    public void add() {
        System.out.println("testc");
    }

    public void add(int a) {
        System.out.println("testc a");
    }

    public static void main(String[] args) {
        Testa a = new Testc();
        Testb b = new Testc();
        a.add();
        b.add();
    }
}