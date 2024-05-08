package com.kwad.sdk.crash.online.monitor.block;

import com.kwad.sdk.service.ServiceProvider;
import java.util.Random;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class e {
    private static com.kwad.sdk.crash.online.monitor.a.a aGJ;

    public static com.kwad.sdk.crash.online.monitor.a.a HQ() {
        return aGJ;
    }

    public static boolean HR() {
        com.kwad.sdk.crash.online.monitor.a.a aVar = aGJ;
        return aVar != null && aVar.HU();
    }

    public static void d(com.kwad.sdk.crash.online.monitor.a.a aVar) {
        if (aVar == null) {
            return;
        }
        try {
            if (aVar.HX()) {
                com.kwad.sdk.core.e.c.d("perfMonitor.BlockManager", "allFuncDisable");
                return;
            }
            if (!a.HO()) {
                com.kwad.sdk.core.e.c.d("perfMonitor.BlockManager", "!hasBlockMonitor");
                return;
            }
            a.a(aVar);
            aGJ = aVar;
            boolean bA = a.bA(true);
            com.kwad.sdk.core.e.c.d("perfMonitor.BlockManager", "hasTenBlockHook:" + bA);
            if (aVar.aor < new Random().nextFloat()) {
                return;
            }
            b.a(aVar);
            if (aVar.HV() && bA) {
                c.b(aVar);
            }
            if (aVar.HW()) {
                com.kwad.sdk.core.e.c.d("perfMonitor.BlockManager", "hasOtherBlockMonitor:" + a.bB(false));
            }
        } catch (Throwable th) {
            try {
                ServiceProvider.reportSdkCaughtException(th);
            } catch (Exception unused) {
            }
        }
    }
}
