package com.bytedance.sdk.openadsdk.ej.m.m;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.CSJSplashAd;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationSplashManager;
import java.util.Map;
import o0.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class dk implements CSJSplashAd {

    /* renamed from: m, reason: collision with root package name */
    private final Bridge f11183m;

    public dk(Bridge bridge) {
        this.f11183m = bridge == null ? a.f52239c : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public int getInteractionType() {
        return this.f11183m.values().intValue(110004);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public Map<String, Object> getMediaExtraInfo() {
        return (Map) this.f11183m.values().objectValue(110005, Map.class);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public MediationSplashManager getMediationManager() {
        return new com.bytedance.sdk.openadsdk.mediation.manager.m.m.m.n((Bridge) this.f11183m.call(110110, a.c(0).a(), Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public View getSplashCardView() {
        return (View) this.f11183m.values().objectValue(110003, View.class);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public int[] getSplashClickEyeSizeToDp() {
        return (int[]) this.f11183m.values().objectValue(110006, int[].class);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public View getSplashClickEyeView() {
        return (View) this.f11183m.values().objectValue(110002, View.class);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public View getSplashView() {
        return (View) this.f11183m.values().objectValue(110001, View.class);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public void hideSkipButton() {
        this.f11183m.call(110101, a.c(0).a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void loss(Double d10, String str, String str2) {
        a c4 = a.c(3);
        c4.h(0, d10);
        c4.i(1, str);
        c4.i(2, str2);
        this.f11183m.call(210102, c4.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        a c4 = a.c(1);
        c4.h(0, new com.bytedance.sdk.openadsdk.ej.m.dk.m(tTAppDownloadListener));
        this.f11183m.call(110102, c4.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void setPrice(Double d10) {
        a c4 = a.c(1);
        c4.h(0, d10);
        this.f11183m.call(210103, c4.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public void setSplashAdListener(CSJSplashAd.SplashAdListener splashAdListener) {
        a c4 = a.c(1);
        c4.h(0, new com.bytedance.sdk.openadsdk.dk.m.m.m.m(splashAdListener));
        this.f11183m.call(110103, c4.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public void setSplashCardListener(CSJSplashAd.SplashCardListener splashCardListener) {
        a c4 = a.c(1);
        c4.h(0, new com.bytedance.sdk.openadsdk.dk.m.m.m.dk(splashCardListener));
        this.f11183m.call(110106, c4.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public void setSplashClickEyeListener(CSJSplashAd.SplashClickEyeListener splashClickEyeListener) {
        a c4 = a.c(1);
        c4.h(0, new com.bytedance.sdk.openadsdk.dk.m.m.m.ej(splashClickEyeListener));
        this.f11183m.call(110105, c4.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public void showSplashCardView(ViewGroup viewGroup, Activity activity) {
        a c4 = a.c(2);
        c4.h(0, viewGroup);
        c4.h(1, activity);
        this.f11183m.call(110109, c4.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public void showSplashClickEyeView(ViewGroup viewGroup) {
        a c4 = a.c(1);
        c4.h(0, viewGroup);
        this.f11183m.call(110107, c4.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public void showSplashView(ViewGroup viewGroup) {
        a c4 = a.c(1);
        c4.h(0, viewGroup);
        this.f11183m.call(110108, c4.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public void startClickEye() {
        this.f11183m.call(110104, a.c(0).a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void win(Double d10) {
        a c4 = a.c(1);
        c4.h(0, d10);
        this.f11183m.call(210101, c4.a(), Void.class);
    }
}
