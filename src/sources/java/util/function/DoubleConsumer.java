package java.util.function;

import java.util.Objects;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
@FunctionalInterface
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface DoubleConsumer {
    void accept(double d10);

    default DoubleConsumer andThen(final DoubleConsumer after) {
        Objects.requireNonNull(after);
        return new DoubleConsumer() { // from class: java.util.function.DoubleConsumer$$ExternalSyntheticLambda0
            @Override // java.util.function.DoubleConsumer
            public final void accept(double d10) {
                DoubleConsumer.this.lambda$andThen$0(after, d10);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* synthetic */ default void lambda$andThen$0(DoubleConsumer after, double t2) {
        accept(t2);
        after.accept(t2);
    }
}
