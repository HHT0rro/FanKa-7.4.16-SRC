package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: Sequences.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
final class SequencesKt__SequencesKt$flatten$1 extends Lambda implements Function1<g<Object>, Iterator<Object>> {
    public static final SequencesKt__SequencesKt$flatten$1 INSTANCE = new SequencesKt__SequencesKt$flatten$1();

    public SequencesKt__SequencesKt$flatten$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    @NotNull
    public final Iterator<Object> invoke(@NotNull g<Object> it) {
        s.i(it, "it");
        return it.iterator();
    }
}
