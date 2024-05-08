package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.CoroutineContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Job.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final /* synthetic */ class s1 {
    @NotNull
    public static final v a(@Nullable n1 n1Var) {
        return new p1(n1Var);
    }

    public static /* synthetic */ v b(n1 n1Var, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            n1Var = null;
        }
        return q1.a(n1Var);
    }

    public static final void c(@NotNull CoroutineContext coroutineContext, @Nullable CancellationException cancellationException) {
        n1 n1Var = (n1) coroutineContext.get(n1.C0);
        if (n1Var != null) {
            n1Var.a(cancellationException);
        }
    }

    public static /* synthetic */ void d(CoroutineContext coroutineContext, CancellationException cancellationException, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            cancellationException = null;
        }
        q1.c(coroutineContext, cancellationException);
    }

    @NotNull
    public static final t0 e(@NotNull n1 n1Var, @NotNull t0 t0Var) {
        return n1Var.e(new v0(t0Var));
    }

    public static final void f(@NotNull CoroutineContext coroutineContext) {
        n1 n1Var = (n1) coroutineContext.get(n1.C0);
        if (n1Var != null) {
            q1.h(n1Var);
        }
    }

    public static final void g(@NotNull n1 n1Var) {
        if (!n1Var.isActive()) {
            throw n1Var.w();
        }
    }

    @NotNull
    public static final n1 h(@NotNull CoroutineContext coroutineContext) {
        n1 n1Var = (n1) coroutineContext.get(n1.C0);
        if (n1Var != null) {
            return n1Var;
        }
        throw new IllegalStateException(("Current context doesn't contain Job in it: " + ((Object) coroutineContext)).toString());
    }
}
