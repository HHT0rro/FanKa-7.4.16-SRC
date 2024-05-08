package com.kwad.components.ad.reward.check;

import androidx.annotation.NonNull;
import com.kwad.sdk.commercial.b;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class a {
    public static void a(@NonNull AdTemplate adTemplate, int i10, long j10, int i11, String str) {
        b.e(new RewardCheckMonitorInfo().setRequestStatus(2).setCheckType(i10).setEnviType(0).setDataLoadInterval(j10).setCode(i11).setErrorMsg(str).setCreativeId(com.kwad.sdk.core.response.b.a.J(e.dQ(adTemplate))).setAdTemplate(adTemplate));
    }

    public static void b(@NonNull AdTemplate adTemplate, int i10) {
        b.e(new RewardCheckMonitorInfo().setRequestStatus(1).setCheckType(i10).setEnviType(0).setCreativeId(com.kwad.sdk.core.response.b.a.J(e.dQ(adTemplate))).setAdTemplate(adTemplate));
    }
}
