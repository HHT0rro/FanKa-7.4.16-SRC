package com.kwad.sdk.a.a;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.kwad.sdk.a.a.b;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.n.l;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import com.kwad.sdk.utils.ak;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.bn;
import com.kwad.sdk.utils.g;
import com.kwad.sdk.utils.q;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class c {
    private final Map<String, Integer> alA;
    private final Stack<AdTemplate> alB;
    private volatile boolean alC;
    public volatile boolean alD;
    public volatile boolean alE;
    private e aly;
    private final Map<String, Integer> alz;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class a {
        public static final c alJ = new c(0);
    }

    public /* synthetic */ c(byte b4) {
        this();
    }

    public static /* synthetic */ e a(c cVar, e eVar) {
        cVar.aly = null;
        return null;
    }

    private static boolean aM(AdTemplate adTemplate) {
        String H;
        if (adTemplate == null) {
            return false;
        }
        AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(adTemplate);
        if (ak.an(ServiceProvider.getContext(), com.kwad.sdk.core.response.b.a.ay(dQ)) || (H = com.kwad.sdk.core.download.a.H(dQ)) == null || TextUtils.isEmpty(H)) {
            return false;
        }
        return new File(H).exists();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aR(final AdTemplate adTemplate) {
        a(adTemplate, (DialogInterface.OnDismissListener) null, new DialogInterface.OnClickListener() { // from class: com.kwad.sdk.a.a.c.7
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                try {
                    if (i10 == -1) {
                        com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
                        bVar.cM(29);
                        bVar.cT(23);
                        com.kwad.sdk.core.adlog.c.e(adTemplate, (JSONObject) null, bVar);
                        com.kwad.sdk.a.a.a.zH();
                    } else {
                        if (i10 != -2) {
                            return;
                        }
                        c cVar = c.this;
                        c.g(adTemplate, 1);
                    }
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        });
        bn.runOnUiThreadDelay(new ay() { // from class: com.kwad.sdk.a.a.c.8
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                if (com.kwad.sdk.a.a.a.zH()) {
                    c cVar = c.this;
                    c.g(adTemplate, 2);
                }
            }
        }, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(final AdTemplate adTemplate, final boolean z10) {
        bn.runOnUiThread(new ay() { // from class: com.kwad.sdk.a.a.c.3
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                int BO = com.kwad.sdk.core.config.d.BO();
                boolean z11 = z10;
                if (z11 && BO == 2) {
                    c.this.a(adTemplate, (DialogInterface.OnDismissListener) null, new DialogInterface.OnClickListener() { // from class: com.kwad.sdk.a.a.c.3.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i10) {
                            if (i10 == -1) {
                                com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
                                bVar.cM(29);
                                bVar.cT(23);
                                com.kwad.sdk.core.adlog.c.e(adTemplate, (JSONObject) null, bVar);
                                com.kwad.sdk.a.a.a.zH();
                                return;
                            }
                            if (i10 == -2) {
                                AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                c cVar = c.this;
                                c.g(adTemplate, 1);
                            }
                        }
                    });
                } else {
                    c.this.a(adTemplate, z11, BO, false);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(AdTemplate adTemplate, int i10) {
        com.kwad.sdk.core.adlog.c.e(adTemplate, (JSONObject) null, new com.kwad.sdk.core.adlog.c.b().cM(69).cT(23).cX(i10));
    }

    public static c zM() {
        return a.alJ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zQ() {
        if (!this.alD && com.kwad.sdk.a.a.a.b.cM() <= 0) {
            bn.runOnUiThread(new Runnable() { // from class: com.kwad.sdk.a.a.c.6
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        AdTemplate zK = b.zJ().zK();
                        if (zK == null || com.kwad.sdk.core.config.d.BP() == 0) {
                            return;
                        }
                        c.this.alD = true;
                        com.kwad.sdk.core.c.b.DD();
                        com.kwad.sdk.a.a.a.b.H(com.kwad.sdk.core.c.b.getCurrentActivity());
                        c.this.aR(zK);
                    } catch (Throwable th) {
                        com.kwad.components.core.d.a.reportSdkCaughtException(th);
                    }
                }
            });
        }
    }

    public final void aN(AdTemplate adTemplate) {
        if (aM(adTemplate)) {
            this.alB.add(adTemplate);
        }
    }

    public final void aO(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return;
        }
        this.alB.remove(adTemplate);
    }

    public final void aP(final AdTemplate adTemplate) {
        int BN = com.kwad.sdk.core.config.d.BN();
        if (adTemplate == null || BN <= 0) {
            return;
        }
        final AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(adTemplate);
        if (adTemplate.mAdScene.getAdStyle() == 0) {
            return;
        }
        String valueOf = String.valueOf(com.kwad.sdk.core.response.b.e.ea(adTemplate));
        int i10 = 0;
        if (this.alz.containsKey(valueOf)) {
            i10 = this.alz.get(valueOf).intValue();
            this.alz.put(valueOf, Integer.valueOf(i10));
        }
        if (i10 > 0) {
            return;
        }
        g.schedule(new ay() { // from class: com.kwad.sdk.a.a.c.1
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                int i11 = dQ.status;
                if (i11 == 12 || i11 == 10 || !q.gs(com.kwad.sdk.core.download.a.H(com.kwad.sdk.core.response.b.e.dQ(adTemplate)))) {
                    return;
                }
                c.this.e(adTemplate, true);
            }
        }, BN, TimeUnit.SECONDS);
    }

    public final void aQ(final AdTemplate adTemplate) {
        int BZ = com.kwad.sdk.core.config.d.BZ();
        if (BZ < 0) {
            return;
        }
        final AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(adTemplate);
        String valueOf = String.valueOf(dQ.adBaseInfo.creativeId);
        int i10 = 0;
        if (this.alA.containsKey(valueOf)) {
            i10 = this.alA.get(valueOf).intValue();
            this.alA.put(valueOf, Integer.valueOf(i10));
        }
        if (i10 > 0) {
            return;
        }
        g.schedule(new Runnable() { // from class: com.kwad.sdk.a.a.c.2
            @Override // java.lang.Runnable
            public final void run() {
                if (ak.ao(ServiceProvider.getContext(), com.kwad.sdk.core.response.b.a.ay(dQ)) == 1) {
                    return;
                }
                c.this.e(adTemplate, false);
            }
        }, BZ, TimeUnit.SECONDS);
    }

    public final void bj(boolean z10) {
        this.alC = z10;
    }

    public final void dismiss() {
        com.kwad.sdk.a.a.a.zH();
        e eVar = this.aly;
        if (eVar != null) {
            eVar.dismiss();
            this.aly = null;
        }
    }

    @Nullable
    public final AdTemplate zN() {
        AdTemplate adTemplate = null;
        while (!this.alB.isEmpty()) {
            AdTemplate pop = this.alB.pop();
            if (aM(pop)) {
                adTemplate = pop;
            }
        }
        if (adTemplate != null) {
            this.alB.add(0, adTemplate);
        }
        return adTemplate;
    }

    public final void zO() {
        b.zJ().a(new b.a() { // from class: com.kwad.sdk.a.a.c.4
            @Override // com.kwad.sdk.a.a.b.a
            public final void go() {
                bn.runOnUiThreadDelay(new ay() { // from class: com.kwad.sdk.a.a.c.4.1
                    @Override // com.kwad.sdk.utils.ay
                    public final void doTask() {
                        if (!c.this.alC) {
                            c.this.zQ();
                        } else {
                            c.this.alE = true;
                        }
                    }
                }, com.kwad.sdk.core.config.d.BQ());
            }

            @Override // com.kwad.sdk.a.a.b.a
            public final void zL() {
                com.kwad.sdk.core.e.c.d("InstallTipsManager", "showInitDelayDialog failed");
            }
        });
    }

    public final void zP() {
        bj(false);
        if (this.alD || !this.alE) {
            return;
        }
        bn.runOnUiThreadDelay(new ay() { // from class: com.kwad.sdk.a.a.c.5
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                c.this.zQ();
            }
        }, 5000L);
    }

    public final void zR() {
        this.aly = null;
    }

    private c() {
        this.alz = new HashMap();
        this.alA = new HashMap();
        this.alB = new Stack<>();
        this.alC = false;
        this.alD = false;
        this.alE = false;
    }

    private static void b(Map<String, Integer> map, String str) {
        if (map.containsKey(str)) {
            map.put(str, Integer.valueOf(map.get(str).intValue() + 1));
        } else {
            map.put(str, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    public void a(AdTemplate adTemplate, DialogInterface.OnDismissListener onDismissListener, DialogInterface.OnClickListener onClickListener) {
        if (com.kwad.sdk.a.a.a.nr()) {
            return;
        }
        com.kwad.sdk.core.c.b.DD();
        Activity currentActivity = com.kwad.sdk.core.c.b.getCurrentActivity();
        if (currentActivity != null && com.kwad.sdk.a.a.a.a(currentActivity, adTemplate, onDismissListener, onClickListener)) {
            a(adTemplate, true, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    public void a(AdTemplate adTemplate, boolean z10, int i10, boolean z11) {
        if (this.aly != null || com.kwad.components.core.e.c.b.nr()) {
            return;
        }
        a(adTemplate, z10, z10 && i10 == 1, z11);
    }

    @UiThread
    private void a(final AdTemplate adTemplate, boolean z10, boolean z11, boolean z12) {
        Context context;
        Context wrapContextIfNeed;
        com.kwad.sdk.core.c.b.DD();
        Activity currentActivity = com.kwad.sdk.core.c.b.getCurrentActivity();
        if (currentActivity == null || (context = ((f) ServiceProvider.get(f.class)).getContext()) == null || (wrapContextIfNeed = l.wrapContextIfNeed(context)) == null) {
            return;
        }
        e eVar = new e(wrapContextIfNeed, adTemplate, z10, z11, z12);
        View findViewById = currentActivity.getWindow().getDecorView().findViewById(16908290);
        if (findViewById instanceof FrameLayout) {
            eVar.b((FrameLayout) findViewById);
            this.aly = eVar;
            a(adTemplate, z10, z12);
        }
        if (z12) {
            com.kwad.sdk.core.c.b.DD();
            com.kwad.sdk.a.a.a.b.H(com.kwad.sdk.core.c.b.getCurrentActivity());
            bn.runOnUiThreadDelay(new ay() { // from class: com.kwad.sdk.a.a.c.9
                @Override // com.kwad.sdk.utils.ay
                public final void doTask() {
                    if (c.this.aly != null) {
                        c.this.aly.dismiss();
                        c.a(c.this, (e) null);
                        c cVar = c.this;
                        c.g(adTemplate, 2);
                    }
                }
            }, 5000L);
        }
    }

    private void a(AdTemplate adTemplate, boolean z10, boolean z11) {
        String valueOf = String.valueOf(com.kwad.sdk.core.response.b.e.ea(adTemplate));
        if (z10) {
            b(this.alz, valueOf);
            com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
            if (z11) {
                bVar.cT(23);
                bVar.cM(191);
            } else {
                bVar.cM(92);
            }
            com.kwad.sdk.core.adlog.c.d(adTemplate, (JSONObject) null, bVar);
            return;
        }
        com.kwad.sdk.core.adlog.c.c(adTemplate, 93, (JSONObject) null);
        b(this.alA, valueOf);
    }
}
