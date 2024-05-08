package com.alibaba.security.biometrics.jni;

import com.mobile.auth.gatewayauth.ResultCode;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public enum ABJniDetectState {
    DETECT_STATE_DETECTING(0),
    DETECT_STATE_SUC(1),
    DETECT_STATE_FAIL(2);

    private static String[] CHINESE_NAME = {"", "通过", ResultCode.MSG_FAILED};
    private int value;

    ABJniDetectState(int i10) {
        this.value = i10;
    }

    public final String getMessage() {
        return CHINESE_NAME[ordinal()];
    }

    public final int getValue() {
        return this.value;
    }
}
