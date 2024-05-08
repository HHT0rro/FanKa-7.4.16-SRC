package com.alibaba.security.realidentity.build;

import com.alibaba.security.realidentity.oss.model.OSSRequest;
import java.util.Map;

/* compiled from: GetObjectRequest.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ex extends OSSRequest {

    /* renamed from: a, reason: collision with root package name */
    public String f3578a;

    /* renamed from: b, reason: collision with root package name */
    public String f3579b;

    /* renamed from: c, reason: collision with root package name */
    public gh f3580c;

    /* renamed from: d, reason: collision with root package name */
    public String f3581d;

    /* renamed from: e, reason: collision with root package name */
    public by f3582e;

    /* renamed from: f, reason: collision with root package name */
    public Map<String, String> f3583f;

    private ex(String str, String str2) {
        this.f3578a = str;
        this.f3579b = str2;
    }

    private Map<String, String> a() {
        return this.f3583f;
    }

    private String b() {
        return this.f3578a;
    }

    private String c() {
        return this.f3579b;
    }

    private gh d() {
        return this.f3580c;
    }

    private String e() {
        return this.f3581d;
    }

    private by f() {
        return this.f3582e;
    }

    private void a(Map<String, String> map) {
        this.f3583f = map;
    }

    private void b(String str) {
        this.f3579b = str;
    }

    private void c(String str) {
        this.f3581d = str;
    }

    private void a(String str) {
        this.f3578a = str;
    }

    private void a(gh ghVar) {
        this.f3580c = ghVar;
    }

    private void a(by<ex> byVar) {
        this.f3582e = byVar;
    }
}
