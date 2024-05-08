package java.util.function;

import java.util.Objects;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
@FunctionalInterface
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface BiConsumer<T, U> {
    void accept(T t2, U u10);

    default BiConsumer<T, U> andThen(final BiConsumer<? super T, ? super U> after) {
        Objects.requireNonNull(after);
        return new BiConsumer() { // from class: java.util.function.BiConsumer$$ExternalSyntheticLambda0
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                BiConsumer.this.lambda$andThen$0(after, obj, obj2);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* synthetic */ default void lambda$andThen$0(BiConsumer after, Object obj, Object obj2) {
        accept(obj, obj2);
        after.accept(obj, obj2);
    }
}
