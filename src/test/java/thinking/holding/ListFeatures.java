package thinking.holding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ListFeatures {
    public static void main(String[] args) {
        List<ListFeatures> list = new ArrayList<ListFeatures>();
        list.add(new ListFeatures());
        list.add(new ListFeatures());
        list.add(new ListFeatures());
        List<ListFeatures> list2 = Arrays.asList(new ListFeatures(),new ListFeatures(),new ListFeatures());
        Object[] o = list.toArray();
        o[2] = new ListFeatures();
        ListFeatures[] l = list.toArray(new ListFeatures[0]);
        list.iterator();
        new HashMap<>();
    }
}
