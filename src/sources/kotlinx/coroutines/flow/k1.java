package kotlinx.coroutines.flow;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.channels.BufferOverflow;
import org.jetbrains.annotations.NotNull;

/* compiled from: SharedFlow.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class k1 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final kotlinx.coroutines.internal.f0 f51336a = new kotlinx.coroutines.internal.f0("NO_VALUE");

    @NotNull
    public static final <T> c<T> c(@NotNull j1<? extends T> j1Var, @NotNull CoroutineContext coroutineContext, int i10, @NotNull BufferOverflow bufferOverflow) {
        return ((i10 == 0 || i10 == -3) && bufferOverflow == BufferOverflow.SUSPEND) ? j1Var : new kotlinx.coroutines.flow.internal.f(j1Var, coroutineContext, i10, bufferOverflow);
    }

    public static final Object d(Object[] objArr, long j10) {
        return objArr[(objArr.length - 1) & ((int) j10)];
    }

    public static final void e(Object[] objArr, long j10, Object obj) {
        objArr[(objArr.length - 1) & ((int) j10)] = obj;
    }
}
