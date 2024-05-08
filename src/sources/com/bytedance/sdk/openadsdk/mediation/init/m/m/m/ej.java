package com.bytedance.sdk.openadsdk.mediation.init.m.m.m;

import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.init.MediationConfigUserInfoForSegment;
import o0.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class ej {
    public static final ValueSet m(MediationConfigUserInfoForSegment mediationConfigUserInfoForSegment) {
        a b4 = a.b();
        if (mediationConfigUserInfoForSegment == null) {
            return null;
        }
        b4.h(265007, mediationConfigUserInfoForSegment.getCustomInfos());
        b4.i(265001, mediationConfigUserInfoForSegment.getUserId());
        b4.i(265002, mediationConfigUserInfoForSegment.getChannel());
        b4.i(265003, mediationConfigUserInfoForSegment.getSubChannel());
        b4.f(265004, mediationConfigUserInfoForSegment.getAge());
        b4.i(265005, mediationConfigUserInfoForSegment.getGender());
        b4.i(265006, mediationConfigUserInfoForSegment.getUserValueGroup());
        return b4.a();
    }
}
