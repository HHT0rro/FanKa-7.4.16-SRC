package com.huawei.uikit.hwclickanimation.anim;

import android.view.View;
import android.view.animation.AnimationUtils;
import com.huawei.dynamicanimation.DynamicAnimation;
import com.huawei.dynamicanimation.SpringModelBase;
import com.huawei.dynamicanimation.interpolator.FlingInterpolator;
import com.huawei.dynamicanimation.interpolator.SpringInterpolator;
import com.huawei.dynamicanimation.util.DynamicCurveRate;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class HwSpringBackHelper {

    /* renamed from: a, reason: collision with root package name */
    public static final String f34838a = "HwSpringBackHelper";

    /* renamed from: b, reason: collision with root package name */
    public static final float f34839b = 228.0f;

    /* renamed from: c, reason: collision with root package name */
    public static final float f34840c = 30.0f;

    /* renamed from: d, reason: collision with root package name */
    public static final float f34841d = 0.5f;

    /* renamed from: e, reason: collision with root package name */
    public static final float f34842e = 0.5f;

    /* renamed from: f, reason: collision with root package name */
    public static final float f34843f = 1000.0f;

    /* renamed from: g, reason: collision with root package name */
    public static final int f34844g = 0;

    /* renamed from: h, reason: collision with root package name */
    public static final int f34845h = 1;

    /* renamed from: i, reason: collision with root package name */
    public static final int f34846i = 2;

    /* renamed from: j, reason: collision with root package name */
    public static final int f34847j = 3;

    /* renamed from: k, reason: collision with root package name */
    public static final long f34848k = -1;

    /* renamed from: l, reason: collision with root package name */
    public static final float f34849l = 1.0f;

    /* renamed from: m, reason: collision with root package name */
    public static final float f34850m = -1.0f;

    /* renamed from: n, reason: collision with root package name */
    public static final float f34851n = 0.5f;

    /* renamed from: o, reason: collision with root package name */
    public static final float f34852o = 1.0E-6f;
    public int A;
    public int B;
    public View C;
    public int D;

    /* renamed from: q, reason: collision with root package name */
    public int f34854q;

    /* renamed from: r, reason: collision with root package name */
    public int f34855r;

    /* renamed from: s, reason: collision with root package name */
    public int f34856s;

    /* renamed from: t, reason: collision with root package name */
    public long f34857t;

    /* renamed from: u, reason: collision with root package name */
    public long f34858u;

    /* renamed from: x, reason: collision with root package name */
    public FlingInterpolator f34861x;

    /* renamed from: y, reason: collision with root package name */
    public float f34862y;

    /* renamed from: z, reason: collision with root package name */
    public a f34863z;

    /* renamed from: p, reason: collision with root package name */
    public SpringInterpolator f34853p = null;

    /* renamed from: v, reason: collision with root package name */
    public boolean f34859v = true;

    /* renamed from: w, reason: collision with root package name */
    public int f34860w = 0;
    public double E = 1.0d;
    public float F = -1.0f;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class a extends SpringModelBase {

        /* renamed from: a, reason: collision with root package name */
        public static final float f34864a = 0.001f;

        /* renamed from: b, reason: collision with root package name */
        public float f34865b;

        /* renamed from: c, reason: collision with root package name */
        public float f34866c;

        /* renamed from: d, reason: collision with root package name */
        public float f34867d;

        /* renamed from: e, reason: collision with root package name */
        public float f34868e;
        public long mStartTime;

        public a(float f10, float f11, float f12, float f13, float f14) {
            super(f10, f11, 0.001f);
            this.f34866c = f12;
            this.f34867d = f12;
            this.f34868e = f13;
            this.f34865b = f14;
            setValueThreshold(0.5f);
            snap(0.0f);
            setEndPosition(this.f34868e - this.f34866c, f14, -1L);
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
        }

        public boolean a() {
            float currentAnimationTimeMillis = ((float) (AnimationUtils.currentAnimationTimeMillis() - this.mStartTime)) / 1000.0f;
            this.f34865b = getVelocity(currentAnimationTimeMillis);
            float position = getPosition(currentAnimationTimeMillis);
            float f10 = this.f34866c;
            float f11 = position + f10;
            this.f34867d = f11;
            if (!isAtEquilibrium(f11 - f10, this.f34865b)) {
                return false;
            }
            this.f34867d = getEndPosition() + this.f34866c;
            this.f34865b = 0.0f;
            return true;
        }
    }

    private boolean a(double d10, double d11) {
        return Math.abs(d10 - d11) < 9.999999974752427E-7d;
    }

    public void abortAnimation() {
        this.f34860w = 0;
        this.f34862y = 0.0f;
        this.f34859v = true;
    }

    public boolean computeScrollOffset() {
        boolean z10;
        if (this.f34859v) {
            return false;
        }
        if (this.f34860w == 3) {
            a aVar = this.f34863z;
            if (aVar != null) {
                this.f34859v = aVar.a();
                this.f34855r = (int) this.f34863z.f34867d;
                this.f34862y = this.f34863z.f34865b;
            } else {
                this.f34859v = true;
            }
            if (this.f34859v) {
                abortAnimation();
            }
            z10 = this.f34859v;
        } else {
            if (this.f34858u <= 0) {
                abortAnimation();
                return false;
            }
            float currentAnimationTimeMillis = ((float) (AnimationUtils.currentAnimationTimeMillis() - this.f34857t)) / ((float) this.f34858u);
            if (currentAnimationTimeMillis <= 1.0f) {
                this.f34859v = false;
                if (this.f34860w == 2) {
                    this.f34855r = this.f34854q + ((int) (this.f34861x.getInterpolateData(currentAnimationTimeMillis).getX() * this.E));
                    float v2 = this.f34861x.getInterpolateData(currentAnimationTimeMillis).getV();
                    this.f34862y = v2;
                    int i10 = this.f34855r;
                    int i11 = this.A;
                    if (i10 <= i11 && v2 < 0.0f) {
                        this.D = i10 - i11;
                        overFling(this.C, i11);
                    } else {
                        int i12 = this.B;
                        if (i10 >= i12 && v2 > 0.0f) {
                            this.D = i10 - i12;
                            overFling(this.C, i12);
                        }
                    }
                } else {
                    this.f34855r = (int) (this.f34854q - (this.f34853p.getInterpolation(currentAnimationTimeMillis) * (this.f34854q - this.f34856s)));
                }
            } else {
                this.f34855r = this.f34856s;
                abortAnimation();
            }
            z10 = this.f34859v;
        }
        return !z10;
    }

    public void fling(View view, int i10, int i11, int i12, int i13) {
        if (i11 == 0) {
            abortAnimation();
            return;
        }
        this.f34860w = 2;
        if (Float.compare(this.F, -1.0f) == 0) {
            this.f34861x = new FlingInterpolator(i11, 0.5f);
        } else {
            this.f34861x = new FlingInterpolator(i11, this.F);
        }
        this.f34858u = this.f34861x.getDuration();
        this.f34859v = false;
        this.f34857t = AnimationUtils.currentAnimationTimeMillis();
        this.f34855r = i10;
        this.f34854q = i10;
        this.A = i12;
        this.B = i13;
        this.C = view;
        this.f34862y = i11;
        this.D = 0;
        this.f34856s = (int) (this.f34861x.getEndOffset() + i10 + 0.5f);
    }

    public float getCurrVelocity() {
        return this.f34862y;
    }

    public int getCurrentOffset() {
        return this.f34855r;
    }

    public int getDynamicCurvedRateDelta(int i10, int i11, int i12) {
        return Math.round(new DynamicCurveRate(i10 * 0.5f).getRate(Math.abs(i12)) * i11);
    }

    public int getFinalPositon() {
        return this.f34856s;
    }

    public float getFriction() {
        return this.F;
    }

    public int getStartPosition() {
        return this.f34854q;
    }

    public boolean isFinished() {
        return this.f34859v;
    }

    public void overFling(View view, int i10) {
        this.f34860w = 3;
        this.f34855r = i10;
        if (this.C == null) {
            if (view == null) {
                abortAnimation();
                return;
            }
            this.C = view;
        }
        if (this.f34862y == 0.0f) {
            abortAnimation();
            return;
        }
        float f10 = this.D;
        if (this.C != null) {
            f10 += r0.getScrollY();
        }
        this.f34863z = new a(228.0f, 30.0f, f10, i10, this.f34862y);
        this.f34855r = (int) f10;
        this.f34859v = false;
    }

    public void setFactor(double d10) {
        this.E = d10;
        this.f34856s = ((int) Math.round((this.f34856s - this.f34854q) * d10)) + this.f34854q;
    }

    public void setFriction(float f10) {
        this.F = f10;
    }

    public boolean springBack(int i10, int i11, int i12) {
        this.f34860w = 1;
        int i13 = 0;
        this.f34859v = false;
        this.f34857t = AnimationUtils.currentAnimationTimeMillis();
        this.f34854q = i10;
        if (i10 < i11) {
            i13 = i10 - i11;
            this.f34856s = i11;
        } else if (i10 > i12) {
            i13 = i10 - i12;
            this.f34856s = i12;
        } else {
            abortAnimation();
        }
        this.f34853p = new SpringInterpolator(DynamicAnimation.SCROLL_Y, 228.0f, 30.0f, i13);
        this.f34858u = r5.getDuration();
        return !this.f34859v;
    }

    public void overFling(float f10, int i10, int i11) {
        this.f34860w = 3;
        this.f34855r = i11;
        if (f10 == 0.0f) {
            abortAnimation();
            return;
        }
        this.f34863z = new a(228.0f, 30.0f, i10, i11, f10);
        this.f34855r = i10;
        this.f34862y = f10;
        this.f34859v = false;
        this.f34857t = AnimationUtils.currentAnimationTimeMillis();
    }
}
