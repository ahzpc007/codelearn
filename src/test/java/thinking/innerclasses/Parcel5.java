package thinking.innerclasses;

public class Parcel5 {
    static {
        class PDestination implements Destination{
            private String label;
            public PDestination(String whereTo){
                this.label = whereTo;
            }
            @Override
            public String readLabel() {
                System.out.println(label);
                return label;
            }
        }
        PDestination pd = new PDestination("field");
        pd.readLabel();
    }

    private class PDestination implements Destination{
        private String label;
        public PDestination(String whereTo){
            this.label = whereTo;
        }
        @Override
        public String readLabel() {
            System.out.println("insertClass" + label);
            return label;
        }
    }

    public Destination destination1(String s){
        return new PDestination(s);
    }

    public Destination destination(String s){
        class PDestination implements Destination{
            private String label;
            public PDestination(String whereTo){
                this.label = whereTo;
            }
            @Override
            public String readLabel() {
                System.out.println(label);
                return label;
            }
        }
        return new PDestination(s);
    }

/*    public Destination test(){
        return new Parcel5.PDestination();
    }*/

    public static void main(String[] args) {
        Parcel5 p = new Parcel5();
        Destination d = p.destination("Tasmania");
        d.readLabel();
    }
}
