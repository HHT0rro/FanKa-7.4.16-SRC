package com.huawei.hms.ads.uiengineloader;

import android.content.Context;
import android.os.Build;
import java.io.File;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class y {

    /* renamed from: a, reason: collision with root package name */
    private static final String f29530a = "dl_FileUtil";

    public static String a(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            return context.createDeviceProtectedStorageContext().getDataDir().getAbsolutePath();
        }
        String absolutePath = context.getFilesDir().getAbsolutePath();
        int lastIndexOf = absolutePath.lastIndexOf(File.separator);
        return lastIndexOf <= 0 ? absolutePath : absolutePath.substring(0, lastIndexOf);
    }

    public static boolean a(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                return true;
            }
            return file.mkdirs();
        } catch (Exception e2) {
            aa.d(f29530a, "makeDirectory Exception: " + e2.getMessage());
            return false;
        }
    }

    public static boolean b(String str) {
        boolean z10;
        boolean z11 = true;
        try {
            File file = new File(str);
            String[] list = file.list();
            if (!file.isDirectory() || list == null || list.length <= 0) {
                z10 = true;
            } else {
                z10 = true;
                for (String str2 : list) {
                    try {
                        if (z10) {
                            if (b(str + File.separator + str2)) {
                                z10 = true;
                            }
                        }
                        z10 = false;
                    } catch (Throwable th) {
                        th = th;
                        z11 = z10;
                        aa.b(f29530a, " delete err: " + th.getClass().getSimpleName());
                        return z11;
                    }
                }
            }
            if (z10) {
                if (file.delete()) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String c(String str) {
        int lastIndexOf = str.lastIndexOf(File.separator);
        return lastIndexOf <= 0 ? str : str.substring(0, lastIndexOf);
    }
}
