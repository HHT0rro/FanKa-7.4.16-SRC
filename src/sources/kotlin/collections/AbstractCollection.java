package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* compiled from: AbstractCollection.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class AbstractCollection<E> implements Collection<E>, zd.a {
    @Override // java.util.Collection, java.util.Set
    public boolean add(E e2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(E e2) {
        if (isEmpty()) {
            return false;
        }
        Iterator<E> iterator2 = iterator2();
        while (iterator2.hasNext()) {
            if (kotlin.jvm.internal.s.d(iterator2.next(), e2)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
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

    public abstract int getSize();

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Collection, java.lang.Iterable
    @NotNull
    /* renamed from: iterator */
    public abstract Iterator<E> iterator2();

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
        return getSize();
    }

    @Override // java.util.Collection, java.util.Set
    @NotNull
    public Object[] toArray() {
        return kotlin.jvm.internal.n.a(this);
    }

    @NotNull
    public String toString() {
        return CollectionsKt___CollectionsKt.c0(this, ", ", "[", "]", 0, null, new Function1<E, CharSequence>(this) { // from class: kotlin.collections.AbstractCollection$toString$1
            public final /* synthetic */ AbstractCollection<E> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
                this.this$0 = this;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ CharSequence invoke(Object obj) {
                return invoke((AbstractCollection$toString$1<E>) obj);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final CharSequence invoke(E e2) {
                return e2 == this.this$0 ? "(this Collection)" : String.valueOf(e2);
            }
        }, 24, null);
    }

    @Override // java.util.Collection, java.util.Set
    @NotNull
    public <T> T[] toArray(@NotNull T[] array) {
        kotlin.jvm.internal.s.i(array, "array");
        return (T[]) kotlin.jvm.internal.n.b(this, array);
    }
}
