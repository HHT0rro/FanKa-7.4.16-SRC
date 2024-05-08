package com.bytedance.sdk.openadsdk.mediation.ad;

import com.bykv.vk.openvk.api.proto.Bridge;
import java.util.Map;
import o0.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class MApiIMediationViewBinderReversal implements IMediationViewBinderReversal {

    /* renamed from: m, reason: collision with root package name */
    private final Bridge f11242m;

    public MApiIMediationViewBinderReversal(Bridge bridge) {
        this.f11242m = bridge == null ? a.f52239c : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public int getCallToActionId() {
        return ((Integer) this.f11242m.call(271024, a.c(0).a(), Integer.TYPE)).intValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public int getDecriptionTextId() {
        return ((Integer) this.f11242m.call(271023, a.c(0).a(), Integer.TYPE)).intValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public Map<String, Integer> getExtras() {
        return (Map) this.f11242m.call(271034, a.c(0).a(), Map.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public int getGroupImage1Id() {
        return ((Integer) this.f11242m.call(271029, a.c(0).a(), Integer.TYPE)).intValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public int getGroupImage2Id() {
        return ((Integer) this.f11242m.call(271030, a.c(0).a(), Integer.TYPE)).intValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public int getGroupImage3Id() {
        return ((Integer) this.f11242m.call(271031, a.c(0).a(), Integer.TYPE)).intValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public int getIconImageId() {
        return ((Integer) this.f11242m.call(271025, a.c(0).a(), Integer.TYPE)).intValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public int getLayoutId() {
        return ((Integer) this.f11242m.call(271021, a.c(0).a(), Integer.TYPE)).intValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public int getLogoLayoutId() {
        return ((Integer) this.f11242m.call(271032, a.c(0).a(), Integer.TYPE)).intValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public int getMainImageId() {
        return ((Integer) this.f11242m.call(271026, a.c(0).a(), Integer.TYPE)).intValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public int getMediaViewId() {
        return ((Integer) this.f11242m.call(271027, a.c(0).a(), Integer.TYPE)).intValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public int getShakeViewContainerId() {
        return ((Integer) this.f11242m.call(271033, a.c(0).a(), Integer.TYPE)).intValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public int getSourceId() {
        return ((Integer) this.f11242m.call(271028, a.c(0).a(), Integer.TYPE)).intValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public int getTitleId() {
        return ((Integer) this.f11242m.call(271022, a.c(0).a(), Integer.TYPE)).intValue();
    }
}
