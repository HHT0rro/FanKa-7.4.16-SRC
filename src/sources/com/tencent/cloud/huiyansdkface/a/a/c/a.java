package com.tencent.cloud.huiyansdkface.a.a.c;

import android.hardware.Camera;
import com.tencent.cloud.huiyansdkface.a.a.a.b;
import com.tencent.cloud.huiyansdkface.a.a.a.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class a {
    public static d a(Camera.Size size) {
        if (size == null) {
            return null;
        }
        return new d(size.width, size.height);
    }

    public static List<b> a(List<int[]> list) {
        if (list == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (int[] iArr : list) {
            if (iArr != null && iArr.length >= 2) {
                arrayList.add(new b(iArr[0], iArr[1]));
            }
        }
        return arrayList;
    }

    public static List<d> b(List<Camera.Size> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (Camera.Size size : list) {
                if (size != null) {
                    arrayList.add(a(size));
                }
            }
        }
        Collections.sort(arrayList, new Comparator<d>() { // from class: com.tencent.cloud.huiyansdkface.a.a.c.a.1
            @Override // java.util.Comparator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(d dVar, d dVar2) {
                return dVar2.c() - dVar.c();
            }
        });
        return arrayList;
    }
}
