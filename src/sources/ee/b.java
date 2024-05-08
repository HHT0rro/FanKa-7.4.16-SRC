package ee;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.d;
import kotlin.e;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.z;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.internal.ThreadContextKt;
import kotlinx.coroutines.internal.b0;
import kotlinx.coroutines.v1;
import kotlinx.coroutines.x;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import td.f;

/* compiled from: Undispatched.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class b {
    public static final <T> void a(@NotNull Function1<? super Continuation<? super T>, ? extends Object> function1, @NotNull Continuation<? super T> continuation) {
        Continuation a10 = f.a(continuation);
        try {
            CoroutineContext context = continuation.getContext();
            Object c4 = ThreadContextKt.c(context, null);
            try {
                Object invoke = ((Function1) z.e(function1, 1)).invoke(a10);
                if (invoke != sd.a.d()) {
                    Result.Companion companion = Result.Companion;
                    a10.resumeWith(Result.m3565constructorimpl(invoke));
                }
            } finally {
                ThreadContextKt.a(context, c4);
            }
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            a10.resumeWith(Result.m3565constructorimpl(e.a(th)));
        }
    }

    public static final <R, T> void b(@NotNull Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r10, @NotNull Continuation<? super T> continuation) {
        Continuation a10 = f.a(continuation);
        try {
            CoroutineContext context = continuation.getContext();
            Object c4 = ThreadContextKt.c(context, null);
            try {
                Object mo1743invoke = ((Function2) z.e(function2, 2)).mo1743invoke(r10, a10);
                if (mo1743invoke != sd.a.d()) {
                    Result.Companion companion = Result.Companion;
                    a10.resumeWith(Result.m3565constructorimpl(mo1743invoke));
                }
            } finally {
                ThreadContextKt.a(context, c4);
            }
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            a10.resumeWith(Result.m3565constructorimpl(e.a(th)));
        }
    }

    public static final <T> void c(@NotNull Function1<? super Continuation<? super T>, ? extends Object> function1, @NotNull Continuation<? super T> continuation) {
        Continuation a10 = f.a(continuation);
        try {
            Object invoke = ((Function1) z.e(function1, 1)).invoke(a10);
            if (invoke != sd.a.d()) {
                Result.Companion companion = Result.Companion;
                a10.resumeWith(Result.m3565constructorimpl(invoke));
            }
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            a10.resumeWith(Result.m3565constructorimpl(e.a(th)));
        }
    }

    public static final <R, T> void d(@NotNull Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r10, @NotNull Continuation<? super T> continuation) {
        Continuation a10 = f.a(continuation);
        try {
            Object mo1743invoke = ((Function2) z.e(function2, 2)).mo1743invoke(r10, a10);
            if (mo1743invoke != sd.a.d()) {
                Result.Companion companion = Result.Companion;
                a10.resumeWith(Result.m3565constructorimpl(mo1743invoke));
            }
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            a10.resumeWith(Result.m3565constructorimpl(e.a(th)));
        }
    }

    @Nullable
    public static final <T, R> Object e(@NotNull b0<? super T> b0Var, R r10, @NotNull Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2) {
        Object xVar;
        Object l02;
        int i10 = 2;
        try {
            xVar = ((Function2) z.e(function2, 2)).mo1743invoke(r10, b0Var);
        } catch (Throwable th) {
            xVar = new x(th, false, i10, null);
        }
        if (xVar != sd.a.d() && (l02 = b0Var.l0(xVar)) != v1.f51548b) {
            if (!(l02 instanceof x)) {
                return v1.h(l02);
            }
            throw ((x) l02).f51562a;
        }
        return sd.a.d();
    }

    @Nullable
    public static final <T, R> Object f(@NotNull b0<? super T> b0Var, R r10, @NotNull Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2) {
        Object xVar;
        Object l02;
        int i10 = 2;
        try {
            xVar = ((Function2) z.e(function2, 2)).mo1743invoke(r10, b0Var);
        } catch (Throwable th) {
            xVar = new x(th, r0, i10, null);
        }
        if (xVar != sd.a.d() && (l02 = b0Var.l0(xVar)) != v1.f51548b) {
            if (l02 instanceof x) {
                Throwable th2 = ((x) l02).f51562a;
                if (((th2 instanceof TimeoutCancellationException) && ((TimeoutCancellationException) th2).coroutine == b0Var) ? false : true) {
                    throw th2;
                }
                if (xVar instanceof x) {
                    throw ((x) xVar).f51562a;
                }
            } else {
                xVar = v1.h(l02);
            }
            return xVar;
        }
        return sd.a.d();
    }
}
