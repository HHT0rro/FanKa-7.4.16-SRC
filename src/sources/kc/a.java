package kc;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.s7;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class a {

    /* renamed from: j, reason: collision with root package name */
    public static volatile a f50765j;

    /* renamed from: a, reason: collision with root package name */
    public final Object f50766a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public final Object f50767b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public final String f50768c = "mipush_region";

    /* renamed from: d, reason: collision with root package name */
    public final String f50769d = "mipush_country_code";

    /* renamed from: e, reason: collision with root package name */
    public final String f50770e = "mipush_region.lock";

    /* renamed from: f, reason: collision with root package name */
    public final String f50771f = "mipush_country_code.lock";

    /* renamed from: g, reason: collision with root package name */
    public volatile String f50772g;

    /* renamed from: h, reason: collision with root package name */
    public volatile String f50773h;

    /* renamed from: i, reason: collision with root package name */
    public Context f50774i;

    public a(Context context) {
        this.f50774i = context;
    }

    public static a c(Context context) {
        if (f50765j == null) {
            synchronized (a.class) {
                if (f50765j == null) {
                    f50765j = new a(context);
                }
            }
        }
        return f50765j;
    }

    public String a() {
        if (TextUtils.isEmpty(this.f50772g)) {
            this.f50772g = b(this.f50774i, "mipush_region", "mipush_region.lock", this.f50766a);
        }
        return this.f50772g;
    }

    public final String b(Context context, String str, String str2, Object obj) {
        RandomAccessFile randomAccessFile;
        FileLock fileLock;
        File file = new File(context.getFilesDir(), str);
        FileLock fileLock2 = null;
        if (!file.exists()) {
            fc.c.i("No ready file to get data from " + str);
            return null;
        }
        synchronized (obj) {
            try {
                File file2 = new File(context.getFilesDir(), str2);
                s7.g(file2);
                randomAccessFile = new RandomAccessFile(file2, "rw");
                try {
                    fileLock = randomAccessFile.getChannel().lock();
                } catch (Exception e2) {
                    e = e2;
                    fileLock = null;
                } catch (Throwable th) {
                    th = th;
                    if (fileLock2 != null) {
                        try {
                            fileLock2.release();
                        } catch (IOException e10) {
                            fc.c.k(e10);
                        }
                    }
                    s7.b(randomAccessFile);
                    throw th;
                }
            } catch (Exception e11) {
                e = e11;
                randomAccessFile = null;
                fileLock = null;
            } catch (Throwable th2) {
                th = th2;
                randomAccessFile = null;
            }
            try {
                try {
                    String a10 = s7.a(file);
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException e12) {
                            fc.c.k(e12);
                        }
                    }
                    s7.b(randomAccessFile);
                    return a10;
                } catch (Throwable th3) {
                    th = th3;
                    fileLock2 = fileLock;
                    if (fileLock2 != null && fileLock2.isValid()) {
                        fileLock2.release();
                    }
                    s7.b(randomAccessFile);
                    throw th;
                }
            } catch (Exception e13) {
                e = e13;
                fc.c.k(e);
                if (fileLock != null && fileLock.isValid()) {
                    try {
                        fileLock.release();
                    } catch (IOException e14) {
                        fc.c.k(e14);
                    }
                }
                s7.b(randomAccessFile);
                return null;
            }
        }
    }

    public final void d(Context context, String str, String str2, String str3, Object obj) {
        RandomAccessFile randomAccessFile;
        synchronized (obj) {
            FileLock fileLock = null;
            try {
                try {
                    File file = new File(context.getFilesDir(), str3);
                    s7.g(file);
                    randomAccessFile = new RandomAccessFile(file, "rw");
                } catch (Exception e2) {
                    e = e2;
                    randomAccessFile = null;
                } catch (Throwable th) {
                    th = th;
                    randomAccessFile = null;
                    if (fileLock != null) {
                        try {
                            fileLock.release();
                        } catch (IOException e10) {
                            fc.c.k(e10);
                        }
                    }
                    s7.b(randomAccessFile);
                    throw th;
                }
                try {
                    try {
                        fileLock = randomAccessFile.getChannel().lock();
                        s7.e(new File(context.getFilesDir(), str2), str);
                        if (fileLock != null && fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (IOException e11) {
                                fc.c.k(e11);
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileLock != null && fileLock.isValid()) {
                            fileLock.release();
                        }
                        s7.b(randomAccessFile);
                        throw th;
                    }
                } catch (Exception e12) {
                    e = e12;
                    fc.c.k(e);
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException e13) {
                            fc.c.k(e13);
                        }
                    }
                    s7.b(randomAccessFile);
                }
                s7.b(randomAccessFile);
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    public void e(String str) {
        if (TextUtils.equals(str, this.f50772g)) {
            return;
        }
        this.f50772g = str;
        d(this.f50774i, this.f50772g, "mipush_region", "mipush_region.lock", this.f50766a);
    }

    public String f() {
        if (TextUtils.isEmpty(this.f50773h)) {
            this.f50773h = b(this.f50774i, "mipush_country_code", "mipush_country_code.lock", this.f50767b);
        }
        return this.f50773h;
    }

    public void g(String str) {
        if (TextUtils.equals(str, this.f50773h)) {
            return;
        }
        this.f50773h = str;
        d(this.f50774i, this.f50773h, "mipush_country_code", "mipush_country_code.lock", this.f50767b);
    }
}
