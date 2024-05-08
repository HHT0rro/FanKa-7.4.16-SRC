package com.huawei.hms.feature.dynamic.f;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.huawei.hms.common.util.Logger;
import com.huawei.openalliance.ad.constant.u;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static final String f29902a = "HMSPkgManager";

    /* renamed from: b, reason: collision with root package name */
    public static final List<String> f29903b = new a();

    /* renamed from: c, reason: collision with root package name */
    public static final int f29904c = 8;

    /* renamed from: d, reason: collision with root package name */
    public static final int f29905d = 4;

    /* renamed from: e, reason: collision with root package name */
    public static final int f29906e = 5;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a extends ArrayList<String> {
        public a() {
            add("com.huawei.hwid");
            add("com.huawei.hwid.tv");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class b implements PrivilegedAction {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Field f29907a;

        public b(Field field) {
            this.f29907a = field;
        }

        @Override // java.security.PrivilegedAction
        public Object run() {
            this.f29907a.setAccessible(true);
            return null;
        }
    }

    public static boolean a(Context context) {
        if (context == null) {
            Logger.e(f29902a, "The given context is null.");
            return false;
        }
        for (String str : f29903b) {
            try {
            } catch (PackageManager.NameNotFoundException unused) {
                Logger.w(f29902a, "Query for HMS Core package name:" + str + " failed.");
            }
            if (context.getPackageManager().getPackageInfo(str, 0) != null) {
                Logger.i(f29902a, "The HMS Core is installed, pkgName:" + str);
                return true;
            }
            continue;
        }
        return false;
    }

    public static boolean a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            Logger.e(f29902a, "context is null or filePath is null.");
            return false;
        }
        try {
        } catch (IOException unused) {
            Logger.e(f29902a, "checkPathValidity IOException");
        }
        if (!new File(str).exists()) {
            Logger.w(f29902a, "the file does not exist.");
            return false;
        }
        String canonicalPath = new File(str).getCanonicalPath();
        if (canonicalPath.startsWith("/system/app/HFF")) {
            Logger.i(f29902a, "HFF file path, need not to verify.");
            return true;
        }
        if (canonicalPath.startsWith("/data/data/")) {
            String[] split = canonicalPath.split("/");
            if (split.length >= 4) {
                return b(context, split[3]);
            }
        } else {
            if (!canonicalPath.startsWith("/data/user_de/") && !canonicalPath.startsWith("/data/user/")) {
                Logger.w(f29902a, "illegal path.");
            }
            String[] split2 = canonicalPath.split("/");
            if (split2.length >= 5) {
                return b(context, split2[4]);
            }
        }
        return false;
    }

    public static boolean b(Context context, String str) {
        ApplicationInfo applicationInfo;
        if (context == null || TextUtils.isEmpty(str)) {
            Logger.e(f29902a, "context is null or pkgName is null.");
            return false;
        }
        PackageInfo packageInfo = null;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 16384);
        } catch (PackageManager.NameNotFoundException e2) {
            Logger.e(f29902a, "get PrivAppFlag err for " + str + u.bD + e2.getMessage());
        }
        if (packageInfo == null || (applicationInfo = packageInfo.applicationInfo) == null) {
            Logger.i(f29902a, "Get pkg application null:" + str);
            return false;
        }
        try {
            Field field = applicationInfo.getClass().getField("privateFlags");
            AccessController.doPrivileged(new b(field));
            Object obj = field.get(applicationInfo);
            if (!(obj instanceof Integer)) {
                Logger.i(f29902a, "Get privFlag instance error.");
                return false;
            }
            int intValue = ((Integer) obj).intValue();
            Logger.d(f29902a, "privFlag of " + str + " is:" + intValue);
            boolean z10 = (intValue & 8) != 0;
            Logger.i(f29902a, "pkgName:" + str + ", isPrivApp:" + z10);
            return z10;
        } catch (IllegalAccessException | NoSuchFieldException e10) {
            Logger.e(f29902a, "get Priv App Flag err for " + str + u.bD + e10.getMessage());
            return false;
        }
    }

    public static boolean c(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            Logger.w(f29902a, "context is null or pkgName is null.");
            return false;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 16384);
            boolean z10 = (packageInfo == null || (packageInfo.applicationInfo.flags & 1) == 0) ? false : true;
            Logger.i(f29902a, "isHMSSystemApp:" + z10);
            if (z10) {
                Logger.i(f29902a, "The HMS package:" + str + " is SystemApp");
                return true;
            }
        } catch (PackageManager.NameNotFoundException e2) {
            Logger.e(f29902a, "getSystemApp flag error for " + str + u.bD + e2.getMessage());
        }
        return false;
    }
}
