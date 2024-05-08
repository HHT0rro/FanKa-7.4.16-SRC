package kotlinx.coroutines.internal;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Atomic.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class y {
    @Nullable
    public abstract d<?> a();

    public final boolean b(@NotNull y yVar) {
        d<?> a10;
        d<?> a11 = a();
        return (a11 == null || (a10 = yVar.a()) == null || a11.g() >= a10.g()) ? false : true;
    }

    @Nullable
    public abstract Object c(@Nullable Object obj);

    @NotNull
    public String toString() {
        return kotlinx.coroutines.j0.a(this) + '@' + kotlinx.coroutines.j0.b(this);
    }
}
