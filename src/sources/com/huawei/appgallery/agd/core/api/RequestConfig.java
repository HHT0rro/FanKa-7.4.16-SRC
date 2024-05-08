package com.huawei.appgallery.agd.core.api;

import android.os.Bundle;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class RequestConfig {

    /* renamed from: a, reason: collision with root package name */
    public Integer f27410a;

    /* renamed from: b, reason: collision with root package name */
    public Integer f27411b;

    /* renamed from: c, reason: collision with root package name */
    public String f27412c;

    /* renamed from: d, reason: collision with root package name */
    public Bundle f27413d;

    /* renamed from: e, reason: collision with root package name */
    public Boolean f27414e;

    /* renamed from: f, reason: collision with root package name */
    public AppInfo f27415f;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        public Integer f27416a;

        /* renamed from: b, reason: collision with root package name */
        public Integer f27417b;

        /* renamed from: c, reason: collision with root package name */
        public String f27418c;

        /* renamed from: d, reason: collision with root package name */
        public Bundle f27419d;

        /* renamed from: e, reason: collision with root package name */
        public Boolean f27420e;

        /* renamed from: f, reason: collision with root package name */
        public AppInfo f27421f;

        public RequestConfig build() {
            return new RequestConfig(this);
        }

        public Builder setAdContentClassification(String str) {
            this.f27418c = str;
            return this;
        }

        public Builder setApp(AppInfo appInfo) {
            this.f27421f = appInfo;
            return this;
        }

        public Builder setPersonalizedAd(Bundle bundle) {
            this.f27419d = bundle;
            return this;
        }

        public Builder setRequestLocation(Boolean bool) {
            this.f27420e = bool;
            return this;
        }

        public Builder setTagForChildProtection(Integer num) {
            this.f27416a = num;
            return this;
        }

        public Builder setTagForUnderAgeOfPromise(Integer num) {
            this.f27417b = num;
            return this;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface PersonalizeConstant {
        public static final String KEY_HW_PERSONALIZE = "hwPersonalize";
        public static final String KEY_PERSONALIZE = "personalize";
        public static final String KEY_THIRD_PERSONALIZE = "thirdPersonalize";
        public static final String KEY_THIRD_PERSONALIZE_STR = "thirdPersonalizeStr";
        public static final int NON_PERSONALIZED = 0;
        public static final int PERSONALIZED = 1;
    }

    public String getAdContentClassification() {
        String str = this.f27412c;
        return str == null ? "" : str;
    }

    public AppInfo getApp() {
        return this.f27415f;
    }

    public Bundle getPersonalizedAd() {
        return this.f27413d;
    }

    public Integer getTagForChildProtection() {
        return this.f27410a;
    }

    public Integer getTagForUnderAgeOfPromise() {
        return this.f27411b;
    }

    public Boolean isRequestLocation() {
        return this.f27414e;
    }

    public Builder toBuilder() {
        return new Builder().setTagForChildProtection(this.f27410a).setTagForUnderAgeOfPromise(this.f27411b).setAdContentClassification(this.f27412c).setPersonalizedAd(this.f27413d).setRequestLocation(this.f27414e).setApp(this.f27415f);
    }

    public RequestConfig(Builder builder) {
        this.f27413d = null;
        this.f27410a = builder.f27416a;
        this.f27411b = builder.f27417b;
        this.f27412c = builder.f27418c;
        this.f27413d = builder.f27419d;
        this.f27414e = builder.f27420e;
        this.f27415f = builder.f27421f;
    }
}
