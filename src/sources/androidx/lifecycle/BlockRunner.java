package androidx.lifecycle;

import androidx.annotation.MainThread;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.s;
import kotlin.p;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.n1;
import kotlinx.coroutines.r0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CoroutineLiveData.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class BlockRunner<T> {

    @NotNull
    private final Function2<LiveDataScope<T>, Continuation<? super p>, Object> block;

    @Nullable
    private n1 cancellationJob;

    @NotNull
    private final CoroutineLiveData<T> liveData;

    @NotNull
    private final Function0<p> onDone;

    @Nullable
    private n1 runningJob;

    @NotNull
    private final h0 scope;
    private final long timeoutInMs;

    /* JADX WARN: Multi-variable type inference failed */
    public BlockRunner(@NotNull CoroutineLiveData<T> liveData, @NotNull Function2<? super LiveDataScope<T>, ? super Continuation<? super p>, ? extends Object> block, long j10, @NotNull h0 scope, @NotNull Function0<p> onDone) {
        s.i(liveData, "liveData");
        s.i(block, "block");
        s.i(scope, "scope");
        s.i(onDone, "onDone");
        this.liveData = liveData;
        this.block = block;
        this.timeoutInMs = j10;
        this.scope = scope;
        this.onDone = onDone;
    }

    @MainThread
    public final void cancel() {
        n1 b4;
        if (this.cancellationJob == null) {
            b4 = kotlinx.coroutines.h.b(this.scope, r0.c().x(), null, new BlockRunner$cancel$1(this, null), 2, null);
            this.cancellationJob = b4;
            return;
        }
        throw new IllegalStateException("Cancel call cannot happen without a maybeRun".toString());
    }

    @MainThread
    public final void maybeRun() {
        n1 b4;
        n1 n1Var = this.cancellationJob;
        if (n1Var != null) {
            n1.a.a(n1Var, null, 1, null);
        }
        this.cancellationJob = null;
        if (this.runningJob != null) {
            return;
        }
        b4 = kotlinx.coroutines.h.b(this.scope, null, null, new BlockRunner$maybeRun$1(this, null), 3, null);
        this.runningJob = b4;
    }
}
