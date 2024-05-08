package com.cupidapp.live.base.safe;

import com.cupidapp.live.base.network.model.Result;
import io.reactivex.Observable;
import ne.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SafeServices.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface d {
    @o("/user/entrance")
    @NotNull
    Observable<Result<Object>> a();

    @o("/client/device/activation/android")
    @ne.e
    @NotNull
    Observable<Result<Object>> b(@ne.c("device0") @Nullable String str, @ne.c("device1") @Nullable String str2);
}
