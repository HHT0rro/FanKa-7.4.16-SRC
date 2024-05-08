package java.util;

import java.io.Serializable;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
class Comparators {
    private Comparators() {
        throw new AssertionError((Object) "no instances");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public enum NaturalOrderComparator implements Comparator<Comparable<Object>> {
        INSTANCE;

        @Override // java.util.Comparator
        public int compare(Comparable<Object> c12, Comparable<Object> c22) {
            return c12.compareTo(c22);
        }

        @Override // java.util.Comparator
        public Comparator<Comparable<Object>> reversed() {
            return Comparator.reverseOrder();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static final class NullComparator<T> implements Comparator<T>, Serializable {
        private static final long serialVersionUID = -7569533591570686392L;
        private final boolean nullFirst;
        private final Comparator<T> real;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Multi-variable type inference failed */
        public NullComparator(boolean nullFirst, Comparator<? super T> comparator) {
            this.nullFirst = nullFirst;
            this.real = comparator;
        }

        @Override // java.util.Comparator
        public int compare(T a10, T b4) {
            if (a10 == null) {
                if (b4 == null) {
                    return 0;
                }
                return this.nullFirst ? -1 : 1;
            }
            if (b4 == null) {
                return this.nullFirst ? 1 : -1;
            }
            Comparator<T> comparator = this.real;
            if (comparator == null) {
                return 0;
            }
            return comparator.compare(a10, b4);
        }

        @Override // java.util.Comparator
        public Comparator<T> thenComparing(Comparator<? super T> other) {
            Objects.requireNonNull(other);
            boolean z10 = this.nullFirst;
            Comparator<T> comparator = this.real;
            return new NullComparator(z10, comparator == null ? other : comparator.thenComparing(other));
        }

        @Override // java.util.Comparator
        public Comparator<T> reversed() {
            boolean z10 = !this.nullFirst;
            Comparator<T> comparator = this.real;
            return new NullComparator(z10, comparator == null ? null : comparator.reversed());
        }
    }
}
