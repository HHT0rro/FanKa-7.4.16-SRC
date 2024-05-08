package com.danlan.android.videogift;

import android.graphics.Point;
import com.google.android.material.shadow.ShadowDrawableWrapper;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class FitViewHelper {

    /* renamed from: b, reason: collision with root package name */
    public int f19072b;

    /* renamed from: c, reason: collision with root package name */
    public int f19073c;

    /* renamed from: d, reason: collision with root package name */
    public int f19074d;

    /* renamed from: e, reason: collision with root package name */
    public int f19075e;

    /* renamed from: a, reason: collision with root package name */
    public float f19071a = 0.5625f;

    /* renamed from: f, reason: collision with root package name */
    public ScaleType f19076f = ScaleType.CENTER_CROP;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum ScaleType {
        FIT_CENTER,
        FIT_WIDTH,
        FIT_HEIGHT,
        CENTER_CROP,
        CENTER_INSIDE
    }

    public boolean a(int i10, int i11) {
        Point b4;
        ScaleType scaleType = this.f19076f;
        if (scaleType == ScaleType.CENTER_INSIDE) {
            this.f19074d = i10;
            this.f19075e = i11;
            return false;
        }
        if (scaleType == ScaleType.FIT_CENTER) {
            b4 = c(i10, i11);
        } else if (scaleType == ScaleType.FIT_WIDTH) {
            b4 = e(i10, i11);
        } else if (scaleType == ScaleType.FIT_HEIGHT) {
            b4 = d(i10, i11);
        } else {
            b4 = b(i10, i11);
        }
        int i12 = b4.x;
        boolean z10 = (i12 == this.f19074d && b4.y == this.f19075e) ? false : true;
        this.f19074d = i12;
        this.f19075e = b4.y;
        return z10;
    }

    public final Point b(int i10, int i11) {
        int i12;
        int i13 = this.f19072b;
        if (i13 != 0 && (i12 = this.f19073c) != 0) {
            if (this.f19071a > (i13 * 1.0f) / i12) {
                i10 = (int) ((i12 * r7) + 0.5d);
                i11 = i12;
            } else {
                i11 = (int) ((i13 / r7) + 0.5d);
                i10 = i13;
            }
        } else if (i10 == 0 || i11 == 0) {
            i10 = 0;
            i11 = 0;
        } else {
            if (this.f19071a > (1.0f * i10) / i11) {
                i10 = (int) ((r5 * r0) + 0.5d);
            } else {
                i11 = (int) ((r2 / r0) + 0.5d);
            }
        }
        return new Point(i10, i11);
    }

    public final Point c(int i10, int i11) {
        int i12;
        int i13 = this.f19072b;
        if (i13 != 0 && (i12 = this.f19073c) != 0) {
            i10 = i13;
            i11 = i12;
        }
        if (i10 > i11 * this.f19071a) {
            i10 = (int) ((r1 * r2) + 0.5d);
        } else {
            i11 = (int) ((r0 / r2) + 0.5d);
        }
        return new Point(i10, i11);
    }

    public final Point d(int i10, int i11) {
        int i12;
        int i13 = 0;
        if (this.f19072b != 0 && (i12 = this.f19073c) != 0) {
            i13 = (int) ((i12 * this.f19071a) + 0.5d);
            i11 = i12;
        } else if (i10 == 0 || i11 == 0) {
            i11 = 0;
        } else {
            i13 = (int) ((i11 * this.f19071a) + 0.5d);
        }
        return new Point(i13, i11);
    }

    public final Point e(int i10, int i11) {
        int i12 = this.f19072b;
        int i13 = 0;
        if (i12 != 0 && this.f19073c != 0) {
            i13 = (int) ((i12 / this.f19071a) + 0.5d);
            i10 = i12;
        } else if (i10 == 0 || i11 == 0) {
            i10 = 0;
        } else {
            i13 = (int) ((i10 / this.f19071a) + 0.5d);
        }
        return new Point(i10, i13);
    }

    public int f() {
        return this.f19075e;
    }

    public int g() {
        return this.f19074d;
    }

    public boolean h(float f10, int i10, int i11) {
        if (f10 <= ShadowDrawableWrapper.COS_45 || i10 < 0 || i11 < 0) {
            throw new IllegalArgumentException();
        }
        if (this.f19071a == f10 && this.f19072b == i10 && this.f19073c == i11) {
            return false;
        }
        this.f19071a = f10;
        this.f19072b = i10;
        this.f19073c = i11;
        return a(0, 0);
    }

    public void i(ScaleType scaleType) {
        this.f19076f = scaleType;
    }
}
