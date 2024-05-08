package com.bytedance.sdk.openadsdk.hc.m.m.m;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdNative;
import o0.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class m implements Bridge {
    private final TTAdNative.CSJSplashAdListener dk;

    /* renamed from: m, reason: collision with root package name */
    private ValueSet f11209m = a.f52238b;

    public m(TTAdNative.CSJSplashAdListener cSJSplashAdListener) {
        this.dk = cSJSplashAdListener;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i10, ValueSet valueSet, Class<T> cls) {
        TTAdNative.CSJSplashAdListener cSJSplashAdListener = this.dk;
        if (cSJSplashAdListener == null) {
            return null;
        }
        switch (i10) {
            case 114102:
                cSJSplashAdListener.onSplashLoadSuccess();
                break;
            case 114103:
                this.dk.onSplashLoadFail(new com.bytedance.sdk.openadsdk.ej.m.m.m((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 114104:
                this.dk.onSplashRenderSuccess(new com.bytedance.sdk.openadsdk.ej.m.m.dk((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 114105:
                this.dk.onSplashRenderFail(new com.bytedance.sdk.openadsdk.ej.m.m.dk((Bridge) valueSet.objectValue(0, Bridge.class)), new com.bytedance.sdk.openadsdk.ej.m.m.m((Bridge) valueSet.objectValue(1, Bridge.class)));
                break;
        }
        m(i10, valueSet, cls);
        return null;
    }

    public void m(int i10, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f11209m;
    }
}
