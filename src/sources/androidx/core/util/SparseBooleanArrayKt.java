package androidx.core.util;

import android.util.SparseBooleanArray;
import kotlin.collections.e0;
import kotlin.collections.o;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;

/* compiled from: SparseBooleanArray.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class SparseBooleanArrayKt {
    public static final boolean contains(@NotNull SparseBooleanArray sparseBooleanArray, int i10) {
        s.i(sparseBooleanArray, "<this>");
        return sparseBooleanArray.indexOfKey(i10) >= 0;
    }

    public static final boolean containsKey(@NotNull SparseBooleanArray sparseBooleanArray, int i10) {
        s.i(sparseBooleanArray, "<this>");
        return sparseBooleanArray.indexOfKey(i10) >= 0;
    }

    public static final boolean containsValue(@NotNull SparseBooleanArray sparseBooleanArray, boolean z10) {
        s.i(sparseBooleanArray, "<this>");
        return sparseBooleanArray.indexOfValue(z10) >= 0;
    }

    public static final void forEach(@NotNull SparseBooleanArray sparseBooleanArray, @NotNull Function2<? super Integer, ? super Boolean, p> action) {
        s.i(sparseBooleanArray, "<this>");
        s.i(action, "action");
        int size = sparseBooleanArray.size();
        for (int i10 = 0; i10 < size; i10++) {
            action.mo1743invoke(Integer.valueOf(sparseBooleanArray.keyAt(i10)), Boolean.valueOf(sparseBooleanArray.valueAt(i10)));
        }
    }

    public static final boolean getOrDefault(@NotNull SparseBooleanArray sparseBooleanArray, int i10, boolean z10) {
        s.i(sparseBooleanArray, "<this>");
        return sparseBooleanArray.get(i10, z10);
    }

    public static final boolean getOrElse(@NotNull SparseBooleanArray sparseBooleanArray, int i10, @NotNull Function0<Boolean> defaultValue) {
        s.i(sparseBooleanArray, "<this>");
        s.i(defaultValue, "defaultValue");
        int indexOfKey = sparseBooleanArray.indexOfKey(i10);
        return indexOfKey >= 0 ? sparseBooleanArray.valueAt(indexOfKey) : defaultValue.invoke().booleanValue();
    }

    public static final int getSize(@NotNull SparseBooleanArray sparseBooleanArray) {
        s.i(sparseBooleanArray, "<this>");
        return sparseBooleanArray.size();
    }

    public static final boolean isEmpty(@NotNull SparseBooleanArray sparseBooleanArray) {
        s.i(sparseBooleanArray, "<this>");
        return sparseBooleanArray.size() == 0;
    }

    public static final boolean isNotEmpty(@NotNull SparseBooleanArray sparseBooleanArray) {
        s.i(sparseBooleanArray, "<this>");
        return sparseBooleanArray.size() != 0;
    }

    @NotNull
    public static final e0 keyIterator(@NotNull final SparseBooleanArray sparseBooleanArray) {
        s.i(sparseBooleanArray, "<this>");
        return new e0() { // from class: androidx.core.util.SparseBooleanArrayKt$keyIterator$1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < sparseBooleanArray.size();
            }

            @Override // kotlin.collections.e0
            public int nextInt() {
                SparseBooleanArray sparseBooleanArray2 = sparseBooleanArray;
                int i10 = this.index;
                this.index = i10 + 1;
                return sparseBooleanArray2.keyAt(i10);
            }

            public final void setIndex(int i10) {
                this.index = i10;
            }
        };
    }

    @NotNull
    public static final SparseBooleanArray plus(@NotNull SparseBooleanArray sparseBooleanArray, @NotNull SparseBooleanArray other) {
        s.i(sparseBooleanArray, "<this>");
        s.i(other, "other");
        SparseBooleanArray sparseBooleanArray2 = new SparseBooleanArray(sparseBooleanArray.size() + other.size());
        putAll(sparseBooleanArray2, sparseBooleanArray);
        putAll(sparseBooleanArray2, other);
        return sparseBooleanArray2;
    }

    public static final void putAll(@NotNull SparseBooleanArray sparseBooleanArray, @NotNull SparseBooleanArray other) {
        s.i(sparseBooleanArray, "<this>");
        s.i(other, "other");
        int size = other.size();
        for (int i10 = 0; i10 < size; i10++) {
            sparseBooleanArray.put(other.keyAt(i10), other.valueAt(i10));
        }
    }

    public static final boolean remove(@NotNull SparseBooleanArray sparseBooleanArray, int i10, boolean z10) {
        s.i(sparseBooleanArray, "<this>");
        int indexOfKey = sparseBooleanArray.indexOfKey(i10);
        if (indexOfKey < 0 || z10 != sparseBooleanArray.valueAt(indexOfKey)) {
            return false;
        }
        sparseBooleanArray.delete(i10);
        return true;
    }

    public static final void set(@NotNull SparseBooleanArray sparseBooleanArray, int i10, boolean z10) {
        s.i(sparseBooleanArray, "<this>");
        sparseBooleanArray.put(i10, z10);
    }

    @NotNull
    public static final o valueIterator(@NotNull final SparseBooleanArray sparseBooleanArray) {
        s.i(sparseBooleanArray, "<this>");
        return new o() { // from class: androidx.core.util.SparseBooleanArrayKt$valueIterator$1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < sparseBooleanArray.size();
            }

            @Override // kotlin.collections.o
            public boolean nextBoolean() {
                SparseBooleanArray sparseBooleanArray2 = sparseBooleanArray;
                int i10 = this.index;
                this.index = i10 + 1;
                return sparseBooleanArray2.valueAt(i10);
            }

            public final void setIndex(int i10) {
                this.index = i10;
            }
        };
    }
}
