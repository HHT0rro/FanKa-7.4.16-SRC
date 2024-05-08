package kotlinx.coroutines;

import java.util.concurrent.Future;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Future.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class i extends j {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final Future<?> f51351b;

    public i(@NotNull Future<?> future) {
        this.f51351b = future;
    }

    @Override // kotlinx.coroutines.k
    public void a(@Nullable Throwable th) {
        if (th != null) {
            this.f51351b.cancel(false);
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ kotlin.p invoke(Throwable th) {
        a(th);
        return kotlin.p.f51048a;
    }

    @NotNull
    public String toString() {
        return "CancelFutureOnCancel[" + ((Object) this.f51351b) + ']';
    }
}
