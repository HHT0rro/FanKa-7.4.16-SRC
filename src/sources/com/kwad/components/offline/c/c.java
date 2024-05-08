package com.kwad.components.offline.c;

import android.content.Context;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.core.request.g;
import com.kwad.components.core.request.h;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.components.offline.api.InitCallBack;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.components.offline.api.tk.ITkOfflineCompo;
import com.kwad.components.offline.api.tk.TkLoggerReporter;
import com.kwad.components.offline.api.tk.model.report.TKDownloadMsg;
import com.kwad.library.solder.lib.i;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.k;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ay;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class c extends com.kwad.components.core.n.b.a<ITkOfflineCompo> {
    private static long acU;
    private final List<com.kwad.components.core.n.a.d.a> acT;
    private final AtomicBoolean acV;

    /* renamed from: com.kwad.components.offline.c.c$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class AnonymousClass1 implements InitCallBack {
        public final /* synthetic */ ITkOfflineCompo acW;
        public final /* synthetic */ boolean acX;
        public final /* synthetic */ long acY;
        public final /* synthetic */ long acZ;
        public final /* synthetic */ Context gq;

        public AnonymousClass1(ITkOfflineCompo iTkOfflineCompo, boolean z10, long j10, long j11, Context context) {
            this.acW = iTkOfflineCompo;
            this.acX = z10;
            this.acY = j10;
            this.acZ = j11;
            this.gq = context;
        }

        @Override // com.kwad.components.offline.api.InitCallBack
        public final void onError(int i10) {
            c.this.au(i10);
        }

        @Override // com.kwad.components.offline.api.InitCallBack
        public final void onSuccess(boolean z10) {
            try {
                final b bVar = new b(this.acW);
                com.kwad.sdk.components.c.a(com.kwad.components.core.n.a.d.c.class, bVar);
                c.this.acV.set(true);
                int i10 = z10 ? 2 : 1;
                int i11 = this.acX ? 2 : 1;
                c.this.b(i10, i11, SystemClock.elapsedRealtime() - this.acY, this.acZ);
                TkLoggerReporter.get().reportTKSOLoad(ILoggerReporter.Category.APM_LOG, new TKDownloadMsg().setDownloadState(3).setOfflineLoadTime(this.acZ).setSoLoadTime(SystemClock.elapsedRealtime() - this.acY).setInitSdkTimeConsuming(SystemClock.elapsedRealtime() - k.zd().zz()).setThreadPoolCoreSize(i.xe().wY().xz()).setOfflineSource(i11).setSoSource(i10).toJson());
                c.this.oN();
                g.b(new h() { // from class: com.kwad.components.offline.c.c.1.1
                    @Override // com.kwad.components.core.request.h, com.kwad.components.core.request.g.a
                    public final void d(@NonNull final SdkConfigData sdkConfigData) {
                        super.d(sdkConfigData);
                        com.kwad.sdk.utils.g.execute(new ay() { // from class: com.kwad.components.offline.c.c.1.1.1
                            @Override // com.kwad.sdk.utils.ay
                            public final void doTask() {
                                C04921 c04921 = C04921.this;
                                bVar.onConfigRefresh(AnonymousClass1.this.gq, sdkConfigData.toJson());
                            }
                        });
                    }
                });
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class a {
        private static final c adf = new c(0);
    }

    public /* synthetic */ c(byte b4) {
        this();
    }

    @InvokeBy(invokerClass = com.kwad.components.core.n.b.b.class, methodId = "initOC")
    public static void aj(Context context) {
        acU = SystemClock.elapsedRealtime();
        tJ().init(context);
    }

    public static c tJ() {
        return a.adf;
    }

    @Override // com.kwad.components.core.n.b.a
    public final String getTag() {
        return "TkInitModule";
    }

    @Override // com.kwad.components.core.n.b.a
    public final boolean isEnabled() {
        return ((Boolean) com.kwad.sdk.core.config.d.b(com.kwad.sdk.core.config.c.arH)).booleanValue();
    }

    @Override // com.kwad.components.core.n.b.a
    public final String oO() {
        return "TK";
    }

    @Override // com.kwad.components.core.n.b.a
    public final String oP() {
        return ITkOfflineCompo.PACKAGE_NAME;
    }

    @Override // com.kwad.components.core.n.b.a
    public final String oQ() {
        return BuildConfig.VERSION_NAME;
    }

    @Override // com.kwad.components.core.n.b.a
    public final String oR() {
        return "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/offline_components/tk/ks_so-tachikomaNoSoRelease-3.3.59.1-dcbd937f5d-492.zip";
    }

    @Override // com.kwad.components.core.n.b.a
    public final String oS() {
        return "703df8b860ec5061cb90cac6b9ed6bc2";
    }

    @Override // com.kwad.components.core.n.b.a
    public final String oT() {
        return "ks_tk_33591";
    }

    @Override // com.kwad.components.core.n.b.a
    public final String oU() {
        return ITkOfflineCompo.IMPL;
    }

    private c() {
        this.acT = new CopyOnWriteArrayList();
        this.acV = new AtomicBoolean(false);
    }

    public final void b(com.kwad.components.core.n.a.d.a aVar) {
        if (aVar == null) {
            return;
        }
        this.acT.remove(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i10, int i11, long j10, long j11) {
        Iterator<com.kwad.components.core.n.a.d.a> iterator2 = this.acT.iterator2();
        while (iterator2.hasNext()) {
            try {
                iterator2.next().a(i10, i11, j10, j11);
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.components.core.n.b.a
    public void a(Context context, boolean z10, ITkOfflineCompo iTkOfflineCompo) {
        iTkOfflineCompo.init(context, new d(), new AnonymousClass1(iTkOfflineCompo, z10, SystemClock.elapsedRealtime(), SystemClock.elapsedRealtime() - acU, context));
    }

    public final void a(com.kwad.components.core.n.a.d.a aVar) {
        if (aVar == null) {
            return;
        }
        try {
            if (this.acV.get()) {
                aVar.a(1, 1, 0L, 0L);
            }
            this.acT.add(aVar);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
