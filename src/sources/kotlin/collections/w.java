package kotlin.collections;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* compiled from: MutableCollectionsJVM.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class w extends v {
    public static final <T extends Comparable<? super T>> void v(@NotNull List<T> list) {
        kotlin.jvm.internal.s.i(list, "<this>");
        if (list.size() > 1) {
            Collections.sort(list);
        }
    }

    public static final <T> void w(@NotNull List<T> list, @NotNull Comparator<? super T> comparator) {
        kotlin.jvm.internal.s.i(list, "<this>");
        kotlin.jvm.internal.s.i(comparator, "comparator");
        if (list.size() > 1) {
            Collections.sort(list, comparator);
        }
    }
}
