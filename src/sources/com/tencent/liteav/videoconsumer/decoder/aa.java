package com.tencent.liteav.videoconsumer.decoder;

import android.view.Surface;
import com.tencent.liteav.base.util.LiteavLog;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class aa implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final u f43825a;

    /* renamed from: b, reason: collision with root package name */
    private final Surface f43826b;

    private aa(u uVar, Surface surface) {
        this.f43825a = uVar;
        this.f43826b = surface;
    }

    public static Runnable a(u uVar, Surface surface) {
        return new aa(uVar, surface);
    }

    @Override // java.lang.Runnable
    public final void run() {
        u uVar = this.f43825a;
        Surface surface = this.f43826b;
        if (uVar.f44002c != surface) {
            LiteavLog.i(uVar.f44000a, "setSurface ".concat(String.valueOf(surface)));
            uVar.f44002c = surface;
            ad adVar = uVar.f44003d;
            if (adVar == null || !(adVar instanceof ae)) {
                return;
            }
            ((ae) adVar).a(surface);
        }
    }
}
