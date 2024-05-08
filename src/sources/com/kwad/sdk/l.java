package com.kwad.sdk;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.model.SDKInitMsg;
import com.kwad.sdk.utils.ay;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class l {
    private static int alh;

    public static void Y(long j10) {
        final long currentTimeMillis = j10 > 0 ? System.currentTimeMillis() - j10 : -1L;
        alh++;
        com.kwad.sdk.utils.g.execute(new ay() { // from class: com.kwad.sdk.l.1
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                com.kwad.sdk.commercial.b.a(ILoggerReporter.Category.APM_LOG, com.kwai.adclient.kscommerciallogger.model.a.aTJ, new SDKInitMsg().setLaunchIntervalTime(currentTimeMillis).setInitCount(l.alh).setInitStatus(0));
            }
        });
    }

    public static void Z(final long j10) {
        if (j10 > 10000) {
            j10 = -1;
        }
        com.kwad.sdk.utils.g.execute(new ay() { // from class: com.kwad.sdk.l.2
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                com.kwad.sdk.commercial.b.a(ILoggerReporter.Category.APM_LOG, com.kwai.adclient.kscommerciallogger.model.a.aTJ, new SDKInitMsg().setTotalDurationTime(j10).setInitCount(l.alh).setInitStatus(1));
            }
        });
    }

    public static void a(final com.kwai.adclient.kscommerciallogger.model.d dVar, final String str) {
        com.kwad.sdk.utils.g.execute(new ay() { // from class: com.kwad.sdk.l.3
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                com.kwad.sdk.commercial.b.a(ILoggerReporter.Category.ERROR_LOG, com.kwai.adclient.kscommerciallogger.model.d.this, new SDKInitMsg().setInitCount(l.alh).setErrorReason(str).setInitStatus(2));
            }
        });
    }
}
