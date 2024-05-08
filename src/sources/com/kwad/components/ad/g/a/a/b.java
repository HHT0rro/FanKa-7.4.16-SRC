package com.kwad.components.ad.g.a.a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bn;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class b implements com.kwad.sdk.core.webview.c.a {
    public static int nt = 1;
    public static int nu = 2;
    private com.kwad.sdk.core.webview.c.c ns;
    private int nv;
    private int nw;
    private InterfaceC0410b ny;
    private c nx = new c(this, 0);

    @Nullable
    private Runnable nz = null;

    @KsJson
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a extends com.kwad.sdk.core.response.a.a {
        public int nB;
        public int nC;
    }

    /* renamed from: com.kwad.components.ad.g.a.a.b$b, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface InterfaceC0410b {
        void E(int i10);
    }

    private b(int i10, int i11) {
        this.nv = i10;
        this.nw = i11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(int i10) {
        com.kwad.sdk.core.e.c.d("RegisterTimer", "updateTimer: " + i10 + ", mCallBackFunction: " + ((Object) this.ns));
        if (i10 >= 0 && this.ns != null) {
            InterfaceC0410b interfaceC0410b = this.ny;
            if (interfaceC0410b != null && i10 == 0) {
                interfaceC0410b.E(this.nv);
            }
            a aVar = new a();
            aVar.nC = i10;
            aVar.nB = this.nv;
            com.kwad.sdk.core.webview.c.c cVar = this.ns;
            if (cVar != null) {
                cVar.a(aVar);
            }
        }
    }

    private static int f(AdInfo adInfo) {
        int b4 = com.kwad.components.ad.interstitial.b.b.b(adInfo);
        if (b4 <= 0) {
            b4 = 60;
        }
        int i10 = adInfo.adInsertScreenInfo.autoCloseTime;
        return i10 > 0 ? Math.min(b4, i10) : b4;
    }

    @Nullable
    public static b z(AdTemplate adTemplate) {
        AdInfo dQ = e.dQ(adTemplate);
        if (!(!com.kwad.sdk.core.response.b.a.bc(dQ))) {
            return null;
        }
        if (com.kwad.sdk.core.response.b.a.bH(dQ)) {
            return new b(nu, f(dQ));
        }
        int i10 = dQ.adInsertScreenInfo.autoCloseTime;
        if (i10 > 0) {
            return new b(nt, i10);
        }
        return null;
    }

    public final void eF() {
        com.kwad.sdk.core.e.c.d("RegisterTimer", "startTimer: mCallBackFunction: " + ((Object) this.ns));
        if (this.ns == null) {
            this.nz = new Runnable() { // from class: com.kwad.components.ad.g.a.a.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.eF();
                }
            };
        } else {
            this.nx.J(this.nw);
            bn.runOnUiThread(this.nx);
        }
    }

    public final void eG() {
        this.nx.y(true);
    }

    public final void eH() {
        this.nx.y(false);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerTimerListener";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.ns = null;
    }

    public final void a(InterfaceC0410b interfaceC0410b) {
        this.ny = interfaceC0410b;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class c implements Runnable {
        private boolean nD;
        private int nE;

        private c() {
            this.nD = false;
            this.nE = -1;
        }

        public final void J(int i10) {
            this.nE = i10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.kwad.sdk.core.e.c.d("RegisterTimer", "TimerRunnable run timerPaused:  " + this.nD + ", currentTime: " + this.nE);
            if (this.nD) {
                bn.a(this, null, 1000L);
                return;
            }
            int i10 = this.nE;
            if (i10 < 0) {
                return;
            }
            b.this.I(i10);
            this.nE--;
            bn.a(this, null, 1000L);
        }

        public final void y(boolean z10) {
            this.nD = z10;
        }

        public /* synthetic */ c(b bVar, byte b4) {
            this();
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.ns = cVar;
        Runnable runnable = this.nz;
        if (runnable != null) {
            runnable.run();
            this.nz = null;
        }
    }
}
