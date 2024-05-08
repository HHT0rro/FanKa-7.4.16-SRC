package java.util.function;

import java.util.Comparator;
import java.util.Objects;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
@FunctionalInterface
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface BinaryOperator<T> extends BiFunction<T, T, T> {
    static <T> BinaryOperator<T> minBy(final Comparator<? super T> comparator) {
        Objects.requireNonNull(comparator);
        return new BinaryOperator() { // from class: java.util.function.BinaryOperator$$ExternalSyntheticLambda1
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return BinaryOperator.lambda$minBy$0(Comparator.this, obj, obj2);
            }
        };
    }

    static /* synthetic */ Object lambda$minBy$0(Comparator comparator, Object a10, Object b4) {
        return comparator.compare(a10, b4) <= 0 ? a10 : b4;
    }

    static <T> BinaryOperator<T> maxBy(final Comparator<? super T> comparator) {
        Objects.requireNonNull(comparator);
        return new BinaryOperator() { // from class: java.util.function.BinaryOperator$$ExternalSyntheticLambda0
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return BinaryOperator.lambda$maxBy$1(Comparator.this, obj, obj2);
            }
        };
    }

    static /* synthetic */ Object lambda$maxBy$1(Comparator comparator, Object a10, Object b4) {
        return comparator.compare(a10, b4) >= 0 ? a10 : b4;
    }
}
