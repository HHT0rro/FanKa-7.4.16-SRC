package com.xiaomi.push;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class i2 implements fc.a {

    /* renamed from: e, reason: collision with root package name */
    public static final SimpleDateFormat f47505e = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss aaa");

    /* renamed from: f, reason: collision with root package name */
    public static String f47506f = "/MiPushLog";

    /* renamed from: g, reason: collision with root package name */
    public static List<Pair<String, Throwable>> f47507g = Collections.synchronizedList(new ArrayList());

    /* renamed from: a, reason: collision with root package name */
    public String f47508a;

    /* renamed from: b, reason: collision with root package name */
    public Context f47509b;

    /* renamed from: c, reason: collision with root package name */
    public String f47510c = "";

    /* renamed from: d, reason: collision with root package name */
    public Handler f47511d;

    public i2(Context context) {
        this.f47509b = context;
        if (context.getApplicationContext() != null) {
            this.f47509b = context.getApplicationContext();
        }
        this.f47508a = this.f47509b.getPackageName();
        HandlerThread handlerThread = new HandlerThread("Log2FileHandlerThread");
        handlerThread.start();
        this.f47511d = new Handler(handlerThread.getLooper());
    }

    public final void c() {
        FileLock fileLock;
        RandomAccessFile randomAccessFile;
        File file;
        File externalFilesDir;
        BufferedWriter bufferedWriter = null;
        try {
            if (TextUtils.isEmpty(this.f47510c) && (externalFilesDir = this.f47509b.getExternalFilesDir(null)) != null) {
                this.f47510c = externalFilesDir.getAbsolutePath() + "";
            }
            file = new File(this.f47510c + f47506f);
        } catch (Exception unused) {
            fileLock = null;
            randomAccessFile = null;
        } catch (Throwable th) {
            th = th;
            fileLock = null;
            randomAccessFile = null;
        }
        if ((!file.exists() || !file.isDirectory()) && !file.mkdirs()) {
            return;
        }
        File file2 = new File(file, "log.lock");
        if (!file2.exists() || file2.isDirectory()) {
            file2.createNewFile();
        }
        randomAccessFile = new RandomAccessFile(file2, "rw");
        try {
            fileLock = randomAccessFile.getChannel().lock();
            try {
                BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(file, "log1.txt"), true)));
                while (!f47507g.isEmpty()) {
                    try {
                        Pair<String, Throwable> remove = f47507g.remove(0);
                        String str = (String) remove.first;
                        if (remove.second != null) {
                            str = (str + "\n") + Log.getStackTraceString((Throwable) remove.second);
                        }
                        bufferedWriter2.write(str + "\n");
                    } catch (Exception unused2) {
                        bufferedWriter = bufferedWriter2;
                        if (bufferedWriter != null) {
                            try {
                                bufferedWriter.close();
                            } catch (IOException unused3) {
                            }
                        }
                        if (fileLock != null && fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (IOException unused4) {
                            }
                        }
                        if (randomAccessFile == null) {
                            return;
                        }
                        randomAccessFile.close();
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedWriter = bufferedWriter2;
                        if (bufferedWriter != null) {
                            try {
                                bufferedWriter.close();
                            } catch (IOException unused5) {
                            }
                        }
                        if (fileLock != null && fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (IOException unused6) {
                            }
                        }
                        if (randomAccessFile == null) {
                            throw th;
                        }
                        try {
                            randomAccessFile.close();
                            throw th;
                        } catch (IOException unused7) {
                            throw th;
                        }
                    }
                }
                bufferedWriter2.flush();
                bufferedWriter2.close();
                File file3 = new File(file, "log1.txt");
                if (file3.length() >= 1048576) {
                    File file4 = new File(file, "log0.txt");
                    if (file4.exists() && file4.isFile()) {
                        file4.delete();
                    }
                    file3.renameTo(file4);
                }
                if (fileLock != null && fileLock.isValid()) {
                    try {
                        fileLock.release();
                    } catch (IOException unused8) {
                    }
                }
            } catch (Exception unused9) {
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Exception unused10) {
            fileLock = null;
        } catch (Throwable th4) {
            th = th4;
            fileLock = null;
        }
        try {
            randomAccessFile.close();
        } catch (IOException unused11) {
        }
    }

    @Override // fc.a
    public final void log(String str) {
        log(str, null);
    }

    @Override // fc.a
    public final void log(String str, Throwable th) {
        f47507g.add(new Pair<>(String.format("%1$s %2$s %3$s ", f47505e.format(new Date()), this.f47508a, str), th));
        this.f47511d.post(new j2(this));
    }
}
