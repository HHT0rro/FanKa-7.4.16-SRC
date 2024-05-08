package com.huawei.hms.utils;

import android.content.Context;
import com.huawei.hms.support.log.HMSLog;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class FileUtil {
    public static final String LOCAL_REPORT_FILE = "hms/HwMobileServiceReport.txt";
    public static final String LOCAL_REPORT_FILE_CONFIG = "hms/config.txt";
    public static final long LOCAL_REPORT_FILE_MAX_SIZE = 10240;

    /* renamed from: a, reason: collision with root package name */
    private static boolean f31918a;

    /* renamed from: b, reason: collision with root package name */
    private static ScheduledExecutorService f31919b = Executors.newSingleThreadScheduledExecutor();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ File f31920a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f31921b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f31922c;

        public a(File file, long j10, String str) {
            this.f31920a = file;
            this.f31921b = j10;
            this.f31922c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            RandomAccessFile randomAccessFile;
            Throwable th;
            File file = this.f31920a;
            if (file == null) {
                HMSLog.e("FileUtil", "In writeFile Failed to get local file.");
                return;
            }
            File parentFile = file.getParentFile();
            if (parentFile != null && (parentFile.mkdirs() || parentFile.isDirectory())) {
                RandomAccessFile randomAccessFile2 = null;
                try {
                    try {
                        long length = this.f31920a.length();
                        if (length > this.f31921b) {
                            String canonicalPath = this.f31920a.getCanonicalPath();
                            if (!this.f31920a.delete()) {
                                HMSLog.e("FileUtil", "last file delete failed.");
                            }
                            randomAccessFile2 = new RandomAccessFile(new File(canonicalPath), "rw");
                        } else {
                            randomAccessFile = new RandomAccessFile(this.f31920a, "rw");
                            try {
                                randomAccessFile.seek(length);
                                randomAccessFile2 = randomAccessFile;
                            } catch (IOException e2) {
                                e = e2;
                                randomAccessFile2 = randomAccessFile;
                                HMSLog.e("FileUtil", "writeFile exception:", e);
                                IOUtils.closeQuietly(randomAccessFile2);
                            } catch (Throwable th2) {
                                th = th2;
                                IOUtils.closeQuietly(randomAccessFile);
                                throw th;
                            }
                        }
                        randomAccessFile2.writeBytes(this.f31922c + System.getProperty("line.separator"));
                    } catch (IOException e10) {
                        e = e10;
                    }
                    IOUtils.closeQuietly(randomAccessFile2);
                } catch (Throwable th3) {
                    randomAccessFile = null;
                    th = th3;
                }
            } else {
                HMSLog.e("FileUtil", "In writeFile, Failed to create directory.");
            }
        }
    }

    public static boolean verifyHash(String str, File file) {
        byte[] digest = SHA256.digest(file);
        return digest != null && HEX.encodeHexString(digest, true).equalsIgnoreCase(str);
    }

    public static void writeFile(File file, String str, long j10) {
        f31919b.execute(new a(file, j10, str));
    }

    public static void writeFileReport(Context context, File file, File file2, String str, long j10, int i10) {
        if (file != null && file.isFile() && file.exists()) {
            if (!f31918a) {
                if (file2 != null && file2.exists() && !file2.delete()) {
                    HMSLog.e("FileUtil", "file delete failed.");
                }
                f31918a = true;
            }
            writeFile(file2, str + "|" + j10 + "|" + i10, LOCAL_REPORT_FILE_MAX_SIZE);
        }
    }
}
