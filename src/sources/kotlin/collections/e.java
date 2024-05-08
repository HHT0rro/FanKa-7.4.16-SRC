package kotlin.collections;

import java.util.AbstractList;

/* compiled from: AbstractMutableList.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class e<E> extends AbstractList<E> implements zd.d {
    @Override // java.util.AbstractList, java.util.List
    public abstract void add(int i10, E e2);

    public abstract int getSize();

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ E remove(int i10) {
        return removeAt(i10);
    }

    public abstract E removeAt(int i10);

    @Override // java.util.AbstractList, java.util.List
    public abstract E set(int i10, E e2);

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ int size() {
        return getSize();
    }
}
