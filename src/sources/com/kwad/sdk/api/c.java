package com.kwad.sdk.api;

import androidx.annotation.Nullable;
import com.kwad.sdk.api.core.IKsAdSDK;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class c {
    private static List<Throwable> JC;
    private static IKsAdSDK alV;

    public static void a(IKsAdSDK iKsAdSDK) {
        alV = iKsAdSDK;
    }

    private static void b(Throwable th) {
        try {
            if (JC == null) {
                JC = new CopyOnWriteArrayList();
            }
            JC.add(th);
        } catch (Throwable unused) {
        }
    }

    public static String ca(String str) {
        return (String) f("TRANSFORM_API_HOST", str);
    }

    @Nullable
    public static <T> T f(String str, Object... objArr) {
        try {
            T t2 = (T) alV.dM(str, objArr);
            if (t2 != null) {
                return t2;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void m(Throwable th) {
        try {
            if (alV != null && KsAdSDK.haseInit()) {
                alV.re(th);
            } else {
                b(th);
            }
        } catch (Throwable unused) {
        }
    }

    public static void mQ() {
        try {
            com.kwad.sdk.api.a.b.a(new com.kwad.sdk.api.a.a() { // from class: com.kwad.sdk.api.c.1
                @Override // com.kwad.sdk.api.a.a
                public final void doTask() {
                    try {
                        if (c.JC == null) {
                            return;
                        }
                        for (Throwable th : c.JC) {
                            if (c.alV != null && KsAdSDK.haseInit()) {
                                c.alV.re(th);
                            }
                        }
                        c.JC.clear();
                        c.s(null);
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    public static /* synthetic */ List s(List list) {
        JC = null;
        return null;
    }

    public static IKsAdSDK zV() {
        return alV;
    }

    public static boolean zW() {
        Boolean bool = (Boolean) f("enableDynamic", new Object[0]);
        return (bool == null || bool.booleanValue()) ? false : true;
    }

    public static int zX() {
        Integer num = (Integer) f("getAutoRevertTime", new Object[0]);
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }
}
