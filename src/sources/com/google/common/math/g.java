package com.google.common.math;

import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.google.common.primitives.Doubles;
import java.util.Iterator;

/* compiled from: StatsAccumulator.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public long f26703a = 0;

    /* renamed from: b, reason: collision with root package name */
    public double f26704b = ShadowDrawableWrapper.COS_45;

    /* renamed from: c, reason: collision with root package name */
    public double f26705c = ShadowDrawableWrapper.COS_45;

    /* renamed from: d, reason: collision with root package name */
    public double f26706d = Double.NaN;

    /* renamed from: e, reason: collision with root package name */
    public double f26707e = Double.NaN;

    public static double g(double d10, double d11) {
        if (Doubles.f(d10)) {
            return d11;
        }
        if (Doubles.f(d11) || d10 == d11) {
            return d10;
        }
        return Double.NaN;
    }

    public void a(double d10) {
        long j10 = this.f26703a;
        if (j10 == 0) {
            this.f26703a = 1L;
            this.f26704b = d10;
            this.f26706d = d10;
            this.f26707e = d10;
            if (Doubles.f(d10)) {
                return;
            }
            this.f26705c = Double.NaN;
            return;
        }
        this.f26703a = j10 + 1;
        if (Doubles.f(d10) && Doubles.f(this.f26704b)) {
            double d11 = this.f26704b;
            double d12 = d10 - d11;
            double d13 = d11 + (d12 / this.f26703a);
            this.f26704b = d13;
            this.f26705c += d12 * (d10 - d13);
        } else {
            this.f26704b = g(this.f26704b, d10);
            this.f26705c = Double.NaN;
        }
        this.f26706d = Math.min(this.f26706d, d10);
        this.f26707e = Math.max(this.f26707e, d10);
    }

    public void b(Iterable<? extends Number> iterable) {
        Iterator<? extends Number> iterator2 = iterable.iterator2();
        while (iterator2.hasNext()) {
            a(iterator2.next().doubleValue());
        }
    }

    public void c(Iterator<? extends Number> it) {
        while (it.hasNext()) {
            a(it.next().doubleValue());
        }
    }

    public void d(double... dArr) {
        for (double d10 : dArr) {
            a(d10);
        }
    }

    public void e(int... iArr) {
        for (int i10 : iArr) {
            a(i10);
        }
    }

    public void f(long... jArr) {
        for (long j10 : jArr) {
            a(j10);
        }
    }

    public Stats h() {
        return new Stats(this.f26703a, this.f26704b, this.f26705c, this.f26706d, this.f26707e);
    }
}
