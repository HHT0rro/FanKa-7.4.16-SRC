package com.google.common.collect;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

/* compiled from: Platform.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class q0 {
    public static <T> T[] a(Object[] objArr, int i10, int i11, T[] tArr) {
        return (T[]) Arrays.copyOfRange(objArr, i10, i11, tArr.getClass());
    }

    public static <T> T[] b(T[] tArr, int i10) {
        return (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), i10));
    }

    public static <K, V> Map<K, V> c(int i10) {
        return CompactHashMap.createWithExpectedSize(i10);
    }

    public static <E> Set<E> d(int i10) {
        return CompactHashSet.createWithExpectedSize(i10);
    }

    public static <K, V> Map<K, V> e(int i10) {
        return CompactLinkedHashMap.createWithExpectedSize(i10);
    }

    public static <E> Set<E> f(int i10) {
        return CompactLinkedHashSet.createWithExpectedSize(i10);
    }

    public static <E> Set<E> g() {
        return CompactHashSet.create();
    }

    public static <K, V> Map<K, V> h() {
        return CompactHashMap.create();
    }

    public static MapMaker i(MapMaker mapMaker) {
        return mapMaker.l();
    }
}
