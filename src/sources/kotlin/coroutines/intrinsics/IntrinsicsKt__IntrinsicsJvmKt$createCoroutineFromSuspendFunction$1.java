package kotlin.coroutines.intrinsics;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.RestrictedContinuationImpl;
import kotlin.e;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: IntrinsicsJvm.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$1 extends RestrictedContinuationImpl {
    public final /* synthetic */ Function1<Continuation<Object>, Object> $block;
    private int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$1(Continuation<Object> continuation, Function1<? super Continuation<Object>, ? extends Object> function1) {
        super(continuation);
        this.$block = function1;
        s.g(continuation, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public Object invokeSuspend(@NotNull Object obj) {
        int i10 = this.label;
        if (i10 == 0) {
            this.label = 1;
            e.b(obj);
            return this.$block.invoke(this);
        }
        if (i10 == 1) {
            this.label = 2;
            e.b(obj);
            return obj;
        }
        throw new IllegalStateException("This coroutine had already completed".toString());
    }
}
