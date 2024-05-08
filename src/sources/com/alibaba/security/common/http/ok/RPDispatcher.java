package com.alibaba.security.common.http.ok;

import com.alibaba.security.common.http.ok.RealCall;
import com.alibaba.security.common.http.ok.internal.Util;
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

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class RPDispatcher {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    private ExecutorService executorService;
    private Runnable idleCallback;
    private int maxRequests = 64;
    private int maxRequestsPerHost = 5;
    private final Deque<RealCall.AsyncCall> readyAsyncCalls = new ArrayDeque();
    private final Deque<RealCall.AsyncCall> runningAsyncCalls = new ArrayDeque();
    private final Deque<RealCall> runningSyncCalls = new ArrayDeque();

    public RPDispatcher(ExecutorService executorService) {
        this.executorService = executorService;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean promoteAndExecute() {
        int i10;
        boolean z10;
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            Iterator<RealCall.AsyncCall> iterator2 = this.readyAsyncCalls.iterator2();
            while (iterator2.hasNext()) {
                RealCall.AsyncCall next = iterator2.next();
                if (this.runningAsyncCalls.size() >= this.maxRequests) {
                    break;
                }
                if (runningCallsForHost(next) < this.maxRequestsPerHost) {
                    iterator2.remove();
                    arrayList.add(next);
                    this.runningAsyncCalls.add(next);
                }
            }
            z10 = runningCallsCount() > 0;
        }
        int size = arrayList.size();
        for (i10 = 0; i10 < size; i10++) {
            ((RealCall.AsyncCall) arrayList.get(i10)).executeOn(executorService());
        }
        return z10;
    }

    private int runningCallsForHost(RealCall.AsyncCall asyncCall) {
        int i10 = 0;
        for (RealCall.AsyncCall asyncCall2 : this.runningAsyncCalls) {
            if (!asyncCall2.get().forWebSocket && asyncCall2.host().equals(asyncCall.host())) {
                i10++;
            }
        }
        return i10;
    }

    public synchronized void cancelAll() {
        Iterator<RealCall.AsyncCall> iterator2 = this.readyAsyncCalls.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().get().cancel();
        }
        Iterator<RealCall.AsyncCall> iterator22 = this.runningAsyncCalls.iterator2();
        while (iterator22.hasNext()) {
            iterator22.next().get().cancel();
        }
        Iterator<RealCall> iterator23 = this.runningSyncCalls.iterator2();
        while (iterator23.hasNext()) {
            iterator23.next().cancel();
        }
    }

    public void enqueue(RealCall.AsyncCall asyncCall) {
        synchronized (this) {
            this.readyAsyncCalls.add(asyncCall);
        }
        promoteAndExecute();
    }

    public synchronized void executed(RealCall realCall) {
        this.runningSyncCalls.add(realCall);
    }

    public synchronized ExecutorService executorService() {
        if (this.executorService == null) {
            this.executorService = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp Dispatcher", false));
        }
        return this.executorService;
    }

    public void finished(RealCall.AsyncCall asyncCall) {
        finished(this.runningAsyncCalls, asyncCall);
    }

    public synchronized int getMaxRequests() {
        return this.maxRequests;
    }

    public synchronized int getMaxRequestsPerHost() {
        return this.maxRequestsPerHost;
    }

    public synchronized List<RPCall> queuedCalls() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<RealCall.AsyncCall> iterator2 = this.readyAsyncCalls.iterator2();
        while (iterator2.hasNext()) {
            arrayList.add(iterator2.next().get());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public synchronized int queuedCallsCount() {
        return this.readyAsyncCalls.size();
    }

    public synchronized List<RPCall> runningCalls() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        arrayList.addAll(this.runningSyncCalls);
        Iterator<RealCall.AsyncCall> iterator2 = this.runningAsyncCalls.iterator2();
        while (iterator2.hasNext()) {
            arrayList.add(iterator2.next().get());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public synchronized int runningCallsCount() {
        return this.runningAsyncCalls.size() + this.runningSyncCalls.size();
    }

    public synchronized void setIdleCallback(Runnable runnable) {
        this.idleCallback = runnable;
    }

    public void setMaxRequests(int i10) {
        if (i10 >= 1) {
            synchronized (this) {
                this.maxRequests = i10;
            }
            promoteAndExecute();
        } else {
            throw new IllegalArgumentException("max < 1: " + i10);
        }
    }

    public void setMaxRequestsPerHost(int i10) {
        if (i10 >= 1) {
            synchronized (this) {
                this.maxRequestsPerHost = i10;
            }
            promoteAndExecute();
        } else {
            throw new IllegalArgumentException("max < 1: " + i10);
        }
    }

    public void finished(RealCall realCall) {
        finished(this.runningSyncCalls, realCall);
    }

    private <T> void finished(Deque<T> deque, T t2) {
        Runnable runnable;
        synchronized (this) {
            if (deque.remove(t2)) {
                runnable = this.idleCallback;
            } else {
                throw new AssertionError((Object) "Call wasn't in-flight!");
            }
        }
        if (promoteAndExecute() || runnable == null) {
            return;
        }
        runnable.run();
    }

    public RPDispatcher() {
    }
}
