package com.kwad.sdk.kgeo;

import android.content.Context;
import android.os.Build;
import com.kwad.library.solder.lib.a.e;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.library.solder.lib.ext.b;
import com.kwad.sdk.utils.AbiUtil;
import com.kwad.sdk.utils.au;
import com.kwad.sdk.utils.o;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class c {
    private static final AtomicBoolean sHasInit = new AtomicBoolean(false);

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface a {
        void Ho();

        void onSuccess(String str);
    }

    public static void a(final Context context, final a aVar) {
        if (au.Mm()) {
            aVar.Ho();
            return;
        }
        if (!o.Lj()) {
            aVar.Ho();
            return;
        }
        if (Build.VERSION.SDK_INT < 23) {
            aVar.Ho();
            return;
        }
        AtomicBoolean atomicBoolean = sHasInit;
        if (atomicBoolean.get()) {
            return;
        }
        atomicBoolean.set(true);
        boolean isArm64 = AbiUtil.isArm64(context);
        com.kwad.library.solder.lib.c.b bVar = new com.kwad.library.solder.lib.c.b();
        bVar.version = "1.0.3";
        bVar.akf = isArm64 ? "kmc-v8a" : "kmc-v7a";
        bVar.akg = com.kwad.sdk.core.network.idc.a.DU().dU(isArm64 ? "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/kmac/ks_kmac64" : "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/kmac/ks_kmac32");
        bVar.aki = isArm64 ? "db9a8da62a0354ec5710ec03e2743f07" : "2440a8221230913d4287c6b1e02b49f1";
        bVar.Jd = true;
        com.kwad.library.solder.a.a.a(context, bVar, new b.c() { // from class: com.kwad.sdk.kgeo.c.1
            private void tG() {
                com.kwad.sdk.core.e.c.d("KGeoSoHelper", "onPostLoad");
                try {
                    System.loadLibrary("ipneigh-android");
                    a.this.onSuccess(com.kwai.library.ipneigh.c.dw(context).aUy);
                } catch (Throwable unused) {
                    com.kwad.sdk.core.e.c.d("KGeoSoHelper", "loadLibrary fail");
                    a.this.Ho();
                }
            }

            @Override // com.kwad.library.solder.lib.ext.b.C0507b, com.kwad.library.solder.lib.ext.b
            public final /* synthetic */ void a(e eVar, com.kwad.library.solder.lib.a.a aVar2) {
                tG();
            }

            @Override // com.kwad.library.solder.lib.ext.b.C0507b, com.kwad.library.solder.lib.ext.b
            public final /* bridge */ /* synthetic */ void a(e eVar, PluginError pluginError) {
                a(pluginError);
            }

            private void a(PluginError pluginError) {
                com.kwad.sdk.core.e.c.d("KGeoSoHelper", "onFail error:" + pluginError.getMessage());
                a.this.Ho();
            }
        });
    }
}
