package com.cupidapp.live.base.network;

import android.content.Context;
import io.reactivex.disposables.Disposable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: RequestDisposableCallback.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface g {
    void H(@NotNull Disposable disposable);

    @Nullable
    Context getStartApiRequestContext();
}
