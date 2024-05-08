package com.bytedance.sdk.openadsdk.ej.m.m;

import android.app.Activity;
import android.view.View;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.DislikeInfo;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationNativeManager;
import java.util.Map;
import o0.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class q implements TTNativeExpressAd {

    /* renamed from: m, reason: collision with root package name */
    private final Bridge f11200m;

    public q(Bridge bridge) {
        this.f11200m = bridge == null ? a.f52239c : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void destroy() {
        this.f11200m.call(150105, a.c(0).a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public TTAdDislike getDislikeDialog(Activity activity) {
        a c4 = a.c(1);
        c4.h(0, activity);
        return new e((Bridge) this.f11200m.call(150108, c4.a(), Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public DislikeInfo getDislikeInfo() {
        return new l((Bridge) this.f11200m.values().objectValue(150003, Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public View getExpressAdView() {
        return (View) this.f11200m.values().objectValue(150001, View.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public int getImageMode() {
        return this.f11200m.values().intValue(150002);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public int getInteractionType() {
        return this.f11200m.values().intValue(150004);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public Map<String, Object> getMediaExtraInfo() {
        return (Map) this.f11200m.values().objectValue(150005, Map.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public MediationNativeManager getMediationManager() {
        return new com.bytedance.sdk.openadsdk.mediation.manager.m.m.m.l((Bridge) this.f11200m.call(150113, a.c(0).a(), Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void loss(Double d10, String str, String str2) {
        a c4 = a.c(3);
        c4.h(0, d10);
        c4.i(1, str);
        c4.i(2, str2);
        this.f11200m.call(210102, c4.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void render() {
        this.f11200m.call(150104, a.c(0).a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setCanInterruptVideoPlay(boolean z10) {
        a c4 = a.c(1);
        c4.j(0, z10);
        this.f11200m.call(150112, c4.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setDislikeCallback(Activity activity, TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        a c4 = a.c(2);
        c4.h(0, activity);
        c4.h(1, new com.bytedance.sdk.openadsdk.n.m.m.m.m(dislikeInteractionCallback));
        this.f11200m.call(150106, c4.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setDislikeDialog(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        a c4 = a.c(1);
        c4.h(0, tTDislikeDialogAbstract);
        this.f11200m.call(150107, c4.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        a c4 = a.c(1);
        c4.h(0, new com.bytedance.sdk.openadsdk.ej.m.dk.m(tTAppDownloadListener));
        this.f11200m.call(150103, c4.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setExpressInteractionListener(TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener) {
        a c4 = a.c(1);
        c4.h(0, new com.bytedance.sdk.openadsdk.ve.m.m.m.dk(expressAdInteractionListener));
        this.f11200m.call(150101, c4.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void setPrice(Double d10) {
        a c4 = a.c(1);
        c4.h(0, d10);
        this.f11200m.call(210103, c4.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setSlideIntervalTime(int i10) {
        a c4 = a.c(1);
        c4.f(0, i10);
        this.f11200m.call(150110, c4.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setVideoAdListener(TTNativeExpressAd.ExpressVideoAdListener expressVideoAdListener) {
        a c4 = a.c(1);
        c4.h(0, new com.bytedance.sdk.openadsdk.ve.m.m.m.ej(expressVideoAdListener));
        this.f11200m.call(150111, c4.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void showInteractionExpressAd(Activity activity) {
        a c4 = a.c(1);
        c4.h(0, activity);
        this.f11200m.call(150109, c4.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void win(Double d10) {
        a c4 = a.c(1);
        c4.h(0, d10);
        this.f11200m.call(210101, c4.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setExpressInteractionListener(TTNativeExpressAd.AdInteractionListener adInteractionListener) {
        a c4 = a.c(1);
        c4.h(0, new com.bytedance.sdk.openadsdk.ve.m.m.m.m(adInteractionListener));
        this.f11200m.call(150102, c4.a(), Void.class);
    }
}
