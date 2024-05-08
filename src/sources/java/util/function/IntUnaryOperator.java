package java.util.function;

import java.util.Objects;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
@FunctionalInterface
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface IntUnaryOperator {
    int applyAsInt(int i10);

    default IntUnaryOperator compose(final IntUnaryOperator before) {
        Objects.requireNonNull(before);
        return new IntUnaryOperator() { // from class: java.util.function.IntUnaryOperator$$ExternalSyntheticLambda0
            @Override // java.util.function.IntUnaryOperator
            public final int applyAsInt(int i10) {
                int lambda$compose$0;
                lambda$compose$0 = IntUnaryOperator.this.lambda$compose$0(before, i10);
                return lambda$compose$0;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* synthetic */ default int lambda$compose$0(IntUnaryOperator before, int v2) {
        return applyAsInt(before.applyAsInt(v2));
    }

    default IntUnaryOperator andThen(final IntUnaryOperator after) {
        Objects.requireNonNull(after);
        return new IntUnaryOperator() { // from class: java.util.function.IntUnaryOperator$$ExternalSyntheticLambda1
            @Override // java.util.function.IntUnaryOperator
            public final int applyAsInt(int i10) {
                int lambda$andThen$1;
                lambda$andThen$1 = IntUnaryOperator.this.lambda$andThen$1(after, i10);
                return lambda$andThen$1;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* synthetic */ default int lambda$andThen$1(IntUnaryOperator after, int t2) {
        return after.applyAsInt(applyAsInt(t2));
    }

    static IntUnaryOperator identity() {
        return new IntUnaryOperator() { // from class: java.util.function.IntUnaryOperator$$ExternalSyntheticLambda2
            @Override // java.util.function.IntUnaryOperator
            public final int applyAsInt(int i10) {
                return IntUnaryOperator.lambda$identity$2(i10);
            }
        };
    }

    static /* synthetic */ int lambda$identity$2(int t2) {
        return t2;
    }
}
