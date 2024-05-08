package com.kwad.components.core.request;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.x;
import com.kwad.sdk.utils.y;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class g {
    private static final AtomicBoolean sHasInit = new AtomicBoolean();
    private static volatile boolean Rs = false;
    private static final List<a> Rt = new CopyOnWriteArrayList();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface a {
        void d(@NonNull SdkConfigData sdkConfigData);

        void qv();
    }

    public static synchronized void a(a aVar) {
        synchronized (g.class) {
            com.kwad.sdk.core.e.c.d("ConfigRequestManager", "init config");
            if (sHasInit.getAndSet(true)) {
                com.kwad.sdk.core.e.c.d("ConfigRequestManager", "config request manager has init");
            } else {
                Rt.add(aVar);
                com.kwad.sdk.utils.g.execute(new ay() { // from class: com.kwad.components.core.request.g.1
                    @Override // com.kwad.sdk.utils.ay
                    public final void doTask() {
                        Context KO = ServiceProvider.KO();
                        y.k(KO, y.cb(KO) + 1);
                        com.kwad.sdk.core.config.d.aS(KO);
                        g.qs();
                        g.qr();
                    }
                });
            }
        }
    }

    public static /* synthetic */ boolean access$102(boolean z10) {
        Rs = true;
        return true;
    }

    public static void qr() {
        com.kwad.sdk.core.e.c.d("ConfigRequestManager", "requestConfig");
        new l<f, SdkConfigData>() { // from class: com.kwad.components.core.request.g.2
            @NonNull
            private static SdkConfigData aw(String str) {
                SdkConfigData sdkConfigData = new SdkConfigData();
                try {
                    y.aj(ServiceProvider.KO(), str);
                    sdkConfigData.parseJson(new JSONObject(str));
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
                return sdkConfigData;
            }

            @NonNull
            private static f qu() {
                return new f();
            }

            @Override // com.kwad.sdk.core.network.a
            @NonNull
            public final /* synthetic */ com.kwad.sdk.core.network.f createRequest() {
                return qu();
            }

            @Override // com.kwad.sdk.core.network.l
            @NonNull
            public final /* synthetic */ SdkConfigData parseData(String str) {
                return aw(str);
            }
        }.request(new o<f, SdkConfigData>() { // from class: com.kwad.components.core.request.g.3
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onError(@NonNull f fVar, int i10, String str) {
                super.onError(fVar, i10, str);
                com.kwad.sdk.core.e.c.d("ConfigRequestManager", "onError errorCode=" + i10 + " errorMsg=" + str);
            }

            private static void c(@NonNull SdkConfigData sdkConfigData) {
                try {
                    com.kwad.sdk.core.e.c.T("ConfigRequestManager", "load config success");
                    com.kwad.sdk.core.config.b.aQ(ServiceProvider.KO());
                    com.kwad.sdk.core.config.d.f(sdkConfigData);
                    g.access$102(true);
                    g.a(sdkConfigData);
                    x.LA();
                    x.Lu();
                    y.k(ServiceProvider.KO(), 0);
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(@NonNull com.kwad.sdk.core.network.f fVar, @NonNull BaseResultData baseResultData) {
                c((SdkConfigData) baseResultData);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void qs() {
        Iterator<a> iterator2 = Rt.iterator2();
        while (iterator2.hasNext()) {
            try {
                iterator2.next().qv();
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
    }

    public static void b(a aVar) {
        try {
            Rt.add(aVar);
            if (com.kwad.sdk.core.config.d.isLoaded()) {
                aVar.qv();
            }
            if (Rs) {
                aVar.d(com.kwad.sdk.core.config.d.Ca());
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(@NonNull SdkConfigData sdkConfigData) {
        Iterator<a> iterator2 = Rt.iterator2();
        while (iterator2.hasNext()) {
            try {
                iterator2.next().d(sdkConfigData);
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
    }
}
