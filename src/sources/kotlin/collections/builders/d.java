package kotlin.collections.builders;

import java.util.Collection;
import java.util.Iterator;
import kotlin.collections.g;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: MapBuilder.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class d<E> extends g<E> {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final MapBuilder<E, ?> f50921b;

    public d(@NotNull MapBuilder<E, ?> backing) {
        s.i(backing, "backing");
        this.f50921b = backing;
    }

    @Override // kotlin.collections.g, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(E e2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(@NotNull Collection<? extends E> elements) {
        s.i(elements, "elements");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.f50921b.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.f50921b.containsKey(obj);
    }

    @Override // kotlin.collections.g
    public int getSize() {
        return this.f50921b.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f50921b.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    @NotNull
    /* renamed from: iterator */
    public Iterator<E> iterator2() {
        return this.f50921b.keysIterator$kotlin_stdlib();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        return this.f50921b.removeKey$kotlin_stdlib(obj) >= 0;
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(@NotNull Collection<? extends Object> elements) {
        s.i(elements, "elements");
        this.f50921b.checkIsMutable$kotlin_stdlib();
        return super.removeAll(elements);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(@NotNull Collection<? extends Object> elements) {
        s.i(elements, "elements");
        this.f50921b.checkIsMutable$kotlin_stdlib();
        return super.retainAll(elements);
    }
}
