package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: _Sequences.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
final /* synthetic */ class SequencesKt___SequencesKt$flatMap$1 extends FunctionReferenceImpl implements Function1<Iterable<Object>, Iterator<Object>> {
    public static final SequencesKt___SequencesKt$flatMap$1 INSTANCE = new SequencesKt___SequencesKt$flatMap$1();

    public SequencesKt___SequencesKt$flatMap$1() {
        super(1, Iterable.class, "iterator", "iterator()Ljava/util/Iterator;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    @NotNull
    public final Iterator<Object> invoke(@NotNull Iterable<Object> p02) {
        s.i(p02, "p0");
        return p02.iterator2();
    }
}
