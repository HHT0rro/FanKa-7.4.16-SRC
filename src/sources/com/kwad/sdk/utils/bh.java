package com.kwad.sdk.utils;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.IOException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class bh {
    private static Class<?> aQi;

    private static <T> T a(String str, T t2, com.kwad.sdk.g.b<String, T> bVar) {
        String gR = gR(str);
        if (gR == null) {
            return t2;
        }
        try {
            return bVar.apply(gR);
        } catch (Throwable unused) {
            return t2;
        }
    }

    private static String gR(String str) {
        try {
            return com.kwad.sdk.crash.utils.h.c(Runtime.getRuntime().exec("getprop " + str).getInputStream());
        } catch (IOException e2) {
            com.kwad.sdk.core.e.c.printStackTrace(e2);
            return null;
        }
    }

    public static String get(String str) {
        Object k10 = k(MonitorConstants.CONNECT_TYPE_GET, str);
        if (k10 instanceof String) {
            return (String) k10;
        }
        return gR(str);
    }

    public static boolean getBoolean(String str, boolean z10) {
        Object k10 = k("getBoolean", str, Boolean.valueOf(z10));
        if (k10 instanceof Boolean) {
            return ((Boolean) k10).booleanValue();
        }
        return ((Boolean) a(str, Boolean.valueOf(z10), new com.kwad.sdk.g.b<String, Boolean>() { // from class: com.kwad.sdk.utils.bh.4
            private static Boolean gV(String str2) {
                return Boolean.valueOf(Boolean.parseBoolean(str2));
            }

            @Override // com.kwad.sdk.g.b
            public final /* synthetic */ Boolean apply(String str2) {
                return gV(str2);
            }
        })).booleanValue();
    }

    public static int getInt(String str, int i10) {
        Object k10 = k("getInt", str, Integer.valueOf(i10));
        if (k10 instanceof Integer) {
            return ((Integer) k10).intValue();
        }
        return ((Integer) a(str, Integer.valueOf(i10), new com.kwad.sdk.g.b<String, Integer>() { // from class: com.kwad.sdk.utils.bh.2
            private static Integer gT(String str2) {
                return Integer.valueOf(Integer.parseInt(str2));
            }

            @Override // com.kwad.sdk.g.b
            public final /* synthetic */ Integer apply(String str2) {
                return gT(str2);
            }
        })).intValue();
    }

    public static long getLong(String str, long j10) {
        Object k10 = k("getLong", str, Long.valueOf(j10));
        if (k10 instanceof Long) {
            return ((Long) k10).longValue();
        }
        return ((Long) a(str, Long.valueOf(j10), new com.kwad.sdk.g.b<String, Long>() { // from class: com.kwad.sdk.utils.bh.3
            private static Long gU(String str2) {
                return Long.valueOf(Long.parseLong(str2));
            }

            @Override // com.kwad.sdk.g.b
            public final /* synthetic */ Long apply(String str2) {
                return gU(str2);
            }
        })).longValue();
    }

    private static Object k(String str, Object... objArr) {
        try {
            if (aQi == null) {
                aQi = Class.forName("android.os.SystemProperties");
            }
            return s.b(aQi, str, objArr);
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTrace(th);
            return null;
        }
    }

    public static String get(String str, String str2) {
        Object k10 = k(MonitorConstants.CONNECT_TYPE_GET, str, str2);
        if (k10 instanceof String) {
            return (String) k10;
        }
        return (String) a(str, str2, new com.kwad.sdk.g.b<String, String>() { // from class: com.kwad.sdk.utils.bh.1
            private static String gS(String str3) {
                return str3;
            }

            @Override // com.kwad.sdk.g.b
            public final /* synthetic */ String apply(String str3) {
                return gS(str3);
            }
        });
    }
}
