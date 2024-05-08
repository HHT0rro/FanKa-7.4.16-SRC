package com.alibaba.security.realidentity.build;

import com.alibaba.security.realidentity.oss.model.OSSRequest;

/* compiled from: ListObjectsRequest.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class fl extends OSSRequest {

    /* renamed from: g, reason: collision with root package name */
    private static final int f3635g = 1000;

    /* renamed from: a, reason: collision with root package name */
    public String f3636a;

    /* renamed from: b, reason: collision with root package name */
    public String f3637b;

    /* renamed from: c, reason: collision with root package name */
    public String f3638c;

    /* renamed from: d, reason: collision with root package name */
    public Integer f3639d;

    /* renamed from: e, reason: collision with root package name */
    public String f3640e;

    /* renamed from: f, reason: collision with root package name */
    public String f3641f;

    public fl() {
        this((byte) 0);
    }

    private String a() {
        return this.f3636a;
    }

    private String b() {
        return this.f3637b;
    }

    private String c() {
        return this.f3638c;
    }

    private Integer d() {
        return this.f3639d;
    }

    private String e() {
        return this.f3640e;
    }

    private String f() {
        return this.f3641f;
    }

    private fl(byte b4) {
        this((char) 0);
    }

    private void a(String str) {
        this.f3636a = str;
    }

    private void b(String str) {
        this.f3637b = str;
    }

    private void c(String str) {
        this.f3638c = str;
    }

    private void d(String str) {
        this.f3640e = str;
    }

    private void e(String str) {
        this.f3641f = str;
    }

    private fl(char c4) {
        this.f3636a = null;
        this.f3637b = null;
        this.f3638c = null;
        this.f3640e = null;
    }

    private void a(Integer num) {
        if (num.intValue() >= 0 && num.intValue() <= 1000) {
            this.f3639d = num;
            return;
        }
        throw new IllegalArgumentException("Maxkeys should less can not exceed 1000.");
    }
}
