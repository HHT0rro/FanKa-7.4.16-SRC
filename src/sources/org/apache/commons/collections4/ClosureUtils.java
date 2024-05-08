package org.apache.commons.collections4;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.collections4.functors.ChainedClosure;
import org.apache.commons.collections4.functors.EqualPredicate;
import org.apache.commons.collections4.functors.ExceptionClosure;
import org.apache.commons.collections4.functors.ForClosure;
import org.apache.commons.collections4.functors.IfClosure;
import org.apache.commons.collections4.functors.InvokerTransformer;
import org.apache.commons.collections4.functors.NOPClosure;
import org.apache.commons.collections4.functors.SwitchClosure;
import org.apache.commons.collections4.functors.TransformerClosure;
import org.apache.commons.collections4.functors.WhileClosure;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class ClosureUtils {
    private ClosureUtils() {
    }

    public static <E> Closure<E> asClosure(Transformer<? super E, ?> transformer) {
        return TransformerClosure.transformerClosure(transformer);
    }

    public static <E> Closure<E> chainedClosure(Closure<? super E>... closureArr) {
        return ChainedClosure.chainedClosure(closureArr);
    }

    public static <E> Closure<E> doWhileClosure(Closure<? super E> closure, Predicate<? super E> predicate) {
        return WhileClosure.whileClosure(predicate, closure, true);
    }

    public static <E> Closure<E> exceptionClosure() {
        return ExceptionClosure.exceptionClosure();
    }

    public static <E> Closure<E> forClosure(int i10, Closure<? super E> closure) {
        return ForClosure.forClosure(i10, closure);
    }

    public static <E> Closure<E> ifClosure(Predicate<? super E> predicate, Closure<? super E> closure) {
        return IfClosure.ifClosure(predicate, closure);
    }

    public static <E> Closure<E> invokerClosure(String str) {
        return asClosure(InvokerTransformer.invokerTransformer(str));
    }

    public static <E> Closure<E> nopClosure() {
        return NOPClosure.nopClosure();
    }

    public static <E> Closure<E> switchClosure(Predicate<? super E>[] predicateArr, Closure<? super E>[] closureArr) {
        return SwitchClosure.switchClosure(predicateArr, closureArr, null);
    }

    public static <E> Closure<E> switchMapClosure(Map<? extends E, Closure<E>> map) {
        Objects.requireNonNull(map, "The object and closure map must not be null");
        Closure<E> remove = map.remove(null);
        int size = map.size();
        Closure[] closureArr = new Closure[size];
        Predicate[] predicateArr = new Predicate[size];
        int i10 = 0;
        for (Map.Entry<? extends E, Closure<E>> entry : map.entrySet()) {
            predicateArr[i10] = EqualPredicate.equalPredicate(entry.getKey());
            closureArr[i10] = entry.getValue();
            i10++;
        }
        return switchClosure(predicateArr, closureArr, remove);
    }

    public static <E> Closure<E> whileClosure(Predicate<? super E> predicate, Closure<? super E> closure) {
        return WhileClosure.whileClosure(predicate, closure, false);
    }

    public static <E> Closure<E> chainedClosure(Collection<? extends Closure<? super E>> collection) {
        return ChainedClosure.chainedClosure(collection);
    }

    public static <E> Closure<E> ifClosure(Predicate<? super E> predicate, Closure<? super E> closure, Closure<? super E> closure2) {
        return IfClosure.ifClosure(predicate, closure, closure2);
    }

    public static <E> Closure<E> invokerClosure(String str, Class<?>[] clsArr, Object[] objArr) {
        return asClosure(InvokerTransformer.invokerTransformer(str, clsArr, objArr));
    }

    public static <E> Closure<E> switchClosure(Predicate<? super E>[] predicateArr, Closure<? super E>[] closureArr, Closure<? super E> closure) {
        return SwitchClosure.switchClosure(predicateArr, closureArr, closure);
    }

    public static <E> Closure<E> switchClosure(Map<Predicate<E>, Closure<E>> map) {
        return SwitchClosure.switchClosure(map);
    }
}
