package androidx.core.util;

import android.util.LruCache;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import yd.n;

/* compiled from: LruCache.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class LruCacheKt {
    @NotNull
    public static final <K, V> LruCache<K, V> lruCache(int i10, @NotNull Function2<? super K, ? super V, Integer> sizeOf, @NotNull Function1<? super K, ? extends V> create, @NotNull n<? super Boolean, ? super K, ? super V, ? super V, p> onEntryRemoved) {
        s.i(sizeOf, "sizeOf");
        s.i(create, "create");
        s.i(onEntryRemoved, "onEntryRemoved");
        return new LruCacheKt$lruCache$4(i10, sizeOf, create, onEntryRemoved);
    }

    public static /* synthetic */ LruCache lruCache$default(int i10, Function2 sizeOf, Function1 create, n onEntryRemoved, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            sizeOf = new Function2() { // from class: androidx.core.util.LruCacheKt$lruCache$1
                @Override // kotlin.jvm.functions.Function2
                @NotNull
                /* renamed from: invoke */
                public final Integer mo1743invoke(@NotNull Object obj2, @NotNull Object obj3) {
                    s.i(obj2, "<anonymous parameter 0>");
                    s.i(obj3, "<anonymous parameter 1>");
                    return 1;
                }
            };
        }
        if ((i11 & 4) != 0) {
            create = new Function1() { // from class: androidx.core.util.LruCacheKt$lruCache$2
                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Object invoke(@NotNull Object it) {
                    s.i(it, "it");
                    return null;
                }
            };
        }
        if ((i11 & 8) != 0) {
            onEntryRemoved = new n() { // from class: androidx.core.util.LruCacheKt$lruCache$3
                @Override // yd.n
                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3, Object obj4, Object obj5) {
                    invoke(((Boolean) obj2).booleanValue(), obj3, obj4, obj5);
                    return p.f51048a;
                }

                public final void invoke(boolean z10, @NotNull Object obj2, @NotNull Object obj3, @Nullable Object obj4) {
                    s.i(obj2, "<anonymous parameter 1>");
                    s.i(obj3, "<anonymous parameter 2>");
                }
            };
        }
        s.i(sizeOf, "sizeOf");
        s.i(create, "create");
        s.i(onEntryRemoved, "onEntryRemoved");
        return new LruCacheKt$lruCache$4(i10, sizeOf, create, onEntryRemoved);
    }
}
