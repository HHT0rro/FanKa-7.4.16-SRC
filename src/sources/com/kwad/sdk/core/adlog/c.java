package com.kwad.sdk.core.adlog;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.internal.logging.nano.MetricsProto;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.report.h;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.ak;
import com.kwad.sdk.utils.ay;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class c {
    private static ExecutorService apm = GlobalThreadPools.FG();
    public static JSONObject apn;
    public static boolean apo;

    @KsJson
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a extends com.kwad.sdk.core.response.a.a {
        public int code;
        public String msg;

        public a(int i10, String str) {
            this.code = i10;
            this.msg = str;
        }
    }

    private static int Bg() {
        return ai.isOrientationPortrait() ? 2 : 1;
    }

    private static boolean G(AdInfo adInfo) {
        f fVar = (f) ServiceProvider.get(f.class);
        if (fVar == null) {
            return false;
        }
        String ay = com.kwad.sdk.core.response.b.a.ay(adInfo);
        if (TextUtils.isEmpty(ay)) {
            return false;
        }
        return ak.an(fVar.getContext(), ay);
    }

    public static void a(AdTemplate adTemplate, com.kwad.sdk.core.adlog.c.a aVar, @Nullable JSONObject jSONObject) {
        if (aVar != null) {
            try {
                if (adTemplate.fromCache) {
                    aVar.a(h.bW(adTemplate));
                }
                aVar.e(adTemplate, null, null);
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
                return;
            }
        }
        a(adTemplate, 2, aVar, jSONObject);
    }

    public static void bE(AdTemplate adTemplate) {
        q(adTemplate, 4);
    }

    public static void bF(AdTemplate adTemplate) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.downloadSource = adTemplate.downloadSource;
        a(adTemplate, 30, aVar, (JSONObject) null);
    }

    public static void bG(AdTemplate adTemplate) {
        q(adTemplate, 36);
    }

    public static void bH(AdTemplate adTemplate) {
        q(adTemplate, 38);
    }

    public static void bI(AdTemplate adTemplate) {
        q(adTemplate, 41);
    }

    public static void bJ(AdTemplate adTemplate) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.apZ = com.kwad.sdk.core.response.b.a.ay(e.dQ(adTemplate));
        a(adTemplate, 768, aVar, new JSONObject());
    }

    public static void bK(@Nullable AdTemplate adTemplate) {
        f(adTemplate, null);
    }

    public static void bL(@Nullable AdTemplate adTemplate) {
        g(adTemplate, (JSONObject) null);
    }

    public static void bM(@Nullable AdTemplate adTemplate) {
        q(adTemplate, 58);
    }

    public static void bN(AdTemplate adTemplate) {
        q(adTemplate, 914);
    }

    public static void bO(AdTemplate adTemplate) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.downloadStatus = com.kwad.sdk.core.response.b.a.bx(e.dQ(adTemplate));
        com.kwad.sdk.core.e.c.d("AdReportManager", "reportDownloadCardClose downloadStatus=" + aVar.downloadStatus);
        a(adTemplate, MetricsProto.MetricsEvent.ACTION_PERMISSION_REVOKE_RECEIVE_SMS, aVar, (JSONObject) null);
    }

    public static void bP(AdTemplate adTemplate) {
        q(adTemplate, MetricsProto.MetricsEvent.ACTION_PERMISSION_REQUEST_RECEIVE_MMS);
    }

    public static void bQ(AdTemplate adTemplate) {
        q(adTemplate, MetricsProto.MetricsEvent.ACTION_PERMISSION_REVOKE_RECEIVE_WAP_PUSH);
    }

    private static boolean bR(AdTemplate adTemplate) {
        if (e.dI(adTemplate)) {
            return true;
        }
        f fVar = (f) ServiceProvider.get(f.class);
        return fVar != null && fVar.aF(adTemplate);
    }

    public static void c(final AdTemplate adTemplate, final JSONObject jSONObject) {
        apm.submit(new ay() { // from class: com.kwad.sdk.core.adlog.c.1
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                com.kwad.sdk.core.adlog.c.b cN = new com.kwad.sdk.core.adlog.c.b().cN(AdTemplate.this.downloadSource);
                c.a(AdTemplate.this, cN);
                c.a(AdTemplate.this, 31, cN.Bs(), jSONObject);
                AdInfo dQ = e.dQ(AdTemplate.this);
                ak.av(dQ.downloadFilePath, dQ.downloadId);
            }
        });
    }

    public static void d(AdTemplate adTemplate, JSONObject jSONObject) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.downloadSource = adTemplate.downloadSource;
        a(adTemplate, 35, aVar, jSONObject);
    }

    public static void e(final AdTemplate adTemplate, final JSONObject jSONObject) {
        apm.submit(new ay() { // from class: com.kwad.sdk.core.adlog.c.2
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                AdInfo dQ = e.dQ(AdTemplate.this);
                int aw = ak.aw(dQ.downloadId, com.kwad.sdk.core.response.b.a.ay(dQ));
                com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
                AdTemplate adTemplate2 = AdTemplate.this;
                aVar.downloadSource = adTemplate2.downloadSource;
                aVar.apU = aw;
                aVar.apV = adTemplate2.installFrom;
                c.a(adTemplate2, 32, aVar, jSONObject);
            }
        });
    }

    public static void f(@Nullable AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        d(adTemplate, 399, jSONObject);
    }

    public static void g(@Nullable AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        d(adTemplate, 400, jSONObject);
    }

    public static void h(AdTemplate adTemplate, int i10) {
        adTemplate.mInstallApkFromSDK = true;
        adTemplate.mInstallApkFormUser = i10 == 1;
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.aql = i10;
        a(adTemplate, 37, aVar, (JSONObject) null);
    }

    public static void i(AdTemplate adTemplate, int i10) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.KI = i10;
        a(adTemplate, MetricsProto.MetricsEvent.ACTION_SETTINGS_CLEAR_INSTANT_APP, aVar, (JSONObject) null);
    }

    public static void j(@Nullable AdTemplate adTemplate, int i10) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.apT = i10;
        b(adTemplate, "wxsmallapp", 1, aVar);
    }

    public static void k(@Nullable AdTemplate adTemplate, int i10) {
        d(adTemplate, i10, 0);
    }

    public static void l(AdTemplate adTemplate, int i10) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.apJ = i10;
        a(adTemplate, MetricsProto.MetricsEvent.RESERVED_FOR_LOGBUILDER_SUBTYPE, aVar, (JSONObject) null);
    }

    public static void m(AdTemplate adTemplate, int i10) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.apI = i10;
        a(adTemplate, 28, aVar, (JSONObject) null);
    }

    public static void n(AdTemplate adTemplate, int i10) {
        if (adTemplate == null) {
            return;
        }
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.apZ = com.kwad.sdk.core.response.b.a.ay(e.dQ(adTemplate));
        a(adTemplate, i10, aVar, new JSONObject());
    }

    public static void o(AdTemplate adTemplate, int i10) {
        a(adTemplate, i10, new com.kwad.sdk.core.adlog.c.a(), new JSONObject());
    }

    @Deprecated
    public static void p(AdTemplate adTemplate, int i10) {
        e(adTemplate, (JSONObject) null, new com.kwad.sdk.core.adlog.c.b().cM(i10));
    }

    private static void q(AdTemplate adTemplate, int i10) {
        a(adTemplate, i10, (com.kwad.sdk.core.adlog.c.a) null, new JSONObject());
    }

    public static boolean b(@NonNull AdTemplate adTemplate, @Nullable JSONObject jSONObject, @Nullable com.kwad.sdk.core.adlog.c.b bVar) {
        if (adTemplate.mPvReported) {
            return false;
        }
        adTemplate.mPvReported = true;
        AdInfo dQ = e.dQ(adTemplate);
        if (bVar == null) {
            bVar = new com.kwad.sdk.core.adlog.c.b();
        }
        bVar.cY(Bg());
        com.kwad.sdk.core.adlog.c.a Bs = bVar.Bs();
        if (adTemplate.fromCache) {
            Bs.a(h.bW(adTemplate));
        }
        Bs.aqg = G(dQ) ? 1 : 0;
        return a(adTemplate, 1, Bs, jSONObject);
    }

    public static void c(@Nullable AdTemplate adTemplate, String str, int i10) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.apR = i10;
        if (!str.equals("")) {
            aVar.apS = str;
        }
        a(adTemplate, 803, aVar, (JSONObject) null);
    }

    public static void e(AdTemplate adTemplate, int i10, int i11) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.apL = 69;
        aVar.aqb = i10;
        aVar.aqc = i11;
        a(adTemplate, 501, aVar, (JSONObject) null);
    }

    public static void g(AdTemplate adTemplate, boolean z10) {
        com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
        a.C0516a c0516a = new a.C0516a();
        c0516a.ape = 1;
        bVar.b(c0516a);
        if (z10) {
            bVar.cT(33);
        }
        a(adTemplate, 804, bVar.Bs(), (JSONObject) null);
    }

    public static void k(@Nullable AdTemplate adTemplate, long j10) {
        a(adTemplate, 52, com.kwad.sdk.core.adlog.c.a.Br().ag(j10), (JSONObject) null);
    }

    public static void d(@Nullable AdTemplate adTemplate, int i10, int i11) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.aqf = i10;
        aVar.KJ = i11;
        a(adTemplate, 323, aVar, (JSONObject) null);
    }

    public static void i(AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        d(adTemplate, 450, jSONObject);
    }

    public static void j(AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        d(adTemplate, MetricsProto.MetricsEvent.ACTION_SHOW_APP_DISAMBIG_APP_FEATURED, jSONObject);
    }

    public static void l(AdTemplate adTemplate, long j10) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.apN = j10;
        a(adTemplate, 600, aVar, (JSONObject) null);
    }

    public static void m(AdTemplate adTemplate, long j10) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.aqe = j10;
        a(adTemplate, 401, aVar, (JSONObject) null);
    }

    @Deprecated
    public static void a(AdTemplate adTemplate, int i10, @Nullable ac.a aVar) {
        com.kwad.sdk.core.adlog.c.a aVar2 = new com.kwad.sdk.core.adlog.c.a();
        aVar2.kl = i10;
        if (aVar != null) {
            aVar2.kn = aVar;
        }
        a(adTemplate, aVar2, (JSONObject) null);
    }

    public static void h(AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        d(adTemplate, 501, jSONObject);
    }

    public static void c(AdTemplate adTemplate, @Nullable JSONObject jSONObject, com.kwad.sdk.core.adlog.c.b bVar) {
        a(adTemplate, MetricsProto.MetricsEvent.ACTION_SHOW_APP_DISAMBIG_APP_FEATURED, bVar != null ? bVar.Bs() : null, (JSONObject) null);
    }

    public static void e(AdTemplate adTemplate, JSONObject jSONObject, @Nullable com.kwad.sdk.core.adlog.c.b bVar) {
        if (bVar == null) {
            bVar = new com.kwad.sdk.core.adlog.c.b();
        }
        com.kwad.sdk.core.adlog.c.a Bs = bVar.Bs();
        Bs.e(adTemplate, null, null);
        a(adTemplate, 141, Bs, jSONObject);
    }

    public static void h(AdTemplate adTemplate, boolean z10) {
        com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
        a.C0516a c0516a = new a.C0516a();
        c0516a.ape = 2;
        bVar.b(c0516a);
        if (z10) {
            bVar.cT(33);
        }
        a(adTemplate, 804, bVar.Bs(), (JSONObject) null);
    }

    public static void d(AdTemplate adTemplate, @Nullable JSONObject jSONObject, com.kwad.sdk.core.adlog.c.b bVar) {
        if (bVar == null) {
            bVar = new com.kwad.sdk.core.adlog.c.b();
        }
        com.kwad.sdk.core.adlog.c.a Bs = bVar.Bs();
        Bs.e(adTemplate, null, null);
        a(adTemplate, 140, Bs, jSONObject);
    }

    public static void c(AdTemplate adTemplate, int i10, @Nullable JSONObject jSONObject) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.apZ = com.kwad.sdk.core.response.b.a.ay(e.dQ(adTemplate));
        aVar.apL = 93;
        a(adTemplate, 140, aVar, (JSONObject) null);
    }

    public static void a(AdTemplate adTemplate, com.kwad.sdk.core.adlog.c.b bVar, JSONObject jSONObject) {
        a(adTemplate, bVar != null ? bVar.Bs() : null, jSONObject);
    }

    public static void a(AdTemplate adTemplate, long j10, @Nullable JSONObject jSONObject) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        a.C0516a c0516a = new a.C0516a();
        if (j10 != -1) {
            c0516a.duration = j10;
            aVar.KH = c0516a;
        }
        a(adTemplate, MetricsProto.MetricsEvent.FINGERPRINT_REMOVE_SIDECAR, aVar, (JSONObject) null);
    }

    public static void b(AdTemplate adTemplate, com.kwad.sdk.core.adlog.c.b bVar, @Nullable JSONObject jSONObject) {
        a(adTemplate, 3, bVar != null ? bVar.Bs() : null, jSONObject);
    }

    private static void d(AdTemplate adTemplate, int i10, JSONObject jSONObject) {
        a(adTemplate, i10, (com.kwad.sdk.core.adlog.c.a) null, jSONObject);
    }

    public static void b(AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.downloadSource = adTemplate.downloadSource;
        a(adTemplate, 34, aVar, jSONObject);
    }

    @Deprecated
    public static void a(AdTemplate adTemplate, int i10, long j10, @Nullable JSONObject jSONObject) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.apK = i10;
        a.C0516a c0516a = new a.C0516a();
        c0516a.duration = j10;
        aVar.KH = c0516a;
        a(adTemplate, 3, aVar, jSONObject);
    }

    public static void b(@Nullable AdTemplate adTemplate, String str, int i10, com.kwad.sdk.core.adlog.c.a aVar) {
        if (aVar == null) {
            aVar = new com.kwad.sdk.core.adlog.c.a();
        }
        aVar.apR = i10;
        if (!str.equals("")) {
            aVar.apS = str;
        }
        a(adTemplate, 321, aVar, (JSONObject) null);
    }

    public static void b(@Nullable AdTemplate adTemplate, com.kwad.sdk.core.adlog.c.a aVar) {
        a(adTemplate, 59, aVar, (JSONObject) null);
    }

    public static void a(AdTemplate adTemplate, int i10, long j10, int i11, long j11, @Nullable JSONObject jSONObject) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.vz = j10;
        aVar.aqi = i11;
        aVar.apK = i10;
        a.C0516a c0516a = new a.C0516a();
        c0516a.duration = j11;
        aVar.KH = c0516a;
        a(adTemplate, 3, aVar, (JSONObject) null);
    }

    @Deprecated
    public static void b(AdTemplate adTemplate, int i10, @Nullable JSONObject jSONObject) {
        d(adTemplate, jSONObject, new com.kwad.sdk.core.adlog.c.b().cM(i10));
    }

    public static void a(AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.downloadSource = adTemplate.downloadSource;
        a(adTemplate, 33, aVar, jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(AdTemplate adTemplate, com.kwad.sdk.core.adlog.c.b bVar) {
        AdInfo dQ = e.dQ(adTemplate);
        String str = dQ.downloadFilePath;
        if (str == null) {
            return;
        }
        String ay = com.kwad.sdk.core.response.b.a.ay(dQ);
        String gF = ak.gF(str);
        if (gF == null || TextUtils.isEmpty(gF) || gF.equals(ay)) {
            return;
        }
        bVar.df(gF);
        bVar.de(ay);
        dQ.adBaseInfo.appPackageName = gF;
    }

    public static void a(AdTemplate adTemplate, a aVar) {
        com.kwad.sdk.core.adlog.c.a aVar2 = new com.kwad.sdk.core.adlog.c.a();
        aVar2.apW = aVar.toJson().toString();
        a(adTemplate, 40, aVar2, (JSONObject) null);
    }

    public static void a(@Nullable AdTemplate adTemplate, String str, int i10, com.kwad.sdk.core.adlog.c.a aVar) {
        if (aVar == null) {
            aVar = new com.kwad.sdk.core.adlog.c.a();
        }
        aVar.apR = i10;
        if (!str.equals("")) {
            aVar.apS = str;
        }
        a(adTemplate, 320, aVar, (JSONObject) null);
    }

    public static void a(@Nullable AdTemplate adTemplate, com.kwad.sdk.core.adlog.c.a aVar) {
        a(adTemplate, 50, aVar, (JSONObject) null);
    }

    public static void a(@Nullable AdTemplate adTemplate, com.kwad.sdk.core.adlog.c.a aVar, long j10) {
        aVar.aqd = j10;
        a(adTemplate, 51, aVar, (JSONObject) null);
    }

    public static void a(AdTemplate adTemplate, int i10, @Nullable JSONObject jSONObject) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.apI = i10;
        a(adTemplate, 402, aVar, jSONObject);
    }

    public static void a(AdTemplate adTemplate, int i10, AdExposureFailedReason adExposureFailedReason) {
        if (i10 == 0 || i10 == 1 || i10 == 2 || i10 == 3 || i10 == 4) {
            com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
            aVar.apO = i10;
            if (adExposureFailedReason != null && i10 == 2) {
                aVar.apP = adExposureFailedReason.winEcpm;
                try {
                    int i11 = adExposureFailedReason.adnType;
                    aVar.adnType = i11;
                    if (i11 == 2) {
                        aVar.adnName = adExposureFailedReason.adnName;
                    }
                } catch (Throwable unused) {
                }
            }
            a(adTemplate, MetricsProto.MetricsEvent.PROVISIONING_TERMS_ACTIVITY_TIME_MS, aVar, (JSONObject) null);
        }
    }

    public static void a(AdTemplate adTemplate, int i10, JSONObject jSONObject, String str) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.KG = str;
        a(adTemplate, i10, aVar, jSONObject);
    }

    public static boolean a(@Nullable AdTemplate adTemplate, int i10, @Nullable com.kwad.sdk.core.adlog.c.a aVar, @Nullable JSONObject jSONObject) {
        if (adTemplate == null || !bR(adTemplate)) {
            return false;
        }
        if (aVar == null) {
            aVar = new com.kwad.sdk.core.adlog.c.a();
        }
        aVar.aqh = com.kwad.sdk.core.response.b.a.aT(e.dQ(adTemplate));
        aVar.adxResult = adTemplate.adxResult;
        if (i10 == 2 && apo) {
            if (aVar.KH == null) {
                aVar.KH = new a.C0516a();
            }
            aVar.KH.aph = apn;
        }
        aVar.adTemplate = adTemplate;
        aVar.aoM = i10;
        aVar.apH = jSONObject;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(i10);
        com.kwad.sdk.core.e.c.d("AdReportManager", sb2.toString());
        b.a(aVar);
        return true;
    }
}
