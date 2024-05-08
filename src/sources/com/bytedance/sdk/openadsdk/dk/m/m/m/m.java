package com.bytedance.sdk.openadsdk.dk.m.m.m;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.CSJSplashAd;
import o0.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class m implements Bridge {
    private final CSJSplashAd.SplashAdListener dk;

    /* renamed from: m, reason: collision with root package name */
    private ValueSet f11140m = a.f52238b;

    public m(CSJSplashAd.SplashAdListener splashAdListener) {
        this.dk = splashAdListener;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i10, ValueSet valueSet, Class<T> cls) {
        if (this.dk == null) {
            return null;
        }
        switch (i10) {
            case 111101:
                this.dk.onSplashAdShow(new com.bytedance.sdk.openadsdk.ej.m.m.dk((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 111102:
                this.dk.onSplashAdClick(new com.bytedance.sdk.openadsdk.ej.m.m.dk((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 111103:
                this.dk.onSplashAdClose(new com.bytedance.sdk.openadsdk.ej.m.m.dk((Bridge) valueSet.objectValue(0, Bridge.class)), valueSet.intValue(1));
                break;
        }
        m(i10, valueSet, cls);
        return null;
    }

    public void m(int i10, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f11140m;
    }
}
