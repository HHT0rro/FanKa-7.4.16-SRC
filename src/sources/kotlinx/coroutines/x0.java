package kotlinx.coroutines;

import com.android.internal.os.PowerProfile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: EventLoop.common.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class x0 extends CoroutineDispatcher {

    /* renamed from: b, reason: collision with root package name */
    public long f51563b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f51564c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public kotlinx.coroutines.internal.a<o0<?>> f51565d;

    public static /* synthetic */ void E(x0 x0Var, boolean z10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incrementUseCount");
        }
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        x0Var.D(z10);
    }

    public final long A(boolean z10) {
        if (z10) {
            return PowerProfile.SUBSYSTEM_MODEM;
        }
        return 1L;
    }

    public final void B(@NotNull o0<?> o0Var) {
        kotlinx.coroutines.internal.a<o0<?>> aVar = this.f51565d;
        if (aVar == null) {
            aVar = new kotlinx.coroutines.internal.a<>();
            this.f51565d = aVar;
        }
        aVar.a(o0Var);
    }

    public long C() {
        kotlinx.coroutines.internal.a<o0<?>> aVar = this.f51565d;
        return (aVar == null || aVar.c()) ? Long.MAX_VALUE : 0L;
    }

    public final void D(boolean z10) {
        this.f51563b += A(z10);
        if (z10) {
            return;
        }
        this.f51564c = true;
    }

    public final boolean G() {
        return this.f51563b >= A(true);
    }

    public final boolean H() {
        kotlinx.coroutines.internal.a<o0<?>> aVar = this.f51565d;
        if (aVar != null) {
            return aVar.c();
        }
        return true;
    }

    public final boolean I() {
        o0<?> d10;
        kotlinx.coroutines.internal.a<o0<?>> aVar = this.f51565d;
        if (aVar == null || (d10 = aVar.d()) == null) {
            return false;
        }
        d10.run();
        return true;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    @NotNull
    public final CoroutineDispatcher limitedParallelism(int i10) {
        kotlinx.coroutines.internal.o.a(i10);
        return this;
    }

    public void shutdown() {
    }

    public final void x(boolean z10) {
        long A = this.f51563b - A(z10);
        this.f51563b = A;
        if (A <= 0 && this.f51564c) {
            shutdown();
        }
    }
}
