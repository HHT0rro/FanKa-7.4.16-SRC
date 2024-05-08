package com.tencent.liteav.videoproducer.producer;

import android.graphics.Bitmap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class ak implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final i f44928a;

    /* renamed from: b, reason: collision with root package name */
    private final Bitmap f44929b;

    /* renamed from: c, reason: collision with root package name */
    private final float f44930c;

    /* renamed from: d, reason: collision with root package name */
    private final float f44931d;

    /* renamed from: e, reason: collision with root package name */
    private final float f44932e;

    private ak(i iVar, Bitmap bitmap, float f10, float f11, float f12) {
        this.f44928a = iVar;
        this.f44929b = bitmap;
        this.f44930c = f10;
        this.f44931d = f11;
        this.f44932e = f12;
    }

    public static Runnable a(i iVar, Bitmap bitmap, float f10, float f11, float f12) {
        return new ak(iVar, bitmap, f10, f11, f12);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f44928a.f44994c.setWatermark(this.f44929b, this.f44930c, this.f44931d, this.f44932e);
    }
}
