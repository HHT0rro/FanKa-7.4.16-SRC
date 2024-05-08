package com.huawei.uikit.hwcommon.anim;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import com.huawei.appgallery.agd.agdpro.R$styleable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class HwCubicBezierInterpolator implements Interpolator {

    /* renamed from: a, reason: collision with root package name */
    public static final long f34870a = 4000;

    /* renamed from: b, reason: collision with root package name */
    public static final float f34871b = 2.5E-4f;

    /* renamed from: c, reason: collision with root package name */
    public static final String f34872c = "HwCubicBezierInterpolator";

    /* renamed from: d, reason: collision with root package name */
    public static final int f34873d = 3;

    /* renamed from: e, reason: collision with root package name */
    public float f34874e;

    /* renamed from: f, reason: collision with root package name */
    public float f34875f;

    /* renamed from: g, reason: collision with root package name */
    public float f34876g;

    /* renamed from: h, reason: collision with root package name */
    public float f34877h;

    public HwCubicBezierInterpolator(float f10, float f11, float f12, float f13) {
        this.f34874e = f10;
        this.f34875f = f11;
        this.f34876g = f12;
        this.f34877h = f13;
    }

    private float a(TypedValue typedValue) {
        if (typedValue == null) {
            return 1.0f;
        }
        int i10 = typedValue.type;
        if (i10 == 6) {
            return TypedValue.complexToFloat(typedValue.data);
        }
        if (i10 == 4) {
            return typedValue.getFloat();
        }
        if (i10 < 16 || i10 > 31) {
            return 1.0f;
        }
        return typedValue.data;
    }

    private float b(float f10) {
        float f11 = 1.0f - f10;
        float f12 = 3.0f * f11;
        return (f10 * f10 * f10) + (f12 * f10 * f10 * this.f34876g) + (f11 * f12 * f10 * this.f34874e);
    }

    public float getCubicBezierY(float f10) {
        float f11 = 1.0f - f10;
        float f12 = 3.0f * f11;
        return (f10 * f10 * f10) + (f12 * f10 * f10 * this.f34877h) + (f11 * f12 * f10 * this.f34875f);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f10) {
        return getCubicBezierY(((float) a(f10)) * 2.5E-4f);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(f34872c);
        stringBuffer.append("  mControlPoint1x = ");
        stringBuffer.append(this.f34874e);
        stringBuffer.append(", mControlPoint1y = ");
        stringBuffer.append(this.f34875f);
        stringBuffer.append(", mControlPoint2x = ");
        stringBuffer.append(this.f34876g);
        stringBuffer.append(", mControlPoint2y = ");
        stringBuffer.append(this.f34877h);
        return stringBuffer.toString();
    }

    public long a(float f10) {
        long j10 = 0;
        long j11 = f34870a;
        while (j10 <= j11) {
            long j12 = (j10 + j11) >>> 1;
            float b4 = b(((float) j12) * 2.5E-4f);
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

    public HwCubicBezierInterpolator(@NonNull Context context, AttributeSet attributeSet) {
        this(context.getResources(), context.getTheme(), attributeSet);
    }

    public HwCubicBezierInterpolator(@NonNull Resources resources, Resources.Theme theme, AttributeSet attributeSet) {
        TypedArray obtainAttributes;
        this.f34874e = 0.0f;
        this.f34875f = 0.0f;
        this.f34876g = 0.0f;
        this.f34877h = 0.0f;
        if (theme != null) {
            obtainAttributes = theme.obtainStyledAttributes(attributeSet, R$styleable.HwTranslateAnimation, 0, 0);
        } else {
            obtainAttributes = resources.obtainAttributes(attributeSet, R$styleable.HwTranslateAnimation);
        }
        this.f34874e = a(obtainAttributes.peekValue(R$styleable.HwTranslateAnimation_hwFromXDelta));
        this.f34875f = a(obtainAttributes.peekValue(R$styleable.HwTranslateAnimation_hwFromYDelta));
        this.f34876g = a(obtainAttributes.peekValue(R$styleable.HwTranslateAnimation_hwToXDelta));
        this.f34877h = a(obtainAttributes.peekValue(R$styleable.HwTranslateAnimation_hwToYDelta));
        obtainAttributes.recycle();
    }
}
