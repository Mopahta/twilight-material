package by.mopahta.laba.task8;

import java.util.ArrayList;
import java.util.List;

public class MergeArrays {

    public void testFunction () {
        List<Integer> a = List.of(1,5,8,19,23);
        ArrayList<Integer> aSeq = new ArrayList<>(a);
        List<Integer> b = List.of(0,3,6,8,15,19,20,21,25,26,27);
        ArrayList<Integer> bSeq = new ArrayList<>(b);
        mergeArrays(aSeq,bSeq);
    }

    private void mergeArrays (List<Integer> aSeq, List<Integer> bSeq) {
        int j = 0;
        for (int i = 0; i < aSeq.size(); i++) {
            if (aSeq.get(i) > bSeq.get(j)) {
                aSeq.add(i, bSeq.get(j));
                j++;
                if (j >= bSeq.size()) break;
            }
        }
        aSeq.addAll(bSeq.subList(j, bSeq.size()));
        System.out.println(aSeq);
    }
}
