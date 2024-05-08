package com.wangmai.common.utils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class DebugLog {
    public static final String TAG = "WM_SDK_LOG==";

    /* renamed from: sb, reason: collision with root package name */
    public static StringBuffer f46927sb = new StringBuffer();

    public static void D(String str, String str2) {
        if (ConstantInfo.isDebug()) {
            release_d(str, str2);
        }
    }

    public static void E(String str, String str2) {
        if (ConstantInfo.isDebug()) {
            release_d(str, str2);
        }
    }

    public static void I(String str, String str2) {
        if (ConstantInfo.isDebug()) {
            release_i(str, str2);
        }
    }

    public static void W(String str, String str2) {
        if (ConstantInfo.isDebug()) {
            release_w(str, str2);
        }
    }

    public static void release_d(String str, String str2) {
        try {
            if (str2.length() <= 3072) {
                return;
            }
            while (str2.length() > 3072) {
                str2 = str2.replace(str2.substring(0, 3072), "");
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void release_e(String str, String str2) {
        try {
            if (str2.length() <= 3072) {
                return;
            }
            while (str2.length() > 3072) {
                str2 = str2.replace(str2.substring(0, 3072), "");
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void release_i(String str, String str2) {
        try {
            if (str2.length() <= 3072) {
                return;
            }
            while (str2.length() > 3072) {
                str2 = str2.replace(str2.substring(0, 3072), "");
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void release_w(String str, String str2) {
        try {
            if (str2.length() <= 3072) {
                return;
            }
            while (str2.length() > 3072) {
                str2 = str2.replace(str2.substring(0, 3072), "");
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void E(String str, Object... objArr) {
        if (ConstantInfo.isDebug()) {
            try {
                f46927sb.setLength(0);
                int length = objArr.length;
                for (int i10 = 1; i10 < length; i10++) {
                    StringBuffer stringBuffer = f46927sb;
                    stringBuffer.append("===>");
                    stringBuffer.append(objArr[i10]);
                }
                release_e(str, f46927sb.toString());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
