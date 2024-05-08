package com.kwad.sdk.crash.online.monitor;

import android.text.TextUtils;
import com.kwad.sdk.crash.online.monitor.a.c;
import com.kwad.sdk.crash.online.monitor.block.e;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.g;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a {
    private static volatile boolean hasInit;

    private static c HN() {
        c cVar = new c();
        com.kwad.sdk.crash.online.monitor.a.a aVar = new com.kwad.sdk.crash.online.monitor.a.a();
        cVar.aHd = aVar;
        aVar.aGU = 5;
        return cVar;
    }

    public static /* synthetic */ boolean access$002(boolean z10) {
        hasInit = true;
        return true;
    }

    public static void cH(final String str) {
        g.execute(new ay() { // from class: com.kwad.sdk.crash.online.monitor.a.1
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                if (a.hasInit) {
                    return;
                }
                com.kwad.sdk.core.e.c.d("perfMonitor.MonitorManager", "configStr:" + String.this);
                c fr = a.fr(String.this);
                com.kwad.sdk.core.e.c.d("perfMonitor.MonitorManager", fr.toJson().toString());
                e.d(fr.aHd);
                a.access$002(true);
            }
        });
    }

    public static c fr(String str) {
        if (TextUtils.isEmpty(str)) {
            return HN();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            c cVar = new c();
            cVar.parseJson(jSONObject);
            return cVar;
        } catch (Exception e2) {
            com.kwad.sdk.core.e.c.w("perfMonitor.MonitorManager", e2);
            return HN();
        }
    }
}
