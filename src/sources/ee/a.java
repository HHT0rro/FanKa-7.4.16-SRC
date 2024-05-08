package ee;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.d;
import kotlin.e;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.p;
import kotlinx.coroutines.internal.j;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Cancellable.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class a {
    public static final void a(Continuation<?> continuation, Throwable th) {
        Result.Companion companion = Result.Companion;
        continuation.resumeWith(Result.m3565constructorimpl(e.a(th)));
        throw th;
    }

    public static final void b(@NotNull Continuation<? super p> continuation, @NotNull Continuation<?> continuation2) {
        try {
            Continuation c4 = IntrinsicsKt__IntrinsicsJvmKt.c(continuation);
            Result.Companion companion = Result.Companion;
            j.c(c4, Result.m3565constructorimpl(p.f51048a), null, 2, null);
        } catch (Throwable th) {
            a(continuation2, th);
        }
    }

    public static final <T> void c(@NotNull Function1<? super Continuation<? super T>, ? extends Object> function1, @NotNull Continuation<? super T> continuation) {
        try {
            Continuation c4 = IntrinsicsKt__IntrinsicsJvmKt.c(IntrinsicsKt__IntrinsicsJvmKt.a(function1, continuation));
            Result.Companion companion = Result.Companion;
            j.c(c4, Result.m3565constructorimpl(p.f51048a), null, 2, null);
        } catch (Throwable th) {
            a(continuation, th);
        }
    }

    public static final <R, T> void d(@NotNull Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r10, @NotNull Continuation<? super T> continuation, @Nullable Function1<? super Throwable, p> function1) {
        try {
            Continuation c4 = IntrinsicsKt__IntrinsicsJvmKt.c(IntrinsicsKt__IntrinsicsJvmKt.b(function2, r10, continuation));
            Result.Companion companion = Result.Companion;
            j.b(c4, Result.m3565constructorimpl(p.f51048a), function1);
        } catch (Throwable th) {
            a(continuation, th);
        }
    }

    public static /* synthetic */ void e(Function2 function2, Object obj, Continuation continuation, Function1 function1, int i10, Object obj2) {
        if ((i10 & 4) != 0) {
            function1 = null;
        }
        d(function2, obj, continuation, function1);
    }
}
