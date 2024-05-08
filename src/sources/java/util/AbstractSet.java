package java.util;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class AbstractSet<E> extends AbstractCollection<E> implements Set<E> {
    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object o10) {
        if (o10 == this) {
            return true;
        }
        if (!(o10 instanceof Set)) {
            return false;
        }
        Collection<?> c4 = (Collection) o10;
        if (c4.size() != size()) {
            return false;
        }
        try {
            return containsAll(c4);
        } catch (ClassCastException | NullPointerException e2) {
            return false;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int h10 = 0;
        Iterator<E> i10 = iterator();
        while (i10.hasNext()) {
            E obj = i10.next();
            if (obj != null) {
                h10 += obj.hashCode();
            }
        }
        return h10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> c4) {
        Objects.requireNonNull(c4);
        boolean modified = false;
        if (size() > c4.size()) {
            for (Object e2 : c4) {
                modified |= remove(e2);
            }
        } else {
            Iterator<E> it = iterator();
            while (it.hasNext()) {
                if (c4.contains(it.next())) {
                    it.remove();
                    modified = true;
                }
            }
        }
        return modified;
    }
}
