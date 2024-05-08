package kotlin.coroutines;

import kotlin.Result;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;

/* compiled from: Continuation.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class d {
    public static final <T> void a(@NotNull Function1<? super Continuation<? super T>, ? extends Object> function1, @NotNull Continuation<? super T> completion) {
        s.i(function1, "<this>");
        s.i(completion, "completion");
        Continuation c4 = IntrinsicsKt__IntrinsicsJvmKt.c(IntrinsicsKt__IntrinsicsJvmKt.a(function1, completion));
        Result.Companion companion = Result.Companion;
        c4.resumeWith(Result.m3565constructorimpl(p.f51048a));
    }

    public static final <R, T> void b(@NotNull Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r10, @NotNull Continuation<? super T> completion) {
        s.i(function2, "<this>");
        s.i(completion, "completion");
        Continuation c4 = IntrinsicsKt__IntrinsicsJvmKt.c(IntrinsicsKt__IntrinsicsJvmKt.b(function2, r10, completion));
        Result.Companion companion = Result.Companion;
        c4.resumeWith(Result.m3565constructorimpl(p.f51048a));
    }
}
