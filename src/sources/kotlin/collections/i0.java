package kotlin.collections;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;

/* compiled from: Maps.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class i0 extends h0 {
    @NotNull
    public static final <K, V> Map<K, V> f() {
        EmptyMap emptyMap = EmptyMap.INSTANCE;
        kotlin.jvm.internal.s.g(emptyMap, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.emptyMap, V of kotlin.collections.MapsKt__MapsKt.emptyMap>");
        return emptyMap;
    }

    @NotNull
    public static final <K, V> Map<K, V> g(@NotNull Pair<? extends K, ? extends V>... pairs) {
        kotlin.jvm.internal.s.i(pairs, "pairs");
        return pairs.length > 0 ? o(pairs, new LinkedHashMap(h0.c(pairs.length))) : f();
    }

    @NotNull
    public static final <K, V> Map<K, V> h(@NotNull Pair<? extends K, ? extends V>... pairs) {
        kotlin.jvm.internal.s.i(pairs, "pairs");
        LinkedHashMap linkedHashMap = new LinkedHashMap(h0.c(pairs.length));
        k(linkedHashMap, pairs);
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <K, V> Map<K, V> i(@NotNull Map<K, ? extends V> map) {
        kotlin.jvm.internal.s.i(map, "<this>");
        int size = map.size();
        if (size != 0) {
            return size != 1 ? map : h0.e(map);
        }
        return f();
    }

    public static final <K, V> void j(@NotNull Map<? super K, ? super V> map, @NotNull Iterable<? extends Pair<? extends K, ? extends V>> pairs) {
        kotlin.jvm.internal.s.i(map, "<this>");
        kotlin.jvm.internal.s.i(pairs, "pairs");
        for (Pair<? extends K, ? extends V> pair : pairs) {
            map.put(pair.component1(), pair.component2());
        }
    }

    public static final <K, V> void k(@NotNull Map<? super K, ? super V> map, @NotNull Pair<? extends K, ? extends V>[] pairs) {
        kotlin.jvm.internal.s.i(map, "<this>");
        kotlin.jvm.internal.s.i(pairs, "pairs");
        for (Pair<? extends K, ? extends V> pair : pairs) {
            map.put(pair.component1(), pair.component2());
        }
    }

    @NotNull
    public static final <K, V> Map<K, V> l(@NotNull Iterable<? extends Pair<? extends K, ? extends V>> iterable) {
        kotlin.jvm.internal.s.i(iterable, "<this>");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size == 0) {
                return f();
            }
            if (size != 1) {
                return m(iterable, new LinkedHashMap(h0.c(collection.size())));
            }
            return h0.d(iterable instanceof List ? (Pair<? extends K, ? extends V>) ((List) iterable).get(0) : iterable.iterator2().next());
        }
        return i(m(iterable, new LinkedHashMap()));
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M m(@NotNull Iterable<? extends Pair<? extends K, ? extends V>> iterable, @NotNull M destination) {
        kotlin.jvm.internal.s.i(iterable, "<this>");
        kotlin.jvm.internal.s.i(destination, "destination");
        j(destination, iterable);
        return destination;
    }

    @NotNull
    public static final <K, V> Map<K, V> n(@NotNull Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.s.i(map, "<this>");
        int size = map.size();
        if (size == 0) {
            return f();
        }
        if (size != 1) {
            return p(map);
        }
        return h0.e(map);
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M o(@NotNull Pair<? extends K, ? extends V>[] pairArr, @NotNull M destination) {
        kotlin.jvm.internal.s.i(pairArr, "<this>");
        kotlin.jvm.internal.s.i(destination, "destination");
        k(destination, pairArr);
        return destination;
    }

    @NotNull
    public static final <K, V> Map<K, V> p(@NotNull Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.s.i(map, "<this>");
        return new LinkedHashMap(map);
    }
}
