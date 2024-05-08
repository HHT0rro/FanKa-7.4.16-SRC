package com.bytedance.sdk.openadsdk.mediation.bridge.valueset;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.bridge.IMediationLocation;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationValueSetBuilder;
import com.google.android.material.shadow.ShadowDrawableWrapper;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class MediationLocationImpl implements Bridge {

    /* renamed from: m, reason: collision with root package name */
    private IMediationLocation f11323m;

    public MediationLocationImpl(IMediationLocation iMediationLocation) {
        this.f11323m = iMediationLocation;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i10, ValueSet valueSet, Class<T> cls) {
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        MediationValueSetBuilder create = MediationValueSetBuilder.create();
        IMediationLocation iMediationLocation = this.f11323m;
        double d10 = ShadowDrawableWrapper.COS_45;
        create.add(8481, iMediationLocation != null ? iMediationLocation.getLatitude() : 0.0d);
        IMediationLocation iMediationLocation2 = this.f11323m;
        if (iMediationLocation2 != null) {
            d10 = iMediationLocation2.getLongitude();
        }
        create.add(8482, d10);
        return create.build();
    }
}
