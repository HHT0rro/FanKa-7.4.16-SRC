package org.apache.commons.collections4.list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class GrowthList<E> extends AbstractSerializableListDecorator<E> {
    private static final long serialVersionUID = -3620001881672L;

    public GrowthList() {
        super(new ArrayList());
    }

    public static <E> GrowthList<E> growthList(List<E> list) {
        return new GrowthList<>(list);
    }

    @Override // org.apache.commons.collections4.list.AbstractListDecorator, java.util.List
    public void add(int i10, E e2) {
        int size = decorated().size();
        if (i10 > size) {
            decorated().addAll(Collections.nCopies(i10 - size, null));
        }
        decorated().add(i10, e2);
    }

    @Override // org.apache.commons.collections4.list.AbstractListDecorator, java.util.List
    public boolean addAll(int i10, Collection<? extends E> collection) {
        boolean z10;
        int size = decorated().size();
        if (i10 > size) {
            decorated().addAll(Collections.nCopies(i10 - size, null));
            z10 = true;
        } else {
            z10 = false;
        }
        return decorated().addAll(i10, collection) || z10;
    }

    @Override // org.apache.commons.collections4.list.AbstractListDecorator, java.util.List
    public E set(int i10, E e2) {
        int size = decorated().size();
        if (i10 >= size) {
            decorated().addAll(Collections.nCopies((i10 - size) + 1, null));
        }
        return decorated().set(i10, e2);
    }

    public GrowthList(int i10) {
        super(new ArrayList(i10));
    }

    public GrowthList(List<E> list) {
        super(list);
    }
}
