package com.huawei.quickcard;

import android.graphics.PointF;
import android.view.animation.Interpolator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class b1 implements Interpolator {

    /* renamed from: a, reason: collision with root package name */
    private PointF f33276a;

    /* renamed from: b, reason: collision with root package name */
    private PointF f33277b;

    /* renamed from: c, reason: collision with root package name */
    private PointF f33278c;

    /* renamed from: d, reason: collision with root package name */
    private PointF f33279d;

    /* renamed from: e, reason: collision with root package name */
    private PointF f33280e;

    public b1(float f10, float f11, float f12, float f13) {
        this(new PointF(f10, f11), new PointF(f12, f13));
    }

    private float a(float f10) {
        PointF pointF = this.f33278c;
        PointF pointF2 = this.f33279d;
        float f11 = pointF2.y * 3.0f;
        pointF.y = f11;
        PointF pointF3 = this.f33277b;
        float f12 = ((this.f33280e.y - pointF2.y) * 3.0f) - f11;
        pointF3.y = f12;
        PointF pointF4 = this.f33276a;
        float f13 = (1.0f - pointF.y) - f12;
        pointF4.y = f13;
        return (pointF.y + ((pointF3.y + (f13 * f10)) * f10)) * f10;
    }

    private float b(float f10) {
        PointF pointF = this.f33278c;
        PointF pointF2 = this.f33279d;
        float f11 = pointF2.x * 3.0f;
        pointF.x = f11;
        PointF pointF3 = this.f33277b;
        float f12 = ((this.f33280e.x - pointF2.x) * 3.0f) - f11;
        pointF3.x = f12;
        PointF pointF4 = this.f33276a;
        float f13 = (1.0f - pointF.x) - f12;
        pointF4.x = f13;
        return (pointF.x + ((pointF3.x + (f13 * f10)) * f10)) * f10;
    }

    private float c(float f10) {
        return this.f33278c.x + (((this.f33277b.x * 2.0f) + (this.f33276a.x * 3.0f * f10)) * f10);
    }

    private float d(float f10) {
        float f11 = f10;
        for (int i10 = 1; i10 < 14; i10++) {
            float b4 = b(f11) - f10;
            if (Math.abs(b4) * 1.0f < 0.001d) {
                return f11;
            }
            f11 -= b4 / c(f11);
        }
        return f11;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f10) {
        return a(d(f10));
    }

    public b1(PointF pointF, PointF pointF2) throws IllegalArgumentException {
        float f10 = pointF.x;
        if (f10 >= 0.0f && f10 <= 1.0f) {
            float f11 = pointF2.x;
            if (f11 >= 0.0f && f11 <= 1.0f) {
                this.f33276a = new PointF();
                this.f33277b = new PointF();
                this.f33278c = new PointF();
                this.f33279d = pointF;
                this.f33280e = pointF2;
                return;
            }
            throw new IllegalArgumentException("endX value must be in the range [0, 1]");
        }
        throw new IllegalArgumentException("startX value must be in the range [0, 1]");
    }
}
