package com.tencent.liteav.videoproducer.producer;

import com.tencent.liteav.videobase.base.GLConstants;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class ac implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final i f44911a;

    /* renamed from: b, reason: collision with root package name */
    private final GLConstants.GLScaleType f44912b;

    private ac(i iVar, GLConstants.GLScaleType gLScaleType) {
        this.f44911a = iVar;
        this.f44912b = gLScaleType;
    }

    public static Runnable a(i iVar, GLConstants.GLScaleType gLScaleType) {
        return new ac(iVar, gLScaleType);
    }

    @Override // java.lang.Runnable
    public final void run() {
        i.a(this.f44911a, this.f44912b);
    }
}
