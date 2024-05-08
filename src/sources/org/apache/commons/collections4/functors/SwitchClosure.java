package org.apache.commons.collections4.functors;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.collections4.Closure;
import org.apache.commons.collections4.Predicate;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class SwitchClosure<E> implements Closure<E>, Serializable {
    private static final long serialVersionUID = 3518477308466486130L;
    private final Closure<? super E>[] iClosures;
    private final Closure<? super E> iDefault;
    private final Predicate<? super E>[] iPredicates;

    private SwitchClosure(boolean z10, Predicate<? super E>[] predicateArr, Closure<? super E>[] closureArr, Closure<? super E> closure) {
        this.iPredicates = z10 ? FunctorUtils.copy(predicateArr) : predicateArr;
        this.iClosures = z10 ? FunctorUtils.copy(closureArr) : closureArr;
        this.iDefault = closure == null ? NOPClosure.nopClosure() : closure;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <E> Closure<E> switchClosure(Predicate<? super E>[] predicateArr, Closure<? super E>[] closureArr, Closure<? super E> closure) {
        FunctorUtils.validate(predicateArr);
        FunctorUtils.validate(closureArr);
        if (predicateArr.length == closureArr.length) {
            if (predicateArr.length == 0) {
                return closure == 0 ? NOPClosure.nopClosure() : closure;
            }
            return new SwitchClosure(predicateArr, closureArr, closure);
        }
        throw new IllegalArgumentException("The predicate and closure arrays must be the same size");
    }

    @Override // org.apache.commons.collections4.Closure
    public void execute(E e2) {
        int i10 = 0;
        while (true) {
            Predicate<? super E>[] predicateArr = this.iPredicates;
            if (i10 < predicateArr.length) {
                if (predicateArr[i10].evaluate(e2)) {
                    this.iClosures[i10].execute(e2);
                    return;
                }
                i10++;
            } else {
                this.iDefault.execute(e2);
                return;
            }
        }
    }

    public Closure<? super E>[] getClosures() {
        return FunctorUtils.copy(this.iClosures);
    }

    public Closure<? super E> getDefaultClosure() {
        return this.iDefault;
    }

    public Predicate<? super E>[] getPredicates() {
        return FunctorUtils.copy(this.iPredicates);
    }

    public SwitchClosure(Predicate<? super E>[] predicateArr, Closure<? super E>[] closureArr, Closure<? super E> closure) {
        this(true, predicateArr, closureArr, closure);
    }

    public static <E> Closure<E> switchClosure(Map<Predicate<E>, Closure<E>> map) {
        Objects.requireNonNull(map, "The predicate and closure map must not be null");
        Closure<E> remove = map.remove(null);
        int size = map.size();
        if (size == 0) {
            return remove == null ? NOPClosure.nopClosure() : remove;
        }
        Closure[] closureArr = new Closure[size];
        Predicate[] predicateArr = new Predicate[size];
        int i10 = 0;
        for (Map.Entry<Predicate<E>, Closure<E>> entry : map.entrySet()) {
            predicateArr[i10] = entry.getKey();
            closureArr[i10] = entry.getValue();
            i10++;
        }
        return new SwitchClosure(false, predicateArr, closureArr, remove);
    }
}
