package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Add missing generic type declarations: [R, T] */
/* compiled from: Merge.kt */
@kotlin.d
@td.d(c = "kotlinx.coroutines.flow.FlowKt__MergeKt$mapLatest$1", f = "Merge.kt", l = {214, 214}, m = "invokeSuspend")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class FlowKt__MergeKt$mapLatest$1<R, T> extends SuspendLambda implements Function3<d<? super R>, T, Continuation<? super kotlin.p>, Object> {
    public final /* synthetic */ Function2<T, Continuation<? super R>, Object> $transform;
    private /* synthetic */ Object L$0;
    public /* synthetic */ Object L$1;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__MergeKt$mapLatest$1(Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super FlowKt__MergeKt$mapLatest$1> continuation) {
        super(3, continuation);
        this.$transform = function2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Continuation<? super kotlin.p> continuation) {
        return invoke((d) obj, (d<? super R>) obj2, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull d<? super R> dVar, T t2, @Nullable Continuation<? super kotlin.p> continuation) {
        FlowKt__MergeKt$mapLatest$1 flowKt__MergeKt$mapLatest$1 = new FlowKt__MergeKt$mapLatest$1(this.$transform, continuation);
        flowKt__MergeKt$mapLatest$1.L$0 = dVar;
        flowKt__MergeKt$mapLatest$1.L$1 = t2;
        return flowKt__MergeKt$mapLatest$1.invokeSuspend(kotlin.p.f51048a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        d dVar;
        Object d10 = sd.a.d();
        int i10 = this.label;
        if (i10 == 0) {
            kotlin.e.b(obj);
            d dVar2 = (d) this.L$0;
            Object obj2 = this.L$1;
            Function2<T, Continuation<? super R>, Object> function2 = this.$transform;
            this.L$0 = dVar2;
            this.label = 1;
            obj = function2.mo1743invoke(obj2, this);
            dVar = dVar2;
            if (obj == d10) {
                return d10;
            }
        } else {
            if (i10 != 1) {
                if (i10 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.e.b(obj);
                return kotlin.p.f51048a;
            }
            d dVar3 = (d) this.L$0;
            kotlin.e.b(obj);
            dVar = dVar3;
        }
        this.L$0 = null;
        this.label = 2;
        if (dVar.emit(obj, this) == d10) {
            return d10;
        }
        return kotlin.p.f51048a;
    }
}
