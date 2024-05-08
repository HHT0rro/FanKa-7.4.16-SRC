package org.apache.commons.collections4.functors;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import org.apache.commons.collections4.Closure;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class ChainedClosure<E> implements Closure<E>, Serializable {
    private static final long serialVersionUID = -3520677225766901240L;
    private final Closure<? super E>[] iClosures;

    private ChainedClosure(boolean z10, Closure<? super E>... closureArr) {
        this.iClosures = z10 ? FunctorUtils.copy(closureArr) : closureArr;
    }

    public static <E> Closure<E> chainedClosure(Closure<? super E>... closureArr) {
        FunctorUtils.validate(closureArr);
        if (closureArr.length == 0) {
            return NOPClosure.nopClosure();
        }
        return new ChainedClosure(closureArr);
    }

    @Override // org.apache.commons.collections4.Closure
    public void execute(E e2) {
        for (Closure<? super E> closure : this.iClosures) {
            closure.execute(e2);
        }
    }

    public Closure<? super E>[] getClosures() {
        return FunctorUtils.copy(this.iClosures);
    }

    public ChainedClosure(Closure<? super E>... closureArr) {
        this(true, closureArr);
    }

    public static <E> Closure<E> chainedClosure(Collection<? extends Closure<? super E>> collection) {
        Objects.requireNonNull(collection, "Closure collection must not be null");
        if (collection.size() == 0) {
            return NOPClosure.nopClosure();
        }
        Closure[] closureArr = new Closure[collection.size()];
        Iterator<? extends Closure<? super E>> iterator2 = collection.iterator2();
        int i10 = 0;
        while (iterator2.hasNext()) {
            closureArr[i10] = iterator2.next();
            i10++;
        }
        FunctorUtils.validate((Closure<?>[]) closureArr);
        return new ChainedClosure(false, closureArr);
    }
}
