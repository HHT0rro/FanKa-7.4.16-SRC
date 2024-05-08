package com.bytedance.sdk.openadsdk.mediation.m.m;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationExpressRenderListener;
import o0.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class c extends com.bytedance.sdk.openadsdk.ej.m.m.oa {

    /* renamed from: m, reason: collision with root package name */
    private Bridge f11369m;

    public c(Bridge bridge) {
        super(bridge);
        this.f11369m = bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.ej.m.m.oa, com.bytedance.sdk.openadsdk.TTNativeAd
    public void setExpressRenderListener(TTNativeAd.ExpressRenderListener expressRenderListener) {
        a c4 = a.c(1);
        if (expressRenderListener instanceof MediationExpressRenderListener) {
            c4.h(0, new com.bytedance.sdk.openadsdk.mediation.ad.m.m.dk.n((MediationExpressRenderListener) expressRenderListener));
            c4.f(1, 1);
        } else {
            c4.h(0, new com.bytedance.sdk.openadsdk.c.m.m.m.dk(expressRenderListener));
            c4.f(1, 0);
        }
        Bridge bridge = this.f11369m;
        if (bridge != null) {
            bridge.call(140111, c4.a(), Void.class);
        }
    }
}
