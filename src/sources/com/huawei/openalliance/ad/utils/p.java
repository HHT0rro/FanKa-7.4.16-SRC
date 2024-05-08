package com.huawei.openalliance.ad.utils;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.ads.gl;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class p {
    public static final String Code = "FileUtil";
    private static final int V = 10;

    private static String B(File file) {
        if (file == null) {
            return null;
        }
        try {
            return file.getCanonicalPath();
        } catch (IOException unused) {
            gl.Z("FileUtil", "get path error");
            return null;
        }
    }

    public static String Code(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            return context.createDeviceProtectedStorageContext().getDataDir().getAbsolutePath();
        }
        String absolutePath = context.getFilesDir().getAbsolutePath();
        int lastIndexOf = absolutePath.lastIndexOf(File.separator);
        return lastIndexOf <= 0 ? absolutePath : absolutePath.substring(0, lastIndexOf);
    }

    public static String Code(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        try {
            byte[] bArr = new byte[4];
            if (inputStream.read(bArr, 0, 4) > 0) {
                return u.Code(bArr);
            }
            return null;
        } catch (IOException unused) {
            gl.Z("FileUtil", "fail to read file header");
            return null;
        }
    }

    public static void Code(String str) {
        if (au.Code(str)) {
            return;
        }
        I(new File(str));
    }

    public static boolean Code(File file) {
        if (file == null || file.mkdirs()) {
            return true;
        }
        Z(file);
        return file.mkdirs();
    }

    private static void I(File file) {
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File file2 : listFiles) {
                    if (file2.isDirectory()) {
                        I(file2);
                    } else {
                        V(file2);
                    }
                }
            }
            V(file);
        }
    }

    private static boolean V(File file) {
        try {
            File file2 = new File(file.getCanonicalPath() + System.currentTimeMillis());
            if (file.renameTo(file2)) {
                return file2.delete();
            }
            return false;
        } catch (IOException unused) {
            gl.I("FileUtil", "deleteSingleFile IOException");
            return false;
        }
    }

    private static void Z(File file) {
        if (file == null) {
            return;
        }
        int i10 = 0;
        while (i10 < 10 && file != null && !as.Code(B(file))) {
            i10++;
            if (file.exists()) {
                gl.Code("FileUtil", "current file exists");
                if (file.isFile()) {
                    V(file);
                    return;
                }
                return;
            }
            File parentFile = file.getParentFile();
            if (parentFile != null && TextUtils.equals(B(parentFile), B(file))) {
                gl.I("FileUtil", "parent file is the same as current");
                return;
            }
            file = parentFile;
        }
    }
}
