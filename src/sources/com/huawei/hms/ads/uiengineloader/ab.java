package com.huawei.hms.ads.uiengineloader;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import com.android.internal.content.NativeLibraryHelper;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class ab {

    /* renamed from: a, reason: collision with root package name */
    private static final String f29419a = "_multiKitLoadNative";

    /* renamed from: b, reason: collision with root package name */
    private static final String f29420b = "com.huawei.hms.runtimekit.container.kitsdk.KitContext";

    /* renamed from: c, reason: collision with root package name */
    private static ThreadPoolExecutor f29421c = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue());

    private static String a(Context context) throws IOException {
        if (Build.VERSION.SDK_INT >= 24) {
            context = context.createDeviceProtectedStorageContext();
        }
        return context.getFilesDir().getCanonicalPath() + File.separator + "modules";
    }

    public static String a(Context context, String str, String str2, PackageInfo packageInfo) {
        aa.b(f29419a, " generaNewNativePath");
        if (!b(context)) {
            return str2;
        }
        if (!TextUtils.isEmpty(str2) && str2.contains(File.separator)) {
            return b(context, str, str2, packageInfo);
        }
        aa.b(f29419a, "nativePath is empty or error");
        return str2;
    }

    private static void a(final String str, final int i10, final boolean z10) {
        f29421c.execute(new Runnable() { // from class: com.huawei.hms.ads.uiengineloader.ab.1
            @Override // java.lang.Runnable
            public final void run() {
                File file = new File(String.this);
                String num = Integer.toString(i10);
                if (ab.c(file)) {
                    for (File file2 : file.listFiles()) {
                        if (!z10 || !file2.getPath().contains(num)) {
                            StringBuilder sb2 = ab.d(file2) ? new StringBuilder(" delete success : ") : new StringBuilder(" delete failed : ");
                            sb2.append(file2.getName());
                            aa.b(ab.f29419a, sb2.toString());
                        }
                    }
                }
            }
        });
    }

    private static void a(ZipFile zipFile, String str, PackageInfo packageInfo, boolean z10) {
        int i10;
        ae.a(zipFile);
        try {
            if (TextUtils.isEmpty(str) || (i10 = packageInfo.versionCode) <= 0) {
                return;
            }
            a(str, i10, z10);
        } catch (Exception unused) {
            aa.c(f29419a, "IOException:");
        }
    }

    private static String b(Context context, String str, String str2, PackageInfo packageInfo) {
        String str3;
        ZipFile zipFile = null;
        try {
            try {
                StringBuilder sb2 = new StringBuilder();
                if (Build.VERSION.SDK_INT >= 24) {
                    context = context.createDeviceProtectedStorageContext();
                }
                StringBuilder sb3 = new StringBuilder();
                sb3.append(context.getFilesDir().getCanonicalPath());
                String str4 = File.separator;
                sb3.append(str4);
                sb3.append("modules");
                sb2.append(sb3.toString());
                sb2.append(str4);
                sb2.append(packageInfo.packageName);
                str3 = sb2.toString();
                try {
                    String substring = str2.substring(str2.lastIndexOf(str4) + 1);
                    ZipFile zipFile2 = new ZipFile(str);
                    try {
                        Enumeration<? extends ZipEntry> entries = zipFile2.entries();
                        HashSet hashSet = new HashSet();
                        x.a(entries, hashSet, substring);
                        if (hashSet.size() <= 0) {
                            aa.b(f29419a, "native is empty");
                            a(zipFile2, str3, packageInfo, true);
                            return str2;
                        }
                        String str5 = str3 + str4 + packageInfo.versionCode + str4 + NativeLibraryHelper.LIB_DIR_NAME + str4 + substring;
                        if (new File(str5).exists() || x.a(zipFile2, hashSet, str5) == 0) {
                            a(zipFile2, str3, packageInfo, true);
                            return str5;
                        }
                        aa.b(f29419a, "the apk decompress fail");
                        a(zipFile2, str3, packageInfo, false);
                        return str2;
                    } catch (Exception unused) {
                        zipFile = zipFile2;
                        aa.c(f29419a, "catch IOException");
                        a(zipFile, str3, packageInfo, true);
                        return str2;
                    } catch (Throwable th) {
                        th = th;
                        zipFile = zipFile2;
                        a(zipFile, str3, packageInfo, true);
                        throw th;
                    }
                } catch (Exception unused2) {
                }
            } catch (Exception unused3) {
                str3 = null;
            } catch (Throwable th2) {
                th = th2;
                str3 = null;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private static boolean b(Context context) {
        try {
            return context.getClassLoader().loadClass(f29420b) != null;
        } catch (ClassNotFoundException unused) {
            aa.b(f29419a, "The cp is not hms kit.");
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean c(File file) {
        return file.exists() && file.isDirectory() && file.listFiles() != null && file.listFiles().length > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(File file) {
        boolean z10;
        boolean z11 = false;
        if (c(file)) {
            z10 = true;
            for (File file2 : file.listFiles()) {
                z10 = z10 && d(file2);
            }
        } else {
            z10 = true;
        }
        if (!z10) {
            return z10;
        }
        if (z10 && file.delete()) {
            z11 = true;
        }
        return z11;
    }
}
