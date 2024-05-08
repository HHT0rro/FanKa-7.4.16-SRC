package androidx.core.util;

import android.util.Range;
import androidx.annotation.RequiresApi;
import ce.g;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: Range.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class RangeKt {
    @RequiresApi(21)
    @NotNull
    public static final <T extends Comparable<? super T>> Range<T> and(@NotNull Range<T> range, @NotNull Range<T> other) {
        s.i(range, "<this>");
        s.i(other, "other");
        Range<T> intersect = range.intersect(other);
        s.h(intersect, "intersect(other)");
        return intersect;
    }

    @RequiresApi(21)
    @NotNull
    public static final <T extends Comparable<? super T>> Range<T> plus(@NotNull Range<T> range, @NotNull T value) {
        s.i(range, "<this>");
        s.i(value, "value");
        Range<T> extend = range.extend((Range<T>) value);
        s.h(extend, "extend(value)");
        return extend;
    }

    @RequiresApi(21)
    @NotNull
    public static final <T extends Comparable<? super T>> Range<T> rangeTo(@NotNull T t2, @NotNull T that) {
        s.i(t2, "<this>");
        s.i(that, "that");
        return new Range<>(t2, that);
    }

    @RequiresApi(21)
    @NotNull
    public static final <T extends Comparable<? super T>> ce.g<T> toClosedRange(@NotNull final Range<T> range) {
        s.i(range, "<this>");
        return (ce.g<T>) new ce.g<T>() { // from class: androidx.core.util.RangeKt$toClosedRange$1
            /* JADX WARN: Incorrect types in method signature: (TT;)Z */
            public boolean contains(@NotNull Comparable comparable) {
                return g.a.a(this, comparable);
            }

            /* JADX WARN: Incorrect return type in method signature: ()TT; */
            @Override // ce.g
            public Comparable getEndInclusive() {
                return range.getUpper();
            }

            /* JADX WARN: Incorrect return type in method signature: ()TT; */
            @Override // ce.g
            public Comparable getStart() {
                return range.getLower();
            }

            public boolean isEmpty() {
                return g.a.b(this);
            }
        };
    }

    @RequiresApi(21)
    @NotNull
    public static final <T extends Comparable<? super T>> Range<T> toRange(@NotNull ce.g<T> gVar) {
        s.i(gVar, "<this>");
        return new Range<>(gVar.getStart(), gVar.getEndInclusive());
    }

    @RequiresApi(21)
    @NotNull
    public static final <T extends Comparable<? super T>> Range<T> plus(@NotNull Range<T> range, @NotNull Range<T> other) {
        s.i(range, "<this>");
        s.i(other, "other");
        Range<T> extend = range.extend(other);
        s.h(extend, "extend(other)");
        return extend;
    }
}
