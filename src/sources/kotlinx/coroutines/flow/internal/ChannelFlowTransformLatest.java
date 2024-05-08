package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.i0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Merge.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class ChannelFlowTransformLatest<T, R> extends ChannelFlowOperator<T, R> {

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public final Function3<kotlinx.coroutines.flow.d<? super R>, T, Continuation<? super kotlin.p>, Object> f51303f;

    public /* synthetic */ ChannelFlowTransformLatest(Function3 function3, kotlinx.coroutines.flow.c cVar, CoroutineContext coroutineContext, int i10, BufferOverflow bufferOverflow, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(function3, cVar, (i11 & 4) != 0 ? EmptyCoroutineContext.INSTANCE : coroutineContext, (i11 & 8) != 0 ? -2 : i10, (i11 & 16) != 0 ? BufferOverflow.SUSPEND : bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @NotNull
    public ChannelFlow<R> f(@NotNull CoroutineContext coroutineContext, int i10, @NotNull BufferOverflow bufferOverflow) {
        return new ChannelFlowTransformLatest(this.f51303f, this.f51302e, coroutineContext, i10, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlowOperator
    @Nullable
    public Object p(@NotNull kotlinx.coroutines.flow.d<? super R> dVar, @NotNull Continuation<? super kotlin.p> continuation) {
        Object b4 = i0.b(new ChannelFlowTransformLatest$flowCollect$3(this, dVar, null), continuation);
        return b4 == sd.a.d() ? b4 : kotlin.p.f51048a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChannelFlowTransformLatest(@NotNull Function3<? super kotlinx.coroutines.flow.d<? super R>, ? super T, ? super Continuation<? super kotlin.p>, ? extends Object> function3, @NotNull kotlinx.coroutines.flow.c<? extends T> cVar, @NotNull CoroutineContext coroutineContext, int i10, @NotNull BufferOverflow bufferOverflow) {
        super(cVar, coroutineContext, i10, bufferOverflow);
        this.f51303f = function3;
    }
}
