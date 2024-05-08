package com.huawei.quickcard.base.interfaces;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface IQuickCardData {
    void add(@NonNull Object obj);

    @Nullable
    Object get(@NonNull int i10);

    @Nullable
    Object get(@NonNull String str);

    boolean isArray();

    @NonNull
    String[] keys();

    void put(@NonNull int i10, @Nullable Object obj);

    void put(@NonNull String str, @Nullable Object obj);

    void set(@NonNull int i10, @Nullable Object obj);

    void set(@NonNull String str, @Nullable Object obj);

    int size();

    Object slice();

    Object slice(int i10);

    Object slice(int i10, int i11);

    Object splice(int i10);

    Object splice(int i10, int i11, Object... objArr);

    @NonNull
    Object toJSON();
}
