package com.tencent.open.log;

import android.text.TextUtils;
import com.tencent.open.log.d;
import com.tencent.open.utils.l;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/* compiled from: ProGuard */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static SimpleDateFormat f45240a = d.C0652d.a("yy.MM.dd.HH");

    /* renamed from: g, reason: collision with root package name */
    private File f45246g;

    /* renamed from: b, reason: collision with root package name */
    private String f45241b = "Tracer.File";

    /* renamed from: c, reason: collision with root package name */
    private int f45242c = Integer.MAX_VALUE;

    /* renamed from: d, reason: collision with root package name */
    private int f45243d = Integer.MAX_VALUE;

    /* renamed from: e, reason: collision with root package name */
    private int f45244e = 4096;

    /* renamed from: f, reason: collision with root package name */
    private long f45245f = 10000;

    /* renamed from: h, reason: collision with root package name */
    private int f45247h = 10;

    /* renamed from: i, reason: collision with root package name */
    private String f45248i = ".log";

    /* renamed from: j, reason: collision with root package name */
    private long f45249j = Long.MAX_VALUE;

    public b(File file, int i10, int i11, int i12, String str, long j10, int i13, String str2, long j11) {
        a(file);
        b(i10);
        a(i11);
        c(i12);
        a(str);
        a(j10);
        d(i13);
        b(str2);
        b(j11);
    }

    private File[] c(long j10) {
        File b4 = b();
        String c4 = c(d(j10));
        try {
            b4 = new File(b4, c4);
        } catch (Throwable th) {
            SLog.e(SLog.TAG, "getWorkFile,get old sdcard file exception:", th);
        }
        String b10 = l.b();
        File file = null;
        if (!TextUtils.isEmpty(b10) || b10 != null) {
            try {
                File file2 = new File(b10, c.f45264o);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                file = new File(file2, c4);
            } catch (Exception e2) {
                SLog.e(SLog.TAG, "getWorkFile,get app specific file exception:", e2);
            }
        }
        return new File[]{b4, file};
    }

    private String d(long j10) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j10);
        return new SimpleDateFormat("yy.MM.dd.HH").format(calendar.getTime());
    }

    public File[] a() {
        return c(System.currentTimeMillis());
    }

    public File b() {
        File e2 = e();
        if (e2 != null) {
            e2.mkdirs();
        }
        return e2;
    }

    public File e() {
        return this.f45246g;
    }

    public int f() {
        return this.f45247h;
    }

    public void a(String str) {
        this.f45241b = str;
    }

    public void a(int i10) {
        this.f45242c = i10;
    }

    public void b(int i10) {
        this.f45243d = i10;
    }

    public void a(long j10) {
        this.f45245f = j10;
    }

    public void b(String str) {
        this.f45248i = str;
    }

    public void a(File file) {
        this.f45246g = file;
    }

    public void b(long j10) {
        this.f45249j = j10;
    }

    public int d() {
        return this.f45244e;
    }

    public void d(int i10) {
        this.f45247h = i10;
    }

    private String c(String str) {
        return "com.tencent.mobileqq_connectSdk." + str + ".log";
    }

    public String c() {
        return this.f45241b;
    }

    public void c(int i10) {
        this.f45244e = i10;
    }
}
