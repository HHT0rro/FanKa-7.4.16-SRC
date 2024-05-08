package com.tencent.liteav.videoconsumer.consumer;

import android.graphics.PointF;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class q implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final b f43755a;

    /* renamed from: b, reason: collision with root package name */
    private final List f43756b;

    /* renamed from: c, reason: collision with root package name */
    private final List f43757c;

    private q(b bVar, List list, List list2) {
        this.f43755a = bVar;
        this.f43756b = list;
        this.f43757c = list2;
    }

    public static Runnable a(b bVar, List list, List list2) {
        return new q(bVar, list, list2);
    }

    @Override // java.lang.Runnable
    public final void run() {
        b bVar = this.f43755a;
        List<PointF> list = this.f43756b;
        List<PointF> list2 = this.f43757c;
        com.tencent.liteav.videoconsumer.renderer.t tVar = bVar.f43696e;
        if (tVar != null) {
            tVar.a(list, list2);
        }
    }
}
