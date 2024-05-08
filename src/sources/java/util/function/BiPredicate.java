package java.util.function;

import java.util.Objects;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
@FunctionalInterface
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface BiPredicate<T, U> {
    boolean test(T t2, U u10);

    default BiPredicate<T, U> and(final BiPredicate<? super T, ? super U> other) {
        Objects.requireNonNull(other);
        return new BiPredicate() { // from class: java.util.function.BiPredicate$$ExternalSyntheticLambda0
            @Override // java.util.function.BiPredicate
            public final boolean test(Object obj, Object obj2) {
                boolean lambda$and$0;
                lambda$and$0 = BiPredicate.this.lambda$and$0(other, obj, obj2);
                return lambda$and$0;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* synthetic */ default boolean lambda$and$0(BiPredicate other, Object obj, Object obj2) {
        return test(obj, obj2) && other.test(obj, obj2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* synthetic */ default boolean lambda$negate$1(Object obj, Object obj2) {
        return !test(obj, obj2);
    }

    default BiPredicate<T, U> negate() {
        return new BiPredicate() { // from class: java.util.function.BiPredicate$$ExternalSyntheticLambda1
            @Override // java.util.function.BiPredicate
            public final boolean test(Object obj, Object obj2) {
                boolean lambda$negate$1;
                lambda$negate$1 = BiPredicate.this.lambda$negate$1(obj, obj2);
                return lambda$negate$1;
            }
        };
    }

    default BiPredicate<T, U> or(final BiPredicate<? super T, ? super U> other) {
        Objects.requireNonNull(other);
        return new BiPredicate() { // from class: java.util.function.BiPredicate$$ExternalSyntheticLambda2
            @Override // java.util.function.BiPredicate
            public final boolean test(Object obj, Object obj2) {
                boolean lambda$or$2;
                lambda$or$2 = BiPredicate.this.lambda$or$2(other, obj, obj2);
                return lambda$or$2;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* synthetic */ default boolean lambda$or$2(BiPredicate other, Object obj, Object obj2) {
        return test(obj, obj2) || other.test(obj, obj2);
    }
}
