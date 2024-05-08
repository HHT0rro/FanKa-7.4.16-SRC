package com.kwad.sdk.core.adlog;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.commercial.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.f;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.bn;
import com.kwad.sdk.utils.t;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class b {
    public static void Bf() {
        GlobalThreadPools.FH().execute(new ay() { // from class: com.kwad.sdk.core.adlog.b.2
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                com.kwad.sdk.core.adlog.a.a Bl = com.kwad.sdk.core.adlog.a.b.Bi().Bl();
                if (Bl != null) {
                    JSONObject jSONObject = Bl.apq;
                    t.putValue(jSONObject, DBDefinition.RETRY_COUNT, Bl.retryCount);
                    t.putValue(jSONObject, "cacheType", 1);
                    b.a(Bl.url, jSONObject, Bl.apr, Bl);
                }
            }
        });
    }

    public static void a(@NonNull final com.kwad.sdk.core.adlog.c.a aVar) {
        GlobalThreadPools.FH().execute(new ay() { // from class: com.kwad.sdk.core.adlog.b.1
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                a aVar2 = new a(com.kwad.sdk.core.adlog.c.a.this);
                b.a(aVar2.getUrl(), aVar2.getBody(), com.kwad.sdk.core.adlog.c.a.this, null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(String str, JSONObject jSONObject, @NonNull com.kwad.sdk.core.adlog.c.a aVar, @Nullable com.kwad.sdk.core.adlog.a.a aVar2) {
        AdTemplate adTemplate = aVar.adTemplate;
        int i10 = aVar.aoM;
        try {
            com.kwad.sdk.core.adlog.b.c.a(adTemplate, i10, aVar2);
            if (!ag.isNetworkConnected(ServiceProvider.getContext())) {
                com.kwad.sdk.core.e.c.w("AdLogRequestManager", "no network while report log");
                com.kwad.sdk.core.adlog.b.c.a(adTemplate, i10, str, 100004, "no network", aVar2);
                com.kwad.sdk.core.adlog.a.b.Bi().a(aVar2, str, jSONObject, aVar, 100004, "no network");
                return;
            }
            if (bn.hb(str)) {
                com.kwad.sdk.core.adlog.b.c.b(adTemplate, i10, str, 100001, "", aVar2);
                return;
            }
            com.kwad.sdk.core.network.c doPost = f.xT().doPost(str, (Map<String, String>) null, jSONObject);
            AdLogRequestResult adLogRequestResult = new AdLogRequestResult();
            adLogRequestResult.parseResult(doPost.avs);
            int i11 = doPost.code;
            if (i11 != 200) {
                int cb2 = d.cb(i11);
                String str2 = doPost.avs;
                com.kwad.sdk.core.adlog.b.c.d(adTemplate, i10, str, cb2, str2, aVar2);
                com.kwad.sdk.core.adlog.a.b.Bi().a(aVar2, str, jSONObject, aVar, cb2, str2);
                return;
            }
            if (adLogRequestResult.isResultOk()) {
                com.kwad.sdk.core.adlog.b.c.b(adTemplate, i10, aVar2);
                b(aVar);
                com.kwad.sdk.core.adlog.a.b.Bi().Bj();
                return;
            }
            if (adLogRequestResult.isCheatingFlow()) {
                adTemplate.setCheatingFlow(adLogRequestResult.isCheatingFlow());
                com.kwad.sdk.core.adlog.b.c.c(adTemplate, i10, str, adLogRequestResult.result, adLogRequestResult.errorMsg, aVar2);
                return;
            }
            int i12 = adLogRequestResult.result;
            String str3 = adLogRequestResult.errorMsg;
            com.kwad.sdk.core.e.c.w("AdLogRequestManager", "request fail code:" + i12 + ", errorMsg:" + str3 + ", url=" + str);
            com.kwad.sdk.core.adlog.b.c.c(adTemplate, i10, str, i12, str3, aVar2);
            com.kwad.sdk.core.adlog.a.b.Bi().a(aVar2, str, jSONObject, aVar, i12, str3);
        } catch (Throwable th) {
            com.kwad.sdk.core.adlog.b.c.b(adTemplate, i10, "", 100000, bn.t(th), aVar2);
            com.kwad.sdk.core.e.c.printStackTrace(th);
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private static void b(@NonNull com.kwad.sdk.core.adlog.c.a aVar) {
        try {
            com.kwad.sdk.core.track.a.d(aVar);
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTrace(th);
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
