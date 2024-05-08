package kotlin;

import kotlin.Result;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: Result.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class e {
    @NotNull
    public static final Object a(@NotNull Throwable exception) {
        s.i(exception, "exception");
        return new Result.Failure(exception);
    }

    public static final void b(@NotNull Object obj) {
        if (obj instanceof Result.Failure) {
            throw ((Result.Failure) obj).exception;
        }
    }
}
