package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.mobile.auth.BuildConfig;
import java.io.File;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f46994a;

    /* renamed from: b, reason: collision with root package name */
    public static fc.a f46995b;

    public static File a(String str) {
        File file;
        try {
            file = new File(str);
        } catch (NullPointerException unused) {
            fc.c.n("null pointer exception while retrieve file.");
        }
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            for (int i10 = 0; i10 < listFiles.length; i10++) {
                if (listFiles[i10].isFile() && !listFiles[i10].getName().contains("lock") && listFiles[i10].getName().contains(BuildConfig.FLAVOR_type)) {
                    return listFiles[i10];
                }
            }
            return null;
        }
        return null;
    }

    public static fc.a b() {
        return f46995b;
    }

    public static boolean c(Context context) {
        try {
            String[] strArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
            if (strArr != null) {
                for (String str : strArr) {
                    if (com.kuaishou.weapon.p0.g.f36124j.equals(str)) {
                        return true;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static void d(Context context, fc.a aVar) {
        f46995b = aVar;
        e(context);
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0013, code lost:
    
        if (c(r4) != false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void e(android.content.Context r4) {
        /*
            fc.a r0 = com.xiaomi.mipush.sdk.g.f46995b
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L8
            r0 = 1
            goto L9
        L8:
            r0 = 0
        L9:
            boolean r3 = com.xiaomi.mipush.sdk.g.f46994a
            if (r3 == 0) goto Le
            goto L16
        Le:
            boolean r3 = c(r4)
            r2 = r0
            if (r3 == 0) goto L16
            goto L17
        L16:
            r1 = 0
        L17:
            com.xiaomi.push.h2 r0 = new com.xiaomi.push.h2
            r3 = 0
            if (r2 == 0) goto L1f
            fc.a r2 = com.xiaomi.mipush.sdk.g.f46995b
            goto L20
        L1f:
            r2 = r3
        L20:
            if (r1 == 0) goto L27
            com.xiaomi.push.i2 r3 = new com.xiaomi.push.i2
            r3.<init>(r4)
        L27:
            r0.<init>(r2, r3)
            fc.c.g(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.g.e(android.content.Context):void");
    }

    public static void f(Context context, boolean z10) {
        com.xiaomi.push.n.c(context).g(new f1(context, z10));
    }
}
