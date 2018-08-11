package memory.gc;

public class MinorGcTest {
    /**
     * vm: -verbose:gc -Xmx20m -Xmx20m -Xmn10m -XX:+PrintGCDetails -XX:SurvivorRatio=8
     */
    private static final int _1MB = 1024 * 1024;

    public static void testAllocation(){
        byte[] allocate1,allocate2,allocate3,allocate4;
        //allocate1 = new byte[2 * _1MB];
        //allocate2 = new byte[2 * _1MB];
        //allocate3 = new byte[2 * _1MB];
        allocate4 = new byte[4 * _1MB];

    }

    public static void main(String[] args) {
        testAllocation();
    }
}
