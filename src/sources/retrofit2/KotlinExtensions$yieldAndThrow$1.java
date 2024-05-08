package retrofit2;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: KotlinExtensions.kt */
@kotlin.d
@td.d(c = "retrofit2/KotlinExtensions", f = "KotlinExtensions.kt", l = {100, 102}, m = "yieldAndThrow")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class KotlinExtensions$yieldAndThrow$1 extends ContinuationImpl {
    public Object L$0;
    public int label;
    public /* synthetic */ Object result;

    public KotlinExtensions$yieldAndThrow$1(Continuation continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return KotlinExtensions.d(null, this);
    }
}
