package com.tencent.liteav.videoconsumer.consumer;

import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videoconsumer.consumer.b;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class x implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final b f43768a;

    private x(b bVar) {
        this.f43768a = bVar;
    }

    public static Runnable a(b bVar) {
        return new x(bVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        b bVar = this.f43768a;
        LiteavLog.i(bVar.f43692a, "resume , current status is " + ((Object) bVar.f43710s));
        if (bVar.f43710s == b.EnumC0643b.PAUSED) {
            bVar.f43710s = b.EnumC0643b.STARTED;
        }
        bVar.f43711t = false;
    }
}
