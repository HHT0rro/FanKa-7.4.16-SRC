package com.kwad.components.ad.reward;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.h;
import com.kwad.components.ad.reward.k.r;
import com.kwad.components.ad.reward.n.p;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.i.a;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.tachikoma.c.e;
import com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.TKAdLiveShopItemInfo;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.bm;
import com.kwad.sdk.utils.bn;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class g extends com.kwad.components.core.l.a {
    public boolean fP;
    private Handler fS;
    public boolean gt;
    public boolean jY;
    public AdResultData mAdResultData;

    @NonNull
    public com.kwad.components.ad.reward.e.d mAdRewardStepListener;

    @Nullable
    public com.kwad.components.core.e.d.c mApkDownloadHelper;
    public boolean mCheckExposureResult;
    public long mPageEnterTime;

    @Nullable
    public JSONObject mReportExtData;
    private boolean mRewardVerifyCalled;

    @NonNull
    public AdBaseFrameLayout mRootContainer;
    public int mScreenOrientation;
    public bm mTimerHelper;

    @NonNull
    public KsVideoPlayConfig mVideoPlayConfig;
    public boolean oH;

    @NonNull
    public com.kwad.components.ad.reward.e.b oI;
    public com.kwad.components.ad.reward.m.e oJ;

    @Nullable
    public IAdLiveOfflineView oK;

    @Nullable
    public com.kwad.components.core.playable.a oL;

    @NonNull
    public RewardActionBarControl oM;

    @Nullable
    public j oN;

    @Nullable
    public com.kwad.components.ad.k.a oO;

    @Nullable
    public d oP;
    private final PriorityQueue<com.kwad.components.ad.reward.e.g> oQ;
    public final List<com.kwad.components.ad.reward.k.a> oR;
    private final List<r> oS;
    private final List<com.kwad.components.ad.reward.m.c> oT;
    public Set<com.kwad.components.ad.reward.e.e> oU;

    @Nullable
    private com.kwad.components.core.webview.tachikoma.e.a oV;
    private boolean oW;
    private boolean oX;
    public boolean oY;
    public boolean oZ;
    public boolean pA;

    @NonNull
    public LoadStrategy pB;
    private RewardRenderResult pC;
    private List<a> pD;
    private List<b> pE;
    private List<a.InterfaceC0466a> pF;

    /* renamed from: pa, reason: collision with root package name */
    public boolean f36543pa;

    /* renamed from: pb, reason: collision with root package name */
    public boolean f36544pb;

    /* renamed from: pc, reason: collision with root package name */
    private boolean f36545pc;

    /* renamed from: pd, reason: collision with root package name */
    public boolean f36546pd;
    public boolean pe;
    public List<Integer> pf;
    public int pg;
    public boolean ph;

    @Nullable
    public p pi;
    public boolean pj;

    @Nullable
    private PlayableSource pk;
    private boolean pl;
    public long pm;
    private List<DialogInterface.OnDismissListener> pn;

    @Nullable
    public com.kwad.components.ad.reward.e.o po;
    public boolean pp;

    @Nullable
    public com.kwad.components.ad.reward.l.b.a pq;

    @Nullable
    public com.kwad.components.ad.reward.l.a.a pr;
    public int ps;
    private int pt;
    public long pu;
    public long pv;
    public boolean pw;
    private boolean px;
    private boolean py;
    public boolean pz;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface a {
        void fU();

        void fV();

        void fW();

        void fX();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface b {
        boolean interceptPlayCardResume();
    }

    public g(com.kwad.components.core.l.b<?> bVar) {
        super(bVar);
        this.oH = false;
        this.oQ = new PriorityQueue<>();
        this.oR = new CopyOnWriteArrayList();
        this.oS = new CopyOnWriteArrayList();
        this.oT = new CopyOnWriteArrayList();
        this.oU = new HashSet();
        this.oW = false;
        this.oX = false;
        this.oZ = false;
        this.f36543pa = false;
        this.f36544pb = false;
        this.f36545pc = false;
        this.f36546pd = false;
        this.mRewardVerifyCalled = false;
        this.pe = false;
        this.pf = new ArrayList();
        this.mCheckExposureResult = true;
        this.pg = 0;
        this.ph = false;
        this.pj = false;
        this.pk = null;
        this.pl = false;
        this.gt = false;
        this.pn = new CopyOnWriteArrayList();
        this.fS = new Handler(Looper.getMainLooper());
        this.pp = false;
        this.pt = 2;
        this.px = false;
        this.py = false;
        this.pz = false;
        this.pA = false;
        this.pB = LoadStrategy.FULL_TK;
        this.pD = new CopyOnWriteArrayList();
        this.pE = new CopyOnWriteArrayList();
        this.pF = new CopyOnWriteArrayList();
        this.Ms.add(new com.kwad.components.core.l.a.a() { // from class: com.kwad.components.ad.reward.g.1
            @Override // com.kwad.components.core.l.a.a
            public final void c(com.kwad.components.core.proxy.c cVar) {
                g.this.fu();
            }

            @Override // com.kwad.components.core.l.a.a
            public final void d(com.kwad.components.core.proxy.c cVar) {
                g.this.fv();
            }

            @Override // com.kwad.components.core.l.a.a
            public final void fP() {
                g.this.ft();
            }

            @Override // com.kwad.components.core.l.a.a
            public final void fQ() {
                g.this.fw();
            }
        });
    }

    public static boolean F(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.b.e.F(adTemplate);
    }

    public static boolean G(AdTemplate adTemplate) {
        if (com.kwad.sdk.core.response.b.a.cR(com.kwad.sdk.core.response.b.e.dQ(adTemplate))) {
            return false;
        }
        return E(adTemplate) || F(adTemplate);
    }

    private void fA() {
        this.oQ.clear();
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.clear();
        }
        j jVar = this.oN;
        if (jVar != null) {
            jVar.release();
        }
        d dVar = this.oP;
        if (dVar != null) {
            dVar.release();
        }
        Set<com.kwad.components.ad.reward.e.e> set = this.oU;
        if (set != null) {
            set.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fC() {
        try {
            int size = this.oQ.size();
            for (int i10 = 0; i10 < size; i10++) {
                com.kwad.components.ad.reward.e.g poll = this.oQ.poll();
                if (poll != null) {
                    poll.bL();
                }
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ft() {
        Iterator<a> iterator2 = this.pD.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().fU();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fw() {
        Iterator<a> iterator2 = this.pD.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().fX();
        }
    }

    private static boolean isMainThread() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public final void A(boolean z10) {
        this.py = z10;
    }

    public final void B(boolean z10) {
        this.pl = true;
    }

    public final void C(boolean z10) {
        this.px = true;
    }

    public final void D(boolean z10) {
        this.oW = z10;
    }

    public final void E(final boolean z10) {
        if (z10 != this.mRewardVerifyCalled) {
            a(this.oS, new com.kwad.sdk.g.a<r>() { // from class: com.kwad.components.ad.reward.g.11
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.g.a
                /* renamed from: c, reason: merged with bridge method [inline-methods] */
                public void accept(r rVar) {
                    rVar.aa(z10);
                }
            });
        }
        this.mRewardVerifyCalled = z10;
    }

    public final void L(int i10) {
        this.pt = i10;
    }

    public final void b(a aVar) {
        this.pD.remove(aVar);
    }

    public final void d(AdResultData adResultData) {
        this.mAdResultData = adResultData;
        this.mAdTemplate = com.kwad.sdk.core.response.b.c.n(adResultData);
    }

    public final void fB() {
        if (isMainThread()) {
            fC();
        } else {
            this.fS.post(new ay() { // from class: com.kwad.components.ad.reward.g.6
                @Override // com.kwad.sdk.utils.ay
                public final void doTask() {
                    g.this.fC();
                }
            });
        }
    }

    public final boolean fD() {
        return this.py;
    }

    public final void fE() {
        com.kwad.components.core.webview.tachikoma.e.a aVar = this.oV;
        if (aVar == null) {
            return;
        }
        aVar.ja();
    }

    public final boolean fF() {
        return this.f36545pc;
    }

    @Nullable
    public final PlayableSource fG() {
        return this.pk;
    }

    public final boolean fH() {
        return this.pl;
    }

    public final List<a.InterfaceC0466a> fI() {
        return this.pF;
    }

    public final RewardRenderResult fJ() {
        return this.pC;
    }

    public final boolean fK() {
        return RewardRenderResult.NEO_TK.equals(this.pC);
    }

    public final boolean fL() {
        return this.px;
    }

    public final boolean fM() {
        return this.oW;
    }

    public final boolean fN() {
        return this.mRewardVerifyCalled;
    }

    public final void fO() {
        long j10 = this.pv;
        int i10 = j10 != 0 ? (int) (j10 / 1000) : 0;
        AdTemplate adTemplate = this.mAdTemplate;
        com.kwad.sdk.core.adlog.c.e(adTemplate, com.kwad.sdk.core.response.b.a.ae(com.kwad.sdk.core.response.b.e.dQ(adTemplate)), i10);
    }

    public final void fu() {
        if (this.oX || this.oW || this.px) {
            return;
        }
        boolean z10 = false;
        Iterator<b> iterator2 = this.pE.iterator2();
        while (iterator2.hasNext()) {
            z10 |= iterator2.next().interceptPlayCardResume();
        }
        if (z10) {
            return;
        }
        Iterator<a> iterator22 = this.pD.iterator2();
        while (iterator22.hasNext()) {
            iterator22.next().fV();
        }
    }

    public final void fv() {
        Iterator<a> iterator2 = this.pD.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().fW();
        }
    }

    public final boolean fx() {
        return this.oX;
    }

    public final void fy() {
        a(this.oT, new com.kwad.sdk.g.a<com.kwad.components.ad.reward.m.c>() { // from class: com.kwad.components.ad.reward.g.5
            private static void c(com.kwad.components.ad.reward.m.c cVar) {
                cVar.iq();
            }

            @Override // com.kwad.sdk.g.a
            public final /* synthetic */ void accept(com.kwad.components.ad.reward.m.c cVar) {
                c(cVar);
            }
        });
    }

    @Nullable
    public final String fz() {
        TKAdLiveShopItemInfo tKAdLiveShopItemInfo = this.mAdTemplate.tkLiveShopItemInfo;
        if (tKAdLiveShopItemInfo == null) {
            return null;
        }
        return tKAdLiveShopItemInfo.itemId;
    }

    @Override // com.kwad.components.core.l.a, com.kwad.sdk.mvp.a
    public final void release() {
        fA();
        com.kwad.components.ad.reward.m.e eVar = this.oJ;
        if (eVar != null) {
            eVar.release();
        }
    }

    public final void x(String str) {
        int i10 = -1;
        try {
            if (com.kwad.sdk.core.config.d.yT()) {
                i10 = com.kwad.components.ad.reward.j.a.a(getActivity());
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
        }
        com.kwad.components.ad.reward.j.b.a(this.mContext, this.mAdTemplate, str, i10, this.mReportExtData);
    }

    public final void z(boolean z10) {
        this.oX = z10;
        if (z10) {
            fv();
        } else {
            fu();
        }
    }

    public static boolean g(AdInfo adInfo) {
        return com.kwad.sdk.core.response.b.b.g(adInfo) && !com.kwad.components.ad.reward.a.b.k(adInfo);
    }

    public final void a(a aVar) {
        this.pD.add(aVar);
    }

    public final void b(b bVar) {
        this.pE.remove(bVar);
    }

    @MainThread
    public final void c(com.kwad.components.ad.reward.e.g gVar) {
        this.oQ.remove(gVar);
    }

    private static com.kwad.components.ad.reward.k.a.b c(g gVar) {
        e.b bVar = new e.b();
        bVar.d(gVar.mAdResultData);
        bVar.aU(com.kwad.sdk.core.response.b.b.du(gVar.mAdTemplate));
        bVar.aW(false);
        bVar.aX(true);
        return com.kwad.components.ad.reward.k.a.b.a(gVar, bVar);
    }

    public final void a(b bVar) {
        this.pE.add(bVar);
    }

    public final void b(com.kwad.components.ad.reward.k.a aVar) {
        this.oR.remove(aVar);
    }

    public final void d(DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnDismissListener> iterator2 = this.pn.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().onDismiss(dialogInterface);
        }
    }

    public static boolean E(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.b.e.i(adTemplate, com.kwad.components.ad.reward.a.b.k(com.kwad.sdk.core.response.b.e.dQ(adTemplate)));
    }

    public final void a(com.kwad.components.ad.reward.k.a aVar) {
        this.oR.add(aVar);
    }

    public final void b(r rVar) {
        this.oS.remove(rVar);
    }

    public final void a(r rVar) {
        this.oS.add(rVar);
    }

    public final void b(com.kwad.components.ad.reward.m.c cVar) {
        if (cVar != null) {
            this.oT.remove(cVar);
        }
    }

    public final void d(@Nullable PlayableSource playableSource) {
        this.pk = playableSource;
    }

    public final void a(com.kwad.components.ad.reward.m.c cVar) {
        if (cVar != null) {
            this.oT.add(cVar);
        }
    }

    @MainThread
    public final void b(com.kwad.components.ad.reward.e.g gVar) {
        this.oQ.offer(gVar);
    }

    public final void d(final boolean z10, final boolean z11) {
        if (this.oJ.jM()) {
            bn.runOnUiThreadDelay(new ay() { // from class: com.kwad.components.ad.reward.g.2
                @Override // com.kwad.sdk.utils.ay
                public final void doTask() {
                    com.kwad.components.ad.reward.f.a jN = g.this.oJ.jN();
                    if (jN != null) {
                        jN.setAudioEnabled(z10, z11);
                    }
                }
            }, 500L);
        }
    }

    public static <T> void a(List<T> list, com.kwad.sdk.g.a<T> aVar) {
        if (list != null) {
            Iterator<T> iterator2 = list.iterator2();
            while (iterator2.hasNext()) {
                aVar.accept(iterator2.next());
            }
        }
    }

    public final void b(int i10, Context context, int i11, int i12) {
        a(i10, context, i11, i12, 0L, false, null);
    }

    private static com.kwad.components.ad.reward.k.a.b d(g gVar) {
        if (com.kwad.sdk.core.response.b.a.cb(com.kwad.sdk.core.response.b.e.dQ(gVar.mAdTemplate)) == 4 || com.kwad.sdk.core.response.b.a.cb(com.kwad.sdk.core.response.b.e.dQ(gVar.mAdTemplate)) == 3) {
            return c(gVar);
        }
        return null;
    }

    public final void b(DialogInterface.OnDismissListener onDismissListener) {
        this.pn.remove(onDismissListener);
    }

    public final void a(long j10, long j11, int i10) {
        Iterator<com.kwad.components.ad.reward.e.e> iterator2 = this.oU.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().ce();
        }
    }

    public final void b(com.kwad.components.ad.reward.c.b bVar) {
        com.kwad.components.ad.reward.c.a.gL().a(this.mAdTemplate, bVar);
    }

    public final void b(final com.kwad.components.core.i.c cVar) {
        final com.kwad.components.core.i.d I = com.kwad.components.ad.reward.e.f.I(this.mAdTemplate.getUniqueId());
        bn.runOnUiThread(new ay() { // from class: com.kwad.components.ad.reward.g.10
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                com.kwad.components.core.i.d dVar = I;
                if (dVar != null) {
                    dVar.d(cVar);
                }
            }
        });
    }

    public final void a(int i10, Context context, int i11, int i12) {
        b(i10, context, i11, i12);
    }

    public final void a(int i10, Context context, int i11, int i12, long j10) {
        a(1, context, 40, 1, j10, false, null);
    }

    public final void a(int i10, Context context, final int i11, int i12, long j10, boolean z10, final com.kwad.sdk.core.adlog.c.b bVar) {
        com.kwad.components.core.e.d.a.a(new a.C0461a(context).aq(this.mAdTemplate).b(this.mApkDownloadHelper).ao(false).an(i12).v(j10).am(i11).al(i10).af(fz()).a(new Callable<String>() { // from class: com.kwad.components.ad.reward.g.8
            /* JADX INFO: Access modifiers changed from: private */
            @Override // java.util.concurrent.Callable
            /* renamed from: fS, reason: merged with bridge method [inline-methods] */
            public String call() {
                com.kwad.components.ad.reward.m.e eVar = g.this.oJ;
                if (eVar != null) {
                    return eVar.jN().getCurrentShowShopItemInfo().itemId;
                }
                return null;
            }
        }).a(new a.b() { // from class: com.kwad.components.ad.reward.g.7
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                try {
                    g.this.a(i11, bVar);
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        }));
    }

    public final void b(a.InterfaceC0466a interfaceC0466a) {
        List<a.InterfaceC0466a> list = this.pF;
        if (list != null) {
            list.remove(interfaceC0466a);
        }
    }

    public static boolean b(g gVar) {
        return gVar.oW;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(g gVar, h.c cVar, h.a aVar) {
        boolean b4 = b(gVar);
        com.kwad.sdk.core.e.c.d("RewardCallerContext", "showNativeCloseDialog isCloseDialogShowing: " + b4);
        if (b4) {
            return;
        }
        h.a(gVar.getActivity(), gVar.mAdTemplate, cVar, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i10, com.kwad.sdk.core.adlog.c.b bVar) {
        if (bVar == null) {
            bVar = new com.kwad.sdk.core.adlog.c.b();
        }
        bVar.cK(i10);
        bVar.f(this.mRootContainer.getTouchCoords());
        com.kwad.components.ad.reward.j.b.a(this.mAdTemplate, (String) null, (String) null, bVar, this.mReportExtData);
        com.kwad.components.ad.reward.c.a.gL().c(this.mAdTemplate, com.kwad.components.ad.reward.c.b.STATUS_NONE);
        this.oI.bJ();
    }

    public final void a(DialogInterface.OnDismissListener onDismissListener) {
        this.pn.add(onDismissListener);
    }

    public final void a(@Nullable com.kwad.components.ad.reward.e.o oVar) {
        this.po = oVar;
    }

    public final void a(com.kwad.components.core.webview.tachikoma.e.a aVar) {
        this.oV = aVar;
    }

    public final void a(final com.kwad.components.core.i.c cVar) {
        final com.kwad.components.core.i.d I = com.kwad.components.ad.reward.e.f.I(this.mAdTemplate.getUniqueId());
        bn.runOnUiThread(new ay() { // from class: com.kwad.components.ad.reward.g.9
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                com.kwad.components.core.i.d dVar = I;
                if (dVar != null) {
                    dVar.c(cVar);
                }
            }
        });
    }

    public final void a(a.InterfaceC0466a interfaceC0466a) {
        List<a.InterfaceC0466a> list = this.pF;
        if (list != null) {
            list.add(interfaceC0466a);
        }
    }

    @Nullable
    public static com.kwad.components.core.i.c a(List<com.kwad.components.core.i.c> list, long j10) {
        if (j10 >= 0 && list != null) {
            for (com.kwad.components.core.i.c cVar : list) {
                if (com.kwad.sdk.core.response.b.e.ea(cVar.getAdTemplate()) == j10) {
                    return cVar;
                }
            }
        }
        return null;
    }

    public final void a(RewardRenderResult rewardRenderResult) {
        this.pC = rewardRenderResult;
    }

    public static void a(Context context, g gVar, ViewGroup viewGroup) {
        AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(gVar.mAdTemplate);
        com.kwad.components.core.n.a.a.a aVar = (com.kwad.components.core.n.a.a.a) com.kwad.sdk.components.c.f(com.kwad.components.core.n.a.a.a.class);
        if (aVar != null && aVar.oK() && com.kwad.sdk.core.response.b.a.cL(com.kwad.sdk.core.response.b.e.dQ(gVar.mAdTemplate))) {
            IAdLiveOfflineView iAdLiveOfflineView = null;
            try {
                iAdLiveOfflineView = aVar.getView(context, com.kwad.sdk.core.response.b.a.bf(dQ) == 8 ? 1 : 0);
            } catch (Throwable unused) {
            }
            if (iAdLiveOfflineView != null) {
                View view = iAdLiveOfflineView.getView();
                gVar.oK = iAdLiveOfflineView;
                viewGroup.addView(view);
                gVar.oJ.a(2, new com.kwad.components.ad.reward.f.a(gVar.mAdTemplate, aVar.getAdLivePlayModule(iAdLiveOfflineView, ServiceProvider.getAppId(), String.valueOf(com.kwad.sdk.core.response.b.a.cg(dQ)), com.kwad.sdk.core.response.b.a.ch(dQ), com.kwad.sdk.core.response.b.a.ci(dQ))));
            }
        }
    }

    public static long a(long j10, AdInfo adInfo) {
        return Math.min(com.kwad.sdk.core.response.b.a.ag(adInfo), j10);
    }

    public static void a(g gVar, final h.c cVar, final h.a aVar) {
        if (!gVar.oJ.jM()) {
            AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(gVar.mAdTemplate);
            r1 = com.kwad.components.ad.reward.a.b.j(dQ) || com.kwad.sdk.core.response.b.a.cb(dQ) == 2 ? c(gVar) : null;
            if (r1 == null) {
                r1 = d(gVar);
            }
        }
        com.kwad.components.ad.reward.k.a.b bVar = r1;
        if (bVar != null) {
            com.kwad.components.ad.reward.k.a.b.a(bVar, gVar.getActivity(), gVar.oJ.getPlayDuration(), aVar, new e.a() { // from class: com.kwad.components.ad.reward.g.12
                @Override // com.kwad.components.core.webview.tachikoma.c.e.a
                public final boolean fT() {
                    g.b(g.this, cVar, aVar);
                    return true;
                }
            });
        } else {
            b(gVar, cVar, aVar);
        }
    }

    public static void a(Activity activity, g gVar) {
        com.kwad.sdk.core.e.c.d("RewardCallerContext", "showExtraDialog");
        com.kwad.components.ad.reward.k.a.b.a(gVar, activity, gVar.oJ.getPlayDuration(), new DialogInterface.OnDismissListener() { // from class: com.kwad.components.ad.reward.g.3
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                g.this.d(dialogInterface);
                com.kwad.sdk.core.c.b.DD();
                Activity currentActivity = com.kwad.sdk.core.c.b.getCurrentActivity();
                if (currentActivity == null || !currentActivity.equals(g.this.getActivity())) {
                    return;
                }
                g.this.oJ.resume();
            }
        }, new h.b() { // from class: com.kwad.components.ad.reward.g.4
            @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.e.c
            public final void fR() {
                g.this.oJ.pause();
            }
        });
    }
}
