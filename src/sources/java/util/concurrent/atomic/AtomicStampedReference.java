package java.util.concurrent.atomic;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class AtomicStampedReference<V> {
    private static final VarHandle PAIR;
    private volatile Pair<V> pair;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class Pair<T> {
        final T reference;
        final int stamp;

        private Pair(T reference, int stamp) {
            this.reference = reference;
            this.stamp = stamp;
        }

        static <T> Pair<T> of(T reference, int stamp) {
            return new Pair<>(reference, stamp);
        }
    }

    public AtomicStampedReference(V initialRef, int initialStamp) {
        this.pair = Pair.of(initialRef, initialStamp);
    }

    public V getReference() {
        return this.pair.reference;
    }

    public int getStamp() {
        return this.pair.stamp;
    }

    public V get(int[] stampHolder) {
        Pair<V> pair = this.pair;
        stampHolder[0] = pair.stamp;
        return pair.reference;
    }

    public boolean weakCompareAndSet(V expectedReference, V newReference, int expectedStamp, int newStamp) {
        return compareAndSet(expectedReference, newReference, expectedStamp, newStamp);
    }

    public boolean compareAndSet(V expectedReference, V newReference, int expectedStamp, int newStamp) {
        Pair<V> current = this.pair;
        return expectedReference == current.reference && expectedStamp == current.stamp && ((newReference == current.reference && newStamp == current.stamp) || casPair(current, Pair.of(newReference, newStamp)));
    }

    public void set(V newReference, int newStamp) {
        Pair<V> current = this.pair;
        if (newReference != current.reference || newStamp != current.stamp) {
            this.pair = Pair.of(newReference, newStamp);
        }
    }

    public boolean attemptStamp(V expectedReference, int newStamp) {
        Pair<V> current = this.pair;
        return expectedReference == current.reference && (newStamp == current.stamp || casPair(current, Pair.of(expectedReference, newStamp)));
    }

    static {
        try {
            MethodHandles.Lookup l10 = MethodHandles.lookup();
            PAIR = l10.findVarHandle(AtomicStampedReference.class, "pair", Pair.class);
        } catch (ReflectiveOperationException e2) {
            throw new ExceptionInInitializerError(e2);
        }
    }

    private boolean casPair(Pair<V> cmp, Pair<V> val) {
        return (boolean) PAIR.compareAndSet(this, cmp, val);
    }
}
