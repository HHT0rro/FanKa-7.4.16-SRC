package androidx.collection;

import java.util.Iterator;
import kotlin.collections.e0;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;

/* compiled from: SparseArray.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class SparseArrayKt {
    public static final <T> boolean contains(@NotNull SparseArrayCompat<T> receiver$0, int i10) {
        s.j(receiver$0, "receiver$0");
        return receiver$0.containsKey(i10);
    }

    public static final <T> void forEach(@NotNull SparseArrayCompat<T> receiver$0, @NotNull Function2<? super Integer, ? super T, p> action) {
        s.j(receiver$0, "receiver$0");
        s.j(action, "action");
        int size = receiver$0.size();
        for (int i10 = 0; i10 < size; i10++) {
            action.mo1743invoke(Integer.valueOf(receiver$0.keyAt(i10)), receiver$0.valueAt(i10));
        }
    }

    public static final <T> T getOrDefault(@NotNull SparseArrayCompat<T> receiver$0, int i10, T t2) {
        s.j(receiver$0, "receiver$0");
        return receiver$0.get(i10, t2);
    }

    public static final <T> T getOrElse(@NotNull SparseArrayCompat<T> receiver$0, int i10, @NotNull Function0<? extends T> defaultValue) {
        s.j(receiver$0, "receiver$0");
        s.j(defaultValue, "defaultValue");
        T t2 = receiver$0.get(i10);
        return t2 != null ? t2 : defaultValue.invoke();
    }

    public static final <T> int getSize(@NotNull SparseArrayCompat<T> receiver$0) {
        s.j(receiver$0, "receiver$0");
        return receiver$0.size();
    }

    public static final <T> boolean isNotEmpty(@NotNull SparseArrayCompat<T> receiver$0) {
        s.j(receiver$0, "receiver$0");
        return !receiver$0.isEmpty();
    }

    @NotNull
    public static final <T> e0 keyIterator(@NotNull final SparseArrayCompat<T> receiver$0) {
        s.j(receiver$0, "receiver$0");
        return new e0() { // from class: androidx.collection.SparseArrayKt$keyIterator$1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < receiver$0.size();
            }

            @Override // kotlin.collections.e0
            public int nextInt() {
                SparseArrayCompat sparseArrayCompat = receiver$0;
                int i10 = this.index;
                this.index = i10 + 1;
                return sparseArrayCompat.keyAt(i10);
            }

            public final void setIndex(int i10) {
                this.index = i10;
            }
        };
    }

    @NotNull
    public static final <T> SparseArrayCompat<T> plus(@NotNull SparseArrayCompat<T> receiver$0, @NotNull SparseArrayCompat<T> other) {
        s.j(receiver$0, "receiver$0");
        s.j(other, "other");
        SparseArrayCompat<T> sparseArrayCompat = new SparseArrayCompat<>(receiver$0.size() + other.size());
        sparseArrayCompat.putAll(receiver$0);
        sparseArrayCompat.putAll(other);
        return sparseArrayCompat;
    }

    public static final <T> boolean remove(@NotNull SparseArrayCompat<T> receiver$0, int i10, T t2) {
        s.j(receiver$0, "receiver$0");
        return receiver$0.remove(i10, t2);
    }

    public static final <T> void set(@NotNull SparseArrayCompat<T> receiver$0, int i10, T t2) {
        s.j(receiver$0, "receiver$0");
        receiver$0.put(i10, t2);
    }

    @NotNull
    public static final <T> Iterator<T> valueIterator(@NotNull SparseArrayCompat<T> receiver$0) {
        s.j(receiver$0, "receiver$0");
        return new SparseArrayKt$valueIterator$1(receiver$0);
    }
}
