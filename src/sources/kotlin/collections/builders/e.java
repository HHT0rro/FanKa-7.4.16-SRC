package kotlin.collections.builders;

import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: MapBuilder.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class e<V> extends kotlin.collections.d<V> {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final MapBuilder<?, V> f50922b;

    public e(@NotNull MapBuilder<?, V> backing) {
        s.i(backing, "backing");
        this.f50922b = backing;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(V v2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(@NotNull Collection<? extends V> elements) {
        s.i(elements, "elements");
        throw new UnsupportedOperationException();
    }

    @Override // kotlin.collections.d
    public int b() {
        return this.f50922b.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.f50922b.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.f50922b.containsValue(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f50922b.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    @NotNull
    /* renamed from: iterator */
    public Iterator<V> iterator2() {
        return this.f50922b.valuesIterator$kotlin_stdlib();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        return this.f50922b.removeValue$kotlin_stdlib(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(@NotNull Collection<? extends Object> elements) {
        s.i(elements, "elements");
        this.f50922b.checkIsMutable$kotlin_stdlib();
        return super.removeAll(elements);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(@NotNull Collection<? extends Object> elements) {
        s.i(elements, "elements");
        this.f50922b.checkIsMutable$kotlin_stdlib();
        return super.retainAll(elements);
    }
}
