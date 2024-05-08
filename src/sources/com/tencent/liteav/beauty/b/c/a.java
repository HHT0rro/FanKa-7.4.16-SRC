package com.tencent.liteav.beauty.b.c;

import androidx.annotation.NonNull;
import com.tencent.liteav.beauty.b.m;
import com.tencent.liteav.videobase.a.h;
import com.tencent.liteav.videobase.frame.e;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a extends h implements com.tencent.liteav.beauty.b.b {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final b f42995a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    private final m f42996b;

    /* renamed from: c, reason: collision with root package name */
    private float f42997c = 0.0f;

    /* renamed from: d, reason: collision with root package name */
    private float f42998d = 0.0f;

    /* renamed from: e, reason: collision with root package name */
    private float f42999e = 0.0f;

    /* renamed from: f, reason: collision with root package name */
    private float f43000f = 0.0f;

    public a() {
        b bVar = new b();
        this.f42995a = bVar;
        m mVar = new m();
        this.f42996b = mVar;
        addFilter(bVar);
        addFilter(mVar);
    }

    @Override // com.tencent.liteav.beauty.b.b
    public final void a(float f10) {
        this.f42997c = f10;
        this.f42995a.a(f10);
    }

    @Override // com.tencent.liteav.beauty.b.b
    public final void b(float f10) {
        this.f42998d = f10;
        this.f42995a.b(f10);
    }

    @Override // com.tencent.liteav.beauty.b.b
    public final void c(float f10) {
        this.f42999e = f10;
        this.f42995a.c(f10);
    }

    @Override // com.tencent.liteav.videobase.a.b
    public final boolean canBeSkipped() {
        return this.f42995a.canBeSkipped() && this.f42996b.canBeSkipped();
    }

    @Override // com.tencent.liteav.beauty.b.b
    public final void d(float f10) {
        this.f43000f = f10;
        this.f42996b.a(f10 / 2.0f);
    }

    @Override // com.tencent.liteav.videobase.a.h, com.tencent.liteav.videobase.a.b
    public final void onInit(e eVar) {
        super.onInit(eVar);
        this.f42995a.a(this.f42997c);
        this.f42995a.b(this.f42998d);
        this.f42995a.c(this.f42999e);
        this.f42996b.a(this.f43000f / 2.0f);
    }
}
