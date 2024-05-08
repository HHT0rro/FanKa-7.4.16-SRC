package com.tencent.cloud.huiyansdkface.a.a;

import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private List<e> f40300a;

    /* renamed from: b, reason: collision with root package name */
    private f f40301b;

    /* renamed from: c, reason: collision with root package name */
    private g<com.tencent.cloud.huiyansdkface.a.a.a.d> f40302c;

    /* renamed from: d, reason: collision with root package name */
    private g<com.tencent.cloud.huiyansdkface.a.a.a.d> f40303d;

    /* renamed from: e, reason: collision with root package name */
    private g<com.tencent.cloud.huiyansdkface.a.a.a.d> f40304e;

    /* renamed from: f, reason: collision with root package name */
    private g<String> f40305f;

    /* renamed from: g, reason: collision with root package name */
    private g<String> f40306g;

    /* renamed from: h, reason: collision with root package name */
    private g<com.tencent.cloud.huiyansdkface.a.a.a.b> f40307h;

    /* renamed from: i, reason: collision with root package name */
    private float f40308i;

    public c() {
        com.tencent.cloud.huiyansdkface.a.a.b.e eVar = com.tencent.cloud.huiyansdkface.a.a.b.e.f40298a;
        this.f40302c = eVar;
        this.f40303d = eVar;
        this.f40304e = eVar;
        this.f40305f = eVar;
        this.f40306g = eVar;
        this.f40307h = eVar;
        this.f40308i = -1.0f;
    }

    public c a(float f10) {
        if (f10 >= 0.0f && f10 <= 1.0f) {
            this.f40308i = f10;
        }
        return this;
    }

    public c a(f fVar) {
        this.f40301b = fVar;
        return this;
    }

    public c a(g<com.tencent.cloud.huiyansdkface.a.a.a.d> gVar) {
        if (gVar != null) {
            this.f40302c = gVar;
        }
        return this;
    }

    public c a(List<e> list) {
        this.f40300a = list;
        return this;
    }

    public List<e> a() {
        return this.f40300a;
    }

    public c b(g<com.tencent.cloud.huiyansdkface.a.a.a.d> gVar) {
        if (gVar != null) {
            this.f40303d = gVar;
        }
        return this;
    }

    public f b() {
        return this.f40301b;
    }

    public c c(g<com.tencent.cloud.huiyansdkface.a.a.a.d> gVar) {
        if (gVar != null) {
            this.f40304e = gVar;
        }
        return this;
    }

    public g<com.tencent.cloud.huiyansdkface.a.a.a.b> c() {
        return this.f40307h;
    }

    public c d(g<String> gVar) {
        if (gVar != null) {
            this.f40305f = gVar;
        }
        return this;
    }

    public g<com.tencent.cloud.huiyansdkface.a.a.a.d> d() {
        return this.f40302c;
    }

    public c e(g<String> gVar) {
        if (gVar != null) {
            this.f40306g = gVar;
        }
        return this;
    }

    public g<com.tencent.cloud.huiyansdkface.a.a.a.d> e() {
        return this.f40303d;
    }

    public c f(g<com.tencent.cloud.huiyansdkface.a.a.a.b> gVar) {
        if (gVar != null) {
            this.f40307h = gVar;
        }
        return this;
    }

    public g<com.tencent.cloud.huiyansdkface.a.a.a.d> f() {
        return this.f40304e;
    }

    public g<String> g() {
        return this.f40305f;
    }

    public g<String> h() {
        return this.f40306g;
    }

    public float i() {
        return this.f40308i;
    }
}
