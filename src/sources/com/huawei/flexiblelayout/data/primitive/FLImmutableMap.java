package com.huawei.flexiblelayout.data.primitive;

import androidx.annotation.NonNull;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface FLImmutableMap extends MapModel {
    FLImmutableArray optArray(@NonNull String str);

    boolean optBoolean(@NonNull String str);

    boolean optBoolean(@NonNull String str, boolean z10);

    double optDouble(@NonNull String str);

    double optDouble(@NonNull String str, double d10);

    int optInt(@NonNull String str);

    int optInt(@NonNull String str, int i10);

    long optLong(@NonNull String str);

    long optLong(@NonNull String str, long j10);

    FLImmutableMap optMap(@NonNull String str);

    @NonNull
    String optString(@NonNull String str);

    @NonNull
    String optString(@NonNull String str, String str2);
}
