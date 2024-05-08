package java.util.function;

import java.util.Objects;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
@FunctionalInterface
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface Consumer<T> {
    void accept(T t2);

    default Consumer<T> andThen(final Consumer<? super T> after) {
        Objects.requireNonNull(after);
        return new Consumer() { // from class: java.util.function.Consumer$$ExternalSyntheticLambda0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                Consumer.this.lambda$andThen$0(after, obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* synthetic */ default void lambda$andThen$0(Consumer after, Object obj) {
        accept(obj);
        after.accept(obj);
    }
}
