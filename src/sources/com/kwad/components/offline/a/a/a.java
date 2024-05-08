package com.kwad.components.offline.a.a;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.offline.api.adLive.IAdLiveOfflineCompo;
import com.kwad.components.offline.api.core.soloader.SoLoadListener;
import com.kwad.library.solder.lib.a.e;
import com.kwad.library.solder.lib.c.b;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.library.solder.lib.ext.b;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.utils.AbiUtil;
import com.kwad.sdk.utils.aa;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a {
    private static final AtomicBoolean acE = new AtomicBoolean(false);
    private static final String acF = aa.format("lib%s.so", "c++_shared");
    private static final String acG = aa.format("lib%s.so", "kwaiplayer");
    private static final String acH = aa.format("lib%s.so", "kste");
    private static final String acI = aa.format("lib%s.so", "hodor");
    private static final String acJ = aa.format("lib%s.so", "aegon");

    public static void a(Context context, @NonNull final SoLoadListener soLoadListener) {
        String str;
        String str2;
        String str3;
        AtomicBoolean atomicBoolean = acE;
        if (atomicBoolean.get()) {
            return;
        }
        atomicBoolean.set(true);
        HashMap<String, String> hashMap = new HashMap<>();
        if (AbiUtil.isArm64(context)) {
            hashMap.put(acF, "dcd68cd059cb06a9596ba6839c2e8858");
            hashMap.put(acG, "cf71bcc476b2b25e2e62b541275ad78c");
            hashMap.put(acH, "ebb56fa9c5701350497e281c2446660f");
            hashMap.put(acI, "a61edf93bc5abc7799c5444ccbaf140b");
            hashMap.put(acJ, "c256c0d7f79ad4d47db61cb8e8ab142a");
            str = "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/adLive/ks_so-adLiveArm64v8aRelease-3.3.44.2-e8fbb3a5f8-666.apk";
            str2 = "adLive-v8a";
            str3 = "41a4213dcbf3ed262fc69daf7d4a29e5";
        } else {
            hashMap.put(acF, "e3fdbf82716c2cb9b666a3880ab94003");
            hashMap.put(acG, "2ba24f9d0a6e786af477ed1e2dad148b");
            hashMap.put(acH, "71a9baa45905a6f0e527e5a2e06e8808");
            hashMap.put(acI, "d997935a035d00a67dc46e26427b8bf9");
            hashMap.put(acJ, "bdac6eea0d25da98061c21234f3b20c5");
            str = "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/adLive/ks_so-adLiveArmeabiv7aRelease-3.3.44.2-e8fbb3a5f8-666.apk";
            str2 = "adLive-v7a";
            str3 = "ceddd5a3aae9148992bee153a29a25fb";
        }
        b bVar = new b();
        com.kwad.library.b.a i10 = com.kwad.library.solder.a.a.i(context, IAdLiveOfflineCompo.PACKAGE_NAME);
        c.d("AdLiveSoLoadHelper", "adLiveOfflineCompoPlugin: " + ((Object) i10));
        if (i10 instanceof com.kwad.library.b.a) {
            bVar.ako = i10.wU();
        }
        bVar.akg = com.kwad.sdk.core.network.idc.a.DU().dU(str);
        bVar.Jd = true;
        bVar.akf = str2;
        bVar.version = "3.3.44.3";
        bVar.akl = hashMap;
        bVar.aki = str3;
        bVar.akj = true;
        com.kwad.library.solder.a.a.a(context, bVar, new b.c() { // from class: com.kwad.components.offline.a.a.a.1
            private void tG() {
                SoLoadListener.this.onLoaded();
            }

            @Override // com.kwad.library.solder.lib.ext.b.C0507b, com.kwad.library.solder.lib.ext.b
            public final /* synthetic */ void a(e eVar, com.kwad.library.solder.lib.a.a aVar) {
                tG();
            }

            @Override // com.kwad.library.solder.lib.ext.b.C0507b, com.kwad.library.solder.lib.ext.b
            public final /* bridge */ /* synthetic */ void a(e eVar, PluginError pluginError) {
                a(pluginError);
            }

            private void a(PluginError pluginError) {
                SoLoadListener.this.onFailed(pluginError.getCode(), pluginError);
            }
        });
    }
}
