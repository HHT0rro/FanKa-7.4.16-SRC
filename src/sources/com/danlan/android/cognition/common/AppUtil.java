package com.danlan.android.cognition.common;

import android.content.Context;
import com.danlan.android.cognition.StringFog;
import java.io.FileInputStream;
import java.io.IOException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class AppUtil {
    public static String getCurrentProcessName() {
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(StringFog.decrypt("DlNWTEIMV0RNRQtATEdISE9G"));
        } catch (Throwable th) {
            th = th;
            fileInputStream = null;
        }
        try {
            byte[] bArr = new byte[256];
            int i10 = 0;
            while (true) {
                int read = fileInputStream.read();
                if (read <= 0 || i10 >= 256) {
                    break;
                }
                bArr[i10] = (byte) read;
                i10++;
            }
            if (i10 > 0) {
                String str = new String(bArr, 0, i10, StringFog.decrypt("dHdiDhk="));
                try {
                    fileInputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                return str;
            }
        } catch (Throwable th2) {
            th = th2;
            try {
                th.printStackTrace();
            } finally {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e10) {
                        e10.printStackTrace();
                    }
                }
            }
        }
        return null;
    }

    public static String getVersionCode(Context context) {
        try {
            return String.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
        } catch (Exception unused) {
            return "";
        }
    }

    public static String getVersionName(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception unused) {
            return "";
        }
    }
}
