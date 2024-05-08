package com.xiaomi.push;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class w2 extends a3 {

    /* renamed from: d, reason: collision with root package name */
    public String f48452d;

    public w2(Context context, int i10, String str) {
        super(context, i10);
        this.f48452d = str;
    }

    @Override // com.xiaomi.push.n.a
    public int a() {
        return 24;
    }

    @Override // com.xiaomi.push.a3
    public hs b() {
        return hs.AppIsInstalled;
    }

    @Override // com.xiaomi.push.a3
    public String c() {
        String str;
        String[] k10 = k();
        if (k10 == null || k10.length <= 0) {
            return null;
        }
        PackageManager packageManager = this.f47110c.getPackageManager();
        StringBuilder sb2 = new StringBuilder();
        for (String str2 : k10) {
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(str2, 16384);
                if (packageInfo != null) {
                    if (sb2.length() > 0) {
                        sb2.append(";");
                    }
                    try {
                        str = packageManager.getInstallerPackageName(str2);
                    } catch (IllegalArgumentException unused) {
                        str = null;
                    }
                    if (TextUtils.isEmpty(str)) {
                        str = "null";
                    }
                    sb2.append(packageInfo.applicationInfo.loadLabel(packageManager).toString());
                    sb2.append(",");
                    sb2.append(packageInfo.packageName);
                    sb2.append(",");
                    sb2.append(packageInfo.versionName);
                    sb2.append(",");
                    sb2.append(packageInfo.versionCode);
                    sb2.append(",");
                    sb2.append(packageInfo.firstInstallTime);
                    sb2.append(",");
                    sb2.append(packageInfo.lastUpdateTime);
                    sb2.append(",");
                    sb2.append(str);
                }
            } catch (Exception unused2) {
            }
        }
        if (sb2.length() > 0) {
            return sb2.toString();
        }
        return null;
    }

    public final String[] k() {
        if (TextUtils.isEmpty(this.f48452d)) {
            return null;
        }
        String g3 = m0.g(this.f48452d);
        if (TextUtils.isEmpty(g3)) {
            return null;
        }
        return g3.contains(",") ? g3.split(",") : new String[]{g3};
    }
}
