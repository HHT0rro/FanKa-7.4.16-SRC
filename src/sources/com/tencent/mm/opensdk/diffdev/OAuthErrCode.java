package com.tencent.mm.opensdk.diffdev;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public enum OAuthErrCode {
    WechatAuth_Err_OK(0),
    WechatAuth_Err_NormalErr(-1),
    WechatAuth_Err_NetworkErr(-2),
    WechatAuth_Err_JsonDecodeErr(-3),
    WechatAuth_Err_Cancel(-4),
    WechatAuth_Err_Timeout(-5),
    WechatAuth_Err_Auth_Stopped(-6);

    private int code;

    OAuthErrCode(int i10) {
        this.code = i10;
    }

    public final int getCode() {
        return this.code;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "OAuthErrCode:" + this.code;
    }
}
