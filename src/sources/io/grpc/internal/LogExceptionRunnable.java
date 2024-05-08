package io.grpc.internal;

import com.google.common.base.o;
import com.google.common.base.u;
import com.huawei.flexiblelayout.parser.cardmanager.d;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class LogExceptionRunnable implements Runnable {
    private static final Logger log = Logger.getLogger(LogExceptionRunnable.class.getName());
    private final Runnable task;

    public LogExceptionRunnable(Runnable runnable) {
        this.task = (Runnable) o.s(runnable, d.a.f28343b);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.task.run();
        } catch (Throwable th) {
            log.log(Level.SEVERE, "Exception while executing runnable " + ((Object) this.task), th);
            u.f(th);
            throw new AssertionError(th);
        }
    }

    public String toString() {
        return "LogExceptionRunnable(" + ((Object) this.task) + ")";
    }
}
