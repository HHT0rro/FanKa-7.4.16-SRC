package com.alibaba.security.biometrics.service.model.strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class GroupActionStrategy extends DefaultActionStrategy {
    private static final String TAG = "GroupActionStrategy";
    public int[] group1 = {0, 1};
    public int[] group2 = {5, 6};

    @Override // com.alibaba.security.biometrics.service.model.strategy.DefaultActionStrategy
    public List<Integer> getRandom(int i10) {
        ArrayList arrayList = new ArrayList();
        Random random = new Random();
        int i11 = this.group1[random.nextInt(2)];
        int i12 = this.group2[random.nextInt(2)];
        arrayList.add(Integer.valueOf(i11));
        arrayList.add(Integer.valueOf(i12));
        int nextInt = random.nextInt(2);
        if (nextInt == 0) {
            Collections.sort(arrayList);
        } else if (nextInt == 1) {
            Collections.reverse(arrayList);
        }
        while (arrayList.size() > i10 && arrayList.size() > 0) {
            arrayList.remove(0);
        }
        return arrayList;
    }
}
