package com.huawei.hms.common.data;

import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class FreezableUtils {
    public static <T, E extends Freezable<T>> ArrayList<T> freeze(ArrayList<E> arrayList) {
        return freezeIterable(arrayList);
    }

    public static <T, E extends Freezable<T>> ArrayList<T> freezeIterable(Iterable<E> iterable) {
        ViewGroup.ChildListForAutoFillOrContentCapture childListForAutoFillOrContentCapture = (ArrayList<T>) new ArrayList();
        if (iterable == null) {
            return childListForAutoFillOrContentCapture;
        }
        Iterator<E> iterator2 = iterable.iterator2();
        while (iterator2.hasNext()) {
            childListForAutoFillOrContentCapture.add(iterator2.next().freeze());
        }
        return childListForAutoFillOrContentCapture;
    }

    public static <T, E extends Freezable<T>> ArrayList<T> freeze(E[] eArr) {
        return freezeIterable(Arrays.asList(eArr));
    }
}
