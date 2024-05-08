package com.huawei.hms.ads.uiengineloader;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.text.TextUtils;
import java.io.File;
import java.util.HashSet;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class i implements f {

    /* renamed from: a, reason: collision with root package name */
    private static final String f29445a = "HMSClassLoaderStrategy";

    /* renamed from: b, reason: collision with root package name */
    private static final String f29446b = "com.huawei.hwid";

    /* renamed from: c, reason: collision with root package name */
    private static final String f29447c = "com.huawei.hms.core.service.HMSCoreService";

    /* renamed from: d, reason: collision with root package name */
    private static final String f29448d = "lib";

    /* renamed from: e, reason: collision with root package name */
    private static final String f29449e = "arm64";

    /* renamed from: f, reason: collision with root package name */
    private static final HashSet<String> f29450f = new HashSet<String>() { // from class: com.huawei.hms.ads.uiengineloader.i.1
        {
            add("com.huawei.hwid");
            add("com.huawei.hms");
            add("com.huawei.hwid.tv");
        }
    };

    public static boolean a(Context context) {
        String str;
        String packageName = context.getPackageName();
        aa.b(f29445a, "The pkg name of clientContext is:".concat(String.valueOf(packageName)));
        if (!a(context, packageName)) {
            if (context instanceof ContextWrapper) {
                Context baseContext = ((ContextWrapper) context).getBaseContext();
                String packageName2 = baseContext.getPackageName();
                aa.b(f29445a, "The pkg name of baseContext is:".concat(String.valueOf(packageName2)));
                str = a(baseContext, packageName2) ? "The base context is HMS context, cp is HMS." : "The context is HMS context, cp is HMS.";
            }
            aa.b(f29445a, "The cp is not HMS.");
            return false;
        }
        aa.b(f29445a, str);
        return true;
    }

    private static boolean a(Context context, String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            aa.b(f29445a, "Get pkg name failed: null.");
            return false;
        }
        if (!f29450f.contains(str)) {
            if (!str.startsWith("com.huawei.hwid")) {
                aa.b(f29445a, "The pkg does not start with HMS prefix.");
                return false;
            }
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4);
                if (packageInfo == null) {
                    aa.c(f29445a, "Get callPackage packageInfo failed: null.");
                    return false;
                }
                ServiceInfo[] serviceInfoArr = packageInfo.services;
                if (serviceInfoArr == null) {
                    aa.c(f29445a, "Get service Info failed: null.");
                    return false;
                }
                for (ServiceInfo serviceInfo : serviceInfoArr) {
                    if (TextUtils.equals(serviceInfo.name, f29447c)) {
                        str2 = "Check Service name: The calling package is HMS.";
                    }
                }
                aa.b(f29445a, "The calling package is not HMS.");
                return false;
            } catch (PackageManager.NameNotFoundException unused) {
                aa.c(f29445a, "Get callPackage packageInfo NameNotFoundException.");
                return false;
            }
        }
        str2 = "The pkgName belongs to HMS pkg names, the cp is HMS.";
        aa.b(f29445a, str2);
        return true;
    }

    @Override // com.huawei.hms.ads.uiengineloader.f
    public final ClassLoader a(Context context, String str, int i10, PackageInfo packageInfo) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(new File(context.getPackageResourcePath()).getParent());
        String str2 = File.separator;
        sb2.append(str2);
        sb2.append("lib");
        sb2.append(str2);
        sb2.append(f29449e);
        String sb3 = sb2.toString();
        aa.b(f29445a, "The api version is:" + Build.VERSION.SDK_INT + ", callingPkg is HMS, use the hmsNativePath.");
        return new com.huawei.hms.ads.dynamicloader.d(str, sb3, context.getClassLoader());
    }
}
