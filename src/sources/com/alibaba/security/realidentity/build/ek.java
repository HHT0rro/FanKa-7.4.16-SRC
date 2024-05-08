package com.alibaba.security.realidentity.build;

import com.alibaba.security.realidentity.oss.common.HttpMethod;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* compiled from: GeneratePresignedUrlRequest.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ek {

    /* renamed from: a, reason: collision with root package name */
    public HttpMethod f3552a;

    /* renamed from: b, reason: collision with root package name */
    public String f3553b;

    /* renamed from: c, reason: collision with root package name */
    public String f3554c;

    /* renamed from: d, reason: collision with root package name */
    public String f3555d;

    /* renamed from: e, reason: collision with root package name */
    public long f3556e;

    /* renamed from: f, reason: collision with root package name */
    public String f3557f;

    /* renamed from: g, reason: collision with root package name */
    public String f3558g;

    /* renamed from: h, reason: collision with root package name */
    public Map<String, String> f3559h;

    public ek(String str, String str2) {
        this(str, str2, (byte) 0);
    }

    private String a() {
        return this.f3557f;
    }

    private String b() {
        return this.f3558g;
    }

    private HttpMethod c() {
        return this.f3552a;
    }

    private String d() {
        return this.f3553b;
    }

    private String e() {
        return this.f3554c;
    }

    private long f() {
        return this.f3556e;
    }

    private Map<String, String> g() {
        return this.f3559h;
    }

    private String h() {
        return this.f3555d;
    }

    private ek(String str, String str2, byte b4) {
        this(str, str2, HttpMethod.GET);
    }

    private void a(String str) {
        this.f3557f = str;
    }

    private void b(String str) {
        this.f3558g = str;
    }

    private void c(String str) {
        this.f3553b = str;
    }

    private void d(String str) {
        this.f3554c = str;
    }

    private void e(String str) {
        this.f3555d = str;
    }

    private ek(String str, String str2, HttpMethod httpMethod) {
        this.f3559h = new HashMap();
        this.f3553b = str;
        this.f3554c = str2;
        this.f3556e = 3600L;
        this.f3552a = httpMethod;
    }

    private void a(HttpMethod httpMethod) {
        if (httpMethod != HttpMethod.GET && httpMethod != HttpMethod.PUT) {
            throw new IllegalArgumentException("Only GET or PUT is supported!");
        }
        this.f3552a = httpMethod;
    }

    private void a(long j10) {
        this.f3556e = j10;
    }

    private void a(Map<String, String> map) {
        Objects.requireNonNull(map, "The argument 'queryParameter' is null.");
        Map<String, String> map2 = this.f3559h;
        if (map2 != null && map2.size() > 0) {
            this.f3559h.clear();
        }
        this.f3559h.putAll(map);
    }

    private void a(String str, String str2) {
        this.f3559h.put(str, str2);
    }
}
