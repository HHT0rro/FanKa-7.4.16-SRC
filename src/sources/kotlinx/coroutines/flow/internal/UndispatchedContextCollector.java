package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.internal.ThreadContextKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ChannelFlow.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class UndispatchedContextCollector<T> implements kotlinx.coroutines.flow.d<T> {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final CoroutineContext f51317b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public final Object f51318c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public final Function2<T, Continuation<? super kotlin.p>, Object> f51319d;

    public UndispatchedContextCollector(@NotNull kotlinx.coroutines.flow.d<? super T> dVar, @NotNull CoroutineContext coroutineContext) {
        this.f51317b = coroutineContext;
        this.f51318c = ThreadContextKt.b(coroutineContext);
        this.f51319d = new UndispatchedContextCollector$emitRef$1(dVar, null);
    }

    @Override // kotlinx.coroutines.flow.d
    @Nullable
    public Object emit(T t2, @NotNull Continuation<? super kotlin.p> continuation) {
        Object b4 = d.b(this.f51317b, t2, this.f51318c, this.f51319d, continuation);
        return b4 == sd.a.d() ? b4 : kotlin.p.f51048a;
    }
}
