package com.tencent.liteav.videoconsumer.consumer;

import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videoconsumer.consumer.b;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class u implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final b f43764a;

    private u(b bVar) {
        this.f43764a = bVar;
    }

    public static Runnable a(b bVar) {
        return new u(bVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        b bVar = this.f43764a;
        LiteavLog.i(bVar.f43692a, "Start");
        if (bVar.f43710s != b.EnumC0643b.STOPPED) {
            LiteavLog.w(bVar.f43692a, "video consumer is started.");
            return;
        }
        bVar.f43693b.a(15);
        bVar.a(bVar.f43696e);
        if (bVar.f43699h != null) {
            bVar.a(bVar.f43697f);
        }
        bVar.f43698g.a(bVar.C);
        bVar.f43706o.a();
        bVar.f43710s = bVar.f43711t ? b.EnumC0643b.PAUSED : b.EnumC0643b.STARTED;
    }
}
