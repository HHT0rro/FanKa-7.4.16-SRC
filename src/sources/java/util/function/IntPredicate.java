package java.util.function;

import java.util.Objects;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
@FunctionalInterface
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface IntPredicate {
    boolean test(int i10);

    default IntPredicate and(final IntPredicate other) {
        Objects.requireNonNull(other);
        return new IntPredicate() { // from class: java.util.function.IntPredicate$$ExternalSyntheticLambda2
            @Override // java.util.function.IntPredicate
            public final boolean test(int i10) {
                boolean lambda$and$0;
                lambda$and$0 = IntPredicate.this.lambda$and$0(other, i10);
                return lambda$and$0;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* synthetic */ default boolean lambda$and$0(IntPredicate other, int value) {
        return test(value) && other.test(value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* synthetic */ default boolean lambda$negate$1(int value) {
        return !test(value);
    }

    default IntPredicate negate() {
        return new IntPredicate() { // from class: java.util.function.IntPredicate$$ExternalSyntheticLambda0
            @Override // java.util.function.IntPredicate
            public final boolean test(int i10) {
                boolean lambda$negate$1;
                lambda$negate$1 = IntPredicate.this.lambda$negate$1(i10);
                return lambda$negate$1;
            }
        };
    }

    default IntPredicate or(final IntPredicate other) {
        Objects.requireNonNull(other);
        return new IntPredicate() { // from class: java.util.function.IntPredicate$$ExternalSyntheticLambda1
            @Override // java.util.function.IntPredicate
            public final boolean test(int i10) {
                boolean lambda$or$2;
                lambda$or$2 = IntPredicate.this.lambda$or$2(other, i10);
                return lambda$or$2;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* synthetic */ default boolean lambda$or$2(IntPredicate other, int value) {
        return test(value) || other.test(value);
    }
}
