package com.huawei.appgallery.coreservice.api;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import w9.e;
import w9.i;
import w9.m;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class CoreServiceApi {
    @Nullable
    public static AppGalleryInfo getAppGalleryInfo(Context context) {
        String h10 = e.h(context);
        if (TextUtils.isEmpty(h10)) {
            return null;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(h10, 128);
            if (packageInfo != null) {
                return new AppGalleryInfo(packageInfo.versionName, packageInfo.versionCode);
            }
        } catch (PackageManager.NameNotFoundException unused) {
            m.a("CoreServiceApi", "NameNotFoundException ");
        } catch (RuntimeException unused2) {
            m.c("CoreServiceApi", "getPackageInfo RuntimeException");
        }
        return null;
    }

    @Nullable
    public static String getAppGalleryPkg(Context context) {
        return e.h(context);
    }

    public static IConnectionResult getGuideInstallPendingIntent(Context context) {
        return e.k(context);
    }

    @Deprecated
    public static void setAppName(Context context, String str) {
        i.b().c(context, str);
    }

    public static void setHomeCountry(Context context, String str) {
        i.b().e(context, str);
    }
}
