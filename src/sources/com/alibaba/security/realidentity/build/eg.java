package com.alibaba.security.realidentity.build;

import com.alibaba.security.realidentity.oss.model.OSSRequest;
import java.util.List;

/* compiled from: DeleteMultipleObjectRequest.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class eg extends OSSRequest {

    /* renamed from: a, reason: collision with root package name */
    public String f3544a;

    /* renamed from: b, reason: collision with root package name */
    public List<String> f3545b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f3546c;

    private eg(String str, List<String> list, Boolean bool) {
        this.f3544a = str;
        this.f3545b = list;
        this.f3546c = bool.booleanValue();
    }

    private String a() {
        return this.f3544a;
    }

    private List<String> b() {
        return this.f3545b;
    }

    private Boolean c() {
        return Boolean.valueOf(this.f3546c);
    }

    private void a(String str) {
        this.f3544a = str;
    }

    private void a(List<String> list) {
        this.f3545b = list;
    }

    private void a(Boolean bool) {
        this.f3546c = bool.booleanValue();
    }
}
