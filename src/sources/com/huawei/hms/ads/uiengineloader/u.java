package com.huawei.hms.ads.uiengineloader;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class u {

    /* renamed from: a, reason: collision with root package name */
    private static final String f29490a = "u";

    /* renamed from: b, reason: collision with root package name */
    private static final String f29491b = "lib";

    /* renamed from: c, reason: collision with root package name */
    private static final String f29492c = "!";

    /* renamed from: d, reason: collision with root package name */
    private static final String f29493d = "armeabi-v7a";

    /* renamed from: e, reason: collision with root package name */
    private static final String f29494e = "armeabi";

    /* renamed from: f, reason: collision with root package name */
    private static final Pattern f29495f = Pattern.compile("lib/([^/]+)/(.*\\.so)$");

    public static String a(Context context, String str) {
        Iterator<String> iterator2 = b(context).iterator2();
        while (iterator2.hasNext()) {
            String next = iterator2.next();
            StringBuilder sb2 = new StringBuilder();
            String str2 = File.separator;
            sb2.append(str.substring(0, str.lastIndexOf(str2)));
            sb2.append(str2);
            sb2.append(next);
            String sb3 = sb2.toString();
            if (new File(sb3).exists()) {
                aa.b(f29490a, "The so has been unzipped, abi:".concat(String.valueOf(next)));
                return sb3;
            }
        }
        return b(context, str);
    }

    private static boolean a(Context context) {
        boolean z10 = false;
        if (context == null) {
            aa.d(f29490a, "Null context, please check it.");
            return false;
        }
        Context applicationContext = context.getApplicationContext() == null ? context : context.getApplicationContext();
        if (Build.VERSION.SDK_INT >= 23) {
            return Process.is64Bit();
        }
        try {
            return applicationContext.getPackageManager().getApplicationInfo(applicationContext.getPackageName(), 128).nativeLibraryDir.contains("64");
        } catch (PackageManager.NameNotFoundException unused) {
            String str = f29490a;
            aa.d(str, "Get application info failed: name not found, try to get baseContext.");
            if (context instanceof ContextWrapper) {
                Context baseContext = ((ContextWrapper) context).getBaseContext();
                if (baseContext == null) {
                    aa.c(str, "Get baseContext failed: null. Return default: is64-bit.");
                    return true;
                }
                try {
                    return baseContext.getPackageManager().getApplicationInfo(baseContext.getPackageName(), 128).nativeLibraryDir.contains("64");
                } catch (PackageManager.NameNotFoundException unused2) {
                    aa.d(f29490a, "Get baseContext application info failed: name not found");
                    z10 = true;
                    return z10;
                }
            }
            return z10;
        }
    }

    private static boolean a(File file, String str) {
        try {
            Enumeration<? extends ZipEntry> entries = new ZipFile(file).entries();
            while (entries.hasMoreElements()) {
                String name = entries.nextElement().getName();
                if (name.contains("../")) {
                    aa.c(f29490a, "Unsafe zip name!");
                    return false;
                }
                Matcher matcher = f29495f.matcher(name);
                if (matcher.matches()) {
                    String group = matcher.group(1);
                    if (TextUtils.equals(str, group)) {
                        aa.b(f29490a, "abiName:" + group + " matched.");
                        return true;
                    }
                }
            }
        } catch (Exception e2) {
            aa.c(f29490a, "isApkContainPrefAbi exception:" + e2.getClass().getSimpleName());
        }
        return false;
    }

    public static String b(Context context, String str) {
        if (Build.VERSION.SDK_INT > 23) {
            Iterator<String> iterator2 = b(context).iterator2();
            while (iterator2.hasNext()) {
                String next = iterator2.next();
                if (a(new File(str), next)) {
                    aa.b(f29490a, "use the preferred abi:".concat(String.valueOf(next)));
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str);
                    sb2.append(f29492c);
                    String str2 = File.separator;
                    sb2.append(str2);
                    sb2.append("lib");
                    sb2.append(str2);
                    sb2.append(next);
                    return sb2.toString();
                }
            }
        }
        aa.c(f29490a, "cannot get a valid native path, return null.");
        return null;
    }

    private static ArrayList<String> b(Context context) {
        ArrayList<String> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, a(context) ? Build.SUPPORTED_64_BIT_ABIS : Build.SUPPORTED_32_BIT_ABIS);
        return arrayList;
    }
}
