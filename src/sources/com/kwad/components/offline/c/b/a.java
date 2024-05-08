package com.kwad.components.offline.c.b;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.components.offline.api.core.soloader.SoLoadListener;
import com.kwad.components.offline.api.tk.ITkOfflineCompo;
import com.kwad.components.offline.api.tk.TkLoggerReporter;
import com.kwad.components.offline.api.tk.model.report.TKDownloadMsg;
import com.kwad.library.solder.lib.a.e;
import com.kwad.library.solder.lib.c.b;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.library.solder.lib.ext.b;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.utils.AbiUtil;
import com.kwad.sdk.utils.aa;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a {
    private static long adB;
    private static final AtomicBoolean acE = new AtomicBoolean(false);
    private static final String adv = aa.format("lib%s.so", "tk_runtime_v0_0_38");
    private static final String adw = aa.format("lib%s.so", "tk_runtime_lite_v0_0_38");
    private static final String adx = aa.format("lib%s.so", "kwai-v8");
    private static final String ady = aa.format("lib%s.so", "kwai-v8-lite");
    private static final String adz = aa.format("lib%s.so", "kwad-fb");
    private static final String adA = aa.format("lib%s.so", "kwad-yoga");
    private static final String acF = aa.format("lib%s.so", "c++_shared");
    private static Boolean adC = null;

    public static void a(Context context, @NonNull final SoLoadListener soLoadListener) {
        String BH;
        String str;
        String str2;
        AtomicBoolean atomicBoolean = acE;
        if (atomicBoolean.get()) {
            return;
        }
        atomicBoolean.set(true);
        HashMap<String, String> hashMap = new HashMap<>();
        boolean useTkLite = useTkLite();
        if (AbiUtil.isArm64(context)) {
            BH = d.BI();
            if (TextUtils.isEmpty(BH)) {
                BH = useTkLite ? "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/tachikoma/ks_tk_so_v8_lite_3334" : "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/tachikoma/ks_tk_so_v8_3334";
            }
            str = useTkLite ? "sotk-v8a-lite" : "sotk-v8a";
            str2 = useTkLite ? "39df505f83794e951720e9c753824d0c" : "2c0fb7069df4a3e6fd55e417229bcb6b";
            if (useTkLite) {
                hashMap.put(adw, "a5009e795307441cc05dbd3e8aeaead3");
                hashMap.put(ady, "77545ba1892c1a1d4a039db37b3249eb");
            } else {
                hashMap.put(adv, "e1478b9b4f377d667c7e510e88ae1bcb");
                hashMap.put(adx, "7316cd8d074b04e6cb21486288d314ce");
            }
            hashMap.put(adz, "31f065607e6da6b741330d1df0b35460");
            hashMap.put(adA, "76308532f64b68fd5a930c42cceec22b");
            hashMap.put(acF, "6ca7958ee0b0192a7c52c16faffaa8ba");
        } else {
            BH = d.BH();
            if (TextUtils.isEmpty(BH)) {
                BH = useTkLite ? "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/tachikoma/ks_tk_so_v7_lite_3334" : "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/tachikoma/ks_tk_so_v7_3334";
            }
            str = useTkLite ? "sotk-v7a-lite" : "sotk-v7a";
            str2 = useTkLite ? "a46a370ee3a1a61a0d6041b3c69c0ab7" : "f8d270613187202ab45cfec0dca9deee";
            if (useTkLite) {
                hashMap.put(adw, "8ffd76abe9e5fe33f4035b56b9d6e8e3");
                hashMap.put(ady, "2dbd72527a0739740746adaae48ed2e0");
            } else {
                hashMap.put(adv, "55e6b8f6cd2091d8f8412dafcf9f381a");
                hashMap.put(adx, "519ba633e88efafb8fbd536d800da734");
            }
            hashMap.put(adz, "eff11bebb8a3c872fa30b0484b460d12");
            hashMap.put(adA, "2c6f402c6a565d2e6912b0013fa59380");
            hashMap.put(acF, "7cb16c2840085bbdf4be628e6604bac1");
        }
        b bVar = new b();
        bVar.akg = com.kwad.sdk.core.network.idc.a.DU().dU(BH);
        bVar.Jd = true;
        bVar.akf = str;
        bVar.version = useTkLite ? "3.3.59-lite" : "3.3.59";
        bVar.akj = false;
        bVar.aki = str2;
        bVar.akl = hashMap;
        com.kwad.library.b.a i10 = com.kwad.library.solder.a.a.i(context, ITkOfflineCompo.PACKAGE_NAME);
        c.d("TkSoLoadHelper", "tkOfflineCompoPlugin: " + ((Object) i10));
        if (i10 instanceof com.kwad.library.b.a) {
            bVar.ako = i10.wU();
        }
        com.kwad.library.solder.a.a.a(context, bVar, new b.c() { // from class: com.kwad.components.offline.c.b.a.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.library.solder.lib.ext.b.C0507b, com.kwad.library.solder.lib.ext.b
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void e(com.kwad.library.solder.lib.b.c cVar) {
                super.e(cVar);
                SoLoadListener.this.onPreUpdate();
                long unused = a.adB = SystemClock.elapsedRealtime();
                TkLoggerReporter.get().reportTKSODownload(ILoggerReporter.Category.APM_LOG, new TKDownloadMsg().setDownloadState(0).setRetryCount(cVar.xr()).setThreadPoolCoreSize(cVar.xl().wY().xz()).toJson());
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.library.solder.lib.ext.b.C0507b, com.kwad.library.solder.lib.ext.b
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public void d(com.kwad.library.solder.lib.b.c cVar) {
                super.d(cVar);
                if (cVar.getState() == 4) {
                    TkLoggerReporter.get().reportTKSODownload(ILoggerReporter.Category.APM_LOG, new TKDownloadMsg().setRetryCount(cVar.xr()).setDownloadTime(SystemClock.elapsedRealtime() - a.adB).setDownloadState(1).setThreadPoolCoreSize(cVar.xl().wY().xz()).toJson());
                }
            }

            private void tG() {
                SoLoadListener.this.onLoaded();
            }

            @Override // com.kwad.library.solder.lib.ext.b.C0507b, com.kwad.library.solder.lib.ext.b
            public final /* synthetic */ void a(e eVar, com.kwad.library.solder.lib.a.a aVar) {
                tG();
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.library.solder.lib.ext.b.C0507b, com.kwad.library.solder.lib.ext.b
            public void a(com.kwad.library.solder.lib.b.c cVar, PluginError pluginError) {
                SoLoadListener.this.onFailed(pluginError.getCode(), pluginError);
                if (cVar.getState() == 1) {
                    TkLoggerReporter.get().reportTKSODownload(ILoggerReporter.Category.ERROR_LOG, new TKDownloadMsg().setRetryCount(cVar.xr()).setErrorReason(String.valueOf(pluginError.getCode())).setDownloadState(2).toJson());
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.library.solder.lib.ext.b.C0507b, com.kwad.library.solder.lib.ext.b
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void f(com.kwad.library.solder.lib.b.c cVar) {
                super.f(cVar);
            }
        });
    }

    public static boolean useTkLite() {
        if (adC == null) {
            adC = Boolean.valueOf(!d.a(com.kwad.sdk.core.config.c.aqY));
        }
        return adC.booleanValue();
    }
}
