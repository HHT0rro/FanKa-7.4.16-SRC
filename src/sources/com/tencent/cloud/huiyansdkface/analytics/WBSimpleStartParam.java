package com.tencent.cloud.huiyansdkface.analytics;

import android.text.TextUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class WBSimpleStartParam {
    private String appId;
    private String appVersion;
    private String baseUrl;
    private String customFiled;
    private String ecifNo;
    private boolean isEnableService;
    private boolean logEnable;
    private String openId;
    private String subAppId;
    private String unionId;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class Builder {
        private String appId;
        private String appVersion;
        private String baseUrl;
        private String customFiled;
        private String ecifNo;
        private boolean isEnableWAService;
        private boolean logEnable;
        private String openId;
        private String subAppId;
        private String unionId;

        public Builder(String str, String str2, String str3) {
            this.appId = str;
            this.openId = str2;
            this.baseUrl = str3;
        }

        public WBSimpleStartParam build() {
            return new WBSimpleStartParam(this);
        }

        public Builder setAppId(String str) {
            this.appId = str;
            return this;
        }

        public Builder setAppVersion(String str) {
            this.appVersion = str;
            return this;
        }

        public Builder setBaseUrl(String str) {
            this.baseUrl = str;
            return this;
        }

        public Builder setCustomFiled(String str) {
            this.customFiled = str;
            return this;
        }

        public Builder setEcifNo(String str) {
            this.ecifNo = str;
            return this;
        }

        public Builder setEnableWAService(boolean z10) {
            this.isEnableWAService = z10;
            return this;
        }

        public Builder setLogEnable(boolean z10) {
            this.logEnable = z10;
            return this;
        }

        public Builder setSubAppId(String str) {
            this.subAppId = str;
            return this;
        }

        public Builder setUnionId(String str) {
            this.unionId = str;
            return this;
        }
    }

    private WBSimpleStartParam(Builder builder) {
        this.isEnableService = builder.isEnableWAService;
        this.appId = builder.appId;
        this.baseUrl = builder.baseUrl;
        this.logEnable = builder.logEnable;
        this.ecifNo = builder.ecifNo;
        this.unionId = builder.unionId;
        this.openId = builder.openId;
        this.appVersion = builder.appVersion;
        this.customFiled = builder.customFiled;
        this.subAppId = TextUtils.isEmpty(builder.subAppId) ? "subAppId" : builder.subAppId;
    }

    public String getAppId() {
        return this.appId;
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public String getBaseUrl() {
        return this.baseUrl;
    }

    public String getCustomFiled() {
        return this.customFiled;
    }

    public String getEcifNo() {
        return this.ecifNo;
    }

    public String getOpenId() {
        return this.openId;
    }

    public String getSubAppId() {
        return this.subAppId;
    }

    public String getUnionId() {
        return this.unionId;
    }

    public boolean isEnableService() {
        return this.isEnableService;
    }

    public boolean isLogEnable() {
        return this.logEnable;
    }
}
