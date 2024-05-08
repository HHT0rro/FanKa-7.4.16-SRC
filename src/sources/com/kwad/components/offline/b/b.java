package com.kwad.components.offline.b;

import android.content.Context;
import androidx.annotation.NonNull;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.core.request.g;
import com.kwad.components.offline.api.InitCallBack;
import com.kwad.components.offline.api.obiwan.IObiwanOfflineCompo;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class b extends com.kwad.components.core.n.b.a<IObiwanOfflineCompo> {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class a {
        private static final b acQ = new b(0);
    }

    public /* synthetic */ b(byte b4) {
        this();
    }

    @InvokeBy(invokerClass = com.kwad.components.core.n.b.b.class, methodId = "initOC")
    public static void aj(Context context) {
        tH().init(context);
    }

    private static b tH() {
        return a.acQ;
    }

    @Override // com.kwad.components.core.n.b.a
    public final /* bridge */ /* synthetic */ void a(Context context, boolean z10, IObiwanOfflineCompo iObiwanOfflineCompo) {
        a(context, iObiwanOfflineCompo);
    }

    @Override // com.kwad.components.core.n.b.a
    public final String getTag() {
        return "ObiwanInitModule";
    }

    @Override // com.kwad.components.core.n.b.a
    public final boolean isEnabled() {
        return ((Boolean) com.kwad.sdk.core.config.d.b(com.kwad.sdk.core.config.c.ase)).booleanValue();
    }

    @Override // com.kwad.components.core.n.b.a
    public final String oO() {
        return "OBIWAN";
    }

    @Override // com.kwad.components.core.n.b.a
    public final String oP() {
        return IObiwanOfflineCompo.PACKAGE_NAME;
    }

    @Override // com.kwad.components.core.n.b.a
    public final String oQ() {
        return "3.3.56";
    }

    @Override // com.kwad.components.core.n.b.a
    public final String oR() {
        return "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/offline_components/obiwan/ks_so-obiwanNoSoRelease-3.3.56-445ef4f109-409.zip";
    }

    @Override // com.kwad.components.core.n.b.a
    public final String oS() {
        return "d4a07cc878d997efd944c0182236fa7c";
    }

    @Override // com.kwad.components.core.n.b.a
    public final String oT() {
        return "ks_obiwan_3356";
    }

    @Override // com.kwad.components.core.n.b.a
    public final String oU() {
        return IObiwanOfflineCompo.IMPL;
    }

    private b() {
    }

    private void a(Context context, final IObiwanOfflineCompo iObiwanOfflineCompo) {
        iObiwanOfflineCompo.init(context, new d(), new InitCallBack() { // from class: com.kwad.components.offline.b.b.1
            @Override // com.kwad.components.offline.api.InitCallBack
            public final void onError(int i10) {
                b.this.au(i10);
            }

            @Override // com.kwad.components.offline.api.InitCallBack
            public final void onSuccess(boolean z10) {
                try {
                    final com.kwad.components.offline.b.a aVar = new com.kwad.components.offline.b.a(iObiwanOfflineCompo);
                    com.kwad.sdk.components.c.a(com.kwad.components.core.n.a.c.a.class, aVar);
                    com.kwad.sdk.core.e.c.a(new c(aVar.getLog()));
                    b.this.oN();
                    g.b(new g.a() { // from class: com.kwad.components.offline.b.b.1.1
                        private void updateConfigs() {
                            com.kwad.sdk.core.e.c.a(com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.ase) ? new c(aVar.getLog()) : null);
                            aVar.updateConfigs();
                        }

                        @Override // com.kwad.components.core.request.g.a
                        public final void d(@NonNull SdkConfigData sdkConfigData) {
                            updateConfigs();
                        }

                        @Override // com.kwad.components.core.request.g.a
                        public final void qv() {
                            updateConfigs();
                        }
                    });
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        });
    }
}
