package com.huawei.hms.ads.uiengineloader;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private static final String f29441a = "ClassLoaderPathManager";

    /* renamed from: b, reason: collision with root package name */
    private static final String f29442b = "com.huawei.hff";

    /* renamed from: c, reason: collision with root package name */
    private static HashMap<String, ArrayList<String>> f29443c = new HashMap<>();

    public static String a(Context context, String str, PackageInfo packageInfo) {
        String str2;
        if (context == null || TextUtils.isEmpty(str) || packageInfo == null) {
            aa.c(f29441a, "clientContext or dynamicApkPath or dynamicPackageInfo is null.");
            return null;
        }
        c(context, str, packageInfo);
        if (f29443c.containsKey(str)) {
            ArrayList<String> arrayList = f29443c.get(str);
            if (arrayList != null && !arrayList.isEmpty()) {
                StringBuilder sb2 = new StringBuilder(str);
                Iterator<String> iterator2 = arrayList.iterator2();
                while (iterator2.hasNext()) {
                    String next = iterator2.next();
                    sb2.append(File.pathSeparator);
                    sb2.append(next);
                }
                return sb2.toString();
            }
            str2 = "No split apk path has set.";
        } else {
            str2 = "No split apk required, continue.";
        }
        aa.b(f29441a, str2);
        return str;
    }

    private static String a(Context context, ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            aa.b(f29441a, "No split apk path has set.");
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        Iterator<String> iterator2 = arrayList.iterator2();
        while (iterator2.hasNext()) {
            String next = iterator2.next();
            if (sb2.length() != 0) {
                sb2.append(File.pathSeparator);
            }
            sb2.append(u.b(context, next));
        }
        return sb2.toString();
    }

    public static String b(Context context, String str, PackageInfo packageInfo) {
        String str2 = null;
        if (context == null || TextUtils.isEmpty(str) || packageInfo == null) {
            aa.c(f29441a, "clientContext or dynamicApkPath or dynamicPackageInfo is null.");
            return null;
        }
        c(context, str, packageInfo);
        String a10 = ab.a(context, str, u.a(context, str), packageInfo);
        packageInfo.applicationInfo.nativeLibraryDir = a10;
        if (!f29443c.containsKey(str)) {
            aa.b(f29441a, "No split apk required, continue.");
            return a10;
        }
        ArrayList<String> arrayList = f29443c.get(str);
        if (arrayList == null || arrayList.isEmpty()) {
            aa.b(f29441a, "No split apk path has set.");
        } else {
            StringBuilder sb2 = new StringBuilder();
            Iterator<String> iterator2 = arrayList.iterator2();
            while (iterator2.hasNext()) {
                String next = iterator2.next();
                if (sb2.length() != 0) {
                    sb2.append(File.pathSeparator);
                }
                sb2.append(u.b(context, next));
            }
            str2 = sb2.toString();
        }
        if (TextUtils.isEmpty(a10)) {
            return str2;
        }
        if (TextUtils.isEmpty(str2)) {
            return a10;
        }
        return a10 + File.pathSeparator + str2;
    }

    private static void c(Context context, String str, PackageInfo packageInfo) {
        if (f29443c.containsKey(str)) {
            aa.b(f29441a, "HFF split info for dynamicApkPath has set.");
            return;
        }
        new n();
        Set<m> a10 = n.a(context, packageInfo.applicationInfo, "com.huawei.hff");
        if (a10.isEmpty()) {
            aa.b(f29441a, "No HFF split path need to add to classloader.");
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<m> iterator2 = a10.iterator2();
        while (iterator2.hasNext()) {
            arrayList.add(iterator2.next().f29453a.getAbsolutePath());
        }
        f29443c.put(str, arrayList);
    }
}
