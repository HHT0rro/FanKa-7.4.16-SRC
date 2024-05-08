package com.jd.ad.sdk.jad_ve;

import android.animation.Animator;
import android.graphics.PointF;
import android.view.Choreographer;
import androidx.annotation.FloatRange;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.util.Iterator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class jad_er extends jad_an implements Choreographer.FrameCallback {

    @Nullable
    public com.jd.ad.sdk.jad_js.jad_jt jad_jw;
    public float jad_cp = 1.0f;
    public boolean jad_dq = false;
    public long jad_er = 0;
    public float jad_fs = 0.0f;
    public int jad_jt = 0;
    public float jad_hu = -2.14748365E9f;
    public float jad_iv = 2.14748365E9f;

    @VisibleForTesting
    public boolean jad_kx = false;

    @Override // android.animation.ValueAnimator, android.animation.Animator
    @MainThread
    public void cancel() {
        Iterator<Animator.AnimatorListener> iterator2 = this.jad_bo.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().onAnimationCancel(this);
        }
        jad_hu();
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j10) {
        jad_jt();
        com.jd.ad.sdk.jad_js.jad_jt jad_jtVar = this.jad_jw;
        if (jad_jtVar == null || !this.jad_kx) {
            return;
        }
        long j11 = this.jad_er;
        float abs = ((float) (j11 != 0 ? j10 - j11 : 0L)) / ((1.0E9f / jad_jtVar.jad_mz) / Math.abs(this.jad_cp));
        float f10 = this.jad_fs;
        if (jad_fs()) {
            abs = -abs;
        }
        float f11 = f10 + abs;
        this.jad_fs = f11;
        float jad_er = jad_er();
        float jad_dq = jad_dq();
        PointF pointF = jad_jt.jad_an;
        boolean z10 = !(f11 >= jad_er && f11 <= jad_dq);
        this.jad_fs = Math.max(jad_er(), Math.min(jad_dq(), this.jad_fs));
        this.jad_er = j10;
        jad_an();
        if (z10) {
            if (getRepeatCount() == -1 || this.jad_jt < getRepeatCount()) {
                Iterator<Animator.AnimatorListener> iterator2 = this.jad_bo.iterator2();
                while (iterator2.hasNext()) {
                    iterator2.next().onAnimationRepeat(this);
                }
                this.jad_jt++;
                if (getRepeatMode() == 2) {
                    this.jad_dq = !this.jad_dq;
                    this.jad_cp = -this.jad_cp;
                } else {
                    this.jad_fs = jad_fs() ? jad_dq() : jad_er();
                }
                this.jad_er = j10;
            } else {
                this.jad_fs = this.jad_cp < 0.0f ? jad_er() : jad_dq();
                jad_hu();
                jad_an(jad_fs());
            }
        }
        if (this.jad_jw != null) {
            float f12 = this.jad_fs;
            if (f12 < this.jad_hu || f12 > this.jad_iv) {
                throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", Float.valueOf(this.jad_hu), Float.valueOf(this.jad_iv), Float.valueOf(this.jad_fs)));
            }
        }
        com.jd.ad.sdk.jad_js.jad_dq.jad_an("LottieValueAnimator#doFrame");
    }

    @Override // android.animation.ValueAnimator
    @FloatRange(from = ShadowDrawableWrapper.COS_45, to = 1.0d)
    public float getAnimatedFraction() {
        float f10;
        float jad_er;
        if (this.jad_jw == null) {
            return 0.0f;
        }
        if (jad_fs()) {
            f10 = jad_dq();
            jad_er = this.jad_fs;
        } else {
            f10 = this.jad_fs;
            jad_er = jad_er();
        }
        return (f10 - jad_er) / (jad_dq() - jad_er());
    }

    @Override // android.animation.ValueAnimator
    public Object getAnimatedValue() {
        return Float.valueOf(jad_cp());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getDuration() {
        if (this.jad_jw == null) {
            return 0L;
        }
        return r0.jad_an();
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public boolean isRunning() {
        return this.jad_kx;
    }

    public void jad_an(float f10) {
        if (this.jad_fs == f10) {
            return;
        }
        float jad_er = jad_er();
        float jad_dq = jad_dq();
        PointF pointF = jad_jt.jad_an;
        this.jad_fs = Math.max(jad_er, Math.min(jad_dq, f10));
        this.jad_er = 0L;
        jad_an();
    }

    @MainThread
    public void jad_bo() {
        jad_hu();
        jad_an(jad_fs());
    }

    @FloatRange(from = ShadowDrawableWrapper.COS_45, to = 1.0d)
    public float jad_cp() {
        com.jd.ad.sdk.jad_js.jad_jt jad_jtVar = this.jad_jw;
        if (jad_jtVar == null) {
            return 0.0f;
        }
        float f10 = this.jad_fs;
        float f11 = jad_jtVar.jad_kx;
        return (f10 - f11) / (jad_jtVar.jad_ly - f11);
    }

    public float jad_dq() {
        com.jd.ad.sdk.jad_js.jad_jt jad_jtVar = this.jad_jw;
        if (jad_jtVar == null) {
            return 0.0f;
        }
        float f10 = this.jad_iv;
        return f10 == 2.14748365E9f ? jad_jtVar.jad_ly : f10;
    }

    public float jad_er() {
        com.jd.ad.sdk.jad_js.jad_jt jad_jtVar = this.jad_jw;
        if (jad_jtVar == null) {
            return 0.0f;
        }
        float f10 = this.jad_hu;
        return f10 == -2.14748365E9f ? jad_jtVar.jad_kx : f10;
    }

    public final boolean jad_fs() {
        return this.jad_cp < 0.0f;
    }

    @MainThread
    public void jad_hu() {
        Choreographer.getInstance().removeFrameCallback(this);
        this.jad_kx = false;
    }

    public void jad_jt() {
        if (this.jad_kx) {
            Choreographer.getInstance().removeFrameCallback(this);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    @Override // android.animation.ValueAnimator
    public void setRepeatMode(int i10) {
        super.setRepeatMode(i10);
        if (i10 == 2 || !this.jad_dq) {
            return;
        }
        this.jad_dq = false;
        this.jad_cp = -this.jad_cp;
    }

    public void jad_an(float f10, float f11) {
        if (f10 > f11) {
            throw new IllegalArgumentException(String.format("minFrame (%s) must be <= maxFrame (%s)", Float.valueOf(f10), Float.valueOf(f11)));
        }
        com.jd.ad.sdk.jad_js.jad_jt jad_jtVar = this.jad_jw;
        float f12 = jad_jtVar == null ? -3.4028235E38f : jad_jtVar.jad_kx;
        float f13 = jad_jtVar == null ? Float.MAX_VALUE : jad_jtVar.jad_ly;
        PointF pointF = jad_jt.jad_an;
        float max = Math.max(f12, Math.min(f13, f10));
        float max2 = Math.max(f12, Math.min(f13, f11));
        if (max == this.jad_hu && max2 == this.jad_iv) {
            return;
        }
        this.jad_hu = max;
        this.jad_iv = max2;
        jad_an((int) Math.max(max, Math.min(max2, this.jad_fs)));
    }
}
