package com.inno.innosdk.utils;

import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.util.Locale;

/* compiled from: CheckVirtual.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class d {
    public static String a(String str) {
        Process process;
        BufferedOutputStream bufferedOutputStream;
        BufferedInputStream bufferedInputStream = null;
        try {
            try {
                process = Runtime.getRuntime().exec("sh");
            } catch (Exception e2) {
                e = e2;
                process = null;
            } catch (Throwable th) {
                th = th;
                process = null;
            }
            try {
                bufferedOutputStream = new BufferedOutputStream(process.getOutputStream());
                try {
                    BufferedInputStream bufferedInputStream2 = new BufferedInputStream(process.getInputStream());
                    try {
                        bufferedOutputStream.write(str.getBytes());
                        bufferedOutputStream.write(10);
                        bufferedOutputStream.flush();
                        bufferedOutputStream.close();
                        process.waitFor();
                        String a10 = a(bufferedInputStream2);
                        com.inno.innosdk.utils.t.a.a(bufferedOutputStream);
                        com.inno.innosdk.utils.t.a.a((Closeable) bufferedInputStream2);
                        com.inno.innosdk.utils.t.a.a(process);
                        return a10;
                    } catch (Exception e10) {
                        e = e10;
                        bufferedInputStream = bufferedInputStream2;
                        com.inno.innosdk.utils.u.a.a((Throwable) e);
                        com.inno.innosdk.utils.t.a.a(bufferedOutputStream);
                        com.inno.innosdk.utils.t.a.a((Closeable) bufferedInputStream);
                        com.inno.innosdk.utils.t.a.a(process);
                        return "";
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedInputStream = bufferedInputStream2;
                        com.inno.innosdk.utils.t.a.a(bufferedOutputStream);
                        com.inno.innosdk.utils.t.a.a((Closeable) bufferedInputStream);
                        com.inno.innosdk.utils.t.a.a(process);
                        throw th;
                    }
                } catch (Exception e11) {
                    e = e11;
                }
            } catch (Exception e12) {
                e = e12;
                bufferedOutputStream = null;
                com.inno.innosdk.utils.u.a.a((Throwable) e);
                com.inno.innosdk.utils.t.a.a(bufferedOutputStream);
                com.inno.innosdk.utils.t.a.a((Closeable) bufferedInputStream);
                com.inno.innosdk.utils.t.a.a(process);
                return "";
            } catch (Throwable th3) {
                th = th3;
                bufferedOutputStream = null;
                com.inno.innosdk.utils.t.a.a(bufferedOutputStream);
                com.inno.innosdk.utils.t.a.a((Closeable) bufferedInputStream);
                com.inno.innosdk.utils.t.a.a(process);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public static boolean b() {
        try {
            String a10 = a();
            if (TextUtils.isEmpty(a10)) {
                return false;
            }
            String a11 = a("ps");
            if (TextUtils.isEmpty(a11)) {
                return false;
            }
            String[] split = a11.split("\n");
            if (split.length <= 0) {
                return false;
            }
            int i10 = 0;
            for (String str : split) {
                if (str.contains(a10)) {
                    int lastIndexOf = str.lastIndexOf(" ");
                    if (new File(String.format("/data/data/%s", str.substring(lastIndexOf <= 0 ? 0 : lastIndexOf + 1))).exists()) {
                        i10++;
                    }
                }
            }
            return i10 > 1;
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
            return false;
        }
    }

    public static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (int i10 = 0; i10 < str.length(); i10++) {
            if (!Character.isDigit(str.charAt(i10))) {
                return false;
            }
        }
        return true;
    }

    public static String a(BufferedInputStream bufferedInputStream) {
        int read;
        if (bufferedInputStream == null) {
            return "";
        }
        byte[] bArr = new byte[512];
        StringBuilder sb2 = new StringBuilder();
        do {
            try {
                read = bufferedInputStream.read(bArr);
                if (read > 0) {
                    sb2.append(new String(bArr, 0, read));
                }
            } catch (Exception e2) {
                com.inno.innosdk.utils.u.a.a((Throwable) e2);
            }
        } while (read >= 512);
        return sb2.toString();
    }

    public static String a() {
        String a10 = a("cat /proc/self/cgroup");
        if (TextUtils.isEmpty(a10)) {
            return null;
        }
        int lastIndexOf = a10.lastIndexOf("uid");
        int lastIndexOf2 = a10.lastIndexOf("/pid");
        if (lastIndexOf < 0) {
            return null;
        }
        if (lastIndexOf2 <= 0) {
            lastIndexOf2 = a10.length();
        }
        try {
            if (!b(a10.substring(lastIndexOf + 4, lastIndexOf2).replaceAll("\n", ""))) {
                return null;
            }
            return String.format(Locale.CHINA, "u0_a%d", Integer.valueOf(Integer.parseInt(r0) - 10000));
        } catch (Exception e2) {
            com.inno.innosdk.utils.u.a.a((Throwable) e2);
            return null;
        }
    }
}
