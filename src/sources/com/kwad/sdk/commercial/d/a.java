package com.kwad.sdk.commercial.d;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a {
    private static void a(AdTemplate adTemplate, com.kwad.sdk.commercial.c.a aVar) {
        aVar.setAdTemplate(adTemplate);
        com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.AJ().cu(ILoggerReporter.Category.APM_LOG).i(0.001d).a(com.kwad.sdk.commercial.d.aS(adTemplate)).N("ad_convert_method_call", "method_name").u(aVar));
    }

    public static void bc(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.AM().cy("adClick"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void bd(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.AM().cy("startH5Page"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void be(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.AM().cy("dplinkStart"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void bf(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.AM().cy("smallAppSuccess"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void bg(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.AM().cy("appstoreStart"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void bh(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.AM().cy("disableClick"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void bi(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.AM().cy("toVideoH5Web"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void bj(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.AM().cy("toDownload"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void bk(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.AM().cy("toOpenApp"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void bl(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.AM().cy("toInstallApp"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void bm(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.AM().cy("toDownloadDialog"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void bn(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.AM().cy("toDownloadThirdDialog"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void bo(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.AM().cy("toDownloadPage"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void bp(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.AM().cy("toDownloadPause"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void bq(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.AM().cy("toDownloadResume"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void br(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.AM().cy("toDownloadNoNet"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void bs(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.AM().cy("toDoNoting"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void bt(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.AM().cy("toOpenAppDialog"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void bu(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.AM().cy("toOpenDeeplinkDialog"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void bv(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.AM().cy("toH5PageDialog"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void bw(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.AM().cy("toMiddlePageDialog"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void bx(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.AM().cy("toSmallAppDialog"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void f(AdTemplate adTemplate, boolean z10) {
        try {
            a(adTemplate, b.AM().cy("adUserClick").bk(z10));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
