package androidx.collection;

import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import yd.n;

/* compiled from: LruCache.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class LruCacheKt {
    @NotNull
    public static final <K, V> LruCache<K, V> lruCache(int i10, @NotNull Function2<? super K, ? super V, Integer> sizeOf, @NotNull Function1<? super K, ? extends V> create, @NotNull n<? super Boolean, ? super K, ? super V, ? super V, p> onEntryRemoved) {
        s.j(sizeOf, "sizeOf");
        s.j(create, "create");
        s.j(onEntryRemoved, "onEntryRemoved");
        return new LruCacheKt$lruCache$4(sizeOf, create, onEntryRemoved, i10, i10);
    }

    @NotNull
    public static /* synthetic */ LruCache lruCache$default(int i10, Function2 function2, Function1 function1, n nVar, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            function2 = new Function2() { // from class: androidx.collection.LruCacheKt$lruCache$1
                public final int invoke(@NotNull Object obj2, @NotNull Object obj3) {
                    s.j(obj2, "<anonymous parameter 0>");
                    s.j(obj3, "<anonymous parameter 1>");
                    return 1;
                }

                @Override // kotlin.jvm.functions.Function2
                /* renamed from: invoke, reason: collision with other method in class */
                public /* bridge */ /* synthetic */ Object mo1743invoke(Object obj2, Object obj3) {
                    return Integer.valueOf(invoke(obj2, obj3));
                }
            };
        }
        Function2 sizeOf = function2;
        if ((i11 & 4) != 0) {
            function1 = new Function1() { // from class: androidx.collection.LruCacheKt$lruCache$2
                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Object invoke(@NotNull Object it) {
                    s.j(it, "it");
                    return null;
                }
            };
        }
        Function1 create = function1;
        if ((i11 & 8) != 0) {
            nVar = new n() { // from class: androidx.collection.LruCacheKt$lruCache$3
                @Override // yd.n
                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3, Object obj4, Object obj5) {
                    invoke(((Boolean) obj2).booleanValue(), obj3, obj4, obj5);
                    return p.f51048a;
                }

                public final void invoke(boolean z10, @NotNull Object obj2, @NotNull Object obj3, @Nullable Object obj4) {
                    s.j(obj2, "<anonymous parameter 1>");
                    s.j(obj3, "<anonymous parameter 2>");
                }
            };
        }
        n onEntryRemoved = nVar;
        s.j(sizeOf, "sizeOf");
        s.j(create, "create");
        s.j(onEntryRemoved, "onEntryRemoved");
        return new LruCacheKt$lruCache$4(sizeOf, create, onEntryRemoved, i10, i10);
    }
}
