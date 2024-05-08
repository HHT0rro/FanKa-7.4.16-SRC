package com.alipay.sdk.auth;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class APAuthInfo {

    /* renamed from: a, reason: collision with root package name */
    private String f4462a;

    /* renamed from: b, reason: collision with root package name */
    private String f4463b;

    /* renamed from: c, reason: collision with root package name */
    private String f4464c;

    /* renamed from: d, reason: collision with root package name */
    private String f4465d;

    public APAuthInfo(String str, String str2, String str3) {
        this(str, str2, str3, null);
    }

    public String getAppId() {
        return this.f4462a;
    }

    public String getPid() {
        return this.f4464c;
    }

    public String getProductId() {
        return this.f4463b;
    }

    public String getRedirectUri() {
        return this.f4465d;
    }

    public APAuthInfo(String str, String str2, String str3, String str4) {
        this.f4462a = str;
        this.f4463b = str2;
        this.f4465d = str3;
        this.f4464c = str4;
    }
}
