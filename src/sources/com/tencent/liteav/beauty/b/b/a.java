package com.tencent.liteav.beauty.b.b;

import androidx.annotation.NonNull;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.a.k;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a extends k implements com.tencent.liteav.beauty.b.b {

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    private final d f42969b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    private final e f42970c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    private final c f42971d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    private final b f42972e;

    /* renamed from: f, reason: collision with root package name */
    private float f42973f = 0.1f;

    /* renamed from: g, reason: collision with root package name */
    private float f42974g = 2.0f;

    /* renamed from: h, reason: collision with root package name */
    private int f42975h = 0;

    /* renamed from: i, reason: collision with root package name */
    private int f42976i = 0;

    public a() {
        b bVar = new b();
        this.f42972e = bVar;
        d dVar = new d();
        this.f42969b = dVar;
        e eVar = new e();
        this.f42970c = eVar;
        c cVar = new c();
        this.f42971d = cVar;
        k.a aVar = this.f43263a;
        k.a a10 = a(dVar);
        a10.a(aVar);
        k.a a11 = a(eVar);
        a11.a(a10);
        a11.a("inputImageTexture2", aVar);
        k.a a12 = a(cVar);
        a12.a(a11);
        k.a a13 = a(bVar);
        a13.a(a12);
        a13.a("inputImageTexture2", aVar);
    }

    @Override // com.tencent.liteav.beauty.b.b
    public final void a(float f10) {
        e eVar = this.f42970c;
        LiteavLog.i("SmoothVertical", "setBeautyLevel ".concat(String.valueOf(f10)));
        eVar.f42990b = f10;
        eVar.setFloatOnDraw(eVar.f42989a, f10);
    }

    @Override // com.tencent.liteav.beauty.b.b
    public final void b(float f10) {
        b bVar = this.f42972e;
        LiteavLog.i("BeautyBlend", "setWhitenessLevel ".concat(String.valueOf(f10)));
        bVar.f42979c = f10;
        bVar.setFloatOnDraw(bVar.f42977a, f10);
    }

    @Override // com.tencent.liteav.beauty.b.b
    public final void c(float f10) {
        b bVar = this.f42972e;
        LiteavLog.i("BeautyBlend", "setRuddyLevel ".concat(String.valueOf(f10)));
        bVar.f42980d = f10;
        bVar.setFloatOnDraw(bVar.f42978b, f10 / 2.0f);
    }

    @Override // com.tencent.liteav.videobase.a.b
    public final boolean canBeSkipped() {
        return this.f42970c.canBeSkipped() && this.f42972e.canBeSkipped() && this.f42971d.canBeSkipped();
    }

    @Override // com.tencent.liteav.beauty.b.b
    public final void d(float f10) {
        LiteavLog.i("BeautySmoothFilter", "setSharpenLevel ".concat(String.valueOf(f10)));
        this.f42973f = f10;
        this.f42971d.a(f10 / 1.2f);
    }

    @Override // com.tencent.liteav.videobase.a.k, com.tencent.liteav.videobase.a.b
    public final void onOutputSizeChanged(int i10, int i11) {
        super.onOutputSizeChanged(i10, i11);
        this.f42975h = i10;
        this.f42976i = i11;
        if (Math.abs(this.f42974g - 1.0f) > 1.0E-5d) {
            float f10 = this.f42975h;
            float f11 = this.f42974g;
            this.f42975h = (int) (f10 / f11);
            this.f42976i = (int) (this.f42976i / f11);
        }
        LiteavLog.i("BeautySmoothFilter", "mResampleRatio: %f, mResampleWidth: %d, mResampleHeight: %d", Float.valueOf(this.f42974g), Integer.valueOf(this.f42975h), Integer.valueOf(this.f42976i));
        this.f42969b.onOutputSizeChanged(this.f42975h, this.f42976i);
        this.f42970c.onOutputSizeChanged(this.f42975h, this.f42976i);
    }
}
