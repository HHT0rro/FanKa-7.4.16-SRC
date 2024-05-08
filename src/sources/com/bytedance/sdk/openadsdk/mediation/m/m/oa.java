package com.bytedance.sdk.openadsdk.mediation.m.m;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationAdDislike;
import o0.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class oa implements Bridge {
    private final MediationAdDislike dk;

    /* renamed from: m, reason: collision with root package name */
    private ValueSet f11385m = a.f52238b;

    public oa(MediationAdDislike mediationAdDislike) {
        this.dk = mediationAdDislike;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i10, ValueSet valueSet, Class<T> cls) {
        MediationAdDislike mediationAdDislike = this.dk;
        if (mediationAdDislike == null) {
            return null;
        }
        switch (i10) {
            case 270032:
                mediationAdDislike.showDislikeDialog();
                break;
            case 270033:
                this.dk.setDislikeCallback(new n((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
        }
        m(i10, valueSet, cls);
        return null;
    }

    public void m(int i10, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f11385m;
    }
}
