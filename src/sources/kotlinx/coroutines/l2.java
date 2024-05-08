package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;

/* compiled from: Timeout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class l2<U, T extends U> extends kotlinx.coroutines.internal.b0<T> implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    public final long f51439e;

    public l2(long j10, @NotNull Continuation<? super U> continuation) {
        super(continuation.getContext(), continuation);
        this.f51439e = j10;
    }

    @Override // kotlinx.coroutines.a, kotlinx.coroutines.u1
    @NotNull
    public String n0() {
        return super.n0() + "(timeMillis=" + this.f51439e + ')';
    }

    @Override // java.lang.Runnable
    public void run() {
        L(TimeoutKt.a(this.f51439e, this));
    }
}
