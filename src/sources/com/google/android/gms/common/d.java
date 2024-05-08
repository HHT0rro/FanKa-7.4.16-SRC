package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.UserManager;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import b7.k;
import b7.l;
import com.cupidapp.live.liveshow.beauty.databeauty.UserData;
import com.google.android.gms.common.internal.e0;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    @RecentlyNonNull
    @Deprecated
    public static final int f23519a = 12451000;

    /* renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f23520b = new AtomicBoolean();

    /* renamed from: c, reason: collision with root package name */
    public static final AtomicBoolean f23521c = new AtomicBoolean();

    @RecentlyNonNull
    @Deprecated
    public static int a(@RecentlyNonNull Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            return 0;
        }
    }

    @NonNull
    @Deprecated
    public static String b(@RecentlyNonNull int i10) {
        return ConnectionResult.zza(i10);
    }

    @RecentlyNullable
    public static Context c(@RecentlyNonNull Context context) {
        try {
            return context.createPackageContext("com.google.android.gms", 3);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    @RecentlyNullable
    public static Resources d(@RecentlyNonNull Context context) {
        try {
            return context.getPackageManager().getResourcesForApplication("com.google.android.gms");
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    @RecentlyNonNull
    @Deprecated
    public static int e(@RecentlyNonNull Context context, @RecentlyNonNull int i10) {
        try {
            context.getResources().getString(R$string.common_google_play_services_unknown_issue);
        } catch (Throwable unused) {
        }
        if (!"com.google.android.gms".equals(context.getPackageName()) && !f23521c.get()) {
            int a10 = e0.a(context);
            if (a10 != 0) {
                int i11 = f23519a;
                if (a10 != i11) {
                    StringBuilder sb2 = new StringBuilder(320);
                    sb2.append("The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected ");
                    sb2.append(i11);
                    sb2.append(" but found ");
                    sb2.append(a10);
                    sb2.append(".  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
                    throw new IllegalStateException(sb2.toString());
                }
            } else {
                throw new IllegalStateException("A required meta-data tag in your app's AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
            }
        }
        return i(context, (b7.g.e(context) || b7.g.f(context)) ? false : true, i10);
    }

    @RecentlyNonNull
    @Deprecated
    public static boolean f(@RecentlyNonNull Context context, @RecentlyNonNull int i10) {
        if (i10 == 18) {
            return true;
        }
        if (i10 == 1) {
            return j(context, "com.google.android.gms");
        }
        return false;
    }

    @RecentlyNonNull
    public static boolean g(@RecentlyNonNull Context context) {
        Bundle applicationRestrictions;
        return k.c() && (applicationRestrictions = ((UserManager) com.google.android.gms.common.internal.h.h(context.getSystemService(UserData.NAME))).getApplicationRestrictions(context.getPackageName())) != null && "true".equals(applicationRestrictions.getString("restricted_profile"));
    }

    @RecentlyNonNull
    @Deprecated
    public static boolean h(@RecentlyNonNull int i10) {
        return i10 == 1 || i10 == 2 || i10 == 3 || i10 == 9;
    }

    public static int i(Context context, boolean z10, int i10) {
        com.google.android.gms.common.internal.h.a(i10 >= 0);
        String packageName = context.getPackageName();
        PackageManager packageManager = context.getPackageManager();
        PackageInfo packageInfo = null;
        if (z10) {
            try {
                packageInfo = packageManager.getPackageInfo("com.android.vending", 8256);
            } catch (PackageManager.NameNotFoundException unused) {
                String.valueOf(packageName).concat(" requires the Google Play Store, but it is missing.");
                return 9;
            }
        }
        try {
            PackageInfo packageInfo2 = packageManager.getPackageInfo("com.google.android.gms", 64);
            e.a(context);
            if (!e.c(packageInfo2, true)) {
                String.valueOf(packageName).concat(" requires Google Play services, but their signature is invalid.");
                return 9;
            }
            if (z10 && (!e.c((PackageInfo) com.google.android.gms.common.internal.h.h(packageInfo), true) || !packageInfo.signatures[0].equals(packageInfo2.signatures[0]))) {
                String.valueOf(packageName).concat(" requires Google Play Store, but its signature is invalid.");
                return 9;
            }
            if (l.a(packageInfo2.versionCode) < l.a(i10)) {
                int i11 = packageInfo2.versionCode;
                StringBuilder sb2 = new StringBuilder(String.valueOf(packageName).length() + 82);
                sb2.append("Google Play services out of date for ");
                sb2.append(packageName);
                sb2.append(".  Requires ");
                sb2.append(i10);
                sb2.append(" but found ");
                sb2.append(i11);
                return 2;
            }
            ApplicationInfo applicationInfo = packageInfo2.applicationInfo;
            if (applicationInfo == null) {
                try {
                    applicationInfo = packageManager.getApplicationInfo("com.google.android.gms", 0);
                } catch (PackageManager.NameNotFoundException e2) {
                    Log.wtf("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires Google Play services, but they're missing when getting application info."), e2);
                    return 1;
                }
            }
            return !applicationInfo.enabled ? 3 : 0;
        } catch (PackageManager.NameNotFoundException unused2) {
            String.valueOf(packageName).concat(" requires Google Play services, but they are missing.");
            return 1;
        }
    }

    public static boolean j(Context context, String str) {
        ApplicationInfo applicationInfo;
        boolean equals = str.equals("com.google.android.gms");
        if (k.e()) {
            try {
                Iterator<PackageInstaller.SessionInfo> it = context.getPackageManager().getPackageInstaller().getAllSessions().iterator();
                while (it.hasNext()) {
                    if (str.equals(it.next().getAppPackageName())) {
                        return true;
                    }
                }
            } catch (Exception unused) {
                return false;
            }
        }
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(str, 8192);
        } catch (PackageManager.NameNotFoundException unused2) {
        }
        if (equals) {
            return applicationInfo.enabled;
        }
        return applicationInfo.enabled && !g(context);
    }
}
