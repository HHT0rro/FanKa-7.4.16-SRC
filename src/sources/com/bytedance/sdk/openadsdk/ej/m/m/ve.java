package com.bytedance.sdk.openadsdk.ej.m.m;

import android.app.Activity;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationFullScreenManager;
import java.util.Map;
import o0.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class ve implements TTFullScreenVideoAd {

    /* renamed from: m, reason: collision with root package name */
    private final Bridge f11203m;

    public ve(Bridge bridge) {
        this.f11203m = bridge == null ? a.f52239c : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public long getExpirationTimestamp() {
        return this.f11203m.values().longValue(130004);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public int getFullVideoAdType() {
        return this.f11203m.values().intValue(130003);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public int getInteractionType() {
        return this.f11203m.values().intValue(130001);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public Map<String, Object> getMediaExtraInfo() {
        return (Map) this.f11203m.values().objectValue(130002, Map.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public MediationFullScreenManager getMediationManager() {
        return new com.bytedance.sdk.openadsdk.mediation.manager.m.m.m.ej((Bridge) this.f11203m.call(130106, a.c(0).a(), Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void loss(Double d10, String str, String str2) {
        a c4 = a.c(3);
        c4.h(0, d10);
        c4.i(1, str);
        c4.i(2, str2);
        this.f11203m.call(210102, c4.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        a c4 = a.c(1);
        c4.h(0, new com.bytedance.sdk.openadsdk.ej.m.dk.m(tTAppDownloadListener));
        this.f11203m.call(130102, c4.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void setFullScreenVideoAdInteractionListener(TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        a c4 = a.c(1);
        c4.h(0, new com.bytedance.sdk.openadsdk.oa.m.m.m.m(fullScreenVideoAdInteractionListener));
        this.f11203m.call(130101, c4.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void setPrice(Double d10) {
        a c4 = a.c(1);
        c4.h(0, d10);
        this.f11203m.call(210103, c4.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void setShowDownLoadBar(boolean z10) {
        a c4 = a.c(1);
        c4.j(0, z10);
        this.f11203m.call(130105, c4.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void showFullScreenVideoAd(Activity activity) {
        a c4 = a.c(1);
        c4.h(0, activity);
        this.f11203m.call(130103, c4.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void win(Double d10) {
        a c4 = a.c(1);
        c4.h(0, d10);
        this.f11203m.call(210101, c4.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void showFullScreenVideoAd(Activity activity, TTAdConstant.RitScenes ritScenes, String str) {
        a c4 = a.c(3);
        c4.h(0, activity);
        c4.h(1, ritScenes);
        c4.i(2, str);
        this.f11203m.call(130104, c4.a(), Void.class);
    }
}
