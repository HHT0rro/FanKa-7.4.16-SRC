package com.hifive.sdk.rx;

import kotlin.d;
import org.jetbrains.annotations.Nullable;

/* compiled from: BaseException.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class BaseException extends Throwable {

    @Nullable
    private final String msg;

    @Nullable
    private final Integer status;

    public BaseException(@Nullable Integer num, @Nullable String str) {
        this.status = num;
        this.msg = str;
    }

    @Nullable
    public final String getMsg() {
        return this.msg;
    }

    @Nullable
    public final Integer getStatus() {
        return this.status;
    }
}
