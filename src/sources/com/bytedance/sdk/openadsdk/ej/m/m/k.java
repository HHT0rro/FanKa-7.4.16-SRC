package com.bytedance.sdk.openadsdk.ej.m.m;

import android.app.Activity;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationRewardManager;
import java.util.Map;
import o0.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class k implements TTRewardVideoAd {

    /* renamed from: m, reason: collision with root package name */
    private final Bridge f11187m;

    public k(Bridge bridge) {
        this.f11187m = bridge == null ? a.f52239c : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public long getExpirationTimestamp() {
        return this.f11187m.values().longValue(120004);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public int getInteractionType() {
        return this.f11187m.values().intValue(120001);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public Map<String, Object> getMediaExtraInfo() {
        return (Map) this.f11187m.values().objectValue(120002, Map.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public MediationRewardManager getMediationManager() {
        return new com.bytedance.sdk.openadsdk.mediation.manager.m.m.m.np((Bridge) this.f11187m.call(121109, a.c(0).a(), Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public int getRewardVideoAdType() {
        return this.f11187m.values().intValue(120003);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void loss(Double d10, String str, String str2) {
        a c4 = a.c(3);
        c4.h(0, d10);
        c4.i(1, str);
        c4.i(2, str2);
        this.f11187m.call(210102, c4.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        a c4 = a.c(1);
        c4.h(0, new com.bytedance.sdk.openadsdk.ej.m.dk.m(tTAppDownloadListener));
        this.f11187m.call(120104, c4.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void setPrice(Double d10) {
        a c4 = a.c(1);
        c4.h(0, d10);
        this.f11187m.call(210103, c4.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void setRewardAdInteractionListener(TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        a c4 = a.c(1);
        c4.h(0, new com.bytedance.sdk.openadsdk.sy.m.m.m.m(rewardAdInteractionListener));
        this.f11187m.call(120101, c4.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void setRewardPlayAgainController(TTRewardVideoAd.RewardAdPlayAgainController rewardAdPlayAgainController) {
        a c4 = a.c(1);
        c4.h(0, new com.bytedance.sdk.openadsdk.sy.m.m.m.dk(rewardAdPlayAgainController));
        this.f11187m.call(120103, c4.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void setRewardPlayAgainInteractionListener(TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        a c4 = a.c(1);
        c4.h(0, new com.bytedance.sdk.openadsdk.sy.m.m.m.m(rewardAdInteractionListener));
        this.f11187m.call(120102, c4.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void setShowDownLoadBar(boolean z10) {
        a c4 = a.c(1);
        c4.j(0, z10);
        this.f11187m.call(120107, c4.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void showRewardVideoAd(Activity activity) {
        a c4 = a.c(1);
        c4.h(0, activity);
        this.f11187m.call(120105, c4.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void win(Double d10) {
        a c4 = a.c(1);
        c4.h(0, d10);
        this.f11187m.call(210101, c4.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void showRewardVideoAd(Activity activity, TTAdConstant.RitScenes ritScenes, String str) {
        a c4 = a.c(3);
        c4.h(0, activity);
        c4.h(1, ritScenes);
        c4.i(2, str);
        this.f11187m.call(120106, c4.a(), Void.class);
    }
}
