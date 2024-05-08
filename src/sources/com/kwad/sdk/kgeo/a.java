package com.kwad.sdk.kgeo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.request.b;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.kgeo.c;
import com.kwad.sdk.service.ServiceProvider;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a {
    private static String aIO;
    private static KGeoInfo aIP;
    private static final AtomicBoolean aIQ = new AtomicBoolean();

    @Nullable
    public static KGeoInfo IS() {
        return aIP;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void IT() {
        try {
            if (aIQ.getAndSet(true)) {
                return;
            }
            c.a(ServiceProvider.KO(), new c.a() { // from class: com.kwad.sdk.kgeo.a.2
                @Override // com.kwad.sdk.kgeo.c.a
                public final void Ho() {
                    a.IU();
                }

                @Override // com.kwad.sdk.kgeo.c.a
                public final void onSuccess(String str) {
                    String unused = a.aIO = str;
                    a.IU();
                }
            });
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void IU() {
        try {
            new l<f, KGeoResultData>() { // from class: com.kwad.sdk.kgeo.a.3
                @NonNull
                private static KGeoResultData fM(String str) {
                    KGeoResultData kGeoResultData = new KGeoResultData();
                    kGeoResultData.parseJson(new JSONObject(str));
                    return kGeoResultData;
                }

                @Override // com.kwad.sdk.core.network.a
                @NonNull
                public final f createRequest() {
                    return new b();
                }

                @Override // com.kwad.sdk.core.network.l
                @NonNull
                public final /* synthetic */ KGeoResultData parseData(String str) {
                    return fM(str);
                }
            }.request(new o<f, KGeoResultData>() { // from class: com.kwad.sdk.kgeo.a.4
                private static void a(@NonNull KGeoResultData kGeoResultData) {
                    KGeoInfo unused = a.aIP = kGeoResultData.kGeoInfo;
                }

                @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
                public final /* synthetic */ void onSuccess(@NonNull f fVar, @NonNull BaseResultData baseResultData) {
                    a((KGeoResultData) baseResultData);
                }
            });
        } catch (Throwable unused) {
        }
    }

    public static void dC(int i10) {
        if (i10 == 0) {
            return;
        }
        if (i10 == 1) {
            IT();
        } else if (i10 == 2) {
            com.kwad.components.core.request.b.qn().a(new b.a() { // from class: com.kwad.sdk.kgeo.a.1
                @Override // com.kwad.components.core.request.b.a
                public final void qp() {
                    com.kwad.components.core.request.b.qn().b(this);
                    a.IT();
                }
            });
        }
    }

    @Nullable
    public static String yt() {
        return aIO;
    }
}
