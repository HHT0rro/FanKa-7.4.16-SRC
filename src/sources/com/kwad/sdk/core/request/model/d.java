package com.kwad.sdk.core.request.model;

import android.content.Context;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.au;
import com.kwad.sdk.utils.av;

@KsJson
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class d extends com.kwad.sdk.core.response.a.a {
    public String azF;
    public String azG;
    public int azH;
    public int azI;

    public static d Fc() {
        d dVar = new d();
        try {
            Context KO = ServiceProvider.KO();
            dVar.azF = av.cx(KO);
            dVar.azG = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).yt();
            dVar.azH = ag.ck(KO);
            dVar.azI = ag.d(KO, av.cA(KO), au.Mq());
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
        return dVar;
    }

    public static d Fd() {
        d dVar = new d();
        dVar.azH = ag.ck(ServiceProvider.getContext());
        return dVar;
    }
}
