package kotlinx.coroutines;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CancellableContinuation.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class u0 extends j {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final t0 f51537b;

    public u0(@NotNull t0 t0Var) {
        this.f51537b = t0Var;
    }

    @Override // kotlinx.coroutines.k
    public void a(@Nullable Throwable th) {
        this.f51537b.dispose();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ kotlin.p invoke(Throwable th) {
        a(th);
        return kotlin.p.f51048a;
    }

    @NotNull
    public String toString() {
        return "DisposeOnCancel[" + ((Object) this.f51537b) + ']';
    }
}
