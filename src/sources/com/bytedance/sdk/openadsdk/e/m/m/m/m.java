package com.bytedance.sdk.openadsdk.e.m.m.m;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTDrawFeedAd;
import o0.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class m implements Bridge {
    private final TTDrawFeedAd.DrawVideoListener dk;

    /* renamed from: m, reason: collision with root package name */
    private ValueSet f11163m = a.f52238b;

    public m(TTDrawFeedAd.DrawVideoListener drawVideoListener) {
        this.dk = drawVideoListener;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i10, ValueSet valueSet, Class<T> cls) {
        TTDrawFeedAd.DrawVideoListener drawVideoListener = this.dk;
        if (drawVideoListener == null) {
            return null;
        }
        switch (i10) {
            case 171101:
                drawVideoListener.onClick();
                break;
            case 171102:
                drawVideoListener.onClickRetry();
                break;
        }
        m(i10, valueSet, cls);
        return null;
    }

    public void m(int i10, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f11163m;
    }
}
