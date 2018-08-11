package thinking;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Random;
import java.util.Scanner;

public class AdaptedRandomDoubles extends RandomDoubles implements Readable{

    private int count;

    public AdaptedRandomDoubles(int count){
        this.count = count;
    }

    @Override
    public int read(CharBuffer cb) throws IOException {
        if(count-- == 0){
            return -1;
        }
        String result = Double.toString(next()) + " ";
        cb.append(result);
        return result.length();
    }

    public static void main(String[] args){
        Scanner s = new Scanner(new AdaptedRandomDoubles(7));
        while (s.hasNextDouble()){
            System.out.println(s.nextDouble() + "");
        }
    }
}
class RandomDoubles{
    int a = 0;
    private static Random random = new Random(47);
    public double next(){
        return random.nextDouble();
    }
}
interface C{
    int a = 0;
}
