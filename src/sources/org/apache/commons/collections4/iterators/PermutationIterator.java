package org.apache.commons.collections4.iterators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class PermutationIterator<E> implements Iterator<List<E>> {
    private final boolean[] direction;
    private final int[] keys;
    private List<E> nextPermutation;
    private final Map<Integer, E> objectMap;

    public PermutationIterator(Collection<? extends E> collection) {
        Objects.requireNonNull(collection, "The collection must not be null");
        this.keys = new int[collection.size()];
        boolean[] zArr = new boolean[collection.size()];
        this.direction = zArr;
        Arrays.fill(zArr, false);
        this.objectMap = new HashMap();
        Iterator<? extends E> iterator2 = collection.iterator2();
        int i10 = 1;
        while (iterator2.hasNext()) {
            this.objectMap.put(Integer.valueOf(i10), iterator2.next());
            this.keys[i10 - 1] = i10;
            i10++;
        }
        this.nextPermutation = new ArrayList(collection);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.nextPermutation != null;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("remove() is not supported");
    }

    @Override // java.util.Iterator
    public List<E> next() {
        int[] iArr;
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i10 = 0;
        int i11 = 0;
        int i12 = -1;
        int i13 = -1;
        while (true) {
            iArr = this.keys;
            if (i11 >= iArr.length) {
                break;
            }
            boolean[] zArr = this.direction;
            if (((zArr[i11] && i11 < iArr.length - 1 && iArr[i11] > iArr[i11 + 1]) || (!zArr[i11] && i11 > 0 && iArr[i11] > iArr[i11 - 1])) && iArr[i11] > i12) {
                i12 = iArr[i11];
                i13 = i11;
            }
            i11++;
        }
        if (i12 == -1) {
            List<E> list = this.nextPermutation;
            this.nextPermutation = null;
            return list;
        }
        boolean[] zArr2 = this.direction;
        int i14 = zArr2[i13] ? 1 : -1;
        int i15 = iArr[i13];
        int i16 = i14 + i13;
        iArr[i13] = iArr[i16];
        iArr[i16] = i15;
        boolean z10 = zArr2[i13];
        zArr2[i13] = zArr2[i16];
        zArr2[i16] = z10;
        ArrayList arrayList = new ArrayList();
        while (true) {
            int[] iArr2 = this.keys;
            if (i10 < iArr2.length) {
                if (iArr2[i10] > i12) {
                    this.direction[i10] = !r4[i10];
                }
                arrayList.add(this.objectMap.get(Integer.valueOf(iArr2[i10])));
                i10++;
            } else {
                List<E> list2 = this.nextPermutation;
                this.nextPermutation = arrayList;
                return list2;
            }
        }
    }
}
