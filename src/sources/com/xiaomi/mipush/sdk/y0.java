package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.mlsdk.common.internal.client.event.MonitorResult;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class y0 {

    /* renamed from: a, reason: collision with root package name */
    public static int f47096a = -1;

    public static ah a(Context context) {
        try {
            return (context.getPackageManager().getServiceInfo(new ComponentName("com.huawei.hwid", "com.huawei.hms.core.service.HMSCoreService"), 128) == null || !b()) ? ah.OTHER : ah.HUAWEI;
        } catch (Exception unused) {
            return ah.OTHER;
        }
    }

    public static boolean b() {
        try {
            String str = (String) com.xiaomi.push.k0.g("android.os.SystemProperties", MonitorConstants.CONNECT_TYPE_GET, "ro.build.hw_emui_api_level", "");
            if (!TextUtils.isEmpty(str)) {
                if (Integer.parseInt(str) >= 9) {
                    return true;
                }
            }
        } catch (Exception e2) {
            fc.c.k(e2);
        }
        return false;
    }

    public static boolean c(Context context) {
        Object e2 = com.xiaomi.push.k0.e(com.xiaomi.push.k0.g("com.google.android.gms.common.GoogleApiAvailability", "getInstance", new Object[0]), "isGooglePlayServicesAvailable", context);
        Object f10 = com.xiaomi.push.k0.f("com.google.android.gms.common.ConnectionResult", MonitorResult.SUCCESS);
        if (f10 == null || !(f10 instanceof Integer)) {
            fc.c.m("google service is not avaliable");
            f47096a = 0;
            return false;
        }
        int intValue = ((Integer) Integer.class.cast(f10)).intValue();
        if (e2 != null) {
            if (e2 instanceof Integer) {
                f47096a = ((Integer) Integer.class.cast(e2)).intValue() == intValue ? 1 : 0;
            } else {
                f47096a = 0;
                fc.c.m("google service is not avaliable");
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("is google service can be used");
        sb2.append(f47096a > 0);
        fc.c.m(sb2.toString());
        return f47096a > 0;
    }

    public static boolean d(Context context) {
        boolean z10 = false;
        Object g3 = com.xiaomi.push.k0.g("com.xiaomi.assemble.control.COSPushManager", "isSupportPush", context);
        if (g3 != null && (g3 instanceof Boolean)) {
            z10 = ((Boolean) Boolean.class.cast(g3)).booleanValue();
        }
        fc.c.m("color os push  is avaliable ? :" + z10);
        return z10;
    }

    public static boolean e(Context context) {
        boolean z10 = false;
        Object g3 = com.xiaomi.push.k0.g("com.xiaomi.assemble.control.FTOSPushManager", "isSupportPush", context);
        if (g3 != null && (g3 instanceof Boolean)) {
            z10 = ((Boolean) Boolean.class.cast(g3)).booleanValue();
        }
        fc.c.m("fun touch os push  is avaliable ? :" + z10);
        return z10;
    }
}
