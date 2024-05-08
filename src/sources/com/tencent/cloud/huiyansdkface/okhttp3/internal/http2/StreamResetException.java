package com.tencent.cloud.huiyansdkface.okhttp3.internal.http2;

import java.io.IOException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class StreamResetException extends IOException {

    /* renamed from: a, reason: collision with root package name */
    public final ErrorCode f41985a;

    public StreamResetException(ErrorCode errorCode) {
        super("stream was reset: " + ((Object) errorCode));
        this.f41985a = errorCode;
    }
}
