package com.kwad.components.core.e.d;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import com.kwad.components.core.e.c.b;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.page.AdWebViewVideoActivityProxy;
import com.kwad.components.core.page.DownloadLandPageActivity;
import com.kwad.sdk.api.KsApkDownloadListener;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.NetworkMonitor;
import com.kwad.sdk.core.adlog.c;
import com.kwad.sdk.core.diskcache.ApkCacheManager;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.n.l;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ad;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.ak;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.g;
import com.kwad.sdk.utils.v;
import com.kwad.sdk.utils.w;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class c implements NetworkMonitor.a, com.kwad.sdk.core.download.c, com.kwad.sdk.core.webview.a {

    @NonNull
    private AdTemplate KT;
    private boolean KU;
    private a KV;
    private DialogInterface.OnShowListener KW;
    private List<KsAppDownloadListener> KX;
    private boolean downloadPauseEnable;
    private Handler fS;

    @NonNull
    private AdInfo mAdInfo;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private JSONObject mReportExtData;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface a {
        boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener);
    }

    public c(@NonNull AdTemplate adTemplate, JSONObject jSONObject, KsAppDownloadListener ksAppDownloadListener) {
        this.fS = new Handler(Looper.getMainLooper());
        this.KX = new ArrayList();
        this.KT = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.dQ(adTemplate);
        this.mReportExtData = jSONObject;
        if (ksAppDownloadListener != null) {
            b(ksAppDownloadListener);
        }
        nV();
        this.downloadPauseEnable = com.kwad.sdk.core.response.b.a.cB(com.kwad.sdk.core.response.b.e.dQ(this.KT));
        nU();
        com.kwad.sdk.a.a.c.zM().aN(this.KT);
    }

    public static int A(a.C0461a c0461a) {
        AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(c0461a.getAdTemplate());
        if (dQ.downloadSafeInfo.complianceInfo == null) {
            return 0;
        }
        int cU = c0461a.cU();
        if (cU == 2) {
            return dQ.downloadSafeInfo.complianceInfo.describeBarType;
        }
        if (cU != 3) {
            return dQ.downloadSafeInfo.complianceInfo.actionBarType;
        }
        return dQ.downloadSafeInfo.complianceInfo.materialJumpType;
    }

    private void nV() {
        com.kwad.sdk.core.download.b.De();
        int dz = com.kwad.sdk.core.download.b.dz(nX());
        if (dz != 0) {
            this.mAdInfo.status = dz;
        }
        ob();
        oa();
    }

    private boolean nZ() {
        if (Build.VERSION.SDK_INT < 29) {
            if (this.KT.mIsFromContent && com.kwad.sdk.core.config.d.Bu()) {
                r1 = of();
                if (r1) {
                    com.kwad.sdk.core.adlog.c.bI(this.KT);
                }
            } else if (!this.KT.mIsFromContent && com.kwad.sdk.core.config.d.BY()) {
                boolean aa2 = com.kwad.components.core.k.b.aa(ServiceProvider.getContext());
                com.kwad.sdk.core.e.c.d("ApkDownloadHelper", "handleForceOpenApp enableForceOpen: " + aa2);
                r1 = aa2 ? of() : false;
                if (r1) {
                    com.kwad.sdk.core.adlog.c.bJ(this.KT);
                }
            }
        }
        return r1;
    }

    private void oa() {
        this.fS.post(new ay() { // from class: com.kwad.components.core.e.d.c.3
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                ArrayList<KsAppDownloadListener> arrayList = new ArrayList(c.this.KX.size());
                arrayList.addAll(c.this.KX);
                for (KsAppDownloadListener ksAppDownloadListener : arrayList) {
                    if (ksAppDownloadListener != null) {
                        c.this.a(ksAppDownloadListener);
                    }
                }
            }
        });
    }

    private boolean od() {
        a aVar = this.KV;
        if (aVar != null) {
            return aVar.handleDownloadDialog(new DialogInterface.OnClickListener() { // from class: com.kwad.components.core.e.d.c.4
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i10) {
                    if (i10 == -1) {
                        switch (c.this.mAdInfo.status) {
                            case 0:
                            case 1:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                                c.this.oh();
                                return;
                            case 2:
                            case 3:
                            case 10:
                            default:
                                return;
                            case 8:
                            case 9:
                            case 11:
                                c.this.og();
                                return;
                            case 12:
                                c.this.oe();
                                return;
                        }
                    }
                }
            });
        }
        return false;
    }

    private boolean of() {
        Context context = ServiceProvider.getContext();
        if (d.a(new a.C0461a(context).aq(this.KT), 1) == 1) {
            return true;
        }
        boolean ap = ak.ap(context, com.kwad.sdk.core.response.b.a.ay(this.mAdInfo));
        if (ap) {
            com.kwad.sdk.core.adlog.c.bH(this.KT);
        }
        return ap;
    }

    private boolean t(a.C0461a c0461a) {
        boolean h10 = com.kwad.sdk.utils.d.h(c0461a.getContext(), this.KT);
        if (h10) {
            com.kwad.sdk.core.adlog.c.k(this.KT, 0);
        }
        return h10;
    }

    private int u(a.C0461a c0461a) {
        Context context = c0461a.getContext();
        if (com.kwad.sdk.utils.d.a(context, com.kwad.sdk.core.response.b.a.cQ(this.mAdInfo), this.KT)) {
            com.kwad.sdk.core.adlog.c.k(this.KT, 1);
            return 11;
        }
        if (t(c0461a)) {
            return 11;
        }
        if (od()) {
            return 10;
        }
        if (!ag.isNetworkConnected(context)) {
            v.O(context, w.bY(context));
            return 2;
        }
        if (c0461a.nQ() && com.kwad.sdk.core.config.d.BL()) {
            return v(c0461a);
        }
        if (com.kwad.sdk.core.response.b.e.ef(this.KT) && c0461a.nS() != 2) {
            return c(c0461a.getContext(), c0461a.getAdTemplate());
        }
        if (c0461a.nM()) {
            return w(c0461a);
        }
        if (x(c0461a)) {
            return 8;
        }
        return oh();
    }

    private int v(a.C0461a c0461a) {
        Context context = c0461a.getContext();
        AdTemplate adTemplate = c0461a.getAdTemplate();
        int nR = c0461a.nR();
        if (nR == 1) {
            return oh();
        }
        if (nR != 2) {
            return 1;
        }
        if (!com.kwad.sdk.core.response.b.b.cX(adTemplate)) {
            return 8;
        }
        com.kwad.components.core.e.c.b.a(context, new b.a().ap(adTemplate).ae(com.kwad.sdk.core.response.b.b.cW(adTemplate)).a(this.KW).c(this.mOnDismissListener).nu());
        return 8;
    }

    private int w(a.C0461a c0461a) {
        Context context = c0461a.getContext();
        AdTemplate adTemplate = c0461a.getAdTemplate();
        int A = A(c0461a);
        if (A == 1) {
            if (com.kwad.sdk.core.response.b.b.cX(adTemplate)) {
                com.kwad.components.core.e.c.b.a(context, new b.a().ap(adTemplate).ae(com.kwad.sdk.core.response.b.b.cW(adTemplate)).a(this.KW).c(this.mOnDismissListener).nu());
            }
            return 8;
        }
        if (A == 2) {
            return c(c0461a.getContext(), c0461a.getAdTemplate());
        }
        if (A == 3) {
            return 1;
        }
        if (x(c0461a)) {
            return 8;
        }
        return oh();
    }

    private boolean x(a.C0461a c0461a) {
        if (c0461a.nJ() || this.mAdInfo.status == 4 || !com.kwad.sdk.core.response.b.b.da(this.KT) || !y(c0461a)) {
            return false;
        }
        return com.kwad.components.core.e.c.b.a(c0461a.getContext(), new b.a().ap(this.KT).ae(com.kwad.sdk.core.response.b.b.cZ(this.KT)).a(this.KW).c(this.mOnDismissListener).nu());
    }

    private static boolean y(a.C0461a c0461a) {
        AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(c0461a.getAdTemplate());
        if (com.kwad.sdk.core.response.b.a.bt(dQ) && (DownloadLandPageActivity.showingAdWebViewLandPage || AdWebViewVideoActivityProxy.showingAdWebViewVideoActivity || c0461a.getAdTemplate().isWebViewDownload)) {
            return true;
        }
        return com.kwad.sdk.core.response.b.a.bu(dQ) && !ag.isWifiConnected(c0461a.getContext());
    }

    private int z(a.C0461a c0461a) {
        Activity dn = l.dn(c0461a.getContext());
        if (dn != null && com.kwad.sdk.core.response.b.a.U(this.mAdInfo) && !c0461a.nA() && !c0461a.nF()) {
            c0461a.ak(1);
            com.kwad.components.core.e.e.e.a(dn, c0461a);
            return 18;
        }
        return oe();
    }

    public final void as(int i10) {
        this.KT.downloadSource = i10;
    }

    @Override // com.kwad.sdk.core.download.c
    public final void b(String str, com.kwad.sdk.core.download.e eVar) {
        if (this.mAdInfo.downloadId.equals(str)) {
            if (this.mAdInfo.status != 4 && eVar.Di()) {
                com.kwad.sdk.core.adlog.c.a(this.KT, this.mReportExtData);
                eVar.Dh();
                com.kwad.sdk.commercial.a.a.aU(this.KT);
            }
            this.mAdInfo.status = 4;
            oa();
        }
    }

    public final void clear() {
        ok();
        com.kwad.sdk.core.download.b.De().a(this);
        if (com.kwad.sdk.core.config.d.Ck()) {
            NetworkMonitor.getInstance().a(this);
        }
    }

    @Override // com.kwad.sdk.core.download.c
    public final void f(String str, com.kwad.sdk.core.download.e eVar) {
        if (this.mAdInfo.downloadId.equals(str)) {
            ob();
            if (eVar.Di()) {
                eVar.Dh();
                com.kwad.sdk.commercial.a.a.ba(this.KT);
            }
        }
    }

    @Override // com.kwad.sdk.core.download.c
    public final void g(String str, com.kwad.sdk.core.download.e eVar) {
        if (this.mAdInfo.downloadId.equals(str) && eVar.Di()) {
            eVar.Dh();
            com.kwad.sdk.core.adlog.c.bG(this.KT);
            com.kwad.sdk.commercial.a.a.aX(this.KT);
        }
    }

    public final void nU() {
        com.kwad.sdk.core.download.b.De().a(this, this.KT);
        if (com.kwad.sdk.core.config.d.Ck()) {
            NetworkMonitor.getInstance().a(ServiceProvider.getContext(), this);
        }
    }

    public final int nW() {
        ob();
        int i10 = this.mAdInfo.status;
        if (i10 == 3) {
            return 2;
        }
        return i10;
    }

    @Override // com.kwad.sdk.core.download.c
    public final String nX() {
        return this.mAdInfo.downloadId;
    }

    @Override // com.kwad.sdk.core.download.c
    public final String nY() {
        return this.mAdInfo.adBaseInfo.appPackageName;
    }

    public final void ob() {
        if (ak.an(ServiceProvider.getContext(), this.mAdInfo.adBaseInfo.appPackageName)) {
            this.mAdInfo.status = 12;
            return;
        }
        AdInfo adInfo = this.mAdInfo;
        if (adInfo.status == 12) {
            adInfo.status = 0;
            adInfo.progress = 0;
        }
        int i10 = adInfo.status;
        if (i10 == 8 || i10 == 9) {
            String str = adInfo.downloadFilePath;
            if (TextUtils.isEmpty(str) || !new File(str).exists()) {
                AdInfo adInfo2 = this.mAdInfo;
                adInfo2.status = 0;
                adInfo2.progress = 0;
            }
        }
        AdInfo adInfo3 = this.mAdInfo;
        if (adInfo3.status == 0) {
            String H = com.kwad.sdk.core.download.a.H(adInfo3);
            if (TextUtils.isEmpty(H) || !new File(H).exists()) {
                return;
            }
            AdInfo adInfo4 = this.mAdInfo;
            adInfo4.downloadFilePath = H;
            adInfo4.status = 8;
        }
    }

    @NonNull
    public final AdTemplate oc() {
        return this.KT;
    }

    public final int oe() {
        g.execute(new ay() { // from class: com.kwad.components.core.e.d.c.5
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                com.kwad.sdk.components.c.f(com.kwad.components.a.a.a.class);
            }
        });
        if (!ak.ap(ServiceProvider.getContext(), com.kwad.sdk.core.response.b.a.ay(this.mAdInfo))) {
            return 6;
        }
        com.kwad.sdk.core.adlog.c.bH(this.KT);
        return 6;
    }

    public final int og() {
        ak.a(this.mAdInfo.downloadFilePath, new ak.a() { // from class: com.kwad.components.core.e.d.c.6
            @Override // com.kwad.sdk.utils.ak.a
            public final void d(Throwable th) {
                com.kwad.sdk.commercial.a.a.i(c.this.KT, 100003, Log.getStackTraceString(th));
            }

            @Override // com.kwad.sdk.utils.ak.a
            public final void ol() {
                com.kwad.sdk.core.adlog.c.h(c.this.KT, 1);
                com.kwad.sdk.commercial.a.a.aY(c.this.KT);
            }
        });
        return 7;
    }

    public final int oh() {
        com.kwad.sdk.core.download.a.I(this.mAdInfo);
        return 3;
    }

    public final int oi() {
        com.kwad.sdk.core.download.a.dw(this.mAdInfo.downloadId);
        return 4;
    }

    public final int oj() {
        oh();
        return 5;
    }

    @Override // com.kwad.sdk.core.webview.a
    public final void ok() {
        List<KsAppDownloadListener> list = this.KX;
        if (list != null) {
            list.clear();
        }
    }

    public final int q(a.C0461a c0461a) {
        int i10 = this.mAdInfo.status;
        if (i10 != 0 && i10 != 1) {
            switch (i10) {
                case 4:
                case 5:
                case 6:
                case 7:
                    break;
                case 8:
                case 9:
                case 10:
                case 11:
                    return og();
                case 12:
                    return z(c0461a);
                default:
                    return 0;
            }
        }
        return t(c0461a) ? 11 : 0;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final int r(a.C0461a c0461a) {
        this.KU = false;
        ob();
        switch (this.mAdInfo.status) {
            case 0:
            case 1:
            case 5:
            case 6:
            case 7:
                return u(c0461a);
            case 2:
            case 3:
                if (c0461a.nH() && this.downloadPauseEnable) {
                    return oi();
                }
                return 0;
            case 4:
                return oj();
            case 8:
            case 9:
            case 11:
                return og();
            case 10:
            default:
                return 0;
            case 12:
                return z(c0461a);
        }
    }

    public final boolean s(a.C0461a c0461a) {
        return this.mAdInfo.status == 0 && t(c0461a);
    }

    public final void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    public final void setOnShowListener(DialogInterface.OnShowListener onShowListener) {
        this.KW = onShowListener;
    }

    @Override // com.kwad.sdk.core.download.c
    public final void a(String str, com.kwad.sdk.core.download.e eVar) {
        if (this.mAdInfo.downloadId.equals(str)) {
            this.mAdInfo.status = 1;
            oa();
            if (eVar.Di()) {
                this.mAdInfo.mStartDownloadTime = SystemClock.elapsedRealtime();
                com.kwad.sdk.core.adlog.c.bF(this.KT);
                eVar.Dh();
                com.kwad.sdk.commercial.a.a.o(this.KT);
            }
        }
    }

    @Override // com.kwad.sdk.core.download.c
    public final void c(String str, com.kwad.sdk.core.download.e eVar) {
        if (this.mAdInfo.downloadId.equals(str)) {
            if (this.mAdInfo.status != 2 && eVar.Di()) {
                com.kwad.sdk.core.adlog.c.b(this.KT, this.mReportExtData);
                eVar.Dh();
                com.kwad.sdk.commercial.a.a.aV(this.KT);
            }
            this.mAdInfo.status = 2;
            oa();
        }
    }

    public final void d(JSONObject jSONObject) {
        this.mReportExtData = jSONObject;
    }

    @Override // com.kwad.sdk.core.download.c
    public final void e(String str, com.kwad.sdk.core.download.e eVar) {
        if (this.mAdInfo.downloadId.equals(str)) {
            this.mAdInfo.status = 9;
            oa();
            if (eVar.Di()) {
                com.kwad.sdk.core.adlog.c.h(this.KT, 2);
                eVar.Dh();
                com.kwad.sdk.commercial.a.a.aY(this.KT);
            }
        }
    }

    @Override // com.kwad.sdk.core.download.c
    public final void d(String str, com.kwad.sdk.core.download.e eVar) {
        if (this.mAdInfo.downloadId.equals(str)) {
            if (this.mAdInfo.status != 5 && eVar.Di()) {
                com.kwad.sdk.core.adlog.c.d(this.KT, this.mReportExtData);
                eVar.Dh();
                com.kwad.sdk.commercial.a.a.aW(this.KT);
            }
            com.kwad.sdk.a.a.c.zM().aO(this.KT);
            com.kwad.sdk.a.a.b.zJ().aJ(this.KT);
            this.mAdInfo.status = 5;
            oa();
        }
    }

    @Override // com.kwad.sdk.core.download.c
    public final void b(String str, String str2, com.kwad.sdk.core.download.e eVar) {
        final boolean z10;
        this.mAdInfo.status = 12;
        oa();
        if (eVar.Di()) {
            com.kwad.sdk.core.adlog.c.e(this.KT, this.mReportExtData);
            eVar.Dh();
            com.kwad.sdk.commercial.a.a.aZ(this.KT);
            z10 = nZ();
            com.kwad.sdk.a.a.c.zM().aQ(this.KT);
            com.kwad.sdk.a.a.c.zM().aO(this.KT);
            com.kwad.sdk.a.a.b.zJ().aJ(this.KT);
            com.kwad.components.core.e.a.e.nf().am(this.KT);
            com.kwad.sdk.core.a.Bc().cW(nX());
        } else {
            z10 = false;
        }
        g.execute(new ay() { // from class: com.kwad.components.core.e.d.c.2
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                com.kwad.sdk.components.c.f(com.kwad.components.a.a.a.class);
            }
        });
    }

    public final void c(final KsAppDownloadListener ksAppDownloadListener) {
        if (ksAppDownloadListener == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.KX.remove(ksAppDownloadListener);
        } else {
            this.fS.post(new ay() { // from class: com.kwad.components.core.e.d.c.8
                @Override // com.kwad.sdk.utils.ay
                public final void doTask() {
                    c.this.KX.remove(ksAppDownloadListener);
                }
            });
        }
    }

    @Override // com.kwad.sdk.core.download.c
    public final void a(String str, int i10, int i11, int i12) {
        if (this.mAdInfo.downloadId.equals(str)) {
            AdInfo adInfo = this.mAdInfo;
            adInfo.status = 3;
            adInfo.progress = i10;
            adInfo.soFarBytes = i11;
            adInfo.totalBytes = i12;
            oa();
        }
    }

    private static int c(Context context, AdTemplate adTemplate) {
        if (context == null || adTemplate == null) {
            return 9;
        }
        DownloadLandPageActivity.launch(context, adTemplate, false);
        return 9;
    }

    public final void d(KsAppDownloadListener ksAppDownloadListener) {
        if (ksAppDownloadListener == null) {
            return;
        }
        ob();
        a(ksAppDownloadListener);
    }

    public c(@NonNull AdTemplate adTemplate, @NonNull KsAppDownloadListener ksAppDownloadListener) {
        this(adTemplate, null, ksAppDownloadListener);
    }

    public c(@NonNull AdTemplate adTemplate, JSONObject jSONObject) {
        this(adTemplate, jSONObject, null);
    }

    public c(@NonNull AdTemplate adTemplate) {
        this(adTemplate, null, null);
    }

    public c(@NonNull AdTemplate adTemplate, KsAppDownloadListener ksAppDownloadListener, String str, String str2) {
        this(adTemplate, null, null);
        AdInfo adInfo = this.mAdInfo;
        adInfo.adConversionInfo.appDownloadUrl = str;
        adInfo.adBaseInfo.appPackageName = str2;
        adInfo.downloadId = ad.bu(str);
    }

    @Override // com.kwad.sdk.core.download.c
    public final void a(String str, String str2, com.kwad.sdk.core.download.e eVar) {
        if (this.mAdInfo.downloadId.equals(str)) {
            AdInfo adInfo = this.mAdInfo;
            adInfo.downloadFilePath = str2;
            adInfo.progress = 100;
            adInfo.status = 8;
            oa();
            if (eVar.Di()) {
                eVar.Dh();
                com.kwad.sdk.core.adlog.c.c(this.KT, this.mReportExtData);
                com.kwad.sdk.commercial.a.a.j(this.KT, SystemClock.elapsedRealtime() - this.mAdInfo.mStartDownloadTime);
                com.kwad.sdk.core.a.Bc().e(str, this.KT);
                g.execute(new Runnable() { // from class: com.kwad.components.core.e.d.c.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.kwad.sdk.components.c.f(com.kwad.components.a.a.a.class);
                    }
                });
                com.kwad.sdk.a.a.c.zM().aP(this.KT);
                com.kwad.sdk.a.a.c.zM().aN(this.KT);
                com.kwad.sdk.a.a.b.zJ().aI(this.KT);
                ApkCacheManager.getInstance().CR();
            }
        }
    }

    @UiThread
    public final void b(final KsAppDownloadListener ksAppDownloadListener) {
        if (ksAppDownloadListener == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            if (!this.KX.contains(ksAppDownloadListener)) {
                this.KX.add(0, ksAppDownloadListener);
            }
        } else {
            this.fS.post(new ay() { // from class: com.kwad.components.core.e.d.c.7
                @Override // com.kwad.sdk.utils.ay
                public final void doTask() {
                    if (c.this.KX.contains(ksAppDownloadListener)) {
                        return;
                    }
                    c.this.KX.add(0, ksAppDownloadListener);
                }
            });
        }
        ob();
        a(ksAppDownloadListener);
    }

    @Override // com.kwad.sdk.core.download.c
    public final void a(String str, int i10, String str2, com.kwad.sdk.core.download.e eVar) {
        if (this.mAdInfo.downloadId.equals(str)) {
            this.mAdInfo.status = 7;
            oa();
            if (eVar.Di()) {
                c.a aVar = new c.a(i10, str2);
                com.kwad.sdk.core.adlog.c.a(this.KT, aVar);
                com.kwad.components.core.o.a.qi().a(this.KT, this.mAdInfo.adConversionInfo.appDownloadUrl, aVar.toJson().toString());
                eVar.Dh();
                com.kwad.sdk.commercial.a.a.h(this.KT, i10, str2);
            }
            if (this.mAdInfo.adConversionInfo.retryH5TimeStep <= 0 || this.KU) {
                return;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            AdInfo adInfo = this.mAdInfo;
            if (elapsedRealtime - adInfo.mStartDownloadTime >= adInfo.adConversionInfo.retryH5TimeStep || TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.aS(adInfo))) {
                return;
            }
            AdWebViewActivityProxy.launch(ServiceProvider.getContext(), this.KT);
            this.KU = true;
        }
    }

    @Override // com.kwad.sdk.core.download.c
    public final void a(String str, Throwable th, com.kwad.sdk.core.download.e eVar) {
        if (this.mAdInfo.downloadId.equals(str)) {
            this.mAdInfo.status = 11;
            oa();
            if (eVar.Di()) {
                eVar.Dh();
                com.kwad.sdk.commercial.a.a.i(this.KT, 100003, Log.getStackTraceString(th));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull KsAppDownloadListener ksAppDownloadListener) {
        AdInfo adInfo = this.mAdInfo;
        int i10 = adInfo.progress;
        switch (adInfo.status) {
            case 0:
            case 5:
                ksAppDownloadListener.onIdle();
                return;
            case 1:
                ksAppDownloadListener.onProgressUpdate(0);
                if (ksAppDownloadListener instanceof com.kwad.sdk.core.download.a.a) {
                    ((com.kwad.sdk.core.download.a.a) ksAppDownloadListener).onDownloadStarted();
                    return;
                }
                try {
                    ksAppDownloadListener.onDownloadStarted();
                    return;
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.printStackTraceOnly(th);
                    return;
                }
            case 2:
            case 3:
                ksAppDownloadListener.onProgressUpdate(i10);
                return;
            case 4:
                if (ksAppDownloadListener instanceof com.kwad.sdk.core.download.a.a) {
                    ((com.kwad.sdk.core.download.a.a) ksAppDownloadListener).onPaused(i10);
                }
                try {
                    if (ksAppDownloadListener instanceof KsApkDownloadListener) {
                        ((KsApkDownloadListener) ksAppDownloadListener).onPaused(i10);
                        return;
                    }
                    return;
                } catch (Throwable unused) {
                    return;
                }
            case 6:
            case 10:
            case 11:
            default:
                return;
            case 7:
                ksAppDownloadListener.onDownloadFailed();
                return;
            case 8:
            case 9:
                ksAppDownloadListener.onDownloadFinished();
                return;
            case 12:
                ksAppDownloadListener.onInstalled();
                return;
        }
    }

    public final void a(a aVar) {
        this.KV = aVar;
    }

    @Override // com.kwad.sdk.core.NetworkMonitor.a
    public final void a(NetworkMonitor.NetworkState networkState) {
        if (this.mAdInfo.status == 7 && networkState == NetworkMonitor.NetworkState.NETWORK_WIFI) {
            oh();
        }
    }
}
