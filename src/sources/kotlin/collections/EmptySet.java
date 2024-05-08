package kotlin.collections;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Sets.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class EmptySet implements Set, Serializable, zd.a {

    @NotNull
    public static final EmptySet INSTANCE = new EmptySet();
    private static final long serialVersionUID = 3406603774387020532L;

    private EmptySet() {
    }

    private final Object readResolve() {
        return INSTANCE;
    }

    @Override // java.util.Set
    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean add(Void r22) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set
    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Void) {
            return contains((Void) obj);
        }
        return false;
    }

    public boolean contains(@NotNull Void element) {
        kotlin.jvm.internal.s.i(element, "element");
        return false;
    }

    @Override // java.util.Set
    public boolean containsAll(@NotNull Collection elements) {
        kotlin.jvm.internal.s.i(elements, "elements");
        return elements.isEmpty();
    }

    @Override // java.util.Set
    public boolean equals(@Nullable Object obj) {
        return (obj instanceof Set) && ((Set) obj).isEmpty();
    }

    public int getSize() {
        return 0;
    }

    @Override // java.util.Set
    public int hashCode() {
        return 0;
    }

    @Override // java.util.Set
    public boolean isEmpty() {
        return true;
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    @NotNull
    /* renamed from: iterator */
    public Iterator iterator2() {
        return b0.f50911b;
    }

    @Override // java.util.Set
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set
    public boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set
    public boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.Set
    public Object[] toArray() {
        return kotlin.jvm.internal.n.a(this);
    }

    @Override // java.util.Set
    public <T> T[] toArray(T[] array) {
        kotlin.jvm.internal.s.i(array, "array");
        return (T[]) kotlin.jvm.internal.n.b(this, array);
    }

    @NotNull
    public String toString() {
        return "[]";
    }
}
