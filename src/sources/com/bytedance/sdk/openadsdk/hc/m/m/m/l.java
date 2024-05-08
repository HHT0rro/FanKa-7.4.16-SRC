package com.bytedance.sdk.openadsdk.hc.m.m.m;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.ej.m.m.ve;
import o0.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class l implements Bridge {
    private final TTAdNative.FullScreenVideoAdListener dk;

    /* renamed from: m, reason: collision with root package name */
    private ValueSet f11208m = a.f52238b;

    public l(TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener) {
        this.dk = fullScreenVideoAdListener;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i10, ValueSet valueSet, Class<T> cls) {
        TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener = this.dk;
        if (fullScreenVideoAdListener == null) {
            return null;
        }
        switch (i10) {
            case 132101:
                this.dk.onError(valueSet.intValue(0), (String) valueSet.objectValue(1, String.class));
                break;
            case 132102:
                this.dk.onFullScreenVideoAdLoad(new ve((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 132103:
                this.dk.onFullScreenVideoCached(new ve((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 132104:
                fullScreenVideoAdListener.onFullScreenVideoCached();
                break;
        }
        m(i10, valueSet, cls);
        return null;
    }

    public void m(int i10, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f11208m;
    }
}
