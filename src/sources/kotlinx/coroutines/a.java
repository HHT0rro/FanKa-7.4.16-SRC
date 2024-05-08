package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AbstractCoroutine.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class a<T> extends u1 implements Continuation<T>, h0 {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public final CoroutineContext f51122c;

    public a(@NotNull CoroutineContext coroutineContext, boolean z10, boolean z11) {
        super(z11);
        if (z10) {
            g0((n1) coroutineContext.get(n1.C0));
        }
        this.f51122c = coroutineContext.plus(this);
    }

    public void I0(@Nullable Object obj) {
        K(obj);
    }

    public void J0(@NotNull Throwable th, boolean z10) {
    }

    public void K0(T t2) {
    }

    public final <R> void L0(@NotNull CoroutineStart coroutineStart, R r10, @NotNull Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2) {
        coroutineStart.invoke(function2, r10, this);
    }

    @Override // kotlinx.coroutines.u1
    @NotNull
    public String Q() {
        return j0.a(this) + " was cancelled";
    }

    @Override // kotlinx.coroutines.u1
    public final void f0(@NotNull Throwable th) {
        e0.a(this.f51122c, th);
    }

    @Override // kotlin.coroutines.Continuation
    @NotNull
    public final CoroutineContext getContext() {
        return this.f51122c;
    }

    @Override // kotlinx.coroutines.h0
    @NotNull
    public CoroutineContext getCoroutineContext() {
        return this.f51122c;
    }

    @Override // kotlinx.coroutines.u1, kotlinx.coroutines.n1
    public boolean isActive() {
        return super.isActive();
    }

    @Override // kotlinx.coroutines.u1
    @NotNull
    public String n0() {
        String b4 = CoroutineContextKt.b(this.f51122c);
        if (b4 == null) {
            return super.n0();
        }
        return '\"' + b4 + "\":" + super.n0();
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(@NotNull Object obj) {
        Object l02 = l0(a0.d(obj, null, 1, null));
        if (l02 == v1.f51548b) {
            return;
        }
        I0(l02);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.u1
    public final void s0(@Nullable Object obj) {
        if (obj instanceof x) {
            x xVar = (x) obj;
            J0(xVar.f51562a, xVar.a());
        } else {
            K0(obj);
        }
    }
}
