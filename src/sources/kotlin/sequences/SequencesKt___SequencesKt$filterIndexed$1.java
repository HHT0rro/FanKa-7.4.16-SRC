package kotlin.sequences;

import kotlin.collections.d0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: _Sequences.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
final class SequencesKt___SequencesKt$filterIndexed$1 extends Lambda implements Function1<d0<Object>, Boolean> {
    public final /* synthetic */ Function2<Integer, Object, Boolean> $predicate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SequencesKt___SequencesKt$filterIndexed$1(Function2<? super Integer, Object, Boolean> function2) {
        super(1);
        this.$predicate = function2;
    }

    @Override // kotlin.jvm.functions.Function1
    @NotNull
    public final Boolean invoke(@NotNull d0<Object> it) {
        s.i(it, "it");
        return this.$predicate.mo1743invoke(Integer.valueOf(it.a()), it.b());
    }
}
