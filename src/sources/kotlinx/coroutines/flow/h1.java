package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.channels.BufferOverflow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Share.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class h1<T> implements p1<T>, c, kotlinx.coroutines.flow.internal.k<T> {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public final kotlinx.coroutines.n1 f51296b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ p1<T> f51297c;

    /* JADX WARN: Multi-variable type inference failed */
    public h1(@NotNull p1<? extends T> p1Var, @Nullable kotlinx.coroutines.n1 n1Var) {
        this.f51296b = n1Var;
        this.f51297c = p1Var;
    }

    @Override // kotlinx.coroutines.flow.j1, kotlinx.coroutines.flow.c
    @Nullable
    public Object a(@NotNull d<? super T> dVar, @NotNull Continuation<?> continuation) {
        return this.f51297c.a(dVar, continuation);
    }

    @Override // kotlinx.coroutines.flow.internal.k
    @NotNull
    public c<T> b(@NotNull CoroutineContext coroutineContext, int i10, @NotNull BufferOverflow bufferOverflow) {
        return q1.d(this, coroutineContext, i10, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.p1
    public T getValue() {
        return this.f51297c.getValue();
    }
}
