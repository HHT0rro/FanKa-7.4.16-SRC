package kotlinx.coroutines.flow;

import org.jetbrains.annotations.NotNull;

/* compiled from: SharingStarted.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class StartedLazily implements m1 {
    @Override // kotlinx.coroutines.flow.m1
    @NotNull
    public c<SharingCommand> a(@NotNull p1<Integer> p1Var) {
        return e.u(new StartedLazily$command$1(p1Var, null));
    }

    @NotNull
    public String toString() {
        return "SharingStarted.Lazily";
    }
}
