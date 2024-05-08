package kotlin.sequences;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: _Sequences.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
final class SequencesKt___SequencesKt$requireNoNulls$1 extends Lambda implements Function1<Object, Object> {
    public final /* synthetic */ g<Object> $this_requireNoNulls;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SequencesKt___SequencesKt$requireNoNulls$1(g<Object> gVar) {
        super(1);
        this.$this_requireNoNulls = gVar;
    }

    @Override // kotlin.jvm.functions.Function1
    @NotNull
    public final Object invoke(@Nullable Object obj) {
        if (obj != null) {
            return obj;
        }
        throw new IllegalArgumentException("null element found in " + ((Object) this.$this_requireNoNulls) + '.');
    }
}
