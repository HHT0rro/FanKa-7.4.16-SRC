package kotlinx.coroutines.internal;

import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.j2;
import kotlinx.coroutines.n1;
import kotlinx.coroutines.n2;
import kotlinx.coroutines.x0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DispatchedContinuation.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class j {

    /* renamed from: a */
    @NotNull
    public static final f0 f51392a = new f0("UNDEFINED");

    /* renamed from: b */
    @NotNull
    public static final f0 f51393b = new f0("REUSABLE_CLAIMED");

    public static final /* synthetic */ f0 a() {
        return f51392a;
    }

    /* JADX WARN: Finally extract failed */
    public static final <T> void b(@NotNull Continuation<? super T> continuation, @NotNull Object obj, @Nullable Function1<? super Throwable, kotlin.p> function1) {
        boolean z10;
        if (continuation instanceof i) {
            i iVar = (i) continuation;
            Object b4 = kotlinx.coroutines.a0.b(obj, function1);
            if (iVar.f51388e.isDispatchNeeded(iVar.getContext())) {
                iVar.f51390g = b4;
                iVar.f51451d = 1;
                iVar.f51388e.dispatch(iVar.getContext(), iVar);
                return;
            }
            x0 a10 = j2.f51426a.a();
            if (a10.G()) {
                iVar.f51390g = b4;
                iVar.f51451d = 1;
                a10.B(iVar);
                return;
            }
            a10.D(true);
            try {
                n1 n1Var = (n1) iVar.getContext().get(n1.C0);
                if (n1Var == null || n1Var.isActive()) {
                    z10 = false;
                } else {
                    CancellationException w3 = n1Var.w();
                    iVar.a(b4, w3);
                    Result.Companion companion = Result.Companion;
                    iVar.resumeWith(Result.m3565constructorimpl(kotlin.e.a(w3)));
                    z10 = true;
                }
                if (!z10) {
                    Continuation<T> continuation2 = iVar.f51389f;
                    Object obj2 = iVar.f51391h;
                    CoroutineContext context = continuation2.getContext();
                    Object c4 = ThreadContextKt.c(context, obj2);
                    n2<?> g3 = c4 != ThreadContextKt.f51364a ? CoroutineContextKt.g(continuation2, context, c4) : null;
                    try {
                        iVar.f51389f.resumeWith(obj);
                        kotlin.p pVar = kotlin.p.f51048a;
                        if (g3 == null || g3.N0()) {
                            ThreadContextKt.a(context, c4);
                        }
                    } catch (Throwable th) {
                        if (g3 == null || g3.N0()) {
                            ThreadContextKt.a(context, c4);
                        }
                        throw th;
                    }
                }
                do {
                } while (a10.I());
            } finally {
                try {
                    return;
                } finally {
                }
            }
            return;
        }
        continuation.resumeWith(obj);
    }

    public static /* synthetic */ void c(Continuation continuation, Object obj, Function1 function1, int i10, Object obj2) {
        if ((i10 & 2) != 0) {
            function1 = null;
        }
        b(continuation, obj, function1);
    }

    public static final boolean d(@NotNull i<? super kotlin.p> iVar) {
        kotlin.p pVar = kotlin.p.f51048a;
        x0 a10 = j2.f51426a.a();
        if (a10.H()) {
            return false;
        }
        if (a10.G()) {
            iVar.f51390g = pVar;
            iVar.f51451d = 1;
            a10.B(iVar);
            return true;
        }
        a10.D(true);
        try {
            iVar.run();
            do {
            } while (a10.I());
        } finally {
            try {
                return false;
            } finally {
            }
        }
        return false;
    }
}
