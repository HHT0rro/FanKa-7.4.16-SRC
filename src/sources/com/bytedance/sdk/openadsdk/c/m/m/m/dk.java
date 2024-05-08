package com.bytedance.sdk.openadsdk.c.m.m.m;

import android.view.View;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import o0.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class dk implements Bridge {
    private final TTNativeAd.ExpressRenderListener dk;

    /* renamed from: m, reason: collision with root package name */
    private ValueSet f11136m = a.f52238b;

    public dk(TTNativeAd.ExpressRenderListener expressRenderListener) {
        this.dk = expressRenderListener;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i10, ValueSet valueSet, Class<T> cls) {
        if (this.dk == null) {
            return null;
        }
        if (i10 == 142101) {
            this.dk.onRenderSuccess((View) valueSet.objectValue(0, View.class), valueSet.floatValue(1), valueSet.floatValue(2), valueSet.booleanValue(3));
        }
        m(i10, valueSet, cls);
        return null;
    }

    public void m(int i10, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f11136m;
    }
}
