package com.nirvana.tools.core;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.u;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class AppUtils {
    private static String APP_NAME;
    private static String APP_SIGNATURE;
    private static String APP_VERSION_NAME;
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static String PACKAGE_NAME;

    public static long date2ms(String str) {
        try {
            return new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss").parse(str).getTime();
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static int dp2px(Context context, float f10) {
        try {
            return (int) ((f10 * context.getResources().getDisplayMetrics().density) + 0.5f);
        } catch (Exception unused) {
            return (int) f10;
        }
    }

    public static int getAnimResID(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        return context.getResources().getIdentifier(str, "anim", context.getPackageName());
    }

    public static synchronized String getAppName(Context context) {
        String str;
        synchronized (AppUtils.class) {
            if (APP_NAME == null) {
                ApplicationInfo applicationInfo = context.getApplicationInfo();
                APP_NAME = applicationInfo.labelRes == 0 ? applicationInfo.nonLocalizedLabel.toString() : context.getResources().getString(applicationInfo.labelRes);
            }
            str = APP_NAME;
        }
        return str;
    }

    public static String getDeviceName() {
        return Build.BRAND + u.bD + Build.MODEL;
    }

    public static String getHstype() {
        String str = Build.MODEL;
        return str.length() > 20 ? str.substring(0, 20) : str;
    }

    public static synchronized String getPackageName(Context context) {
        String str;
        synchronized (AppUtils.class) {
            setupAppInfo(context);
            str = PACKAGE_NAME;
        }
        return str;
    }

    public static int getResID(Context context, String str, String str2) {
        return context.getResources().getIdentifier(str, str2, context.getPackageName());
    }

    public static synchronized String getSign(Context context) {
        String str;
        synchronized (AppUtils.class) {
            try {
                if (APP_SIGNATURE == null) {
                    APP_SIGNATURE = hexdigest(context.getPackageManager().getPackageInfo(getPackageName(context), 64).signatures[0].toByteArray());
                }
                str = APP_SIGNATURE;
            } catch (Exception e2) {
                e2.printStackTrace();
                return "";
            }
        }
        return str;
    }

    public static int getSystemAPILevel() {
        return Build.VERSION.SDK_INT;
    }

    public static String getSystemVersion() {
        return Build.VERSION.RELEASE;
    }

    public static String getTime() {
        return new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss").format(new Date(System.currentTimeMillis()));
    }

    public static synchronized String getVersionName(Context context) {
        String str;
        synchronized (AppUtils.class) {
            setupAppInfo(context);
            str = APP_VERSION_NAME;
        }
        return str;
    }

    public static String hexdigest(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            byte[] digest = messageDigest.digest();
            char[] cArr = new char[32];
            int i10 = 0;
            for (int i11 = 0; i11 < 16; i11++) {
                byte b4 = digest[i11];
                int i12 = i10 + 1;
                char[] cArr2 = HEX_DIGITS;
                cArr[i10] = cArr2[(b4 >>> 4) & 15];
                i10 = i12 + 1;
                cArr[i12] = cArr2[b4 & 15];
            }
            return new String(cArr);
        } catch (Exception unused) {
            return null;
        }
    }

    private static void setupAppInfo(Context context) {
        if (PACKAGE_NAME == null || APP_VERSION_NAME == null) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                APP_VERSION_NAME = packageInfo.versionName;
                PACKAGE_NAME = packageInfo.packageName;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static int sp2px(Context context, float f10) {
        try {
            return (int) ((f10 * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
        } catch (Exception unused) {
            return (int) f10;
        }
    }
}
