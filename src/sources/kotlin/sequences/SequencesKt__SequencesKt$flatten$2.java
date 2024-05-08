package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: Sequences.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
final class SequencesKt__SequencesKt$flatten$2 extends Lambda implements Function1<Iterable<Object>, Iterator<Object>> {
    public static final SequencesKt__SequencesKt$flatten$2 INSTANCE = new SequencesKt__SequencesKt$flatten$2();

    public SequencesKt__SequencesKt$flatten$2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    @NotNull
    public final Iterator<Object> invoke(@NotNull Iterable<Object> it) {
        s.i(it, "it");
        return it.iterator2();
    }
}
