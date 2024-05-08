package com.bytedance.sdk.openadsdk.mediation.m.m;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdNative;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class l extends com.bytedance.sdk.openadsdk.hc.m.m.m.l {

    /* renamed from: m, reason: collision with root package name */
    private TTAdNative.FullScreenVideoAdListener f11379m;

    public l(TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener) {
        super(fullScreenVideoAdListener);
        this.f11379m = fullScreenVideoAdListener;
    }

    @Override // com.bytedance.sdk.openadsdk.hc.m.m.m.l, com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i10, ValueSet valueSet, Class<T> cls) {
        if (i10 == 132102) {
            if (this.f11379m != null) {
                this.f11379m.onFullScreenVideoAdLoad(new sy((Bridge) valueSet.objectValue(0, Bridge.class)));
                return null;
            }
        } else if (i10 == 132103 && this.f11379m != null) {
            this.f11379m.onFullScreenVideoCached(new sy((Bridge) valueSet.objectValue(0, Bridge.class)));
            return null;
        }
        return (T) super.call(i10, valueSet, cls);
    }
}
