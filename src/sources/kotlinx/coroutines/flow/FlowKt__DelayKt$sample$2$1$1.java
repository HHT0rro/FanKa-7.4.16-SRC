package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.internal.ChildCancelledException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Delay.kt */
@kotlin.d
@td.d(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2$1$1", f = "Delay.kt", l = {}, m = "invokeSuspend")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class FlowKt__DelayKt$sample$2$1$1 extends SuspendLambda implements Function2<ChannelResult<? extends Object>, Continuation<? super kotlin.p>, Object> {
    public final /* synthetic */ Ref$ObjectRef<Object> $lastValue;
    public final /* synthetic */ ReceiveChannel<kotlin.p> $ticker;
    public /* synthetic */ Object L$0;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__DelayKt$sample$2$1$1(Ref$ObjectRef<Object> ref$ObjectRef, ReceiveChannel<kotlin.p> receiveChannel, Continuation<? super FlowKt__DelayKt$sample$2$1$1> continuation) {
        super(2, continuation);
        this.$lastValue = ref$ObjectRef;
        this.$ticker = receiveChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<kotlin.p> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        FlowKt__DelayKt$sample$2$1$1 flowKt__DelayKt$sample$2$1$1 = new FlowKt__DelayKt$sample$2$1$1(this.$lastValue, this.$ticker, continuation);
        flowKt__DelayKt$sample$2$1$1.L$0 = obj;
        return flowKt__DelayKt$sample$2$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo1743invoke(ChannelResult<? extends Object> channelResult, Continuation<? super kotlin.p> continuation) {
        return m3592invokeWpGqRn0(channelResult.m3589unboximpl(), continuation);
    }

    @Nullable
    /* renamed from: invoke-WpGqRn0, reason: not valid java name */
    public final Object m3592invokeWpGqRn0(@NotNull Object obj, @Nullable Continuation<? super kotlin.p> continuation) {
        return ((FlowKt__DelayKt$sample$2$1$1) create(ChannelResult.m3577boximpl(obj), continuation)).invokeSuspend(kotlin.p.f51048a);
    }

    /* JADX WARN: Type inference failed for: r4v4, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v8, types: [T, kotlinx.coroutines.internal.f0] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        sd.a.d();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        kotlin.e.b(obj);
        ?? m3589unboximpl = ((ChannelResult) this.L$0).m3589unboximpl();
        Ref$ObjectRef<Object> ref$ObjectRef = this.$lastValue;
        boolean z10 = m3589unboximpl instanceof ChannelResult.Failed;
        if (!z10) {
            ref$ObjectRef.element = m3589unboximpl;
        }
        ReceiveChannel<kotlin.p> receiveChannel = this.$ticker;
        if (z10) {
            Throwable m3581exceptionOrNullimpl = ChannelResult.m3581exceptionOrNullimpl(m3589unboximpl);
            if (m3581exceptionOrNullimpl == null) {
                receiveChannel.a(new ChildCancelledException());
                ref$ObjectRef.element = kotlinx.coroutines.flow.internal.n.f51332c;
            } else {
                throw m3581exceptionOrNullimpl;
            }
        }
        return kotlin.p.f51048a;
    }
}
