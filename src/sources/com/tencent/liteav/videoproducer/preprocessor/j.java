package com.tencent.liteav.videoproducer.preprocessor;

import android.graphics.Bitmap;
import com.tencent.liteav.videoproducer.preprocessor.h;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class j implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final h f44819a;

    /* renamed from: b, reason: collision with root package name */
    private final Bitmap f44820b;

    /* renamed from: c, reason: collision with root package name */
    private final float f44821c;

    /* renamed from: d, reason: collision with root package name */
    private final float f44822d;

    /* renamed from: e, reason: collision with root package name */
    private final float f44823e;

    private j(h hVar, Bitmap bitmap, float f10, float f11, float f12) {
        this.f44819a = hVar;
        this.f44820b = bitmap;
        this.f44821c = f10;
        this.f44822d = f11;
        this.f44823e = f12;
    }

    public static Runnable a(h hVar, Bitmap bitmap, float f10, float f11, float f12) {
        return new j(hVar, bitmap, f10, f11, f12);
    }

    @Override // java.lang.Runnable
    public final void run() {
        h hVar = this.f44819a;
        Bitmap bitmap = this.f44820b;
        float f10 = this.f44821c;
        float f11 = this.f44822d;
        float f12 = this.f44823e;
        if (bitmap == null) {
            hVar.c(h.b.f44809e);
            return;
        }
        com.tencent.liteav.beauty.b.n nVar = (com.tencent.liteav.beauty.b.n) hVar.a(h.b.f44809e);
        nVar.a();
        nVar.a(bitmap, f10, f11, f12);
        com.tencent.liteav.beauty.a.h(hVar.f44782b);
    }
}
