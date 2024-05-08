package com.tencent.liteav.base.b;

import android.os.SystemClock;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public long f42750a = 0;

    /* renamed from: b, reason: collision with root package name */
    private final long f42751b;

    public a(long j10) {
        this.f42751b = j10;
    }

    public final boolean a() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j10 = this.f42750a;
        if (j10 != 0 && elapsedRealtime - j10 <= this.f42751b) {
            return false;
        }
        this.f42750a = SystemClock.elapsedRealtime();
        return true;
    }
}
