package androidx.core.util;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface Predicate<T> {
    Predicate<T> and(Predicate<? super T> predicate);

    Predicate<T> negate();

    Predicate<T> or(Predicate<? super T> predicate);

    boolean test(T t2);
}
