package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.jvm.internal.s;
import kotlinx.coroutines.channels.BufferOverflow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ChannelFlow.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class ChannelFlowOperator<S, T> extends ChannelFlow<T> {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public final kotlinx.coroutines.flow.c<S> f51302e;

    /* JADX WARN: Multi-variable type inference failed */
    public ChannelFlowOperator(@NotNull kotlinx.coroutines.flow.c<? extends S> cVar, @NotNull CoroutineContext coroutineContext, int i10, @NotNull BufferOverflow bufferOverflow) {
        super(coroutineContext, i10, bufferOverflow);
        this.f51302e = cVar;
    }

    public static /* synthetic */ Object l(ChannelFlowOperator channelFlowOperator, kotlinx.coroutines.flow.d dVar, Continuation continuation) {
        if (channelFlowOperator.f51300c == -3) {
            CoroutineContext context = continuation.getContext();
            CoroutineContext plus = context.plus(channelFlowOperator.f51299b);
            if (s.d(plus, context)) {
                Object p10 = channelFlowOperator.p(dVar, continuation);
                return p10 == sd.a.d() ? p10 : kotlin.p.f51048a;
            }
            c.b bVar = kotlin.coroutines.c.A0;
            if (s.d(plus.get(bVar), context.get(bVar))) {
                Object n10 = channelFlowOperator.n(dVar, plus, continuation);
                return n10 == sd.a.d() ? n10 : kotlin.p.f51048a;
            }
        }
        Object a10 = super.a(dVar, continuation);
        return a10 == sd.a.d() ? a10 : kotlin.p.f51048a;
    }

    public static /* synthetic */ Object m(ChannelFlowOperator channelFlowOperator, kotlinx.coroutines.channels.m mVar, Continuation continuation) {
        Object p10 = channelFlowOperator.p(new p(mVar), continuation);
        return p10 == sd.a.d() ? p10 : kotlin.p.f51048a;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow, kotlinx.coroutines.flow.c
    @Nullable
    public Object a(@NotNull kotlinx.coroutines.flow.d<? super T> dVar, @NotNull Continuation<? super kotlin.p> continuation) {
        return l(this, dVar, continuation);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @Nullable
    public Object e(@NotNull kotlinx.coroutines.channels.m<? super T> mVar, @NotNull Continuation<? super kotlin.p> continuation) {
        return m(this, mVar, continuation);
    }

    public final Object n(kotlinx.coroutines.flow.d<? super T> dVar, CoroutineContext coroutineContext, Continuation<? super kotlin.p> continuation) {
        Object c4 = d.c(coroutineContext, d.a(dVar, continuation.getContext()), null, new ChannelFlowOperator$collectWithContextUndispatched$2(this, null), continuation, 4, null);
        return c4 == sd.a.d() ? c4 : kotlin.p.f51048a;
    }

    @Nullable
    public abstract Object p(@NotNull kotlinx.coroutines.flow.d<? super T> dVar, @NotNull Continuation<? super kotlin.p> continuation);

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @NotNull
    public String toString() {
        return ((Object) this.f51302e) + " -> " + super.toString();
    }
}
