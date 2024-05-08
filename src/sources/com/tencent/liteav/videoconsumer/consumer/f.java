package com.tencent.liteav.videoconsumer.consumer;

import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Rotation;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final b f43733a;

    /* renamed from: b, reason: collision with root package name */
    private final Rotation f43734b;

    private f(b bVar, Rotation rotation) {
        this.f43733a = bVar;
        this.f43734b = rotation;
    }

    public static Runnable a(b bVar, Rotation rotation) {
        return new f(bVar, rotation);
    }

    @Override // java.lang.Runnable
    public final void run() {
        b bVar = this.f43733a;
        Rotation rotation = this.f43734b;
        LiteavLog.i(bVar.f43692a, "setRenderRotation: ".concat(String.valueOf(rotation)));
        bVar.f43704m = rotation;
        for (com.tencent.liteav.videoconsumer.renderer.r rVar : bVar.a()) {
            if (rVar != null) {
                rVar.a(bVar.f43704m);
            }
        }
    }
}
