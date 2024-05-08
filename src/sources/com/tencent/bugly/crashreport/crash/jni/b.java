package com.tencent.bugly.crashreport.crash.jni;

import android.content.Context;
import android.text.TextUtils;
import com.alimm.tanx.core.constant.AdClickConstants;
import com.huawei.hms.push.AttributionReporter;
import com.huawei.openalliance.ad.constant.as;
import com.huawei.openalliance.ad.constant.u;
import com.huawei.quickcard.base.Attributes;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* compiled from: BUGLY */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private static List<File> f39332a = new ArrayList();

    public static String a(String str) {
        if (str == null) {
            return "";
        }
        String[] split = str.split("\n");
        if (split == null || split.length == 0) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder();
        for (String str2 : split) {
            if (!str2.contains("java.lang.Thread.getStackTrace(")) {
                sb2.append(str2);
                sb2.append("\n");
            }
        }
        return sb2.toString();
    }

    private static String b(String str, String str2) {
        BufferedReader a10 = z.a(str, "reg_record.txt");
        if (a10 == null) {
            return null;
        }
        try {
            StringBuilder sb2 = new StringBuilder();
            String readLine = a10.readLine();
            if (readLine != null && readLine.startsWith(str2)) {
                int i10 = 18;
                int i11 = 0;
                int i12 = 0;
                while (true) {
                    String readLine2 = a10.readLine();
                    if (readLine2 == null) {
                        break;
                    }
                    if (i11 % 4 == 0) {
                        if (i11 > 0) {
                            sb2.append("\n");
                        }
                        sb2.append("  ");
                    } else {
                        if (readLine2.length() > 16) {
                            i10 = 28;
                        }
                        sb2.append("                ".substring(0, i10 - i12));
                    }
                    i12 = readLine2.length();
                    sb2.append(readLine2);
                    i11++;
                }
                sb2.append("\n");
                return sb2.toString();
            }
            try {
                a10.close();
            } catch (Exception e2) {
                x.a(e2);
            }
            return null;
        } catch (Throwable th) {
            try {
                x.a(th);
                try {
                    a10.close();
                } catch (Exception e10) {
                    x.a(e10);
                }
                return null;
            } finally {
                try {
                    a10.close();
                } catch (Exception e11) {
                    x.a(e11);
                }
            }
        }
    }

    private static String c(String str, String str2) {
        BufferedReader a10 = z.a(str, "map_record.txt");
        if (a10 == null) {
            return null;
        }
        try {
            StringBuilder sb2 = new StringBuilder();
            String readLine = a10.readLine();
            if (readLine != null && readLine.startsWith(str2)) {
                while (true) {
                    String readLine2 = a10.readLine();
                    if (readLine2 == null) {
                        break;
                    }
                    sb2.append("  ");
                    sb2.append(readLine2);
                    sb2.append("\n");
                }
                return sb2.toString();
            }
            try {
                a10.close();
            } catch (Exception e2) {
                x.a(e2);
            }
            return null;
        } catch (Throwable th) {
            try {
                x.a(th);
                try {
                    a10.close();
                } catch (Exception e10) {
                    x.a(e10);
                }
                return null;
            } finally {
                try {
                    a10.close();
                } catch (Exception e11) {
                    x.a(e11);
                }
            }
        }
    }

    private static Map<String, Integer> d(String str) {
        if (str == null) {
            return null;
        }
        try {
            HashMap hashMap = new HashMap();
            for (String str2 : str.split(",")) {
                String[] split = str2.split(u.bD);
                if (split.length != 2) {
                    x.e("error format at %s", str2);
                    return null;
                }
                hashMap.put(split[0], Integer.valueOf(Integer.parseInt(split[1])));
            }
            return hashMap;
        } catch (Exception e2) {
            x.e("error format intStateStr %s", str);
            e2.printStackTrace();
            return null;
        }
    }

    private static CrashDetailBean a(Context context, Map<String, String> map, NativeExceptionHandler nativeExceptionHandler) {
        String str;
        String str2;
        HashMap hashMap;
        if (map == null) {
            return null;
        }
        if (com.tencent.bugly.crashreport.common.info.a.a(context) == null) {
            x.e("abnormal com info not created", new Object[0]);
            return null;
        }
        String str3 = map.get("intStateStr");
        if (str3 != null && str3.trim().length() > 0) {
            Map<String, Integer> d10 = d(str3);
            if (d10 == null) {
                x.e("parse intSateMap fail", Integer.valueOf(map.size()));
                return null;
            }
            try {
                d10.get("sino").intValue();
                d10.get("sud").intValue();
                String str4 = map.get("soVersion");
                if (TextUtils.isEmpty(str4)) {
                    x.e("error format at version", new Object[0]);
                    return null;
                }
                String str5 = map.get("errorAddr");
                String str6 = "unknown";
                String str7 = str5 == null ? "unknown" : str5;
                String str8 = map.get("codeMsg");
                if (str8 == null) {
                    str8 = "unknown";
                }
                String str9 = map.get("tombPath");
                String str10 = str9 == null ? "unknown" : str9;
                String str11 = map.get("signalName");
                if (str11 == null) {
                    str11 = "unknown";
                }
                map.get("errnoMsg");
                String str12 = map.get(Attributes.Component.STACK);
                if (str12 == null) {
                    str12 = "unknown";
                }
                String str13 = map.get("jstack");
                if (str13 != null) {
                    str12 = str12 + "java:\n" + str13;
                }
                Integer num = d10.get("sico");
                if (num == null || num.intValue() <= 0) {
                    str = str8;
                    str2 = str11;
                } else {
                    str2 = str11 + "(" + str8 + ")";
                    str = "KERNEL";
                }
                String str14 = map.get("nativeLog");
                byte[] a10 = (str14 == null || str14.isEmpty()) ? null : z.a((File) null, str14, "BuglyNativeLog.txt");
                String str15 = map.get("sendingProcess");
                if (str15 == null) {
                    str15 = "unknown";
                }
                Integer num2 = d10.get("spd");
                if (num2 != null) {
                    str15 = str15 + "(" + ((Object) num2) + ")";
                }
                String str16 = str15;
                String str17 = map.get("threadName");
                if (str17 == null) {
                    str17 = "unknown";
                }
                Integer num3 = d10.get("et");
                if (num3 != null) {
                    str17 = str17 + "(" + ((Object) num3) + ")";
                }
                String str18 = str17;
                String str19 = map.get("processName");
                if (str19 != null) {
                    str6 = str19;
                }
                Integer num4 = d10.get("ep");
                if (num4 != null) {
                    str6 = str6 + "(" + ((Object) num4) + ")";
                }
                String str20 = str6;
                String str21 = map.get("key-value");
                if (str21 != null) {
                    HashMap hashMap2 = new HashMap();
                    String[] split = str21.split("\n");
                    int length = split.length;
                    int i10 = 0;
                    while (i10 < length) {
                        String[] split2 = split[i10].split("=");
                        String[] strArr = split;
                        if (split2.length == 2) {
                            hashMap2.put(split2[0], split2[1]);
                        }
                        i10++;
                        split = strArr;
                    }
                    hashMap = hashMap2;
                } else {
                    hashMap = null;
                }
                CrashDetailBean packageCrashDatas = nativeExceptionHandler.packageCrashDatas(str20, str18, (d10.get("etms").intValue() / 1000) + (d10.get("ets").intValue() * 1000), str2, str7, a(str12), str, str16, str10, map.get("sysLogPath"), map.get("jniLogPath"), str4, a10, hashMap, false, false);
                if (packageCrashDatas != null) {
                    String str22 = map.get(as.f32242q);
                    if (str22 != null) {
                        x.c("[Native record info] userId: %s", str22);
                        packageCrashDatas.f39172m = str22;
                    }
                    String str23 = map.get("sysLog");
                    if (str23 != null) {
                        packageCrashDatas.f39182w = str23;
                    }
                    String str24 = map.get(AttributionReporter.APP_VERSION);
                    if (str24 != null) {
                        x.c("[Native record info] appVersion: %s", str24);
                        packageCrashDatas.f39165f = str24;
                    }
                    String str25 = map.get("isAppForeground");
                    if (str25 != null) {
                        x.c("[Native record info] isAppForeground: %s", str25);
                        packageCrashDatas.N = str25.equalsIgnoreCase("true");
                    }
                    String str26 = map.get(AdClickConstants.ACTIVITY_LAUNCH_TIME);
                    if (str26 != null) {
                        x.c("[Native record info] launchTime: %s", str26);
                        try {
                            packageCrashDatas.M = Long.parseLong(str26);
                        } catch (NumberFormatException e2) {
                            if (!x.a(e2)) {
                                e2.printStackTrace();
                            }
                        }
                    }
                    packageCrashDatas.f39185z = null;
                    packageCrashDatas.f39170k = true;
                }
                return packageCrashDatas;
            } catch (Throwable th) {
                x.e("error format", new Object[0]);
                th.printStackTrace();
                return null;
            }
        }
        x.e("no intStateStr", new Object[0]);
        return null;
    }

    public static void c(String str) {
        File[] listFiles;
        if (str == null) {
            return;
        }
        try {
            File file = new File(str);
            if (file.canRead() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    if (file2.canRead() && file2.canWrite() && file2.length() == 0) {
                        file2.delete();
                        x.c("Delete empty record file %s", file2.getAbsoluteFile());
                    }
                }
            }
        } catch (Throwable th) {
            x.a(th);
        }
    }

    public static String b(String str) {
        if (str == null) {
            return null;
        }
        File file = new File(str, "backup_record.txt");
        if (file.exists()) {
            return file.getAbsolutePath();
        }
        return null;
    }

    private static String a(BufferedInputStream bufferedInputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream;
        if (bufferedInputStream == null) {
            return null;
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream(1024);
            while (true) {
                try {
                    int read = bufferedInputStream.read();
                    if (read == -1) {
                        byteArrayOutputStream.close();
                        break;
                    }
                    if (read == 0) {
                        String str = new String(byteArrayOutputStream.toByteArray(), "UTf-8");
                        byteArrayOutputStream.close();
                        return str;
                    }
                    byteArrayOutputStream.write(read);
                } catch (Throwable th) {
                    th = th;
                    try {
                        x.a(th);
                        return null;
                    } finally {
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            byteArrayOutputStream = null;
        }
    }

    /* JADX WARN: Type inference failed for: r7v3, types: [boolean] */
    public static CrashDetailBean a(Context context, String str, NativeExceptionHandler nativeExceptionHandler) {
        BufferedInputStream bufferedInputStream;
        String str2;
        String a10;
        AutoCloseable autoCloseable = null;
        if (context != null && str != null && nativeExceptionHandler != null) {
            File file = new File(str, "rqd_record.eup");
            if (file.exists()) {
                ?? canRead = file.canRead();
                try {
                    if (canRead != 0) {
                        try {
                            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                        } catch (IOException e2) {
                            e = e2;
                            bufferedInputStream = null;
                        } catch (Throwable th) {
                            th = th;
                            if (autoCloseable != null) {
                                try {
                                    autoCloseable.close();
                                } catch (IOException e10) {
                                    e10.printStackTrace();
                                }
                            }
                            throw th;
                        }
                        try {
                            String a11 = a(bufferedInputStream);
                            if (a11 != null && a11.equals("NATIVE_RQD_REPORT")) {
                                HashMap hashMap = new HashMap();
                                loop0: while (true) {
                                    str2 = null;
                                    while (true) {
                                        a10 = a(bufferedInputStream);
                                        if (a10 == null) {
                                            break loop0;
                                        }
                                        if (str2 == null) {
                                            str2 = a10;
                                        }
                                    }
                                    hashMap.put(str2, a10);
                                }
                                if (str2 != null) {
                                    x.e("record not pair! drop! %s", str2);
                                    try {
                                        bufferedInputStream.close();
                                    } catch (IOException e11) {
                                        e11.printStackTrace();
                                    }
                                    return null;
                                }
                                CrashDetailBean a12 = a(context, hashMap, nativeExceptionHandler);
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException e12) {
                                    e12.printStackTrace();
                                }
                                return a12;
                            }
                            x.e("record read fail! %s", a11);
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e13) {
                                e13.printStackTrace();
                            }
                            return null;
                        } catch (IOException e14) {
                            e = e14;
                            e.printStackTrace();
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException e15) {
                                    e15.printStackTrace();
                                }
                            }
                            return null;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    autoCloseable = canRead;
                }
            }
            return null;
        }
        x.e("get eup record file args error", new Object[0]);
        return null;
    }

    public static String a(String str, String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        String b4 = b(str, str2);
        if (b4 != null && !b4.isEmpty()) {
            sb2.append("Register infos:\n");
            sb2.append(b4);
        }
        String c4 = c(str, str2);
        if (c4 != null && !c4.isEmpty()) {
            if (sb2.length() > 0) {
                sb2.append("\n");
            }
            sb2.append("System SO infos:\n");
            sb2.append(c4);
        }
        return sb2.toString();
    }

    public static void a(boolean z10, String str) {
        if (str != null) {
            f39332a.add(new File(str, "rqd_record.eup"));
            f39332a.add(new File(str, "reg_record.txt"));
            f39332a.add(new File(str, "map_record.txt"));
            f39332a.add(new File(str, "backup_record.txt"));
            if (z10) {
                c(str);
            }
        }
        List<File> list = f39332a;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (File file : f39332a) {
            if (file.exists() && file.canWrite()) {
                file.delete();
                x.c("Delete record file %s", file.getAbsoluteFile());
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.lang.String] */
    public static String a(String str, int i10, String str2, boolean z10) {
        BufferedReader bufferedReader = null;
        if (str != null && i10 > 0) {
            File file = new File(str);
            if (file.exists() && file.canRead()) {
                x.a("Read system log from native record file(length: %s bytes): %s", Long.valueOf(file.length()), file.getAbsolutePath());
                f39332a.add(file);
                x.c("Add this record file to list for cleaning lastly.", new Object[0]);
                if (str2 == null) {
                    return z.a(new File(str), i10, z10);
                }
                String sb2 = new StringBuilder();
                try {
                    try {
                        BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
                        while (true) {
                            try {
                                String readLine = bufferedReader2.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                if (Pattern.compile(str2 + "[ ]*:").matcher(readLine).find()) {
                                    sb2.append(readLine);
                                    sb2.append("\n");
                                }
                                if (i10 > 0 && sb2.length() > i10) {
                                    if (z10) {
                                        sb2.delete(i10, sb2.length());
                                        break;
                                    }
                                    sb2.delete(0, sb2.length() - i10);
                                }
                            } catch (Throwable th) {
                                th = th;
                                bufferedReader = bufferedReader2;
                                try {
                                    x.a(th);
                                    sb2.append("\n[error:" + th.toString() + "]");
                                    String sb3 = sb2.toString();
                                    if (bufferedReader == null) {
                                        return sb3;
                                    }
                                    bufferedReader.close();
                                    sb2 = sb3;
                                    return sb2;
                                } catch (Throwable th2) {
                                    if (bufferedReader != null) {
                                        try {
                                            bufferedReader.close();
                                        } catch (Exception e2) {
                                            x.a(e2);
                                        }
                                    }
                                    throw th2;
                                }
                            }
                        }
                        String sb4 = sb2.toString();
                        bufferedReader2.close();
                        sb2 = sb4;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                    return sb2;
                } catch (Exception e10) {
                    x.a(e10);
                    return sb2;
                }
            }
        }
        return null;
    }
}
