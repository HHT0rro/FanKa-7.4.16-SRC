package kotlin.sequences;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: _Sequences.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
final class SequencesKt___SequencesKt$minus$1$iterator$1 extends Lambda implements Function1<Object, Boolean> {
    public final /* synthetic */ Object $element;
    public final /* synthetic */ Ref$BooleanRef $removed;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SequencesKt___SequencesKt$minus$1$iterator$1(Ref$BooleanRef ref$BooleanRef, Object obj) {
        super(1);
        this.$removed = ref$BooleanRef;
        this.$element = obj;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function1
    @NotNull
    public final Boolean invoke(Object obj) {
        boolean z10 = true;
        if (!this.$removed.element && s.d(obj, this.$element)) {
            this.$removed.element = true;
            z10 = false;
        }
        return Boolean.valueOf(z10);
    }
}
