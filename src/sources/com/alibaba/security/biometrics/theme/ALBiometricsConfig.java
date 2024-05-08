package com.alibaba.security.biometrics.theme;

import com.alibaba.security.biometrics.transition.TransitionMode;
import java.io.Serializable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ALBiometricsConfig implements Serializable {
    public static final transient boolean DEFAULT_NEED_SOUND = true;
    public static final transient TransitionMode DEFAULT_TRANSITION_MODE = TransitionMode.NULL;
    public boolean isNeedFailResultPage;
    public final boolean isNeedSound;
    public final boolean isShouldAlertOnExit;
    public boolean mIsSkinInAssets;
    public final String skinPath;
    public final TransitionMode transitionMode;

    public ALBiometricsConfig() {
        this(new Builder());
    }

    public String getSkinPath() {
        return this.skinPath;
    }

    public TransitionMode getTransitionMode() {
        return this.transitionMode;
    }

    public boolean isNeedFailResultPage() {
        return this.isNeedFailResultPage;
    }

    public boolean isNeedSound() {
        return this.isNeedSound;
    }

    public boolean isShouldAlertOnExit() {
        return this.isShouldAlertOnExit;
    }

    public boolean isSkinInAssets() {
        return this.mIsSkinInAssets;
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    public ALBiometricsConfig(Builder builder) {
        this.transitionMode = builder.transitionMode;
        this.isNeedSound = builder.isNeedSound;
        this.isShouldAlertOnExit = builder.isShouldAlertOnExit;
        this.skinPath = builder.skinPath;
        this.mIsSkinInAssets = builder.mIsSkinInAssets;
        this.isNeedFailResultPage = builder.isNeedFailResultPage;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static final class Builder {
        public boolean isNeedFailResultPage;
        public boolean isNeedSound;
        public boolean isNeedWaitingForFinish;
        public boolean isShouldAlertOnExit;
        public boolean mIsSkinInAssets;
        public String skinPath;
        public TransitionMode transitionMode;

        public Builder() {
            this.transitionMode = ALBiometricsConfig.DEFAULT_TRANSITION_MODE;
            this.isNeedSound = true;
            this.isShouldAlertOnExit = true;
        }

        public final ALBiometricsConfig build() {
            return new ALBiometricsConfig(this);
        }

        public final Builder setIsSkinInAssets(boolean z10) {
            this.mIsSkinInAssets = z10;
            return this;
        }

        public final Builder setNeedFailResultPage(boolean z10) {
            this.isNeedFailResultPage = z10;
            return this;
        }

        @Deprecated
        public final Builder setNeedLoading(boolean z10) {
            this.isNeedWaitingForFinish = z10;
            return this;
        }

        public final Builder setNeedSound(boolean z10) {
            this.isNeedSound = z10;
            return this;
        }

        public final Builder setNeedWaitingForFinish(boolean z10) {
            this.isNeedWaitingForFinish = z10;
            return this;
        }

        public final Builder setShouldAlertOnExit(boolean z10) {
            this.isShouldAlertOnExit = z10;
            return this;
        }

        public final Builder setSkinPath(String str) {
            this.skinPath = str;
            return this;
        }

        public final Builder setTransitionMode(TransitionMode transitionMode) {
            this.transitionMode = transitionMode;
            return this;
        }

        public Builder(ALBiometricsConfig aLBiometricsConfig) {
            this.transitionMode = aLBiometricsConfig.transitionMode;
            this.isNeedSound = aLBiometricsConfig.isNeedSound;
            this.isShouldAlertOnExit = aLBiometricsConfig.isShouldAlertOnExit;
        }
    }
}
