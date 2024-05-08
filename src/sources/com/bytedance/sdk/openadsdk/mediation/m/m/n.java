package com.bytedance.sdk.openadsdk.mediation.m.m;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationDislikeCallback;
import o0.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class n implements IMediationDislikeCallback {

    /* renamed from: m, reason: collision with root package name */
    private final Bridge f11383m;

    public n(Bridge bridge) {
        this.f11383m = bridge == null ? a.f52239c : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationDislikeCallback
    public void onCancel() {
        this.f11383m.call(268014, a.c(0).a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationDislikeCallback
    public void onSelected(int i10, String str) {
        a c4 = a.c(2);
        c4.f(0, i10);
        c4.i(1, str);
        this.f11383m.call(268013, c4.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationDislikeCallback
    public void onShow() {
        this.f11383m.call(268015, a.c(0).a(), Void.class);
    }
}
