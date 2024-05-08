package java.util.function;

import java.util.Objects;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
@FunctionalInterface
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface LongPredicate {
    boolean test(long j10);

    default LongPredicate and(final LongPredicate other) {
        Objects.requireNonNull(other);
        return new LongPredicate() { // from class: java.util.function.LongPredicate$$ExternalSyntheticLambda1
            @Override // java.util.function.LongPredicate
            public final boolean test(long j10) {
                boolean lambda$and$0;
                lambda$and$0 = LongPredicate.this.lambda$and$0(other, j10);
                return lambda$and$0;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* synthetic */ default boolean lambda$and$0(LongPredicate other, long value) {
        return test(value) && other.test(value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* synthetic */ default boolean lambda$negate$1(long value) {
        return !test(value);
    }

    default LongPredicate negate() {
        return new LongPredicate() { // from class: java.util.function.LongPredicate$$ExternalSyntheticLambda2
            @Override // java.util.function.LongPredicate
            public final boolean test(long j10) {
                boolean lambda$negate$1;
                lambda$negate$1 = LongPredicate.this.lambda$negate$1(j10);
                return lambda$negate$1;
            }
        };
    }

    default LongPredicate or(final LongPredicate other) {
        Objects.requireNonNull(other);
        return new LongPredicate() { // from class: java.util.function.LongPredicate$$ExternalSyntheticLambda0
            @Override // java.util.function.LongPredicate
            public final boolean test(long j10) {
                boolean lambda$or$2;
                lambda$or$2 = LongPredicate.this.lambda$or$2(other, j10);
                return lambda$or$2;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* synthetic */ default boolean lambda$or$2(LongPredicate other, long value) {
        return test(value) || other.test(value);
    }
}
