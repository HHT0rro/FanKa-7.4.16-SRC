package com.huawei.hms.push.ups.entity;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class TokenResult extends CodeResult {

    /* renamed from: c, reason: collision with root package name */
    private String f30472c;

    public TokenResult() {
    }

    public String getToken() {
        return this.f30472c;
    }

    public void setToken(String str) {
        this.f30472c = str;
    }

    public TokenResult(int i10) {
        super(i10);
    }

    public TokenResult(int i10, String str) {
        super(i10, str);
    }

    public TokenResult(String str) {
        this.f30472c = str;
    }
}
