package com.bytedance.sdk.openadsdk.mediation;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.LocationProvider;
import com.google.android.material.shadow.ShadowDrawableWrapper;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class MediationLocationProviderImpl implements Bridge, LocationProvider {

    /* renamed from: m, reason: collision with root package name */
    private LocationProvider f11234m;

    public MediationLocationProviderImpl(LocationProvider locationProvider) {
        this.f11234m = locationProvider;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i10, ValueSet valueSet, Class<T> cls) {
        if (i10 == 8481) {
            return (T) Double.valueOf(getLatitude());
        }
        if (i10 == 8482) {
            return (T) Double.valueOf(getLongitude());
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.LocationProvider
    public double getLatitude() {
        LocationProvider locationProvider = this.f11234m;
        return locationProvider != null ? locationProvider.getLatitude() : ShadowDrawableWrapper.COS_45;
    }

    @Override // com.bytedance.sdk.openadsdk.LocationProvider
    public double getLongitude() {
        LocationProvider locationProvider = this.f11234m;
        return locationProvider != null ? locationProvider.getLongitude() : ShadowDrawableWrapper.COS_45;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }
}
