package com.tencent.liteav.videobase.utils;

import android.os.SystemClock;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private final String f43490a;

    /* renamed from: c, reason: collision with root package name */
    private long f43492c;

    /* renamed from: d, reason: collision with root package name */
    private long f43493d;

    /* renamed from: e, reason: collision with root package name */
    private long f43494e;

    /* renamed from: f, reason: collision with root package name */
    private final a f43495f;

    /* renamed from: g, reason: collision with root package name */
    private double f43496g = ShadowDrawableWrapper.COS_45;

    /* renamed from: b, reason: collision with root package name */
    private final int f43491b = (int) Math.max(1000L, TimeUnit.SECONDS.toMillis(1));

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface a {
        void a(double d10);
    }

    public f(String str, a aVar) {
        this.f43490a = str + "(" + hashCode() + ")";
        b();
        this.f43495f = aVar;
    }

    public final void a() {
        this.f43492c++;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j10 = this.f43494e;
        if (j10 == 0) {
            this.f43494e = SystemClock.elapsedRealtime();
            return;
        }
        if (elapsedRealtime - j10 >= this.f43491b) {
            long j11 = this.f43492c;
            double d10 = (((float) (j11 - this.f43493d)) * 1000.0f) / ((float) (elapsedRealtime - j10));
            this.f43496g = d10;
            this.f43494e = elapsedRealtime;
            this.f43493d = j11;
            a aVar = this.f43495f;
            if (aVar != null) {
                aVar.a(d10);
            }
        }
    }

    public final void b() {
        this.f43492c = 0L;
        this.f43493d = 0L;
        this.f43494e = 0L;
    }
}
