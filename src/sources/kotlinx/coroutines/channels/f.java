package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.JobCancellationException;
import kotlinx.coroutines.u1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ChannelCoroutine.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class f<E> extends kotlinx.coroutines.a<kotlin.p> implements e<E> {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public final e<E> f51173d;

    public f(@NotNull CoroutineContext coroutineContext, @NotNull e<E> eVar, boolean z10, boolean z11) {
        super(coroutineContext, z10, z11);
        this.f51173d = eVar;
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @NotNull
    public kotlinx.coroutines.selects.d<E> A() {
        return this.f51173d.A();
    }

    @Override // kotlinx.coroutines.channels.r
    public boolean D(@Nullable Throwable th) {
        return this.f51173d.D(th);
    }

    @Override // kotlinx.coroutines.channels.r
    @Nullable
    public Object E(E e2, @NotNull Continuation<? super kotlin.p> continuation) {
        return this.f51173d.E(e2, continuation);
    }

    @NotNull
    public final e<E> M0() {
        return this;
    }

    @Override // kotlinx.coroutines.u1
    public void N(@NotNull Throwable th) {
        CancellationException B0 = u1.B0(this, th, null, 1, null);
        this.f51173d.a(B0);
        L(B0);
    }

    @NotNull
    public final e<E> N0() {
        return this.f51173d;
    }

    @Override // kotlinx.coroutines.u1, kotlinx.coroutines.n1, kotlinx.coroutines.channels.ReceiveChannel
    public final void a(@Nullable CancellationException cancellationException) {
        if (isCancelled()) {
            return;
        }
        if (cancellationException == null) {
            cancellationException = new JobCancellationException(Q(), null, this);
        }
        N(cancellationException);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @NotNull
    public ChannelIterator<E> iterator() {
        return this.f51173d.iterator();
    }

    @Override // kotlinx.coroutines.channels.r
    public void k(@NotNull Function1<? super Throwable, kotlin.p> function1) {
        this.f51173d.k(function1);
    }

    @Override // kotlinx.coroutines.channels.r
    @NotNull
    public Object l(E e2) {
        return this.f51173d.l(e2);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @NotNull
    public kotlinx.coroutines.selects.d<ChannelResult<E>> n() {
        return this.f51173d.n();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @NotNull
    public Object o() {
        return this.f51173d.o();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @Nullable
    public Object p(@NotNull Continuation<? super ChannelResult<? extends E>> continuation) {
        Object p10 = this.f51173d.p(continuation);
        sd.a.d();
        return p10;
    }

    @Override // kotlinx.coroutines.channels.r
    public boolean q() {
        return this.f51173d.q();
    }
}
