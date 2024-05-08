package com.tencent.cloud.huiyansdkface.wehttp2;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class Resp<T> {

    /* renamed from: a, reason: collision with root package name */
    private int f42304a;

    /* renamed from: b, reason: collision with root package name */
    private String f42305b;

    /* renamed from: c, reason: collision with root package name */
    private T f42306c;

    public int getCode() {
        return this.f42304a;
    }

    public String getMsg() {
        return this.f42305b;
    }

    public T getResult() {
        return this.f42306c;
    }

    public void setCode(int i10) {
        this.f42304a = i10;
    }

    public void setMsg(String str) {
        this.f42305b = str;
    }

    public void setResult(T t2) {
        this.f42306c = t2;
    }
}
