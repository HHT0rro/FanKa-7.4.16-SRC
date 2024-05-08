package kotlinx.coroutines.channels;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: TickerChannels.kt */
@kotlin.d
@td.d(c = "kotlinx.coroutines.channels.TickerChannelsKt", f = "TickerChannels.kt", l = {84, 88, 94, 96}, m = "fixedPeriodTicker")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class TickerChannelsKt$fixedPeriodTicker$1 extends ContinuationImpl {
    public long J$0;
    public long J$1;
    public Object L$0;
    public int label;
    public /* synthetic */ Object result;

    public TickerChannelsKt$fixedPeriodTicker$1(Continuation<? super TickerChannelsKt$fixedPeriodTicker$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object d10;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        d10 = TickerChannelsKt.d(0L, 0L, null, this);
        return d10;
    }
}
