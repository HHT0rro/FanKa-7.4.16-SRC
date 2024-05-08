package androidx.core.util;

import android.util.LruCache;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import yd.n;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: LruCache.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class LruCacheKt$lruCache$4<K, V> extends LruCache<K, V> {
    public final /* synthetic */ Function1<K, V> $create;
    public final /* synthetic */ n<Boolean, K, V, V, p> $onEntryRemoved;
    public final /* synthetic */ Function2<K, V, Integer> $sizeOf;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public LruCacheKt$lruCache$4(int i10, Function2<? super K, ? super V, Integer> function2, Function1<? super K, ? extends V> function1, n<? super Boolean, ? super K, ? super V, ? super V, p> nVar) {
        super(i10);
        this.$sizeOf = function2;
        this.$create = function1;
        this.$onEntryRemoved = nVar;
    }

    @Override // android.util.LruCache
    @Nullable
    public V create(@NotNull K key) {
        s.i(key, "key");
        return this.$create.invoke(key);
    }

    @Override // android.util.LruCache
    public void entryRemoved(boolean z10, @NotNull K key, @NotNull V oldValue, @Nullable V v2) {
        s.i(key, "key");
        s.i(oldValue, "oldValue");
        this.$onEntryRemoved.invoke(Boolean.valueOf(z10), key, oldValue, v2);
    }

    @Override // android.util.LruCache
    public int sizeOf(@NotNull K key, @NotNull V value) {
        s.i(key, "key");
        s.i(value, "value");
        return this.$sizeOf.mo1743invoke(key, value).intValue();
    }
}
