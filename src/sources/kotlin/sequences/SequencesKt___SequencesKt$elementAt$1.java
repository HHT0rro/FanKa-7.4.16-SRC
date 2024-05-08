package kotlin.sequences;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* compiled from: _Sequences.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
final class SequencesKt___SequencesKt$elementAt$1 extends Lambda implements Function1<Integer, Object> {
    public final /* synthetic */ int $index;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SequencesKt___SequencesKt$elementAt$1(int i10) {
        super(1);
        this.$index = i10;
    }

    public final Object invoke(int i10) {
        throw new IndexOutOfBoundsException("Sequence doesn't contain element at index " + this.$index + '.');
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Integer num) {
        return invoke(num.intValue());
    }
}
