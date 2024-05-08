package okhttp3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.t;
import kotlin.d;
import kotlin.jvm.internal.s;
import kotlin.p;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealCall;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Dispatcher.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class Dispatcher {
    private ExecutorService executorServiceOrNull;

    @Nullable
    private Runnable idleCallback;
    private int maxRequests;
    private int maxRequestsPerHost;
    private final ArrayDeque<RealCall.AsyncCall> readyAsyncCalls;
    private final ArrayDeque<RealCall.AsyncCall> runningAsyncCalls;
    private final ArrayDeque<RealCall> runningSyncCalls;

    public Dispatcher() {
        this.maxRequests = 64;
        this.maxRequestsPerHost = 5;
        this.readyAsyncCalls = new ArrayDeque<>();
        this.runningAsyncCalls = new ArrayDeque<>();
        this.runningSyncCalls = new ArrayDeque<>();
    }

    private final RealCall.AsyncCall findExistingCallWithHost(String str) {
        Iterator<RealCall.AsyncCall> iterator2 = this.runningAsyncCalls.iterator2();
        while (iterator2.hasNext()) {
            RealCall.AsyncCall next = iterator2.next();
            if (s.d(next.getHost(), str)) {
                return next;
            }
        }
        Iterator<RealCall.AsyncCall> iterator22 = this.readyAsyncCalls.iterator2();
        while (iterator22.hasNext()) {
            RealCall.AsyncCall next2 = iterator22.next();
            if (s.d(next2.getHost(), str)) {
                return next2;
            }
        }
        return null;
    }

    private final <T> void finished(Deque<T> deque, T t2) {
        Runnable runnable;
        synchronized (this) {
            if (deque.remove(t2)) {
                runnable = this.idleCallback;
                p pVar = p.f51048a;
            } else {
                throw new AssertionError((Object) "Call wasn't in-flight!");
            }
        }
        if (promoteAndExecute() || runnable == null) {
            return;
        }
        runnable.run();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean promoteAndExecute() {
        int i10;
        boolean z10;
        if (Util.assertionsEnabled && Thread.holdsLock(this)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Thread ");
            Thread currentThread = Thread.currentThread();
            s.h(currentThread, "Thread.currentThread()");
            sb2.append(currentThread.getName());
            sb2.append(" MUST NOT hold lock on ");
            sb2.append((Object) this);
            throw new AssertionError((Object) sb2.toString());
        }
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            Iterator<RealCall.AsyncCall> iterator2 = this.readyAsyncCalls.iterator2();
            s.h(iterator2, "readyAsyncCalls.iterator()");
            while (iterator2.hasNext()) {
                RealCall.AsyncCall asyncCall = iterator2.next();
                if (this.runningAsyncCalls.size() >= this.maxRequests) {
                    break;
                }
                if (asyncCall.getCallsPerHost().get() < this.maxRequestsPerHost) {
                    iterator2.remove();
                    asyncCall.getCallsPerHost().incrementAndGet();
                    s.h(asyncCall, "asyncCall");
                    arrayList.add(asyncCall);
                    this.runningAsyncCalls.add(asyncCall);
                }
            }
            z10 = runningCallsCount() > 0;
            p pVar = p.f51048a;
        }
        int size = arrayList.size();
        for (i10 = 0; i10 < size; i10++) {
            ((RealCall.AsyncCall) arrayList.get(i10)).executeOn(executorService());
        }
        return z10;
    }

    @NotNull
    /* renamed from: -deprecated_executorService, reason: not valid java name */
    public final ExecutorService m3632deprecated_executorService() {
        return executorService();
    }

    public final synchronized void cancelAll() {
        Iterator<RealCall.AsyncCall> iterator2 = this.readyAsyncCalls.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().getCall().cancel();
        }
        Iterator<RealCall.AsyncCall> iterator22 = this.runningAsyncCalls.iterator2();
        while (iterator22.hasNext()) {
            iterator22.next().getCall().cancel();
        }
        Iterator<RealCall> iterator23 = this.runningSyncCalls.iterator2();
        while (iterator23.hasNext()) {
            iterator23.next().cancel();
        }
    }

    public final void enqueue$okhttp(@NotNull RealCall.AsyncCall call) {
        RealCall.AsyncCall findExistingCallWithHost;
        s.i(call, "call");
        synchronized (this) {
            this.readyAsyncCalls.add(call);
            if (!call.getCall().getForWebSocket() && (findExistingCallWithHost = findExistingCallWithHost(call.getHost())) != null) {
                call.reuseCallsPerHostFrom(findExistingCallWithHost);
            }
            p pVar = p.f51048a;
        }
        promoteAndExecute();
    }

    public final synchronized void executed$okhttp(@NotNull RealCall call) {
        s.i(call, "call");
        this.runningSyncCalls.add(call);
    }

    @NotNull
    public final synchronized ExecutorService executorService() {
        ExecutorService executorService;
        if (this.executorServiceOrNull == null) {
            this.executorServiceOrNull = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory(Util.okHttpName + " Dispatcher", false));
        }
        executorService = this.executorServiceOrNull;
        s.f(executorService);
        return executorService;
    }

    public final void finished$okhttp(@NotNull RealCall.AsyncCall call) {
        s.i(call, "call");
        call.getCallsPerHost().decrementAndGet();
        finished(this.runningAsyncCalls, call);
    }

    @Nullable
    public final synchronized Runnable getIdleCallback() {
        return this.idleCallback;
    }

    public final synchronized int getMaxRequests() {
        return this.maxRequests;
    }

    public final synchronized int getMaxRequestsPerHost() {
        return this.maxRequestsPerHost;
    }

    @NotNull
    public final synchronized List<Call> queuedCalls() {
        List<Call> unmodifiableList;
        ArrayDeque<RealCall.AsyncCall> arrayDeque = this.readyAsyncCalls;
        ArrayList arrayList = new ArrayList(t.t(arrayDeque, 10));
        Iterator<RealCall.AsyncCall> iterator2 = arrayDeque.iterator2();
        while (iterator2.hasNext()) {
            arrayList.add(iterator2.next().getCall());
        }
        unmodifiableList = Collections.unmodifiableList(arrayList);
        s.h(unmodifiableList, "Collections.unmodifiable…yncCalls.map { it.call })");
        return unmodifiableList;
    }

    public final synchronized int queuedCallsCount() {
        return this.readyAsyncCalls.size();
    }

    @NotNull
    public final synchronized List<Call> runningCalls() {
        List<Call> unmodifiableList;
        ArrayDeque<RealCall> arrayDeque = this.runningSyncCalls;
        ArrayDeque<RealCall.AsyncCall> arrayDeque2 = this.runningAsyncCalls;
        ArrayList arrayList = new ArrayList(t.t(arrayDeque2, 10));
        Iterator<RealCall.AsyncCall> iterator2 = arrayDeque2.iterator2();
        while (iterator2.hasNext()) {
            arrayList.add(iterator2.next().getCall());
        }
        unmodifiableList = Collections.unmodifiableList(CollectionsKt___CollectionsKt.k0(arrayDeque, arrayList));
        s.h(unmodifiableList, "Collections.unmodifiable…yncCalls.map { it.call })");
        return unmodifiableList;
    }

    public final synchronized int runningCallsCount() {
        return this.runningAsyncCalls.size() + this.runningSyncCalls.size();
    }

    public final synchronized void setIdleCallback(@Nullable Runnable runnable) {
        this.idleCallback = runnable;
    }

    public final void setMaxRequests(int i10) {
        if (i10 >= 1) {
            synchronized (this) {
                this.maxRequests = i10;
                p pVar = p.f51048a;
            }
            promoteAndExecute();
            return;
        }
        throw new IllegalArgumentException(("max < 1: " + i10).toString());
    }

    public final void setMaxRequestsPerHost(int i10) {
        if (i10 >= 1) {
            synchronized (this) {
                this.maxRequestsPerHost = i10;
                p pVar = p.f51048a;
            }
            promoteAndExecute();
            return;
        }
        throw new IllegalArgumentException(("max < 1: " + i10).toString());
    }

    public final void finished$okhttp(@NotNull RealCall call) {
        s.i(call, "call");
        finished(this.runningSyncCalls, call);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Dispatcher(@NotNull ExecutorService executorService) {
        this();
        s.i(executorService, "executorService");
        this.executorServiceOrNull = executorService;
    }
}
