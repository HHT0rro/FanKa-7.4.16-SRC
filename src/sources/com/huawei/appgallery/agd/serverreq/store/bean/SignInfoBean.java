package com.huawei.appgallery.agd.serverreq.store.bean;

import com.huawei.appgallery.agd.serverreq.json.JsonBean;
import com.huawei.appgallery.agd.serverreq.json.annotation.NetworkTransmission;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class SignInfoBean extends JsonBean {

    @NetworkTransmission
    private String deviceId;

    @NetworkTransmission
    private String deviceLanguage;

    @NetworkTransmission
    private String sign;

    @NetworkTransmission
    private long timestamp;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        public String f27536a;

        /* renamed from: b, reason: collision with root package name */
        public String f27537b;

        /* renamed from: c, reason: collision with root package name */
        public long f27538c;

        /* renamed from: d, reason: collision with root package name */
        public String f27539d;

        public SignInfoBean build() {
            SignInfoBean signInfoBean = new SignInfoBean();
            signInfoBean.deviceId = this.f27536a;
            signInfoBean.deviceLanguage = this.f27537b;
            signInfoBean.timestamp = this.f27538c;
            signInfoBean.sign = this.f27539d;
            return signInfoBean;
        }

        public Builder deviceId(String str) {
            this.f27536a = str;
            return this;
        }

        public Builder deviceLanguage(String str) {
            this.f27537b = str;
            return this;
        }

        public Builder sign(String str) {
            this.f27539d = str;
            return this;
        }

        public Builder timestamp(long j10) {
            this.f27538c = j10;
            return this;
        }
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public String getDeviceLanguage() {
        return this.deviceLanguage;
    }

    public String getSign() {
        return this.sign;
    }

    public long getTimestamp() {
        return this.timestamp;
    }
}
