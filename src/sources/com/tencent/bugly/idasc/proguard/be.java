package com.tencent.bugly.idasc.proguard;

import android.content.Context;
import com.alimm.tanx.core.constant.AdClickConstants;
import com.tencent.bugly.idasc.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.idasc.crashreport.crash.jni.NativeExceptionHandler;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class be {

    /* renamed from: a, reason: collision with root package name */
    private static List<File> f39742a = new ArrayList();

    /* JADX WARN: Type inference failed for: r7v3, types: [boolean] */
    public static CrashDetailBean a(Context context, String str, NativeExceptionHandler nativeExceptionHandler) {
        BufferedInputStream bufferedInputStream;
        String str2;
        String a10;
        AutoCloseable autoCloseable = null;
        if (context == null || str == null || nativeExceptionHandler == null) {
            al.e("get eup record file args error", new Object[0]);
            return null;
        }
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
                                al.e("record not pair! drop! %s", str2);
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
                        al.e("record read fail! %s", a11);
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

    /* JADX WARN: Removed duplicated region for block: B:7:0x0037 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0038  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.tencent.bugly.idasc.crashreport.crash.CrashDetailBean a(android.content.Context r25, java.util.Map<java.lang.String, java.lang.String> r26, com.tencent.bugly.idasc.crashreport.crash.jni.NativeExceptionHandler r27) {
        /*
            Method dump skipped, instructions count: 583
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.idasc.proguard.be.a(android.content.Context, java.util.Map, com.tencent.bugly.idasc.crashreport.crash.jni.NativeExceptionHandler):com.tencent.bugly.idasc.crashreport.crash.CrashDetailBean");
    }

    private static <KeyT, ValueT> ValueT a(Map<KeyT, ValueT> map, KeyT keyt, ValueT valuet) {
        ValueT valuet2;
        try {
            valuet2 = map.get(keyt);
        } catch (Exception e2) {
            al.a(e2);
        }
        return valuet2 != null ? valuet2 : valuet;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0030, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String a(java.io.BufferedInputStream r4) throws java.io.IOException {
        /*
            r0 = 0
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L26
            r2 = 1024(0x400, float:1.435E-42)
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L26
        L8:
            int r2 = r4.read()     // Catch: java.lang.Throwable -> L24
            r3 = -1
            if (r2 == r3) goto L2d
            if (r2 != 0) goto L20
            java.lang.String r4 = new java.lang.String     // Catch: java.lang.Throwable -> L24
            byte[] r2 = r1.toByteArray()     // Catch: java.lang.Throwable -> L24
            java.lang.String r3 = "UTf-8"
            r4.<init>(r2, r3)     // Catch: java.lang.Throwable -> L24
            r1.close()
            return r4
        L20:
            r1.write(r2)     // Catch: java.lang.Throwable -> L24
            goto L8
        L24:
            r4 = move-exception
            goto L28
        L26:
            r4 = move-exception
            r1 = r0
        L28:
            com.tencent.bugly.idasc.proguard.al.a(r4)     // Catch: java.lang.Throwable -> L31
            if (r1 == 0) goto L30
        L2d:
            r1.close()
        L30:
            return r0
        L31:
            r4 = move-exception
            if (r1 == 0) goto L37
            r1.close()
        L37:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.idasc.proguard.be.a(java.io.BufferedInputStream):java.lang.String");
    }

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
                al.a("Read system log from native record file(length: %s bytes): %s", Long.valueOf(file.length()), file.getAbsolutePath());
                f39742a.add(file);
                al.c("Add this record file to list for cleaning lastly.", new Object[0]);
                if (str2 == null) {
                    return ap.a(new File(str), i10, z10);
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
                                    al.a(th);
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
                                            al.a(e2);
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
                    al.a(e10);
                    return sb2;
                }
            }
        }
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

    private static Map<String, String> a(Map<String, String> map) {
        String str = map.get("key-value");
        if (str == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (String str2 : str.split("\n")) {
            String[] split = str2.split("=");
            if (split.length == 2) {
                hashMap.put(split[0], split[1]);
            }
        }
        return hashMap;
    }

    public static void a(boolean z10, String str) {
        if (str != null) {
            f39742a.add(new File(str, "rqd_record.eup"));
            f39742a.add(new File(str, "reg_record.txt"));
            f39742a.add(new File(str, "map_record.txt"));
            f39742a.add(new File(str, "backup_record.txt"));
            if (z10) {
                c(str);
            }
        }
        List<File> list = f39742a;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (File file : f39742a) {
            if (file.exists() && file.canWrite()) {
                file.delete();
                al.c("Delete record file %s", file.getAbsoluteFile());
            }
        }
    }

    private static long b(Map<String, String> map) {
        String str = map.get(AdClickConstants.ACTIVITY_LAUNCH_TIME);
        if (str == null) {
            return -1L;
        }
        al.c("[Native record info] launchTime: %s", str);
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e2) {
            if (al.a(e2)) {
                return -1L;
            }
            e2.printStackTrace();
            return -1L;
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

    private static String b(String str, String str2) {
        String substring;
        BufferedReader b4 = ap.b(str, "reg_record.txt");
        if (b4 == null) {
            return null;
        }
        try {
            StringBuilder sb2 = new StringBuilder();
            String readLine = b4.readLine();
            if (readLine != null && readLine.startsWith(str2)) {
                int i10 = 18;
                int i11 = 0;
                int i12 = 0;
                while (true) {
                    String readLine2 = b4.readLine();
                    if (readLine2 == null) {
                        break;
                    }
                    if (i11 % 4 == 0) {
                        if (i11 > 0) {
                            sb2.append("\n");
                        }
                        substring = "  ";
                    } else {
                        if (readLine2.length() > 16) {
                            i10 = 28;
                        }
                        substring = "                ".substring(0, i10 - i12);
                    }
                    sb2.append(substring);
                    i12 = readLine2.length();
                    sb2.append(readLine2);
                    i11++;
                }
                sb2.append("\n");
                return sb2.toString();
            }
            try {
                b4.close();
            } catch (Exception e2) {
                al.a(e2);
            }
            return null;
        } catch (Throwable th) {
            try {
                al.a(th);
                try {
                    b4.close();
                } catch (Exception e10) {
                    al.a(e10);
                }
                return null;
            } finally {
                try {
                    b4.close();
                } catch (Exception e11) {
                    al.a(e11);
                }
            }
        }
    }

    private static String c(String str, String str2) {
        BufferedReader b4 = ap.b(str, "map_record.txt");
        if (b4 == null) {
            return null;
        }
        try {
            StringBuilder sb2 = new StringBuilder();
            String readLine = b4.readLine();
            if (readLine != null && readLine.startsWith(str2)) {
                while (true) {
                    String readLine2 = b4.readLine();
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
                b4.close();
            } catch (Exception e2) {
                al.a(e2);
            }
            return null;
        } catch (Throwable th) {
            try {
                al.a(th);
                try {
                    b4.close();
                } catch (Exception e10) {
                    al.a(e10);
                }
                return null;
            } finally {
                try {
                    b4.close();
                } catch (Exception e11) {
                    al.a(e11);
                }
            }
        }
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
                        al.c("Delete empty record file %s", file2.getAbsoluteFile());
                    }
                }
            }
        } catch (Throwable th) {
            al.a(th);
        }
    }

    private static Map<String, Integer> d(String str) {
        if (str == null) {
            return null;
        }
        try {
            HashMap hashMap = new HashMap();
            for (String str2 : str.split(",")) {
                String[] split = str2.split(com.huawei.openalliance.ad.constant.u.bD);
                if (split.length != 2) {
                    al.e("error format at %s", str2);
                    return null;
                }
                hashMap.put(split[0], Integer.valueOf(Integer.parseInt(split[1])));
            }
            return hashMap;
        } catch (Exception e2) {
            al.e("error format intStateStr %s", str);
            e2.printStackTrace();
            return null;
        }
    }
}
