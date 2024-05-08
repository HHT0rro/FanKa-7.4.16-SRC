package kotlinx.coroutines.flow;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.channels.BufferOverflow;
import org.jetbrains.annotations.NotNull;

/* compiled from: StateFlow.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class q1 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final kotlinx.coroutines.internal.f0 f51344a = new kotlinx.coroutines.internal.f0("NONE");

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final kotlinx.coroutines.internal.f0 f51345b = new kotlinx.coroutines.internal.f0("PENDING");

    @NotNull
    public static final <T> g1<T> a(T t2) {
        if (t2 == null) {
            t2 = (T) kotlinx.coroutines.flow.internal.n.f51330a;
        }
        return new StateFlowImpl(t2);
    }

    @NotNull
    public static final <T> c<T> d(@NotNull p1<? extends T> p1Var, @NotNull CoroutineContext coroutineContext, int i10, @NotNull BufferOverflow bufferOverflow) {
        boolean z10 = false;
        if (i10 >= 0 && i10 < 2) {
            z10 = true;
        }
        return ((z10 || i10 == -2) && bufferOverflow == BufferOverflow.DROP_OLDEST) ? p1Var : k1.c(p1Var, coroutineContext, i10, bufferOverflow);
    }
}
