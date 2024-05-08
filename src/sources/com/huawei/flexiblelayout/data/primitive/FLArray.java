package com.huawei.flexiblelayout.data.primitive;

import androidx.annotation.NonNull;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface FLArray extends FLImmutableArray {
    @NonNull
    FLArray add(Object obj);

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableArray
    FLArray optArray(int i10);

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableArray
    /* bridge */ /* synthetic */ FLImmutableArray optArray(int i10);

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableArray
    /* bridge */ /* synthetic */ FLImmutableMap optMap(int i10);

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableArray
    FLMap optMap(int i10);

    Object remove(int i10);

    void set(int i10, Object obj);
}
