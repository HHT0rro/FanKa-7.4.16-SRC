package n4;

import java.util.concurrent.Executor;

/* compiled from: SafeLoggingExecutor.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class g implements Executor {

    /* renamed from: b, reason: collision with root package name */
    public final Executor f52111b;

    /* compiled from: SafeLoggingExecutor.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final Runnable f52112b;

        public a(Runnable runnable) {
            this.f52112b = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f52112b.run();
            } catch (Exception e2) {
                p4.a.c("Executor", "Background execution failure.", e2);
            }
        }
    }

    public g(Executor executor) {
        this.f52111b = executor;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f52111b.execute(new a(runnable));
    }
}
