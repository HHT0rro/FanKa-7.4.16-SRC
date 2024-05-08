package kotlin.sequences;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: SequencesJVM.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class a<T> implements g<T> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public final AtomicReference<g<T>> f51064a;

    public a(@NotNull g<? extends T> sequence) {
        s.i(sequence, "sequence");
        this.f51064a = new AtomicReference<>(sequence);
    }

    @Override // kotlin.sequences.g
    @NotNull
    public Iterator<T> iterator() {
        g<T> andSet = this.f51064a.getAndSet(null);
        if (andSet != null) {
            return andSet.iterator();
        }
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}
