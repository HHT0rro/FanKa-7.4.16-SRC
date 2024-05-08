package com.alibaba.security.realidentity.http;

import java.io.Serializable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class AuthHeader implements Serializable {
    private String appkey;
    private int code;
    private String signature;

    public String getAppkey() {
        return this.appkey;
    }

    public int getCode() {
        return this.code;
    }

    public String getSignature() {
        return this.signature;
    }

    public void setAppkey(String str) {
        this.appkey = str;
    }

    public void setCode(int i10) {
        this.code = i10;
    }

    public void setSignature(String str) {
        this.signature = str;
    }
}
