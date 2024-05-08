package com.xiaomi.push;

import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.util.Date;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class s7 {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f48152a = {"jpg", "png", "bmp", "gif", "webp"};

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0062: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:22:0x0062 */
    public static String a(File file) {
        InputStreamReader inputStreamReader;
        Closeable closeable;
        StringWriter stringWriter = new StringWriter();
        Closeable closeable2 = null;
        try {
            try {
                inputStreamReader = new InputStreamReader(new BufferedInputStream(new FileInputStream(file)));
            } catch (IOException e2) {
                e = e2;
                inputStreamReader = null;
            } catch (Throwable th) {
                th = th;
                b(closeable2);
                b(stringWriter);
                throw th;
            }
            try {
                char[] cArr = new char[2048];
                while (true) {
                    int read = inputStreamReader.read(cArr);
                    if (read == -1) {
                        String stringWriter2 = stringWriter.toString();
                        b(inputStreamReader);
                        b(stringWriter);
                        return stringWriter2;
                    }
                    stringWriter.write(cArr, 0, read);
                }
            } catch (IOException e10) {
                e = e10;
                fc.c.m("read file :" + file.getAbsolutePath() + " failure :" + e.getMessage());
                b(inputStreamReader);
                b(stringWriter);
                return null;
            }
        } catch (Throwable th2) {
            th = th2;
            closeable2 = closeable;
            b(closeable2);
            b(stringWriter);
            throw th;
        }
    }

    public static void b(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public static void c(File file) {
        if (file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                c(file2);
            }
        } else if (!file.exists()) {
            return;
        }
        file.delete();
    }

    public static void d(File file, File file2) {
        ZipOutputStream zipOutputStream;
        ZipOutputStream zipOutputStream2 = null;
        try {
            try {
                zipOutputStream = new ZipOutputStream(new FileOutputStream(file, false));
            } catch (FileNotFoundException unused) {
                b(zipOutputStream2);
            } catch (IOException e2) {
                e = e2;
            }
            try {
                f(zipOutputStream, file2, null, null);
                b(zipOutputStream);
            } catch (FileNotFoundException unused2) {
                zipOutputStream2 = zipOutputStream;
                b(zipOutputStream2);
            } catch (IOException e10) {
                e = e10;
                zipOutputStream2 = zipOutputStream;
                fc.c.i("zip file failure + " + e.getMessage());
                b(zipOutputStream2);
            } catch (Throwable th) {
                th = th;
                zipOutputStream2 = zipOutputStream;
                b(zipOutputStream2);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void e(File file, String str) {
        if (!file.exists()) {
            fc.c.m("mkdir " + file.getAbsolutePath());
            file.getParentFile().mkdirs();
        }
        BufferedWriter bufferedWriter = null;
        try {
            try {
                BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
                try {
                    bufferedWriter2.write(str);
                    b(bufferedWriter2);
                } catch (IOException e2) {
                    e = e2;
                    bufferedWriter = bufferedWriter2;
                    fc.c.m("write file :" + file.getAbsolutePath() + " failure :" + e.getMessage());
                    b(bufferedWriter);
                } catch (Throwable th) {
                    th = th;
                    bufferedWriter = bufferedWriter2;
                    b(bufferedWriter);
                    throw th;
                }
            } catch (IOException e10) {
                e = e10;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void f(ZipOutputStream zipOutputStream, File file, String str, FileFilter fileFilter) {
        String str2 = "";
        if (str == null) {
            str = "";
        }
        FileInputStream fileInputStream = null;
        try {
            try {
                if (file.isDirectory()) {
                    File[] listFiles = fileFilter != null ? file.listFiles(fileFilter) : file.listFiles();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str);
                    String str3 = File.separator;
                    sb2.append(str3);
                    zipOutputStream.putNextEntry(new ZipEntry(sb2.toString()));
                    if (!TextUtils.isEmpty(str)) {
                        str2 = str + str3;
                    }
                    for (int i10 = 0; i10 < listFiles.length; i10++) {
                        f(zipOutputStream, listFiles[i10], str2 + listFiles[i10].getName(), null);
                    }
                    File[] listFiles2 = file.listFiles(new t7());
                    if (listFiles2 != null) {
                        for (File file2 : listFiles2) {
                            f(zipOutputStream, file2, str2 + File.separator + file2.getName(), fileFilter);
                        }
                    }
                } else {
                    zipOutputStream.putNextEntry(TextUtils.isEmpty(str) ? new ZipEntry(String.valueOf(new Date().getTime()) + ".txt") : new ZipEntry(str));
                    FileInputStream fileInputStream2 = new FileInputStream(file);
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = fileInputStream2.read(bArr);
                            if (read == -1) {
                                break;
                            } else {
                                zipOutputStream.write(bArr, 0, read);
                            }
                        }
                        fileInputStream = fileInputStream2;
                    } catch (IOException e2) {
                        e = e2;
                        fileInputStream = fileInputStream2;
                        fc.c.n("zipFiction failed with exception:" + e.toString());
                        b(fileInputStream);
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream = fileInputStream2;
                        b(fileInputStream);
                        throw th;
                    }
                }
            } catch (IOException e10) {
                e = e10;
            }
            b(fileInputStream);
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean g(File file) {
        try {
            if (file.isDirectory()) {
                return false;
            }
            if (file.exists()) {
                return true;
            }
            File parentFile = file.getParentFile();
            if (parentFile.exists() || parentFile.mkdirs()) {
                return file.createNewFile();
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static byte[] h(byte[] bArr) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.finish();
            gZIPOutputStream.close();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Exception unused) {
            return bArr;
        }
    }

    public static void i(File file, File file2) {
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
        if (file.getAbsolutePath().equals(file2.getAbsolutePath())) {
            return;
        }
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
            } catch (Throwable th) {
                th = th;
                fileOutputStream = null;
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read < 0) {
                    fileInputStream.close();
                    fileOutputStream.close();
                    return;
                }
                fileOutputStream.write(bArr, 0, read);
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw th;
        }
    }
}
