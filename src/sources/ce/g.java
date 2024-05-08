package ce;

import java.lang.Comparable;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: Range.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface g<T extends Comparable<? super T>> {

    /* compiled from: Range.kt */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class a {
        public static <T extends Comparable<? super T>> boolean a(@NotNull g<T> gVar, @NotNull T value) {
            s.i(value, "value");
            return value.compareTo(gVar.getStart()) >= 0 && value.compareTo(gVar.getEndInclusive()) <= 0;
        }

        public static <T extends Comparable<? super T>> boolean b(@NotNull g<T> gVar) {
            return gVar.getStart().compareTo(gVar.getEndInclusive()) > 0;
        }
    }

    @NotNull
    T getEndInclusive();

    @NotNull
    T getStart();
}
