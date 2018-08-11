package thinking.exception;

public class StormyInning extends Inning implements Storm{


    public StormyInning() throws BaseballException {
    }

    public void walk(){

    }

    @Override
    public void event(){

    }

    @Override
    public void atBat() throws PopFoul {

    }


    public void rainHard() throws RainSun {

    }

    @Override
    public void rainHard1(){

    }
}

class BaseballException extends Exception{}
class Foul extends BaseballException{}
class Strike extends BaseballException{}
class StormException extends Exception{}
class RainedOut extends Exception{}
class PopFoul extends Foul{}
class RainSun extends RainedOut{}

abstract class Inning{
    public Inning() throws BaseballException{}

    public void event() throws BaseballException{}

    public abstract void atBat() throws Strike,Foul;

    public void walk(){}

}
interface Storm{
    public void event() throws RainedOut;
    public void rainHard() throws RainedOut;

    default void rainHard1(){

    }
}