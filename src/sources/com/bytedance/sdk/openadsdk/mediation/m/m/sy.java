package com.bytedance.sdk.openadsdk.mediation.m.m;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.bytedance.sdk.openadsdk.mediation.IMediationInterstitialFullAdListener;
import o0.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class sy extends com.bytedance.sdk.openadsdk.ej.m.m.ve {

    /* renamed from: m, reason: collision with root package name */
    private Bridge f11386m;

    public sy(Bridge bridge) {
        super(bridge);
        this.f11386m = bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.ej.m.m.ve, com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void setFullScreenVideoAdInteractionListener(TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        a c4 = a.c(1);
        if (fullScreenVideoAdInteractionListener instanceof IMediationInterstitialFullAdListener) {
            c4.h(0, new com.bytedance.sdk.openadsdk.mediation.m.m.dk.dk((IMediationInterstitialFullAdListener) fullScreenVideoAdInteractionListener));
            c4.f(1, 1);
        } else {
            c4.h(0, new com.bytedance.sdk.openadsdk.oa.m.m.m.m(fullScreenVideoAdInteractionListener));
            c4.f(1, 0);
        }
        Bridge bridge = this.f11386m;
        if (bridge != null) {
            bridge.call(130101, c4.a(), Void.class);
        }
    }
}
