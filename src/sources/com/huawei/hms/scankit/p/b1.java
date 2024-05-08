package com.huawei.hms.scankit.p;

import android.view.animation.Interpolator;
import com.huawei.uikit.hwcommon.anim.HwCubicBezierInterpolator;
import java.math.BigDecimal;

/* compiled from: CubicBezierInterpolator.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class b1 implements Interpolator {

    /* renamed from: e, reason: collision with root package name */
    private static final BigDecimal f30722e;

    /* renamed from: f, reason: collision with root package name */
    private static final BigDecimal f30723f;

    /* renamed from: g, reason: collision with root package name */
    private static final float f30724g;

    /* renamed from: a, reason: collision with root package name */
    private float f30725a;

    /* renamed from: b, reason: collision with root package name */
    private float f30726b;

    /* renamed from: c, reason: collision with root package name */
    private float f30727c;

    /* renamed from: d, reason: collision with root package name */
    private float f30728d;

    static {
        BigDecimal bigDecimal = new BigDecimal(Float.toString(1.0f));
        f30722e = bigDecimal;
        BigDecimal bigDecimal2 = new BigDecimal(Long.toString(HwCubicBezierInterpolator.f34870a));
        f30723f = bigDecimal2;
        f30724g = bigDecimal.divide(bigDecimal2, 20, 4).floatValue();
    }

    public b1(float f10, float f11, float f12, float f13) {
        this.f30725a = f10;
        this.f30726b = f11;
        this.f30727c = f12;
        this.f30728d = f13;
    }

    private long a(float f10) {
        long j10 = 0;
        long j11 = HwCubicBezierInterpolator.f34870a;
        while (j10 <= j11) {
            long j12 = (j10 + j11) >>> 1;
            float b4 = b(f30724g * ((float) j12));
            if (b4 < f10) {
                j10 = j12 + 1;
            } else {
                if (b4 <= f10) {
                    return j12;
                }
                j11 = j12 - 1;
            }
        }
        return j10;
    }

    private float b(float f10) {
        float f11 = 1.0f - f10;
        float f12 = 3.0f * f11;
        return (f11 * f12 * f10 * this.f30725a) + (f12 * f10 * f10 * this.f30727c) + (f10 * f10 * f10);
    }

    private float c(float f10) {
        float f11 = 1.0f - f10;
        float f12 = 3.0f * f11;
        return (f11 * f12 * f10 * this.f30726b) + (f12 * f10 * f10 * this.f30728d) + (f10 * f10 * f10);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f10) {
        return c(f30724g * ((float) a(f10)));
    }

    public String toString() {
        return a();
    }

    private String a() {
        return "CubicBezierInterpolator  mControlPoint1x = " + this.f30725a + ", mControlPoint1y = " + this.f30726b + ", mControlPoint2x = " + this.f30727c + ", mControlPoint2y = " + this.f30728d;
    }
}
