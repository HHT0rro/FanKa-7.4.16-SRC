package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;

/* compiled from: MutableCollections.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class x extends w {
    public static final <T> boolean A(List<T> list, Function1<? super T, Boolean> function1, boolean z10) {
        if (!(list instanceof RandomAccess)) {
            kotlin.jvm.internal.s.g(list, "null cannot be cast to non-null type kotlin.collections.MutableIterable<T of kotlin.collections.CollectionsKt__MutableCollectionsKt.filterInPlace>");
            return z(kotlin.jvm.internal.z.b(list), function1, z10);
        }
        e0 iterator2 = new IntRange(0, s.l(list)).iterator2();
        int i10 = 0;
        while (iterator2.hasNext()) {
            int nextInt = iterator2.nextInt();
            T t2 = list.get(nextInt);
            if (function1.invoke(t2).booleanValue() != z10) {
                if (i10 != nextInt) {
                    list.set(i10, t2);
                }
                i10++;
            }
        }
        if (i10 >= list.size()) {
            return false;
        }
        int l10 = s.l(list);
        if (i10 > l10) {
            return true;
        }
        while (true) {
            list.remove(l10);
            if (l10 == i10) {
                return true;
            }
            l10--;
        }
    }

    public static final <T> boolean B(@NotNull List<T> list, @NotNull Function1<? super T, Boolean> predicate) {
        kotlin.jvm.internal.s.i(list, "<this>");
        kotlin.jvm.internal.s.i(predicate, "predicate");
        return A(list, predicate, true);
    }

    public static final <T> T C(@NotNull List<T> list) {
        kotlin.jvm.internal.s.i(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.remove(s.l(list));
    }

    public static final <T> boolean D(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, Boolean> predicate) {
        kotlin.jvm.internal.s.i(iterable, "<this>");
        kotlin.jvm.internal.s.i(predicate, "predicate");
        return z(iterable, predicate, false);
    }

    public static final <T> boolean x(@NotNull Collection<? super T> collection, @NotNull Iterable<? extends T> elements) {
        kotlin.jvm.internal.s.i(collection, "<this>");
        kotlin.jvm.internal.s.i(elements, "elements");
        if (elements instanceof Collection) {
            return collection.addAll((Collection) elements);
        }
        boolean z10 = false;
        Iterator<? extends T> iterator2 = elements.iterator2();
        while (iterator2.hasNext()) {
            if (collection.add(iterator2.next())) {
                z10 = true;
            }
        }
        return z10;
    }

    public static final <T> boolean y(@NotNull Collection<? super T> collection, @NotNull T[] elements) {
        kotlin.jvm.internal.s.i(collection, "<this>");
        kotlin.jvm.internal.s.i(elements, "elements");
        return collection.addAll(l.d(elements));
    }

    public static final <T> boolean z(Iterable<? extends T> iterable, Function1<? super T, Boolean> function1, boolean z10) {
        Iterator<? extends T> iterator2 = iterable.iterator2();
        boolean z11 = false;
        while (iterator2.hasNext()) {
            if (function1.invoke(iterator2.next()).booleanValue() == z10) {
                iterator2.remove();
                z11 = true;
            }
        }
        return z11;
    }
}
