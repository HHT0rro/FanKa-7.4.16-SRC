package com.tencent.liteav.videoproducer.encoder;

import com.tencent.liteav.base.util.LiteavLog;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    private final String f44695a = "FpsThrottler_" + hashCode();

    /* renamed from: b, reason: collision with root package name */
    private int f44696b = 1;

    /* renamed from: c, reason: collision with root package name */
    private long f44697c = -1;

    /* renamed from: d, reason: collision with root package name */
    private int f44698d = 0;

    public final synchronized boolean a(long j10) {
        long j11 = this.f44697c;
        if (j11 != -1 && j10 >= j11) {
            int i10 = (int) ((j10 - j11) / (1000.0d / this.f44696b));
            int i11 = this.f44698d;
            if (i10 > i11 + 10) {
                a();
                return true;
            }
            if (i11 >= i10) {
                return false;
            }
            this.f44698d = i11 + 1;
            return true;
        }
        a();
        this.f44697c = j10;
        return true;
    }

    public final synchronized void a(int i10) {
        if (this.f44696b != i10) {
            LiteavLog.i(this.f44695a, "update fps to ".concat(String.valueOf(i10)));
            this.f44696b = Math.max(i10, 1);
            a();
        }
    }

    private void a() {
        this.f44698d = 0;
        this.f44697c = -1L;
    }
}
