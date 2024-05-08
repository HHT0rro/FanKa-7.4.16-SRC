package com.alibaba.security.common.http.ok.internal.http2;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public enum ErrorCode {
    NO_ERROR(0),
    PROTOCOL_ERROR(1),
    INTERNAL_ERROR(2),
    FLOW_CONTROL_ERROR(3),
    REFUSED_STREAM(7),
    CANCEL(8),
    COMPRESSION_ERROR(9),
    CONNECT_ERROR(10),
    ENHANCE_YOUR_CALM(11),
    INADEQUATE_SECURITY(12),
    HTTP_1_1_REQUIRED(13);

    public final int httpCode;

    ErrorCode(int i10) {
        this.httpCode = i10;
    }

    public static ErrorCode fromHttp2(int i10) {
        for (ErrorCode errorCode : values()) {
            if (errorCode.httpCode == i10) {
                return errorCode;
            }
        }
        return null;
    }
}
