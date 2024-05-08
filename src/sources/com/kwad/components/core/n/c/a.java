package com.kwad.components.core.n.c;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a {
    private static void a(b bVar) {
        a(bVar, false);
    }

    public static void b(String str, long j10, int i10) {
        try {
            a(new b().am(str).B(j10).aw(i10).A(2L));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void c(String str, long j10) {
        try {
            a(new b().am(str).B(j10).A(1L));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void d(String str, long j10) {
        try {
            a(new b().am(str).B(j10).A(6L));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private static void a(b bVar, boolean z10) {
        com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.AJ().cu(z10 ? ILoggerReporter.Category.ERROR_LOG : ILoggerReporter.Category.APM_LOG).i(z10 ? 1.0d : 0.01d).N("ad_sdk_offline_component_monitor", "load_status").u(bVar).a(com.kwai.adclient.kscommerciallogger.model.a.aTL));
    }

    public static void c(String str, long j10, String str2) {
        try {
            a(new b().am(str).B(j10).ao(str2).A(4L));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void b(String str, long j10, String str2) {
        try {
            a(new b().am(str).B(j10).ao(str2).A(3L));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(String str, long j10, int i10, String str2, String str3) {
        try {
            a(new b().am(str).B(j10).setErrorCode(i10).ao(str3).an(str2).A(7L), true);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void c(String str, long j10, int i10) {
        try {
            a(new b().am(str).A(8L).aw(i10).B(j10));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(String str, long j10, String str2) {
        try {
            a(new b().am(str).ao(str2).B(j10).A(5L));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
