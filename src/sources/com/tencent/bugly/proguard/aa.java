package com.tencent.bugly.proguard;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;

/* compiled from: BUGLY */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class aa implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final Handler f39998a;

    /* renamed from: b, reason: collision with root package name */
    private final String f39999b;

    /* renamed from: c, reason: collision with root package name */
    private long f40000c;

    /* renamed from: d, reason: collision with root package name */
    private final long f40001d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f40002e = true;

    /* renamed from: f, reason: collision with root package name */
    private long f40003f;

    public aa(Handler handler, String str, long j10) {
        this.f39998a = handler;
        this.f39999b = str;
        this.f40000c = j10;
        this.f40001d = j10;
    }

    public final void a() {
        if (this.f40002e) {
            this.f40002e = false;
            this.f40003f = SystemClock.uptimeMillis();
            this.f39998a.post(this);
        }
    }

    public final boolean b() {
        return !this.f40002e && SystemClock.uptimeMillis() > this.f40003f + this.f40000c;
    }

    public final int c() {
        if (this.f40002e) {
            return 0;
        }
        return SystemClock.uptimeMillis() - this.f40003f < this.f40000c ? 1 : 3;
    }

    public final String d() {
        return this.f39999b;
    }

    public final Looper e() {
        return this.f39998a.getLooper();
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f40002e = true;
        this.f40000c = this.f40001d;
    }

    public final void a(long j10) {
        this.f40000c = Long.MAX_VALUE;
    }
}
