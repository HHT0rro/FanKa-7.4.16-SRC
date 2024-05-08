package com.alimm.tanx.core.utils;

import android.content.Context;
import com.android.internal.logging.nano.MetricsProto;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.ResponseBody;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class FileUtil implements NotConfused {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface WriteProgress {
        void error(Exception exc);

        void writeProgress(int i10);
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x006e A[Catch: IOException -> 0x006a, TRY_LEAVE, TryCatch #0 {IOException -> 0x006a, blocks: (B:54:0x0066, B:47:0x006e), top: B:53:0x0066 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0066 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean copyFile(java.lang.String r4, java.lang.String r5) {
        /*
            r0 = 0
            r1 = 0
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L4a
            r2.<init>(r4)     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L4a
            boolean r2 = r2.exists()     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L4a
            if (r2 == 0) goto L34
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L4a
            r2.<init>(r4)     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L4a
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L31
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L31
            r5 = 1444(0x5a4, float:2.023E-42)
            byte[] r5 = new byte[r5]     // Catch: java.lang.Throwable -> L29 java.lang.Exception -> L2c
        L1b:
            int r0 = r2.read(r5)     // Catch: java.lang.Throwable -> L29 java.lang.Exception -> L2c
            r3 = -1
            if (r0 == r3) goto L26
            r4.write(r5, r1, r0)     // Catch: java.lang.Throwable -> L29 java.lang.Exception -> L2c
            goto L1b
        L26:
            r1 = 1
            r0 = r4
            goto L35
        L29:
            r5 = move-exception
            r0 = r4
            goto L63
        L2c:
            r5 = move-exception
            r0 = r4
            goto L4d
        L2f:
            r4 = move-exception
            goto L64
        L31:
            r4 = move-exception
            r5 = r4
            goto L4d
        L34:
            r2 = r0
        L35:
            if (r0 == 0) goto L3d
            r0.close()     // Catch: java.io.IOException -> L3b
            goto L3d
        L3b:
            r4 = move-exception
            goto L43
        L3d:
            if (r2 == 0) goto L61
            r2.close()     // Catch: java.io.IOException -> L3b
            goto L61
        L43:
            r4.printStackTrace()
            goto L61
        L47:
            r4 = move-exception
            r2 = r0
            goto L64
        L4a:
            r4 = move-exception
            r5 = r4
            r2 = r0
        L4d:
            r5.printStackTrace()     // Catch: java.lang.Throwable -> L62
            if (r0 == 0) goto L58
            r0.close()     // Catch: java.io.IOException -> L56
            goto L58
        L56:
            r4 = move-exception
            goto L5e
        L58:
            if (r2 == 0) goto L61
            r2.close()     // Catch: java.io.IOException -> L56
            goto L61
        L5e:
            r4.printStackTrace()
        L61:
            return r1
        L62:
            r5 = move-exception
        L63:
            r4 = r5
        L64:
            if (r0 == 0) goto L6c
            r0.close()     // Catch: java.io.IOException -> L6a
            goto L6c
        L6a:
            r5 = move-exception
            goto L72
        L6c:
            if (r2 == 0) goto L75
            r2.close()     // Catch: java.io.IOException -> L6a
            goto L75
        L72:
            r5.printStackTrace()
        L75:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alimm.tanx.core.utils.FileUtil.copyFile(java.lang.String, java.lang.String):boolean");
    }

    public static boolean deleteFiles(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return true;
        }
        for (File file2 : listFiles) {
            if (!file2.isDirectory() && file2.exists() && !file2.delete()) {
                return false;
            }
        }
        return true;
    }

    public static synchronized File getAndCreateFile(String str, String str2) {
        File file;
        synchronized (FileUtil.class) {
            File file2 = new File(str);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            file = new File(file2, str2);
        }
        return file;
    }

    public static File getCacheDirectory(Context context, boolean z10) {
        File cacheDir = context.getCacheDir();
        if (cacheDir != null) {
            return cacheDir;
        }
        return new File("/data/data/" + context.getPackageName() + "/cache/");
    }

    public static long getFileName(File file) {
        if (file != null) {
            return Long.parseLong(file.getName().replace(".txt", ""));
        }
        return 0L;
    }

    public static File getIndividualCacheDirectory(Context context, String str) {
        return new File(getCacheDirectory(context, true), str);
    }

    public static void writeFile(ResponseBody responseBody, File file, long j10, boolean z10, WriteProgress writeProgress) {
        FileOutputStream fileOutputStream;
        if (responseBody == null) {
            return;
        }
        InputStream byteStream = responseBody.byteStream();
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                byte[] bArr = new byte[1024];
                if (z10) {
                    fileOutputStream = new FileOutputStream(file, true);
                } else {
                    fileOutputStream = new FileOutputStream(file);
                }
                fileOutputStream2 = fileOutputStream;
                if (!z10) {
                    j10 = 0;
                }
                while (true) {
                    int read = byteStream.read(bArr);
                    if (read == -1) {
                        fileOutputStream2.flush();
                        try {
                            byteStream.close();
                            fileOutputStream2.close();
                            return;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            return;
                        }
                    }
                    fileOutputStream2.write(bArr, 0, read);
                    j10 += read;
                    writeProgress.writeProgress((int) (((((float) j10) * 1.0f) / ((float) responseBody.contentLength())) * 100.0f));
                }
            } catch (Exception e10) {
                writeProgress.error(e10);
                e10.printStackTrace();
                if (byteStream != null) {
                    try {
                        byteStream.close();
                    } catch (IOException e11) {
                        e11.printStackTrace();
                        return;
                    }
                }
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
            }
        } catch (Throwable th) {
            if (byteStream != null) {
                try {
                    byteStream.close();
                } catch (IOException e12) {
                    e12.printStackTrace();
                    throw th;
                }
            }
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
            throw th;
        }
    }

    public static boolean copyFile(InputStream inputStream, FileOutputStream fileOutputStream) {
        boolean z10 = false;
        try {
            try {
                byte[] bArr = new byte[MetricsProto.MetricsEvent.FIELD_IO_OPERATION_COUNT];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                z10 = true;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                inputStream.close();
            } catch (Exception e10) {
                e10.printStackTrace();
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e11) {
                        e11.printStackTrace();
                    }
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            }
            return z10;
        } catch (Throwable th) {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e12) {
                    e12.printStackTrace();
                    throw th;
                }
            }
            if (inputStream != null) {
                inputStream.close();
            }
            throw th;
        }
    }
}
