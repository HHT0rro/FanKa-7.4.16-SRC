package com.kwad.sdk.ranger.b;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.b;
import com.kwad.sdk.commercial.c;
import com.kwad.sdk.ranger.b.a.d;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class a {
    public static final String TAG = "Ranger_" + a.class.getSimpleName();

    public static void a(d dVar) {
        b.d(c.AJ().cu(ILoggerReporter.Category.APM_LOG).i(1.0d).N("ad_sdk_detect_info", "stats_ranger").u(dVar).a(com.kwai.adclient.kscommerciallogger.model.a.aTL));
    }
}
