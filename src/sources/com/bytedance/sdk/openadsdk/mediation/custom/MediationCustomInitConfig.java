package com.bytedance.sdk.openadsdk.mediation.custom;

import com.bykv.vk.openvk.api.proto.ValueSet;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class MediationCustomInitConfig {

    /* renamed from: c, reason: collision with root package name */
    private String f11324c;
    private String dk;

    /* renamed from: e, reason: collision with root package name */
    private String f11325e;
    private String ej;

    /* renamed from: hc, reason: collision with root package name */
    private String f11326hc;

    /* renamed from: l, reason: collision with root package name */
    private String f11327l;

    /* renamed from: m, reason: collision with root package name */
    private String f11328m;

    /* renamed from: n, reason: collision with root package name */
    private String f11329n;
    private String np;

    /* renamed from: oa, reason: collision with root package name */
    private String f11330oa;

    /* renamed from: w, reason: collision with root package name */
    private String f11331w;

    public MediationCustomInitConfig(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        this.ej = str;
        this.f11328m = str2;
        this.dk = str3;
        this.f11327l = str4;
        this.np = str5;
        this.f11329n = str6;
        this.f11326hc = str7;
        this.f11325e = str8;
        this.f11331w = str9;
        this.f11330oa = str10;
        this.f11324c = str11;
    }

    public String getADNName() {
        return this.ej;
    }

    public String getAdnInitClassName() {
        return this.f11327l;
    }

    public String getAppId() {
        return this.f11328m;
    }

    public String getAppKey() {
        return this.dk;
    }

    public String getBannerClassName() {
        return this.np;
    }

    public String getDrawClassName() {
        return this.f11324c;
    }

    public String getFeedClassName() {
        return this.f11330oa;
    }

    public String getFullVideoClassName() {
        return this.f11325e;
    }

    public String getInterstitialClassName() {
        return this.f11329n;
    }

    public String getRewardClassName() {
        return this.f11326hc;
    }

    public String getSplashClassName() {
        return this.f11331w;
    }

    public String toString() {
        return "MediationCustomInitConfig{mAppId='" + this.f11328m + "', mAppKey='" + this.dk + "', mADNName='" + this.ej + "', mAdnInitClassName='" + this.f11327l + "', mBannerClassName='" + this.np + "', mInterstitialClassName='" + this.f11329n + "', mRewardClassName='" + this.f11326hc + "', mFullVideoClassName='" + this.f11325e + "', mSplashClassName='" + this.f11331w + "', mFeedClassName='" + this.f11330oa + "', mDrawClassName='" + this.f11324c + "'}";
    }

    public MediationCustomInitConfig(ValueSet valueSet) {
        if (valueSet != null) {
            this.ej = valueSet.stringValue(8003);
            this.f11328m = valueSet.stringValue(8534);
            this.dk = valueSet.stringValue(8535);
            this.f11327l = valueSet.stringValue(8536);
            this.np = valueSet.stringValue(8537);
            this.f11329n = valueSet.stringValue(8538);
            this.f11326hc = valueSet.stringValue(8539);
            this.f11325e = valueSet.stringValue(8540);
            this.f11331w = valueSet.stringValue(8541);
            this.f11330oa = valueSet.stringValue(8542);
            this.f11324c = valueSet.stringValue(8543);
        }
    }
}
