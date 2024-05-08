package kotlinx.coroutines;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;

/* compiled from: DebugStrings.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class j0 {
    @NotNull
    public static final String a(@NotNull Object obj) {
        return obj.getClass().getSimpleName();
    }

    @NotNull
    public static final String b(@NotNull Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    @NotNull
    public static final String c(@NotNull Continuation<?> continuation) {
        Object m3565constructorimpl;
        if (continuation instanceof kotlinx.coroutines.internal.i) {
            return continuation.toString();
        }
        try {
            Result.Companion companion = Result.Companion;
            m3565constructorimpl = Result.m3565constructorimpl(((Object) continuation) + '@' + b(continuation));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m3565constructorimpl = Result.m3565constructorimpl(kotlin.e.a(th));
        }
        if (Result.m3568exceptionOrNullimpl(m3565constructorimpl) != null) {
            m3565constructorimpl = continuation.getClass().getName() + '@' + b(continuation);
        }
        return (String) m3565constructorimpl;
    }
}
