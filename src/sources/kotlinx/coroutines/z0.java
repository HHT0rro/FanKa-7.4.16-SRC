package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import kotlinx.coroutines.y0;
import org.jetbrains.annotations.NotNull;

/* compiled from: EventLoop.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class z0 extends x0 {
    @NotNull
    public abstract Thread J();

    public void K(long j10, @NotNull y0.c cVar) {
        k0.f51428g.V(j10, cVar);
    }

    public final void L() {
        Thread J = J();
        if (Thread.currentThread() != J) {
            c.a();
            LockSupport.unpark(J);
        }
    }
}
