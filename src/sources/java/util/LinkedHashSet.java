package java.util;

import java.io.Serializable;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class LinkedHashSet<E> extends HashSet<E> implements Set<E>, Cloneable, Serializable {
    private static final long serialVersionUID = -2851667679971038690L;

    public LinkedHashSet(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor, true);
    }

    public LinkedHashSet(int initialCapacity) {
        super(initialCapacity, 0.75f, true);
    }

    public LinkedHashSet() {
        super(16, 0.75f, true);
    }

    public LinkedHashSet(Collection<? extends E> c4) {
        super(Math.max(c4.size() * 2, 11), 0.75f, true);
        addAll(c4);
    }

    @Override // java.util.HashSet, java.util.Collection, java.lang.Iterable
    public Spliterator<E> spliterator() {
        return Spliterators.spliterator(this, 17);
    }
}
