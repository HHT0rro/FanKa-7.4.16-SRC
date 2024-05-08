package com.bytedance.sdk.openadsdk.oa.m.m.m;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import o0.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class m implements Bridge {
    private final TTFullScreenVideoAd.FullScreenVideoAdInteractionListener dk;

    /* renamed from: m, reason: collision with root package name */
    private ValueSet f11410m = a.f52238b;

    public m(TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        this.dk = fullScreenVideoAdInteractionListener;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i10, ValueSet valueSet, Class<T> cls) {
        TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener = this.dk;
        if (fullScreenVideoAdInteractionListener == null) {
            return null;
        }
        switch (i10) {
            case 131101:
                fullScreenVideoAdInteractionListener.onAdShow();
                break;
            case 131102:
                fullScreenVideoAdInteractionListener.onAdVideoBarClick();
                break;
            case 131103:
                fullScreenVideoAdInteractionListener.onAdClose();
                break;
            case 131104:
                fullScreenVideoAdInteractionListener.onVideoComplete();
                break;
            case 131105:
                fullScreenVideoAdInteractionListener.onSkippedVideo();
                break;
        }
        m(i10, valueSet, cls);
        return null;
    }

    public void m(int i10, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f11410m;
    }
}
