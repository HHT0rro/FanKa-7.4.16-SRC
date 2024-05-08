package kotlin.text;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Appendable.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class i {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> void a(@NotNull Appendable appendable, T t2, @Nullable Function1<? super T, ? extends CharSequence> function1) {
        s.i(appendable, "<this>");
        if (function1 != null) {
            appendable.append(function1.invoke(t2));
            return;
        }
        if (t2 == 0 ? true : t2 instanceof CharSequence) {
            appendable.append((CharSequence) t2);
        } else if (t2 instanceof Character) {
            appendable.append(((Character) t2).charValue());
        } else {
            appendable.append(String.valueOf(t2));
        }
    }
}
