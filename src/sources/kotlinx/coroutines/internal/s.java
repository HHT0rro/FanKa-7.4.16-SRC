package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LockFreeTaskQueue.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class s<E> {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f51409a = AtomicReferenceFieldUpdater.newUpdater(s.class, Object.class, "_cur");

    @NotNull
    private volatile /* synthetic */ Object _cur;

    public s(boolean z10) {
        this._cur = new t(8, z10);
    }

    public final boolean a(@NotNull E e2) {
        while (true) {
            t tVar = (t) this._cur;
            int a10 = tVar.a(e2);
            if (a10 == 0) {
                return true;
            }
            if (a10 == 1) {
                androidx.concurrent.futures.a.a(f51409a, this, tVar, tVar.i());
            } else if (a10 == 2) {
                return false;
            }
        }
    }

    public final void b() {
        while (true) {
            t tVar = (t) this._cur;
            if (tVar.d()) {
                return;
            } else {
                androidx.concurrent.futures.a.a(f51409a, this, tVar, tVar.i());
            }
        }
    }

    public final int c() {
        return ((t) this._cur).f();
    }

    @Nullable
    public final E d() {
        while (true) {
            t tVar = (t) this._cur;
            E e2 = (E) tVar.j();
            if (e2 != t.f51413h) {
                return e2;
            }
            androidx.concurrent.futures.a.a(f51409a, this, tVar, tVar.i());
        }
    }
}
