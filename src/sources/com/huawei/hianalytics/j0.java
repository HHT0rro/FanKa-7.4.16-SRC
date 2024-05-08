package com.huawei.hianalytics;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.huawei.hianalytics.core.log.HiLog;
import com.huawei.hianalytics.log.LogTag;
import java.io.File;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class j0 {
    public static final String lmn = LogTag.get(j0.class, new Class[0]);

    public static long ikl(Context context, String str) {
        String str2 = klm(context, str) + ".xml";
        return new File(context.getFilesDir(), "../shared_prefs/" + str2).length();
    }

    public static void klm(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            SharedPreferences lmn2 = lmn(str);
            if (lmn2 != null) {
                SharedPreferences.Editor edit = lmn2.edit();
                edit.putString(str2, str3);
                edit.commit();
                return;
            }
            return;
        }
        HiLog.e(lmn, "spName is empty,or spKey is empty");
    }

    public static SharedPreferences lmn(String str) {
        Context lmn2 = d.lmn();
        if (lmn2 == null) {
            HiLog.e(lmn, "getSPName : context is null");
            return null;
        }
        return lmn2.getSharedPreferences(klm(lmn2, str), 0);
    }

    public static String lmn(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            SharedPreferences lmn2 = lmn(str);
            return lmn2 != null ? lmn2.getString(str2, str3) : str3;
        }
        HiLog.e(lmn, "spName is empty,or spKey is empty");
        return str3;
    }

    public static void klm(Context context, String str, String str2, String str3) {
        if (context == null) {
            HiLog.e(lmn, "SharedPreferences putString : context is null");
            return;
        }
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            SharedPreferences sharedPreferences = context.getSharedPreferences(klm(context, str), 0);
            if (sharedPreferences != null) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putString(str2, str3);
                edit.commit();
                return;
            }
            return;
        }
        HiLog.e(lmn, "spName is empty,or spKey is empty");
    }

    public static String lmn(Context context, String str, String str2, String str3) {
        if (context == null) {
            HiLog.e(lmn, "SharedPreferences getString : context is null");
            return "";
        }
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            SharedPreferences sharedPreferences = context.getSharedPreferences(klm(context, str), 0);
            return sharedPreferences != null ? sharedPreferences.getString(str2, str3) : str3;
        }
        HiLog.e(lmn, "spName is empty,or spKey is empty");
        return str3;
    }

    public static boolean lmn(String str, String str2, boolean z10) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            SharedPreferences lmn2 = lmn(str);
            return lmn2 != null ? lmn2.getBoolean(str2, z10) : z10;
        }
        HiLog.e(lmn, "spName is empty,or spKey is empty");
        return z10;
    }

    public static String klm(Context context, String str) {
        String str2 = c.klm().lmn.f28747d;
        if (TextUtils.isEmpty(str2)) {
            str2 = context.getPackageName();
        }
        return "hianalytics_" + str + "_" + str2;
    }

    public static long lmn(String str, String str2, long j10) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            SharedPreferences lmn2 = lmn(str);
            return lmn2 != null ? lmn2.getLong(str2, j10) : j10;
        }
        HiLog.e(lmn, "spName is empty,or spKey is empty");
        return j10;
    }

    public static void klm(String str, String str2, boolean z10) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            SharedPreferences lmn2 = lmn(str);
            if (lmn2 != null) {
                SharedPreferences.Editor edit = lmn2.edit();
                edit.putBoolean(str2, z10);
                edit.commit();
                return;
            }
            return;
        }
        HiLog.e(lmn, "spName is empty,or spKey is empty");
    }

    public static boolean lmn(Context context, String str) {
        File filesDir = context.getFilesDir();
        StringBuilder b4 = e9.a.b("../shared_prefs/");
        b4.append(klm(context, str));
        b4.append(".xml");
        File file = new File(filesDir, b4.toString());
        if (file.exists() && file.delete()) {
            HiLog.w(lmn, "delete sp file");
        }
        return file.exists() && file.delete();
    }

    public static void klm(String str, String str2, long j10) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            SharedPreferences lmn2 = lmn(str);
            if (lmn2 != null) {
                SharedPreferences.Editor edit = lmn2.edit();
                edit.putLong(str2, j10);
                edit.commit();
                return;
            }
            return;
        }
        HiLog.e(lmn, "spName is empty,or spKey is empty");
    }
}
