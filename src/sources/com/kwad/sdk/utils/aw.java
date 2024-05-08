package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import java.io.File;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class aw {
    private static String aPH;
    private static File aPI;

    private static boolean Mz() {
        try {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                return true;
            }
            return !Environment.isExternalStorageRemovable();
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
            return false;
        }
    }

    private static String cJ(Context context) {
        if (!TextUtils.isEmpty(aPH)) {
            return aPH;
        }
        String str = null;
        if (Mz()) {
            try {
                File externalFilesDir = context.getExternalFilesDir(null);
                if (externalFilesDir != null) {
                    str = externalFilesDir.getPath();
                }
            } catch (Exception e2) {
                com.kwad.sdk.core.e.c.printStackTrace(e2);
            }
        }
        if (TextUtils.isEmpty(str)) {
            str = context.getFilesDir().getPath();
        }
        String str2 = str + File.separator + "ksadsdk";
        aPH = str2;
        return str2;
    }

    public static File cK(Context context) {
        File file = aPI;
        if (file != null) {
            return file;
        }
        String str = null;
        if (Mz()) {
            try {
                File externalCacheDir = context.getExternalCacheDir();
                if (externalCacheDir != null) {
                    str = externalCacheDir.getPath();
                }
            } catch (Exception e2) {
                com.kwad.sdk.core.e.c.printStackTrace(e2);
            }
        }
        if (TextUtils.isEmpty(str)) {
            str = context.getCacheDir().getPath();
        }
        File file2 = new File(str + File.separator + "ksadsdk");
        aPI = file2;
        if (!file2.exists()) {
            aPI.mkdirs();
        }
        return aPI;
    }

    public static File cL(Context context) {
        File file = new File(cJ(context) + File.separator + "Download");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File cM(Context context) {
        File file = new File(cJ(context) + File.separator + "downloadFileSync/.temp");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File cN(Context context) {
        String str;
        if (com.kwad.framework.a.a.f36635md.booleanValue()) {
            str = cJ(context);
        } else {
            str = context.getFilesDir().getAbsolutePath() + File.separator + "ksadsdk";
        }
        return new File(str + File.separator + "ksadlog");
    }

    public static String cO(Context context) {
        if (context == null) {
            return "";
        }
        return context.getFilesDir().getPath() + File.separator + "ksadsdk";
    }

    public static String cP(Context context) {
        return cK(context).getPath() + "/cookie";
    }

    public static String getTkJsFileDir(Context context, String str) {
        if (context == null) {
            return "";
        }
        String cO = cO(context);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(cO);
        String str2 = File.separator;
        sb2.append(str2);
        sb2.append("ksad/download/js");
        sb2.append(str2);
        sb2.append(str);
        return sb2.toString();
    }

    public static String getTkJsRootDir(Context context) {
        if (context == null) {
            return "";
        }
        return cO(context) + File.separator + "ksad/download/js";
    }
}
