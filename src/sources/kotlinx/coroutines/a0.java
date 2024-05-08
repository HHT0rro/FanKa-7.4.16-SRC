package kotlinx.coroutines;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CompletionState.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class a0 {
    @NotNull
    public static final <T> Object a(@Nullable Object obj, @NotNull Continuation<? super T> continuation) {
        if (obj instanceof x) {
            Result.Companion companion = Result.Companion;
            return Result.m3565constructorimpl(kotlin.e.a(((x) obj).f51562a));
        }
        Result.Companion companion2 = Result.Companion;
        return Result.m3565constructorimpl(obj);
    }

    @Nullable
    public static final <T> Object b(@NotNull Object obj, @Nullable Function1<? super Throwable, kotlin.p> function1) {
        Throwable m3568exceptionOrNullimpl = Result.m3568exceptionOrNullimpl(obj);
        if (m3568exceptionOrNullimpl == null) {
            return function1 != null ? new y(obj, function1) : obj;
        }
        return new x(m3568exceptionOrNullimpl, false, 2, null);
    }

    @Nullable
    public static final <T> Object c(@NotNull Object obj, @NotNull l<?> lVar) {
        Throwable m3568exceptionOrNullimpl = Result.m3568exceptionOrNullimpl(obj);
        return m3568exceptionOrNullimpl == null ? obj : new x(m3568exceptionOrNullimpl, false, 2, null);
    }

    public static /* synthetic */ Object d(Object obj, Function1 function1, int i10, Object obj2) {
        if ((i10 & 1) != 0) {
            function1 = null;
        }
        return b(obj, function1);
    }
}
