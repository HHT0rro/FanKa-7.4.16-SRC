package com.kwad.components.core.o;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.core.proxy.a.b;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.collector.f;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.core.report.g;
import com.kwad.sdk.core.report.n;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.InstalledAppInfoManager;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.l;
import com.kwad.sdk.utils.t;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a {
    private static boolean Rk;

    /* renamed from: com.kwad.components.core.o.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class C0471a {
        private static final a Rm = new a();
    }

    public static n G(long j10) {
        return new n(j10);
    }

    private static n a(long j10, AdTemplate adTemplate, String str) {
        return new n(j10, adTemplate, str);
    }

    private static n b(long j10, AdTemplate adTemplate) {
        return new n(j10, adTemplate);
    }

    public static a qi() {
        return C0471a.Rm;
    }

    public final void aD(int i10) {
        n G = G(10104L);
        G.ayc = i10;
        g.a2(G);
    }

    public final void aE(int i10) {
        n G = G(10107L);
        G.ayd = i10;
        g.a2(G);
    }

    public final void ae(Context context) {
        n G = G(11L);
        JSONArray[] c4 = InstalledAppInfoManager.c(context, d.yG());
        G.axU = c4[0];
        G.axV = c4[1];
        g.a2(G);
    }

    public final void au(@NonNull AdTemplate adTemplate) {
        g.a2(b(10007L, adTemplate));
    }

    public final void av(@NonNull AdTemplate adTemplate) {
        g.a2(b(10208L, adTemplate));
    }

    public final void aw(@NonNull AdTemplate adTemplate) {
        g.a2(b(10209L, adTemplate));
    }

    public final void c(@NonNull AdTemplate adTemplate, int i10, int i11) {
        n b4 = b(10002L, adTemplate);
        b4.EN();
        if (e.dI(adTemplate)) {
            b4.ayb = com.kwad.sdk.core.response.b.a.K(e.dQ(adTemplate));
        } else {
            b4.ayb = e.dS(adTemplate);
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("what", i10);
            jSONObject.put("extra", i11);
            b4.errorMsg = jSONObject.toString();
        } catch (JSONException e2) {
            c.printStackTraceOnly(e2);
        }
        g.a2(b4);
    }

    public final void e(@NonNull JSONObject jSONObject, int i10) {
        n G = G(10201L);
        t.putValue(jSONObject, "appChangeType", i10);
        G.ayf = jSONObject;
        g.a2(G);
    }

    public final void f(AdTemplate adTemplate, int i10, String str) {
        n b4 = b(10109L, adTemplate);
        b4.ayd = 1;
        b4.aye = str;
        g.a2(b4);
    }

    public final void g(@NonNull AdTemplate adTemplate, long j10) {
        n b4 = b(10202L, adTemplate);
        b4.ayk = j10;
        g.a2(b4);
    }

    public final void h(AdTemplate adTemplate, long j10) {
        n b4 = b(10206L, adTemplate);
        b4.ayA = j10;
        g.a2(b4);
    }

    public final void i(AdTemplate adTemplate, long j10) {
        n b4 = b(10207L, adTemplate);
        b4.ayB = j10;
        g.a2(b4);
    }

    public final n m(String str, String str2) {
        n G = G(12200L);
        G.ayJ = str;
        G.ayK = str2;
        return G;
    }

    public final void qj() {
        if (Rk) {
            return;
        }
        Rk = true;
        com.kwad.sdk.utils.g.execute(new ay() { // from class: com.kwad.components.core.o.a.1
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                n G = a.G(8L);
                G.ayC = f.Ay();
                g.a2(G);
            }
        });
    }

    public final void qk() {
        g.a2(G(10101L));
    }

    public final void ql() {
        g.a2(G(10106L));
    }

    public final void a(@NonNull AdTemplate adTemplate, String str, String str2) {
        n b4 = b(10003L, adTemplate);
        b4.ayb = str;
        b4.errorMsg = str2;
        g.a2(b4);
    }

    public final void b(@NonNull AdTemplate adTemplate, int i10, int i11) {
        n b4 = b(12006L, adTemplate);
        b4.Xt = i10;
        b4.apY = i11;
        g.a2(b4);
    }

    public final void g(@NonNull AdTemplate adTemplate, int i10, String str) {
        n b4 = b(107L, adTemplate);
        b4.errorCode = i10;
        b4.errorMsg = str;
        g.a2(b4);
    }

    public final void e(AdTemplate adTemplate, int i10) {
        n b4 = b(10108L, adTemplate);
        b4.ayd = i10;
        g.a2(b4);
    }

    public final void f(@NonNull AdTemplate adTemplate, int i10) {
        if (d.Cw()) {
            AdInfo dQ = e.dQ(adTemplate);
            n G = G(20000L);
            G.timestamp = System.currentTimeMillis();
            G.ayL = i10;
            G.trace = dQ.trace;
            G.ayM = BuildConfig.VERSION_CODE;
            G.posId = e.dJ(adTemplate);
            g.a2(G);
        }
    }

    public final void a(int i10, @NonNull AdTemplate adTemplate, String str) {
        g.a2(a(i10, adTemplate, str));
    }

    public final void b(@NonNull AdTemplate adTemplate, String str, String str2) {
        n b4 = b(10005L, adTemplate);
        if (e.dI(adTemplate)) {
            b4.ayb = com.kwad.sdk.core.response.b.a.K(e.dQ(adTemplate));
        } else {
            b4.ayb = e.dS(adTemplate);
        }
        b4.ayb = str;
        b4.errorMsg = str2;
        g.a2(b4);
    }

    public final void a(@NonNull AdTemplate adTemplate, long j10, long j11, int i10) {
        n b4 = b(10203L, adTemplate);
        b4.VU = j10;
        b4.blockDuration = j11;
        b4.axR = i10;
        g.a2(b4);
    }

    public final void e(String str, String str2, boolean z10) {
        g.a(m(str, str2), z10);
    }

    public final void a(boolean z10, List<Integer> list) {
        n G = G(10204L);
        G.aym = z10;
        if (list.size() > 0) {
            JSONArray jSONArray = new JSONArray();
            Iterator<Integer> iterator2 = list.iterator2();
            while (iterator2.hasNext()) {
                jSONArray.put(iterator2.next());
            }
            G.ayl = jSONArray;
        }
        g.a2(G);
    }

    public final void c(@NonNull JSONArray jSONArray) {
        n G = G(10200L);
        G.ayg = jSONArray;
        g.a2(G);
    }

    public final void b(@NonNull AdTemplate adTemplate, long j10, int i10) {
        n b4 = b(104L, adTemplate);
        b4.clickTime = l.em(adTemplate);
        b4.ayq = j10;
        b4.ayr = i10;
        g.a2(b4);
    }

    public final void a(SceneImpl sceneImpl, boolean z10, String str) {
        n G = G(10216L);
        G.aym = z10;
        G.ayn = str;
        G.adScene = sceneImpl;
        g.a2(G);
    }

    public final void a(b bVar) {
        n G = G(10215L);
        G.Ra = bVar.Ra;
        G.Rh = bVar.Rh;
        G.Ri = bVar.Ri;
        G.Rj = bVar.Rj;
        g.a2(G);
    }

    public final void a(long j10, int i10) {
        if (d.Cw()) {
            n G = G(20000L);
            G.timestamp = System.currentTimeMillis();
            G.ayL = i10;
            G.posId = j10;
            G.ayM = BuildConfig.VERSION_CODE;
            g.a2(G);
        }
    }
}
