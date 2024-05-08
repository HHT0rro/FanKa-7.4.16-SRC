package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.push.n;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class a3 extends n.a {

    /* renamed from: b, reason: collision with root package name */
    public int f47109b;

    /* renamed from: c, reason: collision with root package name */
    public Context f47110c;

    public a3(Context context, int i10) {
        this.f47109b = i10;
        this.f47110c = context;
    }

    public static void d(Context context, hy hyVar) {
        l2 a10 = m2.b().a();
        String a11 = a10 == null ? "" : a10.a();
        if (TextUtils.isEmpty(a11) || TextUtils.isEmpty(hyVar.a())) {
            return;
        }
        e(context, hyVar, a11);
    }

    public static void e(Context context, hy hyVar, String str) {
        BufferedOutputStream bufferedOutputStream;
        RandomAccessFile randomAccessFile;
        byte[] d10 = q2.d(str, o6.c(hyVar));
        if (d10 == null || d10.length == 0) {
            return;
        }
        synchronized (r2.f48127a) {
            FileLock fileLock = null;
            try {
                try {
                    File file = new File(context.getExternalFilesDir(null), "push_cdata.lock");
                    s7.g(file);
                    randomAccessFile = new RandomAccessFile(file, "rw");
                    try {
                        FileLock lock = randomAccessFile.getChannel().lock();
                        try {
                            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(context.getExternalFilesDir(null), "push_cdata.data"), true));
                        } catch (IOException e2) {
                            e = e2;
                            bufferedOutputStream = null;
                        } catch (Throwable th) {
                            th = th;
                            bufferedOutputStream = null;
                        }
                        try {
                            bufferedOutputStream.write(f.b(d10.length));
                            bufferedOutputStream.write(d10);
                            bufferedOutputStream.flush();
                            if (lock != null && lock.isValid()) {
                                try {
                                    lock.release();
                                } catch (IOException unused) {
                                }
                            }
                            s7.b(bufferedOutputStream);
                        } catch (IOException e10) {
                            e = e10;
                            fileLock = lock;
                            try {
                                e.printStackTrace();
                                if (fileLock != null && fileLock.isValid()) {
                                    try {
                                        fileLock.release();
                                    } catch (IOException unused2) {
                                    }
                                }
                                s7.b(bufferedOutputStream);
                                s7.b(randomAccessFile);
                            } catch (Throwable th2) {
                                th = th2;
                                if (fileLock != null && fileLock.isValid()) {
                                    try {
                                        fileLock.release();
                                    } catch (IOException unused3) {
                                    }
                                }
                                s7.b(bufferedOutputStream);
                                s7.b(randomAccessFile);
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            fileLock = lock;
                            if (fileLock != null) {
                                fileLock.release();
                            }
                            s7.b(bufferedOutputStream);
                            s7.b(randomAccessFile);
                            throw th;
                        }
                    } catch (IOException e11) {
                        e = e11;
                        bufferedOutputStream = null;
                    } catch (Throwable th4) {
                        th = th4;
                        bufferedOutputStream = null;
                    }
                } catch (IOException e12) {
                    e = e12;
                    bufferedOutputStream = null;
                    randomAccessFile = null;
                } catch (Throwable th5) {
                    th = th5;
                    bufferedOutputStream = null;
                    randomAccessFile = null;
                }
                s7.b(randomAccessFile);
            } catch (Throwable th6) {
                throw th6;
            }
        }
    }

    public abstract hs b();

    public abstract String c();

    public boolean f() {
        return false;
    }

    public final String g() {
        return "dc_job_result_time_" + a();
    }

    public boolean h() {
        return q2.b(this.f47110c, String.valueOf(a()), this.f47109b);
    }

    public final String i() {
        return "dc_job_result_" + a();
    }

    public boolean j() {
        return true;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (h()) {
            fc.c.i("DC run job mutual: " + a());
            return;
        }
        l2 a10 = m2.b().a();
        String a11 = a10 == null ? "" : a10.a();
        if (!TextUtils.isEmpty(a11) && j()) {
            String c4 = c();
            if (TextUtils.isEmpty(c4)) {
                return;
            }
            if (f()) {
                SharedPreferences sharedPreferences = this.f47110c.getSharedPreferences("mipush_extra", 0);
                if (p0.b(c4).equals(sharedPreferences.getString(i(), null))) {
                    long j10 = sharedPreferences.getLong(g(), 0L);
                    int a12 = kc.j.d(this.f47110c).a(hv.DCJobUploadRepeatedInterval.a(), 604800);
                    if ((System.currentTimeMillis() - j10) / 1000 < this.f47109b) {
                        return;
                    }
                    if ((System.currentTimeMillis() - j10) / 1000 < a12) {
                        c4 = "same_" + j10;
                    }
                }
            }
            hy hyVar = new hy();
            hyVar.a(c4);
            hyVar.a(System.currentTimeMillis());
            hyVar.a(b());
            e(this.f47110c, hyVar, a11);
        }
    }
}
