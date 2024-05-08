package kotlinx.coroutines.channels;

import android.view.autofill.AutofillManager;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Deprecated.kt */
@kotlin.d
@td.d(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", l = {404}, m = AutofillManager.ANY_HINT)
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class ChannelsKt__DeprecatedKt$any$1<E> extends ContinuationImpl {
    public Object L$0;
    public int label;
    public /* synthetic */ Object result;

    public ChannelsKt__DeprecatedKt$any$1(Continuation<? super ChannelsKt__DeprecatedKt$any$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object a10;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        a10 = ChannelsKt__DeprecatedKt.a(null, this);
        return a10;
    }
}
