package com.bytedance.sdk.openadsdk.mediation.m.m.m;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.mediation.IMediationNativeTokenInfo;
import o0.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class ej implements IMediationNativeTokenInfo {

    /* renamed from: m, reason: collision with root package name */
    private final Bridge f11381m;

    public ej(Bridge bridge) {
        this.f11381m = bridge == null ? a.f52239c : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationNativeTokenInfo
    public void loadNativeAdByAdm(String str, TTAdNative.FeedAdListener feedAdListener) {
        a c4 = a.c(2);
        c4.i(0, str);
        c4.h(1, new com.bytedance.sdk.openadsdk.hc.m.m.m.ej(feedAdListener));
        this.f11381m.call(270028, c4.a(), Void.class);
    }
}
