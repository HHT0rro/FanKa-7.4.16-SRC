package com.kwad.sdk.utils.a;

import java.io.Closeable;
import java.io.File;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.SecureRandom;
import sun.misc.Unsafe;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class h {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a {
        public static final SecureRandom aSh = new SecureRandom();
        public static final char[] aSi = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    public static String NP() {
        byte[] bArr = new byte[16];
        a.aSh.nextBytes(bArr);
        char[] cArr = new char[32];
        for (int i10 = 0; i10 < 16; i10++) {
            byte b4 = bArr[i10];
            int i11 = i10 << 1;
            char[] cArr2 = a.aSi;
            cArr[i11] = cArr2[(b4 >> 4) & 15];
            cArr[i11 + 1] = cArr2[b4 & 15];
        }
        return new String(cArr);
    }

    public static int NQ() {
        try {
            Field declaredField = Unsafe.class.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            Method declaredMethod = Unsafe.class.getDeclaredMethod("pageSize", new Class[0]);
            declaredMethod.setAccessible(true);
            return ((Integer) declaredMethod.invoke(declaredField.get(null), new Object[0])).intValue();
        } catch (Throwable unused) {
            return 4096;
        }
    }

    public static void a(File file, byte[] bArr, int i10) {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        int i11 = 0;
        while (i11 < i10) {
            try {
                int read = randomAccessFile.read(bArr, i11, i10 - i11);
                if (read < 0) {
                    break;
                } else {
                    i11 += read;
                }
            } finally {
                closeQuietly(randomAccessFile);
            }
        }
    }

    public static boolean ae(File file) {
        if (file.isFile()) {
            return true;
        }
        File parentFile = file.getParentFile();
        if (parentFile != null) {
            return (parentFile.isDirectory() || parentFile.mkdirs()) && file.createNewFile();
        }
        return false;
    }

    public static byte[] af(File file) {
        if (!file.isFile()) {
            return null;
        }
        long length = file.length();
        if ((length >> 32) == 0) {
            int i10 = (int) length;
            byte[] bArr = new byte[i10];
            a(file, bArr, i10);
            return bArr;
        }
        throw new IllegalArgumentException("file too large, path:" + file.getPath());
    }

    private static void ag(File file) {
        File[] listFiles;
        if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                ag(file2);
            }
        }
        file.delete();
    }

    public static int binarySearch(int[] iArr, int i10) {
        int length = (iArr.length >> 1) - 1;
        int i11 = 0;
        while (i11 <= length) {
            int i12 = (i11 + length) >>> 1;
            int i13 = iArr[i12 << 1];
            if (i13 < i10) {
                i11 = i12 + 1;
            } else {
                if (i13 <= i10) {
                    return i12;
                }
                length = i12 - 1;
            }
        }
        return length;
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public static void h(File file) {
        try {
            if (file.exists()) {
                ag(file);
            }
        } catch (Exception unused) {
        }
    }

    public static boolean a(File file, byte[] bArr) {
        File file2;
        try {
            file2 = new File(file.getParent(), file.getName() + ".tmp");
        } catch (Exception unused) {
        }
        if (!ae(file2)) {
            return false;
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rw");
        try {
            randomAccessFile.setLength(bArr.length);
            randomAccessFile.write(bArr);
            closeQuietly(randomAccessFile);
            if (!file.exists() || file.delete()) {
                return file2.renameTo(file);
            }
            return false;
        } catch (Throwable th) {
            closeQuietly(randomAccessFile);
            throw th;
        }
    }
}
