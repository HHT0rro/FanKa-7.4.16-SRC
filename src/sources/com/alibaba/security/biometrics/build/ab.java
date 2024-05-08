package com.alibaba.security.biometrics.build;

import com.alibaba.security.biometrics.service.model.detector.ABDetectType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/* compiled from: ActionRandomUtils.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ab {

    /* renamed from: a, reason: collision with root package name */
    public static int[] f2211a = {0, 1};

    /* renamed from: b, reason: collision with root package name */
    public static int[] f2212b = {5, 6};

    private static List<Integer> a(int i10) {
        ArrayList arrayList = new ArrayList();
        Random random = new Random();
        int i11 = f2211a[random.nextInt(2)];
        int i12 = f2212b[random.nextInt(2)];
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

    private static ABDetectType b(int i10) {
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
}
