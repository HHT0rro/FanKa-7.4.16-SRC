package com.huawei.quickcard.utils;

import java.util.LinkedList;
import java.util.List;
import java.util.WeakHashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class WeakMapList<K, T> extends WeakHashMap<K, List<T>> {
    public List<T> getChildren(K k10) {
        return (List) super.get(k10);
    }

    public void putChild(K k10, T t2) {
        List list = (List) super.get(k10);
        if (list == null) {
            list = new LinkedList();
            super.put(k10, list);
        }
        list.add(t2);
    }

    public boolean removeChild(K k10, T t2) {
        List list = (List) super.get(k10);
        if (list == null) {
            return false;
        }
        return list.remove(t2);
    }
}
