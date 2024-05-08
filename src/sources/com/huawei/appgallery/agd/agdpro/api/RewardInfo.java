package com.huawei.appgallery.agd.agdpro.api;

import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class RewardInfo {
    public static final int VERIFIED = 0;

    /* renamed from: a, reason: collision with root package name */
    public final JSONObject f27228a;

    /* renamed from: b, reason: collision with root package name */
    public int f27229b;

    /* renamed from: c, reason: collision with root package name */
    public String f27230c;

    public RewardInfo(JSONObject jSONObject, int i10, String str) {
        this.f27228a = jSONObject;
        this.f27229b = i10;
        this.f27230c = str;
    }

    public int getCode() {
        return this.f27229b;
    }

    public String getMessage() {
        return this.f27230c;
    }

    public String getName() {
        JSONObject jSONObject = this.f27228a;
        return jSONObject == null ? "" : jSONObject.optString("rewardName");
    }

    public int getNumber() {
        JSONObject jSONObject = this.f27228a;
        if (jSONObject == null) {
            return 0;
        }
        return jSONObject.optInt("rewardNumber");
    }

    public long getTime() {
        JSONObject jSONObject = this.f27228a;
        if (jSONObject == null) {
            return 0L;
        }
        return jSONObject.optLong("rewardTime");
    }

    public boolean isVerified() {
        return this.f27229b == 0;
    }
}
