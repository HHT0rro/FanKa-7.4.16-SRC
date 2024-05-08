package com.alibaba.security.biometrics.service.model.strategy;

import com.alibaba.security.biometrics.service.model.detector.ABDetectType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class DefaultActionStrategy implements ActionStrategy {
    private static final String TAG = "DefaultActionStrategy";

    public ABDetectType getDetectType(int i10) {
        ABDetectType aBDetectType = ABDetectType.DONE;
        switch (i10) {
            case 0:
                return ABDetectType.BLINK;
            case 1:
                return ABDetectType.MOUTH;
            case 2:
                return ABDetectType.POS_PITCH;
            case 3:
                return ABDetectType.POS_YAW_LEFT;
            case 4:
                return ABDetectType.POS_YAW_RIGHT;
            case 5:
                return ABDetectType.POS_YAW;
            case 6:
                return ABDetectType.POS_PITCH_UP;
            case 7:
                return ABDetectType.POS_PITCH_DOWN;
            default:
                return aBDetectType;
        }
    }

    @Override // com.alibaba.security.biometrics.service.model.strategy.ActionStrategy
    public List<ABDetectType> getDetectTypes(int i10) {
        List<Integer> random = getRandom(i10);
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        Iterator<Integer> iterator2 = random.iterator2();
        while (iterator2.hasNext()) {
            copyOnWriteArrayList.add(getDetectType(iterator2.next().intValue()));
        }
        return copyOnWriteArrayList;
    }

    public List<Integer> getRandom(int i10) {
        int nextInt;
        ArrayList arrayList = new ArrayList();
        Random random = new Random();
        boolean[] zArr = new boolean[5];
        for (int i11 = 0; i11 < 5; i11++) {
            do {
                nextInt = random.nextInt(5);
            } while (zArr[nextInt]);
            zArr[nextInt] = true;
            if (arrayList.size() == i10) {
                break;
            }
            arrayList.add(Integer.valueOf(nextInt));
        }
        return arrayList;
    }
}
