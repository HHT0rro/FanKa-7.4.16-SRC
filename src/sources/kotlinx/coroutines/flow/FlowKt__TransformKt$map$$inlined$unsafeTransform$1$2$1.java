package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Emitters.kt */
@kotlin.d
@td.d(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2", f = "Transform.kt", l = {223, 223}, m = "emit")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2$1 extends ContinuationImpl {
    public Object L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ t0 this$0;

    public FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2$1(t0 t0Var, Continuation continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        throw null;
    }
}
