package com.bytedance.sdk.openadsdk.mediation.ad;

import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class MediationNativeAdAppInfo {
    private String dk;

    /* renamed from: e, reason: collision with root package name */
    private Map<String, Object> f11265e;
    private long ej;

    /* renamed from: hc, reason: collision with root package name */
    private String f11266hc;

    /* renamed from: l, reason: collision with root package name */
    private String f11267l;

    /* renamed from: m, reason: collision with root package name */
    private String f11268m;

    /* renamed from: n, reason: collision with root package name */
    private String f11269n;
    private Map<String, String> np;

    public Map<String, Object> getAppInfoExtra() {
        return this.f11265e;
    }

    public String getAppName() {
        return this.f11268m;
    }

    public String getAuthorName() {
        return this.dk;
    }

    public long getPackageSizeBytes() {
        return this.ej;
    }

    public Map<String, String> getPermissionsMap() {
        return this.np;
    }

    public String getPermissionsUrl() {
        return this.f11267l;
    }

    public String getPrivacyAgreement() {
        return this.f11269n;
    }

    public String getVersionName() {
        return this.f11266hc;
    }

    public void setAppInfoExtra(Map<String, Object> map) {
        this.f11265e = map;
    }

    public void setAppName(String str) {
        this.f11268m = str;
    }

    public void setAuthorName(String str) {
        this.dk = str;
    }

    public void setPackageSizeBytes(long j10) {
        this.ej = j10;
    }

    public void setPermissionsMap(Map<String, String> map) {
        this.np = map;
    }

    public void setPermissionsUrl(String str) {
        this.f11267l = str;
    }

    public void setPrivacyAgreement(String str) {
        this.f11269n = str;
    }

    public void setVersionName(String str) {
        this.f11266hc = str;
    }
}
