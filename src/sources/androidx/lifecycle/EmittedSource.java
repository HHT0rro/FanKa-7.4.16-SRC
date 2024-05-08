package androidx.lifecycle;

import androidx.annotation.MainThread;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.s;
import kotlin.p;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.r0;
import kotlinx.coroutines.t0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CoroutineLiveData.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class EmittedSource implements t0 {
    private boolean disposed;

    @NotNull
    private final MediatorLiveData<?> mediator;

    @NotNull
    private final LiveData<?> source;

    public EmittedSource(@NotNull LiveData<?> source, @NotNull MediatorLiveData<?> mediator) {
        s.i(source, "source");
        s.i(mediator, "mediator");
        this.source = source;
        this.mediator = mediator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    public final void removeSource() {
        if (this.disposed) {
            return;
        }
        this.mediator.removeSource(this.source);
        this.disposed = true;
    }

    @Override // kotlinx.coroutines.t0
    public void dispose() {
        kotlinx.coroutines.h.b(i0.a(r0.c().x()), null, null, new EmittedSource$dispose$1(this, null), 3, null);
    }

    @Nullable
    public final Object disposeNow(@NotNull Continuation<? super p> continuation) {
        Object c4 = kotlinx.coroutines.g.c(r0.c().x(), new EmittedSource$disposeNow$2(this, null), continuation);
        return c4 == sd.a.d() ? c4 : p.f51048a;
    }
}
