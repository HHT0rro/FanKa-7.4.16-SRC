package com.amap.api.col.p0003l;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.text.TextUtils;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/* compiled from: FileStorageModel.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class gn {

    /* renamed from: a, reason: collision with root package name */
    public static final String f6121a = fv.c("SYmFja3Vwcw");

    /* renamed from: b, reason: collision with root package name */
    public static final String f6122b = fv.c("SLmFkaXU");

    /* renamed from: c, reason: collision with root package name */
    public static final String f6123c = fv.c("JIw");

    public static synchronized void a(Context context, String str, String str2) {
        FileChannel fileChannel;
        RandomAccessFile randomAccessFile;
        synchronized (gn.class) {
            if (context != null) {
                if (context.checkCallingOrSelfPermission(fv.c("EYW5kcm9pZC5wZXJtaXNzaW9uLldSSVRFX0VYVEVSTkFMX1NUT1JBR0U=")) == 0 && context.checkCallingOrSelfPermission(fv.c("EYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfRVhURVJOQUxfU1RPUkFHRQ==")) == 0) {
                    String a10 = a(context);
                    if (TextUtils.isEmpty(a10)) {
                        return;
                    }
                    String str3 = str + f6123c + str2;
                    File file = new File(a10 + File.separator + f6121a);
                    File file2 = new File(file, f6122b);
                    FileLock fileLock = null;
                    try {
                        if (!file.exists() || file.isDirectory()) {
                            file.mkdirs();
                        }
                        file2.createNewFile();
                        randomAccessFile = new RandomAccessFile(file2, "rws");
                        try {
                            fileChannel = randomAccessFile.getChannel();
                            try {
                                fileLock = fileChannel.tryLock();
                                if (fileLock != null) {
                                    fileChannel.write(ByteBuffer.wrap(str3.getBytes("UTF-8")));
                                }
                                if (fileLock != null) {
                                    try {
                                        fileLock.release();
                                    } catch (IOException unused) {
                                    }
                                }
                                try {
                                    fileChannel.close();
                                } catch (IOException unused2) {
                                }
                                a(randomAccessFile);
                            } catch (Throwable unused3) {
                                if (fileLock != null) {
                                    try {
                                        fileLock.release();
                                    } catch (IOException unused4) {
                                    }
                                }
                                if (fileChannel != null) {
                                    try {
                                        fileChannel.close();
                                    } catch (IOException unused5) {
                                    }
                                }
                                a(randomAccessFile);
                            }
                        } catch (Throwable unused6) {
                            fileChannel = null;
                        }
                    } catch (Throwable unused7) {
                        fileChannel = null;
                        randomAccessFile = null;
                    }
                }
            }
        }
    }

    private static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    private static String a(Context context) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 31 && (context.getApplicationInfo().targetSdkVersion < 30 || i10 < 30)) {
            StorageManager storageManager = (StorageManager) context.getSystemService("storage");
            try {
                Class<?> cls = Class.forName(fv.c("SYW5kcm9pZC5vcy5zdG9yYWdlLlN0b3JhZ2VWb2x1bWU"));
                Method method = storageManager.getClass().getMethod(fv.c("FZ2V0Vm9sdW1lTGlzdA"), new Class[0]);
                Method method2 = cls.getMethod(fv.c("ZZ2V0UGF0aA"), new Class[0]);
                Method method3 = cls.getMethod(fv.c("AaXNSZW1vdmFibGUK"), new Class[0]);
                Object invoke = method.invoke(storageManager, new Object[0]);
                int length = Array.getLength(invoke);
                for (int i11 = 0; i11 < length; i11++) {
                    Object obj = Array.get(invoke, i11);
                    String str = (String) method2.invoke(obj, new Object[0]);
                    if (!((Boolean) method3.invoke(obj, new Object[0])).booleanValue()) {
                        return str;
                    }
                }
                return null;
            } catch (Throwable unused) {
                return Environment.getExternalStorageDirectory().getAbsolutePath();
            }
        }
        return context.getApplicationContext().getExternalFilesDir("").getAbsolutePath();
    }
}
