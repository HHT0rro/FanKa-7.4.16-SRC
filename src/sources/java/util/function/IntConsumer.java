package java.util.function;

import java.util.Objects;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
@FunctionalInterface
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface IntConsumer {
    void accept(int i10);

    default IntConsumer andThen(final IntConsumer after) {
        Objects.requireNonNull(after);
        return new IntConsumer() { // from class: java.util.function.IntConsumer$$ExternalSyntheticLambda0
            @Override // java.util.function.IntConsumer
            public final void accept(int i10) {
                IntConsumer.this.lambda$andThen$0(after, i10);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* synthetic */ default void lambda$andThen$0(IntConsumer after, int t2) {
        accept(t2);
        after.accept(t2);
    }
}
