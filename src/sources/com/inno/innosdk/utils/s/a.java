package com.inno.innosdk.utils.s;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;

/* compiled from: CommonUtils.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class a {
    public static String a(String str) {
        Process process;
        BufferedOutputStream bufferedOutputStream;
        String a10;
        BufferedInputStream bufferedInputStream = null;
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
                try {
                    BufferedInputStream bufferedInputStream2 = new BufferedInputStream(process.getInputStream());
                    try {
                        bufferedOutputStream.write(str.getBytes());
                        bufferedOutputStream.write(10);
                        bufferedOutputStream.flush();
                        bufferedOutputStream.close();
                        int waitFor = process.waitFor();
                        if (waitFor != 0) {
                            a10 = String.valueOf(waitFor);
                        } else {
                            a10 = a(bufferedInputStream2);
                        }
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
                        return "-1";
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedInputStream = bufferedInputStream2;
                        com.inno.innosdk.utils.t.a.a(bufferedOutputStream);
                        com.inno.innosdk.utils.t.a.a((Closeable) bufferedInputStream);
                        com.inno.innosdk.utils.t.a.a(process);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
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
            return "-1";
        } catch (Throwable th4) {
            th = th4;
            bufferedOutputStream = null;
            com.inno.innosdk.utils.t.a.a(bufferedOutputStream);
            com.inno.innosdk.utils.t.a.a((Closeable) bufferedInputStream);
            com.inno.innosdk.utils.t.a.a(process);
            throw th;
        }
    }

    public static String b(String str) {
        return null;
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
                e2.printStackTrace();
            }
        } while (read >= 512);
        return sb2.toString();
    }
}
