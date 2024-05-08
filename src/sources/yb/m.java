package yb;

import android.os.Handler;
import android.os.HandlerThread;

/* compiled from: DatabaseWorker.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    public final String f54766a;

    /* renamed from: b, reason: collision with root package name */
    public final int f54767b;

    /* renamed from: c, reason: collision with root package name */
    public HandlerThread f54768c;

    /* renamed from: d, reason: collision with root package name */
    public Handler f54769d;

    /* renamed from: e, reason: collision with root package name */
    public Runnable f54770e;

    /* renamed from: f, reason: collision with root package name */
    public k f54771f;

    public m(String str, int i10) {
        this.f54766a = str;
        this.f54767b = i10;
    }

    public boolean b() {
        k kVar = this.f54771f;
        return kVar != null && kVar.b();
    }

    public Integer d() {
        k kVar = this.f54771f;
        if (kVar != null) {
            return kVar.a();
        }
        return null;
    }

    public void e(final k kVar) {
        this.f54769d.post(new Runnable() { // from class: yb.l
            @Override // java.lang.Runnable
            public final void run() {
                m.this.c(kVar);
            }
        });
    }

    public synchronized void f() {
        HandlerThread handlerThread = this.f54768c;
        if (handlerThread != null) {
            handlerThread.quit();
            this.f54768c = null;
            this.f54769d = null;
        }
    }

    public synchronized void g(Runnable runnable) {
        HandlerThread handlerThread = new HandlerThread(this.f54766a, this.f54767b);
        this.f54768c = handlerThread;
        handlerThread.start();
        this.f54769d = new Handler(this.f54768c.getLooper());
        this.f54770e = runnable;
    }

    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public void c(k kVar) {
        kVar.f54763b.run();
        this.f54771f = kVar;
        this.f54770e.run();
    }
}
