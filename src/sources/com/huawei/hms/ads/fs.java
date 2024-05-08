package com.huawei.hms.ads;

import android.view.animation.Interpolator;
import com.huawei.uikit.hwcommon.anim.HwCubicBezierInterpolator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class fs implements Interpolator {
    public float B;
    public float C;
    public float S;
    public float Z;

    public fs(float f10, float f11, float f12, float f13) {
        this.Z = f10;
        this.B = f11;
        this.C = f12;
        this.S = f13;
        gl.Code("CubicBezierInterpolator", toString());
    }

    private float I(float f10) {
        float f11 = 1.0f - f10;
        float f12 = 3.0f * f11;
        return (f11 * f12 * f10 * this.Z) + (f12 * f10 * f10 * this.C) + (f10 * f10 * f10);
    }

    public float Code(float f10) {
        float f11 = 1.0f - f10;
        float f12 = 3.0f * f11;
        return (f11 * f12 * f10 * this.B) + (f12 * f10 * f10 * this.S) + (f10 * f10 * f10);
    }

    public long V(float f10) {
        long j10 = 0;
        long j11 = HwCubicBezierInterpolator.f34870a;
        while (j10 <= j11) {
            long j12 = (j10 + j11) >>> 1;
            float I = I(((float) j12) * 2.5E-4f);
            if (I < f10) {
                j10 = j12 + 1;
            } else {
                if (I <= f10) {
                    return j12;
                }
                j11 = j12 - 1;
            }
        }
        return j10;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f10) {
        return Code(((float) V(f10)) * 2.5E-4f);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("CubicBezierInterpolator");
        stringBuffer.append("  mControlPoint1x = ");
        stringBuffer.append(this.Z);
        stringBuffer.append(", mControlPoint1y = ");
        stringBuffer.append(this.B);
        stringBuffer.append(", mControlPoint2x = ");
        stringBuffer.append(this.C);
        stringBuffer.append(", mControlPoint2y = ");
        stringBuffer.append(this.S);
        return stringBuffer.toString();
    }
}
