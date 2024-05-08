package androidx.core.util;

import android.util.SparseIntArray;
import kotlin.collections.e0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;

/* compiled from: SparseIntArray.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class SparseIntArrayKt {
    public static final boolean contains(@NotNull SparseIntArray sparseIntArray, int i10) {
        s.i(sparseIntArray, "<this>");
        return sparseIntArray.indexOfKey(i10) >= 0;
    }

    public static final boolean containsKey(@NotNull SparseIntArray sparseIntArray, int i10) {
        s.i(sparseIntArray, "<this>");
        return sparseIntArray.indexOfKey(i10) >= 0;
    }

    public static final boolean containsValue(@NotNull SparseIntArray sparseIntArray, int i10) {
        s.i(sparseIntArray, "<this>");
        return sparseIntArray.indexOfValue(i10) >= 0;
    }

    public static final void forEach(@NotNull SparseIntArray sparseIntArray, @NotNull Function2<? super Integer, ? super Integer, p> action) {
        s.i(sparseIntArray, "<this>");
        s.i(action, "action");
        int size = sparseIntArray.size();
        for (int i10 = 0; i10 < size; i10++) {
            action.mo1743invoke(Integer.valueOf(sparseIntArray.keyAt(i10)), Integer.valueOf(sparseIntArray.valueAt(i10)));
        }
    }

    public static final int getOrDefault(@NotNull SparseIntArray sparseIntArray, int i10, int i11) {
        s.i(sparseIntArray, "<this>");
        return sparseIntArray.get(i10, i11);
    }

    public static final int getOrElse(@NotNull SparseIntArray sparseIntArray, int i10, @NotNull Function0<Integer> defaultValue) {
        s.i(sparseIntArray, "<this>");
        s.i(defaultValue, "defaultValue");
        int indexOfKey = sparseIntArray.indexOfKey(i10);
        return indexOfKey >= 0 ? sparseIntArray.valueAt(indexOfKey) : defaultValue.invoke().intValue();
    }

    public static final int getSize(@NotNull SparseIntArray sparseIntArray) {
        s.i(sparseIntArray, "<this>");
        return sparseIntArray.size();
    }

    public static final boolean isEmpty(@NotNull SparseIntArray sparseIntArray) {
        s.i(sparseIntArray, "<this>");
        return sparseIntArray.size() == 0;
    }

    public static final boolean isNotEmpty(@NotNull SparseIntArray sparseIntArray) {
        s.i(sparseIntArray, "<this>");
        return sparseIntArray.size() != 0;
    }

    @NotNull
    public static final e0 keyIterator(@NotNull final SparseIntArray sparseIntArray) {
        s.i(sparseIntArray, "<this>");
        return new e0() { // from class: androidx.core.util.SparseIntArrayKt$keyIterator$1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < sparseIntArray.size();
            }

            @Override // kotlin.collections.e0
            public int nextInt() {
                SparseIntArray sparseIntArray2 = sparseIntArray;
                int i10 = this.index;
                this.index = i10 + 1;
                return sparseIntArray2.keyAt(i10);
            }

            public final void setIndex(int i10) {
                this.index = i10;
            }
        };
    }

    @NotNull
    public static final SparseIntArray plus(@NotNull SparseIntArray sparseIntArray, @NotNull SparseIntArray other) {
        s.i(sparseIntArray, "<this>");
        s.i(other, "other");
        SparseIntArray sparseIntArray2 = new SparseIntArray(sparseIntArray.size() + other.size());
        putAll(sparseIntArray2, sparseIntArray);
        putAll(sparseIntArray2, other);
        return sparseIntArray2;
    }

    public static final void putAll(@NotNull SparseIntArray sparseIntArray, @NotNull SparseIntArray other) {
        s.i(sparseIntArray, "<this>");
        s.i(other, "other");
        int size = other.size();
        for (int i10 = 0; i10 < size; i10++) {
            sparseIntArray.put(other.keyAt(i10), other.valueAt(i10));
        }
    }

    public static final boolean remove(@NotNull SparseIntArray sparseIntArray, int i10, int i11) {
        s.i(sparseIntArray, "<this>");
        int indexOfKey = sparseIntArray.indexOfKey(i10);
        if (indexOfKey < 0 || i11 != sparseIntArray.valueAt(indexOfKey)) {
            return false;
        }
        sparseIntArray.removeAt(indexOfKey);
        return true;
    }

    public static final void set(@NotNull SparseIntArray sparseIntArray, int i10, int i11) {
        s.i(sparseIntArray, "<this>");
        sparseIntArray.put(i10, i11);
    }

    @NotNull
    public static final e0 valueIterator(@NotNull final SparseIntArray sparseIntArray) {
        s.i(sparseIntArray, "<this>");
        return new e0() { // from class: androidx.core.util.SparseIntArrayKt$valueIterator$1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < sparseIntArray.size();
            }

            @Override // kotlin.collections.e0
            public int nextInt() {
                SparseIntArray sparseIntArray2 = sparseIntArray;
                int i10 = this.index;
                this.index = i10 + 1;
                return sparseIntArray2.valueAt(i10);
            }

            public final void setIndex(int i10) {
                this.index = i10;
            }
        };
    }
}
