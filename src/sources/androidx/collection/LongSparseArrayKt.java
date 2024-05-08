package androidx.collection;

import java.util.Iterator;
import kotlin.collections.f0;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;

/* compiled from: LongSparseArray.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class LongSparseArrayKt {
    public static final <T> boolean contains(@NotNull LongSparseArray<T> receiver$0, long j10) {
        s.j(receiver$0, "receiver$0");
        return receiver$0.containsKey(j10);
    }

    public static final <T> void forEach(@NotNull LongSparseArray<T> receiver$0, @NotNull Function2<? super Long, ? super T, p> action) {
        s.j(receiver$0, "receiver$0");
        s.j(action, "action");
        int size = receiver$0.size();
        for (int i10 = 0; i10 < size; i10++) {
            action.mo1743invoke(Long.valueOf(receiver$0.keyAt(i10)), receiver$0.valueAt(i10));
        }
    }

    public static final <T> T getOrDefault(@NotNull LongSparseArray<T> receiver$0, long j10, T t2) {
        s.j(receiver$0, "receiver$0");
        return receiver$0.get(j10, t2);
    }

    public static final <T> T getOrElse(@NotNull LongSparseArray<T> receiver$0, long j10, @NotNull Function0<? extends T> defaultValue) {
        s.j(receiver$0, "receiver$0");
        s.j(defaultValue, "defaultValue");
        T t2 = receiver$0.get(j10);
        return t2 != null ? t2 : defaultValue.invoke();
    }

    public static final <T> int getSize(@NotNull LongSparseArray<T> receiver$0) {
        s.j(receiver$0, "receiver$0");
        return receiver$0.size();
    }

    public static final <T> boolean isNotEmpty(@NotNull LongSparseArray<T> receiver$0) {
        s.j(receiver$0, "receiver$0");
        return !receiver$0.isEmpty();
    }

    @NotNull
    public static final <T> f0 keyIterator(@NotNull final LongSparseArray<T> receiver$0) {
        s.j(receiver$0, "receiver$0");
        return new f0() { // from class: androidx.collection.LongSparseArrayKt$keyIterator$1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < receiver$0.size();
            }

            @Override // kotlin.collections.f0
            public long nextLong() {
                LongSparseArray longSparseArray = receiver$0;
                int i10 = this.index;
                this.index = i10 + 1;
                return longSparseArray.keyAt(i10);
            }

            public final void setIndex(int i10) {
                this.index = i10;
            }
        };
    }

    @NotNull
    public static final <T> LongSparseArray<T> plus(@NotNull LongSparseArray<T> receiver$0, @NotNull LongSparseArray<T> other) {
        s.j(receiver$0, "receiver$0");
        s.j(other, "other");
        LongSparseArray<T> longSparseArray = new LongSparseArray<>(receiver$0.size() + other.size());
        longSparseArray.putAll(receiver$0);
        longSparseArray.putAll(other);
        return longSparseArray;
    }

    public static final <T> boolean remove(@NotNull LongSparseArray<T> receiver$0, long j10, T t2) {
        s.j(receiver$0, "receiver$0");
        return receiver$0.remove(j10, t2);
    }

    public static final <T> void set(@NotNull LongSparseArray<T> receiver$0, long j10, T t2) {
        s.j(receiver$0, "receiver$0");
        receiver$0.put(j10, t2);
    }

    @NotNull
    public static final <T> Iterator<T> valueIterator(@NotNull LongSparseArray<T> receiver$0) {
        s.j(receiver$0, "receiver$0");
        return new LongSparseArrayKt$valueIterator$1(receiver$0);
    }
}
