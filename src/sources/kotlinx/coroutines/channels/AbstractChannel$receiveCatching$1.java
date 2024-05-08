package kotlinx.coroutines.channels;

import com.android.internal.logging.nano.MetricsProto;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AbstractChannel.kt */
@kotlin.d
@td.d(c = "kotlinx.coroutines.channels.AbstractChannel", f = "AbstractChannel.kt", l = {MetricsProto.MetricsEvent.ACTION_PERMISSION_REVOKE_UNKNOWN}, m = "receiveCatching-JP2dKIU")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class AbstractChannel$receiveCatching$1 extends ContinuationImpl {
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ AbstractChannel<E> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractChannel$receiveCatching$1(AbstractChannel<E> abstractChannel, Continuation<? super AbstractChannel$receiveCatching$1> continuation) {
        super(continuation);
        this.this$0 = abstractChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object p10 = this.this$0.p(this);
        return p10 == sd.a.d() ? p10 : ChannelResult.m3577boximpl(p10);
    }
}
