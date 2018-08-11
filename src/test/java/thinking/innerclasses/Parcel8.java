package thinking.innerclasses;

public class Parcel8 {
    private int a;
    public Wrapping wrapping(int x){
        return new Wrapping(x){
            private int a = x;
            public int value(){
                return super.value() * 47;
            }
        };
    }
    public Destination destination(String s,Wrapping w){
        return new Destination(){
            private String label = s;
            int b = a;
            @Override
            public String readLabel() {
                w.value();
                System.out.println(label);
                return label;
            }
        };
    }
}
class Wrapping{
    private int i;
    public Wrapping(int x){
        i = x;
    }
    public int value(){
        return i;
    }
}