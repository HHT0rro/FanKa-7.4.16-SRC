package kotlinx.coroutines;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MainCoroutineDispatcher.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class x1 extends CoroutineDispatcher {
    @Nullable
    public final String A() {
        x1 x1Var;
        x1 c4 = r0.c();
        if (this == c4) {
            return "Dispatchers.Main";
        }
        try {
            x1Var = c4.x();
        } catch (UnsupportedOperationException unused) {
            x1Var = null;
        }
        if (this == x1Var) {
            return "Dispatchers.Main.immediate";
        }
        return null;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    @NotNull
    public CoroutineDispatcher limitedParallelism(int i10) {
        kotlinx.coroutines.internal.o.a(i10);
        return this;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    @NotNull
    public String toString() {
        String A = A();
        if (A != null) {
            return A;
        }
        return j0.a(this) + '@' + j0.b(this);
    }

    @NotNull
    public abstract x1 x();
}
