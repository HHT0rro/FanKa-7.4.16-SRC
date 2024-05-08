package com.hifive.sdk.protocol;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: BaseResp.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class BaseResp<T> {
    private final int code;
    private final T data;

    @NotNull
    private final String msg;

    public BaseResp(int i10, @NotNull String msg, T t2) {
        s.j(msg, "msg");
        this.code = i10;
        this.msg = msg;
        this.data = t2;
    }

    public final int getCode() {
        return this.code;
    }

    public final T getData() {
        return this.data;
    }

    @NotNull
    public final String getMsg() {
        return this.msg;
    }
}
