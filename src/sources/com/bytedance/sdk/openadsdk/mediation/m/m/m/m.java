package com.bytedance.sdk.openadsdk.mediation.m.m.m;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.mediation.IMediationDrawTokenInfo;
import o0.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class m implements IMediationDrawTokenInfo {

    /* renamed from: m, reason: collision with root package name */
    private final Bridge f11382m;

    public m(Bridge bridge) {
        this.f11382m = bridge == null ? a.f52239c : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationDrawTokenInfo
    public void loadDrawAdByAdm(String str, TTAdNative.DrawFeedAdListener drawFeedAdListener) {
        a c4 = a.c(2);
        c4.i(0, str);
        c4.h(1, new com.bytedance.sdk.openadsdk.hc.m.m.m.dk(drawFeedAdListener));
        this.f11382m.call(270031, c4.a(), Void.class);
    }
}
