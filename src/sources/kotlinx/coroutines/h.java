package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.c;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.internal.ThreadContextKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Builders.common.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final /* synthetic */ class h {
    @NotNull
    public static final n1 a(@NotNull h0 h0Var, @NotNull CoroutineContext coroutineContext, @NotNull CoroutineStart coroutineStart, @NotNull Function2<? super h0, ? super Continuation<? super kotlin.p>, ? extends Object> function2) {
        a f2Var;
        CoroutineContext e2 = CoroutineContextKt.e(h0Var, coroutineContext);
        if (coroutineStart.isLazy()) {
            f2Var = new w1(e2, function2);
        } else {
            f2Var = new f2(e2, true);
        }
        f2Var.L0(coroutineStart, f2Var, function2);
        return f2Var;
    }

    public static /* synthetic */ n1 b(h0 h0Var, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2 function2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i10 & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return g.a(h0Var, coroutineContext, coroutineStart, function2);
    }

    @Nullable
    public static final <T> Object c(@NotNull CoroutineContext coroutineContext, @NotNull Function2<? super h0, ? super Continuation<? super T>, ? extends Object> function2, @NotNull Continuation<? super T> continuation) {
        Object N0;
        CoroutineContext context = continuation.getContext();
        CoroutineContext d10 = CoroutineContextKt.d(context, coroutineContext);
        q1.g(d10);
        if (d10 == context) {
            kotlinx.coroutines.internal.b0 b0Var = new kotlinx.coroutines.internal.b0(d10, continuation);
            N0 = ee.b.e(b0Var, b0Var, function2);
        } else {
            c.b bVar = kotlin.coroutines.c.A0;
            if (kotlin.jvm.internal.s.d(d10.get(bVar), context.get(bVar))) {
                n2 n2Var = new n2(d10, continuation);
                Object c4 = ThreadContextKt.c(d10, null);
                try {
                    Object e2 = ee.b.e(n2Var, n2Var, function2);
                    ThreadContextKt.a(d10, c4);
                    N0 = e2;
                } catch (Throwable th) {
                    ThreadContextKt.a(d10, c4);
                    throw th;
                }
            } else {
                n0 n0Var = new n0(d10, continuation);
                ee.a.e(function2, n0Var, n0Var, null, 4, null);
                N0 = n0Var.N0();
            }
        }
        if (N0 == sd.a.d()) {
            td.f.c(continuation);
        }
        return N0;
    }
}
