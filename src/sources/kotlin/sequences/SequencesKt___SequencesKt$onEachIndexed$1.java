package kotlin.sequences;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.p;

/* compiled from: _Sequences.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
final class SequencesKt___SequencesKt$onEachIndexed$1 extends Lambda implements Function2<Integer, Object, Object> {
    public final /* synthetic */ Function2<Integer, Object, p> $action;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SequencesKt___SequencesKt$onEachIndexed$1(Function2<? super Integer, Object, p> function2) {
        super(2);
        this.$action = function2;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo1743invoke(Integer num, Object obj) {
        return invoke(num.intValue(), obj);
    }

    public final Object invoke(int i10, Object obj) {
        this.$action.mo1743invoke(Integer.valueOf(i10), obj);
        return obj;
    }
}
