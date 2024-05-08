package java.util.function;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
@FunctionalInterface
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface UnaryOperator<T> extends Function<T, T> {
    static <T> UnaryOperator<T> identity() {
        return new UnaryOperator() { // from class: java.util.function.UnaryOperator$$ExternalSyntheticLambda0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return UnaryOperator.lambda$identity$0(obj);
            }
        };
    }

    static /* synthetic */ Object lambda$identity$0(Object t2) {
        return t2;
    }
}
