package kotlinx.coroutines;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Job.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class z1 implements t0, r {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final z1 f51576b = new z1();

    @Override // kotlinx.coroutines.r
    public boolean b(@NotNull Throwable th) {
        return false;
    }

    @Override // kotlinx.coroutines.t0
    public void dispose() {
    }

    @Override // kotlinx.coroutines.r
    @Nullable
    public n1 getParent() {
        return null;
    }

    @NotNull
    public String toString() {
        return "NonDisposableHandle";
    }
}
