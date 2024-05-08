package java.util.function;

import java.util.Objects;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
@FunctionalInterface
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface LongConsumer {
    void accept(long j10);

    default LongConsumer andThen(final LongConsumer after) {
        Objects.requireNonNull(after);
        return new LongConsumer() { // from class: java.util.function.LongConsumer$$ExternalSyntheticLambda0
            @Override // java.util.function.LongConsumer
            public final void accept(long j10) {
                LongConsumer.this.lambda$andThen$0(after, j10);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* synthetic */ default void lambda$andThen$0(LongConsumer after, long t2) {
        accept(t2);
        after.accept(t2);
    }
}
