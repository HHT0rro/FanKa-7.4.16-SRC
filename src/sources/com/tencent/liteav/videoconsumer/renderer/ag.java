package com.tencent.liteav.videoconsumer.renderer;

import com.tencent.liteav.videobase.base.GLConstants;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class ag implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final t f44066a;

    /* renamed from: b, reason: collision with root package name */
    private final GLConstants.GLScaleType f44067b;

    private ag(t tVar, GLConstants.GLScaleType gLScaleType) {
        this.f44066a = tVar;
        this.f44067b = gLScaleType;
    }

    public static Runnable a(t tVar, GLConstants.GLScaleType gLScaleType) {
        return new ag(tVar, gLScaleType);
    }

    @Override // java.lang.Runnable
    public final void run() {
        t.a(this.f44066a, this.f44067b);
    }
}
