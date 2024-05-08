package com.bytedance.sdk.openadsdk.l.m.m.m.m;

import android.os.Bundle;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import o0.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class m implements TTRewardVideoAd.RewardAdPlayAgainController.Callback {

    /* renamed from: m, reason: collision with root package name */
    private final Bridge f11212m;

    public m(Bridge bridge) {
        this.f11212m = bridge == null ? a.f52239c : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdPlayAgainController.Callback
    public void onConditionReturn(Bundle bundle) {
        a c4 = a.c(1);
        c4.h(0, bundle);
        this.f11212m.call(123101, c4.a(), Void.class);
    }
}
