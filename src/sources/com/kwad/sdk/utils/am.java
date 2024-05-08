package com.kwad.sdk.utils;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Binder;
import android.os.Process;
import android.provider.Settings;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class am {
    private static Map<String, Integer> aPv;
    private static Set<String> aPw;
    private static Method aPx;

    static {
        HashSet hashSet = new HashSet();
        aPw = hashSet;
        hashSet.add("android.permission.REQUEST_INSTALL_PACKAGES");
        aPw.add("android.permission.WRITE_SETTINGS");
        aPw.add("android.permission.SYSTEM_ALERT_WINDOW");
    }

    public static int aq(Context context, String str) {
        int ar2;
        if (aPv == null) {
            h(aj.cq(context));
        }
        if (aPw.contains(str) && (ar2 = ar(context, str)) != -2) {
            return ar2;
        }
        int as = as(context, str);
        if (as != -2) {
            return as;
        }
        try {
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        } catch (Throwable unused) {
            return as;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0030. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0041 A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int ar(android.content.Context r3, java.lang.String r4) {
        /*
            r4.hashCode()
            int r0 = r4.hashCode()
            r1 = 0
            r2 = -1
            switch(r0) {
                case -2078357533: goto L24;
                case -1561629405: goto L19;
                case 1777263169: goto Le;
                default: goto Lc;
            }
        Lc:
            r4 = -1
            goto L2e
        Le:
            java.lang.String r0 = "android.permission.REQUEST_INSTALL_PACKAGES"
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L17
            goto Lc
        L17:
            r4 = 2
            goto L2e
        L19:
            java.lang.String r0 = "android.permission.SYSTEM_ALERT_WINDOW"
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L22
            goto Lc
        L22:
            r4 = 1
            goto L2e
        L24:
            java.lang.String r0 = "android.permission.WRITE_SETTINGS"
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L2d
            goto Lc
        L2d:
            r4 = 0
        L2e:
            r0 = 23
            switch(r4) {
                case 0: goto L53;
                case 1: goto L43;
                case 2: goto L34;
                default: goto L33;
            }
        L33:
            goto L5e
        L34:
            int r4 = android.os.Build.VERSION.SDK_INT
            r0 = 26
            if (r4 < r0) goto L5e
            boolean r3 = com.kwad.sdk.utils.aj.cp(r3)
            if (r3 == 0) goto L41
            goto L5f
        L41:
            r1 = -1
            goto L5f
        L43:
            int r4 = android.os.Build.VERSION.SDK_INT
            if (r4 < r0) goto L5e
            boolean r3 = android.provider.Settings.canDrawOverlays(r3)     // Catch: java.lang.Throwable -> L4e
            if (r3 == 0) goto L41
            goto L5f
        L4e:
            r3 = move-exception
            com.kwad.sdk.core.e.c.printStackTraceOnly(r3)
            goto L5e
        L53:
            int r4 = android.os.Build.VERSION.SDK_INT
            if (r4 < r0) goto L5e
            boolean r3 = android.provider.Settings.System.canWrite(r3)     // Catch: java.lang.Throwable -> L5e
            if (r3 == 0) goto L41
            goto L5f
        L5e:
            r1 = -2
        L5f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.utils.am.ar(android.content.Context, java.lang.String):int");
    }

    private static int as(Context context, String str) {
        if (aPv == null || str == null || !aPv.containsKey(str)) {
            return -2;
        }
        try {
            Integer num = aPv.get(str);
            if (num == null) {
                return -2;
            }
            if (aPx == null) {
                Class<Integer> cls = Integer.TYPE;
                Method declaredMethod = AppOpsManager.class.getDeclaredMethod("checkOp", cls, cls, String.class);
                aPx = declaredMethod;
                declaredMethod.setAccessible(true);
            }
            return ((Integer) aPx.invoke((AppOpsManager) context.getSystemService("appops"), num, Integer.valueOf(Binder.getCallingUid()), context.getPackageName())).intValue() == 0 ? 0 : -1;
        } catch (Exception e2) {
            com.kwad.sdk.core.e.c.printStackTrace(e2);
            return 0;
        }
    }

    public static boolean cr(Context context) {
        int i10;
        try {
            i10 = Settings.Secure.getInt(context.getContentResolver(), "accessibility_enabled");
        } catch (Throwable unused) {
            i10 = 0;
        }
        return i10 == 1;
    }

    private static String gG(String str) {
        if (str == null) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf < 0) {
            return str;
        }
        try {
            return str.substring(lastIndexOf + 1);
        } catch (Exception unused) {
            return str;
        }
    }

    private static void h(String[] strArr) {
        if (strArr == null) {
            return;
        }
        aPv = new HashMap();
        for (String str : strArr) {
            try {
                int intValue = ((Integer) s.c((Class<?>) AppOpsManager.class, "OP_" + gG(str))).intValue();
                if (intValue >= 0) {
                    aPv.put(str, Integer.valueOf(intValue));
                }
            } catch (Throwable unused) {
            }
        }
    }
}
