package com.huawei.openalliance.ad.utils;

import android.app.UiModeManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import com.huawei.hms.ads.ea;
import com.huawei.hms.ads.fr;
import com.huawei.hms.ads.gl;
import com.huawei.openalliance.ad.constant.cn;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.UUID;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class v {
    private static final String Code = "HiAdTools";
    private static final byte[] I = new byte[0];
    private static String V;

    public static String B() {
        return UUID.randomUUID().toString();
    }

    public static boolean B(Context context) {
        return TextUtils.equals(e.I(context), Z(context));
    }

    public static boolean C() {
        return an.I(com.huawei.openalliance.ad.constant.u.bA) && an.Code(com.huawei.openalliance.ad.constant.u.bA, com.huawei.openalliance.ad.constant.u.bB, null);
    }

    public static boolean C(Context context) {
        if (context == null || Build.VERSION.SDK_INT < 29) {
            return false;
        }
        Object systemService = context.getSystemService("uimode");
        return (systemService instanceof UiModeManager) && ((UiModeManager) systemService).getNightMode() == 2;
    }

    public static int Code(Context context, float f10) {
        if (context == null || f10 <= 0.0f) {
            return 0;
        }
        return (int) ((f10 / context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static long Code() {
        return System.currentTimeMillis();
    }

    public static SimpleDateFormat Code(String str) {
        try {
            return new SimpleDateFormat(str, Locale.ENGLISH);
        } catch (Throwable unused) {
            return new SimpleDateFormat(str);
        }
    }

    public static boolean Code(Context context) {
        return S() && h(context);
    }

    public static boolean Code(Context context, Uri uri) {
        if (context == null || uri == null) {
            return false;
        }
        if (!ea.B(context)) {
            return true;
        }
        PackageManager packageManager = context.getPackageManager();
        ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(uri.getAuthority(), 0);
        if (resolveContentProvider == null) {
            gl.Z(Code, "Invalid param");
            return false;
        }
        ApplicationInfo applicationInfo = resolveContentProvider.applicationInfo;
        if (applicationInfo == null) {
            return false;
        }
        String str = applicationInfo.packageName;
        gl.V(Code, "Target provider service's package name is : " + str);
        if (str == null) {
            return false;
        }
        boolean z10 = packageManager.checkSignatures(context.getPackageName(), str) == 0 || (applicationInfo.flags & 1) == 1;
        if (!z10 && !ea.B(context)) {
            String B = e.B(context, str);
            boolean isEmpty = TextUtils.isEmpty(B);
            gl.V(Code, "is sign empty: %s", Boolean.valueOf(isEmpty));
            if (!isEmpty) {
                return cn.Code(context, str, B);
            }
        }
        return z10;
    }

    public static boolean Code(Context context, String str) {
        if (context == null) {
            gl.I(Code, "processWhyEvent context is null, return");
            return false;
        }
        String str2 = com.huawei.openalliance.ad.constant.u.al;
        if (com.huawei.openalliance.ad.constant.u.al.equalsIgnoreCase(str) && !B(context)) {
            str = com.huawei.openalliance.ad.constant.u.am + context.getPackageName();
        }
        if (!au.Code(str)) {
            gl.Code(Code, "processWhyEvent url = %s", bc.Code(str));
            return au.B(str) ? V(context, str) : I(context, str);
        }
        if (!B(context)) {
            str2 = com.huawei.openalliance.ad.constant.u.am + context.getPackageName();
        }
        gl.Code(Code, "processWhyEvent cloud download url is empty, use default!");
        return I(context, str2);
    }

    public static boolean Code(int[] iArr, int i10) {
        return iArr != null && iArr.length == i10;
    }

    public static boolean D(Context context) {
        if (context == null) {
            return false;
        }
        Integer a10 = a(context);
        if (a10 != null && a10.intValue() >= 30462300) {
            return true;
        }
        gl.V(Code, "hms version is too low to support query by type.");
        return false;
    }

    public static boolean F(Context context) {
        if (context == null) {
            return false;
        }
        Integer a10 = a(context);
        if (a10 != null && a10.intValue() >= 30456100) {
            return true;
        }
        gl.V(Code, "hms version is too low to support sdkType.");
        return false;
    }

    public static int I(Context context, float f10) {
        if (context == null || f10 <= 0.0f) {
            return 0;
        }
        return (int) ((f10 / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static boolean I() {
        try {
            Class.forName(com.huawei.openalliance.ad.constant.u.aB);
            return true;
        } catch (Throwable unused) {
            gl.I(Code, "inner pps core service not available");
            return false;
        }
    }

    public static boolean I(Context context) {
        if (I()) {
            return true;
        }
        int Z = e.Z(context, e.I(context));
        gl.V(Code, "isSupportSetAppInfo hms ver: " + Z);
        if (Z >= 40004300) {
            return true;
        }
        gl.V(Code, "hms is not installed or hms version is too low, version is: " + Z);
        return false;
    }

    private static boolean I(Context context, String str) {
        String str2;
        if (au.Code(str)) {
            str2 = "openLinkByDeepLink deepLinkUrl is null, return";
        } else {
            try {
                Intent intent = new Intent();
                intent.addFlags(268435456);
                intent.setPackage(B(context) ? e.I(context) : context.getPackageName());
                intent.setData(Uri.parse(str));
                intent.setClipData(com.huawei.openalliance.ad.constant.u.cG);
                context.startActivity(intent);
                return true;
            } catch (Throwable th) {
                str2 = "openLinkByDeepLink " + th.getClass().getSimpleName();
            }
        }
        gl.I(Code, str2);
        return false;
    }

    public static boolean L(Context context) {
        if (context == null) {
            return false;
        }
        Integer a10 = a(context);
        if (a10 != null && a10.intValue() >= 30457100) {
            return true;
        }
        gl.V(Code, "hms version is too low to support v3.");
        return false;
    }

    private static boolean S() {
        return true;
    }

    public static boolean S(Context context) {
        if (context == null) {
            return false;
        }
        Integer a10 = a(context);
        if (a10 != null && a10.intValue() >= 30445100) {
            return true;
        }
        gl.V(Code, "hms version is too low to support switch next install way.");
        return false;
    }

    public static int V(Context context, float f10) {
        if (context != null && f10 > 0.0f) {
            return (int) ((f10 * context.getResources().getDisplayMetrics().density) + 0.5f);
        }
        return 0;
    }

    public static long V() {
        long maxMemory = Runtime.getRuntime().maxMemory() - (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
        if (gl.Code()) {
            gl.Code(Code, "unUsedMemory is: %s", String.valueOf(maxMemory));
        }
        return maxMemory;
    }

    public static void V(String str) {
        synchronized (I) {
            V = str;
        }
    }

    public static boolean V(Context context) {
        int Z = e.Z(context, e.I(context));
        gl.V(Code, "isSupportHmsAdsService hms ver: " + Z);
        if (Z >= 40000300) {
            return true;
        }
        gl.V(Code, "hms is not installed or hms version is too low, version is: " + Z);
        return false;
    }

    private static boolean V(Context context, String str) {
        String str2;
        if (au.Code(str)) {
            str2 = "openLinkInBrowser url is null, return";
        } else {
            try {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setData(Uri.parse(str));
                intent.setFlags(268468224);
                intent.setClipData(com.huawei.openalliance.ad.constant.u.cG);
                context.startActivity(intent);
                return true;
            } catch (Throwable th) {
                str2 = "openLinkInBrowser " + th.getClass().getSimpleName();
            }
        }
        gl.I(Code, str2);
        return false;
    }

    public static int Z(Context context, float f10) {
        if (context != null && f10 > 0.0f) {
            return (int) ((f10 * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
        }
        return 0;
    }

    public static String Z() {
        String str;
        synchronized (I) {
            str = V;
        }
        return str;
    }

    public static String Z(Context context) {
        String Z = Z();
        gl.V(Code, "current connected service pkg: " + Z);
        if (!TextUtils.isEmpty(Z)) {
            return Z;
        }
        int t2 = fr.Code(context).t();
        if (((t2 != 0 && t2 != 2) || !V(context)) && I()) {
            return context.getPackageName();
        }
        return e.I(context);
    }

    public static Integer a(Context context) {
        Integer Code2 = ah.Code(context, e.I(context.getApplicationContext()), "ppskit_ver_code");
        if (gl.Code()) {
            gl.Code(Code, "ppsKitVerCode:%s", Code2);
        }
        return Code2;
    }

    public static Integer b(Context context) {
        Integer Code2 = ah.Code(context, context.getApplicationContext().getPackageName(), "hw_ads_sdk_type");
        if (gl.Code()) {
            gl.Code(Code, "sdkType:%s", Code2);
        }
        return Code2;
    }

    public static float c(Context context) {
        Configuration configuration;
        if (context == null) {
            return -1.0f;
        }
        float i10 = i(context);
        if (i10 > 0.0f) {
            return i10;
        }
        Resources resources = context.getResources();
        if (resources == null || (configuration = resources.getConfiguration()) == null) {
            return -1.0f;
        }
        return configuration.fontScale;
    }

    public static boolean d(Context context) {
        return c(context) >= 1.75f;
    }

    public static boolean e(Context context) {
        return c(context) >= 1.3f;
    }

    public static int f(Context context) {
        try {
            int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
            if (identifier > 0) {
                return context.getResources().getDimensionPixelSize(identifier);
            }
            return 0;
        } catch (Throwable th) {
            gl.I(Code, "getStatusBarHeight err: %s", th.getClass().getSimpleName());
            return 0;
        }
    }

    public static boolean g(Context context) {
        return c.I(context) >= 600;
    }

    private static boolean h(Context context) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(com.huawei.openalliance.ad.constant.u.ap);
        String str = "ads-base";
        sb2.append("ads-base");
        String Code2 = ay.Code(context, sb2.toString());
        if (TextUtils.isEmpty(Code2)) {
            str = "ads-base-inner";
            Code2 = ay.Code(context, com.huawei.openalliance.ad.constant.u.ap + str);
        }
        if (!TextUtils.isEmpty(Code2)) {
            Code2 = Code2.replaceAll(str + com.huawei.openalliance.ad.constant.u.bD, "");
        }
        if (TextUtils.equals(Code2, "13.4.62.302") || TextUtils.isEmpty(Code2)) {
            return true;
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("current sdk module version 13.4.62.302 is not compatible with base sdk version(");
        sb3.append(Code2);
        sb3.append("), please update to base version ");
        sb3.append(Code2);
        return false;
    }

    private static float i(Context context) {
        try {
            return Settings.System.getFloat(context.getContentResolver(), "font_scale", -1.0f);
        } catch (Throwable th) {
            gl.I(Code, "get font err: %s", th.getClass().getSimpleName());
            return -1.0f;
        }
    }
}
