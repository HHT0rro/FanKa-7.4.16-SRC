package kotlin;

import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: Exceptions.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class a {
    public static final void a(@NotNull Throwable th, @NotNull Throwable exception) {
        s.i(th, "<this>");
        s.i(exception, "exception");
        if (th != exception) {
            ud.b.f54017a.a(th, exception);
        }
    }
}
