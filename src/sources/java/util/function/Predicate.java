package java.util.function;

import java.util.Objects;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
@FunctionalInterface
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface Predicate<T> {
    boolean test(T t2);

    default Predicate<T> and(final Predicate<? super T> other) {
        Objects.requireNonNull(other);
        return new Predicate() { // from class: java.util.function.Predicate$$ExternalSyntheticLambda2
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                boolean lambda$and$0;
                lambda$and$0 = Predicate.this.lambda$and$0(other, obj);
                return lambda$and$0;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* synthetic */ default boolean lambda$and$0(Predicate other, Object obj) {
        return test(obj) && other.test(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* synthetic */ default boolean lambda$negate$1(Object obj) {
        return !test(obj);
    }

    default Predicate<T> negate() {
        return new Predicate() { // from class: java.util.function.Predicate$$ExternalSyntheticLambda3
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                boolean lambda$negate$1;
                lambda$negate$1 = Predicate.this.lambda$negate$1(obj);
                return lambda$negate$1;
            }
        };
    }

    default Predicate<T> or(final Predicate<? super T> other) {
        Objects.requireNonNull(other);
        return new Predicate() { // from class: java.util.function.Predicate$$ExternalSyntheticLambda4
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                boolean lambda$or$2;
                lambda$or$2 = Predicate.this.lambda$or$2(other, obj);
                return lambda$or$2;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* synthetic */ default boolean lambda$or$2(Predicate other, Object obj) {
        return test(obj) || other.test(obj);
    }

    static <T> Predicate<T> isEqual(final Object targetRef) {
        if (targetRef == null) {
            return new Predicate() { // from class: java.util.function.Predicate$$ExternalSyntheticLambda0
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return Objects.isNull(obj);
                }
            };
        }
        return new Predicate() { // from class: java.util.function.Predicate$$ExternalSyntheticLambda1
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                boolean equals;
                equals = Object.this.equals(obj);
                return equals;
            }
        };
    }

    static <T> Predicate<T> not(Predicate<? super T> predicate) {
        Objects.requireNonNull(predicate);
        return predicate.negate();
    }
}
