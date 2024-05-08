package com.bytedance.sdk.openadsdk.dk.m.m.m;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.CSJSplashAd;
import o0.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class dk implements Bridge {
    private final CSJSplashAd.SplashCardListener dk;

    /* renamed from: m, reason: collision with root package name */
    private ValueSet f11138m = a.f52238b;

    public dk(CSJSplashAd.SplashCardListener splashCardListener) {
        this.dk = splashCardListener;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i10, ValueSet valueSet, Class<T> cls) {
        CSJSplashAd.SplashCardListener splashCardListener = this.dk;
        if (splashCardListener == null) {
            return null;
        }
        switch (i10) {
            case 112102:
                splashCardListener.onSplashCardClick();
                break;
            case 112103:
                splashCardListener.onSplashCardClose();
                break;
            case 121201:
                this.dk.onSplashCardReadyToShow(new com.bytedance.sdk.openadsdk.ej.m.m.dk((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
        }
        m(i10, valueSet, cls);
        return null;
    }

    public void m(int i10, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f11138m;
    }
}
