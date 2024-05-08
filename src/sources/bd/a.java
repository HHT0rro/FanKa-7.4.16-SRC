package bd;

/* compiled from: ExceptionHandler.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class a {
    public final void a() {
        try {
            d();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public abstract void b(Thread thread, Throwable th);

    public final void c(Throwable th) {
        try {
            g(th);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public abstract void d();

    public final void e(Thread thread, Throwable th) {
        try {
            b(thread, th);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public final void f(Throwable th) {
        try {
            h(th);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public abstract void g(Throwable th);

    public void h(Throwable th) {
    }
}
