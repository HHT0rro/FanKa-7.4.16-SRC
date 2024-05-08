package kc;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.xiaomi.push.k0;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f50801a = {"com.mi.globalbrowser", "com.android.browser"};

    /* renamed from: b, reason: collision with root package name */
    public static String f50802b = null;

    public static int a(Context context, String str) {
        ApplicationInfo applicationInfo;
        if (str.equals(context.getPackageName())) {
            applicationInfo = context.getApplicationInfo();
        } else {
            try {
                applicationInfo = context.getPackageManager().getApplicationInfo(str, 0);
            } catch (PackageManager.NameNotFoundException unused) {
                fc.c.i("not found app info " + str);
                applicationInfo = null;
            }
        }
        if (applicationInfo == null) {
            return 0;
        }
        int i10 = applicationInfo.icon;
        return i10 == 0 ? applicationInfo.logo : i10;
    }

    public static String b(Notification notification) {
        Object d10;
        try {
            Bundle bundle = notification.extras;
            r0 = bundle != null ? bundle.getString(HiAnalyticsConstant.BI_KEY_TARGET_PACKAGE) : null;
            return (!TextUtils.isEmpty(r0) || (d10 = k0.d(notification, "extraNotification")) == null) ? r0 : (String) k0.e(d10, "getTargetPkg", new Object[0]);
        } catch (Exception unused) {
            return r0;
        }
    }

    public static void c(Notification notification, String str) {
        try {
            Bundle bundle = notification.extras;
            if (bundle != null) {
                bundle.putString(HiAnalyticsConstant.BI_KEY_TARGET_PACKAGE, str);
            }
            Object d10 = k0.d(notification, "extraNotification");
            if (d10 != null) {
                k0.e(d10, "setTargetPkg", str);
            }
        } catch (Exception unused) {
        }
    }

    public static void d(Context context, Intent intent) {
        String str;
        int i10 = -1;
        while (true) {
            str = i10 < 0 ? f50802b : f50801a[i10];
            if (!TextUtils.isEmpty(str)) {
                intent.setPackage(str);
                try {
                    List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
                    if (queryIntentActivities != null && queryIntentActivities.size() > 0) {
                        break;
                    }
                } catch (Exception e2) {
                    fc.c.i("not found xm browser:" + ((Object) e2));
                }
            }
            i10++;
            if (i10 >= f50801a.length) {
                str = null;
                break;
            }
        }
        intent.setPackage(str);
        f50802b = str;
    }

    public static boolean e(Context context) {
        return context != null && "com.xiaomi.xmsf".equals(context.getPackageName());
    }
}
