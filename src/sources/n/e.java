package n;

import android.view.Choreographer;
import androidx.annotation.FloatRange;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.airbnb.lottie.LottieComposition;
import com.google.android.material.shadow.ShadowDrawableWrapper;

/* compiled from: LottieValueAnimator.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class e extends a implements Choreographer.FrameCallback {

    /* renamed from: m, reason: collision with root package name */
    @Nullable
    public LottieComposition f52012m;

    /* renamed from: e, reason: collision with root package name */
    public float f52004e = 1.0f;

    /* renamed from: f, reason: collision with root package name */
    public boolean f52005f = false;

    /* renamed from: g, reason: collision with root package name */
    public long f52006g = 0;

    /* renamed from: h, reason: collision with root package name */
    public float f52007h = 0.0f;

    /* renamed from: i, reason: collision with root package name */
    public float f52008i = 0.0f;

    /* renamed from: j, reason: collision with root package name */
    public int f52009j = 0;

    /* renamed from: k, reason: collision with root package name */
    public float f52010k = -2.14748365E9f;

    /* renamed from: l, reason: collision with root package name */
    public float f52011l = 2.14748365E9f;

    /* renamed from: n, reason: collision with root package name */
    @VisibleForTesting
    public boolean f52013n = false;

    /* renamed from: o, reason: collision with root package name */
    public boolean f52014o = false;

    public void A(float f10) {
        if (this.f52007h == f10) {
            return;
        }
        float b4 = g.b(f10, p(), o());
        this.f52007h = b4;
        if (this.f52014o) {
            b4 = (float) Math.floor(b4);
        }
        this.f52008i = b4;
        this.f52006g = 0L;
        i();
    }

    public void B(float f10) {
        D(this.f52010k, f10);
    }

    public void D(float f10, float f11) {
        if (f10 <= f11) {
            LottieComposition lottieComposition = this.f52012m;
            float p10 = lottieComposition == null ? -3.4028235E38f : lottieComposition.p();
            LottieComposition lottieComposition2 = this.f52012m;
            float f12 = lottieComposition2 == null ? Float.MAX_VALUE : lottieComposition2.f();
            float b4 = g.b(f10, p10, f12);
            float b10 = g.b(f11, p10, f12);
            if (b4 == this.f52010k && b10 == this.f52011l) {
                return;
            }
            this.f52010k = b4;
            this.f52011l = b10;
            A((int) g.b(this.f52008i, b4, b10));
            return;
        }
        throw new IllegalArgumentException(String.format("minFrame (%s) must be <= maxFrame (%s)", Float.valueOf(f10), Float.valueOf(f11)));
    }

    public void F(int i10) {
        D(i10, (int) this.f52011l);
    }

    public void I(float f10) {
        this.f52004e = f10;
    }

    public void J(boolean z10) {
        this.f52014o = z10;
    }

    public final void K() {
        if (this.f52012m == null) {
            return;
        }
        float f10 = this.f52008i;
        if (f10 < this.f52010k || f10 > this.f52011l) {
            throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", Float.valueOf(this.f52010k), Float.valueOf(this.f52011l), Float.valueOf(this.f52008i)));
        }
    }

    @Override // n.a
    public void a() {
        super.a();
        c(r());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    @MainThread
    public void cancel() {
        a();
        v();
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j10) {
        u();
        if (this.f52012m == null || !isRunning()) {
            return;
        }
        com.airbnb.lottie.c.a("LottieValueAnimator#doFrame");
        long j11 = this.f52006g;
        float n10 = ((float) (j11 != 0 ? j10 - j11 : 0L)) / n();
        float f10 = this.f52007h;
        if (r()) {
            n10 = -n10;
        }
        float f11 = f10 + n10;
        boolean z10 = !g.d(f11, p(), o());
        float f12 = this.f52007h;
        float b4 = g.b(f11, p(), o());
        this.f52007h = b4;
        if (this.f52014o) {
            b4 = (float) Math.floor(b4);
        }
        this.f52008i = b4;
        this.f52006g = j10;
        if (!this.f52014o || this.f52007h != f12) {
            i();
        }
        if (z10) {
            if (getRepeatCount() != -1 && this.f52009j >= getRepeatCount()) {
                float p10 = this.f52004e < 0.0f ? p() : o();
                this.f52007h = p10;
                this.f52008i = p10;
                v();
                c(r());
            } else {
                e();
                this.f52009j++;
                if (getRepeatMode() == 2) {
                    this.f52005f = !this.f52005f;
                    y();
                } else {
                    float o10 = r() ? o() : p();
                    this.f52007h = o10;
                    this.f52008i = o10;
                }
                this.f52006g = j10;
            }
        }
        K();
        com.airbnb.lottie.c.b("LottieValueAnimator#doFrame");
    }

    @Override // android.animation.ValueAnimator
    @FloatRange(from = ShadowDrawableWrapper.COS_45, to = 1.0d)
    public float getAnimatedFraction() {
        float p10;
        float o10;
        float p11;
        if (this.f52012m == null) {
            return 0.0f;
        }
        if (r()) {
            p10 = o() - this.f52008i;
            o10 = o();
            p11 = p();
        } else {
            p10 = this.f52008i - p();
            o10 = o();
            p11 = p();
        }
        return p10 / (o10 - p11);
    }

    @Override // android.animation.ValueAnimator
    public Object getAnimatedValue() {
        return Float.valueOf(l());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getDuration() {
        if (this.f52012m == null) {
            return 0L;
        }
        return r0.d();
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public boolean isRunning() {
        return this.f52013n;
    }

    public void j() {
        this.f52012m = null;
        this.f52010k = -2.14748365E9f;
        this.f52011l = 2.14748365E9f;
    }

    @MainThread
    public void k() {
        v();
        c(r());
    }

    @FloatRange(from = ShadowDrawableWrapper.COS_45, to = 1.0d)
    public float l() {
        LottieComposition lottieComposition = this.f52012m;
        if (lottieComposition == null) {
            return 0.0f;
        }
        return (this.f52008i - lottieComposition.p()) / (this.f52012m.f() - this.f52012m.p());
    }

    public float m() {
        return this.f52008i;
    }

    public final float n() {
        LottieComposition lottieComposition = this.f52012m;
        if (lottieComposition == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / lottieComposition.i()) / Math.abs(this.f52004e);
    }

    public float o() {
        LottieComposition lottieComposition = this.f52012m;
        if (lottieComposition == null) {
            return 0.0f;
        }
        float f10 = this.f52011l;
        return f10 == 2.14748365E9f ? lottieComposition.f() : f10;
    }

    public float p() {
        LottieComposition lottieComposition = this.f52012m;
        if (lottieComposition == null) {
            return 0.0f;
        }
        float f10 = this.f52010k;
        return f10 == -2.14748365E9f ? lottieComposition.p() : f10;
    }

    public float q() {
        return this.f52004e;
    }

    public final boolean r() {
        return q() < 0.0f;
    }

    @MainThread
    public void s() {
        v();
        d();
    }

    @Override // android.animation.ValueAnimator
    public void setRepeatMode(int i10) {
        super.setRepeatMode(i10);
        if (i10 == 2 || !this.f52005f) {
            return;
        }
        this.f52005f = false;
        y();
    }

    @MainThread
    public void t() {
        this.f52013n = true;
        h(r());
        A((int) (r() ? o() : p()));
        this.f52006g = 0L;
        this.f52009j = 0;
        u();
    }

    public void u() {
        if (isRunning()) {
            w(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    @MainThread
    public void v() {
        w(true);
    }

    @MainThread
    public void w(boolean z10) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z10) {
            this.f52013n = false;
        }
    }

    @MainThread
    public void x() {
        this.f52013n = true;
        u();
        this.f52006g = 0L;
        if (r() && m() == p()) {
            A(o());
        } else if (!r() && m() == o()) {
            A(p());
        }
        g();
    }

    public void y() {
        I(-q());
    }

    public void z(LottieComposition lottieComposition) {
        boolean z10 = this.f52012m == null;
        this.f52012m = lottieComposition;
        if (z10) {
            D(Math.max(this.f52010k, lottieComposition.p()), Math.min(this.f52011l, lottieComposition.f()));
        } else {
            D((int) lottieComposition.p(), (int) lottieComposition.f());
        }
        float f10 = this.f52008i;
        this.f52008i = 0.0f;
        this.f52007h = 0.0f;
        A((int) f10);
        i();
    }
}
