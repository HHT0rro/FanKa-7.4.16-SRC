package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.Set;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: _Collections.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class CollectionsKt___CollectionsKt extends z {

    /* compiled from: Sequences.kt */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class a<T> implements kotlin.sequences.g<T> {

        /* renamed from: a */
        public final /* synthetic */ Iterable f50901a;

        public a(Iterable iterable) {
            this.f50901a = iterable;
        }

        @Override // kotlin.sequences.g
        @NotNull
        public Iterator<T> iterator() {
            return this.f50901a.iterator2();
        }
    }

    @NotNull
    public static final <T> Set<T> A0(@NotNull Iterable<? extends T> iterable) {
        kotlin.jvm.internal.s.i(iterable, "<this>");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size == 0) {
                return m0.d();
            }
            if (size != 1) {
                return (Set) u0(iterable, new LinkedHashSet(h0.c(collection.size())));
            }
            return l0.c(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator2().next());
        }
        return m0.e((Set) u0(iterable, new LinkedHashSet()));
    }

    @NotNull
    public static final <T, R> List<Pair<T, R>> B0(@NotNull Iterable<? extends T> iterable, @NotNull Iterable<? extends R> other) {
        kotlin.jvm.internal.s.i(iterable, "<this>");
        kotlin.jvm.internal.s.i(other, "other");
        Iterator<? extends T> iterator2 = iterable.iterator2();
        Iterator<? extends R> iterator22 = other.iterator2();
        ArrayList arrayList = new ArrayList(Math.min(t.t(iterable, 10), t.t(other, 10)));
        while (iterator2.hasNext() && iterator22.hasNext()) {
            arrayList.add(kotlin.f.a(iterator2.next(), iterator22.next()));
        }
        return arrayList;
    }

    @NotNull
    public static final <T> kotlin.sequences.g<T> K(@NotNull Iterable<? extends T> iterable) {
        kotlin.jvm.internal.s.i(iterable, "<this>");
        return new a(iterable);
    }

    public static final <T> boolean L(@NotNull Iterable<? extends T> iterable, T t2) {
        kotlin.jvm.internal.s.i(iterable, "<this>");
        if (iterable instanceof Collection) {
            return ((Collection) iterable).contains(t2);
        }
        return X(iterable, t2) >= 0;
    }

    @NotNull
    public static final <T> List<T> M(@NotNull Iterable<? extends T> iterable, int i10) {
        ArrayList arrayList;
        kotlin.jvm.internal.s.i(iterable, "<this>");
        int i11 = 0;
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
        }
        if (i10 == 0) {
            return x0(iterable);
        }
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            int size = collection.size() - i10;
            if (size <= 0) {
                return s.j();
            }
            if (size == 1) {
                return r.e(d0(iterable));
            }
            arrayList = new ArrayList(size);
            if (iterable instanceof List) {
                if (iterable instanceof RandomAccess) {
                    int size2 = collection.size();
                    while (i10 < size2) {
                        arrayList.add(((List) iterable).get(i10));
                        i10++;
                    }
                } else {
                    ListIterator listIterator = ((List) iterable).listIterator(i10);
                    while (listIterator.hasNext()) {
                        arrayList.add(listIterator.next());
                    }
                }
                return arrayList;
            }
        } else {
            arrayList = new ArrayList();
        }
        for (T t2 : iterable) {
            if (i11 >= i10) {
                arrayList.add(t2);
            } else {
                i11++;
            }
        }
        return s.p(arrayList);
    }

    @NotNull
    public static final <T> List<T> N(@NotNull List<? extends T> list, int i10) {
        kotlin.jvm.internal.s.i(list, "<this>");
        if (i10 >= 0) {
            return t0(list, ce.n.b(list.size() - i10, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
    }

    public static final <T> T O(@NotNull Iterable<? extends T> iterable, final int i10) {
        kotlin.jvm.internal.s.i(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) ((List) iterable).get(i10);
        }
        return (T) P(iterable, i10, new Function1<Integer, T>() { // from class: kotlin.collections.CollectionsKt___CollectionsKt$elementAt$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final T invoke(int i11) {
                throw new IndexOutOfBoundsException("Collection doesn't contain element at index " + i10 + '.');
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }
        });
    }

    public static final <T> T P(@NotNull Iterable<? extends T> iterable, int i10, @NotNull Function1<? super Integer, ? extends T> defaultValue) {
        kotlin.jvm.internal.s.i(iterable, "<this>");
        kotlin.jvm.internal.s.i(defaultValue, "defaultValue");
        if (iterable instanceof List) {
            List list = (List) iterable;
            return (i10 < 0 || i10 > s.l(list)) ? defaultValue.invoke(Integer.valueOf(i10)) : (T) list.get(i10);
        }
        if (i10 < 0) {
            return defaultValue.invoke(Integer.valueOf(i10));
        }
        int i11 = 0;
        for (T t2 : iterable) {
            int i12 = i11 + 1;
            if (i10 == i11) {
                return t2;
            }
            i11 = i12;
        }
        return defaultValue.invoke(Integer.valueOf(i10));
    }

    @NotNull
    public static final <T> List<T> Q(@NotNull Iterable<? extends T> iterable) {
        kotlin.jvm.internal.s.i(iterable, "<this>");
        return (List) R(iterable, new ArrayList());
    }

    @NotNull
    public static final <C extends Collection<? super T>, T> C R(@NotNull Iterable<? extends T> iterable, @NotNull C destination) {
        kotlin.jvm.internal.s.i(iterable, "<this>");
        kotlin.jvm.internal.s.i(destination, "destination");
        for (T t2 : iterable) {
            if (t2 != null) {
                destination.add(t2);
            }
        }
        return destination;
    }

    public static final <T> T S(@NotNull Iterable<? extends T> iterable) {
        kotlin.jvm.internal.s.i(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) T((List) iterable);
        }
        Iterator<? extends T> iterator2 = iterable.iterator2();
        if (iterator2.hasNext()) {
            return iterator2.next();
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static final <T> T T(@NotNull List<? extends T> list) {
        kotlin.jvm.internal.s.i(list, "<this>");
        if (!list.isEmpty()) {
            return list.get(0);
        }
        throw new NoSuchElementException("List is empty.");
    }

    @Nullable
    public static final <T> T U(@NotNull Iterable<? extends T> iterable) {
        kotlin.jvm.internal.s.i(iterable, "<this>");
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.isEmpty()) {
                return null;
            }
            return (T) list.get(0);
        }
        Iterator<? extends T> iterator2 = iterable.iterator2();
        if (iterator2.hasNext()) {
            return iterator2.next();
        }
        return null;
    }

    @Nullable
    public static final <T> T V(@NotNull List<? extends T> list) {
        kotlin.jvm.internal.s.i(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Nullable
    public static final <T> T W(@NotNull List<? extends T> list, int i10) {
        kotlin.jvm.internal.s.i(list, "<this>");
        if (i10 < 0 || i10 > s.l(list)) {
            return null;
        }
        return list.get(i10);
    }

    public static final <T> int X(@NotNull Iterable<? extends T> iterable, T t2) {
        kotlin.jvm.internal.s.i(iterable, "<this>");
        if (iterable instanceof List) {
            return ((List) iterable).indexOf(t2);
        }
        int i10 = 0;
        for (T t10 : iterable) {
            if (i10 < 0) {
                s.s();
            }
            if (kotlin.jvm.internal.s.d(t2, t10)) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public static final <T> int Y(@NotNull List<? extends T> list, T t2) {
        kotlin.jvm.internal.s.i(list, "<this>");
        return list.indexOf(t2);
    }

    @NotNull
    public static final <T, A extends Appendable> A Z(@NotNull Iterable<? extends T> iterable, @NotNull A buffer, @NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence postfix, int i10, @NotNull CharSequence truncated, @Nullable Function1<? super T, ? extends CharSequence> function1) {
        kotlin.jvm.internal.s.i(iterable, "<this>");
        kotlin.jvm.internal.s.i(buffer, "buffer");
        kotlin.jvm.internal.s.i(separator, "separator");
        kotlin.jvm.internal.s.i(prefix, "prefix");
        kotlin.jvm.internal.s.i(postfix, "postfix");
        kotlin.jvm.internal.s.i(truncated, "truncated");
        buffer.append(prefix);
        int i11 = 0;
        for (T t2 : iterable) {
            i11++;
            if (i11 > 1) {
                buffer.append(separator);
            }
            if (i10 >= 0 && i11 > i10) {
                break;
            }
            kotlin.text.i.a(buffer, t2, function1);
        }
        if (i10 >= 0 && i11 > i10) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static /* synthetic */ Appendable a0(Iterable iterable, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, Function1 function1, int i11, Object obj) {
        return Z(iterable, appendable, (i11 & 2) != 0 ? ", " : charSequence, (i11 & 4) != 0 ? "" : charSequence2, (i11 & 8) == 0 ? charSequence3 : "", (i11 & 16) != 0 ? -1 : i10, (i11 & 32) != 0 ? "..." : charSequence4, (i11 & 64) != 0 ? null : function1);
    }

    @NotNull
    public static final <T> String b0(@NotNull Iterable<? extends T> iterable, @NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence postfix, int i10, @NotNull CharSequence truncated, @Nullable Function1<? super T, ? extends CharSequence> function1) {
        kotlin.jvm.internal.s.i(iterable, "<this>");
        kotlin.jvm.internal.s.i(separator, "separator");
        kotlin.jvm.internal.s.i(prefix, "prefix");
        kotlin.jvm.internal.s.i(postfix, "postfix");
        kotlin.jvm.internal.s.i(truncated, "truncated");
        String sb2 = ((StringBuilder) Z(iterable, new StringBuilder(), separator, prefix, postfix, i10, truncated, function1)).toString();
        kotlin.jvm.internal.s.h(sb2, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb2;
    }

    public static /* synthetic */ String c0(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, Function1 function1, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i11 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i11 & 4) == 0 ? charSequence3 : "";
        int i12 = (i11 & 8) != 0 ? -1 : i10;
        if ((i11 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i11 & 32) != 0) {
            function1 = null;
        }
        return b0(iterable, charSequence, charSequence5, charSequence6, i12, charSequence7, function1);
    }

    public static final <T> T d0(@NotNull Iterable<? extends T> iterable) {
        kotlin.jvm.internal.s.i(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) e0((List) iterable);
        }
        Iterator<? extends T> iterator2 = iterable.iterator2();
        if (iterator2.hasNext()) {
            T next = iterator2.next();
            while (iterator2.hasNext()) {
                next = iterator2.next();
            }
            return next;
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static final <T> T e0(@NotNull List<? extends T> list) {
        kotlin.jvm.internal.s.i(list, "<this>");
        if (!list.isEmpty()) {
            return list.get(s.l(list));
        }
        throw new NoSuchElementException("List is empty.");
    }

    @Nullable
    public static final <T> T f0(@NotNull List<? extends T> list) {
        kotlin.jvm.internal.s.i(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(list.size() - 1);
    }

    @Nullable
    public static final <T extends Comparable<? super T>> T g0(@NotNull Iterable<? extends T> iterable) {
        kotlin.jvm.internal.s.i(iterable, "<this>");
        Iterator<? extends T> iterator2 = iterable.iterator2();
        if (!iterator2.hasNext()) {
            return null;
        }
        T next = iterator2.next();
        while (iterator2.hasNext()) {
            T next2 = iterator2.next();
            if (next.compareTo(next2) < 0) {
                next = next2;
            }
        }
        return next;
    }

    @Nullable
    public static final Float h0(@NotNull Iterable<Float> iterable) {
        kotlin.jvm.internal.s.i(iterable, "<this>");
        Iterator<Float> iterator2 = iterable.iterator2();
        if (!iterator2.hasNext()) {
            return null;
        }
        float floatValue = iterator2.next().floatValue();
        while (iterator2.hasNext()) {
            floatValue = Math.max(floatValue, iterator2.next().floatValue());
        }
        return Float.valueOf(floatValue);
    }

    @Nullable
    public static final <T extends Comparable<? super T>> T i0(@NotNull Iterable<? extends T> iterable) {
        kotlin.jvm.internal.s.i(iterable, "<this>");
        Iterator<? extends T> iterator2 = iterable.iterator2();
        if (!iterator2.hasNext()) {
            return null;
        }
        T next = iterator2.next();
        while (iterator2.hasNext()) {
            T next2 = iterator2.next();
            if (next.compareTo(next2) > 0) {
                next = next2;
            }
        }
        return next;
    }

    @Nullable
    public static final Float j0(@NotNull Iterable<Float> iterable) {
        kotlin.jvm.internal.s.i(iterable, "<this>");
        Iterator<Float> iterator2 = iterable.iterator2();
        if (!iterator2.hasNext()) {
            return null;
        }
        float floatValue = iterator2.next().floatValue();
        while (iterator2.hasNext()) {
            floatValue = Math.min(floatValue, iterator2.next().floatValue());
        }
        return Float.valueOf(floatValue);
    }

    @NotNull
    public static final <T> List<T> k0(@NotNull Collection<? extends T> collection, @NotNull Iterable<? extends T> elements) {
        kotlin.jvm.internal.s.i(collection, "<this>");
        kotlin.jvm.internal.s.i(elements, "elements");
        if (elements instanceof Collection) {
            Collection collection2 = (Collection) elements;
            ArrayList arrayList = new ArrayList(collection.size() + collection2.size());
            arrayList.addAll(collection);
            arrayList.addAll(collection2);
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList(collection);
        x.x(arrayList2, elements);
        return arrayList2;
    }

    @NotNull
    public static final <T> List<T> l0(@NotNull Collection<? extends T> collection, T t2) {
        kotlin.jvm.internal.s.i(collection, "<this>");
        ArrayList arrayList = new ArrayList(collection.size() + 1);
        arrayList.addAll(collection);
        arrayList.add(t2);
        return arrayList;
    }

    public static final <T> T m0(@NotNull Collection<? extends T> collection, @NotNull Random random) {
        kotlin.jvm.internal.s.i(collection, "<this>");
        kotlin.jvm.internal.s.i(random, "random");
        if (!collection.isEmpty()) {
            return (T) O(collection, random.nextInt(collection.size()));
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    @NotNull
    public static final <T> List<T> n0(@NotNull Iterable<? extends T> iterable) {
        kotlin.jvm.internal.s.i(iterable, "<this>");
        if ((iterable instanceof Collection) && ((Collection) iterable).size() <= 1) {
            return x0(iterable);
        }
        List<T> y02 = y0(iterable);
        z.J(y02);
        return y02;
    }

    public static final <T> T o0(@NotNull Iterable<? extends T> iterable) {
        kotlin.jvm.internal.s.i(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) p0((List) iterable);
        }
        Iterator<? extends T> iterator2 = iterable.iterator2();
        if (iterator2.hasNext()) {
            T next = iterator2.next();
            if (iterator2.hasNext()) {
                throw new IllegalArgumentException("Collection has more than one element.");
            }
            return next;
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static final <T> T p0(@NotNull List<? extends T> list) {
        kotlin.jvm.internal.s.i(list, "<this>");
        int size = list.size();
        if (size == 0) {
            throw new NoSuchElementException("List is empty.");
        }
        if (size == 1) {
            return list.get(0);
        }
        throw new IllegalArgumentException("List has more than one element.");
    }

    @NotNull
    public static final <T> List<T> q0(@NotNull List<? extends T> list, @NotNull IntRange indices) {
        kotlin.jvm.internal.s.i(list, "<this>");
        kotlin.jvm.internal.s.i(indices, "indices");
        return indices.isEmpty() ? s.j() : x0(list.subList(indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1));
    }

    @NotNull
    public static final <T extends Comparable<? super T>> List<T> r0(@NotNull Iterable<? extends T> iterable) {
        kotlin.jvm.internal.s.i(iterable, "<this>");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            if (collection.size() <= 1) {
                return x0(iterable);
            }
            Object[] array = collection.toArray(new Comparable[0]);
            l.p((Comparable[]) array);
            return l.d(array);
        }
        List<T> y02 = y0(iterable);
        w.v(y02);
        return y02;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <T> List<T> s0(@NotNull Iterable<? extends T> iterable, @NotNull Comparator<? super T> comparator) {
        kotlin.jvm.internal.s.i(iterable, "<this>");
        kotlin.jvm.internal.s.i(comparator, "comparator");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            if (collection.size() <= 1) {
                return x0(iterable);
            }
            Object[] array = collection.toArray(new Object[0]);
            l.q(array, comparator);
            return l.d(array);
        }
        List<T> y02 = y0(iterable);
        w.w(y02, comparator);
        return y02;
    }

    @NotNull
    public static final <T> List<T> t0(@NotNull Iterable<? extends T> iterable, int i10) {
        kotlin.jvm.internal.s.i(iterable, "<this>");
        int i11 = 0;
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
        }
        if (i10 == 0) {
            return s.j();
        }
        if (iterable instanceof Collection) {
            if (i10 >= ((Collection) iterable).size()) {
                return x0(iterable);
            }
            if (i10 == 1) {
                return r.e(S(iterable));
            }
        }
        ArrayList arrayList = new ArrayList(i10);
        Iterator<? extends T> iterator2 = iterable.iterator2();
        while (iterator2.hasNext()) {
            arrayList.add(iterator2.next());
            i11++;
            if (i11 == i10) {
                break;
            }
        }
        return s.p(arrayList);
    }

    @NotNull
    public static final <T, C extends Collection<? super T>> C u0(@NotNull Iterable<? extends T> iterable, @NotNull C destination) {
        kotlin.jvm.internal.s.i(iterable, "<this>");
        kotlin.jvm.internal.s.i(destination, "destination");
        Iterator<? extends T> iterator2 = iterable.iterator2();
        while (iterator2.hasNext()) {
            destination.add(iterator2.next());
        }
        return destination;
    }

    @NotNull
    public static final float[] v0(@NotNull Collection<Float> collection) {
        kotlin.jvm.internal.s.i(collection, "<this>");
        float[] fArr = new float[collection.size()];
        Iterator<Float> iterator2 = collection.iterator2();
        int i10 = 0;
        while (iterator2.hasNext()) {
            fArr[i10] = iterator2.next().floatValue();
            i10++;
        }
        return fArr;
    }

    @NotNull
    public static final int[] w0(@NotNull Collection<Integer> collection) {
        kotlin.jvm.internal.s.i(collection, "<this>");
        int[] iArr = new int[collection.size()];
        Iterator<Integer> iterator2 = collection.iterator2();
        int i10 = 0;
        while (iterator2.hasNext()) {
            iArr[i10] = iterator2.next().intValue();
            i10++;
        }
        return iArr;
    }

    @NotNull
    public static final <T> List<T> x0(@NotNull Iterable<? extends T> iterable) {
        kotlin.jvm.internal.s.i(iterable, "<this>");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size == 0) {
                return s.j();
            }
            if (size != 1) {
                return z0(collection);
            }
            return r.e(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator2().next());
        }
        return s.p(y0(iterable));
    }

    @NotNull
    public static final <T> List<T> y0(@NotNull Iterable<? extends T> iterable) {
        kotlin.jvm.internal.s.i(iterable, "<this>");
        if (iterable instanceof Collection) {
            return z0((Collection) iterable);
        }
        return (List) u0(iterable, new ArrayList());
    }

    @NotNull
    public static final <T> List<T> z0(@NotNull Collection<? extends T> collection) {
        kotlin.jvm.internal.s.i(collection, "<this>");
        return new ArrayList(collection);
    }
}
