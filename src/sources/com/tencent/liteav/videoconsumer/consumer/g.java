package com.tencent.liteav.videoconsumer.consumer;

import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.base.GLConstants;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final b f43735a;

    /* renamed from: b, reason: collision with root package name */
    private final GLConstants.GLScaleType f43736b;

    private g(b bVar, GLConstants.GLScaleType gLScaleType) {
        this.f43735a = bVar;
        this.f43736b = gLScaleType;
    }

    public static Runnable a(b bVar, GLConstants.GLScaleType gLScaleType) {
        return new g(bVar, gLScaleType);
    }

    @Override // java.lang.Runnable
    public final void run() {
        b bVar = this.f43735a;
        GLConstants.GLScaleType gLScaleType = this.f43736b;
        LiteavLog.i(bVar.f43692a, "setScaleType: ".concat(String.valueOf(gLScaleType)));
        bVar.f43703l = gLScaleType;
        for (com.tencent.liteav.videoconsumer.renderer.r rVar : bVar.a()) {
            if (rVar != null) {
                rVar.a(gLScaleType);
            }
        }
    }
}
