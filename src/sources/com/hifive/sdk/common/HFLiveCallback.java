package com.hifive.sdk.common;

import com.hifive.sdk.rx.BaseException;
import kotlin.d;
import org.jetbrains.annotations.NotNull;

/* compiled from: HFLiveCallback.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface HFLiveCallback {
    void onError(@NotNull BaseException baseException);

    void onSuccess();
}
