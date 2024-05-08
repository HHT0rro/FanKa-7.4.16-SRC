package com.tencent.open.log;

import android.os.Environment;
import android.text.TextUtils;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.d;
import java.io.File;

/* compiled from: ProGuard */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class SLog implements TraceLevel {
    public static final String TAG = "openSDK_LOG";

    /* renamed from: c, reason: collision with root package name */
    private static boolean f45221c;
    public static SLog instance;

    /* renamed from: a, reason: collision with root package name */
    public a f45222a = new a(new b(a(), c.f45262m, c.f45256g, c.f45257h, c.f45252c, c.f45258i, 10, c.f45254e, c.f45263n));

    /* renamed from: b, reason: collision with root package name */
    private Tracer f45223b;

    private SLog() {
    }

    public static final void d(String str, String str2) {
        getInstance().a(2, str, str2, null);
    }

    public static final void e(String str, String str2) {
        getInstance().a(16, str, str2, null);
    }

    public static void flushLogs() {
        getInstance().c();
    }

    public static SLog getInstance() {
        if (instance == null) {
            synchronized (SLog.class) {
                if (instance == null) {
                    instance = new SLog();
                    f45221c = true;
                }
            }
        }
        return instance;
    }

    public static final void i(String str, String str2) {
        getInstance().a(4, str, str2, null);
    }

    public static void release() {
        synchronized (SLog.class) {
            getInstance().b();
            if (instance != null) {
                instance = null;
            }
        }
    }

    public static final void u(String str, String str2) {
        getInstance().a(32, str, str2, null);
    }

    public static final void v(String str, String str2) {
        getInstance().a(1, str, str2, null);
    }

    public static final void w(String str, String str2) {
        getInstance().a(8, str, str2, null);
    }

    public void a(int i10, String str, String str2, Throwable th) {
        if (f45221c) {
            String b4 = com.tencent.open.utils.f.b();
            if (!TextUtils.isEmpty(b4)) {
                String str3 = b4 + " SDK_VERSION:" + Constants.SDK_VERSION;
                if (this.f45222a == null) {
                    return;
                }
                e.f45268a.a(32, Thread.currentThread(), System.currentTimeMillis(), TAG, str3, null);
                this.f45222a.a(32, Thread.currentThread(), System.currentTimeMillis(), TAG, str3, null);
                f45221c = false;
            }
        }
        e.f45268a.a(i10, Thread.currentThread(), System.currentTimeMillis(), str, str2, th);
        if (d.a.a(c.f45251b, i10)) {
            a aVar = this.f45222a;
            if (aVar == null) {
                return;
            } else {
                aVar.a(i10, Thread.currentThread(), System.currentTimeMillis(), str, str2, th);
            }
        }
        Tracer tracer = this.f45223b;
        if (tracer != null) {
            try {
                tracer.a(i10, Thread.currentThread(), System.currentTimeMillis(), str, a(str2), th);
            } catch (Exception unused) {
            }
        }
    }

    public void b() {
        a aVar = this.f45222a;
        if (aVar != null) {
            aVar.a();
            this.f45222a.b();
            this.f45222a = null;
        }
    }

    public void c() {
        a aVar = this.f45222a;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void setCustomLogger(Tracer tracer) {
        this.f45223b = tracer;
    }

    public static final void d(String str, String str2, Throwable th) {
        getInstance().a(2, str, str2, th);
    }

    public static final void e(String str, String str2, Throwable th) {
        getInstance().a(16, str, str2, th);
    }

    public static final void i(String str, String str2, Throwable th) {
        getInstance().a(4, str, str2, th);
    }

    public static final void u(String str, String str2, Throwable th) {
        getInstance().a(32, str, str2, th);
    }

    public static final void v(String str, String str2, Throwable th) {
        getInstance().a(1, str, str2, th);
    }

    public static final void w(String str, String str2, Throwable th) {
        getInstance().a(8, str, str2, th);
    }

    private String a(String str) {
        return TextUtils.isEmpty(str) ? "" : d.a(str) ? "xxxxxx" : str;
    }

    public static File a() {
        String str = c.f45253d;
        try {
            d.c b4 = d.b.b();
            if (b4 != null && b4.c() > c.f45255f) {
                return new File(Environment.getExternalStorageDirectory(), str);
            }
            return new File(com.tencent.open.utils.f.c(), str);
        } catch (Throwable th) {
            e(TAG, "getLogFilePath:", th);
            return null;
        }
    }
}
