package com.facebook.soloader;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Parcel;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import com.kuaishou.weapon.p0.t;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class SysUtil {
    private static final byte APK_SIGNATURE_VERSION = 1;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class LollipopSysdeps {
        private LollipopSysdeps() {
        }

        @DoNotOptimize
        public static void fallocateIfSupported(FileDescriptor fileDescriptor, long j10) throws IOException {
            int i10;
            try {
                Os.posix_fallocate(fileDescriptor, 0L, j10);
            } catch (ErrnoException e2) {
                if (e2.errno != OsConstants.EOPNOTSUPP && (i10 = e2.errno) != OsConstants.ENOSYS && i10 != OsConstants.EINVAL) {
                    throw new IOException(e2.toString(), e2);
                }
            }
        }

        @DoNotOptimize
        public static String[] getSupportedAbis() {
            return Build.SUPPORTED_ABIS;
        }
    }

    public static int copyBytes(RandomAccessFile randomAccessFile, InputStream inputStream, int i10, byte[] bArr) throws IOException {
        int i11 = 0;
        while (i11 < i10) {
            int read = inputStream.read(bArr, 0, Math.min(bArr.length, i10 - i11));
            if (read == -1) {
                break;
            }
            randomAccessFile.write(bArr, 0, read);
            i11 += read;
        }
        return i11;
    }

    public static void deleteOrThrow(File file) throws IOException {
        if (file.delete()) {
            return;
        }
        throw new IOException("could not delete file " + ((Object) file));
    }

    public static void dumbDeleteRecursive(File file) throws IOException {
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return;
            }
            for (File file2 : listFiles) {
                dumbDeleteRecursive(file2);
            }
        }
        if (file.delete() || !file.exists()) {
            return;
        }
        throw new IOException("could not delete: " + ((Object) file));
    }

    public static void fallocateIfSupported(FileDescriptor fileDescriptor, long j10) throws IOException {
        LollipopSysdeps.fallocateIfSupported(fileDescriptor, j10);
    }

    public static int findAbiScore(String[] strArr, String str) {
        for (int i10 = 0; i10 < strArr.length; i10++) {
            if (strArr[i10] != null && str.equals(strArr[i10])) {
                return i10;
            }
        }
        return -1;
    }

    public static void fsyncRecursive(File file) throws IOException {
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    fsyncRecursive(file2);
                }
                return;
            }
            throw new IOException("cannot list directory " + ((Object) file));
        }
        if (file.getPath().endsWith("_lock")) {
            return;
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, t.f36226k);
        try {
            randomAccessFile.getFD().sync();
            randomAccessFile.close();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    randomAccessFile.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    public static int getAppVersionCode(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            try {
                return packageManager.getPackageInfo(context.getPackageName(), 0).versionCode;
            } catch (PackageManager.NameNotFoundException | RuntimeException unused) {
            }
        }
        return 0;
    }

    public static String[] getSupportedAbis() {
        return LollipopSysdeps.getSupportedAbis();
    }

    public static byte[] makeApkDepBlock(File file, Context context) throws IOException {
        File canonicalFile = file.getCanonicalFile();
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeByte((byte) 1);
            obtain.writeString(canonicalFile.getPath());
            obtain.writeLong(canonicalFile.lastModified());
            obtain.writeInt(getAppVersionCode(context));
            return obtain.marshall();
        } finally {
            obtain.recycle();
        }
    }

    public static void mkdirOrThrow(File file) throws IOException {
        if (file.mkdirs() || file.isDirectory()) {
            return;
        }
        throw new IOException("cannot mkdir: " + ((Object) file));
    }
}
