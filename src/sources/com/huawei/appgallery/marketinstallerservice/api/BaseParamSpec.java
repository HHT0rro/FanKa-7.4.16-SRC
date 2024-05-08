package com.huawei.appgallery.marketinstallerservice.api;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class BaseParamSpec {

    /* renamed from: a, reason: collision with root package name */
    public String f27604a = null;

    /* renamed from: b, reason: collision with root package name */
    public String f27605b = null;

    /* renamed from: c, reason: collision with root package name */
    public String f27606c = null;

    /* renamed from: d, reason: collision with root package name */
    public boolean f27607d = false;

    public String getMarketPkg() {
        return this.f27606c;
    }

    public String getServerUrl() {
        return this.f27604a;
    }

    public String getSubsystem() {
        return this.f27605b;
    }

    public boolean isUpdate() {
        return this.f27607d;
    }

    public void setMarketPkg(String str) {
        this.f27606c = str;
    }

    public void setServerUrl(String str) {
        this.f27604a = str;
    }

    public void setSubsystem(String str) {
        this.f27605b = str;
    }

    public void setUpdate(boolean z10) {
        this.f27607d = z10;
    }
}
