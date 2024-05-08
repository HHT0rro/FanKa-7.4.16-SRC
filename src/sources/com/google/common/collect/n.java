package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;

/* compiled from: Collections2.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class n {
    public static boolean a(Collection<?> collection, Collection<?> collection2) {
        Iterator<?> iterator2 = collection2.iterator2();
        while (iterator2.hasNext()) {
            if (!collection.contains(iterator2.next())) {
                return false;
            }
        }
        return true;
    }

    public static StringBuilder b(int i10) {
        m.b(i10, "size");
        return new StringBuilder((int) Math.min(i10 * 8, 1073741824L));
    }

    public static boolean c(Collection<?> collection, Object obj) {
        com.google.common.base.o.r(collection);
        try {
            return collection.contains(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    public static boolean d(Collection<?> collection, Object obj) {
        com.google.common.base.o.r(collection);
        try {
            return collection.remove(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    public static String e(Collection<?> collection) {
        StringBuilder b4 = b(collection.size());
        b4.append('[');
        boolean z10 = true;
        for (Object obj : collection) {
            if (!z10) {
                b4.append(", ");
            }
            z10 = false;
            if (obj == collection) {
                b4.append("(this Collection)");
            } else {
                b4.append(obj);
            }
        }
        b4.append(']');
        return b4.toString();
    }
}
