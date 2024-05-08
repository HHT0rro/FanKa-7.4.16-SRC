package com.kwad.components.core.e.d;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.page.AdWebViewVideoActivityProxy;
import com.kwad.components.core.webview.tachikoma.a.k;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.track.AdTrackLog;
import com.kwad.sdk.n.l;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ac;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a {
    private static List<WeakReference<k.b>> Kq;

    /* renamed from: com.kwad.components.core.e.d.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class C0461a {
        private boolean KA;
        private boolean KB;
        private long KC;
        private boolean KD;
        private boolean KE;
        public String KG;
        public a.C0516a KH;
        private JSONObject KK;
        private boolean KM;
        private int KN;
        private int KO;
        private int KP;
        private int KQ;
        private Callable<String> KR;
        private String KS;
        private boolean Kr;
        private boolean Ks;
        private boolean Kt;
        private boolean Ku;
        private boolean Kv;
        private boolean Kw;
        private boolean Kx;
        private b Ky;
        private c Kz;
        private AdTemplate adTemplate;
        private final Context context;
        private int kj;
        private int kl;
        public ac.a kn;
        public long vz;
        public int KF = -1;
        public int KI = 0;
        public int KJ = -1;
        private boolean KL = false;

        public C0461a(Context context) {
            this.context = context;
        }

        public final C0461a a(@Nullable Callable<String> callable) {
            this.KR = callable;
            return this;
        }

        public final C0461a af(String str) {
            this.KS = str;
            return this;
        }

        public final C0461a ag(String str) {
            this.KG = str;
            return this;
        }

        public final void ak(boolean z10) {
            this.KB = true;
        }

        public final C0461a al(int i10) {
            this.KQ = i10;
            return this;
        }

        public final C0461a am(int i10) {
            this.kl = i10;
            return this;
        }

        public final C0461a an(boolean z10) {
            this.Kv = true;
            return this;
        }

        public final C0461a ao(boolean z10) {
            this.KA = z10;
            return this;
        }

        public final C0461a ap(boolean z10) {
            this.KD = z10;
            return this;
        }

        public final C0461a aq(AdTemplate adTemplate) {
            this.adTemplate = adTemplate;
            return this;
        }

        public final C0461a ar(boolean z10) {
            this.KL = z10;
            return this;
        }

        public final C0461a as(boolean z10) {
            this.Ks = z10;
            return this;
        }

        public final C0461a at(boolean z10) {
            this.Ku = true;
            return this;
        }

        public final C0461a au(boolean z10) {
            this.Kr = z10;
            return this;
        }

        public final C0461a av(boolean z10) {
            this.KM = z10;
            return this;
        }

        public final C0461a aw(boolean z10) {
            this.Kt = true;
            return this;
        }

        public final C0461a b(c cVar) {
            this.Kz = cVar;
            return this;
        }

        public final C0461a c(JSONObject jSONObject) {
            this.KK = jSONObject;
            return this;
        }

        public final int cU() {
            return this.kj;
        }

        public final int cX() {
            return this.kl;
        }

        public final C0461a d(ac.a aVar) {
            this.kn = aVar;
            return this;
        }

        public final c gZ() {
            return this.Kz;
        }

        public final AdTemplate getAdTemplate() {
            return this.adTemplate;
        }

        public final Context getContext() {
            return this.context;
        }

        public final JSONObject hn() {
            return this.KK;
        }

        public final boolean nA() {
            return this.KB;
        }

        public final int nB() {
            return this.KO;
        }

        public final b nC() {
            return this.Ky;
        }

        public final boolean nD() {
            return this.Kv;
        }

        public final int nE() {
            return this.KQ;
        }

        public final boolean nF() {
            return this.Kw;
        }

        public final boolean nG() {
            return this.Kx;
        }

        public final boolean nH() {
            return this.KA;
        }

        public final long nI() {
            return this.KC;
        }

        public final boolean nJ() {
            return this.KD;
        }

        public final boolean nK() {
            return this.KE;
        }

        public final com.kwad.sdk.core.adlog.c.a nL() {
            return com.kwad.sdk.core.adlog.c.a.Br().cE(this.kl).dc(this.KG).e(this.kn).cF(this.KI).cG(this.KJ).af(this.vz).a(this.KH).cH(this.KF);
        }

        public final boolean nM() {
            return this.KL;
        }

        public final boolean nN() {
            return this.Ks;
        }

        public final boolean nO() {
            return this.Ku;
        }

        public final boolean nP() {
            return this.Kr;
        }

        public final boolean nQ() {
            return this.KM;
        }

        public final int nR() {
            return this.KN;
        }

        public final int nS() {
            return this.KP;
        }

        public final boolean nT() {
            return this.Kt;
        }

        public final String ny() {
            return this.KS;
        }

        public final Callable<String> nz() {
            return this.KR;
        }

        public final C0461a v(long j10) {
            this.KC = j10;
            return this;
        }

        public final C0461a w(long j10) {
            this.vz = j10;
            return this;
        }

        public final C0461a a(b bVar) {
            this.Ky = bVar;
            return this;
        }

        public final void ak(int i10) {
            this.KO = i10;
        }

        public final C0461a al(boolean z10) {
            this.Kw = z10;
            return this;
        }

        public final C0461a am(boolean z10) {
            this.Kx = true;
            return this;
        }

        public final C0461a an(int i10) {
            this.kj = i10;
            return this;
        }

        public final C0461a ao(int i10) {
            this.KI = i10;
            return this;
        }

        public final C0461a ap(int i10) {
            this.KJ = i10;
            return this;
        }

        public final C0461a aq(boolean z10) {
            this.KE = z10;
            return this;
        }

        public final C0461a ar(int i10) {
            this.KP = i10;
            return this;
        }

        public final C0461a a(String str, String str2, com.kwad.sdk.g.a<AdTrackLog> aVar) {
            if (this.KH == null) {
                this.KH = new a.C0516a();
            }
            this.KH.a(this.adTemplate, null, null, null);
            return this;
        }

        public final C0461a aq(int i10) {
            this.KN = i10;
            return this;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface b {
        void onAdClicked();
    }

    public static int a(@NonNull Context context, @NonNull AdTemplate adTemplate, @NonNull b bVar, @Nullable c cVar, boolean z10, boolean z11, boolean z12, boolean z13) {
        com.kwad.sdk.commercial.d.a.f(adTemplate, true);
        adTemplate.converted = true;
        d.ax(false);
        AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(adTemplate);
        com.kwad.sdk.components.c.f(com.kwad.components.a.a.a.class);
        C0461a ar2 = new C0461a(context).aq(adTemplate).a(bVar).b(cVar).ao(z10).ap(z11).al(z13).ar(false);
        int an = com.kwad.sdk.core.response.b.a.an(dQ);
        if (!(z12 || ar2.nS() == 2 || ar2.nS() == 1) && !TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.aS(dQ)) && !ar2.nO()) {
            if (an == 1) {
                if (com.kwad.sdk.core.response.b.a.bh(dQ)) {
                    return k(ar2);
                }
                return l(ar2);
            }
            if (an == 2) {
                int h10 = h(ar2);
                if (h10 == 1) {
                    return 13;
                }
                if (h10 == 2) {
                    return 16;
                }
                if (com.kwad.sdk.core.response.b.a.bh(dQ)) {
                    return k(ar2);
                }
                return l(ar2);
            }
        }
        int h11 = h(ar2);
        if (h11 == 1) {
            return 13;
        }
        if (h11 == 2) {
            return 16;
        }
        if (!com.kwad.sdk.core.response.b.a.aF(dQ)) {
            if (j(ar2)) {
                return 11;
            }
            return l(ar2);
        }
        int m10 = m(ar2);
        int i10 = dQ.status;
        if (i10 != 2 && i10 != 3) {
            e(ar2);
        }
        return m10;
    }

    private static int b(C0461a c0461a) {
        Context context = c0461a.getContext();
        AdTemplate adTemplate = c0461a.getAdTemplate();
        AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(adTemplate);
        Activity dn = l.dn(context);
        if (dn != null && com.kwad.sdk.core.response.b.a.V(dQ) && !c0461a.nA() && !c0461a.nF()) {
            c0461a.ak(2);
            com.kwad.components.core.e.e.e.a(dn, c0461a);
            d(adTemplate, 19);
            return 19;
        }
        AdWebViewActivityProxy.launch(context, new AdWebViewActivityProxy.a.C0472a().at(com.kwad.sdk.core.response.b.b.cB(adTemplate)).as(adTemplate).aD(true).pl());
        d(adTemplate, 20);
        return 20;
    }

    private static boolean c(C0461a c0461a) {
        return com.kwad.sdk.core.response.b.a.aF(com.kwad.sdk.core.response.b.e.dQ(c0461a.getAdTemplate())) ? !c0461a.nQ() && c.A(c0461a) == 3 : d(c0461a) == 1;
    }

    private static int d(C0461a c0461a) {
        AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(c0461a.getAdTemplate());
        if (dQ.unDownloadConf.unDownloadRegionConf == null) {
            return 0;
        }
        int cU = c0461a.cU();
        if (cU == 2) {
            return dQ.unDownloadConf.unDownloadRegionConf.describeBarType;
        }
        if (cU != 3) {
            return dQ.unDownloadConf.unDownloadRegionConf.actionBarType;
        }
        return dQ.unDownloadConf.unDownloadRegionConf.materialJumpType;
    }

    private static void e(C0461a c0461a) {
        if (c0461a.nA()) {
            return;
        }
        g(c0461a);
        f(c0461a);
        if (c0461a.nC() != null) {
            try {
                c0461a.nC().onAdClicked();
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
        com.kwad.sdk.commercial.d.a.bc(c0461a.getAdTemplate());
    }

    private static void f(C0461a c0461a) {
        if (c0461a.nK()) {
            com.kwad.sdk.core.adlog.c.a(c0461a.adTemplate, c0461a.nL(), c0461a.hn());
        }
    }

    private static void g(C0461a c0461a) {
        k.b bVar;
        List<WeakReference<k.b>> list = Kq;
        if (list == null || list.isEmpty() || c0461a.adTemplate == null) {
            return;
        }
        for (WeakReference<k.b> weakReference : Kq) {
            if (weakReference != null && (bVar = weakReference.get()) != null) {
                bVar.L(com.kwad.sdk.core.response.b.e.ea(c0461a.adTemplate));
            }
        }
    }

    private static int h(C0461a c0461a) {
        AdTemplate adTemplate = c0461a.getAdTemplate();
        AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(adTemplate);
        int a10 = d.a(c0461a, 1);
        if (a10 == 1) {
            d.ax(true);
            e(c0461a);
            if ((com.kwad.sdk.core.response.b.a.cK(dQ) || com.kwad.sdk.core.response.b.a.cL(dQ)) && !c0461a.nT()) {
                com.kwad.sdk.core.adlog.c.m(c0461a.getAdTemplate(), (int) Math.ceil(((float) c0461a.nI()) / 1000.0f));
            }
            d(adTemplate, 13);
        } else if (a10 == 2) {
            e(c0461a);
            d(adTemplate, 16);
        }
        return a10;
    }

    private static int i(C0461a c0461a) {
        Context context = c0461a.getContext();
        AdTemplate adTemplate = c0461a.getAdTemplate();
        AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(c0461a.getAdTemplate());
        Activity dn = l.dn(c0461a.getContext());
        if (dn != null && com.kwad.sdk.core.response.b.a.U(dQ) && !c0461a.nA() && e.E(dQ) && !c0461a.nF()) {
            c0461a.ak(1);
            com.kwad.components.core.e.e.e.a(dn, c0461a);
            e(c0461a);
            d(adTemplate, 17);
            return 2;
        }
        int d10 = e.d(context, adTemplate);
        if (d10 == 1) {
            e(c0461a);
            d(adTemplate, 12);
        }
        return d10;
    }

    private static boolean j(C0461a c0461a) {
        AdTemplate adTemplate = c0461a.getAdTemplate();
        boolean h10 = com.kwad.sdk.utils.d.h(c0461a.getContext(), adTemplate);
        if (h10) {
            e(c0461a);
            com.kwad.sdk.core.adlog.c.k(adTemplate, 0);
            d(adTemplate, 11);
        }
        return h10;
    }

    private static int k(C0461a c0461a) {
        e(c0461a);
        AdTemplate adTemplate = c0461a.getAdTemplate();
        AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(c0461a.getAdTemplate());
        Activity dn = l.dn(c0461a.getContext());
        if (dn != null && com.kwad.sdk.core.response.b.a.V(dQ) && !c0461a.nA() && !c0461a.nF()) {
            c0461a.ak(2);
            com.kwad.components.core.e.e.e.a(dn, c0461a);
            d(adTemplate, 19);
            return 19;
        }
        AdWebViewVideoActivityProxy.launch(c0461a.getContext(), adTemplate);
        d(adTemplate, 15);
        return 15;
    }

    private static int l(C0461a c0461a) {
        e(c0461a);
        Context context = c0461a.getContext();
        AdTemplate adTemplate = c0461a.getAdTemplate();
        AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(adTemplate);
        Activity dn = l.dn(context);
        if (dn != null && com.kwad.sdk.core.response.b.a.V(dQ) && !c0461a.nA() && !c0461a.nF()) {
            c0461a.ak(2);
            com.kwad.components.core.e.e.e.a(dn, c0461a);
            d(adTemplate, 19);
            return 19;
        }
        AdWebViewActivityProxy.launch(context, new AdWebViewActivityProxy.a.C0472a().at(com.kwad.sdk.core.response.b.b.cB(adTemplate)).as(adTemplate).aE(c0461a.nD()).az(1).pl());
        d(adTemplate, 14);
        return 14;
    }

    private static int m(C0461a c0461a) {
        c gZ = c0461a.gZ();
        if (gZ == null) {
            gZ = new c(c0461a.adTemplate);
            c0461a.b(gZ);
        }
        int r10 = gZ.r(c0461a);
        d(c0461a.getAdTemplate(), r10);
        return r10;
    }

    private static int n(C0461a c0461a) {
        AdTemplate adTemplate = c0461a.getAdTemplate();
        AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(adTemplate);
        if (j(c0461a)) {
            return 11;
        }
        if (com.kwad.sdk.core.response.b.a.b(dQ, com.kwad.sdk.core.config.d.BS()) && !adTemplate.mAdWebVideoPageShowing) {
            return k(c0461a);
        }
        return l(c0461a);
    }

    private static void d(AdTemplate adTemplate, int i10) {
        switch (i10) {
            case 0:
                com.kwad.sdk.commercial.d.a.bs(adTemplate);
                return;
            case 1:
                com.kwad.sdk.commercial.d.a.bh(adTemplate);
                return;
            case 2:
                com.kwad.sdk.commercial.d.a.br(adTemplate);
                return;
            case 3:
                com.kwad.sdk.commercial.d.a.bj(adTemplate);
                return;
            case 4:
                com.kwad.sdk.commercial.d.a.bp(adTemplate);
                return;
            case 5:
                com.kwad.sdk.commercial.d.a.bq(adTemplate);
                return;
            case 6:
                com.kwad.sdk.commercial.d.a.bk(adTemplate);
                return;
            case 7:
                com.kwad.sdk.commercial.d.a.bl(adTemplate);
                return;
            case 8:
                com.kwad.sdk.commercial.d.a.bm(adTemplate);
                return;
            case 9:
                com.kwad.sdk.commercial.d.a.bo(adTemplate);
                return;
            case 10:
                com.kwad.sdk.commercial.d.a.bn(adTemplate);
                return;
            case 11:
                com.kwad.sdk.commercial.d.a.bg(adTemplate);
                return;
            case 12:
                com.kwad.sdk.commercial.d.a.bf(adTemplate);
                return;
            case 13:
                com.kwad.sdk.commercial.d.a.be(adTemplate);
                return;
            case 14:
                com.kwad.sdk.commercial.d.a.bd(adTemplate);
                return;
            case 15:
                com.kwad.sdk.commercial.d.a.bi(adTemplate);
                return;
            case 16:
                com.kwad.sdk.commercial.d.a.bu(adTemplate);
                return;
            case 17:
                com.kwad.sdk.commercial.d.a.bx(adTemplate);
                return;
            case 18:
                com.kwad.sdk.commercial.d.a.bt(adTemplate);
                return;
            case 19:
                com.kwad.sdk.commercial.d.a.bv(adTemplate);
                return;
            case 20:
                com.kwad.sdk.commercial.d.a.bw(adTemplate);
                return;
            default:
                return;
        }
    }

    public static void b(k.b bVar) {
        if (Kq == null) {
            return;
        }
        int i10 = 0;
        while (true) {
            if (i10 >= Kq.size()) {
                i10 = -1;
                break;
            }
            WeakReference<k.b> weakReference = Kq.get(i10);
            if (weakReference != null && weakReference.get() != null && bVar == weakReference.get()) {
                break;
            } else {
                i10++;
            }
        }
        if (i10 != -1) {
            Kq.remove(i10);
        }
    }

    public static int a(C0461a c0461a) {
        Context context = c0461a.getContext();
        AdTemplate adTemplate = c0461a.getAdTemplate();
        AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(adTemplate);
        d.ax(false);
        if (c0461a.nG()) {
            return b(c0461a);
        }
        if (c0461a.nP()) {
            return a(context, adTemplate, c0461a.nC(), c0461a.gZ(), c0461a.KA, c0461a.nJ(), false, c0461a.nF());
        }
        com.kwad.sdk.commercial.d.a.f(adTemplate, false);
        if (c(c0461a)) {
            d(adTemplate, 1);
            return 1;
        }
        adTemplate.converted = true;
        com.kwad.sdk.components.c.f(com.kwad.components.a.a.a.class);
        int an = com.kwad.sdk.core.response.b.a.an(dQ);
        if (!(c0461a.nS() == 2 || c0461a.nS() == 1) && !TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.aS(dQ)) && !c0461a.nO()) {
            if (an == 1) {
                if (com.kwad.sdk.core.response.b.a.bh(dQ)) {
                    return k(c0461a);
                }
                return l(c0461a);
            }
            if (an == 2) {
                int h10 = h(c0461a);
                if (h10 == 1) {
                    return 13;
                }
                if (h10 == 2) {
                    return 16;
                }
                if (com.kwad.sdk.core.response.b.a.bh(dQ)) {
                    return k(c0461a);
                }
                return l(c0461a);
            }
        }
        int h11 = h(c0461a);
        if (h11 == 1) {
            return 13;
        }
        if (h11 == 2) {
            return 16;
        }
        int i10 = i(c0461a);
        if (i10 == 1) {
            return 12;
        }
        if (i10 == 2) {
            return 17;
        }
        if (c0461a.nN() && !com.kwad.sdk.core.response.b.a.aF(dQ)) {
            return n(c0461a);
        }
        if (!com.kwad.sdk.core.response.b.a.aF(dQ)) {
            if (adTemplate.isWebViewDownload) {
                return m(c0461a);
            }
            if (j(c0461a)) {
                return 11;
            }
            return l(c0461a);
        }
        if (c0461a.nS() != 2 && c0461a.nS() != 1) {
            if (c0461a.nN() && com.kwad.sdk.core.response.b.a.b(dQ, com.kwad.sdk.core.config.d.BS()) && !TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.aS(dQ)) && !AdWebViewVideoActivityProxy.showingAdWebViewVideoActivity) {
                int q10 = c0461a.gZ().q(c0461a);
                if (q10 == 0) {
                    return k(c0461a);
                }
                e(c0461a);
                d(adTemplate, q10);
                return q10;
            }
            e(c0461a);
            c0461a.ar(true);
            return m(c0461a);
        }
        c0461a.ar(false);
        e(c0461a);
        return m(c0461a);
    }

    public static void a(k.b bVar) {
        if (Kq == null) {
            Kq = new CopyOnWriteArrayList();
        }
        Kq.add(new WeakReference<>(bVar));
    }
}
