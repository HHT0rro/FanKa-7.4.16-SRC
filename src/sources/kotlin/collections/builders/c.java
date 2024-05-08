package kotlin.collections.builders;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: MapBuilder.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class c<K, V> extends a<Map.Entry<K, V>, K, V> {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final MapBuilder<K, V> f50920b;

    public c(@NotNull MapBuilder<K, V> backing) {
        s.i(backing, "backing");
        this.f50920b = backing;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(@NotNull Collection<? extends Map.Entry<K, V>> elements) {
        s.i(elements, "elements");
        throw new UnsupportedOperationException();
    }

    @Override // kotlin.collections.builders.a
    public boolean c(@NotNull Map.Entry<? extends K, ? extends V> element) {
        s.i(element, "element");
        return this.f50920b.containsEntry$kotlin_stdlib(element);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.f50920b.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(@NotNull Collection<? extends Object> elements) {
        s.i(elements, "elements");
        return this.f50920b.containsAllEntries$kotlin_stdlib(elements);
    }

    @Override // kotlin.collections.builders.a
    public boolean f(@NotNull Map.Entry element) {
        s.i(element, "element");
        return this.f50920b.removeEntry$kotlin_stdlib(element);
    }

    @Override // kotlin.collections.g, java.util.AbstractCollection, java.util.Collection, java.util.Set
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public boolean add(@NotNull Map.Entry<K, V> element) {
        s.i(element, "element");
        throw new UnsupportedOperationException();
    }

    @Override // kotlin.collections.g
    public int getSize() {
        return this.f50920b.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f50920b.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    @NotNull
    /* renamed from: iterator */
    public Iterator<Map.Entry<K, V>> iterator2() {
        return this.f50920b.entriesIterator$kotlin_stdlib();
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(@NotNull Collection<? extends Object> elements) {
        s.i(elements, "elements");
        this.f50920b.checkIsMutable$kotlin_stdlib();
        return super.removeAll(elements);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(@NotNull Collection<? extends Object> elements) {
        s.i(elements, "elements");
        this.f50920b.checkIsMutable$kotlin_stdlib();
        return super.retainAll(elements);
    }
}
