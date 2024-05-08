package com.bytedance.sdk.openadsdk.sy.m.m.m;

import android.os.Bundle;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import o0.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class m implements Bridge {
    private final TTRewardVideoAd.RewardAdInteractionListener dk;

    /* renamed from: m, reason: collision with root package name */
    private ValueSet f11412m = a.f52238b;

    public m(TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        this.dk = rewardAdInteractionListener;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i10, ValueSet valueSet, Class<T> cls) {
        TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this.dk;
        if (rewardAdInteractionListener == null) {
            return null;
        }
        switch (i10) {
            case 121101:
                rewardAdInteractionListener.onAdShow();
                break;
            case 121102:
                rewardAdInteractionListener.onAdVideoBarClick();
                break;
            case 121103:
                rewardAdInteractionListener.onAdClose();
                break;
            case 121104:
                rewardAdInteractionListener.onVideoComplete();
                break;
            case 121105:
                rewardAdInteractionListener.onVideoError();
                break;
            case 121106:
                this.dk.onRewardVerify(valueSet.booleanValue(0), valueSet.intValue(1), (String) valueSet.objectValue(2, String.class), valueSet.intValue(3), (String) valueSet.objectValue(4, String.class));
                break;
            case 121107:
                this.dk.onRewardArrived(valueSet.booleanValue(0), valueSet.intValue(1), (Bundle) valueSet.objectValue(2, Bundle.class));
                break;
            case 121108:
                rewardAdInteractionListener.onSkippedVideo();
                break;
        }
        m(i10, valueSet, cls);
        return null;
    }

    public void m(int i10, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f11412m;
    }
}
