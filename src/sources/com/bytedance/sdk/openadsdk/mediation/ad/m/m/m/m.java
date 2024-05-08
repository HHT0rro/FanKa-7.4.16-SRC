package com.bytedance.sdk.openadsdk.mediation.ad.m.m.m;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationAdDislike;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo;
import com.bytedance.sdk.openadsdk.mediation.ad.m.m.dk.np;
import java.util.List;
import java.util.Map;
import o0.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class m implements IMediationNativeAdInfo {

    /* renamed from: m, reason: collision with root package name */
    private final Bridge f11290m;

    public m(Bridge bridge) {
        this.f11290m = bridge == null ? a.f52239c : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public String getActionText() {
        return (String) this.f11290m.call(268005, a.c(0).a(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public int getAdImageMode() {
        return ((Integer) this.f11290m.call(268009, a.c(0).a(), Integer.TYPE)).intValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public String getDescription() {
        return (String) this.f11290m.call(268002, a.c(0).a(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public MediationAdDislike getDislikeDialog(Activity activity) {
        a c4 = a.c(1);
        c4.h(0, activity);
        return new dk((Bridge) this.f11290m.call(268102, c4.a(), Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public String getIconUrl() {
        return (String) this.f11290m.call(268003, a.c(0).a(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public List<String> getImageList() {
        return (List) this.f11290m.call(268007, a.c(0).a(), List.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public String getImageUrl() {
        return (String) this.f11290m.call(268004, a.c(0).a(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public int getInteractionType() {
        return ((Integer) this.f11290m.call(268010, a.c(0).a(), Integer.TYPE)).intValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public MediationNativeAdAppInfo getNativeAdAppInfo() {
        return new ej((Bridge) this.f11290m.values().objectValue(268101, Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public String getSource() {
        return (String) this.f11290m.call(268008, a.c(0).a(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public double getStarRating() {
        return ((Double) this.f11290m.call(268006, a.c(0).a(), Double.TYPE)).doubleValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public String getTitle() {
        return (String) this.f11290m.call(268001, a.c(0).a(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public boolean hasDislike() {
        return ((Boolean) this.f11290m.call(268012, a.c(0).a(), Boolean.TYPE)).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public void registerView(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, IMediationViewBinder iMediationViewBinder) {
        a c4 = a.c(6);
        c4.h(0, activity);
        c4.h(1, viewGroup);
        c4.h(2, list);
        c4.h(3, list2);
        c4.h(4, list3);
        c4.h(5, new np(iMediationViewBinder));
        this.f11290m.call(268011, c4.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public MediationAdDislike getDislikeDialog(Activity activity, Map<String, Object> map) {
        a c4 = a.c(2);
        c4.h(0, activity);
        c4.h(1, map);
        return new dk((Bridge) this.f11290m.call(268103, c4.a(), Bridge.class));
    }
}
