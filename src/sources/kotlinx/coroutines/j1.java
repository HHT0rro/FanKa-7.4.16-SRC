package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;

/* compiled from: Interruptible.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class j1 {
    public static final <T> T b(CoroutineContext coroutineContext, Function0<? extends T> function0) {
        try {
            k2 k2Var = new k2(q1.i(coroutineContext));
            k2Var.d();
            try {
                return function0.invoke();
            } finally {
                k2Var.a();
            }
        } catch (InterruptedException e2) {
            throw new CancellationException("Blocking call was interrupted due to parent cancellation").initCause(e2);
        }
    }
}
