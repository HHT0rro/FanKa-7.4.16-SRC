package com.tencent.liteav.beauty.b.a;

import androidx.annotation.NonNull;
import com.tencent.liteav.videobase.a.k;
import com.tencent.liteav.videobase.frame.e;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a extends k implements com.tencent.liteav.beauty.b.b {

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    private final d f42943b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    private final d f42944c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    private final b f42945d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    private final c f42946e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    private final d f42947f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    private final d f42948g;

    /* renamed from: h, reason: collision with root package name */
    private float f42949h = 0.2f;

    /* renamed from: i, reason: collision with root package name */
    private float f42950i = 0.2f;

    /* renamed from: j, reason: collision with root package name */
    private float f42951j = 0.2f;

    /* renamed from: k, reason: collision with root package name */
    private float f42952k = 0.0f;

    public a() {
        d dVar = new d(true);
        this.f42943b = dVar;
        d dVar2 = new d(false);
        this.f42944c = dVar2;
        b bVar = new b();
        this.f42945d = bVar;
        c cVar = new c();
        this.f42946e = cVar;
        d dVar3 = new d(true);
        this.f42947f = dVar3;
        d dVar4 = new d(false);
        this.f42948g = dVar4;
        k.a aVar = this.f43263a;
        k.a a10 = a(dVar);
        a10.a(aVar);
        k.a a11 = a(dVar2);
        a11.a(a10);
        k.a a12 = a(bVar);
        a12.a(aVar);
        a12.a("inputImageTexture2", a11);
        k.a a13 = a(dVar3);
        a13.a(a12);
        k.a a14 = a(dVar4);
        a14.a(a13);
        k.a a15 = a(cVar);
        a15.a(aVar);
        a15.a("inputImageTexture2", a11);
        a15.a("inputImageTexture3", a14);
    }

    @Override // com.tencent.liteav.beauty.b.b
    public final void a(float f10) {
        this.f42949h = f10;
        this.f42946e.a(f10);
    }

    @Override // com.tencent.liteav.beauty.b.b
    public final void b(float f10) {
        this.f42950i = f10;
        this.f42946e.b(f10);
    }

    @Override // com.tencent.liteav.beauty.b.b
    public final void c(float f10) {
        this.f42951j = f10;
        this.f42946e.c(f10);
    }

    @Override // com.tencent.liteav.videobase.a.b
    public final boolean canBeSkipped() {
        return this.f42946e.canBeSkipped();
    }

    @Override // com.tencent.liteav.beauty.b.b
    public final void d(float f10) {
        this.f42952k = f10;
        this.f42946e.d(f10);
    }

    @Override // com.tencent.liteav.videobase.a.k, com.tencent.liteav.videobase.a.b
    public final void onInit(e eVar) {
        super.onInit(eVar);
        this.f42946e.a(this.f42949h);
        this.f42946e.b(this.f42950i);
        this.f42946e.c(this.f42951j);
        this.f42946e.d(this.f42952k);
    }
}
