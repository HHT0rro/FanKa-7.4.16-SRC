package kotlinx.coroutines.android;

import android.os.Handler;
import android.os.Looper;
import ce.n;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import kotlinx.coroutines.l;
import kotlinx.coroutines.q1;
import kotlinx.coroutines.r0;
import kotlinx.coroutines.t0;
import kotlinx.coroutines.z1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: HandlerDispatcher.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class HandlerContext extends d {

    @Nullable
    private volatile HandlerContext _immediate;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final Handler f51123b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public final String f51124c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f51125d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public final HandlerContext f51126e;

    /* compiled from: Runnable.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ l f51127b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ HandlerContext f51128c;

        public a(l lVar, HandlerContext handlerContext) {
            this.f51127b = lVar;
            this.f51128c = handlerContext;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f51127b.C(this.f51128c, p.f51048a);
        }
    }

    public HandlerContext(Handler handler, String str, boolean z10) {
        super(null);
        this.f51123b = handler;
        this.f51124c = str;
        this.f51125d = z10;
        this._immediate = z10 ? this : null;
        HandlerContext handlerContext = this._immediate;
        if (handlerContext == null) {
            handlerContext = new HandlerContext(handler, str, true);
            this._immediate = handlerContext;
        }
        this.f51126e = handlerContext;
    }

    public static final void G(HandlerContext handlerContext, Runnable runnable) {
        handlerContext.f51123b.removeCallbacks(runnable);
    }

    public final void D(CoroutineContext coroutineContext, Runnable runnable) {
        q1.c(coroutineContext, new CancellationException("The task was rejected, the handler underlying the dispatcher '" + ((Object) this) + "' was closed"));
        r0.b().dispatch(coroutineContext, runnable);
    }

    @Override // kotlinx.coroutines.x1
    @NotNull
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public HandlerContext x() {
        return this.f51126e;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
        if (this.f51123b.post(runnable)) {
            return;
        }
        D(coroutineContext, runnable);
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof HandlerContext) && ((HandlerContext) obj).f51123b == this.f51123b;
    }

    public int hashCode() {
        return System.identityHashCode(this.f51123b);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public boolean isDispatchNeeded(@NotNull CoroutineContext coroutineContext) {
        return (this.f51125d && s.d(Looper.myLooper(), this.f51123b.getLooper())) ? false : true;
    }

    @Override // kotlinx.coroutines.m0
    public void k(long j10, @NotNull l<? super p> lVar) {
        final a aVar = new a(lVar, this);
        if (this.f51123b.postDelayed(aVar, n.e(j10, 4611686018427387903L))) {
            lVar.v(new Function1<Throwable, p>() { // from class: kotlinx.coroutines.android.HandlerContext$scheduleResumeAfterDelay$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(Throwable th) {
                    invoke2(th);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable Throwable th) {
                    Handler handler;
                    handler = HandlerContext.this.f51123b;
                    handler.removeCallbacks(aVar);
                }
            });
        } else {
            D(lVar.getContext(), aVar);
        }
    }

    @Override // kotlinx.coroutines.android.d, kotlinx.coroutines.m0
    @NotNull
    public t0 l(long j10, @NotNull final Runnable runnable, @NotNull CoroutineContext coroutineContext) {
        if (this.f51123b.postDelayed(runnable, n.e(j10, 4611686018427387903L))) {
            return new t0() { // from class: kotlinx.coroutines.android.c
                @Override // kotlinx.coroutines.t0
                public final void dispose() {
                    HandlerContext.G(HandlerContext.this, runnable);
                }
            };
        }
        D(coroutineContext, runnable);
        return z1.f51576b;
    }

    @Override // kotlinx.coroutines.x1, kotlinx.coroutines.CoroutineDispatcher
    @NotNull
    public String toString() {
        String A = A();
        if (A != null) {
            return A;
        }
        String str = this.f51124c;
        if (str == null) {
            str = this.f51123b.toString();
        }
        if (!this.f51125d) {
            return str;
        }
        return str + ".immediate";
    }

    public /* synthetic */ HandlerContext(Handler handler, String str, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(handler, (i10 & 2) != 0 ? null : str);
    }

    public HandlerContext(@NotNull Handler handler, @Nullable String str) {
        this(handler, str, false);
    }
}
