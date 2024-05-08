package com.tencent.cloud.huiyansdkface.okhttp3.internal.connection;

import com.tencent.cloud.huiyansdkface.okhttp3.Address;
import com.tencent.cloud.huiyansdkface.okhttp3.Call;
import com.tencent.cloud.huiyansdkface.okhttp3.ConnectionPool;
import com.tencent.cloud.huiyansdkface.okhttp3.EventListener;
import com.tencent.cloud.huiyansdkface.okhttp3.Interceptor;
import com.tencent.cloud.huiyansdkface.okhttp3.OkHttpClient;
import com.tencent.cloud.huiyansdkface.okhttp3.Route;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.Internal;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.Util;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.connection.RouteSelector;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.http.HttpCodec;
import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class StreamAllocation {

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ boolean f41740d = true;

    /* renamed from: a, reason: collision with root package name */
    public final Address f41741a;

    /* renamed from: b, reason: collision with root package name */
    public final Call f41742b;

    /* renamed from: c, reason: collision with root package name */
    public final EventListener f41743c;

    /* renamed from: e, reason: collision with root package name */
    private RouteSelector.Selection f41744e;

    /* renamed from: f, reason: collision with root package name */
    private Route f41745f;

    /* renamed from: g, reason: collision with root package name */
    private final ConnectionPool f41746g;

    /* renamed from: h, reason: collision with root package name */
    private final Object f41747h;

    /* renamed from: i, reason: collision with root package name */
    private final RouteSelector f41748i;

    /* renamed from: j, reason: collision with root package name */
    private int f41749j;

    /* renamed from: k, reason: collision with root package name */
    private RealConnection f41750k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f41751l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f41752m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f41753n;

    /* renamed from: o, reason: collision with root package name */
    private HttpCodec f41754o;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class StreamAllocationReference extends WeakReference<StreamAllocation> {

        /* renamed from: a, reason: collision with root package name */
        public final Object f41755a;

        public StreamAllocationReference(StreamAllocation streamAllocation, Object obj) {
            super(streamAllocation);
            this.f41755a = obj;
        }
    }

    public StreamAllocation(ConnectionPool connectionPool, Address address, Call call, EventListener eventListener, Object obj) {
        this.f41746g = connectionPool;
        this.f41741a = address;
        this.f41742b = call;
        this.f41743c = eventListener;
        this.f41748i = new RouteSelector(address, b(), call, eventListener);
        this.f41747h = obj;
    }

    private RealConnection a(int i10, int i11, int i12, int i13, boolean z10) throws IOException {
        RealConnection realConnection;
        Socket a10;
        RealConnection realConnection2;
        Socket socket;
        Route route;
        boolean z11;
        boolean z12;
        RouteSelector.Selection selection;
        synchronized (this.f41746g) {
            if (this.f41752m) {
                throw new IllegalStateException("released");
            }
            if (this.f41754o != null) {
                throw new IllegalStateException("codec != null");
            }
            if (this.f41753n) {
                throw new IOException("Canceled");
            }
            realConnection = this.f41750k;
            a10 = a();
            realConnection2 = this.f41750k;
            socket = null;
            if (realConnection2 != null) {
                realConnection = null;
            } else {
                realConnection2 = null;
            }
            if (!this.f41751l) {
                realConnection = null;
            }
            if (realConnection2 == null) {
                Internal.f41598a.get(this.f41746g, this.f41741a, this, null);
                RealConnection realConnection3 = this.f41750k;
                if (realConnection3 != null) {
                    realConnection2 = realConnection3;
                    z11 = true;
                    route = null;
                } else {
                    route = this.f41745f;
                }
            } else {
                route = null;
            }
            z11 = false;
        }
        Util.closeQuietly(a10);
        if (realConnection != null) {
            this.f41743c.connectionReleased(this.f41742b, realConnection);
        }
        if (z11) {
            this.f41743c.connectionAcquired(this.f41742b, realConnection2);
        }
        if (realConnection2 != null) {
            return realConnection2;
        }
        if (route != null || ((selection = this.f41744e) != null && selection.hasNext())) {
            z12 = false;
        } else {
            this.f41744e = this.f41748i.next();
            z12 = true;
        }
        synchronized (this.f41746g) {
            if (this.f41753n) {
                throw new IOException("Canceled");
            }
            if (z12) {
                List<Route> all = this.f41744e.getAll();
                int size = all.size();
                int i14 = 0;
                while (true) {
                    if (i14 >= size) {
                        break;
                    }
                    Route route2 = all.get(i14);
                    Internal.f41598a.get(this.f41746g, this.f41741a, this, route2);
                    RealConnection realConnection4 = this.f41750k;
                    if (realConnection4 != null) {
                        this.f41745f = route2;
                        realConnection2 = realConnection4;
                        z11 = true;
                        break;
                    }
                    i14++;
                }
            }
            if (!z11) {
                if (route == null) {
                    route = this.f41744e.next();
                }
                this.f41745f = route;
                this.f41749j = 0;
                realConnection2 = new RealConnection(this.f41746g, route);
                acquire(realConnection2, false);
            }
        }
        if (!z11) {
            realConnection2.connect(i10, i11, i12, i13, z10, this.f41742b, this.f41743c);
            b().connected(realConnection2.route());
            synchronized (this.f41746g) {
                this.f41751l = true;
                Internal.f41598a.put(this.f41746g, realConnection2);
                if (realConnection2.isMultiplexed()) {
                    socket = Internal.f41598a.deduplicate(this.f41746g, this.f41741a, this);
                    realConnection2 = this.f41750k;
                }
            }
            Util.closeQuietly(socket);
        }
        this.f41743c.connectionAcquired(this.f41742b, realConnection2);
        return realConnection2;
    }

    private RealConnection a(int i10, int i11, int i12, int i13, boolean z10, boolean z11) throws IOException {
        while (true) {
            RealConnection a10 = a(i10, i11, i12, i13, z10);
            synchronized (this.f41746g) {
                if (a10.f41712b == 0) {
                    return a10;
                }
                if (a10.isHealthy(z11)) {
                    return a10;
                }
                noNewStreams();
            }
        }
    }

    private Socket a() {
        if (!f41740d && !Thread.holdsLock(this.f41746g)) {
            throw new AssertionError();
        }
        RealConnection realConnection = this.f41750k;
        if (realConnection == null || !realConnection.f41711a) {
            return null;
        }
        return a(false, false, true);
    }

    private Socket a(boolean z10, boolean z11, boolean z12) {
        Socket socket;
        if (!f41740d && !Thread.holdsLock(this.f41746g)) {
            throw new AssertionError();
        }
        if (z12) {
            this.f41754o = null;
        }
        if (z11) {
            this.f41752m = true;
        }
        RealConnection realConnection = this.f41750k;
        if (realConnection == null) {
            return null;
        }
        if (z10) {
            realConnection.f41711a = true;
        }
        if (this.f41754o != null) {
            return null;
        }
        if (!this.f41752m && !realConnection.f41711a) {
            return null;
        }
        a(realConnection);
        if (this.f41750k.f41714d.isEmpty()) {
            this.f41750k.f41715e = System.nanoTime();
            if (Internal.f41598a.connectionBecameIdle(this.f41746g, this.f41750k)) {
                socket = this.f41750k.socket();
                this.f41750k = null;
                return socket;
            }
        }
        socket = null;
        this.f41750k = null;
        return socket;
    }

    private void a(RealConnection realConnection) {
        int size = realConnection.f41714d.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (realConnection.f41714d.get(i10).get() == this) {
                realConnection.f41714d.remove(i10);
                return;
            }
        }
        throw new IllegalStateException();
    }

    private RouteDatabase b() {
        return Internal.f41598a.routeDatabase(this.f41746g);
    }

    public void acquire(RealConnection realConnection, boolean z10) {
        if (!f41740d && !Thread.holdsLock(this.f41746g)) {
            throw new AssertionError();
        }
        if (this.f41750k != null) {
            throw new IllegalStateException();
        }
        this.f41750k = realConnection;
        this.f41751l = z10;
        realConnection.f41714d.add(new StreamAllocationReference(this, this.f41747h));
    }

    public void cancel() {
        HttpCodec httpCodec;
        RealConnection realConnection;
        synchronized (this.f41746g) {
            this.f41753n = true;
            httpCodec = this.f41754o;
            realConnection = this.f41750k;
        }
        if (httpCodec != null) {
            httpCodec.cancel();
        } else if (realConnection != null) {
            realConnection.cancel();
        }
    }

    public HttpCodec codec() {
        HttpCodec httpCodec;
        synchronized (this.f41746g) {
            httpCodec = this.f41754o;
        }
        return httpCodec;
    }

    public synchronized RealConnection connection() {
        return this.f41750k;
    }

    public boolean hasMoreRoutes() {
        RouteSelector.Selection selection;
        return this.f41745f != null || ((selection = this.f41744e) != null && selection.hasNext()) || this.f41748i.hasNext();
    }

    public HttpCodec newStream(OkHttpClient okHttpClient, Interceptor.Chain chain, boolean z10) {
        try {
            HttpCodec newCodec = a(chain.connectTimeoutMillis(), chain.readTimeoutMillis(), chain.writeTimeoutMillis(), okHttpClient.pingIntervalMillis(), okHttpClient.retryOnConnectionFailure(), z10).newCodec(okHttpClient, chain, this);
            synchronized (this.f41746g) {
                this.f41754o = newCodec;
            }
            return newCodec;
        } catch (IOException e2) {
            throw new RouteException(e2);
        }
    }

    public void noNewStreams() {
        RealConnection realConnection;
        Socket a10;
        synchronized (this.f41746g) {
            realConnection = this.f41750k;
            a10 = a(true, false, false);
            if (this.f41750k != null) {
                realConnection = null;
            }
        }
        Util.closeQuietly(a10);
        if (realConnection != null) {
            this.f41743c.connectionReleased(this.f41742b, realConnection);
        }
    }

    public void release() {
        RealConnection realConnection;
        Socket a10;
        synchronized (this.f41746g) {
            realConnection = this.f41750k;
            a10 = a(false, true, false);
            if (this.f41750k != null) {
                realConnection = null;
            }
        }
        Util.closeQuietly(a10);
        if (realConnection != null) {
            Internal.f41598a.timeoutExit(this.f41742b, null);
            this.f41743c.connectionReleased(this.f41742b, realConnection);
            this.f41743c.callEnd(this.f41742b);
        }
    }

    public Socket releaseAndAcquire(RealConnection realConnection) {
        if (!f41740d && !Thread.holdsLock(this.f41746g)) {
            throw new AssertionError();
        }
        if (this.f41754o != null || this.f41750k.f41714d.size() != 1) {
            throw new IllegalStateException();
        }
        Reference<StreamAllocation> reference = this.f41750k.f41714d.get(0);
        Socket a10 = a(true, false, false);
        this.f41750k = realConnection;
        realConnection.f41714d.add(reference);
        return a10;
    }

    public Route route() {
        return this.f41745f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x001c, code lost:
    
        if (r7 != com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.ErrorCode.CANCEL) goto L13;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004e A[Catch: all -> 0x0062, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x000a, B:8:0x0012, B:11:0x001e, B:13:0x0044, B:15:0x004e, B:19:0x0054, B:28:0x001a, B:30:0x0021, B:32:0x0025, B:34:0x002b, B:36:0x002f, B:38:0x0035, B:41:0x003b), top: B:3:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void streamFailed(java.io.IOException r7) {
        /*
            r6 = this;
            com.tencent.cloud.huiyansdkface.okhttp3.ConnectionPool r0 = r6.f41746g
            monitor-enter(r0)
            boolean r1 = r7 instanceof com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.StreamResetException     // Catch: java.lang.Throwable -> L62
            r2 = 0
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L21
            com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.StreamResetException r7 = (com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.StreamResetException) r7     // Catch: java.lang.Throwable -> L62
            com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.ErrorCode r7 = r7.f41985a     // Catch: java.lang.Throwable -> L62
            com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.ErrorCode r1 = com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.ErrorCode.REFUSED_STREAM     // Catch: java.lang.Throwable -> L62
            if (r7 != r1) goto L1a
            int r7 = r6.f41749j     // Catch: java.lang.Throwable -> L62
            int r7 = r7 + r4
            r6.f41749j = r7     // Catch: java.lang.Throwable -> L62
            if (r7 <= r4) goto L43
            goto L1e
        L1a:
            com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.ErrorCode r1 = com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.ErrorCode.CANCEL     // Catch: java.lang.Throwable -> L62
            if (r7 == r1) goto L43
        L1e:
            r6.f41745f = r3     // Catch: java.lang.Throwable -> L62
            goto L41
        L21:
            com.tencent.cloud.huiyansdkface.okhttp3.internal.connection.RealConnection r1 = r6.f41750k     // Catch: java.lang.Throwable -> L62
            if (r1 == 0) goto L43
            boolean r1 = r1.isMultiplexed()     // Catch: java.lang.Throwable -> L62
            if (r1 == 0) goto L2f
            boolean r1 = r7 instanceof com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.ConnectionShutdownException     // Catch: java.lang.Throwable -> L62
            if (r1 == 0) goto L43
        L2f:
            com.tencent.cloud.huiyansdkface.okhttp3.internal.connection.RealConnection r1 = r6.f41750k     // Catch: java.lang.Throwable -> L62
            int r1 = r1.f41712b     // Catch: java.lang.Throwable -> L62
            if (r1 != 0) goto L41
            com.tencent.cloud.huiyansdkface.okhttp3.Route r1 = r6.f41745f     // Catch: java.lang.Throwable -> L62
            if (r1 == 0) goto L1e
            if (r7 == 0) goto L1e
            com.tencent.cloud.huiyansdkface.okhttp3.internal.connection.RouteSelector r5 = r6.f41748i     // Catch: java.lang.Throwable -> L62
            r5.connectFailed(r1, r7)     // Catch: java.lang.Throwable -> L62
            goto L1e
        L41:
            r7 = 1
            goto L44
        L43:
            r7 = 0
        L44:
            com.tencent.cloud.huiyansdkface.okhttp3.internal.connection.RealConnection r1 = r6.f41750k     // Catch: java.lang.Throwable -> L62
            java.net.Socket r7 = r6.a(r7, r2, r4)     // Catch: java.lang.Throwable -> L62
            com.tencent.cloud.huiyansdkface.okhttp3.internal.connection.RealConnection r2 = r6.f41750k     // Catch: java.lang.Throwable -> L62
            if (r2 != 0) goto L54
            boolean r2 = r6.f41751l     // Catch: java.lang.Throwable -> L62
            if (r2 != 0) goto L53
            goto L54
        L53:
            r3 = r1
        L54:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L62
            com.tencent.cloud.huiyansdkface.okhttp3.internal.Util.closeQuietly(r7)
            if (r3 == 0) goto L61
            com.tencent.cloud.huiyansdkface.okhttp3.EventListener r7 = r6.f41743c
            com.tencent.cloud.huiyansdkface.okhttp3.Call r0 = r6.f41742b
            r7.connectionReleased(r0, r3)
        L61:
            return
        L62:
            r7 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L62
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.cloud.huiyansdkface.okhttp3.internal.connection.StreamAllocation.streamFailed(java.io.IOException):void");
    }

    public void streamFinished(boolean z10, HttpCodec httpCodec, long j10, IOException iOException) {
        RealConnection realConnection;
        Socket a10;
        boolean z11;
        this.f41743c.responseBodyEnd(this.f41742b, j10);
        synchronized (this.f41746g) {
            if (httpCodec != null) {
                if (httpCodec == this.f41754o) {
                    if (!z10) {
                        this.f41750k.f41712b++;
                    }
                    realConnection = this.f41750k;
                    a10 = a(z10, false, true);
                    if (this.f41750k != null) {
                        realConnection = null;
                    }
                    z11 = this.f41752m;
                }
            }
            throw new IllegalStateException("expected " + ((Object) this.f41754o) + " but was " + ((Object) httpCodec));
        }
        Util.closeQuietly(a10);
        if (realConnection != null) {
            this.f41743c.connectionReleased(this.f41742b, realConnection);
        }
        if (iOException != null) {
            this.f41743c.callFailed(this.f41742b, Internal.f41598a.timeoutExit(this.f41742b, iOException));
        } else if (z11) {
            Internal.f41598a.timeoutExit(this.f41742b, null);
            this.f41743c.callEnd(this.f41742b);
        }
    }

    public String toString() {
        RealConnection connection = connection();
        return connection != null ? connection.toString() : this.f41741a.toString();
    }
}
