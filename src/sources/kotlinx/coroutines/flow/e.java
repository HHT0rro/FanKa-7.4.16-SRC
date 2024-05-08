package kotlinx.coroutines.flow;

import java.util.Collection;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ReceiveChannel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class e {
    @Nullable
    public static final <T> Object A(@NotNull c<? extends T> cVar, @NotNull Continuation<? super T> continuation) {
        return FlowKt__ReduceKt.i(cVar, continuation);
    }

    @Nullable
    public static final <T> Object B(@NotNull c<? extends T> cVar, @NotNull Continuation<? super T> continuation) {
        return FlowKt__ReduceKt.j(cVar, continuation);
    }

    @Nullable
    public static final <T, C extends Collection<? super T>> Object C(@NotNull c<? extends T> cVar, @NotNull C c4, @NotNull Continuation<? super C> continuation) {
        return FlowKt__CollectionKt.a(cVar, c4, continuation);
    }

    @NotNull
    public static final <T, R> c<R> D(@NotNull c<? extends T> cVar, @NotNull Function3<? super d<? super R>, ? super T, ? super Continuation<? super kotlin.p>, ? extends Object> function3) {
        return FlowKt__MergeKt.b(cVar, function3);
    }

    @NotNull
    public static final <T> p1<T> a(@NotNull g1<T> g1Var) {
        return l0.a(g1Var);
    }

    @NotNull
    public static final <T> c<T> b(@NotNull c<? extends T> cVar, int i10, @NotNull BufferOverflow bufferOverflow) {
        return t.a(cVar, i10, bufferOverflow);
    }

    @NotNull
    public static final <T> c<T> d(@NotNull Function2<? super kotlinx.coroutines.channels.m<? super T>, ? super Continuation<? super kotlin.p>, ? extends Object> function2) {
        return p.a(function2);
    }

    @Nullable
    public static final <T> Object e(@NotNull c<? extends T> cVar, @NotNull d<? super T> dVar, @NotNull Continuation<? super Throwable> continuation) {
        return FlowKt__ErrorsKt.a(cVar, dVar, continuation);
    }

    @Nullable
    public static final Object f(@NotNull c<?> cVar, @NotNull Continuation<? super kotlin.p> continuation) {
        return s.a(cVar, continuation);
    }

    @Nullable
    public static final <T> Object g(@NotNull c<? extends T> cVar, @NotNull Function2<? super T, ? super Continuation<? super kotlin.p>, ? extends Object> function2, @NotNull Continuation<? super kotlin.p> continuation) {
        return s.b(cVar, function2, continuation);
    }

    @NotNull
    public static final <T> c<T> h(@NotNull c<? extends T> cVar) {
        return t.c(cVar);
    }

    @Nullable
    public static final <T> Object i(@NotNull c<? extends T> cVar, @NotNull Continuation<? super Integer> continuation) {
        return FlowKt__CountKt.a(cVar, continuation);
    }

    @Nullable
    public static final <T> Object j(@NotNull c<? extends T> cVar, @NotNull Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2, @NotNull Continuation<? super Integer> continuation) {
        return FlowKt__CountKt.b(cVar, function2, continuation);
    }

    @NotNull
    public static final <T> c<T> k(@NotNull c<? extends T> cVar) {
        return FlowKt__DistinctKt.a(cVar);
    }

    @Nullable
    public static final <T> Object l(@NotNull d<? super T> dVar, @NotNull ReceiveChannel<? extends T> receiveChannel, @NotNull Continuation<? super kotlin.p> continuation) {
        return FlowKt__ChannelsKt.b(dVar, receiveChannel, continuation);
    }

    @Nullable
    public static final <T> Object m(@NotNull d<? super T> dVar, @NotNull c<? extends T> cVar, @NotNull Continuation<? super kotlin.p> continuation) {
        return s.c(dVar, cVar, continuation);
    }

    public static final void n(@NotNull d<?> dVar) {
        FlowKt__EmittersKt.b(dVar);
    }

    @Nullable
    public static final <T> Object o(@NotNull c<? extends T> cVar, @NotNull Continuation<? super T> continuation) {
        return FlowKt__ReduceKt.a(cVar, continuation);
    }

    @Nullable
    public static final <T> Object p(@NotNull c<? extends T> cVar, @NotNull Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2, @NotNull Continuation<? super T> continuation) {
        return FlowKt__ReduceKt.b(cVar, function2, continuation);
    }

    @Nullable
    public static final <T> Object q(@NotNull c<? extends T> cVar, @NotNull Continuation<? super T> continuation) {
        return FlowKt__ReduceKt.c(cVar, continuation);
    }

    @Nullable
    public static final <T> Object r(@NotNull c<? extends T> cVar, @NotNull Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2, @NotNull Continuation<? super T> continuation) {
        return FlowKt__ReduceKt.d(cVar, function2, continuation);
    }

    @NotNull
    public static final ReceiveChannel<kotlin.p> s(@NotNull kotlinx.coroutines.h0 h0Var, long j10, long j11) {
        return FlowKt__DelayKt.a(h0Var, j10, j11);
    }

    @NotNull
    public static final <T> c<T> u(@NotNull Function2<? super d<? super T>, ? super Continuation<? super kotlin.p>, ? extends Object> function2) {
        return p.b(function2);
    }

    @NotNull
    public static final <T> c<T> v(T t2) {
        return p.c(t2);
    }

    @Nullable
    public static final <T> Object w(@NotNull c<? extends T> cVar, @NotNull Continuation<? super T> continuation) {
        return FlowKt__ReduceKt.f(cVar, continuation);
    }

    @Nullable
    public static final <T> Object x(@NotNull c<? extends T> cVar, @NotNull Continuation<? super T> continuation) {
        return FlowKt__ReduceKt.g(cVar, continuation);
    }

    @NotNull
    public static final <T, R> c<R> y(@NotNull c<? extends T> cVar, @NotNull Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2) {
        return FlowKt__MergeKt.a(cVar, function2);
    }

    @Nullable
    public static final <S, T extends S> Object z(@NotNull c<? extends T> cVar, @NotNull Function3<? super S, ? super T, ? super Continuation<? super S>, ? extends Object> function3, @NotNull Continuation<? super S> continuation) {
        return FlowKt__ReduceKt.h(cVar, function3, continuation);
    }
}
