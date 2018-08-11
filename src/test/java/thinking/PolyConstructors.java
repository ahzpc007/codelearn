package thinking;

public class PolyConstructors {
    public static void main(String[] args){
        Glyph glyph = new RoundGlyph(5);
        glyph.print();
        System.out.println(glyph.getClass().getName());
    }
}
abstract class Glyph{
    void draw(){
        System.out.println("Glyph.draw()");
    }
    Glyph(){
        System.out.println("Glyph() before draw()");
        this.draw();
        print();
        System.out.println("Glyph() after draw()");
    }
    abstract void print();
}

class RoundGlyph extends Glyph{
    private int radius = 1;
    RoundGlyph(int r){
        radius = r;
        System.out.println("RoundGlyph.RoundGlyph() radius = " + radius);
    }
    void draw(){
        System.out.println("RoundGlyph.draw()  radius = "  + radius);
    }

    @Override
    void print() {
        System.out.println("radius = "  + radius);
    }

}