package java.util.function;

import java.util.Objects;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
@FunctionalInterface
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface BiFunction<T, U, R> {
    R apply(T t2, U u10);

    default <V> BiFunction<T, U, V> andThen(final Function<? super R, ? extends V> after) {
        Objects.requireNonNull(after);
        return new BiFunction() { // from class: java.util.function.BiFunction$$ExternalSyntheticLambda0
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                Object lambda$andThen$0;
                lambda$andThen$0 = BiFunction.this.lambda$andThen$0(after, obj, obj2);
                return lambda$andThen$0;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* synthetic */ default Object lambda$andThen$0(Function after, Object obj, Object obj2) {
        return after.apply(apply(obj, obj2));
    }
}
