package com.tencent.cloud.huiyansdkface.okhttp3.internal.http2;

import com.tencent.cloud.huiyansdkface.okhttp3.Protocol;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.NamedRunnable;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.Util;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.Http2Reader;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.platform.Platform;
import com.tencent.cloud.huiyansdkface.okio.Buffer;
import com.tencent.cloud.huiyansdkface.okio.BufferedSink;
import com.tencent.cloud.huiyansdkface.okio.BufferedSource;
import com.tencent.cloud.huiyansdkface.okio.ByteString;
import com.tencent.cloud.huiyansdkface.okio.Okio;
import java.io.Closeable;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class Http2Connection implements Closeable {

    /* renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ boolean f41868r = true;

    /* renamed from: s, reason: collision with root package name */
    private static final ExecutorService f41869s = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp Http2Connection", true));

    /* renamed from: a, reason: collision with root package name */
    public final boolean f41870a;

    /* renamed from: b, reason: collision with root package name */
    public final Listener f41871b;

    /* renamed from: d, reason: collision with root package name */
    public final String f41873d;

    /* renamed from: e, reason: collision with root package name */
    public int f41874e;

    /* renamed from: f, reason: collision with root package name */
    public int f41875f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f41876g;

    /* renamed from: h, reason: collision with root package name */
    public final PushObserver f41877h;

    /* renamed from: j, reason: collision with root package name */
    public long f41879j;

    /* renamed from: l, reason: collision with root package name */
    public final Settings f41881l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f41882m;

    /* renamed from: n, reason: collision with root package name */
    public final Socket f41883n;

    /* renamed from: o, reason: collision with root package name */
    public final Http2Writer f41884o;

    /* renamed from: p, reason: collision with root package name */
    public final ReaderRunnable f41885p;

    /* renamed from: q, reason: collision with root package name */
    public final Set<Integer> f41886q;

    /* renamed from: t, reason: collision with root package name */
    private final ScheduledExecutorService f41887t;

    /* renamed from: u, reason: collision with root package name */
    private final ExecutorService f41888u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f41889v;

    /* renamed from: c, reason: collision with root package name */
    public final Map<Integer, Http2Stream> f41872c = new LinkedHashMap();

    /* renamed from: i, reason: collision with root package name */
    public long f41878i = 0;

    /* renamed from: k, reason: collision with root package name */
    public Settings f41880k = new Settings();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        public Socket f41911a;

        /* renamed from: b, reason: collision with root package name */
        public String f41912b;

        /* renamed from: c, reason: collision with root package name */
        public BufferedSource f41913c;

        /* renamed from: d, reason: collision with root package name */
        public BufferedSink f41914d;

        /* renamed from: e, reason: collision with root package name */
        public Listener f41915e = Listener.f41919f;

        /* renamed from: f, reason: collision with root package name */
        public PushObserver f41916f = PushObserver.f41982a;

        /* renamed from: g, reason: collision with root package name */
        public boolean f41917g;

        /* renamed from: h, reason: collision with root package name */
        public int f41918h;

        public Builder(boolean z10) {
            this.f41917g = z10;
        }

        public Http2Connection build() {
            return new Http2Connection(this);
        }

        public Builder listener(Listener listener) {
            this.f41915e = listener;
            return this;
        }

        public Builder pingIntervalMillis(int i10) {
            this.f41918h = i10;
            return this;
        }

        public Builder pushObserver(PushObserver pushObserver) {
            this.f41916f = pushObserver;
            return this;
        }

        public Builder socket(Socket socket) throws IOException {
            return socket(socket, ((InetSocketAddress) socket.getRemoteSocketAddress()).getHostName(), Okio.buffer(Okio.source(socket)), Okio.buffer(Okio.sink(socket)));
        }

        public Builder socket(Socket socket, String str, BufferedSource bufferedSource, BufferedSink bufferedSink) {
            this.f41911a = socket;
            this.f41912b = str;
            this.f41913c = bufferedSource;
            this.f41914d = bufferedSink;
            return this;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static abstract class Listener {

        /* renamed from: f, reason: collision with root package name */
        public static final Listener f41919f = new Listener() { // from class: com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.Http2Connection.Listener.1
            @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.Http2Connection.Listener
            public void onStream(Http2Stream http2Stream) throws IOException {
                http2Stream.close(ErrorCode.REFUSED_STREAM);
            }
        };

        public void onSettings(Http2Connection http2Connection) {
        }

        public abstract void onStream(Http2Stream http2Stream) throws IOException;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public final class PingRunnable extends NamedRunnable {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f41920a;

        /* renamed from: b, reason: collision with root package name */
        public final int f41921b;

        /* renamed from: d, reason: collision with root package name */
        public final int f41922d;

        public PingRunnable(boolean z10, int i10, int i11) {
            super("OkHttp %s ping %08x%08x", Http2Connection.this.f41873d, Integer.valueOf(i10), Integer.valueOf(i11));
            this.f41920a = z10;
            this.f41921b = i10;
            this.f41922d = i11;
        }

        @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.NamedRunnable
        public void execute() {
            Http2Connection.this.a(this.f41920a, this.f41921b, this.f41922d);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class ReaderRunnable extends NamedRunnable implements Http2Reader.Handler {

        /* renamed from: a, reason: collision with root package name */
        public final Http2Reader f41924a;

        public ReaderRunnable(Http2Reader http2Reader) {
            super("OkHttp %s", Http2Connection.this.f41873d);
            this.f41924a = http2Reader;
        }

        private void a(final Settings settings) {
            try {
                Http2Connection.this.f41887t.execute(new NamedRunnable("OkHttp %s ACK Settings", new Object[]{Http2Connection.this.f41873d}) { // from class: com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.Http2Connection.ReaderRunnable.3
                    @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.NamedRunnable
                    public void execute() {
                        try {
                            Http2Connection.this.f41884o.applyAndAckSettings(settings);
                        } catch (IOException unused) {
                            Http2Connection.this.b();
                        }
                    }
                });
            } catch (RejectedExecutionException unused) {
            }
        }

        @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.Http2Reader.Handler
        public void ackSettings() {
        }

        @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.Http2Reader.Handler
        public void alternateService(int i10, String str, ByteString byteString, String str2, int i11, long j10) {
        }

        @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.Http2Reader.Handler
        public void data(boolean z10, int i10, BufferedSource bufferedSource, int i11) throws IOException {
            if (Http2Connection.this.c(i10)) {
                Http2Connection.this.a(i10, bufferedSource, i11, z10);
                return;
            }
            Http2Stream a10 = Http2Connection.this.a(i10);
            if (a10 == null) {
                Http2Connection.this.a(i10, ErrorCode.PROTOCOL_ERROR);
                long j10 = i11;
                Http2Connection.this.a(j10);
                bufferedSource.skip(j10);
                return;
            }
            a10.a(bufferedSource, i11);
            if (z10) {
                a10.a();
            }
        }

        @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.NamedRunnable
        public void execute() {
            ErrorCode errorCode;
            ErrorCode errorCode2 = ErrorCode.INTERNAL_ERROR;
            try {
                try {
                    this.f41924a.readConnectionPreface(this);
                    do {
                    } while (this.f41924a.nextFrame(false, this));
                    errorCode = ErrorCode.NO_ERROR;
                } catch (IOException unused) {
                    errorCode = errorCode2;
                } catch (Throwable th) {
                    th = th;
                    errorCode = errorCode2;
                    try {
                        Http2Connection.this.a(errorCode, errorCode2);
                    } catch (IOException unused2) {
                    }
                    Util.closeQuietly(this.f41924a);
                    throw th;
                }
                try {
                    try {
                        Http2Connection.this.a(errorCode, ErrorCode.CANCEL);
                    } catch (Throwable th2) {
                        th = th2;
                        Http2Connection.this.a(errorCode, errorCode2);
                        Util.closeQuietly(this.f41924a);
                        throw th;
                    }
                } catch (IOException unused3) {
                    ErrorCode errorCode3 = ErrorCode.PROTOCOL_ERROR;
                    Http2Connection.this.a(errorCode3, errorCode3);
                    Util.closeQuietly(this.f41924a);
                }
            } catch (IOException unused4) {
            }
            Util.closeQuietly(this.f41924a);
        }

        @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.Http2Reader.Handler
        public void goAway(int i10, ErrorCode errorCode, ByteString byteString) {
            Http2Stream[] http2StreamArr;
            byteString.size();
            synchronized (Http2Connection.this) {
                http2StreamArr = (Http2Stream[]) Http2Connection.this.f41872c.values().toArray(new Http2Stream[Http2Connection.this.f41872c.size()]);
                Http2Connection.this.f41876g = true;
            }
            for (Http2Stream http2Stream : http2StreamArr) {
                if (http2Stream.getId() > i10 && http2Stream.isLocallyInitiated()) {
                    http2Stream.a(ErrorCode.REFUSED_STREAM);
                    Http2Connection.this.b(http2Stream.getId());
                }
            }
        }

        @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.Http2Reader.Handler
        public void headers(boolean z10, int i10, int i11, List<Header> list) {
            if (Http2Connection.this.c(i10)) {
                Http2Connection.this.a(i10, list, z10);
                return;
            }
            synchronized (Http2Connection.this) {
                Http2Stream a10 = Http2Connection.this.a(i10);
                if (a10 != null) {
                    a10.a(list);
                    if (z10) {
                        a10.a();
                        return;
                    }
                    return;
                }
                Http2Connection http2Connection = Http2Connection.this;
                if (http2Connection.f41876g) {
                    return;
                }
                if (i10 <= http2Connection.f41874e) {
                    return;
                }
                if (i10 % 2 == http2Connection.f41875f % 2) {
                    return;
                }
                final Http2Stream http2Stream = new Http2Stream(i10, Http2Connection.this, false, z10, Util.toHeaders(list));
                Http2Connection http2Connection2 = Http2Connection.this;
                http2Connection2.f41874e = i10;
                http2Connection2.f41872c.put(Integer.valueOf(i10), http2Stream);
                Http2Connection.f41869s.execute(new NamedRunnable("OkHttp %s stream %d", new Object[]{Http2Connection.this.f41873d, Integer.valueOf(i10)}) { // from class: com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.Http2Connection.ReaderRunnable.1
                    @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.NamedRunnable
                    public void execute() {
                        try {
                            Http2Connection.this.f41871b.onStream(http2Stream);
                        } catch (IOException e2) {
                            Platform.get().log(4, "Http2Connection.Listener failure for " + Http2Connection.this.f41873d, e2);
                            try {
                                http2Stream.close(ErrorCode.PROTOCOL_ERROR);
                            } catch (IOException unused) {
                            }
                        }
                    }
                });
            }
        }

        @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.Http2Reader.Handler
        public void ping(boolean z10, int i10, int i11) {
            if (!z10) {
                try {
                    Http2Connection.this.f41887t.execute(new PingRunnable(true, i10, i11));
                } catch (RejectedExecutionException unused) {
                }
            } else {
                synchronized (Http2Connection.this) {
                    Http2Connection.this.f41889v = false;
                    Http2Connection.this.notifyAll();
                }
            }
        }

        @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.Http2Reader.Handler
        public void priority(int i10, int i11, int i12, boolean z10) {
        }

        @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.Http2Reader.Handler
        public void pushPromise(int i10, int i11, List<Header> list) {
            Http2Connection.this.a(i11, list);
        }

        @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.Http2Reader.Handler
        public void rstStream(int i10, ErrorCode errorCode) {
            if (Http2Connection.this.c(i10)) {
                Http2Connection.this.c(i10, errorCode);
                return;
            }
            Http2Stream b4 = Http2Connection.this.b(i10);
            if (b4 != null) {
                b4.a(errorCode);
            }
        }

        @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.Http2Reader.Handler
        public void settings(boolean z10, Settings settings) {
            Http2Stream[] http2StreamArr;
            long j10;
            int i10;
            synchronized (Http2Connection.this) {
                int d10 = Http2Connection.this.f41881l.d();
                if (z10) {
                    Http2Connection.this.f41881l.a();
                }
                Http2Connection.this.f41881l.a(settings);
                a(settings);
                int d11 = Http2Connection.this.f41881l.d();
                http2StreamArr = null;
                if (d11 == -1 || d11 == d10) {
                    j10 = 0;
                } else {
                    j10 = d11 - d10;
                    Http2Connection http2Connection = Http2Connection.this;
                    if (!http2Connection.f41882m) {
                        http2Connection.f41882m = true;
                    }
                    if (!http2Connection.f41872c.isEmpty()) {
                        http2StreamArr = (Http2Stream[]) Http2Connection.this.f41872c.values().toArray(new Http2Stream[Http2Connection.this.f41872c.size()]);
                    }
                }
                Http2Connection.f41869s.execute(new NamedRunnable("OkHttp %s settings", Http2Connection.this.f41873d) { // from class: com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.Http2Connection.ReaderRunnable.2
                    @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.NamedRunnable
                    public void execute() {
                        Http2Connection http2Connection2 = Http2Connection.this;
                        http2Connection2.f41871b.onSettings(http2Connection2);
                    }
                });
            }
            if (http2StreamArr == null || j10 == 0) {
                return;
            }
            for (Http2Stream http2Stream : http2StreamArr) {
                synchronized (http2Stream) {
                    http2Stream.a(j10);
                }
            }
        }

        @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.Http2Reader.Handler
        public void windowUpdate(int i10, long j10) {
            Http2Connection http2Connection = Http2Connection.this;
            if (i10 == 0) {
                synchronized (http2Connection) {
                    Http2Connection http2Connection2 = Http2Connection.this;
                    http2Connection2.f41879j += j10;
                    http2Connection2.notifyAll();
                }
                return;
            }
            Http2Stream a10 = http2Connection.a(i10);
            if (a10 != null) {
                synchronized (a10) {
                    a10.a(j10);
                }
            }
        }
    }

    public Http2Connection(Builder builder) {
        Settings settings = new Settings();
        this.f41881l = settings;
        this.f41882m = false;
        this.f41886q = new LinkedHashSet();
        this.f41877h = builder.f41916f;
        boolean z10 = builder.f41917g;
        this.f41870a = z10;
        this.f41871b = builder.f41915e;
        int i10 = z10 ? 1 : 2;
        this.f41875f = i10;
        if (z10) {
            this.f41875f = i10 + 2;
        }
        if (z10) {
            this.f41880k.a(7, 16777216);
        }
        String str = builder.f41912b;
        this.f41873d = str;
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, Util.threadFactory(Util.format("OkHttp %s Writer", str), false));
        this.f41887t = scheduledThreadPoolExecutor;
        if (builder.f41918h != 0) {
            PingRunnable pingRunnable = new PingRunnable(false, 0, 0);
            int i11 = builder.f41918h;
            scheduledThreadPoolExecutor.scheduleAtFixedRate(pingRunnable, i11, i11, TimeUnit.MILLISECONDS);
        }
        this.f41888u = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.threadFactory(Util.format("OkHttp %s Push Observer", str), true));
        settings.a(7, 65535);
        settings.a(5, 16384);
        this.f41879j = settings.d();
        this.f41883n = builder.f41911a;
        this.f41884o = new Http2Writer(builder.f41914d, z10);
        this.f41885p = new ReaderRunnable(new Http2Reader(builder.f41913c, z10));
    }

    private synchronized void a(NamedRunnable namedRunnable) {
        if (!isShutdown()) {
            this.f41888u.execute(namedRunnable);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0041 A[Catch: all -> 0x0073, TryCatch #0 {, blocks: (B:6:0x0007, B:8:0x000e, B:9:0x0013, B:11:0x0017, B:13:0x0029, B:15:0x0031, B:19:0x003b, B:21:0x0041, B:22:0x004a, B:36:0x006d, B:37:0x0072), top: B:5:0x0007, outer: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.Http2Stream b(int r11, java.util.List<com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.Header> r12, boolean r13) throws java.io.IOException {
        /*
            r10 = this;
            r6 = r13 ^ 1
            r4 = 0
            com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.Http2Writer r7 = r10.f41884o
            monitor-enter(r7)
            monitor-enter(r10)     // Catch: java.lang.Throwable -> L76
            int r0 = r10.f41875f     // Catch: java.lang.Throwable -> L73
            r1 = 1073741823(0x3fffffff, float:1.9999999)
            if (r0 <= r1) goto L13
            com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.ErrorCode r0 = com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.ErrorCode.REFUSED_STREAM     // Catch: java.lang.Throwable -> L73
            r10.shutdown(r0)     // Catch: java.lang.Throwable -> L73
        L13:
            boolean r0 = r10.f41876g     // Catch: java.lang.Throwable -> L73
            if (r0 != 0) goto L6d
            int r8 = r10.f41875f     // Catch: java.lang.Throwable -> L73
            int r0 = r8 + 2
            r10.f41875f = r0     // Catch: java.lang.Throwable -> L73
            com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.Http2Stream r9 = new com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.Http2Stream     // Catch: java.lang.Throwable -> L73
            r5 = 0
            r0 = r9
            r1 = r8
            r2 = r10
            r3 = r6
            r0.<init>(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L73
            if (r13 == 0) goto L3a
            long r0 = r10.f41879j     // Catch: java.lang.Throwable -> L73
            r2 = 0
            int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r13 == 0) goto L3a
            long r0 = r9.f41944b     // Catch: java.lang.Throwable -> L73
            int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r13 != 0) goto L38
            goto L3a
        L38:
            r13 = 0
            goto L3b
        L3a:
            r13 = 1
        L3b:
            boolean r0 = r9.isOpen()     // Catch: java.lang.Throwable -> L73
            if (r0 == 0) goto L4a
            java.util.Map<java.lang.Integer, com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.Http2Stream> r0 = r10.f41872c     // Catch: java.lang.Throwable -> L73
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)     // Catch: java.lang.Throwable -> L73
            r0.put(r1, r9)     // Catch: java.lang.Throwable -> L73
        L4a:
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L73
            if (r11 != 0) goto L53
            com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.Http2Writer r0 = r10.f41884o     // Catch: java.lang.Throwable -> L76
            r0.synStream(r6, r8, r11, r12)     // Catch: java.lang.Throwable -> L76
            goto L5c
        L53:
            boolean r0 = r10.f41870a     // Catch: java.lang.Throwable -> L76
            if (r0 != 0) goto L65
            com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.Http2Writer r0 = r10.f41884o     // Catch: java.lang.Throwable -> L76
            r0.pushPromise(r11, r8, r12)     // Catch: java.lang.Throwable -> L76
        L5c:
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L76
            if (r13 == 0) goto L64
            com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.Http2Writer r11 = r10.f41884o
            r11.flush()
        L64:
            return r9
        L65:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException     // Catch: java.lang.Throwable -> L76
            java.lang.String r12 = "client streams shouldn't have associated stream IDs"
            r11.<init>(r12)     // Catch: java.lang.Throwable -> L76
            throw r11     // Catch: java.lang.Throwable -> L76
        L6d:
            com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.ConnectionShutdownException r11 = new com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.ConnectionShutdownException     // Catch: java.lang.Throwable -> L73
            r11.<init>()     // Catch: java.lang.Throwable -> L73
            throw r11     // Catch: java.lang.Throwable -> L73
        L73:
            r11 = move-exception
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L73
            throw r11     // Catch: java.lang.Throwable -> L76
        L76:
            r11 = move-exception
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L76
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.Http2Connection.b(int, java.util.List, boolean):com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.Http2Stream");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        try {
            ErrorCode errorCode = ErrorCode.PROTOCOL_ERROR;
            a(errorCode, errorCode);
        } catch (IOException unused) {
        }
    }

    public synchronized Http2Stream a(int i10) {
        return this.f41872c.get(Integer.valueOf(i10));
    }

    public void a(final int i10, final long j10) {
        try {
            this.f41887t.execute(new NamedRunnable("OkHttp Window Update %s stream %d", new Object[]{this.f41873d, Integer.valueOf(i10)}) { // from class: com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.Http2Connection.2
                @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.NamedRunnable
                public void execute() {
                    try {
                        Http2Connection.this.f41884o.windowUpdate(i10, j10);
                    } catch (IOException unused) {
                        Http2Connection.this.b();
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
        }
    }

    public void a(final int i10, final ErrorCode errorCode) {
        try {
            this.f41887t.execute(new NamedRunnable("OkHttp %s stream %d", new Object[]{this.f41873d, Integer.valueOf(i10)}) { // from class: com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.Http2Connection.1
                @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.NamedRunnable
                public void execute() {
                    try {
                        Http2Connection.this.b(i10, errorCode);
                    } catch (IOException unused) {
                        Http2Connection.this.b();
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
        }
    }

    public void a(final int i10, BufferedSource bufferedSource, final int i11, final boolean z10) throws IOException {
        final Buffer buffer = new Buffer();
        long j10 = i11;
        bufferedSource.require(j10);
        bufferedSource.read(buffer, j10);
        if (buffer.size() == j10) {
            a(new NamedRunnable("OkHttp %s Push Data[%s]", new Object[]{this.f41873d, Integer.valueOf(i10)}) { // from class: com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.Http2Connection.5
                @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.NamedRunnable
                public void execute() {
                    try {
                        boolean onData = Http2Connection.this.f41877h.onData(i10, buffer, i11, z10);
                        if (onData) {
                            Http2Connection.this.f41884o.rstStream(i10, ErrorCode.CANCEL);
                        }
                        if (onData || z10) {
                            synchronized (Http2Connection.this) {
                                Http2Connection.this.f41886q.remove(Integer.valueOf(i10));
                            }
                        }
                    } catch (IOException unused) {
                    }
                }
            });
            return;
        }
        throw new IOException(buffer.size() + " != " + i11);
    }

    public void a(final int i10, final List<Header> list) {
        synchronized (this) {
            if (this.f41886q.contains(Integer.valueOf(i10))) {
                a(i10, ErrorCode.PROTOCOL_ERROR);
                return;
            }
            this.f41886q.add(Integer.valueOf(i10));
            try {
                a(new NamedRunnable("OkHttp %s Push Request[%s]", new Object[]{this.f41873d, Integer.valueOf(i10)}) { // from class: com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.Http2Connection.3
                    @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.NamedRunnable
                    public void execute() {
                        if (Http2Connection.this.f41877h.onRequest(i10, list)) {
                            try {
                                Http2Connection.this.f41884o.rstStream(i10, ErrorCode.CANCEL);
                                synchronized (Http2Connection.this) {
                                    Http2Connection.this.f41886q.remove(Integer.valueOf(i10));
                                }
                            } catch (IOException unused) {
                            }
                        }
                    }
                });
            } catch (RejectedExecutionException unused) {
            }
        }
    }

    public void a(final int i10, final List<Header> list, final boolean z10) {
        try {
            a(new NamedRunnable("OkHttp %s Push Headers[%s]", new Object[]{this.f41873d, Integer.valueOf(i10)}) { // from class: com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.Http2Connection.4
                @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.NamedRunnable
                public void execute() {
                    boolean onHeaders = Http2Connection.this.f41877h.onHeaders(i10, list, z10);
                    if (onHeaders) {
                        try {
                            Http2Connection.this.f41884o.rstStream(i10, ErrorCode.CANCEL);
                        } catch (IOException unused) {
                            return;
                        }
                    }
                    if (onHeaders || z10) {
                        synchronized (Http2Connection.this) {
                            Http2Connection.this.f41886q.remove(Integer.valueOf(i10));
                        }
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
        }
    }

    public void a(int i10, boolean z10, List<Header> list) throws IOException {
        this.f41884o.synReply(z10, i10, list);
    }

    public synchronized void a(long j10) {
        long j11 = this.f41878i + j10;
        this.f41878i = j11;
        if (j11 >= this.f41880k.d() / 2) {
            a(0, this.f41878i);
            this.f41878i = 0L;
        }
    }

    public void a(ErrorCode errorCode, ErrorCode errorCode2) throws IOException {
        if (!f41868r && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        Http2Stream[] http2StreamArr = null;
        try {
            shutdown(errorCode);
            e = null;
        } catch (IOException e2) {
            e = e2;
        }
        synchronized (this) {
            if (!this.f41872c.isEmpty()) {
                http2StreamArr = (Http2Stream[]) this.f41872c.values().toArray(new Http2Stream[this.f41872c.size()]);
                this.f41872c.clear();
            }
        }
        if (http2StreamArr != null) {
            for (Http2Stream http2Stream : http2StreamArr) {
                try {
                    http2Stream.close(errorCode2);
                } catch (IOException e10) {
                    if (e != null) {
                        e = e10;
                    }
                }
            }
        }
        try {
            this.f41884o.close();
        } catch (IOException e11) {
            if (e == null) {
                e = e11;
            }
        }
        try {
            this.f41883n.close();
        } catch (IOException e12) {
            e = e12;
        }
        this.f41887t.shutdown();
        this.f41888u.shutdown();
        if (e != null) {
            throw e;
        }
    }

    public void a(boolean z10) throws IOException {
        if (z10) {
            this.f41884o.connectionPreface();
            this.f41884o.settings(this.f41880k);
            if (this.f41880k.d() != 65535) {
                this.f41884o.windowUpdate(0, r6 - 65535);
            }
        }
        new Thread(this.f41885p).start();
    }

    public void a(boolean z10, int i10, int i11) {
        boolean z11;
        if (!z10) {
            synchronized (this) {
                z11 = this.f41889v;
                this.f41889v = true;
            }
            if (z11) {
                b();
                return;
            }
        }
        try {
            this.f41884o.ping(z10, i10, i11);
        } catch (IOException unused) {
            b();
        }
    }

    public synchronized Http2Stream b(int i10) {
        Http2Stream remove;
        remove = this.f41872c.remove(Integer.valueOf(i10));
        notifyAll();
        return remove;
    }

    public void b(int i10, ErrorCode errorCode) throws IOException {
        this.f41884o.rstStream(i10, errorCode);
    }

    public void c(final int i10, final ErrorCode errorCode) {
        a(new NamedRunnable("OkHttp %s Push Reset[%s]", new Object[]{this.f41873d, Integer.valueOf(i10)}) { // from class: com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.Http2Connection.6
            @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.NamedRunnable
            public void execute() {
                Http2Connection.this.f41877h.onReset(i10, errorCode);
                synchronized (Http2Connection.this) {
                    Http2Connection.this.f41886q.remove(Integer.valueOf(i10));
                }
            }
        });
    }

    public boolean c(int i10) {
        return i10 != 0 && (i10 & 1) == 0;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        a(ErrorCode.NO_ERROR, ErrorCode.CANCEL);
    }

    public void flush() throws IOException {
        this.f41884o.flush();
    }

    public Protocol getProtocol() {
        return Protocol.HTTP_2;
    }

    public synchronized boolean isShutdown() {
        return this.f41876g;
    }

    public synchronized int maxConcurrentStreams() {
        return this.f41881l.c(Integer.MAX_VALUE);
    }

    public Http2Stream newStream(List<Header> list, boolean z10) throws IOException {
        return b(0, list, z10);
    }

    public synchronized int openStreamCount() {
        return this.f41872c.size();
    }

    public Http2Stream pushStream(int i10, List<Header> list, boolean z10) throws IOException {
        if (this.f41870a) {
            throw new IllegalStateException("Client cannot push requests.");
        }
        return b(i10, list, z10);
    }

    public void setSettings(Settings settings) throws IOException {
        synchronized (this.f41884o) {
            synchronized (this) {
                if (this.f41876g) {
                    throw new ConnectionShutdownException();
                }
                this.f41880k.a(settings);
            }
            this.f41884o.settings(settings);
        }
    }

    public void shutdown(ErrorCode errorCode) throws IOException {
        synchronized (this.f41884o) {
            synchronized (this) {
                if (this.f41876g) {
                    return;
                }
                this.f41876g = true;
                this.f41884o.goAway(this.f41874e, errorCode, Util.f41600a);
            }
        }
    }

    public void start() throws IOException {
        a(true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x002f, code lost:
    
        throw new java.io.IOException("stream closed");
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0030, code lost:
    
        r3 = java.lang.Math.min((int) java.lang.Math.min(r12, r3), r8.f41884o.maxDataLength());
        r6 = r3;
        r8.f41879j -= r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void writeData(int r9, boolean r10, com.tencent.cloud.huiyansdkface.okio.Buffer r11, long r12) throws java.io.IOException {
        /*
            r8 = this;
            r0 = 0
            r1 = 0
            int r3 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r3 != 0) goto Ld
            com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.Http2Writer r12 = r8.f41884o
            r12.data(r10, r9, r11, r0)
            return
        Ld:
            int r3 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r3 <= 0) goto L67
            monitor-enter(r8)
        L12:
            long r3 = r8.f41879j     // Catch: java.lang.Throwable -> L56 java.lang.InterruptedException -> L58
            int r5 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r5 > 0) goto L30
            java.util.Map<java.lang.Integer, com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.Http2Stream> r3 = r8.f41872c     // Catch: java.lang.Throwable -> L56 java.lang.InterruptedException -> L58
            java.lang.Integer r4 = java.lang.Integer.valueOf(r9)     // Catch: java.lang.Throwable -> L56 java.lang.InterruptedException -> L58
            boolean r3 = r3.containsKey(r4)     // Catch: java.lang.Throwable -> L56 java.lang.InterruptedException -> L58
            if (r3 == 0) goto L28
            r8.wait()     // Catch: java.lang.Throwable -> L56 java.lang.InterruptedException -> L58
            goto L12
        L28:
            java.io.IOException r9 = new java.io.IOException     // Catch: java.lang.Throwable -> L56 java.lang.InterruptedException -> L58
            java.lang.String r10 = "stream closed"
            r9.<init>(r10)     // Catch: java.lang.Throwable -> L56 java.lang.InterruptedException -> L58
            throw r9     // Catch: java.lang.Throwable -> L56 java.lang.InterruptedException -> L58
        L30:
            long r3 = java.lang.Math.min(r12, r3)     // Catch: java.lang.Throwable -> L56
            int r4 = (int) r3     // Catch: java.lang.Throwable -> L56
            com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.Http2Writer r3 = r8.f41884o     // Catch: java.lang.Throwable -> L56
            int r3 = r3.maxDataLength()     // Catch: java.lang.Throwable -> L56
            int r3 = java.lang.Math.min(r4, r3)     // Catch: java.lang.Throwable -> L56
            long r4 = r8.f41879j     // Catch: java.lang.Throwable -> L56
            long r6 = (long) r3     // Catch: java.lang.Throwable -> L56
            long r4 = r4 - r6
            r8.f41879j = r4     // Catch: java.lang.Throwable -> L56
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L56
            long r12 = r12 - r6
            com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.Http2Writer r4 = r8.f41884o
            if (r10 == 0) goto L51
            int r5 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r5 != 0) goto L51
            r5 = 1
            goto L52
        L51:
            r5 = 0
        L52:
            r4.data(r5, r9, r11, r3)
            goto Ld
        L56:
            r9 = move-exception
            goto L65
        L58:
            java.lang.Thread r9 = java.lang.Thread.currentThread()     // Catch: java.lang.Throwable -> L56
            r9.interrupt()     // Catch: java.lang.Throwable -> L56
            java.io.InterruptedIOException r9 = new java.io.InterruptedIOException     // Catch: java.lang.Throwable -> L56
            r9.<init>()     // Catch: java.lang.Throwable -> L56
            throw r9     // Catch: java.lang.Throwable -> L56
        L65:
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L56
            throw r9
        L67:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.Http2Connection.writeData(int, boolean, com.tencent.cloud.huiyansdkface.okio.Buffer, long):void");
    }
}
