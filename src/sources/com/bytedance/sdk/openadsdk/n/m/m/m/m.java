package com.bytedance.sdk.openadsdk.n.m.m.m;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import o0.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class m implements Bridge {
    private final TTAdDislike.DislikeInteractionCallback dk;

    /* renamed from: m, reason: collision with root package name */
    private ValueSet f11405m = a.f52238b;

    public m(TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        this.dk = dislikeInteractionCallback;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i10, ValueSet valueSet, Class<T> cls) {
        TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback = this.dk;
        if (dislikeInteractionCallback == null) {
            return null;
        }
        switch (i10) {
            case 244101:
                dislikeInteractionCallback.onShow();
                break;
            case 244102:
                this.dk.onSelected(valueSet.intValue(0), (String) valueSet.objectValue(1, String.class), valueSet.booleanValue(2));
                break;
            case 244103:
                dislikeInteractionCallback.onCancel();
                break;
        }
        m(i10, valueSet, cls);
        return null;
    }

    public void m(int i10, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f11405m;
    }
}
