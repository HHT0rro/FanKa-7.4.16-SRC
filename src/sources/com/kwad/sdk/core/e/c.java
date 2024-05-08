package com.kwad.sdk.core.e;

import android.util.Log;
import com.android.internal.accessibility.common.ShortcutConstants;
import com.ksad.annotation.invoker.ForInvoker;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class c {
    public static boolean avj = true;
    private static boolean avk = com.kwad.sdk.core.e.a.f36643md.booleanValue();
    private static final com.kwad.sdk.core.e.a.a avl = new b();
    private static final List<com.kwad.sdk.core.e.a.a> avm = new CopyOnWriteArrayList();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface a {
        void b(com.kwad.sdk.core.e.a.a aVar);
    }

    @ForInvoker(methodId = "registerLogger")
    private static void DL() {
        com.kwad.sdk.commercial.h.a.register();
    }

    private static void R(final String str, final String str2) {
        a(new a() { // from class: com.kwad.sdk.core.e.c.1
            @Override // com.kwad.sdk.core.e.c.a
            public final void b(com.kwad.sdk.core.e.a.a aVar) {
                aVar.d(String.this, str2);
            }
        });
    }

    private static void S(String str, String str2) {
        if (str2 != null && str2.length() > 4000) {
            R(str, str2.substring(0, 4000));
            S(str, str2.substring(4000));
        } else {
            R(str, str2);
        }
    }

    public static void T(final String str, String str2) {
        final String dN = dN(str2);
        a(new a() { // from class: com.kwad.sdk.core.e.c.5
            @Override // com.kwad.sdk.core.e.c.a
            public final void b(com.kwad.sdk.core.e.a.a aVar) {
                aVar.v(c.dM(String.this), dN, true);
            }
        });
    }

    public static void a(com.kwad.sdk.core.e.a.a aVar) {
        List<com.kwad.sdk.core.e.a.a> list = avm;
        if (list.contains(aVar)) {
            return;
        }
        list.add(aVar);
    }

    public static void d(String str, String str2) {
        S(dM(str), dN(str2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String dM(String str) {
        return "KSAd_" + str;
    }

    private static String dN(String str) {
        return str + " " + wV();
    }

    public static void e(final String str, String str2) {
        final String dN = dN(str2);
        a(new a() { // from class: com.kwad.sdk.core.e.c.9
            @Override // com.kwad.sdk.core.e.c.a
            public final void b(com.kwad.sdk.core.e.a.a aVar) {
                aVar.e(c.dM(String.this), dN);
            }
        });
    }

    public static void i(final String str, String str2) {
        final String dN = dN(str2);
        a(new a() { // from class: com.kwad.sdk.core.e.c.6
            @Override // com.kwad.sdk.core.e.c.a
            public final void b(com.kwad.sdk.core.e.a.a aVar) {
                aVar.i(c.dM(String.this), dN);
            }
        });
    }

    public static void init(boolean z10) {
        avj = z10;
        List<com.kwad.sdk.core.e.a.a> list = avm;
        list.clear();
        list.add(avl);
        DL();
    }

    public static void printStackTrace(final Throwable th) {
        if (th != null) {
            a(new a() { // from class: com.kwad.sdk.core.e.c.2
                @Override // com.kwad.sdk.core.e.c.a
                public final void b(com.kwad.sdk.core.e.a.a aVar) {
                    aVar.printStackTraceOnly(Throwable.this);
                }
            });
        }
        if (com.kwad.sdk.core.e.a.f36643md.booleanValue()) {
            throw new RuntimeException(th);
        }
    }

    public static void printStackTraceOnly(final Throwable th) {
        if (th != null) {
            a(new a() { // from class: com.kwad.sdk.core.e.c.3
                @Override // com.kwad.sdk.core.e.c.a
                public final void b(com.kwad.sdk.core.e.a.a aVar) {
                    aVar.printStackTraceOnly(Throwable.this);
                }
            });
        }
    }

    public static void v(final String str, String str2) {
        final String dN = dN(str2);
        a(new a() { // from class: com.kwad.sdk.core.e.c.4
            @Override // com.kwad.sdk.core.e.c.a
            public final void b(com.kwad.sdk.core.e.a.a aVar) {
                aVar.v(c.dM(String.this), dN);
            }
        });
    }

    public static void w(final String str, String str2) {
        final String dN = dN(str2);
        a(new a() { // from class: com.kwad.sdk.core.e.c.7
            @Override // com.kwad.sdk.core.e.c.a
            public final void b(com.kwad.sdk.core.e.a.a aVar) {
                aVar.w(c.dM(String.this), dN);
            }
        });
    }

    private static String wV() {
        String str;
        int i10;
        if (!avk) {
            return "";
        }
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        if (stackTrace.length > 3) {
            str = stackTrace[3].getFileName();
            i10 = stackTrace[3].getLineNumber();
        } else {
            str = "unknown";
            i10 = -1;
        }
        return "(" + str + ShortcutConstants.SERVICES_SEPARATOR + i10 + ')';
    }

    private static void a(a aVar) {
        for (com.kwad.sdk.core.e.a.a aVar2 : avm) {
            if (aVar2 != null) {
                try {
                    aVar.b(aVar2);
                } catch (Exception unused) {
                }
            }
        }
    }

    public static void e(final String str, String str2, Throwable th) {
        final String dN = dN(str2 + '\n' + Log.getStackTraceString(th));
        a(new a() { // from class: com.kwad.sdk.core.e.c.10
            @Override // com.kwad.sdk.core.e.c.a
            public final void b(com.kwad.sdk.core.e.a.a aVar) {
                aVar.e(c.dM(String.this), dN);
            }
        });
    }

    public static void w(final String str, Throwable th) {
        final String dN = dN(Log.getStackTraceString(th));
        a(new a() { // from class: com.kwad.sdk.core.e.c.8
            @Override // com.kwad.sdk.core.e.c.a
            public final void b(com.kwad.sdk.core.e.a.a aVar) {
                aVar.w(c.dM(String.this), dN, com.kwad.sdk.core.e.a.f36643md.booleanValue());
            }
        });
    }
}
