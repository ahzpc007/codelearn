package thinking.innerclasses;

public class Sequence {
    private Object[] items;
    private int next = 0;
    public Sequence(int size){
        items = new Object[size];
    }
    public void add(Object x){
        if(next<items.length){
            items[next++] = x;
        }
    }
    public static void main(String[] args){
        Sequence sequence = new Sequence(10);
        for(int i=0;i<10;i++){
            sequence.add(Integer.toString(i));
        }
        SequenceSelector sequenceSelector = sequence.getSequenceSelector();
        while(!sequenceSelector.end()){
            System.out.print(sequenceSelector.current() + ",");
            sequenceSelector.next();
        }
        Sequence.SequenceSelector1 s1 = sequence.new SequenceSelector1();
    }
    public class SequenceSelector1{
        public void test(){

        }
    }
    private class SequenceSelector implements Selector{
        private int i = 0;
        @Override
        public boolean end() {
            return i == items.length;
        }

        @Override
        public Object current() {
            return items[i];
        }

        @Override
        public void next() {
            if(i<items.length){
                i++;
            }
        }
        public Sequence getSequence(){
            return Sequence.this;
        }
    }
    public SequenceSelector getSequenceSelector(){
        return new SequenceSelector();
    }
}
interface Selector{
    boolean end();
    Object current();
    void next();
}