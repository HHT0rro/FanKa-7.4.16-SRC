package com.bytedance.sdk.openadsdk.mediation.m.m.dk;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.IMediationDrawAdTokenCallback;
import o0.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class m implements Bridge {
    private final IMediationDrawAdTokenCallback dk;

    /* renamed from: m, reason: collision with root package name */
    private ValueSet f11374m = a.f52238b;

    public m(IMediationDrawAdTokenCallback iMediationDrawAdTokenCallback) {
        this.dk = iMediationDrawAdTokenCallback;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i10, ValueSet valueSet, Class<T> cls) {
        if (this.dk == null) {
            return null;
        }
        switch (i10) {
            case 270029:
                this.dk.onAdTokenLoaded((String) valueSet.objectValue(0, String.class), new com.bytedance.sdk.openadsdk.mediation.m.m.m.m((Bridge) valueSet.objectValue(1, Bridge.class)));
                break;
            case 270030:
                this.dk.onAdTokenLoadedFail(valueSet.intValue(0), (String) valueSet.objectValue(1, String.class));
                break;
        }
        m(i10, valueSet, cls);
        return null;
    }

    public void m(int i10, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f11374m;
    }
}
