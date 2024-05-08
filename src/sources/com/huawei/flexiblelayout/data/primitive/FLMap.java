package com.huawei.flexiblelayout.data.primitive;

import androidx.annotation.NonNull;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface FLMap extends FLImmutableMap {
    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableMap
    FLArray optArray(@NonNull String str);

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableMap
    /* bridge */ /* synthetic */ FLImmutableArray optArray(@NonNull String str);

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableMap
    /* bridge */ /* synthetic */ FLImmutableMap optMap(@NonNull String str);

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableMap
    FLMap optMap(@NonNull String str);

    @NonNull
    FLMap put(@NonNull String str, Object obj);

    Object remove(@NonNull String str);
}
