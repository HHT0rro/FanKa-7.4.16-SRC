package com.tencent.liteav.videoproducer.capture;

import android.graphics.Bitmap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class am implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final ak f44299a;

    /* renamed from: b, reason: collision with root package name */
    private final Bitmap f44300b;

    /* renamed from: c, reason: collision with root package name */
    private final int f44301c;

    /* renamed from: d, reason: collision with root package name */
    private final int f44302d;

    /* renamed from: e, reason: collision with root package name */
    private final int f44303e;

    private am(ak akVar, Bitmap bitmap, int i10, int i11, int i12) {
        this.f44299a = akVar;
        this.f44300b = bitmap;
        this.f44301c = i10;
        this.f44302d = i11;
        this.f44303e = i12;
    }

    public static Runnable a(ak akVar, Bitmap bitmap, int i10, int i11, int i12) {
        return new am(akVar, bitmap, i10, i11, i12);
    }

    @Override // java.lang.Runnable
    public final void run() {
        ak.a(this.f44299a, this.f44300b, this.f44301c, this.f44302d, this.f44303e);
    }
}
