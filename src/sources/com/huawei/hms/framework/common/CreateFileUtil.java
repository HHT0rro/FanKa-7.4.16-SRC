package com.huawei.hms.framework.common;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.libcore.io.ExternalStorageFile;
import com.huawei.libcore.io.ExternalStorageFileInputStream;
import com.huawei.libcore.io.ExternalStorageFileOutputStream;
import com.huawei.libcore.io.ExternalStorageRandomAccessFile;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class CreateFileUtil {
    private static final String EXTERNAL_FILE_NAME = "com.huawei.libcore.io.ExternalStorageFile";
    private static final String EXTERNAL_INPUTSTREAM_NAME = "com.huawei.libcore.io.ExternalStorageFileInputStream";
    private static final String EXTERNAL_OUTPUTSTREAM_NAME = "com.huawei.libcore.io.ExternalStorageFileOutputStream";
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final String RANDOM_ACCESS_FILE_NAME = "com.huawei.libcore.io.ExternalStorageRandomAccessFile";
    private static final String TAG = "CreateFileUtil";

    public static String byteArrayToHex(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        int i10 = 0;
        for (byte b4 : bArr) {
            int i11 = i10 + 1;
            char[] cArr2 = HEX_DIGITS;
            cArr[i10] = cArr2[(b4 >>> 4) & 15];
            i10 = i11 + 1;
            cArr[i11] = cArr2[b4 & 15];
        }
        return new String(cArr);
    }

    public static void deleteSecure(File file) {
        if (file == null || !file.exists() || file.delete()) {
            return;
        }
        Logger.w(TAG, "deleteSecure exception");
    }

    public static String getCacheDirPath(Context context) {
        return context == null ? "" : ContextCompat.getProtectedStorageContext(context).getCacheDir().getPath();
    }

    public static String getCanonicalPath(String str) {
        try {
            return newFile(str).getCanonicalPath();
        } catch (IOException e2) {
            Logger.w(TAG, "the canonicalPath has IOException", e2);
            return str;
        } catch (SecurityException e10) {
            Logger.w(TAG, "the canonicalPath has securityException", e10);
            return str;
        } catch (Exception e11) {
            Logger.w(TAG, "the canonicalPath has other Exception", e11);
            return str;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0074, code lost:
    
        if (r10 == null) goto L54;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getFileHashData(java.lang.String r10, java.lang.String r11) {
        /*
            java.lang.String r0 = "Close FileInputStream failed!"
            java.lang.String r1 = "CreateFileUtil"
            r2 = 0
            java.security.MessageDigest r11 = java.security.MessageDigest.getInstance(r11)     // Catch: java.lang.Throwable -> L43 java.lang.IndexOutOfBoundsException -> L45 java.lang.IllegalArgumentException -> L4f java.io.IOException -> L59 java.io.FileNotFoundException -> L63 java.security.NoSuchAlgorithmException -> L6d
            java.io.FileInputStream r10 = newSafeFileInputStream(r10)     // Catch: java.lang.Throwable -> L43 java.lang.IndexOutOfBoundsException -> L45 java.lang.IllegalArgumentException -> L4f java.io.IOException -> L59 java.io.FileNotFoundException -> L63 java.security.NoSuchAlgorithmException -> L6d
            r3 = 1024(0x400, float:1.435E-42)
            byte[] r3 = new byte[r3]     // Catch: java.lang.Throwable -> L36 java.lang.IndexOutOfBoundsException -> L39 java.lang.IllegalArgumentException -> L3b java.io.IOException -> L3d java.io.FileNotFoundException -> L3f java.security.NoSuchAlgorithmException -> L41
            r4 = 0
            r6 = r4
        L14:
            int r8 = r10.read(r3)     // Catch: java.lang.Throwable -> L36 java.lang.IndexOutOfBoundsException -> L39 java.lang.IllegalArgumentException -> L3b java.io.IOException -> L3d java.io.FileNotFoundException -> L3f java.security.NoSuchAlgorithmException -> L41
            r9 = -1
            if (r8 == r9) goto L22
            r9 = 0
            r11.update(r3, r9, r8)     // Catch: java.lang.Throwable -> L36 java.lang.IndexOutOfBoundsException -> L39 java.lang.IllegalArgumentException -> L3b java.io.IOException -> L3d java.io.FileNotFoundException -> L3f java.security.NoSuchAlgorithmException -> L41
            long r8 = (long) r8     // Catch: java.lang.Throwable -> L36 java.lang.IndexOutOfBoundsException -> L39 java.lang.IllegalArgumentException -> L3b java.io.IOException -> L3d java.io.FileNotFoundException -> L3f java.security.NoSuchAlgorithmException -> L41
            long r6 = r6 + r8
            goto L14
        L22:
            int r3 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r3 <= 0) goto L2e
            byte[] r11 = r11.digest()     // Catch: java.lang.Throwable -> L36 java.lang.IndexOutOfBoundsException -> L39 java.lang.IllegalArgumentException -> L3b java.io.IOException -> L3d java.io.FileNotFoundException -> L3f java.security.NoSuchAlgorithmException -> L41
            java.lang.String r2 = byteArrayToHex(r11)     // Catch: java.lang.Throwable -> L36 java.lang.IndexOutOfBoundsException -> L39 java.lang.IllegalArgumentException -> L3b java.io.IOException -> L3d java.io.FileNotFoundException -> L3f java.security.NoSuchAlgorithmException -> L41
        L2e:
            r10.close()     // Catch: java.io.IOException -> L32
            goto L77
        L32:
            com.huawei.hms.framework.common.Logger.e(r1, r0)
            goto L77
        L36:
            r11 = move-exception
            r2 = r10
            goto L78
        L39:
            r11 = move-exception
            goto L47
        L3b:
            r11 = move-exception
            goto L51
        L3d:
            r11 = move-exception
            goto L5b
        L3f:
            r11 = move-exception
            goto L65
        L41:
            r11 = move-exception
            goto L6f
        L43:
            r11 = move-exception
            goto L78
        L45:
            r11 = move-exception
            r10 = r2
        L47:
            java.lang.String r3 = "getFileHashData IndexOutOfBoundsException"
            com.huawei.hms.framework.common.Logger.e(r1, r3, r11)     // Catch: java.lang.Throwable -> L36
            if (r10 == 0) goto L77
            goto L2e
        L4f:
            r11 = move-exception
            r10 = r2
        L51:
            java.lang.String r3 = "getFileHashData IllegalArgumentException"
            com.huawei.hms.framework.common.Logger.e(r1, r3, r11)     // Catch: java.lang.Throwable -> L36
            if (r10 == 0) goto L77
            goto L2e
        L59:
            r11 = move-exception
            r10 = r2
        L5b:
            java.lang.String r3 = "getFileHashData IOException"
            com.huawei.hms.framework.common.Logger.e(r1, r3, r11)     // Catch: java.lang.Throwable -> L36
            if (r10 == 0) goto L77
            goto L2e
        L63:
            r11 = move-exception
            r10 = r2
        L65:
            java.lang.String r3 = "getFileHashData FileNotFoundException"
            com.huawei.hms.framework.common.Logger.e(r1, r3, r11)     // Catch: java.lang.Throwable -> L36
            if (r10 == 0) goto L77
            goto L2e
        L6d:
            r11 = move-exception
            r10 = r2
        L6f:
            java.lang.String r3 = "getFileHashData NoSuchAlgorithmException"
            com.huawei.hms.framework.common.Logger.e(r1, r3, r11)     // Catch: java.lang.Throwable -> L36
            if (r10 == 0) goto L77
            goto L2e
        L77:
            return r2
        L78:
            if (r2 == 0) goto L81
            r2.close()     // Catch: java.io.IOException -> L7e
            goto L81
        L7e:
            com.huawei.hms.framework.common.Logger.e(r1, r0)
        L81:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.common.CreateFileUtil.getFileHashData(java.lang.String, java.lang.String):java.lang.String");
    }

    @Deprecated
    public static boolean isPVersion() {
        return EmuiUtil.isUpPVersion();
    }

    public static File newFile(String str) {
        if (str == null) {
            return null;
        }
        if (EmuiUtil.isUpPVersion() && ReflectionUtils.checkCompatible(EXTERNAL_FILE_NAME)) {
            return new ExternalStorageFile(str);
        }
        return new File(str);
    }

    public static FileInputStream newFileInputStream(String str) throws FileNotFoundException {
        if (str != null) {
            if (EmuiUtil.isUpPVersion() && ReflectionUtils.checkCompatible(EXTERNAL_INPUTSTREAM_NAME)) {
                return new ExternalStorageFileInputStream(str);
            }
            return new FileInputStream(str);
        }
        Logger.w(TAG, "newFileInputStream  file is null");
        throw new FileNotFoundException("file is null");
    }

    public static FileOutputStream newFileOutputStream(File file) throws FileNotFoundException {
        if (file != null) {
            if (EmuiUtil.isUpPVersion() && ReflectionUtils.checkCompatible(EXTERNAL_OUTPUTSTREAM_NAME)) {
                return new ExternalStorageFileOutputStream(file);
            }
            return new FileOutputStream(file);
        }
        Logger.e(TAG, "newFileOutputStream  file is null");
        throw new FileNotFoundException("file is null");
    }

    public static RandomAccessFile newRandomAccessFile(String str, String str2) throws FileNotFoundException {
        if (str != null) {
            if (EmuiUtil.isUpPVersion() && ReflectionUtils.checkCompatible(RANDOM_ACCESS_FILE_NAME)) {
                return new ExternalStorageRandomAccessFile(str, str2);
            }
            return new RandomAccessFile(str, str2);
        }
        Logger.w(TAG, "newFileOutputStream  file is null");
        throw new FileNotFoundException("file is null");
    }

    public static File newSafeFile(String str) {
        if (str == null) {
            return null;
        }
        try {
            File newFile = newFile(str);
            return !newFile.exists() ? new File(str) : newFile;
        } catch (RuntimeException unused) {
            Logger.w(TAG, "newFile is runtimeException");
            return new File(str);
        } catch (Throwable unused2) {
            Logger.w(TAG, "newFile is Throwable");
            return new File(str);
        }
    }

    public static FileInputStream newSafeFileInputStream(String str) throws FileNotFoundException {
        try {
            return newFileInputStream(str);
        } catch (FileNotFoundException unused) {
            Logger.w(TAG, "newFileInputStream is fileNotFoundException");
            return new FileInputStream(str);
        } catch (RuntimeException unused2) {
            Logger.w(TAG, "newFileInputStream is runtimeException");
            return new FileInputStream(str);
        } catch (Throwable unused3) {
            Logger.w(TAG, "newFileInputStream is Throwable");
            return new FileInputStream(str);
        }
    }

    public static FileOutputStream newSafeFileOutputStream(File file) throws FileNotFoundException {
        try {
            return newFileOutputStream(file);
        } catch (FileNotFoundException unused) {
            Logger.w(TAG, "newFileOutputStream is fileNotFoundException");
            return new FileOutputStream(file);
        } catch (RuntimeException unused2) {
            Logger.w(TAG, "newFileOutputStream is runtimeException");
            return new FileOutputStream(file);
        } catch (Throwable unused3) {
            Logger.w(TAG, "newFileOutputStream is Throwable");
            return new FileOutputStream(file);
        }
    }

    public static RandomAccessFile newSafeRandomAccessFile(String str, String str2) throws FileNotFoundException {
        if (str != null) {
            try {
                return newRandomAccessFile(str, str2);
            } catch (FileNotFoundException unused) {
                Logger.w(TAG, "newRandomAccessFile is fileNotFoundException");
                return new RandomAccessFile(str, str2);
            } catch (RuntimeException unused2) {
                Logger.w(TAG, "newRandomAccessFile is runtimeException");
                return new RandomAccessFile(str, str2);
            } catch (Throwable unused3) {
                Logger.w(TAG, "newRandomAccessFile is Throwable");
                return new RandomAccessFile(str, str2);
            }
        }
        Logger.w(TAG, "newRandomAccessFile  file is null");
        throw new FileNotFoundException("file is null");
    }

    public static void deleteSecure(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        deleteSecure(newFile(str));
    }
}
