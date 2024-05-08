package com.huawei.appgallery.agd.core.api;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.appgallery.agd.common.application.ApplicationWrapper;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class AgdAdConfig {

    /* renamed from: a, reason: collision with root package name */
    public boolean f27399a;

    /* renamed from: b, reason: collision with root package name */
    public String f27400b;

    /* renamed from: c, reason: collision with root package name */
    public String f27401c;

    /* renamed from: d, reason: collision with root package name */
    public String f27402d;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        public boolean f27403a = false;

        /* renamed from: b, reason: collision with root package name */
        public String f27404b;

        /* renamed from: c, reason: collision with root package name */
        public String f27405c;

        /* renamed from: d, reason: collision with root package name */
        public String f27406d;

        public AgdAdConfig build() {
            return new AgdAdConfig(this);
        }

        public Builder debug(boolean z10) {
            this.f27403a = z10;
            return this;
        }

        public Builder setMediaPkgName(String str) {
            this.f27405c = str;
            return this;
        }

        public Builder setMediaPkgSign(String str) {
            this.f27406d = str;
            return this;
        }

        public Builder userId(String str) {
            this.f27404b = str;
            return this;
        }
    }

    public String getMediaPkgName() {
        return this.f27401c;
    }

    public String getMediaPkgSign() {
        Context context = ApplicationWrapper.getInstance().getContext();
        if (context == null || (p9.a.a(context.getPackageName()) && !TextUtils.isEmpty(this.f27401c))) {
            return this.f27402d;
        }
        return null;
    }

    public String getUserId() {
        return this.f27400b;
    }

    public boolean isDebug() {
        return this.f27399a;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("AgdAdConfig{debug=");
        sb2.append(this.f27399a);
        sb2.append(", mediaPkgName='");
        sb2.append(this.f27401c);
        sb2.append('\'');
        sb2.append(", mediaPkgSign='");
        sb2.append(this.f27402d == null ? "null" : "notnull");
        sb2.append('\'');
        sb2.append('}');
        return sb2.toString();
    }

    public AgdAdConfig() {
        this.f27399a = false;
    }

    public AgdAdConfig(Builder builder) {
        this.f27399a = false;
        this.f27400b = builder.f27404b;
        this.f27399a = builder.f27403a;
        this.f27402d = builder.f27406d;
        this.f27401c = builder.f27405c;
    }
}
