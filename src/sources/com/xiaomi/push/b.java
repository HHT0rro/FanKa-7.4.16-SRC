package com.xiaomi.push;

import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.alibaba.security.realidentity.build.cb;
import java.io.File;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class b {
    public static long a() {
        File externalStorageDirectory;
        if (!c() && (externalStorageDirectory = Environment.getExternalStorageDirectory()) != null && !TextUtils.isEmpty(externalStorageDirectory.getPath())) {
            try {
                StatFs statFs = new StatFs(externalStorageDirectory.getPath());
                return statFs.getBlockSize() * (statFs.getAvailableBlocks() - 4);
            } catch (Throwable unused) {
            }
        }
        return 0L;
    }

    public static boolean b() {
        try {
            return Environment.getExternalStorageState().equals("removed");
        } catch (Exception e2) {
            fc.c.k(e2);
            return true;
        }
    }

    public static boolean c() {
        try {
            return true ^ Environment.getExternalStorageState().equals("mounted");
        } catch (Exception e2) {
            fc.c.k(e2);
            return true;
        }
    }

    public static boolean d() {
        return a() <= cb.f3266l;
    }

    public static boolean e() {
        return (c() || d() || b()) ? false : true;
    }
}
