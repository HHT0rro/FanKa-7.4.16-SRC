package kotlinx.coroutines.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlinx.coroutines.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Scopes.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class b0<T> extends kotlinx.coroutines.a<T> implements td.c {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public final Continuation<T> f51372d;

    /* JADX WARN: Multi-variable type inference failed */
    public b0(@NotNull CoroutineContext coroutineContext, @NotNull Continuation<? super T> continuation) {
        super(coroutineContext, true, true);
        this.f51372d = continuation;
    }

    @Override // kotlinx.coroutines.a
    public void I0(@Nullable Object obj) {
        Continuation<T> continuation = this.f51372d;
        continuation.resumeWith(kotlinx.coroutines.a0.a(obj, continuation));
    }

    @Override // kotlinx.coroutines.u1
    public void K(@Nullable Object obj) {
        j.c(IntrinsicsKt__IntrinsicsJvmKt.c(this.f51372d), kotlinx.coroutines.a0.a(obj, this.f51372d), null, 2, null);
    }

    @Nullable
    public final n1 M0() {
        kotlinx.coroutines.r c02 = c0();
        if (c02 != null) {
            return c02.getParent();
        }
        return null;
    }

    @Override // td.c
    @Nullable
    public final td.c getCallerFrame() {
        Continuation<T> continuation = this.f51372d;
        if (continuation instanceof td.c) {
            return (td.c) continuation;
        }
        return null;
    }

    @Override // td.c
    @Nullable
    public final StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlinx.coroutines.u1
    public final boolean h0() {
        return true;
    }
}
