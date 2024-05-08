package com.autonavi.aps.amapapi.restruct;

import android.content.Context;
import android.os.Handler;
import com.amap.api.col.p0003l.ks;

/* compiled from: WifiAgeEstimator.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class i extends a<ks> {
    public i(Context context, String str, Handler handler) {
        super(context, str, handler);
    }

    @Override // com.autonavi.aps.amapapi.restruct.a
    public final /* bridge */ /* synthetic */ void a(ks ksVar, long j10) {
        a2(ksVar, j10);
    }

    @Override // com.autonavi.aps.amapapi.restruct.a
    public final /* synthetic */ String b(ks ksVar) {
        return a(ksVar);
    }

    @Override // com.autonavi.aps.amapapi.restruct.a
    public final /* synthetic */ int c(ks ksVar) {
        return b2(ksVar);
    }

    @Override // com.autonavi.aps.amapapi.restruct.a
    public final /* synthetic */ long d(ks ksVar) {
        return c2(ksVar);
    }

    private static String a(ks ksVar) {
        return ksVar == null ? "" : ksVar.a();
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static int b2(ks ksVar) {
        if (ksVar == null) {
            return -113;
        }
        return ksVar.f6687c;
    }

    /* renamed from: c, reason: avoid collision after fix types in other method */
    private static long c2(ks ksVar) {
        if (ksVar == null) {
            return 0L;
        }
        return ksVar.f6690f;
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(ks ksVar, long j10) {
        if (ksVar != null) {
            ksVar.f6690f = j10;
        }
    }

    @Override // com.autonavi.aps.amapapi.restruct.a
    public final long b() {
        return com.autonavi.aps.amapapi.config.a.f9365e;
    }

    @Override // com.autonavi.aps.amapapi.restruct.a
    public final long c() {
        return com.autonavi.aps.amapapi.config.a.f9366f;
    }
}
