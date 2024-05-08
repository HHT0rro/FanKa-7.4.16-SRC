package com.kwad.sdk.utils;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class z {
    @NonNull
    public static <T> List<List<T>> d(List<T> list, int i10) {
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            return arrayList;
        }
        int i11 = 0;
        while (i11 < list.size()) {
            int i12 = i11 + 200;
            arrayList.add(list.subList(i11, i12 > list.size() ? list.size() : i12));
            i11 = i12;
        }
        return arrayList;
    }
}
