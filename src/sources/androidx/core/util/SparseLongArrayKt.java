package androidx.core.util;

import android.util.SparseLongArray;
import androidx.annotation.RequiresApi;
import kotlin.collections.e0;
import kotlin.collections.f0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;

/* compiled from: SparseLongArray.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class SparseLongArrayKt {
    @RequiresApi(18)
    public static final boolean contains(@NotNull SparseLongArray sparseLongArray, int i10) {
        s.i(sparseLongArray, "<this>");
        return sparseLongArray.indexOfKey(i10) >= 0;
    }

    @RequiresApi(18)
    public static final boolean containsKey(@NotNull SparseLongArray sparseLongArray, int i10) {
        s.i(sparseLongArray, "<this>");
        return sparseLongArray.indexOfKey(i10) >= 0;
    }

    @RequiresApi(18)
    public static final boolean containsValue(@NotNull SparseLongArray sparseLongArray, long j10) {
        s.i(sparseLongArray, "<this>");
        return sparseLongArray.indexOfValue(j10) >= 0;
    }

    @RequiresApi(18)
    public static final void forEach(@NotNull SparseLongArray sparseLongArray, @NotNull Function2<? super Integer, ? super Long, p> action) {
        s.i(sparseLongArray, "<this>");
        s.i(action, "action");
        int size = sparseLongArray.size();
        for (int i10 = 0; i10 < size; i10++) {
            action.mo1743invoke(Integer.valueOf(sparseLongArray.keyAt(i10)), Long.valueOf(sparseLongArray.valueAt(i10)));
        }
    }

    @RequiresApi(18)
    public static final long getOrDefault(@NotNull SparseLongArray sparseLongArray, int i10, long j10) {
        s.i(sparseLongArray, "<this>");
        return sparseLongArray.get(i10, j10);
    }

    @RequiresApi(18)
    public static final long getOrElse(@NotNull SparseLongArray sparseLongArray, int i10, @NotNull Function0<Long> defaultValue) {
        s.i(sparseLongArray, "<this>");
        s.i(defaultValue, "defaultValue");
        int indexOfKey = sparseLongArray.indexOfKey(i10);
        return indexOfKey >= 0 ? sparseLongArray.valueAt(indexOfKey) : defaultValue.invoke().longValue();
    }

    @RequiresApi(18)
    public static final int getSize(@NotNull SparseLongArray sparseLongArray) {
        s.i(sparseLongArray, "<this>");
        return sparseLongArray.size();
    }

    @RequiresApi(18)
    public static final boolean isEmpty(@NotNull SparseLongArray sparseLongArray) {
        s.i(sparseLongArray, "<this>");
        return sparseLongArray.size() == 0;
    }

    @RequiresApi(18)
    public static final boolean isNotEmpty(@NotNull SparseLongArray sparseLongArray) {
        s.i(sparseLongArray, "<this>");
        return sparseLongArray.size() != 0;
    }

    @RequiresApi(18)
    @NotNull
    public static final e0 keyIterator(@NotNull final SparseLongArray sparseLongArray) {
        s.i(sparseLongArray, "<this>");
        return new e0() { // from class: androidx.core.util.SparseLongArrayKt$keyIterator$1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < sparseLongArray.size();
            }

            @Override // kotlin.collections.e0
            public int nextInt() {
                SparseLongArray sparseLongArray2 = sparseLongArray;
                int i10 = this.index;
                this.index = i10 + 1;
                return sparseLongArray2.keyAt(i10);
            }

            public final void setIndex(int i10) {
                this.index = i10;
            }
        };
    }

    @RequiresApi(18)
    @NotNull
    public static final SparseLongArray plus(@NotNull SparseLongArray sparseLongArray, @NotNull SparseLongArray other) {
        s.i(sparseLongArray, "<this>");
        s.i(other, "other");
        SparseLongArray sparseLongArray2 = new SparseLongArray(sparseLongArray.size() + other.size());
        putAll(sparseLongArray2, sparseLongArray);
        putAll(sparseLongArray2, other);
        return sparseLongArray2;
    }

    @RequiresApi(18)
    public static final void putAll(@NotNull SparseLongArray sparseLongArray, @NotNull SparseLongArray other) {
        s.i(sparseLongArray, "<this>");
        s.i(other, "other");
        int size = other.size();
        for (int i10 = 0; i10 < size; i10++) {
            sparseLongArray.put(other.keyAt(i10), other.valueAt(i10));
        }
    }

    @RequiresApi(18)
    public static final boolean remove(@NotNull SparseLongArray sparseLongArray, int i10, long j10) {
        s.i(sparseLongArray, "<this>");
        int indexOfKey = sparseLongArray.indexOfKey(i10);
        if (indexOfKey < 0 || j10 != sparseLongArray.valueAt(indexOfKey)) {
            return false;
        }
        sparseLongArray.removeAt(indexOfKey);
        return true;
    }

    @RequiresApi(18)
    public static final void set(@NotNull SparseLongArray sparseLongArray, int i10, long j10) {
        s.i(sparseLongArray, "<this>");
        sparseLongArray.put(i10, j10);
    }

    @RequiresApi(18)
    @NotNull
    public static final f0 valueIterator(@NotNull final SparseLongArray sparseLongArray) {
        s.i(sparseLongArray, "<this>");
        return new f0() { // from class: androidx.core.util.SparseLongArrayKt$valueIterator$1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < sparseLongArray.size();
            }

            @Override // kotlin.collections.f0
            public long nextLong() {
                SparseLongArray sparseLongArray2 = sparseLongArray;
                int i10 = this.index;
                this.index = i10 + 1;
                return sparseLongArray2.valueAt(i10);
            }

            public final void setIndex(int i10) {
                this.index = i10;
            }
        };
    }
}
