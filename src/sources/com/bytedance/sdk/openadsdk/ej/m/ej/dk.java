package com.bytedance.sdk.openadsdk.ej.m.ej;

import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.AdSlot;
import o0.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class dk {
    public static final ValueSet dk(final AdSlot adSlot) {
        a b4 = a.b();
        if (adSlot == null) {
            return null;
        }
        b4.i(260001, adSlot.getAdId());
        b4.i(260002, adSlot.getCreativeId());
        b4.i(260003, adSlot.getExt());
        b4.i(260004, adSlot.getCodeId());
        b4.j(260005, adSlot.isAutoPlay());
        b4.f(260006, adSlot.getImgAcceptedWidth());
        b4.f(260007, adSlot.getImgAcceptedHeight());
        b4.e(260008, adSlot.getExpressViewAcceptedWidth());
        b4.e(260009, adSlot.getExpressViewAcceptedHeight());
        b4.j(260010, adSlot.isSupportDeepLink());
        b4.j(260011, adSlot.isSupportRenderConrol());
        b4.f(2600012, adSlot.getAdCount());
        b4.i(260013, adSlot.getMediaExtra());
        b4.i(260014, adSlot.getUserID());
        b4.f(260015, adSlot.getOrientation());
        b4.f(260016, adSlot.getNativeAdType());
        b4.h(260017, adSlot.getExternalABVid());
        b4.f(260018, adSlot.getAdloadSeq());
        b4.i(260019, adSlot.getPrimeRit());
        b4.f(260020, adSlot.getAdType());
        b4.i(260021, adSlot.getBidAdm());
        b4.i(260022, adSlot.getUserData());
        b4.h(260023, adSlot.getAdLoadType());
        b4.h(260024, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.ej.m.ej.dk.1
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: m, reason: merged with bridge method [inline-methods] */
            public String get() {
                return AdSlot.this.getRewardName();
            }
        });
        b4.h(260025, new ValueSet.ValueGetter<Integer>() { // from class: com.bytedance.sdk.openadsdk.ej.m.ej.dk.2
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: m, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(AdSlot.this.getRewardAmount());
            }
        });
        b4.h(260026, adSlot.getMediationAdSlot());
        return b4.a();
    }
}
