package com.huawei.hms.push.ups.entity;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class CodeResult {

    /* renamed from: a, reason: collision with root package name */
    private int f30470a;

    /* renamed from: b, reason: collision with root package name */
    private String f30471b;

    public CodeResult() {
    }

    public String getReason() {
        return this.f30471b;
    }

    public int getReturnCode() {
        return this.f30470a;
    }

    public void setReason(String str) {
        this.f30471b = str;
    }

    public void setReturnCode(int i10) {
        this.f30470a = i10;
    }

    public CodeResult(int i10) {
        this.f30470a = i10;
    }

    public CodeResult(int i10, String str) {
        this.f30470a = i10;
        this.f30471b = str;
    }
}
