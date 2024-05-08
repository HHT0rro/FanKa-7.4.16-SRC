package com.tencent.cloud.huiyansdkface.facelight.c;

import android.os.Build;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static String f40605a = "";

    /* renamed from: b, reason: collision with root package name */
    private static String f40606b = "";

    public static String a(String str) {
        if (TextUtils.isEmpty(f40605a)) {
            d(str);
        }
        return f40605a + f40606b;
    }

    private static boolean a() {
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            return !TextUtils.isEmpty((String) cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0]));
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static String b(String str) {
        return TextUtils.isEmpty(str) ? "" : str.replaceAll(" ", "").toUpperCase();
    }

    private static String c(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getDeclaredMethod(MonitorConstants.CONNECT_TYPE_GET, String.class).invoke(cls, str);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static void d(String str) {
        String c4;
        try {
            String b4 = b(str);
            char c10 = 65535;
            switch (b4.hashCode()) {
                case -1881642058:
                    if (b4.equals("REALME")) {
                        c10 = 4;
                        break;
                    }
                    break;
                case -1706170181:
                    if (b4.equals("XIAOMI")) {
                        c10 = 2;
                        break;
                    }
                    break;
                case -602397472:
                    if (b4.equals("ONEPLUS")) {
                        c10 = 7;
                        break;
                    }
                    break;
                case 2432928:
                    if (b4.equals("OPPO")) {
                        c10 = 5;
                        break;
                    }
                    break;
                case 2634924:
                    if (b4.equals("VIVO")) {
                        c10 = 6;
                        break;
                    }
                    break;
                case 68924490:
                    if (b4.equals("HONOR")) {
                        c10 = 1;
                        break;
                    }
                    break;
                case 73239724:
                    if (b4.equals("MEIZU")) {
                        c10 = '\b';
                        break;
                    }
                    break;
                case 74632627:
                    if (b4.equals("NUBIA")) {
                        c10 = '\t';
                        break;
                    }
                    break;
                case 77852109:
                    if (b4.equals("REDMI")) {
                        c10 = 3;
                        break;
                    }
                    break;
                case 2141820391:
                    if (b4.equals("HUAWEI")) {
                        c10 = 0;
                        break;
                    }
                    break;
            }
            switch (c10) {
                case 0:
                    if (!a()) {
                        f40605a = "EMUI";
                        c4 = c("ro.build.version.emui");
                        break;
                    } else {
                        f40606b = c("hw_sc.build.platform.version");
                        f40605a = "HarmonyOS";
                        return;
                    }
                case 1:
                    if (!a()) {
                        if (!TextUtils.isEmpty(c("ro.build.version.magic"))) {
                            f40605a = "MagicUI";
                            c4 = c("ro.build.version.magic");
                            break;
                        } else {
                            f40605a = "EMUI";
                            c4 = c("ro.build.version.emui");
                            break;
                        }
                    } else {
                        f40605a = "HarmonyOS";
                        if (!TextUtils.isEmpty(c("hw_sc.build.platform.version"))) {
                            c4 = c("hw_sc.build.platform.version");
                            break;
                        } else {
                            c4 = "";
                            break;
                        }
                    }
                case 2:
                case 3:
                    f40605a = "MIUI";
                    c4 = c("ro.miui.ui.version.name") + " " + c("ro.build.version.incremental");
                    break;
                case 4:
                case 5:
                    f40605a = "ColorOS";
                    c4 = c("ro.build.version.opporom");
                    break;
                case 6:
                    f40605a = "Funtouch";
                    c4 = c("ro.vivo.os.version");
                    break;
                case 7:
                    f40605a = "HydrogenOS";
                    c4 = c("ro.rom.version");
                    break;
                case '\b':
                    f40605a = "Flyme";
                    c4 = c("ro.build.display.id");
                    break;
                case '\t':
                    f40605a = c("ro.build.nubia.rom.name");
                    c4 = c("ro.build.nubia.rom.code");
                    break;
                default:
                    f40605a = "Android";
                    c4 = Build.VERSION.RELEASE;
                    break;
            }
            f40606b = c4;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
