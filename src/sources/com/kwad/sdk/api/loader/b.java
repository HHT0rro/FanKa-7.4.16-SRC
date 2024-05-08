package com.kwad.sdk.api.loader;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final class b {
    private static void I(String str, String str2) {
        File file = new File(str2);
        if (file.exists()) {
            h.j(file);
        }
        d(new FileInputStream(str), new FileOutputStream(file, false));
    }

    private static void J(String str, String str2) {
        ZipFile zipFile;
        String str3 = w.is64Bit() ? "lib/arm64-v8a/" : "lib/armeabi-v7a/";
        ZipFile zipFile2 = null;
        try {
            zipFile = new ZipFile(str);
        } catch (Throwable th) {
            th = th;
        }
        try {
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry nextElement = entries.nextElement();
                if (!nextElement.isDirectory()) {
                    String name = nextElement.getName();
                    if (!TextUtils.isEmpty(name) && !name.contains("../") && name.endsWith(".so") && name.startsWith(str3)) {
                        d(zipFile.getInputStream(nextElement), new FileOutputStream(new File(str2, name.substring(str3.length()))));
                    }
                }
            }
            try {
                zipFile.close();
            } catch (Exception unused) {
            }
        } catch (Throwable th2) {
            th = th2;
            zipFile2 = zipFile;
            if (zipFile2 != null) {
                try {
                    zipFile2.close();
                } catch (Exception unused2) {
                }
            }
            throw th;
        }
    }

    public static boolean a(Context context, ClassLoader classLoader, String str, String str2) {
        String q10 = h.q(context, str2);
        h(new File(q10));
        String s2 = h.s(context, str2);
        String t2 = h.t(context, str2);
        String u10 = h.u(context, str2);
        try {
            I(str, s2);
            J(str, u10);
            return k.b(context, classLoader, s2, t2, u10).Af() != null;
        } catch (Exception e2) {
            h(new File(s2));
            h(new File(t2));
            h(new File(u10));
            h(new File(q10));
            throw e2;
        }
    }

    private static void c(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return;
            } else {
                outputStream.write(bArr, 0, read);
            }
        }
    }

    private static void d(InputStream inputStream, OutputStream outputStream) {
        try {
            c(inputStream, outputStream);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception unused) {
                }
            }
            try {
                outputStream.close();
            } catch (Exception unused2) {
            }
        } finally {
        }
    }

    private static void h(File file) {
        if (file.isFile()) {
            file.delete();
            return;
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null || listFiles.length <= 0) {
            return;
        }
        for (File file2 : listFiles) {
            h(file2);
        }
    }
}
