package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Zip.kt */
@kotlin.d
@td.d(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$5$2", f = "Zip.kt", l = {238, 238}, m = "invokeSuspend")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class FlowKt__ZipKt$combine$5$2 extends SuspendLambda implements Function3<d<Object>, Object[], Continuation<? super kotlin.p>, Object> {
    public final /* synthetic */ Function2<Object[], Continuation<Object>, Object> $transform;
    private /* synthetic */ Object L$0;
    public /* synthetic */ Object L$1;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__ZipKt$combine$5$2(Function2<? super Object[], ? super Continuation<Object>, ? extends Object> function2, Continuation<? super FlowKt__ZipKt$combine$5$2> continuation) {
        super(3, continuation);
        this.$transform = function2;
    }

    @Override // kotlin.jvm.functions.Function3
    @Nullable
    public final Object invoke(@NotNull d<Object> dVar, @NotNull Object[] objArr, @Nullable Continuation<? super kotlin.p> continuation) {
        FlowKt__ZipKt$combine$5$2 flowKt__ZipKt$combine$5$2 = new FlowKt__ZipKt$combine$5$2(this.$transform, continuation);
        flowKt__ZipKt$combine$5$2.L$0 = dVar;
        flowKt__ZipKt$combine$5$2.L$1 = objArr;
        return flowKt__ZipKt$combine$5$2.invokeSuspend(kotlin.p.f51048a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        d dVar;
        Object d10 = sd.a.d();
        int i10 = this.label;
        if (i10 == 0) {
            kotlin.e.b(obj);
            dVar = (d) this.L$0;
            Object[] objArr = (Object[]) this.L$1;
            Function2<Object[], Continuation<Object>, Object> function2 = this.$transform;
            this.L$0 = dVar;
            this.label = 1;
            obj = function2.mo1743invoke(objArr, this);
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
            dVar = (d) this.L$0;
            kotlin.e.b(obj);
        }
        this.L$0 = null;
        this.label = 2;
        if (dVar.emit(obj, this) == d10) {
            return d10;
        }
        return kotlin.p.f51048a;
    }

    @Nullable
    public final Object invokeSuspend$$forInline(@NotNull Object obj) {
        d dVar = (d) this.L$0;
        Object mo1743invoke = this.$transform.mo1743invoke((Object[]) this.L$1, this);
        kotlin.jvm.internal.r.c(0);
        dVar.emit(mo1743invoke, this);
        kotlin.jvm.internal.r.c(1);
        return kotlin.p.f51048a;
    }
}