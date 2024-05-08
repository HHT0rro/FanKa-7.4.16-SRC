package com.bykv.vk.openvk.api.proto;

import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface ValueSet {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface ValueGetter<T> {
        T get();
    }

    <T> T[] arrayValue(int i10, Class<T> cls);

    boolean booleanValue(int i10);

    boolean booleanValue(int i10, boolean z10);

    boolean containsKey(int i10);

    double doubleValue(int i10);

    float floatValue(int i10);

    float floatValue(int i10, float f10);

    int intValue(int i10);

    int intValue(int i10, int i11);

    boolean isEmpty();

    Set<Integer> keys();

    long longValue(int i10);

    long longValue(int i10, long j10);

    <T> T objectValue(int i10, Class<T> cls);

    int size();

    String stringValue(int i10);

    String stringValue(int i10, String str);
}
