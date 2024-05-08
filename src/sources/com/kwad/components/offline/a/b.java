package com.kwad.components.offline.a;

import android.content.Context;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.offline.api.InitCallBack;
import com.kwad.components.offline.api.adLive.IAdLiveOfflineCompo;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class b extends com.kwad.components.core.n.b.a<IAdLiveOfflineCompo> {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class a {
        private static final b acC = new b(0);
    }

    public /* synthetic */ b(byte b4) {
        this();
    }

    @InvokeBy(invokerClass = com.kwad.components.core.n.b.b.class, methodId = "initOC")
    public static void aj(Context context) {
        tE().init(context);
    }

    private static b tE() {
        return a.acC;
    }

    @Override // com.kwad.components.core.n.b.a
    public final /* bridge */ /* synthetic */ void a(Context context, boolean z10, IAdLiveOfflineCompo iAdLiveOfflineCompo) {
        a(context, iAdLiveOfflineCompo);
    }

    @Override // com.kwad.components.core.n.b.a
    public final String getTag() {
        return "AdLiveInitModule";
    }

    @Override // com.kwad.components.core.n.b.a
    public final boolean isEnabled() {
        return ((Boolean) d.b(com.kwad.sdk.core.config.c.arG)).booleanValue();
    }

    @Override // com.kwad.components.core.n.b.a
    public final String oO() {
        return "LIVE";
    }

    @Override // com.kwad.components.core.n.b.a
    public final String oP() {
        return IAdLiveOfflineCompo.PACKAGE_NAME;
    }

    @Override // com.kwad.components.core.n.b.a
    public final String oQ() {
        return "3.3.59";
    }

    @Override // com.kwad.components.core.n.b.a
    public final String oR() {
        return "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/offline_components/adLive/ks_so-adLiveNoSoRelease-3.3.59-5a16210b94-483.zip";
    }

    @Override // com.kwad.components.core.n.b.a
    public final String oS() {
        return "d4d7aede5bd01c9eaf4bf3cf50b001ef";
    }

    @Override // com.kwad.components.core.n.b.a
    public final String oT() {
        return "ks_live_3359";
    }

    @Override // com.kwad.components.core.n.b.a
    public final String oU() {
        return IAdLiveOfflineCompo.IMPL;
    }

    private b() {
    }

    private void a(Context context, final IAdLiveOfflineCompo iAdLiveOfflineCompo) {
        iAdLiveOfflineCompo.init(context, new c(), new InitCallBack() { // from class: com.kwad.components.offline.a.b.1
            @Override // com.kwad.components.offline.api.InitCallBack
            public final void onError(int i10) {
                b.this.au(i10);
            }

            @Override // com.kwad.components.offline.api.InitCallBack
            public final void onSuccess(boolean z10) {
                try {
                    com.kwad.sdk.components.c.a(com.kwad.components.core.n.a.a.a.class, new com.kwad.components.offline.a.a(iAdLiveOfflineCompo));
                    b.this.oN();
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        });
    }
}
