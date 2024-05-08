package p7;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.DuplicateTaskCompletionException;
import com.google.android.gms.tasks.RuntimeExecutionException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-tasks@@17.2.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class t<TResult> extends f<TResult> {

    /* renamed from: a, reason: collision with root package name */
    public final Object f52931a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public final p<TResult> f52932b = new p<>();

    /* renamed from: c, reason: collision with root package name */
    public boolean f52933c;

    /* renamed from: d, reason: collision with root package name */
    public volatile boolean f52934d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public TResult f52935e;

    /* renamed from: f, reason: collision with root package name */
    public Exception f52936f;

    @Override // p7.f
    @NonNull
    public final f<TResult> a(@NonNull Executor executor, @NonNull c cVar) {
        this.f52932b.b(new m(u.a(executor), cVar));
        r();
        return this;
    }

    @Override // p7.f
    @NonNull
    public final f<TResult> b(@NonNull c cVar) {
        return a(h.f52912a, cVar);
    }

    @Override // p7.f
    @NonNull
    public final f<TResult> c(@NonNull Executor executor, @NonNull d<? super TResult> dVar) {
        this.f52932b.b(new n(u.a(executor), dVar));
        r();
        return this;
    }

    @Override // p7.f
    @NonNull
    public final f<TResult> d(@NonNull d<? super TResult> dVar) {
        return c(h.f52912a, dVar);
    }

    @Override // p7.f
    @Nullable
    public final Exception e() {
        Exception exc;
        synchronized (this.f52931a) {
            exc = this.f52936f;
        }
        return exc;
    }

    @Override // p7.f
    public final TResult f() {
        TResult tresult;
        synchronized (this.f52931a) {
            m();
            q();
            if (this.f52936f == null) {
                tresult = this.f52935e;
            } else {
                throw new RuntimeExecutionException(this.f52936f);
            }
        }
        return tresult;
    }

    @Override // p7.f
    public final boolean g() {
        return this.f52934d;
    }

    @Override // p7.f
    public final boolean h() {
        boolean z10;
        synchronized (this.f52931a) {
            z10 = this.f52933c;
        }
        return z10;
    }

    @Override // p7.f
    public final boolean i() {
        boolean z10;
        synchronized (this.f52931a) {
            z10 = this.f52933c && !this.f52934d && this.f52936f == null;
        }
        return z10;
    }

    public final void j(@NonNull Exception exc) {
        com.google.android.gms.common.internal.h.i(exc, "Exception must not be null");
        synchronized (this.f52931a) {
            p();
            this.f52933c = true;
            this.f52936f = exc;
        }
        this.f52932b.a(this);
    }

    public final void k(@Nullable TResult tresult) {
        synchronized (this.f52931a) {
            p();
            this.f52933c = true;
            this.f52935e = tresult;
        }
        this.f52932b.a(this);
    }

    public final boolean l() {
        synchronized (this.f52931a) {
            if (this.f52933c) {
                return false;
            }
            this.f52933c = true;
            this.f52934d = true;
            this.f52932b.a(this);
            return true;
        }
    }

    public final void m() {
        com.google.android.gms.common.internal.h.k(this.f52933c, "Task is not yet complete");
    }

    public final boolean n(@NonNull Exception exc) {
        com.google.android.gms.common.internal.h.i(exc, "Exception must not be null");
        synchronized (this.f52931a) {
            if (this.f52933c) {
                return false;
            }
            this.f52933c = true;
            this.f52936f = exc;
            this.f52932b.a(this);
            return true;
        }
    }

    public final boolean o(@Nullable TResult tresult) {
        synchronized (this.f52931a) {
            if (this.f52933c) {
                return false;
            }
            this.f52933c = true;
            this.f52935e = tresult;
            this.f52932b.a(this);
            return true;
        }
    }

    public final void p() {
        if (this.f52933c) {
            throw DuplicateTaskCompletionException.of(this);
        }
    }

    public final void q() {
        if (this.f52934d) {
            throw new CancellationException("Task is already canceled.");
        }
    }

    public final void r() {
        synchronized (this.f52931a) {
            if (this.f52933c) {
                this.f52932b.a(this);
            }
        }
    }
}
