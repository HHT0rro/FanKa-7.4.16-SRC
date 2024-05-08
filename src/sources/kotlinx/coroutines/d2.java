package kotlinx.coroutines;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: JobSupport.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class d2 extends t1 {

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public final Continuation<kotlin.p> f51183f;

    /* JADX WARN: Multi-variable type inference failed */
    public d2(@NotNull Continuation<? super kotlin.p> continuation) {
        this.f51183f = continuation;
    }

    @Override // kotlinx.coroutines.z
    public void P(@Nullable Throwable th) {
        Continuation<kotlin.p> continuation = this.f51183f;
        Result.Companion companion = Result.Companion;
        continuation.resumeWith(Result.m3565constructorimpl(kotlin.p.f51048a));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ kotlin.p invoke(Throwable th) {
        P(th);
        return kotlin.p.f51048a;
    }
}
