package com.huawei.openalliance.ad.utils;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class aa {
    public static String Code(List<String> list, String str) {
        if (Code(list)) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        Iterator<String> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            sb2.append(iterator2.next());
            sb2.append(str);
        }
        return sb2.toString();
    }

    public static Set<String> Code(List<String> list, boolean z10) {
        if (Code(list)) {
            return null;
        }
        HashSet hashSet = new HashSet();
        if (z10) {
            Iterator<String> iterator2 = list.iterator2();
            while (iterator2.hasNext()) {
                hashSet.add(iterator2.next().toUpperCase(Locale.ENGLISH));
            }
        } else {
            hashSet.addAll(list);
        }
        return hashSet;
    }

    public static <T> boolean Code(Collection<T> collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean Code(int[] iArr) {
        return iArr == null || iArr.length == 0;
    }

    public static <T> boolean Code(T[] tArr) {
        return tArr == null || tArr.length == 0;
    }
}
