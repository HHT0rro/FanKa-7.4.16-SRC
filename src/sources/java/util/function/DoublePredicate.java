package java.util.function;

import java.util.Objects;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
@FunctionalInterface
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface DoublePredicate {
    boolean test(double d10);

    default DoublePredicate and(final DoublePredicate other) {
        Objects.requireNonNull(other);
        return new DoublePredicate() { // from class: java.util.function.DoublePredicate$$ExternalSyntheticLambda1
            @Override // java.util.function.DoublePredicate
            public final boolean test(double d10) {
                boolean lambda$and$0;
                lambda$and$0 = DoublePredicate.this.lambda$and$0(other, d10);
                return lambda$and$0;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* synthetic */ default boolean lambda$and$0(DoublePredicate other, double value) {
        return test(value) && other.test(value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* synthetic */ default boolean lambda$negate$1(double value) {
        return !test(value);
    }

    default DoublePredicate negate() {
        return new DoublePredicate() { // from class: java.util.function.DoublePredicate$$ExternalSyntheticLambda2
            @Override // java.util.function.DoublePredicate
            public final boolean test(double d10) {
                boolean lambda$negate$1;
                lambda$negate$1 = DoublePredicate.this.lambda$negate$1(d10);
                return lambda$negate$1;
            }
        };
    }

    default DoublePredicate or(final DoublePredicate other) {
        Objects.requireNonNull(other);
        return new DoublePredicate() { // from class: java.util.function.DoublePredicate$$ExternalSyntheticLambda0
            @Override // java.util.function.DoublePredicate
            public final boolean test(double d10) {
                boolean lambda$or$2;
                lambda$or$2 = DoublePredicate.this.lambda$or$2(other, d10);
                return lambda$or$2;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* synthetic */ default boolean lambda$or$2(DoublePredicate other, double value) {
        return test(value) || other.test(value);
    }
}
