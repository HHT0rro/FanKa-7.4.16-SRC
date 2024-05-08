package com.bytedance.sdk.openadsdk.ej.m.ej;

import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.LocationProvider;
import o0.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class ej {
    public static final ValueSet m(LocationProvider locationProvider) {
        a b4 = a.b();
        if (locationProvider == null) {
            return null;
        }
        b4.d(262001, locationProvider.getLatitude());
        b4.d(262002, locationProvider.getLongitude());
        return b4.a();
    }
}
