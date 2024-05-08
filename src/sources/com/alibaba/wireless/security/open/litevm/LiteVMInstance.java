package com.alibaba.wireless.security.open.litevm;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class LiteVMInstance {

    /* renamed from: а, reason: contains not printable characters */
    private Object f194;

    /* renamed from: б, reason: contains not printable characters */
    private String f195;

    /* renamed from: в, reason: contains not printable characters */
    private String f196;

    public LiteVMInstance(Object obj, String str, String str2) {
        this.f195 = str;
        this.f196 = str2;
        this.f194 = obj;
    }

    public String getAuthCode() {
        return this.f195;
    }

    public String getBizId() {
        return this.f196;
    }

    public Object getImpl() {
        return this.f194;
    }
}
