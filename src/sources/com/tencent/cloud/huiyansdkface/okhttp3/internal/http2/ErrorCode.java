package com.tencent.cloud.huiyansdkface.okhttp3.internal.http2;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
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


    /* renamed from: l, reason: collision with root package name */
    public final int f41824l;

    ErrorCode(int i10) {
        this.f41824l = i10;
    }

    public static ErrorCode fromHttp2(int i10) {
        for (ErrorCode errorCode : values()) {
            if (errorCode.f41824l == i10) {
                return errorCode;
            }
        }
        return null;
    }
}
