package com.bytedance.sdk.openadsdk.dk.m.m.m;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.CSJSplashAd;
import o0.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class ej implements Bridge {
    private final CSJSplashAd.SplashClickEyeListener dk;

    /* renamed from: m, reason: collision with root package name */
    private ValueSet f11139m = a.f52238b;

    public ej(CSJSplashAd.SplashClickEyeListener splashClickEyeListener) {
        this.dk = splashClickEyeListener;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i10, ValueSet valueSet, Class<T> cls) {
        CSJSplashAd.SplashClickEyeListener splashClickEyeListener = this.dk;
        if (splashClickEyeListener == null) {
            return null;
        }
        switch (i10) {
            case 113101:
                this.dk.onSplashClickEyeReadyToShow(new com.bytedance.sdk.openadsdk.ej.m.m.dk((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 113102:
                splashClickEyeListener.onSplashClickEyeClick();
                break;
            case 113103:
                splashClickEyeListener.onSplashClickEyeClose();
                break;
        }
        m(i10, valueSet, cls);
        return null;
    }

    public void m(int i10, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f11139m;
    }
}
