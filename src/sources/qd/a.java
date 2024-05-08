package qd;

import java.util.Comparator;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Comparisons.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class a {
    public static final <T extends Comparable<?>> int a(@Nullable T t2, @Nullable T t10) {
        if (t2 == t10) {
            return 0;
        }
        if (t2 == null) {
            return -1;
        }
        if (t10 == null) {
            return 1;
        }
        return t2.compareTo(t10);
    }

    @NotNull
    public static final <T extends Comparable<? super T>> Comparator<T> b() {
        b bVar = b.f53214b;
        s.g(bVar, "null cannot be cast to non-null type java.util.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.naturalOrder>{ kotlin.TypeAliasesKt.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.naturalOrder> }");
        return bVar;
    }
}
