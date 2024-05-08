package kotlinx.coroutines.sync;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Semaphore.kt */
@kotlin.d
@td.d(c = "kotlinx.coroutines.sync.SemaphoreKt", f = "Semaphore.kt", l = {85}, m = "withPermit")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class SemaphoreKt$withPermit$1<T> extends ContinuationImpl {
    public Object L$0;
    public Object L$1;
    public int label;
    public /* synthetic */ Object result;

    public SemaphoreKt$withPermit$1(Continuation<? super SemaphoreKt$withPermit$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return SemaphoreKt.i(null, null, this);
    }
}
