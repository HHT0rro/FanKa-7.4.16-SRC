package com.alibaba.security.common.http.ok.internal.http2;

import java.io.IOException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class StreamResetException extends IOException {
    public final ErrorCode errorCode;

    public StreamResetException(ErrorCode errorCode) {
        super("stream was reset: " + ((Object) errorCode));
        this.errorCode = errorCode;
    }
}
