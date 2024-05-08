package androidx.collection;

import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import yd.n;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: LruCache.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class LruCacheKt$lruCache$4<K, V> extends LruCache<K, V> {
    public final /* synthetic */ Function1 $create;
    public final /* synthetic */ int $maxSize;
    public final /* synthetic */ n $onEntryRemoved;
    public final /* synthetic */ Function2 $sizeOf;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LruCacheKt$lruCache$4(Function2 function2, Function1 function1, n nVar, int i10, int i11) {
        super(i11);
        this.$sizeOf = function2;
        this.$create = function1;
        this.$onEntryRemoved = nVar;
        this.$maxSize = i10;
    }

    @Override // androidx.collection.LruCache
    @Nullable
    public V create(@NotNull K key) {
        s.j(key, "key");
        return (V) this.$create.invoke(key);
    }

    @Override // androidx.collection.LruCache
    public void entryRemoved(boolean z10, @NotNull K key, @NotNull V oldValue, @Nullable V v2) {
        s.j(key, "key");
        s.j(oldValue, "oldValue");
        this.$onEntryRemoved.invoke(Boolean.valueOf(z10), key, oldValue, v2);
    }

    @Override // androidx.collection.LruCache
    public int sizeOf(@NotNull K key, @NotNull V value) {
        s.j(key, "key");
        s.j(value, "value");
        return ((Number) this.$sizeOf.mo1743invoke(key, value)).intValue();
    }
}
