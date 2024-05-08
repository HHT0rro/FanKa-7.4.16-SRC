package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import org.jetbrains.annotations.NotNull;

/* compiled from: CancellableContinuation.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class o {
    public static final void a(@NotNull l<?> lVar, @NotNull t0 t0Var) {
        lVar.v(new u0(t0Var));
    }

    @NotNull
    public static final <T> m<T> b(@NotNull Continuation<? super T> continuation) {
        if (!(continuation instanceof kotlinx.coroutines.internal.i)) {
            return new m<>(continuation, 1);
        }
        m<T> i10 = ((kotlinx.coroutines.internal.i) continuation).i();
        if (i10 != null) {
            if (!i10.J()) {
                i10 = null;
            }
            if (i10 != null) {
                return i10;
            }
        }
        return new m<>(continuation, 2);
    }

    public static final void c(@NotNull l<?> lVar, @NotNull LockFreeLinkedListNode lockFreeLinkedListNode) {
        lVar.v(new c2(lockFreeLinkedListNode));
    }
}
