package com.zego.zegoavkit2.utils;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.huawei.openalliance.ad.constant.u;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class SysUtil {
    private static void closeReader(Reader reader) {
        if (reader != null) {
            try {
                reader.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static String getCarrierName(Context context) {
        if (context == null) {
            return null;
        }
        return ((TelephonyManager) context.getSystemService("phone")).getNetworkOperatorName();
    }

    public static String getOsInfo() {
        return (Build.MANUFACTURER + u.bD + Build.VERSION.RELEASE + u.bD + Build.MODEL + u.bD + Build.VERSION.SDK_INT + u.bD + Build.BRAND).replaceAll(",", ".");
    }

    public static String getPreferredLanguage() {
        return Locale.getDefault().toLanguageTag();
    }

    public static String getSoCModel() {
        String readProp;
        String soCModelFromCPUInfo = getSoCModelFromCPUInfo();
        if (isValidSoCModel(soCModelFromCPUInfo)) {
            readProp = soCModelFromCPUInfo.split(" ")[0];
        } else {
            readProp = readProp("ro.board.platform");
            if (!isValidSoCModel(readProp)) {
                readProp = Build.HARDWARE;
                if (!isValidSoCModel(readProp) && readProp == null) {
                    readProp = "";
                }
            }
        }
        return readProp.toLowerCase();
    }

    public static String getSoCModelFromCPUInfo() {
        BufferedReader bufferedReader;
        String group;
        File file = new File("/proc/cpuinfo");
        String str = "";
        if (file.exists() && file.canRead()) {
            BufferedReader bufferedReader2 = null;
            try {
                bufferedReader = new BufferedReader(new FileReader(file), 8192);
                try {
                    for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                        if (readLine.startsWith("Hardware")) {
                            Matcher matcher = Pattern.compile("sm\\d+.*").matcher(readLine.toLowerCase());
                            if (matcher.find()) {
                                group = matcher.toMatchResult().group(0);
                            } else {
                                Matcher matcher2 = Pattern.compile("sdm\\d+.*").matcher(readLine.toLowerCase());
                                if (matcher2.find()) {
                                    group = matcher2.toMatchResult().group(0);
                                } else {
                                    Matcher matcher3 = Pattern.compile("msm\\d+.*").matcher(readLine.toLowerCase());
                                    if (matcher3.find()) {
                                        group = matcher3.toMatchResult().group(0);
                                    } else {
                                        Matcher matcher4 = Pattern.compile("apq\\d+.*").matcher(readLine.toLowerCase());
                                        if (matcher4.find()) {
                                            group = matcher4.toMatchResult().group(0);
                                        } else {
                                            Matcher matcher5 = Pattern.compile("((waipio)|(lahaina)|(kona)|(huracan)|(hana)|(napali)|(nairo)|(lito)|(atoll)|(trinket)|(bengal))").matcher(readLine.toLowerCase());
                                            if (matcher5.find()) {
                                                group = matcher5.toMatchResult().group(0);
                                            } else {
                                                Matcher matcher6 = Pattern.compile("kirin\\d+.*").matcher(readLine.toLowerCase());
                                                if (matcher6.find()) {
                                                    group = matcher6.toMatchResult().group(0);
                                                } else {
                                                    Matcher matcher7 = Pattern.compile("hi\\d+.*").matcher(readLine.toLowerCase());
                                                    if (matcher7.find()) {
                                                        group = matcher7.toMatchResult().group(0);
                                                    } else {
                                                        Matcher matcher8 = Pattern.compile("mt\\d+.*").matcher(readLine.toLowerCase());
                                                        if (matcher8.find()) {
                                                            group = matcher8.toMatchResult().group(0);
                                                        } else {
                                                            Matcher matcher9 = Pattern.compile("kompanio\\d+.*").matcher(readLine.toLowerCase());
                                                            if (matcher9.find()) {
                                                                group = matcher9.toMatchResult().group(0);
                                                            } else {
                                                                Matcher matcher10 = Pattern.compile("(samsung)?e(xynos)?\\d+.*").matcher(readLine.toLowerCase());
                                                                if (matcher10.find()) {
                                                                    group = matcher10.toMatchResult().group(0);
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
                            str = group;
                            break;
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    bufferedReader2 = bufferedReader;
                    e.printStackTrace();
                    bufferedReader = bufferedReader2;
                    closeReader(bufferedReader);
                    return str;
                }
            } catch (Exception e10) {
                e = e10;
            }
            closeReader(bufferedReader);
        }
        return str;
    }

    public static String getTimeZone() {
        return TimeZone.getDefault().getID();
    }

    public static String getVersion() {
        return Build.VERSION.RELEASE.replaceAll(",", ".");
    }

    public static boolean isValidSoCModel(String str) {
        if (str != null && !str.isEmpty()) {
            String lowerCase = str.trim().toLowerCase();
            if (Pattern.matches("^sm\\d+.*", lowerCase) || Pattern.matches("^sdm\\d+.*", lowerCase) || Pattern.matches("^msm\\d+.*", lowerCase) || Pattern.matches("^apq\\d+.*", lowerCase) || Pattern.matches("^((waipio)|(lahaina)|(kona)|(huracan)|(hana)|(napali)|(nairo)|(lito)|(atoll)|(trinket)|(bengal))", lowerCase) || Pattern.matches("^kirin\\d+.*", lowerCase) || Pattern.matches("^hi\\d+.*", lowerCase) || Pattern.matches("^mt\\d+.*", lowerCase) || Pattern.matches("^kompanio\\d+.*", lowerCase) || Pattern.matches("^(samsung)?e(xynos)?\\d+.*", lowerCase)) {
                return true;
            }
        }
        return false;
    }

    public static String readProp(String str) {
        Process process;
        BufferedReader bufferedReader = null;
        try {
            process = new ProcessBuilder(new String[0]).command("getprop", str).redirectErrorStream(true).start();
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(process.getInputStream()));
                try {
                    String readLine = bufferedReader2.readLine();
                    String str2 = readLine != null ? readLine : "";
                    try {
                        bufferedReader2.close();
                    } catch (IOException unused) {
                    }
                    process.destroy();
                    return str2;
                } catch (Exception unused2) {
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException unused3) {
                        }
                    }
                    if (process != null) {
                        process.destroy();
                    }
                    return "";
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException unused4) {
                        }
                    }
                    if (process != null) {
                        process.destroy();
                        throw th;
                    }
                    throw th;
                }
            } catch (Exception unused5) {
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception unused6) {
            process = null;
        } catch (Throwable th3) {
            th = th3;
            process = null;
        }
    }
}
