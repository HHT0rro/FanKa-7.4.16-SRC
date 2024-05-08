package com.kwad.sdk.crash;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.library.solder.lib.ext.b;
import com.kwad.sdk.utils.AbiUtil;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class g {
    private static final AtomicBoolean aFO = new AtomicBoolean(false);

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface a {
        void Hn();

        void Ho();
    }

    public static void a(@NonNull c cVar, a aVar) {
        String str;
        String str2;
        String str3;
        AtomicBoolean atomicBoolean = aFO;
        if (atomicBoolean.get()) {
            aVar.Hn();
            return;
        }
        if (cVar.sdkVersion.compareTo(cVar.aFr) < 0) {
            com.kwad.sdk.core.e.c.d("ExceptionSoLoadHelper", "sdkVersion:" + cVar.sdkVersion + "*supportAppVersion:" + cVar.aFr);
            aVar.Ho();
            return;
        }
        Context context = cVar.context;
        atomicBoolean.set(true);
        if (AbiUtil.isArm64(context)) {
            str = cVar.aFu;
            if (TextUtils.isEmpty(str)) {
                str = "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/so/exception/202305301754/ks_so-exceptionArm64v8aRelease-3.3.47-e8fbb3a5f8-666.apk";
            }
            str2 = cVar.aFw;
            str3 = "exception-v8a";
        } else {
            str = cVar.aFv;
            if (TextUtils.isEmpty(str)) {
                str = "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/so/exception/202305301754/ks_so-exceptionArmeabiv7aRelease-3.3.47-e8fbb3a5f8-666.apk";
            }
            str2 = cVar.aFx;
            str3 = "exception-v7a";
        }
        com.kwad.library.solder.lib.c.b bVar = new com.kwad.library.solder.lib.c.b();
        bVar.akg = com.kwad.sdk.core.network.idc.a.DU().dU(str);
        bVar.Jd = true;
        bVar.akf = str3;
        bVar.version = cVar.aFq;
        bVar.aki = str2;
        bVar.akj = false;
        a(context, bVar, aVar);
    }

    private static void a(Context context, com.kwad.library.solder.lib.c.b bVar, @Nullable final a aVar) {
        com.kwad.library.solder.a.a.a(context, bVar, new b.c() { // from class: com.kwad.sdk.crash.g.1
            private void HD() {
                com.kwad.sdk.core.e.c.d("ExceptionSoLoadHelper", "onFail thread=" + Thread.currentThread().getName());
                a aVar2 = a.this;
                if (aVar2 != null) {
                    aVar2.Ho();
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.library.solder.lib.ext.b.C0507b, com.kwad.library.solder.lib.ext.b
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public void d(com.kwad.library.solder.lib.b.c cVar) {
                super.d(cVar);
                com.kwad.sdk.core.e.c.d("ExceptionSoLoadHelper", "onPostUpdate thread=" + Thread.currentThread().getName());
            }

            private void tG() {
                com.kwad.sdk.core.e.c.d("ExceptionSoLoadHelper", "onPostLoad");
                a aVar2 = a.this;
                if (aVar2 != null) {
                    aVar2.Hn();
                }
            }

            @Override // com.kwad.library.solder.lib.ext.b.C0507b, com.kwad.library.solder.lib.ext.b
            public final /* synthetic */ void a(com.kwad.library.solder.lib.a.e eVar, com.kwad.library.solder.lib.a.a aVar2) {
                tG();
            }

            @Override // com.kwad.library.solder.lib.ext.b.C0507b, com.kwad.library.solder.lib.ext.b
            public final /* synthetic */ void a(com.kwad.library.solder.lib.a.e eVar, PluginError pluginError) {
                HD();
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.library.solder.lib.ext.b.C0507b, com.kwad.library.solder.lib.ext.b
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void f(com.kwad.library.solder.lib.b.c cVar) {
                super.f(cVar);
                com.kwad.sdk.core.e.c.d("ExceptionSoLoadHelper", "onCanceled thread=" + Thread.currentThread().getName());
            }
        });
    }
}
