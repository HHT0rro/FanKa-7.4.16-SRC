package com.huawei.quickcard.base.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import androidx.annotation.NonNull;
import com.huawei.quickcard.base.bi.HostPackageInfo;
import com.huawei.quickcard.base.log.CardLogUtils;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class QuickReportUtils {

    /* renamed from: a, reason: collision with root package name */
    private static final String f33425a = "QuickReportUtils";

    /* renamed from: b, reason: collision with root package name */
    private static volatile HostPackageInfo f33426b;

    private static HostPackageInfo a(@NonNull Context context) {
        if (f33426b == null) {
            synchronized (HostPackageInfo.class) {
                if (f33426b == null) {
                    HostPackageInfo hostPackageInfo = new HostPackageInfo();
                    try {
                        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 16384);
                        hostPackageInfo.setPkgName(packageInfo.packageName);
                        hostPackageInfo.setPkgVer(packageInfo.versionName);
                        hostPackageInfo.setPkgVerCode(packageInfo.versionCode);
                    } catch (Exception e2) {
                        CardLogUtils.e(f33425a, "get pkg info exception:" + ((Object) e2));
                    }
                    f33426b = hostPackageInfo;
                }
            }
        }
        return f33426b;
    }

    public static String formatTime(long j10) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'Z", Locale.ENGLISH).format(Long.valueOf(j10));
        } catch (Exception unused) {
            return "";
        }
    }

    public static int getHostVersionCode(@NonNull Context context) {
        return a(context).getPkgVerCode();
    }

    public static String getPackageName(@NonNull Context context) {
        return a(context).getPkgName();
    }

    public static String getPackageVer(Context context) {
        return a(context).getPkgVer();
    }
}
