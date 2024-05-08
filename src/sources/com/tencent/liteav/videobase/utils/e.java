package com.tencent.liteav.videobase.utils;

import android.graphics.PointF;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class e {
    public static boolean a(float f10, float f11) {
        return Math.abs(f10 - f11) < 1.0E-6f;
    }

    public static List<PointF> a(float[] fArr) {
        if (fArr == null || (fArr.length & 1) == 1) {
            return null;
        }
        int i10 = 0;
        ArrayList arrayList = new ArrayList();
        while (i10 < fArr.length) {
            int i11 = i10 + 1;
            arrayList.add(new PointF(fArr[i10], fArr[i11]));
            i10 = i11 + 1;
        }
        return arrayList;
    }

    public static float[] a(List<PointF> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        int size = list.size();
        float[] fArr = new float[size * 2];
        for (int i10 = 0; i10 < size; i10++) {
            PointF pointF = list.get(i10);
            int i11 = i10 * 2;
            fArr[i11] = pointF.x;
            fArr[i11 + 1] = pointF.y;
        }
        return fArr;
    }
}
