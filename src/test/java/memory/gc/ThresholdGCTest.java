package memory.gc;

public class ThresholdGCTest {
    /**
     * vm: -verbose:gc -Xmx20m -Xmx20m -Xmn10m -XX:+PrintGCDetails -XX:SurvivorRatio=8
     * -XX:MaxTenuringThreshold=1
     */
    private static final int _1MB = 1024 * 1024;

    public static void testThreshold(){
      byte[] allocate1,allocate2,allocate3;
        allocate1 = new byte[_1MB/4];
        allocate2 = new byte[4 * _1MB];
        allocate3 = new byte[4 * _1MB];
        //allocate3 = null;
        //allocate3 = new byte[4 * _1MB];
    }

    public static void main(String[] args) {
        testThreshold();
    }
}
