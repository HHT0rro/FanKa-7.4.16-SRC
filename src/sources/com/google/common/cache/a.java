package com.google.common.cache;

/* compiled from: AbstractCache.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class a implements b {

    /* renamed from: a, reason: collision with root package name */
    public final g f26125a = LongAddables.a();

    /* renamed from: b, reason: collision with root package name */
    public final g f26126b = LongAddables.a();

    /* renamed from: c, reason: collision with root package name */
    public final g f26127c = LongAddables.a();

    /* renamed from: d, reason: collision with root package name */
    public final g f26128d = LongAddables.a();

    /* renamed from: e, reason: collision with root package name */
    public final g f26129e = LongAddables.a();

    /* renamed from: f, reason: collision with root package name */
    public final g f26130f = LongAddables.a();

    public static long h(long j10) {
        if (j10 >= 0) {
            return j10;
        }
        return Long.MAX_VALUE;
    }

    @Override // com.google.common.cache.b
    public void a(int i10) {
        this.f26125a.add(i10);
    }

    @Override // com.google.common.cache.b
    public void b() {
        this.f26130f.increment();
    }

    @Override // com.google.common.cache.b
    public void c(long j10) {
        this.f26127c.increment();
        this.f26129e.add(j10);
    }

    @Override // com.google.common.cache.b
    public void d(int i10) {
        this.f26126b.add(i10);
    }

    @Override // com.google.common.cache.b
    public void e(long j10) {
        this.f26128d.increment();
        this.f26129e.add(j10);
    }

    @Override // com.google.common.cache.b
    public d f() {
        return new d(h(this.f26125a.sum()), h(this.f26126b.sum()), h(this.f26127c.sum()), h(this.f26128d.sum()), h(this.f26129e.sum()), h(this.f26130f.sum()));
    }

    public void g(b bVar) {
        d f10 = bVar.f();
        this.f26125a.add(f10.b());
        this.f26126b.add(f10.e());
        this.f26127c.add(f10.d());
        this.f26128d.add(f10.c());
        this.f26129e.add(f10.f());
        this.f26130f.add(f10.a());
    }
}
