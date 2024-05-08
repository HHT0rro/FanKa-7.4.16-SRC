package com.tencent.liteav.videoproducer.preprocessor;

import android.graphics.Bitmap;
import com.tencent.liteav.videoproducer.preprocessor.h;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class n implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final h f44830a;

    /* renamed from: b, reason: collision with root package name */
    private final Bitmap f44831b;

    /* renamed from: c, reason: collision with root package name */
    private final Bitmap f44832c;

    /* renamed from: d, reason: collision with root package name */
    private final float f44833d;

    /* renamed from: e, reason: collision with root package name */
    private final float f44834e;

    /* renamed from: f, reason: collision with root package name */
    private final float f44835f;

    private n(h hVar, Bitmap bitmap, Bitmap bitmap2, float f10, float f11, float f12) {
        this.f44830a = hVar;
        this.f44831b = bitmap;
        this.f44832c = bitmap2;
        this.f44833d = f10;
        this.f44834e = f11;
        this.f44835f = f12;
    }

    public static Runnable a(h hVar, Bitmap bitmap, Bitmap bitmap2, float f10, float f11, float f12) {
        return new n(hVar, bitmap, bitmap2, f10, f11, f12);
    }

    @Override // java.lang.Runnable
    public final void run() {
        h hVar = this.f44830a;
        Bitmap bitmap = this.f44831b;
        Bitmap bitmap2 = this.f44832c;
        float f10 = this.f44833d;
        float f11 = this.f44834e;
        float f12 = this.f44835f;
        if (bitmap == null && bitmap2 == null) {
            hVar.c(h.b.f44807c);
        } else {
            ((com.tencent.liteav.beauty.b.i) hVar.a(h.b.f44807c)).a(f10, bitmap, f11, bitmap2, f12);
            com.tencent.liteav.beauty.a.f(hVar.f44782b);
        }
    }
}
