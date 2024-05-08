package kotlinx.coroutines.debug.internal;

import java.io.Serializable;
import java.lang.Thread;
import java.util.List;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.f0;
import kotlinx.coroutines.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DebuggerInfo.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class DebuggerInfo implements Serializable {

    @Nullable
    private final Long coroutineId;

    @Nullable
    private final String dispatcher;

    @NotNull
    private final List<StackTraceElement> lastObservedStackTrace;

    @Nullable
    private final String lastObservedThreadName;

    @Nullable
    private final String lastObservedThreadState;

    @Nullable
    private final String name;
    private final long sequenceNumber;

    @NotNull
    private final String state;

    public DebuggerInfo(@NotNull c cVar, @NotNull CoroutineContext coroutineContext) {
        Thread.State state;
        f0 f0Var = (f0) coroutineContext.get(f0.f51233c);
        this.coroutineId = f0Var != null ? Long.valueOf(f0Var.x()) : null;
        kotlin.coroutines.c cVar2 = (kotlin.coroutines.c) coroutineContext.get(kotlin.coroutines.c.A0);
        this.dispatcher = cVar2 != null ? cVar2.toString() : null;
        g0 g0Var = (g0) coroutineContext.get(g0.f51348c);
        this.name = g0Var != null ? g0Var.x() : null;
        this.state = cVar.f();
        Thread thread = cVar.f51214b;
        this.lastObservedThreadState = (thread == null || (state = thread.getState()) == null) ? null : state.toString();
        Thread thread2 = cVar.f51214b;
        this.lastObservedThreadName = thread2 != null ? thread2.getName() : null;
        this.lastObservedStackTrace = cVar.g();
        this.sequenceNumber = cVar.f51213a;
    }

    @Nullable
    public final Long getCoroutineId() {
        return this.coroutineId;
    }

    @Nullable
    public final String getDispatcher() {
        return this.dispatcher;
    }

    @NotNull
    public final List<StackTraceElement> getLastObservedStackTrace() {
        return this.lastObservedStackTrace;
    }

    @Nullable
    public final String getLastObservedThreadName() {
        return this.lastObservedThreadName;
    }

    @Nullable
    public final String getLastObservedThreadState() {
        return this.lastObservedThreadState;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    public final long getSequenceNumber() {
        return this.sequenceNumber;
    }

    @NotNull
    public final String getState() {
        return this.state;
    }
}
