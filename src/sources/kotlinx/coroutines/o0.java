package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.ThreadContextKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DispatchedTask.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class o0<T> extends fe.g {

    /* renamed from: d, reason: collision with root package name */
    public int f51451d;

    public o0(int i10) {
        this.f51451d = i10;
    }

    public void a(@Nullable Object obj, @NotNull Throwable th) {
    }

    @NotNull
    public abstract Continuation<T> b();

    @Nullable
    public Throwable c(@Nullable Object obj) {
        x xVar = obj instanceof x ? (x) obj : null;
        if (xVar != null) {
            return xVar.f51562a;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T d(@Nullable Object obj) {
        return obj;
    }

    public final void e(@Nullable Throwable th, @Nullable Throwable th2) {
        if (th == null && th2 == null) {
            return;
        }
        if (th != null && th2 != null) {
            kotlin.a.a(th, th2);
        }
        if (th == null) {
            th = th2;
        }
        kotlin.jvm.internal.s.f(th);
        e0.a(b().getContext(), new CoroutinesInternalError("Fatal exception in coroutines machinery for " + ((Object) this) + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th));
    }

    @Nullable
    public abstract Object f();

    @Override // java.lang.Runnable
    public final void run() {
        Object m3565constructorimpl;
        Object m3565constructorimpl2;
        fe.h hVar = this.f49334c;
        try {
            kotlinx.coroutines.internal.i iVar = (kotlinx.coroutines.internal.i) b();
            Continuation<T> continuation = iVar.f51389f;
            Object obj = iVar.f51391h;
            CoroutineContext context = continuation.getContext();
            Object c4 = ThreadContextKt.c(context, obj);
            n2<?> g3 = c4 != ThreadContextKt.f51364a ? CoroutineContextKt.g(continuation, context, c4) : null;
            try {
                CoroutineContext context2 = continuation.getContext();
                Object f10 = f();
                Throwable c10 = c(f10);
                n1 n1Var = (c10 == null && p0.b(this.f51451d)) ? (n1) context2.get(n1.C0) : null;
                if (n1Var != null && !n1Var.isActive()) {
                    CancellationException w3 = n1Var.w();
                    a(f10, w3);
                    Result.Companion companion = Result.Companion;
                    continuation.resumeWith(Result.m3565constructorimpl(kotlin.e.a(w3)));
                } else if (c10 != null) {
                    Result.Companion companion2 = Result.Companion;
                    continuation.resumeWith(Result.m3565constructorimpl(kotlin.e.a(c10)));
                } else {
                    Result.Companion companion3 = Result.Companion;
                    continuation.resumeWith(Result.m3565constructorimpl(d(f10)));
                }
                kotlin.p pVar = kotlin.p.f51048a;
                try {
                    Result.Companion companion4 = Result.Companion;
                    hVar.a();
                    m3565constructorimpl2 = Result.m3565constructorimpl(pVar);
                } catch (Throwable th) {
                    Result.Companion companion5 = Result.Companion;
                    m3565constructorimpl2 = Result.m3565constructorimpl(kotlin.e.a(th));
                }
                e(null, Result.m3568exceptionOrNullimpl(m3565constructorimpl2));
            } finally {
                if (g3 == null || g3.N0()) {
                    ThreadContextKt.a(context, c4);
                }
            }
        } catch (Throwable th2) {
            try {
                Result.Companion companion6 = Result.Companion;
                hVar.a();
                m3565constructorimpl = Result.m3565constructorimpl(kotlin.p.f51048a);
            } catch (Throwable th3) {
                Result.Companion companion7 = Result.Companion;
                m3565constructorimpl = Result.m3565constructorimpl(kotlin.e.a(th3));
            }
            e(th2, Result.m3568exceptionOrNullimpl(m3565constructorimpl));
        }
    }
}
