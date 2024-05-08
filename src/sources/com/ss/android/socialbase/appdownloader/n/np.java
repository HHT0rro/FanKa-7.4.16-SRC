package com.ss.android.socialbase.appdownloader.n;

import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.huawei.openalliance.ad.constant.u;
import com.huawei.quickcard.framework.configuration.device.IManufacturerDeviceInfo;
import com.ss.android.socialbase.appdownloader.hc;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class np {
    public static String dk = "";

    /* renamed from: e, reason: collision with root package name */
    private static Boolean f38945e = null;
    public static String ej = null;

    /* renamed from: hc, reason: collision with root package name */
    private static String f38946hc = null;

    /* renamed from: l, reason: collision with root package name */
    private static String f38947l = "";

    /* renamed from: m, reason: collision with root package name */
    public static String f38948m;

    /* renamed from: n, reason: collision with root package name */
    private static String f38949n;
    private static String np;

    @NonNull
    public static String c() {
        String str = Build.MANUFACTURER;
        return str == null ? "" : str.trim();
    }

    public static boolean dk() {
        return m("MAGICUI");
    }

    public static String e() {
        if (np == null) {
            m("");
        }
        return np;
    }

    public static boolean ej() {
        return m("MIUI");
    }

    private static void f() {
        if (TextUtils.isEmpty(f38948m)) {
            DownloadComponentManager.ensureOPPO();
            f38948m = DownloadConstants.UPPER_OPPO;
            f38947l = "ro.build.version." + DownloadConstants.LOWER_OPPO + "rom";
            dk = "com." + DownloadConstants.LOWER_OPPO + ".market";
        }
    }

    public static boolean hc() {
        return m("SAMSUNG");
    }

    public static boolean k() {
        if (f38945e == null) {
            f38945e = Boolean.valueOf(l.hc().equals(IManufacturerDeviceInfo.OS_HARMONY));
        }
        return f38945e.booleanValue();
    }

    public static boolean l() {
        return m("VIVO");
    }

    public static boolean m() {
        return m("EMUI") || m("MAGICUI");
    }

    public static boolean n() {
        return m("FLYME");
    }

    public static boolean np() {
        f();
        return m(f38948m);
    }

    public static String oa() {
        if (ej == null) {
            m("");
        }
        return ej;
    }

    public static boolean q() {
        x();
        return "V12".equals(f38946hc);
    }

    public static boolean r() {
        x();
        return "V11".equals(f38946hc);
    }

    public static boolean sy() {
        x();
        return "V10".equals(f38946hc);
    }

    public static boolean t() {
        String str = Build.BRAND;
        if (TextUtils.isEmpty(str) || !str.toLowerCase().startsWith("honor")) {
            String str2 = Build.MANUFACTURER;
            if (TextUtils.isEmpty(str2) || !str2.toLowerCase().startsWith("honor")) {
                return false;
            }
        }
        return true;
    }

    @NonNull
    public static String ve() {
        String str = Build.DISPLAY;
        return str == null ? "" : str.trim();
    }

    public static String w() {
        if (f38949n == null) {
            m("");
        }
        return f38949n;
    }

    private static void x() {
        if (f38946hc == null) {
            try {
                f38946hc = l("ro.miui.ui.version.name");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            String str = f38946hc;
            if (str == null) {
                str = "";
            }
            f38946hc = str;
        }
    }

    public static String dk(String str) {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
            try {
                String readLine = bufferedReader.readLine();
                bufferedReader.close();
                DownloadUtils.safeClose(bufferedReader);
                return readLine;
            } catch (Throwable unused) {
                DownloadUtils.safeClose(bufferedReader);
                return null;
            }
        } catch (Throwable unused2) {
            bufferedReader = null;
        }
    }

    public static String ej(String str) throws Throwable {
        return (String) Class.forName("android.os.SystemProperties").getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class).invoke(null, str);
    }

    public static String l(String str) {
        if (DownloadSetting.getGlobalSettings().optBoolean(DownloadSettingKeys.ENABLE_REFLECT_SYSTEM_PROPERTIES, true)) {
            try {
                return ej(str);
            } catch (Throwable th) {
                th.printStackTrace();
                return dk(str);
            }
        }
        return dk(str);
    }

    public static boolean m(String str) {
        f();
        String str2 = np;
        if (str2 != null) {
            return str2.equals(str);
        }
        String l10 = l("ro.miui.ui.version.name");
        f38949n = l10;
        if (!TextUtils.isEmpty(l10)) {
            np = "MIUI";
            ej = "com.xiaomi.market";
            f38946hc = f38949n;
        } else {
            String l11 = l("ro.build.version.emui");
            f38949n = l11;
            if (!TextUtils.isEmpty(l11)) {
                np = t() ? "MAGICUI" : "EMUI";
                ej = u.W;
            } else {
                String l12 = l(f38947l);
                f38949n = l12;
                if (!TextUtils.isEmpty(l12)) {
                    np = f38948m;
                    if (hc.m(dk) > -1) {
                        ej = dk;
                    } else {
                        ej = "com.heytap.market";
                    }
                } else {
                    String l13 = l("ro.vivo.os.version");
                    f38949n = l13;
                    if (!TextUtils.isEmpty(l13)) {
                        np = "VIVO";
                        ej = "com.bbk.appstore";
                    } else {
                        String l14 = l("ro.smartisan.version");
                        f38949n = l14;
                        if (!TextUtils.isEmpty(l14)) {
                            np = "SMARTISAN";
                            ej = "com.smartisanos.appstore";
                        } else {
                            String l15 = l("ro.gn.sv.version");
                            f38949n = l15;
                            if (!TextUtils.isEmpty(l15)) {
                                np = "QIONEE";
                                ej = "com.gionee.aora.market";
                            } else {
                                String l16 = l("ro.lenovo.lvp.version");
                                f38949n = l16;
                                if (!TextUtils.isEmpty(l16)) {
                                    np = "LENOVO";
                                    ej = "com.lenovo.leos.appstore";
                                } else if (c().toUpperCase().contains("SAMSUNG")) {
                                    np = "SAMSUNG";
                                    ej = "com.sec.android.app.samsungapps";
                                } else if (c().toUpperCase().contains("ZTE")) {
                                    np = "ZTE";
                                    ej = "zte.com.market";
                                } else if (c().toUpperCase().contains("NUBIA")) {
                                    np = "NUBIA";
                                    ej = "cn.nubia.neostore";
                                } else if (ve().toUpperCase().contains("FLYME")) {
                                    np = "FLYME";
                                    ej = "com.meizu.mstore";
                                    f38949n = ve();
                                } else if (c().toUpperCase().contains("ONEPLUS")) {
                                    np = "ONEPLUS";
                                    f38949n = l("ro.rom.version");
                                    if (hc.m(dk) > -1) {
                                        ej = dk;
                                    } else {
                                        ej = "com.heytap.market";
                                    }
                                } else {
                                    np = c().toUpperCase();
                                    ej = "";
                                    f38949n = "";
                                }
                            }
                        }
                    }
                }
            }
        }
        return np.equals(str);
    }
}
