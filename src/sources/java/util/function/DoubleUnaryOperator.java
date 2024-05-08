package java.util.function;

import java.util.Objects;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
@FunctionalInterface
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface DoubleUnaryOperator {
    double applyAsDouble(double d10);

    default DoubleUnaryOperator compose(final DoubleUnaryOperator before) {
        Objects.requireNonNull(before);
        return new DoubleUnaryOperator() { // from class: java.util.function.DoubleUnaryOperator$$ExternalSyntheticLambda0
            @Override // java.util.function.DoubleUnaryOperator
            public final double applyAsDouble(double d10) {
                double lambda$compose$0;
                lambda$compose$0 = DoubleUnaryOperator.this.lambda$compose$0(before, d10);
                return lambda$compose$0;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* synthetic */ default double lambda$compose$0(DoubleUnaryOperator before, double v2) {
        return applyAsDouble(before.applyAsDouble(v2));
    }

    default DoubleUnaryOperator andThen(final DoubleUnaryOperator after) {
        Objects.requireNonNull(after);
        return new DoubleUnaryOperator() { // from class: java.util.function.DoubleUnaryOperator$$ExternalSyntheticLambda1
            @Override // java.util.function.DoubleUnaryOperator
            public final double applyAsDouble(double d10) {
                double lambda$andThen$1;
                lambda$andThen$1 = DoubleUnaryOperator.this.lambda$andThen$1(after, d10);
                return lambda$andThen$1;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* synthetic */ default double lambda$andThen$1(DoubleUnaryOperator after, double t2) {
        return after.applyAsDouble(applyAsDouble(t2));
    }

    static DoubleUnaryOperator identity() {
        return new DoubleUnaryOperator() { // from class: java.util.function.DoubleUnaryOperator$$ExternalSyntheticLambda2
            @Override // java.util.function.DoubleUnaryOperator
            public final double applyAsDouble(double d10) {
                return DoubleUnaryOperator.lambda$identity$2(d10);
            }
        };
    }

    static /* synthetic */ double lambda$identity$2(double t2) {
        return t2;
    }
}
