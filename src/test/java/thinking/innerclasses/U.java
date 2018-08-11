package thinking.innerclasses;

public interface U {
    void a();
    void b();
    void c();

    public static void main(String[] args) {

    }
}
class A{

    public U getU(){
        return new U(){

            @Override
            public void a() {

            }

            @Override
            public void b() {

            }

            @Override
            public void c() {

            }
        };
    }
}
class B{
    private U[] us;

    private int length;

    public B(int size){
        us = new U[size];
    }

    public void add(U u){
        if(length<us.length){
            us[length++] = u;
        }
    }

    public void delete(int size){
        if(size<us.length-1){
            us[size] = null;
        }
    }

    public void iterator(){
        for (U u : us){
            u.a();
            u.b();
            u.c();
        }
    }

}