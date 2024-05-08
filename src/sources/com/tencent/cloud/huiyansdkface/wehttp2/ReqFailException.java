package com.tencent.cloud.huiyansdkface.wehttp2;

import com.tencent.cloud.huiyansdkface.wehttp2.WeReq;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class ReqFailException extends Exception {

    /* renamed from: a, reason: collision with root package name */
    private WeReq.ErrType f42301a;

    /* renamed from: b, reason: collision with root package name */
    private int f42302b;

    /* renamed from: c, reason: collision with root package name */
    private String f42303c;

    public ReqFailException(WeReq.ErrType errType, int i10, String str, Exception exc) {
        super(str, exc);
        this.f42301a = errType;
        this.f42302b = i10;
        this.f42303c = str;
    }

    public int code() {
        return this.f42302b;
    }

    public String msg() {
        return this.f42303c;
    }

    public WeReq.ErrType type() {
        return this.f42301a;
    }
}
