package com.alibaba.security.realidentity;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class RPEventListener {
    public void onBiometricsFinish(int i10) {
    }

    public void onBiometricsStart() {
    }

    public void onFinish(RPResult rPResult, ErrorCode errorCode) {
        onFinish(rPResult, errorCode.code, errorCode.msg);
    }

    @Deprecated
    public void onFinish(RPResult rPResult, String str, String str2) {
    }

    public void onStart() {
    }
}
