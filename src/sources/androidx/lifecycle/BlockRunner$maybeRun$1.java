package androidx.lifecycle;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.p;
import kotlinx.coroutines.h0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CoroutineLiveData.kt */
@td.d(c = "androidx.lifecycle.BlockRunner$maybeRun$1", f = "CoroutineLiveData.kt", l = {177}, m = "invokeSuspend")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class BlockRunner$maybeRun$1 extends SuspendLambda implements Function2<h0, Continuation<? super p>, Object> {
    private /* synthetic */ Object L$0;
    public int label;
    public final /* synthetic */ BlockRunner<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BlockRunner$maybeRun$1(BlockRunner<T> blockRunner, Continuation<? super BlockRunner$maybeRun$1> continuation) {
        super(2, continuation);
        this.this$0 = blockRunner;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<p> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        BlockRunner$maybeRun$1 blockRunner$maybeRun$1 = new BlockRunner$maybeRun$1(this.this$0, continuation);
        blockRunner$maybeRun$1.L$0 = obj;
        return blockRunner$maybeRun$1;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final Object mo1743invoke(@NotNull h0 h0Var, @Nullable Continuation<? super p> continuation) {
        return ((BlockRunner$maybeRun$1) create(h0Var, continuation)).invokeSuspend(p.f51048a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        CoroutineLiveData coroutineLiveData;
        Function2 function2;
        Function0 function0;
        Object d10 = sd.a.d();
        int i10 = this.label;
        if (i10 == 0) {
            kotlin.e.b(obj);
            h0 h0Var = (h0) this.L$0;
            coroutineLiveData = ((BlockRunner) this.this$0).liveData;
            LiveDataScopeImpl liveDataScopeImpl = new LiveDataScopeImpl(coroutineLiveData, h0Var.getCoroutineContext());
            function2 = ((BlockRunner) this.this$0).block;
            this.label = 1;
            if (function2.mo1743invoke(liveDataScopeImpl, this) == d10) {
                return d10;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.e.b(obj);
        }
        function0 = ((BlockRunner) this.this$0).onDone;
        function0.invoke();
        return p.f51048a;
    }
}
