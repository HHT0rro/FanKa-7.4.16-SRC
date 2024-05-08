package com.tencent.liteav.videoconsumer.consumer;

import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videoconsumer.consumer.b;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class v implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final b f43765a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f43766b;

    private v(b bVar, boolean z10) {
        this.f43765a = bVar;
        this.f43766b = z10;
    }

    public static Runnable a(b bVar, boolean z10) {
        return new v(bVar, z10);
    }

    @Override // java.lang.Runnable
    public final void run() {
        b bVar = this.f43765a;
        boolean z10 = this.f43766b;
        LiteavLog.i(bVar.f43692a, "Stop");
        b.EnumC0643b enumC0643b = bVar.f43710s;
        b.EnumC0643b enumC0643b2 = b.EnumC0643b.STOPPED;
        if (enumC0643b != enumC0643b2) {
            bVar.f43693b.a(1);
            bVar.f43710s = enumC0643b2;
            bVar.f43707p = false;
            bVar.f43709r.b();
            bVar.f43716y.getAndSet(0L);
            bVar.f43698g.f();
            for (com.tencent.liteav.videoconsumer.renderer.r rVar : bVar.a()) {
                if (rVar != null) {
                    rVar.a(z10);
                    bVar.f43695d.b(rVar instanceof a);
                }
            }
            bVar.f43697f.a();
            bVar.f43717z.b();
            bVar.A.clear();
            bVar.f43715x = null;
            bVar.f43712u = 0;
            bVar.f43713v = 0;
            bVar.f43708q = false;
        }
    }
}
