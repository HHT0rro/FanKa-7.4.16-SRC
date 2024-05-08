package java.util.function;

import java.util.Objects;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
@FunctionalInterface
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface LongUnaryOperator {
    long applyAsLong(long j10);

    default LongUnaryOperator compose(final LongUnaryOperator before) {
        Objects.requireNonNull(before);
        return new LongUnaryOperator() { // from class: java.util.function.LongUnaryOperator$$ExternalSyntheticLambda2
            @Override // java.util.function.LongUnaryOperator
            public final long applyAsLong(long j10) {
                long lambda$compose$0;
                lambda$compose$0 = LongUnaryOperator.this.lambda$compose$0(before, j10);
                return lambda$compose$0;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* synthetic */ default long lambda$compose$0(LongUnaryOperator before, long v2) {
        return applyAsLong(before.applyAsLong(v2));
    }

    default LongUnaryOperator andThen(final LongUnaryOperator after) {
        Objects.requireNonNull(after);
        return new LongUnaryOperator() { // from class: java.util.function.LongUnaryOperator$$ExternalSyntheticLambda1
            @Override // java.util.function.LongUnaryOperator
            public final long applyAsLong(long j10) {
                long lambda$andThen$1;
                lambda$andThen$1 = LongUnaryOperator.this.lambda$andThen$1(after, j10);
                return lambda$andThen$1;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* synthetic */ default long lambda$andThen$1(LongUnaryOperator after, long t2) {
        return after.applyAsLong(applyAsLong(t2));
    }

    static LongUnaryOperator identity() {
        return new LongUnaryOperator() { // from class: java.util.function.LongUnaryOperator$$ExternalSyntheticLambda0
            @Override // java.util.function.LongUnaryOperator
            public final long applyAsLong(long j10) {
                return LongUnaryOperator.lambda$identity$2(j10);
            }
        };
    }

    static /* synthetic */ long lambda$identity$2(long t2) {
        return t2;
    }
}
