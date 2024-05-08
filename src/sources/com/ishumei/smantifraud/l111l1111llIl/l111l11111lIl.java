package com.ishumei.smantifraud.l111l1111llIl;

import java.util.Locale;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class l111l11111lIl {
    public static String l1111l111111Il = "smsdk not init!";
    private static int l111l11111I1l = 5;
    private static boolean l111l11111lIl;

    private static String l1111l111111Il(String str, Object... objArr) {
        for (int i10 = 0; i10 < objArr.length; i10++) {
            if (objArr[i10] instanceof String[]) {
                objArr[i10] = l1111l111111Il((String[]) objArr[i10]);
            }
        }
        return "[" + Thread.currentThread().getId() + "] " + String.format(Locale.US, str, objArr);
    }

    private static String l1111l111111Il(String[] strArr) {
        if (strArr.length == 0) {
            return "[]";
        }
        StringBuilder sb2 = new StringBuilder("[");
        int length = strArr.length - 1;
        for (int i10 = 0; i10 < length; i10++) {
            sb2.append(strArr[i10]);
            sb2.append(", ");
        }
        sb2.append(strArr[length]);
        sb2.append("]");
        return sb2.toString();
    }

    private static void l1111l111111Il(int i10) {
        l111l11111I1l = i10;
    }

    public static void l1111l111111Il(String str, String str2, Object... objArr) {
        if (!l111l11111lIl || l111l11111I1l > 3) {
            return;
        }
        l1111l111111Il(str2, objArr);
    }

    public static void l1111l111111Il(Throwable th) {
        if (l111l11111lIl) {
            th.printStackTrace();
        }
    }

    private static void l1111l111111Il(boolean z10) {
        l111l11111lIl = z10;
    }

    private static void l111l11111I1l(String str, String str2, Object... objArr) {
        if (!l111l11111lIl || l111l11111I1l > 2) {
            return;
        }
        l1111l111111Il(str2, objArr);
    }

    private static void l111l11111Il(String str, String str2, Object... objArr) {
        if (!l111l11111lIl || l111l11111I1l > 4) {
            return;
        }
        l1111l111111Il(str2, objArr);
    }

    public static void l111l11111lIl(String str, String str2, Object... objArr) {
        if (!l111l11111lIl || l111l11111I1l > 6) {
            return;
        }
        l1111l111111Il(str2, objArr);
    }

    private static void l111l1111l1Il(String str, String str2, Object... objArr) {
        if (!l111l11111lIl || l111l11111I1l > 5) {
            return;
        }
        l1111l111111Il(str2, objArr);
    }

    private static void l111l1111llIl(String str, String str2, Object... objArr) {
        if (l111l11111I1l <= 6) {
            l1111l111111Il(str2, objArr);
        }
    }
}
