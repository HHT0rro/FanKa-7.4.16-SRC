package com.alibaba.security.common.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.alipay.sdk.util.i;
import com.hailiang.advlib.core.ADEvent;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class SystemUtils {
    private static final String TAG = "SystemUtils";
    private static final String UNKNOWN = "unknown";
    private static final String VERSION_PROPERTY_360 = "ro.build.uiversion";
    private static final String VERSION_PROPERTY_HUAWEI = "ro.build.version.emui";
    private static final String VERSION_PROPERTY_LEECO = "ro.letv.release.version";
    private static final String VERSION_PROPERTY_NUBIA = "ro.build.rom.id";
    private static final String VERSION_PROPERTY_ONEPLUS = "ro.rom.version";
    private static final String VERSION_PROPERTY_OPPO = "ro.build.version.opporom";
    private static final String VERSION_PROPERTY_VIVO = "ro.vivo.os.build.display.id";
    private static final String VERSION_PROPERTY_XIAOMI = "ro.build.version.incremental";
    private static final String VERSION_PROPERTY_ZTE = "ro.build.MiFavor_version";
    private static final String[] ROM_HUAWEI = {"huawei"};
    private static final String[] ROM_VIVO = {ADEvent.VIVO};
    private static final String[] ROM_XIAOMI = {ADEvent.XIAOMI};
    private static final String[] ROM_OPPO = {"oppo"};
    private static final String[] ROM_LEECO = {"leeco", "letv"};
    private static final String[] ROM_360 = {"360", "qiku"};
    private static final String[] ROM_ZTE = {"zte"};
    private static final String[] ROM_ONEPLUS = {"oneplus"};
    private static final String[] ROM_NUBIA = {"nubia"};
    private static final String[] ROM_COOLPAD = {"coolpad", "yulong"};
    private static final String[] ROM_LG = {"lg", "lge"};
    private static final String[] ROM_GOOGLE = {"google"};
    private static final String[] ROM_SAMSUNG = {"samsung"};
    private static final String[] ROM_MEIZU = {"meizu"};
    private static final String[] ROM_LENOVO = {"lenovo"};
    private static final String[] ROM_SMARTISAN = {"smartisan"};
    private static final String[] ROM_HTC = {"htc"};
    private static final String[] ROM_SONY = {"sony"};
    private static final String[] ROM_GIONEE = {"gionee", "amigo"};
    private static final String[] ROM_MOTOROLA = {"motorola"};
    private static RomInfo bean = null;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class RomInfo {
        private String name;
        private String version;

        public String getName() {
            return this.name;
        }

        public String getVersion() {
            return this.version;
        }

        public String toString() {
            return "RomInfo{name=" + this.name + ", version=" + this.version + i.f4738d;
        }
    }

    private SystemUtils() {
    }

    public static long getAvailableMemory(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null) {
            return 0L;
        }
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo.availMem;
    }

    private static String getBrand() {
        try {
            String str = Build.BRAND;
            return !TextUtils.isEmpty(str) ? str.toLowerCase() : "unknown";
        } catch (Throwable unused) {
            return "unknown";
        }
    }

    public static String getCpuName() {
        String[] strArr = Build.SUPPORTED_ABIS;
        StringBuffer stringBuffer = new StringBuffer();
        if (strArr != null) {
            for (String str : strArr) {
                stringBuffer.append(str);
                stringBuffer.append(";");
            }
        }
        return stringBuffer.toString();
    }

    private static String getManufacturer() {
        try {
            String str = Build.MANUFACTURER;
            return !TextUtils.isEmpty(str) ? str.toLowerCase() : "unknown";
        } catch (Throwable unused) {
            return "unknown";
        }
    }

    public static RomInfo getRomInfo() {
        RomInfo romInfo = bean;
        if (romInfo != null) {
            return romInfo;
        }
        bean = new RomInfo();
        String brand = getBrand();
        String manufacturer = getManufacturer();
        String[] strArr = ROM_HUAWEI;
        if (isRightRom(brand, manufacturer, strArr)) {
            bean.name = strArr[0];
            String romVersion = getRomVersion(VERSION_PROPERTY_HUAWEI);
            String[] split = romVersion.split("_");
            if (split.length > 1) {
                bean.version = split[1];
            } else {
                bean.version = romVersion;
            }
            return bean;
        }
        String[] strArr2 = ROM_VIVO;
        if (isRightRom(brand, manufacturer, strArr2)) {
            bean.name = strArr2[0];
            bean.version = getRomVersion(VERSION_PROPERTY_VIVO);
            return bean;
        }
        String[] strArr3 = ROM_XIAOMI;
        if (isRightRom(brand, manufacturer, strArr3)) {
            bean.name = strArr3[0];
            bean.version = getRomVersion(VERSION_PROPERTY_XIAOMI);
            return bean;
        }
        String[] strArr4 = ROM_OPPO;
        if (isRightRom(brand, manufacturer, strArr4)) {
            bean.name = strArr4[0];
            bean.version = getRomVersion(VERSION_PROPERTY_OPPO);
            return bean;
        }
        String[] strArr5 = ROM_LEECO;
        if (isRightRom(brand, manufacturer, strArr5)) {
            bean.name = strArr5[0];
            bean.version = getRomVersion(VERSION_PROPERTY_LEECO);
            return bean;
        }
        String[] strArr6 = ROM_360;
        if (isRightRom(brand, manufacturer, strArr6)) {
            bean.name = strArr6[0];
            bean.version = getRomVersion(VERSION_PROPERTY_360);
            return bean;
        }
        String[] strArr7 = ROM_ZTE;
        if (isRightRom(brand, manufacturer, strArr7)) {
            bean.name = strArr7[0];
            bean.version = getRomVersion(VERSION_PROPERTY_ZTE);
            return bean;
        }
        String[] strArr8 = ROM_ONEPLUS;
        if (isRightRom(brand, manufacturer, strArr8)) {
            bean.name = strArr8[0];
            bean.version = getRomVersion(VERSION_PROPERTY_ONEPLUS);
            return bean;
        }
        String[] strArr9 = ROM_NUBIA;
        if (isRightRom(brand, manufacturer, strArr9)) {
            bean.name = strArr9[0];
            bean.version = getRomVersion(VERSION_PROPERTY_NUBIA);
            return bean;
        }
        String[] strArr10 = ROM_COOLPAD;
        if (isRightRom(brand, manufacturer, strArr10)) {
            bean.name = strArr10[0];
        } else {
            String[] strArr11 = ROM_LG;
            if (isRightRom(brand, manufacturer, strArr11)) {
                bean.name = strArr11[0];
            } else {
                String[] strArr12 = ROM_GOOGLE;
                if (isRightRom(brand, manufacturer, strArr12)) {
                    bean.name = strArr12[0];
                } else {
                    String[] strArr13 = ROM_SAMSUNG;
                    if (isRightRom(brand, manufacturer, strArr13)) {
                        bean.name = strArr13[0];
                    } else {
                        String[] strArr14 = ROM_MEIZU;
                        if (isRightRom(brand, manufacturer, strArr14)) {
                            bean.name = strArr14[0];
                        } else {
                            String[] strArr15 = ROM_LENOVO;
                            if (isRightRom(brand, manufacturer, strArr15)) {
                                bean.name = strArr15[0];
                            } else {
                                String[] strArr16 = ROM_SMARTISAN;
                                if (isRightRom(brand, manufacturer, strArr16)) {
                                    bean.name = strArr16[0];
                                } else {
                                    String[] strArr17 = ROM_HTC;
                                    if (isRightRom(brand, manufacturer, strArr17)) {
                                        bean.name = strArr17[0];
                                    } else {
                                        String[] strArr18 = ROM_SONY;
                                        if (isRightRom(brand, manufacturer, strArr18)) {
                                            bean.name = strArr18[0];
                                        } else {
                                            String[] strArr19 = ROM_GIONEE;
                                            if (isRightRom(brand, manufacturer, strArr19)) {
                                                bean.name = strArr19[0];
                                            } else {
                                                String[] strArr20 = ROM_MOTOROLA;
                                                if (isRightRom(brand, manufacturer, strArr20)) {
                                                    bean.name = strArr20[0];
                                                } else {
                                                    bean.name = manufacturer;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        bean.version = getRomVersion("");
        return bean;
    }

    private static String getRomVersion(String str) {
        String systemProperty = !TextUtils.isEmpty(str) ? getSystemProperty(str) : "";
        if (TextUtils.isEmpty(systemProperty) || systemProperty.equals("unknown")) {
            try {
                String str2 = Build.DISPLAY;
                if (!TextUtils.isEmpty(str2)) {
                    systemProperty = str2.toLowerCase();
                }
            } catch (Throwable unused) {
            }
        }
        return TextUtils.isEmpty(systemProperty) ? "unknown" : systemProperty;
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0076: MOVE (r2 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:31:0x0076 */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0079 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getSystemProperty(java.lang.String r7) {
        /*
            java.lang.String r0 = "Exception while closing InputStream"
            java.lang.String r1 = "SystemUtils"
            r2 = 0
            java.lang.Runtime r3 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L46 java.io.IOException -> L48
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L46 java.io.IOException -> L48
            r4.<init>()     // Catch: java.lang.Throwable -> L46 java.io.IOException -> L48
            java.lang.String r5 = "getprop "
            r4.append(r5)     // Catch: java.lang.Throwable -> L46 java.io.IOException -> L48
            r4.append(r7)     // Catch: java.lang.Throwable -> L46 java.io.IOException -> L48
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L46 java.io.IOException -> L48
            java.lang.Process r3 = r3.exec(r4)     // Catch: java.lang.Throwable -> L46 java.io.IOException -> L48
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L46 java.io.IOException -> L48
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L46 java.io.IOException -> L48
            java.io.InputStream r3 = r3.getInputStream()     // Catch: java.lang.Throwable -> L46 java.io.IOException -> L48
            r5.<init>(r3)     // Catch: java.lang.Throwable -> L46 java.io.IOException -> L48
            r3 = 1024(0x400, float:1.435E-42)
            r4.<init>(r5, r3)     // Catch: java.lang.Throwable -> L46 java.io.IOException -> L48
            java.lang.String r3 = r4.readLine()     // Catch: java.io.IOException -> L44 java.lang.Throwable -> L75
            r4.close()     // Catch: java.io.IOException -> L44 java.lang.Throwable -> L75
            r4.close()     // Catch: java.io.IOException -> L39
            goto L43
        L39:
            r7 = move-exception
            boolean r2 = com.alibaba.security.common.log.RPLogging.isEnable()
            if (r2 == 0) goto L43
            com.alibaba.security.common.log.RPLogging.e(r1, r0, r7)
        L43:
            return r3
        L44:
            r3 = move-exception
            goto L4a
        L46:
            r7 = move-exception
            goto L77
        L48:
            r3 = move-exception
            r4 = r2
        L4a:
            boolean r5 = com.alibaba.security.common.log.RPLogging.isEnable()     // Catch: java.lang.Throwable -> L75
            if (r5 == 0) goto L64
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L75
            r5.<init>()     // Catch: java.lang.Throwable -> L75
            java.lang.String r6 = "Unable to read sysprop "
            r5.append(r6)     // Catch: java.lang.Throwable -> L75
            r5.append(r7)     // Catch: java.lang.Throwable -> L75
            java.lang.String r7 = r5.toString()     // Catch: java.lang.Throwable -> L75
            com.alibaba.security.common.log.RPLogging.e(r1, r7, r3)     // Catch: java.lang.Throwable -> L75
        L64:
            if (r4 == 0) goto L74
            r4.close()     // Catch: java.io.IOException -> L6a
            goto L74
        L6a:
            r7 = move-exception
            boolean r3 = com.alibaba.security.common.log.RPLogging.isEnable()
            if (r3 == 0) goto L74
            com.alibaba.security.common.log.RPLogging.e(r1, r0, r7)
        L74:
            return r2
        L75:
            r7 = move-exception
            r2 = r4
        L77:
            if (r2 == 0) goto L87
            r2.close()     // Catch: java.io.IOException -> L7d
            goto L87
        L7d:
            r2 = move-exception
            boolean r3 = com.alibaba.security.common.log.RPLogging.isEnable()
            if (r3 == 0) goto L87
            com.alibaba.security.common.log.RPLogging.e(r1, r0, r2)
        L87:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.security.common.utils.SystemUtils.getSystemProperty(java.lang.String):java.lang.String");
    }

    public static long getTotalMemorySize(Context context) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 2048);
            String readLine = bufferedReader.readLine();
            if (TextUtils.isEmpty(readLine)) {
                bufferedReader.close();
                return 0L;
            }
            String substring = readLine.substring(readLine.indexOf("MemTotal:"));
            if (TextUtils.isEmpty(substring)) {
                bufferedReader.close();
                return 0L;
            }
            bufferedReader.close();
            return Long.parseLong(substring.replaceAll("\\D+", "")) * 1024;
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static boolean is360() {
        return ROM_360[0].equals(getRomInfo().name);
    }

    public static boolean isCoolpad() {
        return ROM_COOLPAD[0].equals(getRomInfo().name);
    }

    public static boolean isCpuX86() {
        if ("x86".equalsIgnoreCase(Build.CPU_ABI) || "x86".equalsIgnoreCase(Build.CPU_ABI2)) {
            return true;
        }
        String[] strArr = Build.SUPPORTED_ABIS;
        if (strArr != null) {
            for (String str : strArr) {
                if (str != null && str.toLowerCase().contains("x86")) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isGionee() {
        return ROM_GIONEE[0].equals(getRomInfo().name);
    }

    public static boolean isGoogle() {
        return ROM_GOOGLE[0].equals(getRomInfo().name);
    }

    public static boolean isHtc() {
        return ROM_HTC[0].equals(getRomInfo().name);
    }

    public static boolean isHuawei() {
        return ROM_HUAWEI[0].equals(getRomInfo().name);
    }

    public static boolean isLenovo() {
        return ROM_LENOVO[0].equals(getRomInfo().name);
    }

    public static boolean isLg() {
        return ROM_LG[0].equals(getRomInfo().name);
    }

    public static boolean isMeizu() {
        return ROM_MEIZU[0].equals(getRomInfo().name);
    }

    public static boolean isMotorola() {
        return ROM_MOTOROLA[0].equals(getRomInfo().name);
    }

    public static boolean isNubia() {
        return ROM_NUBIA[0].equals(getRomInfo().name);
    }

    public static boolean isOneplus() {
        return ROM_ONEPLUS[0].equals(getRomInfo().name);
    }

    public static boolean isOppo() {
        return ROM_OPPO[0].equals(getRomInfo().name);
    }

    private static boolean isRightRom(String str, String str2, String... strArr) {
        for (String str3 : strArr) {
            if (str.contains(str3) || str2.contains(str3)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isSamsung() {
        return ROM_SAMSUNG[0].equals(getRomInfo().name);
    }

    public static boolean isSmartisan() {
        return ROM_SMARTISAN[0].equals(getRomInfo().name);
    }

    public static boolean isSony() {
        return ROM_SONY[0].equals(getRomInfo().name);
    }

    public static boolean isVivo() {
        return ROM_VIVO[0].equals(getRomInfo().name);
    }

    public static boolean isXiaomi() {
        return ROM_XIAOMI[0].equals(getRomInfo().name);
    }

    public static boolean isZte() {
        return ROM_ZTE[0].equals(getRomInfo().name);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:100:0x00c7 -> B:46:0x00ca). Please report as a decompilation issue!!! */
    public static boolean supportNEON() {
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        String lowerCase;
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream("/proc/cpuinfo");
                try {
                    inputStreamReader = new InputStreamReader(fileInputStream2);
                    try {
                        bufferedReader = new BufferedReader(inputStreamReader);
                        try {
                            do {
                                try {
                                    String readLine = bufferedReader.readLine();
                                    if (readLine != null) {
                                        lowerCase = readLine.trim().toLowerCase();
                                    }
                                    break;
                                } catch (Exception unused) {
                                    fileInputStream = fileInputStream2;
                                    if (fileInputStream != null) {
                                        try {
                                            fileInputStream.close();
                                        } catch (IOException e2) {
                                            e2.printStackTrace();
                                        }
                                    }
                                    if (inputStreamReader != null) {
                                        try {
                                            inputStreamReader.close();
                                        } catch (IOException e10) {
                                            e10.printStackTrace();
                                        }
                                    }
                                    if (bufferedReader != null) {
                                        bufferedReader.close();
                                    }
                                    return false;
                                } catch (Throwable th) {
                                    th = th;
                                    fileInputStream = fileInputStream2;
                                    if (fileInputStream != null) {
                                        try {
                                            fileInputStream.close();
                                        } catch (IOException e11) {
                                            e11.printStackTrace();
                                        }
                                    }
                                    if (inputStreamReader != null) {
                                        try {
                                            inputStreamReader.close();
                                        } catch (IOException e12) {
                                            e12.printStackTrace();
                                        }
                                    }
                                    if (bufferedReader != null) {
                                        try {
                                            bufferedReader.close();
                                            throw th;
                                        } catch (IOException e13) {
                                            e13.printStackTrace();
                                            throw th;
                                        }
                                    }
                                    throw th;
                                }
                            } while (!lowerCase.startsWith("features"));
                            break;
                            fileInputStream2.close();
                        } catch (IOException e14) {
                            e14.printStackTrace();
                        }
                        for (String str : lowerCase.split(" ")) {
                            if (str.contains("neon") || "asimd".equals(str)) {
                                try {
                                    fileInputStream2.close();
                                } catch (IOException e15) {
                                    e15.printStackTrace();
                                }
                                try {
                                    inputStreamReader.close();
                                } catch (IOException e16) {
                                    e16.printStackTrace();
                                }
                                try {
                                    bufferedReader.close();
                                    return true;
                                } catch (IOException e17) {
                                    e17.printStackTrace();
                                    return true;
                                }
                            }
                        }
                        try {
                            inputStreamReader.close();
                        } catch (IOException e18) {
                            e18.printStackTrace();
                        }
                        bufferedReader.close();
                    } catch (Exception unused2) {
                        bufferedReader = null;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader = null;
                    }
                } catch (Exception unused3) {
                    inputStreamReader = null;
                    bufferedReader = null;
                } catch (Throwable th3) {
                    th = th3;
                    inputStreamReader = null;
                    bufferedReader = null;
                }
            } catch (Exception unused4) {
                inputStreamReader = null;
                bufferedReader = null;
            } catch (Throwable th4) {
                th = th4;
                inputStreamReader = null;
                bufferedReader = null;
            }
        } catch (IOException e19) {
            e19.printStackTrace();
        }
        return false;
    }
}
