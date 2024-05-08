package org.apache.commons.collections4.functors;

import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import org.apache.commons.collections4.Closure;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.Transformer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
class FunctorUtils {
    private FunctorUtils() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> Closure<T> coerce(Closure<? super T> closure) {
        return closure;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> Predicate<T> coerce(Predicate<? super T> predicate) {
        return predicate;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <I, O> Transformer<I, O> coerce(Transformer<? super I, ? extends O> transformer) {
        return transformer;
    }

    public static <T> Predicate<T>[] copy(Predicate<? super T>... predicateArr) {
        if (predicateArr == null) {
            return null;
        }
        return (Predicate[]) predicateArr.clone();
    }

    public static void validate(Predicate<?>... predicateArr) {
        Objects.requireNonNull(predicateArr, "The predicate array must not be null");
        for (int i10 = 0; i10 < predicateArr.length; i10++) {
            if (predicateArr[i10] == null) {
                throw new NullPointerException("The predicate array must not contain a null predicate, index " + i10 + " was null");
            }
        }
    }

    public static <E> Closure<E>[] copy(Closure<? super E>... closureArr) {
        if (closureArr == null) {
            return null;
        }
        return (Closure[]) closureArr.clone();
    }

    public static <I, O> Transformer<I, O>[] copy(Transformer<? super I, ? extends O>... transformerArr) {
        if (transformerArr == null) {
            return null;
        }
        return (Transformer[]) transformerArr.clone();
    }

    public static <T> Predicate<? super T>[] validate(Collection<? extends Predicate<? super T>> collection) {
        Objects.requireNonNull(collection, "The predicate collection must not be null");
        Predicate<? super T>[] predicateArr = new Predicate[collection.size()];
        int i10 = 0;
        Iterator<? extends Predicate<? super T>> iterator2 = collection.iterator2();
        while (iterator2.hasNext()) {
            predicateArr[i10] = iterator2.next();
            if (predicateArr[i10] == null) {
                throw new NullPointerException("The predicate collection must not contain a null predicate, index " + i10 + " was null");
            }
            i10++;
        }
        return predicateArr;
    }

    public static void validate(Closure<?>... closureArr) {
        Objects.requireNonNull(closureArr, "The closure array must not be null");
        for (int i10 = 0; i10 < closureArr.length; i10++) {
            if (closureArr[i10] == null) {
                throw new NullPointerException("The closure array must not contain a null closure, index " + i10 + " was null");
            }
        }
    }

    public static void validate(Transformer<?, ?>... transformerArr) {
        Objects.requireNonNull(transformerArr, "The transformer array must not be null");
        for (int i10 = 0; i10 < transformerArr.length; i10++) {
            if (transformerArr[i10] == null) {
                throw new NullPointerException("The transformer array must not contain a null transformer, index " + i10 + " was null");
            }
        }
    }
}
