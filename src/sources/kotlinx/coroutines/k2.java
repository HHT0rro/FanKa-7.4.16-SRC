package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Interruptible.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class k2 implements Function1<Throwable, kotlin.p> {

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f51431e = AtomicIntegerFieldUpdater.newUpdater(k2.class, "_state");

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final n1 f51432b;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public t0 f51434d;

    @NotNull
    private volatile /* synthetic */ int _state = 0;

    /* renamed from: c, reason: collision with root package name */
    public final Thread f51433c = Thread.currentThread();

    public k2(@NotNull n1 n1Var) {
        this.f51432b = n1Var;
    }

    public final void a() {
        while (true) {
            int i10 = this._state;
            if (i10 != 0) {
                if (i10 != 2) {
                    if (i10 == 3) {
                        Thread.interrupted();
                        return;
                    } else {
                        b(i10);
                        throw new KotlinNothingValueException();
                    }
                }
            } else if (f51431e.compareAndSet(this, i10, 1)) {
                t0 t0Var = this.f51434d;
                if (t0Var != null) {
                    t0Var.dispose();
                    return;
                }
                return;
            }
        }
    }

    public final Void b(int i10) {
        throw new IllegalStateException(("Illegal state " + i10).toString());
    }

    public void c(@Nullable Throwable th) {
        int i10;
        do {
            i10 = this._state;
            if (i10 != 0) {
                if (i10 == 1 || i10 == 2 || i10 == 3) {
                    return;
                }
                b(i10);
                throw new KotlinNothingValueException();
            }
        } while (!f51431e.compareAndSet(this, i10, 2));
        this.f51433c.interrupt();
        this._state = 3;
    }

    public final void d() {
        int i10;
        this.f51434d = this.f51432b.u(true, true, this);
        do {
            i10 = this._state;
            if (i10 != 0) {
                if (i10 == 2 || i10 == 3) {
                    return;
                }
                b(i10);
                throw new KotlinNothingValueException();
            }
        } while (!f51431e.compareAndSet(this, i10, 0));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ kotlin.p invoke(Throwable th) {
        c(th);
        return kotlin.p.f51048a;
    }
}
