package kotlin.sequences;

import java.util.Iterator;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: _Sequences.kt */
@td.d(c = "kotlin.sequences.SequencesKt___SequencesKt$runningReduce$1", f = "_Sequences.kt", l = {2348, 2351}, m = "invokeSuspend")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
final class SequencesKt___SequencesKt$runningReduce$1 extends RestrictedSuspendLambda implements Function2<i<Object>, Continuation<? super p>, Object> {
    public final /* synthetic */ Function2<Object, Object, Object> $operation;
    public final /* synthetic */ g<Object> $this_runningReduce;
    private /* synthetic */ Object L$0;
    public Object L$1;
    public Object L$2;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SequencesKt___SequencesKt$runningReduce$1(g<Object> gVar, Function2<Object, Object, Object> function2, Continuation<? super SequencesKt___SequencesKt$runningReduce$1> continuation) {
        super(2, continuation);
        this.$this_runningReduce = gVar;
        this.$operation = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<p> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        SequencesKt___SequencesKt$runningReduce$1 sequencesKt___SequencesKt$runningReduce$1 = new SequencesKt___SequencesKt$runningReduce$1(this.$this_runningReduce, this.$operation, continuation);
        sequencesKt___SequencesKt$runningReduce$1.L$0 = obj;
        return sequencesKt___SequencesKt$runningReduce$1;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final Object mo1743invoke(@NotNull i<Object> iVar, @Nullable Continuation<? super p> continuation) {
        return ((SequencesKt___SequencesKt$runningReduce$1) create(iVar, continuation)).invokeSuspend(p.f51048a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        i iVar;
        Object next;
        Iterator<Object> it;
        Object d10 = sd.a.d();
        int i10 = this.label;
        if (i10 == 0) {
            kotlin.e.b(obj);
            iVar = (i) this.L$0;
            Iterator<Object> it2 = this.$this_runningReduce.iterator();
            if (it2.hasNext()) {
                next = it2.next();
                this.L$0 = iVar;
                this.L$1 = it2;
                this.L$2 = next;
                this.label = 1;
                if (iVar.a(next, this) == d10) {
                    return d10;
                }
                it = it2;
            }
            return p.f51048a;
        }
        if (i10 != 1 && i10 != 2) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        next = this.L$2;
        it = (Iterator) this.L$1;
        iVar = (i) this.L$0;
        kotlin.e.b(obj);
        while (it.hasNext()) {
            next = this.$operation.mo1743invoke(next, it.next());
            this.L$0 = iVar;
            this.L$1 = it;
            this.L$2 = next;
            this.label = 2;
            if (iVar.a(next, this) == d10) {
                return d10;
            }
        }
        return p.f51048a;
    }
}
