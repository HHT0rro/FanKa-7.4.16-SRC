package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import org.jetbrains.annotations.NotNull;

/* compiled from: Collections.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class h<T> implements Collection<T>, zd.a {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final T[] f50926b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f50927c;

    public h(@NotNull T[] values, boolean z10) {
        kotlin.jvm.internal.s.i(values, "values");
        this.f50926b = values;
        this.f50927c = z10;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(T t2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public int b() {
        return this.f50926b.length;
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return m.t(this.f50926b, obj);
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(@NotNull Collection<? extends Object> elements) {
        kotlin.jvm.internal.s.i(elements, "elements");
        if (elements.isEmpty()) {
            return true;
        }
        Iterator<? extends Object> iterator2 = elements.iterator2();
        while (iterator2.hasNext()) {
            if (!contains(iterator2.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f50926b.length == 0;
    }

    @Override // java.util.Collection, java.lang.Iterable
    @NotNull
    /* renamed from: iterator */
    public Iterator<T> iterator2() {
        return kotlin.jvm.internal.h.a(this.f50926b);
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, java.util.Set
    public final /* bridge */ int size() {
        return b();
    }

    @Override // java.util.Collection, java.util.Set
    @NotNull
    public final Object[] toArray() {
        return r.b(this.f50926b, this.f50927c);
    }

    @Override // java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] array) {
        kotlin.jvm.internal.s.i(array, "array");
        return (T[]) kotlin.jvm.internal.n.b(this, array);
    }
}
