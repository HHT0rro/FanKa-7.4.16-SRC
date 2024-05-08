package com.qq.e.ads.rewardvideo;

import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class ServerSideVerificationOptions {
    public static final String TRANS_ID = "transId";

    /* renamed from: a, reason: collision with root package name */
    private String f38225a;

    /* renamed from: b, reason: collision with root package name */
    private String f38226b;

    /* renamed from: c, reason: collision with root package name */
    private final JSONObject f38227c;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        private String f38228a;

        /* renamed from: b, reason: collision with root package name */
        private String f38229b;

        public ServerSideVerificationOptions build() {
            return new ServerSideVerificationOptions(this);
        }

        public Builder setCustomData(String str) {
            this.f38228a = str;
            return this;
        }

        public Builder setUserId(String str) {
            this.f38229b = str;
            return this;
        }
    }

    private ServerSideVerificationOptions(Builder builder) {
        this.f38227c = new JSONObject();
        this.f38225a = builder.f38228a;
        this.f38226b = builder.f38229b;
    }

    public String getCustomData() {
        return this.f38225a;
    }

    public JSONObject getOptions() {
        return this.f38227c;
    }

    public String getUserId() {
        return this.f38226b;
    }
}
