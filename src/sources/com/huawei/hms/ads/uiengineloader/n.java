package com.huawei.hms.ads.uiengineloader;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    private static final String f29455a = "n";

    /* renamed from: b, reason: collision with root package name */
    private static final String f29456b = "presplits";

    /* renamed from: c, reason: collision with root package name */
    private static final String f29457c = ",";

    private static HashMap<String, String> a(Context context, String str) {
        PackageInfo packageInfo;
        ApplicationInfo applicationInfo;
        String[] strArr;
        String[] strArr2;
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 128);
            applicationInfo = context.getPackageManager().getApplicationInfo(str, 128);
            strArr = packageInfo.splitNames;
        } catch (PackageManager.NameNotFoundException e2) {
            aa.c(f29455a, "getSourceDir:cannot find the package:" + str + " info." + e2.getClass().getSimpleName());
        }
        if (strArr != null && (strArr2 = applicationInfo.splitSourceDirs) != null) {
            int min = Math.min(strArr.length, strArr2.length);
            for (int i10 = 0; i10 < min; i10++) {
                hashMap.put(packageInfo.splitNames[i10], applicationInfo.splitSourceDirs[i10]);
            }
            return hashMap;
        }
        aa.c(f29455a, "splitNames or splitSourceDirs is null.");
        return hashMap;
    }

    public static Set<m> a(Context context, ApplicationInfo applicationInfo, String str) {
        Bundle bundle;
        HashSet hashSet = new HashSet();
        if (context != null && applicationInfo != null && (bundle = applicationInfo.metaData) != null) {
            String string = bundle.getString(f29456b);
            if (TextUtils.isEmpty(string)) {
                aa.b(f29455a, "No metadata: presplits found.");
                return hashSet;
            }
            String[] split = string.split(",");
            HashMap<String, String> a10 = a(context, str);
            if (split.length != 0 && !a10.isEmpty()) {
                for (String str2 : split) {
                    for (Map.Entry<String, String> entry : a10.entrySet()) {
                        if (str2.equals(entry.getKey())) {
                            hashSet.add(new m(new File(entry.getValue()), entry.getKey()));
                        }
                    }
                }
            }
        }
        return hashSet;
    }

    private static Set<m> b(Context context, String str) {
        ApplicationInfo applicationInfo;
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException e2) {
            aa.d(f29455a, "getMetaSplits:cannot find the package:" + str + "info." + e2.getClass().getSimpleName());
            applicationInfo = null;
        }
        return a(context, applicationInfo, str);
    }
}
