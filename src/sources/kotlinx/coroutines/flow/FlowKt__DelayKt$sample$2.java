package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Delay.kt */
@kotlin.d
@td.d(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2", f = "Delay.kt", l = {352}, m = "invokeSuspend")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
final class FlowKt__DelayKt$sample$2 extends SuspendLambda implements Function3<kotlinx.coroutines.h0, d<Object>, Continuation<? super kotlin.p>, Object> {
    public final /* synthetic */ long $periodMillis;
    public final /* synthetic */ c<Object> $this_sample;
    private /* synthetic */ Object L$0;
    public /* synthetic */ Object L$1;
    public Object L$2;
    public Object L$3;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__DelayKt$sample$2(long j10, c<Object> cVar, Continuation<? super FlowKt__DelayKt$sample$2> continuation) {
        super(3, continuation);
        this.$periodMillis = j10;
        this.$this_sample = cVar;
    }

    @Override // kotlin.jvm.functions.Function3
    @Nullable
    public final Object invoke(@NotNull kotlinx.coroutines.h0 h0Var, @NotNull d<Object> dVar, @Nullable Continuation<? super kotlin.p> continuation) {
        FlowKt__DelayKt$sample$2 flowKt__DelayKt$sample$2 = new FlowKt__DelayKt$sample$2(this.$periodMillis, this.$this_sample, continuation);
        flowKt__DelayKt$sample$2.L$0 = h0Var;
        flowKt__DelayKt$sample$2.L$1 = dVar;
        return flowKt__DelayKt$sample$2.invokeSuspend(kotlin.p.f51048a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        ReceiveChannel b4;
        d dVar;
        ReceiveChannel receiveChannel;
        Ref$ObjectRef ref$ObjectRef;
        ReceiveChannel receiveChannel2;
        Object d10 = sd.a.d();
        int i10 = this.label;
        if (i10 == 0) {
            kotlin.e.b(obj);
            kotlinx.coroutines.h0 h0Var = (kotlinx.coroutines.h0) this.L$0;
            d dVar2 = (d) this.L$1;
            ReceiveChannel d11 = ProduceKt.d(h0Var, null, -1, new FlowKt__DelayKt$sample$2$values$1(this.$this_sample, null), 1, null);
            Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
            b4 = FlowKt__DelayKt.b(h0Var, this.$periodMillis, 0L, 2, null);
            dVar = dVar2;
            receiveChannel = d11;
            ref$ObjectRef = ref$ObjectRef2;
            receiveChannel2 = b4;
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            receiveChannel2 = (ReceiveChannel) this.L$3;
            ref$ObjectRef = (Ref$ObjectRef) this.L$2;
            receiveChannel = (ReceiveChannel) this.L$1;
            dVar = (d) this.L$0;
            kotlin.e.b(obj);
        }
        while (ref$ObjectRef.element != kotlinx.coroutines.flow.internal.n.f51332c) {
            this.L$0 = dVar;
            this.L$1 = receiveChannel;
            this.L$2 = ref$ObjectRef;
            this.L$3 = receiveChannel2;
            this.label = 1;
            kotlinx.coroutines.selects.b bVar = new kotlinx.coroutines.selects.b(this);
            try {
                bVar.o(receiveChannel.n(), new FlowKt__DelayKt$sample$2$1$1(ref$ObjectRef, receiveChannel2, null));
                bVar.o(receiveChannel2.A(), new FlowKt__DelayKt$sample$2$1$2(ref$ObjectRef, dVar, null));
            } catch (Throwable th) {
                bVar.V(th);
            }
            Object U = bVar.U();
            if (U == sd.a.d()) {
                td.f.c(this);
            }
            if (U == d10) {
                return d10;
            }
        }
        return kotlin.p.f51048a;
    }
}
