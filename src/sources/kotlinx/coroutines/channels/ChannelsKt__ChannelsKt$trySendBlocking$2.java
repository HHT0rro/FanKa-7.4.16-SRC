package kotlinx.coroutines.channels;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.h0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Channels.kt */
@kotlin.d
@td.d(c = "kotlinx.coroutines.channels.ChannelsKt__ChannelsKt$trySendBlocking$2", f = "Channels.kt", l = {39}, m = "invokeSuspend")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
final class ChannelsKt__ChannelsKt$trySendBlocking$2 extends SuspendLambda implements Function2<h0, Continuation<? super ChannelResult<? extends kotlin.p>>, Object> {
    public final /* synthetic */ Object $element;
    public final /* synthetic */ r<Object> $this_trySendBlocking;
    private /* synthetic */ Object L$0;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelsKt__ChannelsKt$trySendBlocking$2(r<Object> rVar, Object obj, Continuation<? super ChannelsKt__ChannelsKt$trySendBlocking$2> continuation) {
        super(2, continuation);
        this.$this_trySendBlocking = rVar;
        this.$element = obj;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<kotlin.p> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ChannelsKt__ChannelsKt$trySendBlocking$2 channelsKt__ChannelsKt$trySendBlocking$2 = new ChannelsKt__ChannelsKt$trySendBlocking$2(this.$this_trySendBlocking, this.$element, continuation);
        channelsKt__ChannelsKt$trySendBlocking$2.L$0 = obj;
        return channelsKt__ChannelsKt$trySendBlocking$2;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo1743invoke(h0 h0Var, Continuation<? super ChannelResult<? extends kotlin.p>> continuation) {
        return invoke2(h0Var, (Continuation<? super ChannelResult<kotlin.p>>) continuation);
    }

    @Nullable
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull h0 h0Var, @Nullable Continuation<? super ChannelResult<kotlin.p>> continuation) {
        return ((ChannelsKt__ChannelsKt$trySendBlocking$2) create(h0Var, continuation)).invokeSuspend(kotlin.p.f51048a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object m3565constructorimpl;
        Object d10 = sd.a.d();
        int i10 = this.label;
        try {
            if (i10 == 0) {
                kotlin.e.b(obj);
                r<Object> rVar = this.$this_trySendBlocking;
                Object obj2 = this.$element;
                Result.Companion companion = Result.Companion;
                this.label = 1;
                if (rVar.E(obj2, this) == d10) {
                    return d10;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.e.b(obj);
            }
            m3565constructorimpl = Result.m3565constructorimpl(kotlin.p.f51048a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m3565constructorimpl = Result.m3565constructorimpl(kotlin.e.a(th));
        }
        return ChannelResult.m3577boximpl(Result.m3572isSuccessimpl(m3565constructorimpl) ? ChannelResult.Companion.c(kotlin.p.f51048a) : ChannelResult.Companion.a(Result.m3568exceptionOrNullimpl(m3565constructorimpl)));
    }
}
