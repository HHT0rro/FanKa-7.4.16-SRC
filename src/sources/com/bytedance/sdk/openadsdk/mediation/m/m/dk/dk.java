package com.bytedance.sdk.openadsdk.mediation.m.m.dk;

import android.os.Bundle;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.IMediationInterstitialFullAdListener;
import o0.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class dk implements Bridge {
    private final IMediationInterstitialFullAdListener dk;

    /* renamed from: m, reason: collision with root package name */
    private ValueSet f11371m = a.f52238b;

    public dk(IMediationInterstitialFullAdListener iMediationInterstitialFullAdListener) {
        this.dk = iMediationInterstitialFullAdListener;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i10, ValueSet valueSet, Class<T> cls) {
        IMediationInterstitialFullAdListener iMediationInterstitialFullAdListener = this.dk;
        if (iMediationInterstitialFullAdListener == null) {
            return null;
        }
        switch (i10) {
            case 131101:
                iMediationInterstitialFullAdListener.onAdShow();
                break;
            case 131102:
                iMediationInterstitialFullAdListener.onAdVideoBarClick();
                break;
            case 131103:
                iMediationInterstitialFullAdListener.onAdClose();
                break;
            case 131104:
                iMediationInterstitialFullAdListener.onVideoComplete();
                break;
            case 131105:
                iMediationInterstitialFullAdListener.onSkippedVideo();
                break;
            case 131106:
                this.dk.onInterstitialFullShowFail(valueSet.intValue(0), (String) valueSet.objectValue(1, String.class));
                break;
            case 131107:
                iMediationInterstitialFullAdListener.onVideoError();
                break;
            case 131108:
                iMediationInterstitialFullAdListener.onAdOpened();
                break;
            case 131109:
                iMediationInterstitialFullAdListener.onAdLeftApplication();
                break;
            case 131110:
                this.dk.onRewardVerify((Bundle) valueSet.objectValue(0, Bundle.class));
                break;
        }
        m(i10, valueSet, cls);
        return null;
    }

    public void m(int i10, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f11371m;
    }
}
