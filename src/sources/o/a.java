package o;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieComposition;

/* compiled from: Keyframe.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class a<T> {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public final LottieComposition f52210a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public final T f52211b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public T f52212c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public final Interpolator f52213d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public final Interpolator f52214e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public final Interpolator f52215f;

    /* renamed from: g, reason: collision with root package name */
    public final float f52216g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    public Float f52217h;

    /* renamed from: i, reason: collision with root package name */
    public float f52218i;

    /* renamed from: j, reason: collision with root package name */
    public float f52219j;

    /* renamed from: k, reason: collision with root package name */
    public int f52220k;

    /* renamed from: l, reason: collision with root package name */
    public int f52221l;

    /* renamed from: m, reason: collision with root package name */
    public float f52222m;

    /* renamed from: n, reason: collision with root package name */
    public float f52223n;

    /* renamed from: o, reason: collision with root package name */
    public PointF f52224o;

    /* renamed from: p, reason: collision with root package name */
    public PointF f52225p;

    public a(LottieComposition lottieComposition, @Nullable T t2, @Nullable T t10, @Nullable Interpolator interpolator, float f10, @Nullable Float f11) {
        this.f52218i = -3987645.8f;
        this.f52219j = -3987645.8f;
        this.f52220k = 784923401;
        this.f52221l = 784923401;
        this.f52222m = Float.MIN_VALUE;
        this.f52223n = Float.MIN_VALUE;
        this.f52224o = null;
        this.f52225p = null;
        this.f52210a = lottieComposition;
        this.f52211b = t2;
        this.f52212c = t10;
        this.f52213d = interpolator;
        this.f52214e = null;
        this.f52215f = null;
        this.f52216g = f10;
        this.f52217h = f11;
    }

    public boolean a(@FloatRange(from = 0.0d, to = 1.0d) float f10) {
        return f10 >= f() && f10 < c();
    }

    public a<T> b(T t2, T t10) {
        return new a<>(t2, t10);
    }

    public float c() {
        if (this.f52210a == null) {
            return 1.0f;
        }
        if (this.f52223n == Float.MIN_VALUE) {
            if (this.f52217h == null) {
                this.f52223n = 1.0f;
            } else {
                this.f52223n = f() + ((this.f52217h.floatValue() - this.f52216g) / this.f52210a.e());
            }
        }
        return this.f52223n;
    }

    public float d() {
        if (this.f52219j == -3987645.8f) {
            this.f52219j = ((Float) this.f52212c).floatValue();
        }
        return this.f52219j;
    }

    public int e() {
        if (this.f52221l == 784923401) {
            this.f52221l = ((Integer) this.f52212c).intValue();
        }
        return this.f52221l;
    }

    public float f() {
        LottieComposition lottieComposition = this.f52210a;
        if (lottieComposition == null) {
            return 0.0f;
        }
        if (this.f52222m == Float.MIN_VALUE) {
            this.f52222m = (this.f52216g - lottieComposition.p()) / this.f52210a.e();
        }
        return this.f52222m;
    }

    public float g() {
        if (this.f52218i == -3987645.8f) {
            this.f52218i = ((Float) this.f52211b).floatValue();
        }
        return this.f52218i;
    }

    public int h() {
        if (this.f52220k == 784923401) {
            this.f52220k = ((Integer) this.f52211b).intValue();
        }
        return this.f52220k;
    }

    public boolean i() {
        return this.f52213d == null && this.f52214e == null && this.f52215f == null;
    }

    public String toString() {
        return "Keyframe{startValue=" + ((Object) this.f52211b) + ", endValue=" + ((Object) this.f52212c) + ", startFrame=" + this.f52216g + ", endFrame=" + ((Object) this.f52217h) + ", interpolator=" + ((Object) this.f52213d) + '}';
    }

    public a(LottieComposition lottieComposition, @Nullable T t2, @Nullable T t10, @Nullable Interpolator interpolator, @Nullable Interpolator interpolator2, float f10, @Nullable Float f11) {
        this.f52218i = -3987645.8f;
        this.f52219j = -3987645.8f;
        this.f52220k = 784923401;
        this.f52221l = 784923401;
        this.f52222m = Float.MIN_VALUE;
        this.f52223n = Float.MIN_VALUE;
        this.f52224o = null;
        this.f52225p = null;
        this.f52210a = lottieComposition;
        this.f52211b = t2;
        this.f52212c = t10;
        this.f52213d = null;
        this.f52214e = interpolator;
        this.f52215f = interpolator2;
        this.f52216g = f10;
        this.f52217h = f11;
    }

    public a(LottieComposition lottieComposition, @Nullable T t2, @Nullable T t10, @Nullable Interpolator interpolator, @Nullable Interpolator interpolator2, @Nullable Interpolator interpolator3, float f10, @Nullable Float f11) {
        this.f52218i = -3987645.8f;
        this.f52219j = -3987645.8f;
        this.f52220k = 784923401;
        this.f52221l = 784923401;
        this.f52222m = Float.MIN_VALUE;
        this.f52223n = Float.MIN_VALUE;
        this.f52224o = null;
        this.f52225p = null;
        this.f52210a = lottieComposition;
        this.f52211b = t2;
        this.f52212c = t10;
        this.f52213d = interpolator;
        this.f52214e = interpolator2;
        this.f52215f = interpolator3;
        this.f52216g = f10;
        this.f52217h = f11;
    }

    public a(T t2) {
        this.f52218i = -3987645.8f;
        this.f52219j = -3987645.8f;
        this.f52220k = 784923401;
        this.f52221l = 784923401;
        this.f52222m = Float.MIN_VALUE;
        this.f52223n = Float.MIN_VALUE;
        this.f52224o = null;
        this.f52225p = null;
        this.f52210a = null;
        this.f52211b = t2;
        this.f52212c = t2;
        this.f52213d = null;
        this.f52214e = null;
        this.f52215f = null;
        this.f52216g = Float.MIN_VALUE;
        this.f52217h = Float.valueOf(Float.MAX_VALUE);
    }

    public a(T t2, T t10) {
        this.f52218i = -3987645.8f;
        this.f52219j = -3987645.8f;
        this.f52220k = 784923401;
        this.f52221l = 784923401;
        this.f52222m = Float.MIN_VALUE;
        this.f52223n = Float.MIN_VALUE;
        this.f52224o = null;
        this.f52225p = null;
        this.f52210a = null;
        this.f52211b = t2;
        this.f52212c = t10;
        this.f52213d = null;
        this.f52214e = null;
        this.f52215f = null;
        this.f52216g = Float.MIN_VALUE;
        this.f52217h = Float.valueOf(Float.MAX_VALUE);
    }
}
