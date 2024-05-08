package com.alibaba.security.realidentity.build;

import java.util.Map;

/* compiled from: OSSResult.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ft {

    /* renamed from: a, reason: collision with root package name */
    private Long f3695a;

    /* renamed from: l, reason: collision with root package name */
    public int f3696l;

    /* renamed from: m, reason: collision with root package name */
    public Map<String, String> f3697m;

    /* renamed from: n, reason: collision with root package name */
    public String f3698n;

    /* renamed from: o, reason: collision with root package name */
    public Long f3699o;

    private void a(int i10) {
        this.f3696l = i10;
    }

    private int b() {
        return this.f3696l;
    }

    private Map<String, String> c() {
        return this.f3697m;
    }

    private String d() {
        return this.f3698n;
    }

    private Long e() {
        return this.f3699o;
    }

    public String toString() {
        return String.format("OSSResult<%s>: \nstatusCode:%d,\nresponseHeader:%s,\nrequestId:%s", super.toString(), Integer.valueOf(this.f3696l), this.f3697m.toString(), this.f3698n);
    }

    private void a(Map<String, String> map) {
        this.f3697m = map;
    }

    public final void b(Long l10) {
        if (l10 == null || l10.longValue() == 0) {
            return;
        }
        this.f3699o = l10;
    }

    private void a(String str) {
        this.f3698n = str;
    }

    public Long a() {
        return this.f3695a;
    }

    public final void a(Long l10) {
        if (l10 == null || l10.longValue() == 0) {
            return;
        }
        this.f3695a = l10;
    }
}
