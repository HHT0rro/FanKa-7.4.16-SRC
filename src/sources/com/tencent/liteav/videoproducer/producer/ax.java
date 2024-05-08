package com.tencent.liteav.videoproducer.producer;

import android.graphics.Bitmap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class ax implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final i f44969a;

    /* renamed from: b, reason: collision with root package name */
    private final Bitmap f44970b;

    /* renamed from: c, reason: collision with root package name */
    private final int f44971c;

    private ax(i iVar, Bitmap bitmap, int i10) {
        this.f44969a = iVar;
        this.f44970b = bitmap;
        this.f44971c = i10;
    }

    public static Runnable a(i iVar, Bitmap bitmap, int i10) {
        return new ax(iVar, bitmap, i10);
    }

    @Override // java.lang.Runnable
    public final void run() {
        i.a(this.f44969a, this.f44970b, this.f44971c);
    }
}
