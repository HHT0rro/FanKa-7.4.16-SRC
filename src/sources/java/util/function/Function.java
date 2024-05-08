package java.util.function;

import java.util.Objects;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
@FunctionalInterface
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface Function<T, R> {
    R apply(T t2);

    default <V> Function<V, R> compose(final Function<? super V, ? extends T> before) {
        Objects.requireNonNull(before);
        return new Function() { // from class: java.util.function.Function$$ExternalSyntheticLambda2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Object lambda$compose$0;
                lambda$compose$0 = Function.this.lambda$compose$0(before, obj);
                return lambda$compose$0;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* synthetic */ default Object lambda$compose$0(Function before, Object v2) {
        return apply(before.apply(v2));
    }

    default <V> Function<T, V> andThen(final Function<? super R, ? extends V> after) {
        Objects.requireNonNull(after);
        return new Function() { // from class: java.util.function.Function$$ExternalSyntheticLambda0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Object lambda$andThen$1;
                lambda$andThen$1 = Function.this.lambda$andThen$1(after, obj);
                return lambda$andThen$1;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* synthetic */ default Object lambda$andThen$1(Function after, Object obj) {
        return after.apply(apply(obj));
    }

    static <T> Function<T, T> identity() {
        return new Function() { // from class: java.util.function.Function$$ExternalSyntheticLambda1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Function.lambda$identity$2(obj);
            }
        };
    }

    static /* synthetic */ Object lambda$identity$2(Object t2) {
        return t2;
    }
}
