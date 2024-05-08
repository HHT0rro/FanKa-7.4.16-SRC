package yb;

import android.os.Handler;
import android.os.HandlerThread;

/* compiled from: DatabaseWorkerPool.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class s implements o {

    /* renamed from: a, reason: collision with root package name */
    public final String f54783a;

    /* renamed from: b, reason: collision with root package name */
    public final int f54784b;

    /* renamed from: c, reason: collision with root package name */
    public HandlerThread f54785c;

    /* renamed from: d, reason: collision with root package name */
    public Handler f54786d;

    public s(String str, int i10) {
        this.f54783a = str;
        this.f54784b = i10;
    }

    @Override // yb.o
    public void a(k kVar) {
        this.f54786d.post(kVar.f54763b);
    }

    @Override // yb.o
    public void b() {
        HandlerThread handlerThread = this.f54785c;
        if (handlerThread != null) {
            handlerThread.quit();
            this.f54785c = null;
            this.f54786d = null;
        }
    }

    @Override // yb.o
    public /* synthetic */ void c(i iVar, Runnable runnable) {
        n.a(this, iVar, runnable);
    }

    @Override // yb.o
    public void start() {
        HandlerThread handlerThread = new HandlerThread(this.f54783a, this.f54784b);
        this.f54785c = handlerThread;
        handlerThread.start();
        this.f54786d = new Handler(this.f54785c.getLooper());
    }
}
