package thinking.innerclasses;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Parcel11{

    private static class ParcelContents implements Contents,Destination{
        private int i = 11;
        @Override
        public int value() {
            return i;
        }

        @Override
        public String readLabel() {
            return null;
        }

        ParcelContents(){
            System.out.println("ParcelContents init");
        }
    }

    protected static class PDestination implements Destination{
        private String label;
        public PDestination(String whereTo){
            this.label = whereTo;
        }
        @Override
        public String readLabel() {
            System.out.println("insertClass" + label);
            return label;
        }
        public static void f(){

        }
        static int x = 10;

        static class AnotherLevel{
            static int x = 10;
            public static void f(){
            }
        }
    }

    public static Contents contents(){
        return new ParcelContents();
    }

    public static Destination destination(){
        return new PDestination("");
    }

    public static void main(String[] args) throws ParseException {
        String s = "a" + "b";
        String b = "a" + "b";
        System.out.println(s == b);

        String c = new String("ok");
        String d = new String("ok");
        System.out.println(c.equals(d));
    }
}
