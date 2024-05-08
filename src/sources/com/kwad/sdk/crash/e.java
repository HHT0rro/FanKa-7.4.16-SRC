package com.kwad.sdk.crash;

import android.content.Context;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.kwad.sdk.crash.c;
import com.kwad.sdk.crash.model.message.ExceptionMessage;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class e {
    private com.kwad.sdk.crash.b.b aFK;
    private c aFL;
    private long aFM;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a {
        private static final e aFN = new e(0);
    }

    public /* synthetic */ e(byte b4) {
        this();
    }

    public static e Hu() {
        return a.aFN;
    }

    public final h HA() {
        return this.aFL.aFl;
    }

    public final long HB() {
        return SystemClock.elapsedRealtime() - this.aFM;
    }

    public final String[] Hv() {
        return this.aFK.HI();
    }

    public final String[] Hw() {
        return this.aFK.Hw();
    }

    public final String Hx() {
        return this.aFL.aFj.aGl;
    }

    public final int Hy() {
        return this.aFL.aFj.aGp;
    }

    public final c Hz() {
        return this.aFL;
    }

    public final void a(@NonNull c cVar) {
        this.aFL = cVar;
        this.aFM = SystemClock.elapsedRealtime();
        this.aFK.a(cVar.aFm, cVar.aFn);
    }

    public final void b(int i10, ExceptionMessage exceptionMessage) {
        f Hq = this.aFL.Hq();
        if (Hq != null) {
            Hq.a(i10, exceptionMessage);
        }
    }

    public final String getAppId() {
        return this.aFL.aFk.aGc;
    }

    public final Context getContext() {
        return this.aFL.context;
    }

    public final String getSdkVersion() {
        return this.aFL.aFj.mSdkVersion;
    }

    public final boolean isDebug() {
        return this.aFL.Hr();
    }

    private e() {
        this.aFK = new com.kwad.sdk.crash.b.b();
        this.aFL = new c.a().Ht();
    }
}
