package com.tencent.open.log;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/* compiled from: ProGuard */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class a extends Tracer implements Handler.Callback {

    /* renamed from: a, reason: collision with root package name */
    private b f45227a;

    /* renamed from: b, reason: collision with root package name */
    private FileWriter f45228b;

    /* renamed from: c, reason: collision with root package name */
    private FileWriter f45229c;

    /* renamed from: d, reason: collision with root package name */
    private File f45230d;

    /* renamed from: e, reason: collision with root package name */
    private File f45231e;

    /* renamed from: f, reason: collision with root package name */
    private char[] f45232f;

    /* renamed from: g, reason: collision with root package name */
    private volatile f f45233g;

    /* renamed from: h, reason: collision with root package name */
    private volatile f f45234h;

    /* renamed from: i, reason: collision with root package name */
    private volatile f f45235i;

    /* renamed from: j, reason: collision with root package name */
    private volatile f f45236j;

    /* renamed from: k, reason: collision with root package name */
    private volatile boolean f45237k;

    /* renamed from: l, reason: collision with root package name */
    private HandlerThread f45238l;

    /* renamed from: m, reason: collision with root package name */
    private Handler f45239m;

    public a(b bVar) {
        this(c.f45251b, true, g.f45271a, bVar);
    }

    private void f() {
        if (Thread.currentThread() == this.f45238l && !this.f45237k) {
            this.f45237k = true;
            j();
            try {
                try {
                    this.f45236j.a(g(), this.f45232f);
                } catch (IOException e2) {
                    SLog.e("FileTracer", "flushBuffer exception", e2);
                }
                this.f45237k = false;
            } finally {
                this.f45236j.b();
            }
        }
    }

    private Writer[] g() {
        File[] a10 = c().a();
        if (a10 != null && a10.length >= 2) {
            File file = a10[0];
            if ((file != null && !file.equals(this.f45230d)) || (this.f45228b == null && file != null)) {
                this.f45230d = file;
                h();
                try {
                    this.f45228b = new FileWriter(this.f45230d, true);
                } catch (IOException unused) {
                    this.f45228b = null;
                    SLog.e(SLog.TAG, "-->obtainFileWriter() old log file permission denied");
                }
            }
            File file2 = a10[1];
            if ((file2 != null && !file2.equals(this.f45231e)) || (this.f45229c == null && file2 != null)) {
                this.f45231e = file2;
                i();
                try {
                    this.f45229c = new FileWriter(this.f45231e, true);
                } catch (IOException unused2) {
                    this.f45229c = null;
                    SLog.e(SLog.TAG, "-->obtainFileWriter() app specific file permission denied");
                }
            }
        }
        return new Writer[]{this.f45228b, this.f45229c};
    }

    private void h() {
        try {
            FileWriter fileWriter = this.f45228b;
            if (fileWriter != null) {
                fileWriter.flush();
                this.f45228b.close();
            }
        } catch (IOException e2) {
            SLog.e(SLog.TAG, "-->closeFileWriter() exception:", e2);
        }
    }

    private void i() {
        try {
            FileWriter fileWriter = this.f45229c;
            if (fileWriter != null) {
                fileWriter.flush();
                this.f45229c.close();
            }
        } catch (IOException e2) {
            SLog.e(SLog.TAG, "-->closeAppSpecificFileWriter() exception:", e2);
        }
    }

    private void j() {
        synchronized (this) {
            if (this.f45235i == this.f45233g) {
                this.f45235i = this.f45234h;
                this.f45236j = this.f45233g;
            } else {
                this.f45235i = this.f45233g;
                this.f45236j = this.f45234h;
            }
        }
    }

    public void a() {
        if (this.f45239m.hasMessages(1024)) {
            this.f45239m.removeMessages(1024);
        }
        this.f45239m.sendEmptyMessage(1024);
    }

    public void b() {
        h();
        i();
        this.f45238l.quit();
    }

    public b c() {
        return this.f45227a;
    }

    @Override // com.tencent.open.log.Tracer
    public void doTrace(int i10, Thread thread, long j10, String str, String str2, Throwable th) {
        a(e().a(i10, thread, j10, str, str2, th));
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 1024) {
            return true;
        }
        f();
        return true;
    }

    public a(int i10, boolean z10, g gVar, b bVar) {
        super(i10, z10, gVar);
        this.f45237k = false;
        a(bVar);
        this.f45233g = new f();
        this.f45234h = new f();
        this.f45235i = this.f45233g;
        this.f45236j = this.f45234h;
        this.f45232f = new char[bVar.d()];
        HandlerThread handlerThread = new HandlerThread(bVar.c(), bVar.f());
        this.f45238l = handlerThread;
        handlerThread.start();
        if (!this.f45238l.isAlive() || this.f45238l.getLooper() == null) {
            return;
        }
        this.f45239m = new Handler(this.f45238l.getLooper(), this);
    }

    private void a(String str) {
        this.f45235i.a(str);
        if (this.f45235i.a() >= c().d()) {
            a();
        }
    }

    public void a(b bVar) {
        this.f45227a = bVar;
    }
}
