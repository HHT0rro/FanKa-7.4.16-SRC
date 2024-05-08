package androidx.core.util;

import android.util.LongSparseArray;
import androidx.annotation.RequiresApi;
import java.util.Iterator;
import kotlin.collections.f0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;

/* compiled from: LongSparseArray.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class LongSparseArrayKt {
    @RequiresApi(16)
    public static final <T> boolean contains(@NotNull LongSparseArray<T> longSparseArray, long j10) {
        s.i(longSparseArray, "<this>");
        return longSparseArray.indexOfKey(j10) >= 0;
    }

    @RequiresApi(16)
    public static final <T> boolean containsKey(@NotNull LongSparseArray<T> longSparseArray, long j10) {
        s.i(longSparseArray, "<this>");
        return longSparseArray.indexOfKey(j10) >= 0;
    }

    @RequiresApi(16)
    public static final <T> boolean containsValue(@NotNull LongSparseArray<T> longSparseArray, T t2) {
        s.i(longSparseArray, "<this>");
        return longSparseArray.indexOfValue(t2) >= 0;
    }

    @RequiresApi(16)
    public static final <T> void forEach(@NotNull LongSparseArray<T> longSparseArray, @NotNull Function2<? super Long, ? super T, p> action) {
        s.i(longSparseArray, "<this>");
        s.i(action, "action");
        int size = longSparseArray.size();
        for (int i10 = 0; i10 < size; i10++) {
            action.mo1743invoke(Long.valueOf(longSparseArray.keyAt(i10)), longSparseArray.valueAt(i10));
        }
    }

    @RequiresApi(16)
    public static final <T> T getOrDefault(@NotNull LongSparseArray<T> longSparseArray, long j10, T t2) {
        s.i(longSparseArray, "<this>");
        T t10 = longSparseArray.get(j10);
        return t10 == null ? t2 : t10;
    }

    @RequiresApi(16)
    public static final <T> T getOrElse(@NotNull LongSparseArray<T> longSparseArray, long j10, @NotNull Function0<? extends T> defaultValue) {
        s.i(longSparseArray, "<this>");
        s.i(defaultValue, "defaultValue");
        T t2 = longSparseArray.get(j10);
        return t2 == null ? defaultValue.invoke() : t2;
    }

    @RequiresApi(16)
    public static final <T> int getSize(@NotNull LongSparseArray<T> longSparseArray) {
        s.i(longSparseArray, "<this>");
        return longSparseArray.size();
    }

    @RequiresApi(16)
    public static final <T> boolean isEmpty(@NotNull LongSparseArray<T> longSparseArray) {
        s.i(longSparseArray, "<this>");
        return longSparseArray.size() == 0;
    }

    @RequiresApi(16)
    public static final <T> boolean isNotEmpty(@NotNull LongSparseArray<T> longSparseArray) {
        s.i(longSparseArray, "<this>");
        return longSparseArray.size() != 0;
    }

    @RequiresApi(16)
    @NotNull
    public static final <T> f0 keyIterator(@NotNull final LongSparseArray<T> longSparseArray) {
        s.i(longSparseArray, "<this>");
        return new f0() { // from class: androidx.core.util.LongSparseArrayKt$keyIterator$1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < longSparseArray.size();
            }

            @Override // kotlin.collections.f0
            public long nextLong() {
                LongSparseArray<T> longSparseArray2 = longSparseArray;
                int i10 = this.index;
                this.index = i10 + 1;
                return longSparseArray2.keyAt(i10);
            }

            public final void setIndex(int i10) {
                this.index = i10;
            }
        };
    }

    @RequiresApi(16)
    @NotNull
    public static final <T> LongSparseArray<T> plus(@NotNull LongSparseArray<T> longSparseArray, @NotNull LongSparseArray<T> other) {
        s.i(longSparseArray, "<this>");
        s.i(other, "other");
        LongSparseArray<T> longSparseArray2 = new LongSparseArray<>(longSparseArray.size() + other.size());
        putAll(longSparseArray2, longSparseArray);
        putAll(longSparseArray2, other);
        return longSparseArray2;
    }

    @RequiresApi(16)
    public static final <T> void putAll(@NotNull LongSparseArray<T> longSparseArray, @NotNull LongSparseArray<T> other) {
        s.i(longSparseArray, "<this>");
        s.i(other, "other");
        int size = other.size();
        for (int i10 = 0; i10 < size; i10++) {
            longSparseArray.put(other.keyAt(i10), other.valueAt(i10));
        }
    }

    @RequiresApi(16)
    public static final <T> boolean remove(@NotNull LongSparseArray<T> longSparseArray, long j10, T t2) {
        s.i(longSparseArray, "<this>");
        int indexOfKey = longSparseArray.indexOfKey(j10);
        if (indexOfKey < 0 || !s.d(t2, longSparseArray.valueAt(indexOfKey))) {
            return false;
        }
        longSparseArray.removeAt(indexOfKey);
        return true;
    }

    @RequiresApi(16)
    public static final <T> void set(@NotNull LongSparseArray<T> longSparseArray, long j10, T t2) {
        s.i(longSparseArray, "<this>");
        longSparseArray.put(j10, t2);
    }

    @RequiresApi(16)
    @NotNull
    public static final <T> Iterator<T> valueIterator(@NotNull LongSparseArray<T> longSparseArray) {
        s.i(longSparseArray, "<this>");
        return new LongSparseArrayKt$valueIterator$1(longSparseArray);
    }
}
