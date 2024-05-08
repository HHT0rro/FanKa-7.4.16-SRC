package com.huawei.quickcard.utils;

import java.util.HashSet;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class WeakMapSet<K, T> extends WeakHashMap<K, Set<T>> {
    public Set<T> getChildren(K k10) {
        return (Set) super.get(k10);
    }

    public boolean putChild(K k10, T t2) {
        Set set = (Set) super.get(k10);
        if (set == null) {
            set = new HashSet();
            super.put(k10, set);
        }
        return set.add(t2);
    }

    public boolean removeChild(K k10, T t2) {
        Set set = (Set) super.get(k10);
        if (set == null) {
            return false;
        }
        return set.remove(t2);
    }
}
