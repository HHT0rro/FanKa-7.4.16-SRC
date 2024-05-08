package kotlinx.coroutines.flow;

import org.jetbrains.annotations.NotNull;

/* compiled from: SharingStarted.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class n1 implements m1 {
    @Override // kotlinx.coroutines.flow.m1
    @NotNull
    public c<SharingCommand> a(@NotNull p1<Integer> p1Var) {
        return e.v(SharingCommand.START);
    }

    @NotNull
    public String toString() {
        return "SharingStarted.Eagerly";
    }
}
