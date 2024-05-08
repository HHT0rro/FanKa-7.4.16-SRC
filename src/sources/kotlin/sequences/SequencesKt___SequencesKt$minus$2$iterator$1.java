package kotlin.sequences;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: _Sequences.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
final class SequencesKt___SequencesKt$minus$2$iterator$1 extends Lambda implements Function1<Object, Boolean> {
    public final /* synthetic */ Object[] $elements;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SequencesKt___SequencesKt$minus$2$iterator$1(Object[] objArr) {
        super(1);
        this.$elements = objArr;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function1
    @NotNull
    public final Boolean invoke(Object obj) {
        return Boolean.valueOf(kotlin.collections.m.t(this.$elements, obj));
    }
}
