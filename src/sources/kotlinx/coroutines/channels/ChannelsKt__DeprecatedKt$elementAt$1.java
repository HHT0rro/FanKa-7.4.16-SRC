package kotlinx.coroutines.channels;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Deprecated.kt */
@kotlin.d
@td.d(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", l = {38}, m = "elementAt")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class ChannelsKt__DeprecatedKt$elementAt$1<E> extends ContinuationImpl {
    public int I$0;
    public int I$1;
    public Object L$0;
    public Object L$1;
    public int label;
    public /* synthetic */ Object result;

    public ChannelsKt__DeprecatedKt$elementAt$1(Continuation<? super ChannelsKt__DeprecatedKt$elementAt$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object c4;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        c4 = ChannelsKt__DeprecatedKt.c(null, 0, this);
        return c4;
    }
}
