package com.kwad.components.core.p;

import androidx.annotation.NonNull;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.api.core.SpeedLimitApi;
import java.io.InputStream;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class b {
    private static volatile b Se = null;
    private static volatile int Sf = 204800;
    public static volatile boolean Sg = true;
    public static volatile boolean Sh;
    public static volatile Set<c> Si = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));

    public static synchronized void a(c cVar) {
        synchronized (b.class) {
            if (Si.contains(cVar)) {
                Si.remove(cVar);
            }
        }
    }

    public static void f(boolean z10, int i10) {
        if (i10 > 0) {
            Sf = i10 * 1024;
        }
        Sg = z10;
    }

    public static b qA() {
        if (Se == null) {
            synchronized (b.class) {
                if (Se == null) {
                    Se = new b();
                }
            }
        }
        return Se;
    }

    public static boolean qB() {
        return Sg;
    }

    public static int qC() {
        return Sf / 1024;
    }

    @InvokeBy(invokerClass = com.kwad.sdk.service.b.class, methodId = "initModeImplForInvoker")
    public static void register() {
        try {
            com.kwad.sdk.service.b.b(SpeedLimitApi.class, a.class);
        } catch (Throwable unused) {
        }
    }

    private static synchronized InputStream wrap(@NonNull InputStream inputStream) {
        c cVar;
        synchronized (b.class) {
            cVar = new c(inputStream, Sf / (Si.size() + 1));
            Si.add(cVar);
        }
        return cVar;
    }

    public static InputStream wrapInputStream(InputStream inputStream) {
        return wrap(inputStream);
    }

    public final synchronized int qD() {
        int i10;
        i10 = 0;
        try {
            Iterator<c> iterator2 = Si.iterator2();
            while (iterator2.hasNext()) {
                i10 += (int) iterator2.next().qE();
            }
        } catch (Exception unused) {
        }
        return i10;
    }
}
