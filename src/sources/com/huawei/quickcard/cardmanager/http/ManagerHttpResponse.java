package com.huawei.quickcard.cardmanager.http;

import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ManagerHttpResponse {

    /* renamed from: a, reason: collision with root package name */
    public int f33555a;

    /* renamed from: b, reason: collision with root package name */
    public String f33556b;

    /* renamed from: c, reason: collision with root package name */
    public String f33557c;

    /* renamed from: d, reason: collision with root package name */
    public Map<String, Object> f33558d;

    public int getCode() {
        return this.f33555a;
    }

    public Map<String, Object> getHeaders() {
        return this.f33558d;
    }

    public String getMessage() {
        return this.f33557c;
    }

    public String getResponse() {
        return this.f33556b;
    }

    public void setCode(int i10) {
        this.f33555a = i10;
    }

    public void setHeaders(Map<String, Object> map) {
        this.f33558d = map;
    }

    public void setMessage(String str) {
        this.f33557c = str;
    }

    public void setResponse(String str) {
        this.f33556b = str;
    }
}
