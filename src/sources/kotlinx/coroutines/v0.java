package kotlinx.coroutines;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: JobSupport.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class v0 extends t1 {

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public final t0 f51546f;

    public v0(@NotNull t0 t0Var) {
        this.f51546f = t0Var;
    }

    @Override // kotlinx.coroutines.z
    public void P(@Nullable Throwable th) {
        this.f51546f.dispose();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ kotlin.p invoke(Throwable th) {
        P(th);
        return kotlin.p.f51048a;
    }
}
