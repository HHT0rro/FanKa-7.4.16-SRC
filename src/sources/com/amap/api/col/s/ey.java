package com.amap.api.col.s;

/* compiled from: ThreadTask.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class ey implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    public a f7964e;

    /* compiled from: ThreadTask.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface a {
        void a(ey eyVar);
    }

    public abstract void a();

    @Override // java.lang.Runnable
    public final void run() {
        a aVar;
        try {
            if (Thread.interrupted()) {
                return;
            }
            a();
            if (Thread.interrupted() || (aVar = this.f7964e) == null) {
                return;
            }
            aVar.a(this);
        } catch (Throwable th) {
            df.c(th, "ThreadTask", "run");
            th.printStackTrace();
        }
    }
}
