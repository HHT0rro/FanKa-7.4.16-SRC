package kotlinx.coroutines;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.ThreadContextKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: DispatchedTask.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class p0 {
    public static final <T> void a(@NotNull o0<? super T> o0Var, int i10) {
        Continuation<? super T> b4 = o0Var.b();
        boolean z10 = i10 == 4;
        if (!z10 && (b4 instanceof kotlinx.coroutines.internal.i) && b(i10) == b(o0Var.f51451d)) {
            CoroutineDispatcher coroutineDispatcher = ((kotlinx.coroutines.internal.i) b4).f51388e;
            CoroutineContext context = b4.getContext();
            if (coroutineDispatcher.isDispatchNeeded(context)) {
                coroutineDispatcher.dispatch(context, o0Var);
                return;
            } else {
                e(o0Var);
                return;
            }
        }
        d(o0Var, b4, z10);
    }

    public static final boolean b(int i10) {
        return i10 == 1 || i10 == 2;
    }

    public static final boolean c(int i10) {
        return i10 == 2;
    }

    public static final <T> void d(@NotNull o0<? super T> o0Var, @NotNull Continuation<? super T> continuation, boolean z10) {
        Object d10;
        boolean N0;
        Object f10 = o0Var.f();
        Throwable c4 = o0Var.c(f10);
        if (c4 != null) {
            Result.Companion companion = Result.Companion;
            d10 = kotlin.e.a(c4);
        } else {
            Result.Companion companion2 = Result.Companion;
            d10 = o0Var.d(f10);
        }
        Object m3565constructorimpl = Result.m3565constructorimpl(d10);
        if (z10) {
            kotlinx.coroutines.internal.i iVar = (kotlinx.coroutines.internal.i) continuation;
            Continuation<T> continuation2 = iVar.f51389f;
            Object obj = iVar.f51391h;
            CoroutineContext context = continuation2.getContext();
            Object c10 = ThreadContextKt.c(context, obj);
            n2<?> g3 = c10 != ThreadContextKt.f51364a ? CoroutineContextKt.g(continuation2, context, c10) : null;
            try {
                iVar.f51389f.resumeWith(m3565constructorimpl);
                kotlin.p pVar = kotlin.p.f51048a;
                if (g3 != null) {
                    if (!N0) {
                        return;
                    }
                }
                return;
            } finally {
                if (g3 == null || g3.N0()) {
                    ThreadContextKt.a(context, c10);
                }
            }
        }
        continuation.resumeWith(m3565constructorimpl);
    }

    public static final void e(o0<?> o0Var) {
        x0 a10 = j2.f51426a.a();
        if (a10.G()) {
            a10.B(o0Var);
            return;
        }
        a10.D(true);
        try {
            d(o0Var, o0Var.b(), true);
            do {
            } while (a10.I());
        } finally {
            try {
            } finally {
            }
        }
    }
}
