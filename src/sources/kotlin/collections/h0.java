package kotlin.collections;

import java.util.Collections;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.builders.MapBuilder;
import org.jetbrains.annotations.NotNull;

/* compiled from: MapsJVM.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class h0 extends g0 {
    @NotNull
    public static final <K, V> Map<K, V> a(@NotNull Map<K, V> builder) {
        kotlin.jvm.internal.s.i(builder, "builder");
        return ((MapBuilder) builder).build();
    }

    @NotNull
    public static final <K, V> Map<K, V> b(int i10) {
        return new MapBuilder(i10);
    }

    public static final int c(int i10) {
        if (i10 < 0) {
            return i10;
        }
        if (i10 < 3) {
            return i10 + 1;
        }
        if (i10 < 1073741824) {
            return (int) ((i10 / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    @NotNull
    public static final <K, V> Map<K, V> d(@NotNull Pair<? extends K, ? extends V> pair) {
        kotlin.jvm.internal.s.i(pair, "pair");
        Map<K, V> singletonMap = Collections.singletonMap(pair.getFirst(), pair.getSecond());
        kotlin.jvm.internal.s.h(singletonMap, "singletonMap(pair.first, pair.second)");
        return singletonMap;
    }

    @NotNull
    public static final <K, V> Map<K, V> e(@NotNull Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.s.i(map, "<this>");
        Map.Entry<? extends K, ? extends V> next = map.entrySet().iterator2().next();
        Map<K, V> singletonMap = Collections.singletonMap(next.getKey(), next.getValue());
        kotlin.jvm.internal.s.h(singletonMap, "with(entries.iterator().…ingletonMap(key, value) }");
        return singletonMap;
    }
}
