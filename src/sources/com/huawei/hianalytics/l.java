package com.huawei.hianalytics;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.Pair;
import com.huawei.hianalytics.core.log.HiLog;
import com.huawei.hianalytics.log.LogTag;
import com.huawei.hianalytics.util.DeviceUtil;
import com.huawei.hms.ads.jsb.constant.Constant;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.UUID;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class l {
    public static final String lmn = LogTag.get(l.class, new Class[0]);

    public static synchronized String ghi(Context context) {
        String str;
        synchronized (l.class) {
            str = c.klm().lmn.abc;
            if (TextUtils.isEmpty(str)) {
                str = j0.lmn(context, "global_v2", Constant.MAP_KEY_UUID, "");
                if (!TextUtils.isEmpty(str) && str.length() > 32) {
                    String d10 = ua.a.d("HiAnalytics_Sdk_Uuid_Sp_Key", str);
                    if (!TextUtils.isEmpty(d10)) {
                        j0.klm(context, "global_v2", Constant.MAP_KEY_UUID, d10);
                        str = d10;
                    }
                }
                if (TextUtils.isEmpty(str)) {
                    str = UUID.randomUUID().toString().replace("-", "");
                    c.klm().lmn.abc = str;
                    j0.klm(context, "global_v2", Constant.MAP_KEY_UUID, str);
                } else {
                    c.klm().lmn.abc = str;
                }
            }
        }
        return str;
    }

    public static String hij(Context context) {
        String str;
        if (context == null) {
            return "";
        }
        if (Build.VERSION.SDK_INT >= 26) {
            HiLog.d(lmn, "getSerial : is executed.");
            if (!DeviceUtil.checkPermission(context, com.kuaishou.weapon.p0.g.f36117c)) {
                return "";
            }
            try {
                str = Build.getSerial();
            } catch (SecurityException unused) {
                HiLog.e(lmn, "getSerial() Incorrect permissions!");
                str = "";
            }
        } else {
            str = Build.SERIAL;
        }
        return str.equalsIgnoreCase("unknown") ? "" : str;
    }

    public static String ijk(Context context) {
        if (!DeviceUtil.checkPermission(context, com.kuaishou.weapon.p0.g.f36117c)) {
            return "";
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            return telephonyManager != null ? telephonyManager.getDeviceId() : "";
        } catch (SecurityException unused) {
            HiLog.e(lmn, "getDeviceID Incorrect permissions!");
            return "";
        }
    }

    public static Pair<String, String> ikl(Context context) {
        if (Build.VERSION.SDK_INT <= 28 && !DeviceUtil.checkPermission(context, com.kuaishou.weapon.p0.g.f36117c)) {
            HiLog.w(lmn, "getMccAndMnc() Pair value is empty");
            return new Pair<>("", "");
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            return new Pair<>("", "");
        }
        if (telephonyManager.getSimState() != 5) {
            return new Pair<>("", "");
        }
        String networkOperator = telephonyManager.getNetworkOperator();
        if (!TextUtils.isEmpty(networkOperator) && !TextUtils.equals(networkOperator, "null")) {
            if (networkOperator.length() > 3) {
                return new Pair<>(networkOperator.substring(0, 3), networkOperator.substring(3));
            }
            return new Pair<>("", "");
        }
        return new Pair<>("", "");
    }

    public static String klm() {
        Method method;
        String str;
        String str2 = "";
        try {
            if (DeviceUtil.isMagicSix()) {
                method = Class.forName("com.hihonor.android.os.Build").getMethod("getUDID", new Class[0]);
            } else {
                method = Class.forName("com.huawei.android.os.BuildEx").getMethod("getUDID", new Class[0]);
            }
            str = (String) method.invoke(null, new Object[0]);
        } catch (AndroidRuntimeException unused) {
        } catch (ClassNotFoundException unused2) {
        } catch (IllegalAccessException unused3) {
        } catch (IllegalArgumentException unused4) {
        } catch (NoSuchMethodException unused5) {
        } catch (InvocationTargetException unused6) {
        } catch (Exception e2) {
            e = e2;
        }
        try {
            HiLog.sw(lmn, "getUDID success.");
            return str;
        } catch (AndroidRuntimeException unused7) {
            str2 = str;
            HiLog.e(lmn, "getUDID getudid failed, RuntimeException is AndroidRuntimeException");
            return str2;
        } catch (ClassNotFoundException unused8) {
            str2 = str;
            HiLog.e(lmn, "getUDID method invoke failed");
            return str2;
        } catch (IllegalAccessException unused9) {
            str2 = str;
            HiLog.e(lmn, "getUDID method invoke failed : Illegal AccessException");
            return str2;
        } catch (IllegalArgumentException unused10) {
            str2 = str;
            HiLog.e(lmn, "getUDID method invoke failed : Illegal ArgumentException");
            return str2;
        } catch (NoSuchMethodException unused11) {
            str2 = str;
            HiLog.e(lmn, "getUDID method invoke failed : NoSuchMethodException");
            return str2;
        } catch (InvocationTargetException unused12) {
            str2 = str;
            HiLog.e(lmn, "getUDID method invoke failed : InvocationTargetException");
            return str2;
        } catch (Exception e10) {
            e = e10;
            str2 = str;
            String str3 = lmn;
            StringBuilder b4 = e9.a.b("getUDID method invoke failed : ");
            b4.append(e.getMessage());
            HiLog.e(str3, b4.toString());
            return str2;
        }
    }

    public static String lmn() {
        return DeviceUtil.getSystemProperty("ro.build.version.emui", "");
    }

    public static String lmn(Context context) {
        return context == null ? "" : Settings.Secure.getString(context.getContentResolver(), "android_id");
    }

    public static String klm(Context context) {
        Bundle bundle;
        Object obj;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null || (obj = bundle.get("CHANNEL")) == null) {
                return "Unknown";
            }
            String obj2 = obj.toString();
            return obj2.length() > 256 ? "Unknown" : obj2;
        } catch (PackageManager.NameNotFoundException unused) {
            HiLog.e(lmn, "getChannel(): The packageName is not correct!");
            return "Unknown";
        }
    }
}
