package thinking.innerclasses;

public class TestParcel {
    Parcel4 p = new Parcel4();
    Contents c = p.contents();
    Destination d = p.destination("Tasmania");
    Parcel4.PDestination destination = p.new PDestination("");
}

class Parcel4{
    private int a = 0;
    private class PContents implements Contents{
        private int i = 11;
        @Override
        public int value() {
            return i;
        }
    }

    protected class PDestination implements Destination{
        private String label;

        public PDestination(String whereTo){
            this.label = whereTo;
        }

        @Override
        public String readLabel() {
            a = 2;
            return label;
        }
    }

    public Destination destination(String s){
        PDestination p = new PDestination(s);
        p.label = "";
        return new PDestination(s);
    }

    public PContents contents(){
        return new PContents();
    }
}
