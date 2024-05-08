package com.bytedance.sdk.openadsdk.ve.m.m.m;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import o0.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class ej implements Bridge {
    private final TTNativeExpressAd.ExpressVideoAdListener dk;

    /* renamed from: m, reason: collision with root package name */
    private ValueSet f11414m = a.f52238b;

    public ej(TTNativeExpressAd.ExpressVideoAdListener expressVideoAdListener) {
        this.dk = expressVideoAdListener;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i10, ValueSet valueSet, Class<T> cls) {
        TTNativeExpressAd.ExpressVideoAdListener expressVideoAdListener = this.dk;
        if (expressVideoAdListener == null) {
            return null;
        }
        switch (i10) {
            case 152101:
                expressVideoAdListener.onVideoLoad();
                break;
            case 152102:
                this.dk.onVideoError(valueSet.intValue(0), valueSet.intValue(1));
                break;
            case 152103:
                expressVideoAdListener.onVideoAdStartPlay();
                break;
            case 152104:
                expressVideoAdListener.onVideoAdPaused();
                break;
            case 152105:
                expressVideoAdListener.onVideoAdContinuePlay();
                break;
            case 152106:
                this.dk.onProgressUpdate(valueSet.longValue(0), valueSet.longValue(1));
                break;
            case 152107:
                expressVideoAdListener.onVideoAdComplete();
                break;
            case 152108:
                expressVideoAdListener.onClickRetry();
                break;
        }
        m(i10, valueSet, cls);
        return null;
    }

    public void m(int i10, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f11414m;
    }
}
