package com.kwad.components.ad.reward.model;

import com.huawei.quickcard.base.Attributes;
import com.kwad.sdk.core.response.model.AdInfo;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class d {
    public static String m(AdInfo adInfo) {
        return com.kwad.sdk.core.response.b.a.cL(adInfo) ? "live" : com.kwad.sdk.core.response.b.a.bd(adInfo) ? Attributes.Component.IMAGE : com.kwad.sdk.core.response.b.a.bX(adInfo) ? "reward_preview" : "video";
    }
}
