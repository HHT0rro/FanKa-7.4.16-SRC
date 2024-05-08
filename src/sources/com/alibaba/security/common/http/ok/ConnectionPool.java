package com.alibaba.security.common.http.ok;

import com.alibaba.security.common.http.ok.internal.Util;
import com.alibaba.security.common.http.ok.internal.connection.RealConnection;
import com.alibaba.security.common.http.ok.internal.connection.RouteDatabase;
import com.alibaba.security.common.http.ok.internal.connection.StreamAllocation;
import com.alibaba.security.common.http.ok.internal.platform.Platform;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ConnectionPool {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Executor executor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp ConnectionPool", true));
    private final Runnable cleanupRunnable;
    public boolean cleanupRunning;
    private final Deque<RealConnection> connections;
    private final long keepAliveDurationNs;
    private final int maxIdleConnections;
    public final RouteDatabase routeDatabase;

    public ConnectionPool() {
        this(5, 5L, TimeUnit.MINUTES);
    }

    private int pruneAndGetAllocationCount(RealConnection realConnection, long j10) {
        List<Reference<StreamAllocation>> list = realConnection.allocations;
        int i10 = 0;
        while (i10 < list.size()) {
            Reference<StreamAllocation> reference = list.get(i10);
            if (reference.get() != null) {
                i10++;
            } else {
                Platform.get().logCloseableLeak("A connection to " + ((Object) realConnection.route().address().url()) + " was leaked. Did you forget to close a response body?", ((StreamAllocation.StreamAllocationReference) reference).callStackTrace);
                list.remove(i10);
                realConnection.noNewStreams = true;
                if (list.isEmpty()) {
                    realConnection.idleAtNanos = j10 - this.keepAliveDurationNs;
                    return 0;
                }
            }
        }
        return list.size();
    }

    public long cleanup(long j10) {
        synchronized (this) {
            RealConnection realConnection = null;
            long j11 = Long.MIN_VALUE;
            int i10 = 0;
            int i11 = 0;
            for (RealConnection realConnection2 : this.connections) {
                if (pruneAndGetAllocationCount(realConnection2, j10) > 0) {
                    i11++;
                } else {
                    i10++;
                    long j12 = j10 - realConnection2.idleAtNanos;
                    if (j12 > j11) {
                        realConnection = realConnection2;
                        j11 = j12;
                    }
                }
            }
            long j13 = this.keepAliveDurationNs;
            if (j11 < j13 && i10 <= this.maxIdleConnections) {
                if (i10 > 0) {
                    return j13 - j11;
                }
                if (i11 > 0) {
                    return j13;
                }
                this.cleanupRunning = false;
                return -1L;
            }
            this.connections.remove(realConnection);
            Util.closeQuietly(realConnection.socket());
            return 0L;
        }
    }

    public boolean connectionBecameIdle(RealConnection realConnection) {
        if (!realConnection.noNewStreams && this.maxIdleConnections != 0) {
            notifyAll();
            return false;
        }
        this.connections.remove(realConnection);
        return true;
    }

    public synchronized int connectionCount() {
        return this.connections.size();
    }

    public Socket deduplicate(Address address, StreamAllocation streamAllocation) {
        for (RealConnection realConnection : this.connections) {
            if (realConnection.isEligible(address, null) && realConnection.isMultiplexed() && realConnection != streamAllocation.connection()) {
                return streamAllocation.releaseAndAcquire(realConnection);
            }
        }
        return null;
    }

    public void evictAll() {
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            Iterator<RealConnection> iterator2 = this.connections.iterator2();
            while (iterator2.hasNext()) {
                RealConnection next = iterator2.next();
                if (next.allocations.isEmpty()) {
                    next.noNewStreams = true;
                    arrayList.add(next);
                    iterator2.remove();
                }
            }
        }
        Iterator<E> iterator22 = arrayList.iterator2();
        while (iterator22.hasNext()) {
            Util.closeQuietly(((RealConnection) iterator22.next()).socket());
        }
    }

    public RealConnection get(Address address, StreamAllocation streamAllocation, Route route) {
        for (RealConnection realConnection : this.connections) {
            if (realConnection.isEligible(address, route)) {
                streamAllocation.acquire(realConnection, true);
                return realConnection;
            }
        }
        return null;
    }

    public synchronized int idleConnectionCount() {
        int i10;
        i10 = 0;
        Iterator<RealConnection> iterator2 = this.connections.iterator2();
        while (iterator2.hasNext()) {
            if (iterator2.next().allocations.isEmpty()) {
                i10++;
            }
        }
        return i10;
    }

    public void put(RealConnection realConnection) {
        if (!this.cleanupRunning) {
            this.cleanupRunning = true;
            executor.execute(this.cleanupRunnable);
        }
        this.connections.add(realConnection);
    }

    public ConnectionPool(int i10, long j10, TimeUnit timeUnit) {
        this.cleanupRunnable = new Runnable() { // from class: com.alibaba.security.common.http.ok.ConnectionPool.1
            @Override // java.lang.Runnable
            public void run() {
                while (true) {
                    long cleanup = ConnectionPool.this.cleanup(System.nanoTime());
                    if (cleanup == -1) {
                        return;
                    }
                    if (cleanup > 0) {
                        long j11 = cleanup / 1000000;
                        long j12 = cleanup - (1000000 * j11);
                        synchronized (ConnectionPool.this) {
                            try {
                                ConnectionPool.this.wait(j11, (int) j12);
                            } catch (InterruptedException unused) {
                            }
                        }
                    }
                }
            }
        };
        this.connections = new ArrayDeque();
        this.routeDatabase = new RouteDatabase();
        this.maxIdleConnections = i10;
        this.keepAliveDurationNs = timeUnit.toNanos(j10);
        if (j10 > 0) {
            return;
        }
        throw new IllegalArgumentException("keepAliveDuration <= 0: " + j10);
    }
}
