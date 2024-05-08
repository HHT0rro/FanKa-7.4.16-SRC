package com.huawei.hms.aaid.utils;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.opendevice.e;
import com.huawei.hms.opendevice.i;
import com.huawei.hms.opendevice.j;
import com.huawei.hms.support.log.HMSLog;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class BaseUtils {
    private BaseUtils() {
    }

    public static void clearSubjectIds(Context context) {
        i.a(context).removeKey("subjectId");
    }

    public static void delLocalToken(Context context, String str) {
        i.a(context).c(str);
    }

    public static void deleteAllTokenCache(Context context) {
        i.a(context).a();
    }

    public static void deleteCacheData(Context context, String str) {
        i.a(context).removeKey(str);
    }

    public static String getCacheData(Context context, String str, boolean z10) {
        if (z10) {
            return i.a(context).a(str);
        }
        return i.a(context).getString(str);
    }

    public static String getLocalToken(Context context, String str) {
        return i.a(context).b(str);
    }

    public static boolean getProxyInit(Context context) {
        return i.a(context).getBoolean("_proxy_init");
    }

    public static String[] getSubjectIds(Context context) {
        String string = i.a(context).getString("subjectId");
        return TextUtils.isEmpty(string) ? new String[0] : string.split(",");
    }

    public static void initSecret(Context context) {
        j.a(context);
    }

    public static boolean isMainProc(Context context) {
        String a10 = e.a(context);
        String str = context.getApplicationInfo().processName;
        HMSLog.i("BaseUtils", "main process name: " + str + ", current process name: " + a10);
        return str.equals(a10);
    }

    public static boolean saveCacheData(Context context, String str, String str2, boolean z10) {
        if (z10) {
            return i.a(context).a(str, str2);
        }
        return i.a(context).saveString(str, str2);
    }

    public static void saveProxyInit(Context context, boolean z10) {
        i.a(context).saveBoolean("_proxy_init", z10);
    }

    public static void saveToken(Context context, String str, String str2) {
        i.a(context).b(str, str2);
    }
}
