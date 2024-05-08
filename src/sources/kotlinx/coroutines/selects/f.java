package kotlinx.coroutines.selects;

import kotlin.coroutines.Continuation;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.t0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Select.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface f<R> {
    @Nullable
    Object f(@Nullable LockFreeLinkedListNode.c cVar);

    @Nullable
    Object g(@NotNull kotlinx.coroutines.internal.b bVar);

    boolean j();

    void k(@NotNull t0 t0Var);

    boolean l();

    @NotNull
    Continuation<R> m();

    void n(@NotNull Throwable th);
}
