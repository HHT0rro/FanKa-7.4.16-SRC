package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlinx.coroutines.internal.c0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ConcurrentLinkedList.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class c0<S extends c0<S>> extends g<S> {

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f51375d = AtomicIntegerFieldUpdater.newUpdater(c0.class, "cleanedAndPointers");

    /* renamed from: c, reason: collision with root package name */
    public final long f51376c;

    @NotNull
    private volatile /* synthetic */ int cleanedAndPointers;

    public c0(long j10, @Nullable S s2, int i10) {
        super(s2);
        this.f51376c = j10;
        this.cleanedAndPointers = i10 << 16;
    }

    @Override // kotlinx.coroutines.internal.g
    public boolean g() {
        return this.cleanedAndPointers == n() && !i();
    }

    public final boolean l() {
        return f51375d.addAndGet(this, -65536) == n() && !i();
    }

    public final long m() {
        return this.f51376c;
    }

    public abstract int n();

    public final void o() {
        if (f51375d.incrementAndGet(this) != n() || i()) {
            return;
        }
        j();
    }

    public final boolean p() {
        int i10;
        do {
            i10 = this.cleanedAndPointers;
            if (!(i10 != n() || i())) {
                return false;
            }
        } while (!f51375d.compareAndSet(this, i10, 65536 + i10));
        return true;
    }
}
