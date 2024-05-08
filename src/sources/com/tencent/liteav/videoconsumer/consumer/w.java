package com.tencent.liteav.videoconsumer.consumer;

import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videoconsumer.consumer.b;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class w implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final b f43767a;

    private w(b bVar) {
        this.f43767a = bVar;
    }

    public static Runnable a(b bVar) {
        return new w(bVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        b bVar = this.f43767a;
        LiteavLog.i(bVar.f43692a, "pause , current status is " + ((Object) bVar.f43710s));
        bVar.f43710s = b.EnumC0643b.PAUSED;
        bVar.f43711t = true;
    }
}
