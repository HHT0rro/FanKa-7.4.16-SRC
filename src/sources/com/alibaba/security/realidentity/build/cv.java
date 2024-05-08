package com.alibaba.security.realidentity.build;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringWriter;

/* compiled from: IOUtils.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class cv {

    /* renamed from: a, reason: collision with root package name */
    private static final int f3380a = 4096;

    public static String a(InputStream inputStream, String str) throws IOException {
        if (inputStream == null) {
            return "";
        }
        BufferedReader bufferedReader = null;
        StringWriter stringWriter = new StringWriter();
        char[] cArr = new char[4096];
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(inputStream, str));
            while (true) {
                try {
                    int read = bufferedReader2.read(cArr);
                    if (read > 0) {
                        stringWriter.write(cArr, 0, read);
                    } else {
                        String obj = stringWriter.toString();
                        b(inputStream);
                        bufferedReader2.close();
                        stringWriter.close();
                        return obj;
                    }
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    b(inputStream);
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    stringWriter.close();
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static void b(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    private static byte[] a(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (read < 0) {
                break;
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
        byteArrayOutputStream.flush();
        try {
            byteArrayOutputStream.close();
        } catch (IOException unused) {
        }
        return byteArrayOutputStream.toByteArray();
    }

    private static byte[] a(InputStream inputStream, int i10) throws IOException {
        int read;
        if (inputStream == null) {
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[4096];
        long j10 = 0;
        while (true) {
            long j11 = i10;
            if (j10 >= j11 || (read = inputStream.read(bArr, 0, Math.min(2048, (int) (j11 - j10)))) < 0) {
                break;
            }
            byteArrayOutputStream.write(bArr, 0, read);
            j10 += read;
        }
        byteArrayOutputStream.flush();
        try {
            byteArrayOutputStream.close();
        } catch (IOException unused) {
        }
        return byteArrayOutputStream.toByteArray();
    }

    private static void a(OutputStream outputStream) {
        try {
            outputStream.close();
        } catch (IOException unused) {
        }
    }
}
