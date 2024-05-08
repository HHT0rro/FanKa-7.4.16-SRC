package com.huawei.quickcard.cardmanager.http;

import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ManagerHttpRequest {

    /* renamed from: a, reason: collision with root package name */
    public String f33550a;

    /* renamed from: b, reason: collision with root package name */
    public String f33551b;

    /* renamed from: c, reason: collision with root package name */
    public String f33552c;

    /* renamed from: d, reason: collision with root package name */
    public byte[] f33553d;

    /* renamed from: e, reason: collision with root package name */
    public Map<String, String> f33554e;

    public byte[] getBody() {
        return this.f33553d;
    }

    public String getContentType() {
        return this.f33552c;
    }

    public Map<String, String> getHeaders() {
        return this.f33554e;
    }

    public String getMethod() {
        return this.f33551b;
    }

    public String getUrl() {
        return this.f33550a;
    }

    public void setBody(byte[] bArr) {
        this.f33553d = bArr;
    }

    public void setContentType(String str) {
        this.f33552c = str;
    }

    public void setHeaders(Map<String, String> map) {
        this.f33554e = map;
    }

    public void setMethod(String str) {
        this.f33551b = str;
    }

    public void setUrl(String str) {
        this.f33550a = str;
    }
}
