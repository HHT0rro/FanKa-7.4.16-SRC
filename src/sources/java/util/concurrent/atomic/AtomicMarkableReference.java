package java.util.concurrent.atomic;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class AtomicMarkableReference<V> {
    private static final VarHandle PAIR;
    private volatile Pair<V> pair;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class Pair<T> {
        final boolean mark;
        final T reference;

        private Pair(T reference, boolean mark) {
            this.reference = reference;
            this.mark = mark;
        }

        static <T> Pair<T> of(T reference, boolean mark) {
            return new Pair<>(reference, mark);
        }
    }

    public AtomicMarkableReference(V initialRef, boolean initialMark) {
        this.pair = Pair.of(initialRef, initialMark);
    }

    public V getReference() {
        return this.pair.reference;
    }

    public boolean isMarked() {
        return this.pair.mark;
    }

    public V get(boolean[] markHolder) {
        Pair<V> pair = this.pair;
        markHolder[0] = pair.mark;
        return pair.reference;
    }

    public boolean weakCompareAndSet(V expectedReference, V newReference, boolean expectedMark, boolean newMark) {
        return compareAndSet(expectedReference, newReference, expectedMark, newMark);
    }

    public boolean compareAndSet(V expectedReference, V newReference, boolean expectedMark, boolean newMark) {
        Pair<V> current = this.pair;
        return expectedReference == current.reference && expectedMark == current.mark && ((newReference == current.reference && newMark == current.mark) || casPair(current, Pair.of(newReference, newMark)));
    }

    public void set(V newReference, boolean newMark) {
        Pair<V> current = this.pair;
        if (newReference != current.reference || newMark != current.mark) {
            this.pair = Pair.of(newReference, newMark);
        }
    }

    public boolean attemptMark(V expectedReference, boolean newMark) {
        Pair<V> current = this.pair;
        return expectedReference == current.reference && (newMark == current.mark || casPair(current, Pair.of(expectedReference, newMark)));
    }

    static {
        try {
            MethodHandles.Lookup l10 = MethodHandles.lookup();
            PAIR = l10.findVarHandle(AtomicMarkableReference.class, "pair", Pair.class);
        } catch (ReflectiveOperationException e2) {
            throw new ExceptionInInitializerError(e2);
        }
    }

    private boolean casPair(Pair<V> cmp, Pair<V> val) {
        return (boolean) PAIR.compareAndSet(this, cmp, val);
    }
}
