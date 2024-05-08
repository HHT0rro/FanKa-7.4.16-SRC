package com.tencent.liteav.videoproducer.preprocessor;

import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videoproducer.preprocessor.h;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class p implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final h f44839a;

    /* renamed from: b, reason: collision with root package name */
    private final GLConstants.GLScaleType f44840b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f44841c;

    private p(h hVar, GLConstants.GLScaleType gLScaleType, boolean z10) {
        this.f44839a = hVar;
        this.f44840b = gLScaleType;
        this.f44841c = z10;
    }

    public static Runnable a(h hVar, GLConstants.GLScaleType gLScaleType, boolean z10) {
        return new p(hVar, gLScaleType, z10);
    }

    @Override // java.lang.Runnable
    public final void run() {
        h hVar = this.f44839a;
        GLConstants.GLScaleType gLScaleType = this.f44840b;
        boolean z10 = this.f44841c;
        com.tencent.liteav.beauty.b.h hVar2 = (com.tencent.liteav.beauty.b.h) hVar.b(h.b.f44808d);
        if (hVar2 != null) {
            hVar2.f43029a = gLScaleType;
            hVar2.f43030b = z10;
        }
    }
}
