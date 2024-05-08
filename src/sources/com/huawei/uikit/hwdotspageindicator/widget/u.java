package com.huawei.uikit.hwdotspageindicator.widget;

import android.animation.TimeInterpolator;
import android.os.SystemClock;
import android.util.Pair;
import android.view.View;
import androidx.annotation.NonNull;
import com.huawei.uikit.hwcommon.anim.HwCubicBezierInterpolator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class u {
    public static boolean A = false;

    /* renamed from: a, reason: collision with root package name */
    public static final String f35197a = "HwIndicatorHelper";

    /* renamed from: b, reason: collision with root package name */
    public static final boolean f35198b = false;

    /* renamed from: c, reason: collision with root package name */
    public static final float f35199c = 1.0f;

    /* renamed from: d, reason: collision with root package name */
    public static final float f35200d = 0.0125f;

    /* renamed from: e, reason: collision with root package name */
    public static final float f35201e = 0.225f;

    /* renamed from: f, reason: collision with root package name */
    public static final float f35202f = 0.8f;

    /* renamed from: g, reason: collision with root package name */
    public static final float f35203g = 0.05f;

    /* renamed from: h, reason: collision with root package name */
    public static final float f35204h = 0.33f;

    /* renamed from: i, reason: collision with root package name */
    public static final float f35205i = 0.0f;

    /* renamed from: j, reason: collision with root package name */
    public static final float f35206j = 0.67f;

    /* renamed from: k, reason: collision with root package name */
    public static final float f35207k = 0.2f;

    /* renamed from: l, reason: collision with root package name */
    public static final float f35208l = 0.0f;

    /* renamed from: m, reason: collision with root package name */
    public static final float f35209m = 0.0f;

    /* renamed from: n, reason: collision with root package name */
    public static final float f35210n = 0.1f;

    /* renamed from: o, reason: collision with root package name */
    public static final float f35211o = 0.2f;

    /* renamed from: p, reason: collision with root package name */
    public static final float f35212p = 0.48f;

    /* renamed from: q, reason: collision with root package name */
    public static final float f35213q = 1.0f;

    /* renamed from: r, reason: collision with root package name */
    public static final int f35214r = 10;

    /* renamed from: s, reason: collision with root package name */
    public static final int f35215s = 2;

    /* renamed from: t, reason: collision with root package name */
    public static final int f35216t = 100;

    /* renamed from: u, reason: collision with root package name */
    public static final int f35217u = 5;

    /* renamed from: v, reason: collision with root package name */
    public static final int f35218v = -1;

    /* renamed from: w, reason: collision with root package name */
    public static final long f35219w = 100;

    /* renamed from: x, reason: collision with root package name */
    public static final long f35220x = 200;

    /* renamed from: y, reason: collision with root package name */
    public static long f35221y;

    /* renamed from: z, reason: collision with root package name */
    public static boolean f35222z;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public boolean f35223a = true;

        /* renamed from: b, reason: collision with root package name */
        public float f35224b;

        /* renamed from: c, reason: collision with root package name */
        public float f35225c;

        /* renamed from: d, reason: collision with root package name */
        public float f35226d;

        /* renamed from: e, reason: collision with root package name */
        public float f35227e;

        /* renamed from: f, reason: collision with root package name */
        public float f35228f;

        public void a(boolean z10) {
            this.f35223a = z10;
        }

        public float b() {
            return this.f35225c;
        }

        public float c() {
            return this.f35228f;
        }

        public float d() {
            return this.f35227e;
        }

        public float e() {
            return this.f35226d;
        }

        public boolean f() {
            return this.f35223a;
        }

        public float a() {
            return this.f35224b;
        }

        public void b(float f10) {
            this.f35225c = f10;
        }

        public void c(float f10) {
            this.f35228f = f10;
        }

        public void d(float f10) {
            this.f35227e = f10;
        }

        public void e(float f10) {
            this.f35226d = f10;
        }

        public void a(float f10) {
            this.f35224b = f10;
        }
    }

    public static Pair<Float, Float> a(@NonNull TimeInterpolator timeInterpolator, float f10, int i10, float f11, float f12) {
        return new Pair<>(Float.valueOf((Math.abs(f10) * (0.225f - (Math.min(i10, 10) * 0.0125f)) * f11) + f11), Float.valueOf((((1.0f - timeInterpolator.getInterpolation(f10)) * 0.19999999f) + 0.8f) * f12));
    }

    public static TimeInterpolator b() {
        return new HwCubicBezierInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
    }

    public static TimeInterpolator c() {
        return new HwCubicBezierInterpolator(1.0f, 0.0f, 1.0f, 1.0f);
    }

    public static TimeInterpolator d() {
        return new HwCubicBezierInterpolator(0.1f, 0.2f, 0.48f, 1.0f);
    }

    public static boolean e() {
        return f35222z;
    }

    public static boolean f() {
        return A;
    }

    public static boolean b(@NonNull a aVar, float f10, boolean z10, boolean z11, boolean z12) {
        float a10 = f10 - aVar.a();
        if (Math.abs(a10) < aVar.d()) {
            return false;
        }
        return ((a10 > 0.0f ? 1 : (a10 == 0.0f ? 0 : -1)) > 0 && z12 && !z10) || ((a10 > 0.0f ? 1 : (a10 == 0.0f ? 0 : -1)) < 0 && z11 && !z10) || ((a10 > 0.0f ? 1 : (a10 == 0.0f ? 0 : -1)) < 0 && z12 && z10) || ((a10 > 0.0f ? 1 : (a10 == 0.0f ? 0 : -1)) > 0 && z11 && z10);
    }

    public static int a(int i10, float f10) {
        return (int) ((((0.225f - (Math.min(i10, 10) * 0.0125f)) * 2.0f) + 1.0f) * f10);
    }

    public static float a(float f10, float f11) {
        float f12 = (f11 * 0.05f) + f10;
        if (Float.compare(f12, 1.0f) >= 0) {
            return 0.95f;
        }
        return f12;
    }

    public static float a(TimeInterpolator timeInterpolator, TimeInterpolator timeInterpolator2) {
        float f10 = 0.0f;
        if (timeInterpolator != null && timeInterpolator2 != null) {
            float f11 = 0.0f;
            for (int i10 = 0; i10 < 100; i10 += 5) {
                float f12 = i10 / 100.0f;
                float abs = Math.abs(timeInterpolator.getInterpolation(f12) - timeInterpolator2.getInterpolation(f12));
                if (abs > f11) {
                    f10 = f12;
                    f11 = abs;
                }
            }
        }
        return f10;
    }

    public static TimeInterpolator a() {
        return new HwCubicBezierInterpolator(0.2f, 0.0f, 1.0f, 1.0f);
    }

    public static boolean a(@NonNull a aVar, float f10, boolean z10, boolean z11, boolean z12) {
        float a10 = f10 - aVar.a();
        return (!z10 && z12 && (a10 > 0.0f ? 1 : (a10 == 0.0f ? 0 : -1)) > 0) || (z10 && z12 && (a10 > 0.0f ? 1 : (a10 == 0.0f ? 0 : -1)) < 0) || (!z10 && z11 && (a10 > 0.0f ? 1 : (a10 == 0.0f ? 0 : -1)) < 0) || (z10 && z11 && (a10 > 0.0f ? 1 : (a10 == 0.0f ? 0 : -1)) > 0);
    }

    public static boolean a(@NonNull t tVar, boolean z10, float f10, float f11) {
        float m10 = tVar.m();
        float n10 = tVar.n();
        float k10 = tVar.k();
        float j10 = tVar.j();
        return z10 ? f10 >= k10 && f10 < m10 && f11 >= n10 && f11 < j10 : f10 >= m10 && f10 < k10 && f11 >= n10 && f11 < j10;
    }

    public static int a(@NonNull t tVar, float f10, float f11, float f12, float f13) {
        float[] d10 = tVar.d();
        if (d10 == null) {
            return -1;
        }
        int length = d10.length;
        for (int i10 = 0; i10 < length; i10++) {
            float sqrt = (float) Math.sqrt(Math.pow(tVar.c() - f13, 2.0d) + Math.pow(d10[i10] - f12, 2.0d));
            if ((tVar.A() == i10 && Float.compare(sqrt, f10) <= 0) || Float.compare(sqrt, f11) <= 0) {
                return i10;
            }
        }
        return -1;
    }

    public static void a(boolean z10) {
        long uptimeMillis = SystemClock.uptimeMillis();
        long j10 = f35221y;
        if (j10 == 0) {
            f35221y = uptimeMillis;
            return;
        }
        if (!z10) {
            f35222z = false;
            A = false;
            return;
        }
        if (uptimeMillis - j10 < 200) {
            A = true;
        } else {
            A = false;
        }
        if (uptimeMillis - j10 < 100) {
            f35222z = true;
        } else {
            f35222z = false;
        }
        f35221y = uptimeMillis;
    }

    public static Pair<Integer, Integer> a(int i10, int i11, int i12, int i13) {
        int size = View.MeasureSpec.getSize(i10);
        if (View.MeasureSpec.getMode(i10) != Integer.MIN_VALUE) {
            i12 = size;
        }
        int size2 = View.MeasureSpec.getSize(i11);
        int mode = View.MeasureSpec.getMode(i11);
        if (mode == Integer.MIN_VALUE || mode == 0) {
            i13 = Math.min(size2, i13);
        } else if (mode == 1073741824) {
            i13 = size2;
        }
        return new Pair<>(Integer.valueOf(i12), Integer.valueOf(i13));
    }
}
