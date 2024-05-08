package com.tencent.cloud.huiyansdkface.okhttp3;

import com.tencent.cloud.huiyansdkface.okhttp3.internal.Util;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.connection.RealConnection;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.connection.RouteDatabase;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.connection.StreamAllocation;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.platform.Platform;
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

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class ConnectionPool {

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ boolean f41343c = true;

    /* renamed from: d, reason: collision with root package name */
    private static final Executor f41344d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp ConnectionPool", true));

    /* renamed from: a, reason: collision with root package name */
    public final RouteDatabase f41345a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f41346b;

    /* renamed from: e, reason: collision with root package name */
    private final int f41347e;

    /* renamed from: f, reason: collision with root package name */
    private final long f41348f;

    /* renamed from: g, reason: collision with root package name */
    private final Runnable f41349g;

    /* renamed from: h, reason: collision with root package name */
    private final Deque<RealConnection> f41350h;

    public ConnectionPool() {
        this(5, 5L, TimeUnit.MINUTES);
    }

    public ConnectionPool(int i10, long j10, TimeUnit timeUnit) {
        this.f41349g = new Runnable() { // from class: com.tencent.cloud.huiyansdkface.okhttp3.ConnectionPool.1
            @Override // java.lang.Runnable
            public void run() {
                while (true) {
                    long a10 = ConnectionPool.this.a(System.nanoTime());
                    if (a10 == -1) {
                        return;
                    }
                    if (a10 > 0) {
                        long j11 = a10 / 1000000;
                        long j12 = a10 - (1000000 * j11);
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
        this.f41350h = new ArrayDeque();
        this.f41345a = new RouteDatabase();
        this.f41347e = i10;
        this.f41348f = timeUnit.toNanos(j10);
        if (j10 > 0) {
            return;
        }
        throw new IllegalArgumentException("keepAliveDuration <= 0: " + j10);
    }

    private int a(RealConnection realConnection, long j10) {
        List<Reference<StreamAllocation>> list = realConnection.f41714d;
        int i10 = 0;
        while (i10 < list.size()) {
            Reference<StreamAllocation> reference = list.get(i10);
            if (reference.get() != null) {
                i10++;
            } else {
                Platform.get().logCloseableLeak("A connection to " + ((Object) realConnection.route().address().url()) + " was leaked. Did you forget to close a response body?", ((StreamAllocation.StreamAllocationReference) reference).f41755a);
                list.remove(i10);
                realConnection.f41711a = true;
                if (list.isEmpty()) {
                    realConnection.f41715e = j10 - this.f41348f;
                    return 0;
                }
            }
        }
        return list.size();
    }

    public long a(long j10) {
        synchronized (this) {
            RealConnection realConnection = null;
            long j11 = Long.MIN_VALUE;
            int i10 = 0;
            int i11 = 0;
            for (RealConnection realConnection2 : this.f41350h) {
                if (a(realConnection2, j10) > 0) {
                    i11++;
                } else {
                    i10++;
                    long j12 = j10 - realConnection2.f41715e;
                    if (j12 > j11) {
                        realConnection = realConnection2;
                        j11 = j12;
                    }
                }
            }
            long j13 = this.f41348f;
            if (j11 < j13 && i10 <= this.f41347e) {
                if (i10 > 0) {
                    return j13 - j11;
                }
                if (i11 > 0) {
                    return j13;
                }
                this.f41346b = false;
                return -1L;
            }
            this.f41350h.remove(realConnection);
            Util.closeQuietly(realConnection.socket());
            return 0L;
        }
    }

    public RealConnection a(Address address, StreamAllocation streamAllocation, Route route) {
        if (!f41343c && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        for (RealConnection realConnection : this.f41350h) {
            if (realConnection.isEligible(address, route)) {
                streamAllocation.acquire(realConnection, true);
                return realConnection;
            }
        }
        return null;
    }

    public Socket a(Address address, StreamAllocation streamAllocation) {
        if (!f41343c && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        for (RealConnection realConnection : this.f41350h) {
            if (realConnection.isEligible(address, null) && realConnection.isMultiplexed() && realConnection != streamAllocation.connection()) {
                return streamAllocation.releaseAndAcquire(realConnection);
            }
        }
        return null;
    }

    public void a(RealConnection realConnection) {
        if (!f41343c && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        if (!this.f41346b) {
            this.f41346b = true;
            f41344d.execute(this.f41349g);
        }
        this.f41350h.add(realConnection);
    }

    public boolean b(RealConnection realConnection) {
        if (!f41343c && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        if (realConnection.f41711a || this.f41347e == 0) {
            this.f41350h.remove(realConnection);
            return true;
        }
        notifyAll();
        return false;
    }

    public synchronized int connectionCount() {
        return this.f41350h.size();
    }

    public void evictAll() {
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            Iterator<RealConnection> iterator2 = this.f41350h.iterator2();
            while (iterator2.hasNext()) {
                RealConnection next = iterator2.next();
                if (next.f41714d.isEmpty()) {
                    next.f41711a = true;
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

    public synchronized int idleConnectionCount() {
        int i10;
        i10 = 0;
        Iterator<RealConnection> iterator2 = this.f41350h.iterator2();
        while (iterator2.hasNext()) {
            if (iterator2.next().f41714d.isEmpty()) {
                i10++;
            }
        }
        return i10;
    }
}
