package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Job.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface n1 extends CoroutineContext.a {

    @NotNull
    public static final b C0 = b.f51449b;

    /* compiled from: Job.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class a {
        public static /* synthetic */ void a(n1 n1Var, CancellationException cancellationException, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if ((i10 & 1) != 0) {
                cancellationException = null;
            }
            n1Var.a(cancellationException);
        }

        public static <R> R b(@NotNull n1 n1Var, R r10, @NotNull Function2<? super R, ? super CoroutineContext.a, ? extends R> function2) {
            return (R) CoroutineContext.a.C0776a.a(n1Var, r10, function2);
        }

        @Nullable
        public static <E extends CoroutineContext.a> E c(@NotNull n1 n1Var, @NotNull CoroutineContext.b<E> bVar) {
            return (E) CoroutineContext.a.C0776a.b(n1Var, bVar);
        }

        public static /* synthetic */ t0 d(n1 n1Var, boolean z10, boolean z11, Function1 function1, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invokeOnCompletion");
            }
            if ((i10 & 1) != 0) {
                z10 = false;
            }
            if ((i10 & 2) != 0) {
                z11 = true;
            }
            return n1Var.u(z10, z11, function1);
        }

        @NotNull
        public static CoroutineContext e(@NotNull n1 n1Var, @NotNull CoroutineContext.b<?> bVar) {
            return CoroutineContext.a.C0776a.c(n1Var, bVar);
        }

        @NotNull
        public static CoroutineContext f(@NotNull n1 n1Var, @NotNull CoroutineContext coroutineContext) {
            return CoroutineContext.a.C0776a.d(n1Var, coroutineContext);
        }
    }

    /* compiled from: Job.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class b implements CoroutineContext.b<n1> {

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ b f51449b = new b();
    }

    void a(@Nullable CancellationException cancellationException);

    @NotNull
    t0 e(@NotNull Function1<? super Throwable, kotlin.p> function1);

    boolean isActive();

    boolean isCancelled();

    boolean isCompleted();

    @NotNull
    r r(@NotNull t tVar);

    boolean start();

    @NotNull
    t0 u(boolean z10, boolean z11, @NotNull Function1<? super Throwable, kotlin.p> function1);

    @NotNull
    CancellationException w();

    @Nullable
    Object y(@NotNull Continuation<? super kotlin.p> continuation);
}
