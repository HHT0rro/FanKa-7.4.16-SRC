package com.huawei.quickcard;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class o {

    /* renamed from: a, reason: collision with root package name */
    private a f34128a;

    /* renamed from: b, reason: collision with root package name */
    private a f34129b;

    /* renamed from: c, reason: collision with root package name */
    private a f34130c;

    /* renamed from: d, reason: collision with root package name */
    private a f34131d;

    /* renamed from: e, reason: collision with root package name */
    private a f34132e;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public enum a {
        DOTTED,
        DASHED,
        SOLID
    }

    public void a(a aVar) {
        this.f34132e = aVar;
    }

    public void b(a aVar) {
        this.f34131d = aVar;
    }

    public void c(a aVar) {
        this.f34128a = aVar;
    }

    public a d() {
        return this.f34128a;
    }

    public void e(a aVar) {
        this.f34129b = aVar;
    }

    public a f() {
        return this.f34129b;
    }

    public boolean a() {
        a aVar = this.f34128a;
        if (aVar == this.f34130c) {
            a aVar2 = this.f34131d;
            a aVar3 = this.f34129b;
            if (aVar2 == aVar3 && aVar == aVar3 && aVar != null) {
                return true;
            }
        }
        return false;
    }

    public a b() {
        return this.f34132e;
    }

    public a c() {
        return this.f34131d;
    }

    public void d(a aVar) {
        this.f34130c = aVar;
    }

    public a e() {
        return this.f34130c;
    }
}
