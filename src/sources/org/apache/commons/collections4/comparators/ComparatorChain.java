package org.apache.commons.collections4.comparators;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class ComparatorChain<E> implements Comparator<E>, Serializable {
    private static final long serialVersionUID = -721644942746081630L;
    private final List<Comparator<E>> comparatorChain;
    private boolean isLocked;
    private BitSet orderingBits;

    public ComparatorChain() {
        this(new ArrayList(), new BitSet());
    }

    private void checkChainIntegrity() {
        if (this.comparatorChain.size() == 0) {
            throw new UnsupportedOperationException("ComparatorChains must contain at least one Comparator");
        }
    }

    private void checkLocked() {
        if (this.isLocked) {
            throw new UnsupportedOperationException("Comparator ordering cannot be changed after the first comparison is performed");
        }
    }

    public void addComparator(Comparator<E> comparator) {
        addComparator(comparator, false);
    }

    @Override // java.util.Comparator
    public int compare(E e2, E e10) throws UnsupportedOperationException {
        if (!this.isLocked) {
            checkChainIntegrity();
            this.isLocked = true;
        }
        Iterator<Comparator<E>> iterator2 = this.comparatorChain.iterator2();
        int i10 = 0;
        while (iterator2.hasNext()) {
            int compare = iterator2.next().compare(e2, e10);
            if (compare != 0) {
                return this.orderingBits.get(i10) ? compare > 0 ? -1 : 1 : compare;
            }
            i10++;
        }
        return 0;
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        ComparatorChain comparatorChain = (ComparatorChain) obj;
        BitSet bitSet = this.orderingBits;
        if (bitSet != null ? bitSet.equals(comparatorChain.orderingBits) : comparatorChain.orderingBits == null) {
            List<Comparator<E>> list = this.comparatorChain;
            List<Comparator<E>> list2 = comparatorChain.comparatorChain;
            if (list == null) {
                if (list2 == null) {
                    return true;
                }
            } else if (list.equals(list2)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        List<Comparator<E>> list = this.comparatorChain;
        int hashCode = list != null ? 0 ^ list.hashCode() : 0;
        BitSet bitSet = this.orderingBits;
        return bitSet != null ? hashCode ^ bitSet.hashCode() : hashCode;
    }

    public boolean isLocked() {
        return this.isLocked;
    }

    public void setComparator(int i10, Comparator<E> comparator) throws IndexOutOfBoundsException {
        setComparator(i10, comparator, false);
    }

    public void setForwardSort(int i10) {
        checkLocked();
        this.orderingBits.clear(i10);
    }

    public void setReverseSort(int i10) {
        checkLocked();
        this.orderingBits.set(i10);
    }

    public int size() {
        return this.comparatorChain.size();
    }

    public ComparatorChain(Comparator<E> comparator) {
        this((Comparator) comparator, false);
    }

    public void addComparator(Comparator<E> comparator, boolean z10) {
        checkLocked();
        this.comparatorChain.add(comparator);
        if (z10) {
            this.orderingBits.set(this.comparatorChain.size() - 1);
        }
    }

    public void setComparator(int i10, Comparator<E> comparator, boolean z10) {
        checkLocked();
        this.comparatorChain.set(i10, comparator);
        if (z10) {
            this.orderingBits.set(i10);
        } else {
            this.orderingBits.clear(i10);
        }
    }

    public ComparatorChain(Comparator<E> comparator, boolean z10) {
        this.orderingBits = null;
        this.isLocked = false;
        ArrayList arrayList = new ArrayList(1);
        this.comparatorChain = arrayList;
        arrayList.add(comparator);
        BitSet bitSet = new BitSet(1);
        this.orderingBits = bitSet;
        if (z10) {
            bitSet.set(0);
        }
    }

    public ComparatorChain(List<Comparator<E>> list) {
        this(list, new BitSet(list.size()));
    }

    public ComparatorChain(List<Comparator<E>> list, BitSet bitSet) {
        this.isLocked = false;
        this.comparatorChain = list;
        this.orderingBits = bitSet;
    }
}
