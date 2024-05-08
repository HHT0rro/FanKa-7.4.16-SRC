package com.amap.api.col.p0003l;

/* compiled from: ThreadTask.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class je implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    public a f6554f;

    /* compiled from: ThreadTask.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface a {
        void a(je jeVar);

        void b(je jeVar);
    }

    public final void cancelTask() {
        try {
            a aVar = this.f6554f;
            if (aVar != null) {
                aVar.b(this);
            }
        } catch (Throwable th) {
            gy.b(th, "ThreadTask", "cancelTask");
            th.printStackTrace();
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        a aVar;
        try {
            if (Thread.interrupted()) {
                return;
            }
            runTask();
            if (Thread.interrupted() || (aVar = this.f6554f) == null) {
                return;
            }
            aVar.a(this);
        } catch (Throwable th) {
            gy.b(th, "ThreadTask", "run");
            th.printStackTrace();
        }
    }

    public abstract void runTask();
}
