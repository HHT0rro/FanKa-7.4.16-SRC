package com.autonavi.aps.amapapi.restruct;

import android.content.Context;
import android.os.Handler;

/* compiled from: CellAgeEstimator.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class c extends a<d> {
    public c(Context context, String str, Handler handler) {
        super(context, str, handler);
    }

    @Override // com.autonavi.aps.amapapi.restruct.a
    public final /* bridge */ /* synthetic */ void a(d dVar, long j10) {
        a2(dVar, j10);
    }

    @Override // com.autonavi.aps.amapapi.restruct.a
    public final /* synthetic */ String b(d dVar) {
        return a(dVar);
    }

    @Override // com.autonavi.aps.amapapi.restruct.a
    public final /* synthetic */ int c(d dVar) {
        return b2(dVar);
    }

    @Override // com.autonavi.aps.amapapi.restruct.a
    public final /* synthetic */ long d(d dVar) {
        return c2(dVar);
    }

    private static String a(d dVar) {
        return dVar == null ? "" : dVar.b();
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static int b2(d dVar) {
        if (dVar == null) {
            return 99;
        }
        return dVar.f9447s;
    }

    /* renamed from: c, reason: avoid collision after fix types in other method */
    private static long c2(d dVar) {
        if (dVar == null) {
            return 0L;
        }
        return dVar.f9448t;
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(d dVar, long j10) {
        if (dVar != null) {
            dVar.f9448t = j10;
        }
    }

    @Override // com.autonavi.aps.amapapi.restruct.a
    public final long b() {
        return com.autonavi.aps.amapapi.config.a.f9367g;
    }

    @Override // com.autonavi.aps.amapapi.restruct.a
    public final long c() {
        return com.autonavi.aps.amapapi.config.a.f9368h;
    }
}
