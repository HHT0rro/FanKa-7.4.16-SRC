package com.bytedance.sdk.openadsdk.mediation;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface IMediationNativeAdTokenCallback {
    void onAdTokenLoaded(String str, IMediationNativeTokenInfo iMediationNativeTokenInfo);

    void onAdTokenLoadedFail(int i10, String str);
}
