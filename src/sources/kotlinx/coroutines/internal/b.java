package kotlinx.coroutines.internal;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Atomic.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public d<?> f51371a;

    public abstract void a(@NotNull d<?> dVar, @Nullable Object obj);

    @NotNull
    public final d<?> b() {
        d<?> dVar = this.f51371a;
        if (dVar != null) {
            return dVar;
        }
        kotlin.jvm.internal.s.A("atomicOp");
        return null;
    }

    @Nullable
    public abstract Object c(@NotNull d<?> dVar);

    public final void d(@NotNull d<?> dVar) {
        this.f51371a = dVar;
    }
}
