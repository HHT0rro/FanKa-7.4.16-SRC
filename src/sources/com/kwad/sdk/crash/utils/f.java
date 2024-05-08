package com.kwad.sdk.crash.utils;

import java.io.PrintWriter;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class f {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static abstract class a {
        private a() {
        }

        public /* synthetic */ a(byte b4) {
            this();
        }

        public abstract Object Ie();

        public abstract void println(Object obj);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class b extends a {
        private final PrintWriter aHN;

        public b(PrintWriter printWriter) {
            super((byte) 0);
            this.aHN = printWriter;
        }

        @Override // com.kwad.sdk.crash.utils.f.a
        public final Object Ie() {
            return this.aHN;
        }

        @Override // com.kwad.sdk.crash.utils.f.a
        public final void println(Object obj) {
            this.aHN.println(obj);
        }
    }

    public static void a(Throwable th, PrintWriter printWriter) {
        a(th, new b(printWriter));
    }

    private static void a(Throwable th, a aVar) {
        Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
        newSetFromMap.add(th);
        synchronized (aVar.Ie()) {
            aVar.println(th);
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                aVar.println("\tat " + ((Object) stackTraceElement));
            }
            for (Throwable th2 : th.getSuppressed()) {
                a(th2, aVar, "Suppressed: ", "\t", newSetFromMap);
            }
            Throwable cause = th.getCause();
            if (cause != null) {
                a(cause, aVar, "Caused by: ", "", newSetFromMap);
            }
        }
    }

    private static void a(Throwable th, a aVar, String str, String str2, Set<Throwable> set) {
        while (!set.contains(th)) {
            set.add(th);
            StackTraceElement[] stackTrace = th.getStackTrace();
            aVar.println(str2 + str + ((Object) th));
            for (StackTraceElement stackTraceElement : stackTrace) {
                aVar.println(str2 + "\tat " + ((Object) stackTraceElement));
            }
            for (Throwable th2 : th.getSuppressed()) {
                a(th2, aVar, "Suppressed: ", str2 + "\t", set);
            }
            th = th.getCause();
            if (th == null) {
                return;
            } else {
                str = "Caused by: ";
            }
        }
        aVar.println("\t[CIRCULAR REFERENCE:" + ((Object) th) + "]");
    }
}
