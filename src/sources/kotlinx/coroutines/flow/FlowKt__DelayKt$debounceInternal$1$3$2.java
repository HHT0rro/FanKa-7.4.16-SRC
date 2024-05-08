package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.channels.ChannelResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Delay.kt */
@kotlin.d
@td.d(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$2", f = "Delay.kt", l = {243}, m = "invokeSuspend")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class FlowKt__DelayKt$debounceInternal$1$3$2 extends SuspendLambda implements Function2<ChannelResult<? extends Object>, Continuation<? super kotlin.p>, Object> {
    public final /* synthetic */ d<Object> $downstream;
    public final /* synthetic */ Ref$ObjectRef<Object> $lastValue;
    public /* synthetic */ Object L$0;
    public Object L$1;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__DelayKt$debounceInternal$1$3$2(Ref$ObjectRef<Object> ref$ObjectRef, d<Object> dVar, Continuation<? super FlowKt__DelayKt$debounceInternal$1$3$2> continuation) {
        super(2, continuation);
        this.$lastValue = ref$ObjectRef;
        this.$downstream = dVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<kotlin.p> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        FlowKt__DelayKt$debounceInternal$1$3$2 flowKt__DelayKt$debounceInternal$1$3$2 = new FlowKt__DelayKt$debounceInternal$1$3$2(this.$lastValue, this.$downstream, continuation);
        flowKt__DelayKt$debounceInternal$1$3$2.L$0 = obj;
        return flowKt__DelayKt$debounceInternal$1$3$2;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo1743invoke(ChannelResult<? extends Object> channelResult, Continuation<? super kotlin.p> continuation) {
        return m3591invokeWpGqRn0(channelResult.m3589unboximpl(), continuation);
    }

    @Nullable
    /* renamed from: invoke-WpGqRn0, reason: not valid java name */
    public final Object m3591invokeWpGqRn0(@NotNull Object obj, @Nullable Continuation<? super kotlin.p> continuation) {
        return ((FlowKt__DelayKt$debounceInternal$1$3$2) create(ChannelResult.m3577boximpl(obj), continuation)).invokeSuspend(kotlin.p.f51048a);
    }

    /* JADX WARN: Type inference failed for: r7v3, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v6, types: [T, kotlinx.coroutines.internal.f0] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Ref$ObjectRef<Object> ref$ObjectRef;
        Ref$ObjectRef<Object> ref$ObjectRef2;
        Object d10 = sd.a.d();
        int i10 = this.label;
        if (i10 == 0) {
            kotlin.e.b(obj);
            ?? m3589unboximpl = ((ChannelResult) this.L$0).m3589unboximpl();
            ref$ObjectRef = this.$lastValue;
            boolean z10 = m3589unboximpl instanceof ChannelResult.Failed;
            if (!z10) {
                ref$ObjectRef.element = m3589unboximpl;
            }
            d<Object> dVar = this.$downstream;
            if (z10) {
                Throwable m3581exceptionOrNullimpl = ChannelResult.m3581exceptionOrNullimpl(m3589unboximpl);
                if (m3581exceptionOrNullimpl == null) {
                    Object obj2 = ref$ObjectRef.element;
                    if (obj2 != null) {
                        if (obj2 == kotlinx.coroutines.flow.internal.n.f51330a) {
                            obj2 = null;
                        }
                        this.L$0 = m3589unboximpl;
                        this.L$1 = ref$ObjectRef;
                        this.label = 1;
                        if (dVar.emit(obj2, this) == d10) {
                            return d10;
                        }
                        ref$ObjectRef2 = ref$ObjectRef;
                    }
                    ref$ObjectRef.element = kotlinx.coroutines.flow.internal.n.f51332c;
                } else {
                    throw m3581exceptionOrNullimpl;
                }
            }
            return kotlin.p.f51048a;
        }
        if (i10 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ref$ObjectRef2 = (Ref$ObjectRef) this.L$1;
        kotlin.e.b(obj);
        ref$ObjectRef = ref$ObjectRef2;
        ref$ObjectRef.element = kotlinx.coroutines.flow.internal.n.f51332c;
        return kotlin.p.f51048a;
    }
}
