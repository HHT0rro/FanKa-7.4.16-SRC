package com.tencent.liteav.videoconsumer.consumer;

import com.tencent.liteav.base.util.LiteavLog;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final b f43731a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f43732b;

    private e(b bVar, boolean z10) {
        this.f43731a = bVar;
        this.f43732b = z10;
    }

    public static Runnable a(b bVar, boolean z10) {
        return new e(bVar, z10);
    }

    @Override // java.lang.Runnable
    public final void run() {
        b bVar = this.f43731a;
        boolean z10 = this.f43732b;
        LiteavLog.i(bVar.f43692a, "setRenderMirrorEnabled: ".concat(String.valueOf(z10)));
        bVar.f43705n = z10;
        for (com.tencent.liteav.videoconsumer.renderer.r rVar : bVar.a()) {
            if (rVar != null) {
                rVar.b(bVar.f43705n);
            }
        }
    }
}
