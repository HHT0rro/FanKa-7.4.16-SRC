package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.b0;
import org.jetbrains.annotations.NotNull;

/* compiled from: FlowCoroutine.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class h<T> extends b0<T> {
    public h(@NotNull CoroutineContext coroutineContext, @NotNull Continuation<? super T> continuation) {
        super(coroutineContext, continuation);
    }

    @Override // kotlinx.coroutines.u1
    public boolean R(@NotNull Throwable th) {
        if (th instanceof ChildCancelledException) {
            return true;
        }
        return M(th);
    }
}
