package kotlinx.coroutines;

import java.util.concurrent.Future;
import org.jetbrains.annotations.NotNull;

/* compiled from: Executors.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class s0 implements t0 {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final Future<?> f51464b;

    public s0(@NotNull Future<?> future) {
        this.f51464b = future;
    }

    @Override // kotlinx.coroutines.t0
    public void dispose() {
        this.f51464b.cancel(false);
    }

    @NotNull
    public String toString() {
        return "DisposableFutureHandle[" + ((Object) this.f51464b) + ']';
    }
}
