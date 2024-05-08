package com.bytedance.sdk.openadsdk.mediation.custom;

import com.bykv.vk.openvk.api.proto.ValueSet;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class MediationCustomServiceConfig {
    private String dk;
    private int ej;

    /* renamed from: l, reason: collision with root package name */
    private int f11332l;

    /* renamed from: m, reason: collision with root package name */
    private String f11333m;
    private String np;

    public MediationCustomServiceConfig(String str, String str2, int i10, int i11, String str3) {
        this.f11333m = str;
        this.dk = str2;
        this.ej = i10;
        this.f11332l = i11;
        this.np = str3;
    }

    public String getADNNetworkName() {
        return this.f11333m;
    }

    public String getADNNetworkSlotId() {
        return this.dk;
    }

    public int getAdStyleType() {
        return this.ej;
    }

    public String getCustomAdapterJson() {
        return this.np;
    }

    public int getSubAdtype() {
        return this.f11332l;
    }

    public String toString() {
        return "MediationCustomServiceConfig{mADNNetworkName='" + this.f11333m + "', mADNNetworkSlotId='" + this.dk + "', mAdStyleType=" + this.ej + ", mSubAdtype=" + this.f11332l + ", mCustomAdapterJson='" + this.np + "'}";
    }

    public MediationCustomServiceConfig(ValueSet valueSet) {
        if (valueSet != null) {
            this.f11333m = valueSet.stringValue(8003);
            this.dk = valueSet.stringValue(2);
            this.ej = valueSet.intValue(8008);
            this.f11332l = valueSet.intValue(8094);
            this.np = valueSet.stringValue(8547);
        }
    }
}
