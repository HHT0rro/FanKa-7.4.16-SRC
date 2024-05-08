package com.huawei.appgallery.coreservice.api;

import java.io.Serializable;
import w9.m;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class ConnectConfig implements Cloneable, Serializable {

    /* renamed from: a, reason: collision with root package name */
    private String f27565a;

    /* renamed from: b, reason: collision with root package name */
    private String f27566b;

    /* renamed from: c, reason: collision with root package name */
    private String f27567c;

    /* renamed from: d, reason: collision with root package name */
    private String f27568d;

    /* renamed from: e, reason: collision with root package name */
    private String f27569e;

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public ConnectConfig m2856clone() {
        try {
            return (ConnectConfig) super.clone();
        } catch (CloneNotSupportedException e2) {
            m.c("ConnectConfig", "ConnectConfig Clone error:" + e2.getMessage());
            return null;
        }
    }

    public String getAppFingerprintSignature() {
        return this.f27569e;
    }

    public String getAppSignCertchain() {
        return this.f27568d;
    }

    public String getConnectAppPkg() {
        return this.f27566b;
    }

    public String getConnectServiceAction() {
        return this.f27565a;
    }

    public String getInstallAppName() {
        return this.f27567c;
    }

    public void setAppFingerprintSignature(String str) {
        this.f27569e = str;
    }

    public void setAppSignCertchain(String str) {
        this.f27568d = str;
    }

    public void setConnectAppPkg(String str) {
        this.f27566b = str;
    }

    public void setConnectServiceAction(String str) {
        this.f27565a = str;
    }

    public void setInstallAppName(String str) {
        this.f27567c = str;
    }
}
