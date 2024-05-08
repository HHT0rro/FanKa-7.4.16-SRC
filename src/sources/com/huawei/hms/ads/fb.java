package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.beans.metadata.MetaData;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.c;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class fb implements fc {
    private static long V;

    private Map<String, String> Code(AdContentData adContentData) {
        HashMap hashMap = new HashMap();
        if (adContentData != null && adContentData.Z() != null) {
            MetaData Z = adContentData.Z();
            String L = Z.L();
            String D = Z.D();
            if (L != null && D != null) {
                hashMap.put("appId", L);
                hashMap.put(com.huawei.openalliance.ad.uriaction.i.V, D);
            }
        }
        return hashMap;
    }

    private void Code(final Context context, final com.huawei.openalliance.ad.inter.data.d dVar) {
        long Code = com.huawei.openalliance.ad.utils.v.Code();
        gl.V("DownloadChecker", "trigger action list lastTime:%s curTime:%s", Long.valueOf(V), Long.valueOf(Code));
        if (Code - V < 500) {
            gl.V("DownloadChecker", "trigger action list too frequently");
        } else {
            V = Code;
            com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.fb.1
                @Override // java.lang.Runnable
                public void run() {
                    fb.this.Code(dVar, context);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(com.huawei.openalliance.ad.inter.data.d dVar, Context context) {
        if (dVar == null || context == null) {
            return;
        }
        if (dVar instanceof com.huawei.openalliance.ad.inter.data.n) {
            gl.V("DownloadChecker", "native trigger action list result:%s", Boolean.valueOf(((com.huawei.openalliance.ad.inter.data.n) dVar).B(context, null)));
        } else if (!(dVar instanceof c)) {
            gl.V("DownloadChecker", "not baseAd no need trigger action list");
        } else {
            AdContentData l10 = dVar.l();
            gl.V("DownloadChecker", "trigger action list result:%s", Boolean.valueOf(com.huawei.openalliance.ad.uriaction.r.Code(context, l10, Code(l10)).Code()));
        }
    }

    @Override // com.huawei.hms.ads.fc
    public boolean Code(Context context, com.huawei.openalliance.ad.inter.data.d dVar, boolean z10) {
        if (context == null || dVar == null) {
            return false;
        }
        if (dVar instanceof com.huawei.openalliance.ad.inter.data.u) {
            return true;
        }
        int y10 = dVar.y();
        gl.Code("DownloadChecker", "api control flag:%s", Integer.valueOf(y10));
        if (y10 == 0) {
            return true;
        }
        if (y10 != 1) {
            if (y10 != 2) {
                gl.I("DownloadChecker", "invalid apiDownloadFlag value!");
            }
            return false;
        }
        if (z10) {
            Code(context, dVar);
        }
        return false;
    }
}
