package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Builders.common.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class n0<T> extends kotlinx.coroutines.internal.b0<T> {

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f51448e = AtomicIntegerFieldUpdater.newUpdater(n0.class, "_decision");

    @NotNull
    private volatile /* synthetic */ int _decision;

    public n0(@NotNull CoroutineContext coroutineContext, @NotNull Continuation<? super T> continuation) {
        super(coroutineContext, continuation);
        this._decision = 0;
    }

    @Override // kotlinx.coroutines.internal.b0, kotlinx.coroutines.a
    public void I0(@Nullable Object obj) {
        if (O0()) {
            return;
        }
        kotlinx.coroutines.internal.j.c(IntrinsicsKt__IntrinsicsJvmKt.c(this.f51372d), a0.a(obj, this.f51372d), null, 2, null);
    }

    @Override // kotlinx.coroutines.internal.b0, kotlinx.coroutines.u1
    public void K(@Nullable Object obj) {
        I0(obj);
    }

    @Nullable
    public final Object N0() {
        if (P0()) {
            return sd.a.d();
        }
        Object h10 = v1.h(d0());
        if (h10 instanceof x) {
            throw ((x) h10).f51562a;
        }
        return h10;
    }

    public final boolean O0() {
        do {
            int i10 = this._decision;
            if (i10 != 0) {
                if (i10 == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!f51448e.compareAndSet(this, 0, 2));
        return true;
    }

    public final boolean P0() {
        do {
            int i10 = this._decision;
            if (i10 != 0) {
                if (i10 == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended".toString());
            }
        } while (!f51448e.compareAndSet(this, 0, 1));
        return true;
    }
}
