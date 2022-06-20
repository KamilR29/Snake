package com.company;

import java.util.Comparator;

public class MyComprator implements Comparator<RankSort> {
    @Override
    public int compare(RankSort o1, RankSort o2) {
        if(o2 == null) return -1;
        if(o1.score>o2.score) return -1;
        else if (o1.score<o2.score) return 1;
        else return 0;
    }
}
