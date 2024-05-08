package com.huawei.quickcard.base;

import android.content.Context;
import com.huawei.quickcard.base.log.CardLogUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class CardIOUtils {

    /* renamed from: a, reason: collision with root package name */
    private static final String f33287a = "IOUtils";

    /* renamed from: b, reason: collision with root package name */
    private static final int f33288b = 4096;

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e2) {
                CardLogUtils.e("IOUtils", "An exception occurred while closing the 'Closeable' object.", e2);
            }
        }
    }

    public static long copy(InputStream inputStream, OutputStream outputStream, byte[] bArr) throws IOException {
        long j10 = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return j10;
            }
            outputStream.write(bArr, 0, read);
            j10 += read;
        }
    }

    public static String readAsset(Context context, String str) {
        String str2;
        InputStream inputStream = null;
        try {
            try {
                inputStream = context.getAssets().open(str);
                str2 = toString(inputStream, "UTF-8");
            } catch (IOException e2) {
                CardLogUtils.e("IOUtils", "read asset err", e2);
                str2 = "";
            }
            return str2;
        } finally {
            closeQuietly(inputStream);
        }
    }

    public static byte[] toByteArray(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        copy(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static String toString(InputStream inputStream, String str) throws UnsupportedEncodingException, IOException {
        StringWriter stringWriter = new StringWriter();
        copy(new InputStreamReader(inputStream, str), stringWriter);
        return stringWriter.toString();
    }

    public static long copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        return copy(inputStream, outputStream, new byte[4096]);
    }

    public static long copy(InputStream inputStream, File file) throws IOException {
        FileOutputStream fileOutputStream;
        if (inputStream == null || file == null) {
            return 0L;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(file);
        } catch (Throwable th) {
            th = th;
        }
        try {
            long copy = copy(inputStream, fileOutputStream);
            closeQuietly(fileOutputStream);
            return copy;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            closeQuietly(fileOutputStream2);
            throw th;
        }
    }

    public static byte[] toByteArray(InputStream inputStream, int i10) throws IOException {
        if (i10 < 0) {
            throw new IllegalArgumentException("size must not be less than zero.");
        }
        int i11 = 0;
        if (i10 == 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[i10];
        while (i11 < i10) {
            int read = inputStream.read(bArr, i11, i10 - i11);
            if (read == -1) {
                break;
            }
            i11 += read;
        }
        if (i11 == i10) {
            return bArr;
        }
        throw new IOException("Unexpected readed size, excepted: " + i10 + ", current: " + i11);
    }

    public static void copy(File file, File file2) throws IOException {
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream;
        if (file == null || file2 == null) {
            return;
        }
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedInputStream = null;
        }
        try {
            copy(bufferedInputStream, bufferedOutputStream);
            closeQuietly(bufferedInputStream);
            closeQuietly(bufferedOutputStream);
        } catch (Throwable th3) {
            th = th3;
            bufferedOutputStream2 = bufferedOutputStream;
            closeQuietly(bufferedInputStream);
            closeQuietly(bufferedOutputStream2);
            throw th;
        }
    }

    public static long copy(Reader reader, Writer writer, char[] cArr) throws IOException {
        long j10 = 0;
        while (true) {
            int read = reader.read(cArr);
            if (read == -1) {
                return j10;
            }
            writer.write(cArr, 0, read);
            j10 += read;
        }
    }

    public static long copy(Reader reader, Writer writer) throws IOException {
        return copy(reader, writer, new char[4096]);
    }
}
