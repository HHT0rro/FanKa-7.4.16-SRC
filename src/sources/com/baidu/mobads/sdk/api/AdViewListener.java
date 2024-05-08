package com.baidu.mobads.sdk.api;

import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface AdViewListener {
    void onAdClick(JSONObject jSONObject);

    void onAdClose(JSONObject jSONObject);

    void onAdFailed(String str);

    void onAdReady(AdView adView);

    void onAdShow(JSONObject jSONObject);

    void onAdSwitch();
}
