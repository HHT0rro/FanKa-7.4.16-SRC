package org.apache.commons.collections4.functors;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;
import org.apache.commons.collections4.Predicate;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class ComparatorPredicate<T> implements Predicate<T>, Serializable {
    private static final long serialVersionUID = -1863209236504077399L;
    private final Comparator<T> comparator;
    private final Criterion criterion;
    private final T object;

    /* renamed from: org.apache.commons.collections4.functors.ComparatorPredicate$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$org$apache$commons$collections4$functors$ComparatorPredicate$Criterion;

        static {
            int[] iArr = new int[Criterion.values().length];
            $SwitchMap$org$apache$commons$collections4$functors$ComparatorPredicate$Criterion = iArr;
            try {
                iArr[Criterion.EQUAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$commons$collections4$functors$ComparatorPredicate$Criterion[Criterion.GREATER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$commons$collections4$functors$ComparatorPredicate$Criterion[Criterion.LESS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$commons$collections4$functors$ComparatorPredicate$Criterion[Criterion.GREATER_OR_EQUAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$commons$collections4$functors$ComparatorPredicate$Criterion[Criterion.LESS_OR_EQUAL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public enum Criterion {
        EQUAL,
        GREATER,
        LESS,
        GREATER_OR_EQUAL,
        LESS_OR_EQUAL
    }

    public ComparatorPredicate(T t2, Comparator<T> comparator, Criterion criterion) {
        this.object = t2;
        this.comparator = comparator;
        this.criterion = criterion;
    }

    public static <T> Predicate<T> comparatorPredicate(T t2, Comparator<T> comparator) {
        return comparatorPredicate(t2, comparator, Criterion.EQUAL);
    }

    @Override // org.apache.commons.collections4.Predicate
    public boolean evaluate(T t2) {
        int compare = this.comparator.compare(this.object, t2);
        int i10 = AnonymousClass1.$SwitchMap$org$apache$commons$collections4$functors$ComparatorPredicate$Criterion[this.criterion.ordinal()];
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 != 3) {
                    if (i10 != 4) {
                        if (i10 != 5) {
                            throw new IllegalStateException("The current criterion '" + ((Object) this.criterion) + "' is invalid.");
                        }
                        if (compare > 0) {
                            return false;
                        }
                    } else if (compare < 0) {
                        return false;
                    }
                } else if (compare >= 0) {
                    return false;
                }
            } else if (compare <= 0) {
                return false;
            }
        } else if (compare != 0) {
            return false;
        }
        return true;
    }

    public static <T> Predicate<T> comparatorPredicate(T t2, Comparator<T> comparator, Criterion criterion) {
        Objects.requireNonNull(comparator, "Comparator must not be null.");
        Objects.requireNonNull(criterion, "Criterion must not be null.");
        return new ComparatorPredicate(t2, comparator, criterion);
    }
}
