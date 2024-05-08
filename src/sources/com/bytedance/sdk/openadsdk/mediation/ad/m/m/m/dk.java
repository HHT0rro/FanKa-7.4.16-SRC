package com.bytedance.sdk.openadsdk.mediation.ad.m.m.m;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationDislikeCallback;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationAdDislike;
import o0.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class dk implements MediationAdDislike {

    /* renamed from: m, reason: collision with root package name */
    private final Bridge f11288m;

    public dk(Bridge bridge) {
        this.f11288m = bridge == null ? a.f52239c : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationAdDislike
    public void setDislikeCallback(IMediationDislikeCallback iMediationDislikeCallback) {
        a c4 = a.c(1);
        c4.h(0, new com.bytedance.sdk.openadsdk.mediation.ad.m.m.dk.dk(iMediationDislikeCallback));
        this.f11288m.call(270033, c4.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationAdDislike
    public void showDislikeDialog() {
        this.f11288m.call(270032, a.c(0).a(), Void.class);
    }
}
