package com.vivo.push;

import android.os.SystemClock;

/* compiled from: RequestFrequencyControl.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class y {

    /* renamed from: a, reason: collision with root package name */
    private volatile long f46465a = -1;

    public final synchronized boolean a() {
        boolean z10;
        long j10 = this.f46465a;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        z10 = j10 != -1 && elapsedRealtime > j10 && elapsedRealtime < j10 + 2000;
        this.f46465a = SystemClock.elapsedRealtime();
        return z10;
    }
}
