package com.bytedance.sdk.openadsdk.mediation.manager;

import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class MediationAdEcpmInfo {

    /* renamed from: c, reason: collision with root package name */
    private String f11389c;
    private String dk;

    /* renamed from: e, reason: collision with root package name */
    private String f11390e;
    private String ej;

    /* renamed from: hc, reason: collision with root package name */
    private String f11391hc;

    /* renamed from: l, reason: collision with root package name */
    private String f11392l;

    /* renamed from: m, reason: collision with root package name */
    private String f11393m;

    /* renamed from: n, reason: collision with root package name */
    private int f11394n;
    private String np;

    /* renamed from: oa, reason: collision with root package name */
    private String f11395oa;

    /* renamed from: q, reason: collision with root package name */
    private Map<String, String> f11396q;

    /* renamed from: r, reason: collision with root package name */
    private String f11397r;
    private String sy;
    private String ve;

    /* renamed from: w, reason: collision with root package name */
    private String f11398w;

    public MediationAdEcpmInfo() {
        this.f11396q = new HashMap();
    }

    public String getAbTestId() {
        return this.sy;
    }

    public String getChannel() {
        return this.f11389c;
    }

    public Map<String, String> getCustomData() {
        return this.f11396q;
    }

    public String getCustomSdkName() {
        return this.dk;
    }

    public String getEcpm() {
        return this.np;
    }

    public String getErrorMsg() {
        return this.f11391hc;
    }

    public String getLevelTag() {
        return this.f11392l;
    }

    public int getReqBiddingType() {
        return this.f11394n;
    }

    public String getRequestId() {
        return this.f11390e;
    }

    public String getRitType() {
        return this.f11398w;
    }

    public String getScenarioId() {
        return this.f11397r;
    }

    public String getSdkName() {
        return this.f11393m;
    }

    public String getSegmentId() {
        return this.f11395oa;
    }

    public String getSlotId() {
        return this.ej;
    }

    public String getSubChannel() {
        return this.ve;
    }

    public MediationAdEcpmInfo(String str, String str2, String str3, String str4, String str5, int i10, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, Map<String, String> map) {
        HashMap hashMap = new HashMap();
        this.f11396q = hashMap;
        this.f11393m = str;
        this.dk = str2;
        this.ej = str3;
        this.f11392l = str4;
        this.np = str5;
        this.f11394n = i10;
        this.f11391hc = str6;
        this.f11390e = str7;
        this.f11398w = str8;
        this.f11395oa = str9;
        this.f11389c = str10;
        this.ve = str11;
        this.sy = str12;
        this.f11397r = str13;
        if (map != null) {
            this.f11396q = map;
        } else {
            hashMap.clear();
        }
    }
}
