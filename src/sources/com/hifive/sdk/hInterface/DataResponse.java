package com.hifive.sdk.hInterface;

import kotlin.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DataResponse.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface DataResponse<T> {
    void data(T t2);

    void errorMsg(@NotNull String str, @Nullable Integer num);
}
