package com.kwad.sdk.core.response.b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.AdVideoPreCacheConfig;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class e {
    public static boolean F(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return false;
        }
        AdInfo dQ = dQ(adTemplate);
        return (a.aF(dQ) || a.cR(dQ) || dY(adTemplate) != 3) ? false : true;
    }

    @Nullable
    private static g Fh() {
        com.kwad.sdk.service.a.f fVar = (com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class);
        if (fVar != null) {
            return fVar.tD();
        }
        return null;
    }

    @Nullable
    public static AdTemplate a(List<AdTemplate> list, long j10, int i10) {
        if (j10 >= 0 && list != null) {
            for (AdTemplate adTemplate : list) {
                if (c(adTemplate, j10, i10)) {
                    return adTemplate;
                }
            }
        }
        return null;
    }

    public static boolean b(List<AdTemplate> list, long j10, int i10) {
        AdTemplate a10 = a(list, j10, i10);
        if (a10 == null) {
            return false;
        }
        long ea2 = ea(a10);
        int dK = dK(a10);
        if (i10 > 0) {
            if (ea2 != j10 || dK != i10) {
                return false;
            }
        } else if (ea2 != j10) {
            return false;
        }
        return true;
    }

    public static boolean c(AdTemplate adTemplate, long j10, int i10) {
        long ea2 = ea(adTemplate);
        int dK = dK(adTemplate);
        if (i10 > 0) {
            if (ea2 == j10 && dK == i10) {
                return true;
            }
        } else if (ea2 == j10) {
            return true;
        }
        return false;
    }

    public static boolean dI(@NonNull AdTemplate adTemplate) {
        return (adTemplate.realShowType != 2 || adTemplate.adInfoList.isEmpty() || adTemplate.adInfoList.get(0) == null) ? false : true;
    }

    public static long dJ(@NonNull AdTemplate adTemplate) {
        return adTemplate.posId;
    }

    public static int dK(@NonNull AdTemplate adTemplate) {
        return adTemplate.adStyle;
    }

    @Deprecated
    public static int dL(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return 0;
        }
        SceneImpl sceneImpl = adTemplate.mAdScene;
        return sceneImpl != null ? sceneImpl.getAdStyle() : dK(adTemplate);
    }

    public static int dM(@NonNull AdTemplate adTemplate) {
        return adTemplate.contentType;
    }

    public static long dN(@NonNull AdTemplate adTemplate) {
        return adTemplate.llsid;
    }

    public static String dO(@NonNull AdTemplate adTemplate) {
        return adTemplate.extra;
    }

    public static String dP(@NonNull AdTemplate adTemplate) {
        return adTemplate.impAdExtra;
    }

    @NonNull
    public static AdInfo dQ(@NonNull AdTemplate adTemplate) {
        AdInfo adInfo = adTemplate.adInfoList.size() > 0 ? adTemplate.adInfoList.get(0) : null;
        if (adInfo != null) {
            return adInfo;
        }
        com.kwad.sdk.core.e.c.e("AdTemplateHelper", "adInfo in null");
        return new AdInfo();
    }

    @NonNull
    public static PhotoInfo dR(@NonNull AdTemplate adTemplate) {
        return adTemplate.photoInfo;
    }

    public static String dS(@NonNull AdTemplate adTemplate) {
        if (dI(adTemplate)) {
            return a.K(dQ(adTemplate));
        }
        return h.a(dR(adTemplate));
    }

    public static String dT(@NonNull AdTemplate adTemplate) {
        return dQ(adTemplate).adConversionInfo.appDownloadUrl;
    }

    public static String dU(@NonNull AdTemplate adTemplate) {
        g Fh = Fh();
        String Fl = Fh == null ? "" : Fh.Fl();
        return TextUtils.isEmpty(Fl) ? Fl : a.Y(dQ(adTemplate));
    }

    public static String dV(@NonNull AdTemplate adTemplate) {
        if (dI(adTemplate)) {
            return a.cf(dQ(adTemplate));
        }
        g Fh = Fh();
        return Fh == null ? "" : Fh.Fm();
    }

    public static long dW(@NonNull AdTemplate adTemplate) {
        if (dI(adTemplate)) {
            return a.ab(dQ(adTemplate));
        }
        g Fh = Fh();
        return Fh == null ? adTemplate.hashCode() : Fh.Fn();
    }

    public static int dX(@NonNull AdTemplate adTemplate) {
        g Fh = Fh();
        if (Fh == null) {
            return 0;
        }
        return Fh.Fo();
    }

    public static int dY(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return -1;
        }
        return dQ(adTemplate).adBaseInfo.taskType;
    }

    public static String dZ(@NonNull AdTemplate adTemplate) {
        if (dI(adTemplate)) {
            return a.cC(dQ(adTemplate));
        }
        return h.c(dR(adTemplate));
    }

    public static long ea(@Nullable AdTemplate adTemplate) {
        if (adTemplate == null) {
            return 0L;
        }
        return dQ(adTemplate).adBaseInfo.creativeId;
    }

    public static boolean eb(AdTemplate adTemplate) {
        return dQ(adTemplate).adConversionInfo.blockCallbackIfSpam && adTemplate.mCheatingFlow;
    }

    public static boolean ec(@NonNull AdTemplate adTemplate) {
        int j10 = j(adTemplate, true);
        return j10 == 1 || j10 == 2;
    }

    public static boolean ed(@NonNull AdTemplate adTemplate) {
        int j10 = j(adTemplate, false);
        return j10 == 1 || j10 == 2;
    }

    public static int ee(@NonNull AdTemplate adTemplate) {
        return dQ(adTemplate).adBaseInfo.ecpm;
    }

    public static boolean ef(@NonNull AdTemplate adTemplate) {
        AdInfo dQ = dQ(adTemplate);
        return dQ.adStyleConfInfo.adPushDownloadJumpType == 0 && dK(adTemplate) == 17 && a.aF(dQ);
    }

    public static int eg(@NonNull AdTemplate adTemplate) {
        AdVideoPreCacheConfig adVideoPreCacheConfig = adTemplate.adVideoPreCacheConfig;
        if (adVideoPreCacheConfig == null) {
            com.kwad.sdk.service.a.h hVar = (com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class);
            if (hVar != null) {
                return hVar.yU();
            }
            return 800;
        }
        return adVideoPreCacheConfig.adVideoPreCacheSize;
    }

    public static boolean i(AdTemplate adTemplate, boolean z10) {
        if (adTemplate == null) {
            return false;
        }
        AdInfo dQ = dQ(adTemplate);
        return a.aF(dQ) && !a.cR(dQ) && !z10 && dY(adTemplate) == 2;
    }

    public static int j(@NonNull AdTemplate adTemplate, boolean z10) {
        AdInfo dQ = dQ(adTemplate);
        if (dK(adTemplate) == 3) {
            AdMatrixInfo.AdDataV2 adDataV2 = dQ.adMatrixInfo.adDataV2;
            int i10 = z10 ? adDataV2.actionBarInfo.cardType : adDataV2.endCardInfo.cardType;
            if (i10 == 5) {
                return 1;
            }
            return i10 == 6 ? 2 : -1;
        }
        return dQ.adBaseInfo.mABParams.playableStyle;
    }
}
