package com.huawei.quickcard.base.wrapper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface DataWrapper<T> {
    void add(@NonNull T t2, @NonNull Object obj);

    Object get(@NonNull T t2, @NonNull int i10);

    Object get(@NonNull T t2, @NonNull String str);

    boolean isArray(@NonNull T t2);

    boolean isObject(@NonNull T t2);

    @NonNull
    String[] keys(@NonNull T t2);

    void set(@NonNull T t2, @NonNull int i10, @Nullable Object obj);

    void set(@NonNull T t2, @NonNull String str, @Nullable Object obj);

    int size(@NonNull T t2);

    Object slice(@NonNull T t2, int i10);

    Object slice(@NonNull T t2, int i10, int i11);

    Object splice(String str, int i10, @NonNull T t2, int i11, int i12, Object... objArr);

    String stringify(@NonNull T t2);

    String toString(@NonNull T t2);
}
