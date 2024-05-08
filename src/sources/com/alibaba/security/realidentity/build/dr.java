package com.alibaba.security.realidentity.build;

import com.alibaba.security.realidentity.oss.model.OSSRequest;

/* compiled from: AppendObjectRequest.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class dr extends OSSRequest {

    /* renamed from: a, reason: collision with root package name */
    public String f3489a;

    /* renamed from: b, reason: collision with root package name */
    public String f3490b;

    /* renamed from: c, reason: collision with root package name */
    public String f3491c;

    /* renamed from: d, reason: collision with root package name */
    public byte[] f3492d;

    /* renamed from: e, reason: collision with root package name */
    public fu f3493e;

    /* renamed from: f, reason: collision with root package name */
    public by<dr> f3494f;

    /* renamed from: g, reason: collision with root package name */
    public long f3495g;

    /* renamed from: h, reason: collision with root package name */
    public Long f3496h;

    private dr(String str, String str2, String str3) {
        this(str, str2, str3, (byte) 0);
    }

    private long a() {
        return this.f3495g;
    }

    private String b() {
        return this.f3489a;
    }

    private String c() {
        return this.f3490b;
    }

    private String d() {
        return this.f3491c;
    }

    private byte[] e() {
        return this.f3492d;
    }

    private fu f() {
        return this.f3493e;
    }

    private by<dr> g() {
        return this.f3494f;
    }

    private Long h() {
        return this.f3496h;
    }

    private dr(String str, String str2, String str3, byte b4) {
        this.f3489a = str;
        this.f3490b = str2;
        this.f3491c = str3;
        this.f3493e = null;
    }

    private void a(long j10) {
        this.f3495g = j10;
    }

    private void b(String str) {
        this.f3490b = str;
    }

    private void c(String str) {
        this.f3491c = str;
    }

    private void a(String str) {
        this.f3489a = str;
    }

    private void a(byte[] bArr) {
        this.f3492d = bArr;
    }

    private void a(fu fuVar) {
        this.f3493e = fuVar;
    }

    private void a(by<dr> byVar) {
        this.f3494f = byVar;
    }

    private dr(String str, String str2, byte[] bArr) {
        this(str, str2, bArr, (byte) 0);
    }

    private void a(Long l10) {
        this.f3496h = l10;
    }

    private dr(String str, String str2, byte[] bArr, byte b4) {
        this.f3489a = str;
        this.f3490b = str2;
        this.f3492d = bArr;
        this.f3493e = null;
    }
}
