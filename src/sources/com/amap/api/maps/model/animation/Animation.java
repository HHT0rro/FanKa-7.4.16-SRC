package com.amap.api.maps.model.animation;

import android.view.animation.Interpolator;
import com.amap.api.col.p0003l.dv;
import com.amap.api.col.p0003l.je;
import com.amap.api.maps.model.BaseOptions;
import com.autonavi.amap.mapcore.animation.GLAnimation;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

@JBindingInclude
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public abstract class Animation {
    public static final int FILL_MODE_BACKWARDS = 1;
    public static final int FILL_MODE_FORWARDS = 0;
    public static final int INFINITE = -1;
    public static final int RESTART = 1;
    public static final int REVERSE = 2;

    @JBindingInclude
    public String animationType;
    public GLAnimation glAnimation;

    @JBindingInclude
    private AnimationListener mListener;

    @JBindingInclude
    private int fillMode = 0;

    @JBindingInclude
    private long duration = 500;

    @JBindingInclude
    private Interpolator interpolator = null;

    @JBindingInclude
    private boolean mFillBefore = true;

    @JBindingInclude
    private boolean mFillAfter = false;

    @JBindingInclude
    private boolean mFillEnabled = false;

    @JBindingInclude
    private int mRepeatCount = 0;

    @JBindingInclude
    private int mRepeatMode = 1;
    private AnimationUpdateFlags updateFlags = new AnimationUpdateFlags();

    @JBindingInclude
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface AnimationListener {
        @JBindingInclude
        void onAnimationEnd();

        @JBindingInclude
        void onAnimationStart();
    }

    @JBindingInclude
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class AnimationUpdateFlags extends BaseOptions.BaseUpdateFlags {
        public boolean mListenerUpdate = false;
        public boolean durationUpdate = false;
        public boolean interpolatorUpdate = false;
        public boolean fillModeUpdate = false;
        public boolean mFillEnabledUpdate = false;
        public boolean mFillAfterUpdate = false;
        public boolean mFillBeforeUpdate = false;
        public boolean mRepeatCountUpdate = false;
        public boolean mRepeatModeUpdate = false;

        @Override // com.amap.api.maps.model.BaseOptions.BaseUpdateFlags
        public void reset() {
            super.reset();
            this.mListenerUpdate = false;
            this.durationUpdate = false;
            this.interpolatorUpdate = false;
            this.fillModeUpdate = false;
            this.mFillEnabledUpdate = false;
            this.mFillAfterUpdate = false;
            this.mFillBeforeUpdate = false;
            this.mRepeatCountUpdate = false;
            this.mRepeatModeUpdate = false;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public class a implements AnimationListener {

        /* renamed from: b, reason: collision with root package name */
        private final je f8232b;

        /* renamed from: c, reason: collision with root package name */
        private final je f8233c;

        public /* synthetic */ a(Animation animation, AnimationListener animationListener, byte b4) {
            this(animationListener);
        }

        @Override // com.amap.api.maps.model.animation.Animation.AnimationListener
        public final void onAnimationEnd() {
            dv.a().a(this.f8233c);
        }

        @Override // com.amap.api.maps.model.animation.Animation.AnimationListener
        public final void onAnimationStart() {
            dv.a().a(this.f8232b);
        }

        private a(final AnimationListener animationListener) {
            this.f8232b = new je() { // from class: com.amap.api.maps.model.animation.Animation.a.1
                @Override // com.amap.api.col.p0003l.je
                public final void runTask() {
                    try {
                        AnimationListener animationListener2 = animationListener;
                        if (animationListener2 != null) {
                            animationListener2.onAnimationStart();
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            };
            this.f8233c = new je() { // from class: com.amap.api.maps.model.animation.Animation.a.2
                @Override // com.amap.api.col.p0003l.je
                public final void runTask() {
                    try {
                        AnimationListener animationListener2 = animationListener;
                        if (animationListener2 != null) {
                            animationListener2.onAnimationEnd();
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            };
        }
    }

    public Animation() {
        this.animationType = "typeAnimtionBase";
        this.glAnimation = null;
        this.glAnimation = new GLAnimation();
        this.animationType = getAnimationType();
    }

    private void a(boolean z10) {
        this.mFillEnabled = z10;
        GLAnimation gLAnimation = this.glAnimation;
        if (gLAnimation != null) {
            gLAnimation.setFillEnabled(z10);
        }
        this.updateFlags.mFillEnabledUpdate = true;
    }

    private void b(boolean z10) {
        this.mFillAfter = z10;
        GLAnimation gLAnimation = this.glAnimation;
        if (gLAnimation != null) {
            gLAnimation.setFillAfter(z10);
        }
        this.updateFlags.mFillAfterUpdate = true;
    }

    private void c(boolean z10) {
        this.mFillBefore = z10;
        GLAnimation gLAnimation = this.glAnimation;
        if (gLAnimation != null) {
            gLAnimation.setFillBefore(z10);
        }
        this.updateFlags.mFillBeforeUpdate = true;
    }

    public abstract String getAnimationType();

    public int getFillMode() {
        return this.fillMode;
    }

    public int getRepeatCount() {
        GLAnimation gLAnimation = this.glAnimation;
        if (gLAnimation != null) {
            return gLAnimation.getRepeatCount();
        }
        return 0;
    }

    public int getRepeatMode() {
        GLAnimation gLAnimation = this.glAnimation;
        if (gLAnimation != null) {
            return gLAnimation.getRepeatMode();
        }
        return 1;
    }

    @JBindingInclude
    public AnimationUpdateFlags getUpdateFlags() {
        return this.updateFlags;
    }

    public void resetUpdateFlags() {
        this.updateFlags.reset();
    }

    public void setAnimationListener(AnimationListener animationListener) {
        this.mListener = new a(this, animationListener, (byte) 0);
        this.glAnimation.setAnimationListener(animationListener);
        this.updateFlags.mListenerUpdate = true;
    }

    public void setDuration(long j10) {
        this.duration = j10;
        GLAnimation gLAnimation = this.glAnimation;
        if (gLAnimation != null) {
            gLAnimation.setDuration(j10);
        }
        this.updateFlags.durationUpdate = true;
    }

    public void setFillMode(int i10) {
        this.fillMode = i10;
        if (i10 == 0) {
            b(true);
            c(false);
            a(false);
        } else {
            b(false);
            a(true);
            c(true);
        }
        this.updateFlags.fillModeUpdate = true;
    }

    public void setInterpolator(Interpolator interpolator) {
        this.interpolator = interpolator;
        GLAnimation gLAnimation = this.glAnimation;
        if (gLAnimation != null) {
            gLAnimation.setInterpolator(interpolator);
        }
        this.updateFlags.interpolatorUpdate = true;
    }

    public void setRepeatCount(int i10) {
        this.mRepeatCount = i10;
        GLAnimation gLAnimation = this.glAnimation;
        if (gLAnimation != null) {
            gLAnimation.setRepeatCount(i10);
        }
        this.updateFlags.mRepeatCountUpdate = true;
    }

    public void setRepeatMode(int i10) {
        this.mRepeatMode = i10;
        GLAnimation gLAnimation = this.glAnimation;
        if (gLAnimation != null) {
            gLAnimation.setRepeatMode(i10);
        }
        this.updateFlags.mRepeatModeUpdate = true;
    }
}
