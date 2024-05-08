package androidx.core.util;

import android.util.SparseArray;
import java.util.Iterator;
import kotlin.collections.e0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;

/* compiled from: SparseArray.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class SparseArrayKt {
    public static final <T> boolean contains(@NotNull SparseArray<T> sparseArray, int i10) {
        s.i(sparseArray, "<this>");
        return sparseArray.indexOfKey(i10) >= 0;
    }

    public static final <T> boolean containsKey(@NotNull SparseArray<T> sparseArray, int i10) {
        s.i(sparseArray, "<this>");
        return sparseArray.indexOfKey(i10) >= 0;
    }

    public static final <T> boolean containsValue(@NotNull SparseArray<T> sparseArray, T t2) {
        s.i(sparseArray, "<this>");
        return sparseArray.indexOfValue(t2) >= 0;
    }

    public static final <T> void forEach(@NotNull SparseArray<T> sparseArray, @NotNull Function2<? super Integer, ? super T, p> action) {
        s.i(sparseArray, "<this>");
        s.i(action, "action");
        int size = sparseArray.size();
        for (int i10 = 0; i10 < size; i10++) {
            action.mo1743invoke(Integer.valueOf(sparseArray.keyAt(i10)), sparseArray.valueAt(i10));
        }
    }

    public static final <T> T getOrDefault(@NotNull SparseArray<T> sparseArray, int i10, T t2) {
        s.i(sparseArray, "<this>");
        T t10 = sparseArray.get(i10);
        return t10 == null ? t2 : t10;
    }

    public static final <T> T getOrElse(@NotNull SparseArray<T> sparseArray, int i10, @NotNull Function0<? extends T> defaultValue) {
        s.i(sparseArray, "<this>");
        s.i(defaultValue, "defaultValue");
        T t2 = sparseArray.get(i10);
        return t2 == null ? defaultValue.invoke() : t2;
    }

    public static final <T> int getSize(@NotNull SparseArray<T> sparseArray) {
        s.i(sparseArray, "<this>");
        return sparseArray.size();
    }

    public static final <T> boolean isEmpty(@NotNull SparseArray<T> sparseArray) {
        s.i(sparseArray, "<this>");
        return sparseArray.size() == 0;
    }

    public static final <T> boolean isNotEmpty(@NotNull SparseArray<T> sparseArray) {
        s.i(sparseArray, "<this>");
        return sparseArray.size() != 0;
    }

    @NotNull
    public static final <T> e0 keyIterator(@NotNull final SparseArray<T> sparseArray) {
        s.i(sparseArray, "<this>");
        return new e0() { // from class: androidx.core.util.SparseArrayKt$keyIterator$1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < sparseArray.size();
            }

            @Override // kotlin.collections.e0
            public int nextInt() {
                SparseArray<T> sparseArray2 = sparseArray;
                int i10 = this.index;
                this.index = i10 + 1;
                return sparseArray2.keyAt(i10);
            }

            public final void setIndex(int i10) {
                this.index = i10;
            }
        };
    }

    @NotNull
    public static final <T> SparseArray<T> plus(@NotNull SparseArray<T> sparseArray, @NotNull SparseArray<T> other) {
        s.i(sparseArray, "<this>");
        s.i(other, "other");
        SparseArray<T> sparseArray2 = new SparseArray<>(sparseArray.size() + other.size());
        putAll(sparseArray2, sparseArray);
        putAll(sparseArray2, other);
        return sparseArray2;
    }

    public static final <T> void putAll(@NotNull SparseArray<T> sparseArray, @NotNull SparseArray<T> other) {
        s.i(sparseArray, "<this>");
        s.i(other, "other");
        int size = other.size();
        for (int i10 = 0; i10 < size; i10++) {
            sparseArray.put(other.keyAt(i10), other.valueAt(i10));
        }
    }

    public static final <T> boolean remove(@NotNull SparseArray<T> sparseArray, int i10, T t2) {
        s.i(sparseArray, "<this>");
        int indexOfKey = sparseArray.indexOfKey(i10);
        if (indexOfKey < 0 || !s.d(t2, sparseArray.valueAt(indexOfKey))) {
            return false;
        }
        sparseArray.removeAt(indexOfKey);
        return true;
    }

    public static final <T> void set(@NotNull SparseArray<T> sparseArray, int i10, T t2) {
        s.i(sparseArray, "<this>");
        sparseArray.put(i10, t2);
    }

    @NotNull
    public static final <T> Iterator<T> valueIterator(@NotNull SparseArray<T> sparseArray) {
        s.i(sparseArray, "<this>");
        return new SparseArrayKt$valueIterator$1(sparseArray);
    }
}
