package com.alibaba.security.realidentity;

import com.alibaba.security.biometrics.theme.ALBiometricsConfig;
import com.alibaba.security.biometrics.transition.TransitionMode;
import com.alibaba.security.realidentity.build.j;
import com.huawei.appgallery.agd.base.api.AgdManager;
import java.io.Serializable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class RPConfig implements Serializable {
    public final ALBiometricsConfig biometricsConfig;
    public String fromSource;

    private RPConfig() {
        this(new Builder());
    }

    public ALBiometricsConfig getBiometricsConfig() {
        return this.biometricsConfig;
    }

    public String getFromSource() {
        return this.fromSource;
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    public void setFromSource(String str) {
        this.fromSource = str;
    }

    public RPConfig(Builder builder) {
        ALBiometricsConfig.Builder builder2 = new ALBiometricsConfig.Builder();
        builder2.setTransitionMode(builder.f2912a);
        builder2.setNeedSound(builder.f2913b);
        builder2.setShouldAlertOnExit(builder.f2915d);
        builder2.setSkinPath(builder.f2916e);
        builder2.setNeedFailResultPage(builder.f2914c);
        builder2.setIsSkinInAssets(builder.f2917f);
        this.fromSource = builder.f2919h;
        this.biometricsConfig = builder2.build();
        j.a.f3944a.f3907q = builder.f2918g;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public TransitionMode f2912a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f2913b;

        /* renamed from: c, reason: collision with root package name */
        @Deprecated
        public boolean f2914c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f2915d;

        /* renamed from: e, reason: collision with root package name */
        public String f2916e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f2917f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f2918g;

        /* renamed from: h, reason: collision with root package name */
        public String f2919h;

        public Builder() {
            this.f2918g = true;
            this.f2919h = AgdManager.SOURCE_NATIVE;
            this.f2912a = ALBiometricsConfig.DEFAULT_TRANSITION_MODE;
            this.f2913b = true;
            this.f2915d = true;
            this.f2917f = true;
        }

        public final RPConfig build() {
            return new RPConfig(this);
        }

        public final Builder setFromSource(String str) {
            this.f2919h = str;
            return this;
        }

        @Deprecated
        public final Builder setNeedFailResultPage(boolean z10) {
            this.f2914c = z10;
            return this;
        }

        public final Builder setNeedSound(boolean z10) {
            this.f2913b = z10;
            return this;
        }

        @Deprecated
        public final Builder setNeedWaitingForFinish(boolean z10) {
            return this;
        }

        public final Builder setShouldAlertOnExit(boolean z10) {
            this.f2915d = z10;
            return this;
        }

        public final Builder setSkinInAssets(boolean z10) {
            this.f2917f = z10;
            return this;
        }

        public final Builder setSkinPath(String str) {
            this.f2916e = str;
            return this;
        }

        public final Builder setTransitionMode(TransitionMode transitionMode) {
            this.f2912a = transitionMode;
            return this;
        }

        public final Builder setUseWindVane(boolean z10) {
            this.f2918g = z10;
            return this;
        }

        public Builder(RPConfig rPConfig) {
            this.f2918g = true;
            this.f2919h = AgdManager.SOURCE_NATIVE;
            ALBiometricsConfig biometricsConfig = rPConfig.getBiometricsConfig();
            this.f2912a = biometricsConfig.getTransitionMode();
            this.f2913b = biometricsConfig.isNeedSound();
            this.f2914c = biometricsConfig.isNeedFailResultPage();
            this.f2915d = biometricsConfig.isShouldAlertOnExit();
            this.f2916e = biometricsConfig.getSkinPath();
        }
    }
}
