package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.internal.g;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ConcurrentLinkedList.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class g<N extends g<N>> {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f51383a = AtomicReferenceFieldUpdater.newUpdater(g.class, Object.class, "_next");

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f51384b = AtomicReferenceFieldUpdater.newUpdater(g.class, Object.class, "_prev");

    @NotNull
    private volatile /* synthetic */ Object _next = null;

    @NotNull
    private volatile /* synthetic */ Object _prev;

    public g(@Nullable N n10) {
        this._prev = n10;
    }

    public final void b() {
        f51384b.lazySet(this, null);
    }

    public final N c() {
        N f10 = f();
        while (f10 != null && f10.g()) {
            f10 = (N) f10._prev;
        }
        return f10;
    }

    @Nullable
    public final N d() {
        f0 f0Var;
        Object e2 = e();
        f0Var = f.f51381a;
        if (e2 == f0Var) {
            return null;
        }
        return (N) e2;
    }

    public final Object e() {
        return this._next;
    }

    @Nullable
    public final N f() {
        return (N) this._prev;
    }

    public abstract boolean g();

    public final N h() {
        N d10 = d();
        kotlin.jvm.internal.s.f(d10);
        while (d10.g()) {
            d10 = (N) d10.d();
            kotlin.jvm.internal.s.f(d10);
        }
        return d10;
    }

    public final boolean i() {
        return d() == null;
    }

    public final void j() {
        while (true) {
            N c4 = c();
            N h10 = h();
            h10._prev = c4;
            if (c4 != null) {
                c4._next = h10;
            }
            if (!h10.g() && (c4 == null || !c4.g())) {
                return;
            }
        }
    }

    public final boolean k(@NotNull N n10) {
        return androidx.concurrent.futures.a.a(f51383a, this, null, n10);
    }
}
