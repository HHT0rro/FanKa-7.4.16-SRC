package com.tencent.cloud.huiyansdkface.okhttp3.internal.ws;

import com.tencent.cloud.huiyansdkface.okhttp3.Call;
import com.tencent.cloud.huiyansdkface.okhttp3.Callback;
import com.tencent.cloud.huiyansdkface.okhttp3.EventListener;
import com.tencent.cloud.huiyansdkface.okhttp3.OkHttpClient;
import com.tencent.cloud.huiyansdkface.okhttp3.Protocol;
import com.tencent.cloud.huiyansdkface.okhttp3.Request;
import com.tencent.cloud.huiyansdkface.okhttp3.Response;
import com.tencent.cloud.huiyansdkface.okhttp3.WebSocket;
import com.tencent.cloud.huiyansdkface.okhttp3.WebSocketListener;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.Internal;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.Util;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.connection.StreamAllocation;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.ws.WebSocketReader;
import com.tencent.cloud.huiyansdkface.okio.BufferedSink;
import com.tencent.cloud.huiyansdkface.okio.BufferedSource;
import com.tencent.cloud.huiyansdkface.okio.ByteString;
import com.tencent.cloud.huiyansdkface.okio.Okio;
import com.tencent.connect.common.Constants;
import com.wangmai.okhttp.model.HttpHeaders;
import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class RealWebSocket implements WebSocket, WebSocketReader.FrameCallback {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ boolean f42023b = true;

    /* renamed from: c, reason: collision with root package name */
    private static final List<Protocol> f42024c = Collections.singletonList(Protocol.HTTP_1_1);

    /* renamed from: a, reason: collision with root package name */
    public final WebSocketListener f42025a;

    /* renamed from: d, reason: collision with root package name */
    private final Request f42026d;

    /* renamed from: e, reason: collision with root package name */
    private final Random f42027e;

    /* renamed from: f, reason: collision with root package name */
    private final long f42028f;

    /* renamed from: g, reason: collision with root package name */
    private final String f42029g;

    /* renamed from: h, reason: collision with root package name */
    private Call f42030h;

    /* renamed from: i, reason: collision with root package name */
    private final Runnable f42031i;

    /* renamed from: j, reason: collision with root package name */
    private WebSocketReader f42032j;

    /* renamed from: k, reason: collision with root package name */
    private WebSocketWriter f42033k;

    /* renamed from: l, reason: collision with root package name */
    private ScheduledExecutorService f42034l;

    /* renamed from: m, reason: collision with root package name */
    private Streams f42035m;

    /* renamed from: p, reason: collision with root package name */
    private long f42038p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f42039q;

    /* renamed from: r, reason: collision with root package name */
    private ScheduledFuture<?> f42040r;

    /* renamed from: t, reason: collision with root package name */
    private String f42042t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f42043u;

    /* renamed from: v, reason: collision with root package name */
    private int f42044v;

    /* renamed from: w, reason: collision with root package name */
    private int f42045w;

    /* renamed from: x, reason: collision with root package name */
    private int f42046x;

    /* renamed from: y, reason: collision with root package name */
    private boolean f42047y;

    /* renamed from: n, reason: collision with root package name */
    private final ArrayDeque<ByteString> f42036n = new ArrayDeque<>();

    /* renamed from: o, reason: collision with root package name */
    private final ArrayDeque<Object> f42037o = new ArrayDeque<>();

    /* renamed from: s, reason: collision with root package name */
    private int f42041s = -1;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public final class CancelRunnable implements Runnable {
        public CancelRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RealWebSocket.this.cancel();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class Close {

        /* renamed from: a, reason: collision with root package name */
        public final int f42052a;

        /* renamed from: b, reason: collision with root package name */
        public final ByteString f42053b;

        /* renamed from: c, reason: collision with root package name */
        public final long f42054c;

        public Close(int i10, ByteString byteString, long j10) {
            this.f42052a = i10;
            this.f42053b = byteString;
            this.f42054c = j10;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class Message {

        /* renamed from: a, reason: collision with root package name */
        public final int f42055a;

        /* renamed from: b, reason: collision with root package name */
        public final ByteString f42056b;

        public Message(int i10, ByteString byteString) {
            this.f42055a = i10;
            this.f42056b = byteString;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public final class PingRunnable implements Runnable {
        public PingRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RealWebSocket.this.b();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static abstract class Streams implements Closeable {

        /* renamed from: c, reason: collision with root package name */
        public final boolean f42058c;

        /* renamed from: d, reason: collision with root package name */
        public final BufferedSource f42059d;

        /* renamed from: e, reason: collision with root package name */
        public final BufferedSink f42060e;

        public Streams(boolean z10, BufferedSource bufferedSource, BufferedSink bufferedSink) {
            this.f42058c = z10;
            this.f42059d = bufferedSource;
            this.f42060e = bufferedSink;
        }
    }

    public RealWebSocket(Request request, WebSocketListener webSocketListener, Random random, long j10) {
        if (!"GET".equals(request.method())) {
            throw new IllegalArgumentException("Request must be GET: " + request.method());
        }
        this.f42026d = request;
        this.f42025a = webSocketListener;
        this.f42027e = random;
        this.f42028f = j10;
        byte[] bArr = new byte[16];
        random.nextBytes(bArr);
        this.f42029g = ByteString.of(bArr).base64();
        this.f42031i = new Runnable() { // from class: com.tencent.cloud.huiyansdkface.okhttp3.internal.ws.RealWebSocket.1
            @Override // java.lang.Runnable
            public void run() {
                do {
                    try {
                    } catch (IOException e2) {
                        RealWebSocket.this.failWebSocket(e2, null);
                        return;
                    }
                } while (RealWebSocket.this.a());
            }
        };
    }

    private synchronized boolean a(ByteString byteString, int i10) {
        if (!this.f42043u && !this.f42039q) {
            if (this.f42038p + byteString.size() > 16777216) {
                close(1001, null);
                return false;
            }
            this.f42038p += byteString.size();
            this.f42037o.add(new Message(i10, byteString));
            c();
            return true;
        }
        return false;
    }

    private void c() {
        if (!f42023b && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        ScheduledExecutorService scheduledExecutorService = this.f42034l;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.execute(this.f42031i);
        }
    }

    public void a(Response response) throws ProtocolException {
        if (response.code() != 101) {
            throw new ProtocolException("Expected HTTP 101 response but was '" + response.code() + " " + response.message() + "'");
        }
        String header = response.header(HttpHeaders.HEAD_KEY_CONNECTION);
        if (!"Upgrade".equalsIgnoreCase(header)) {
            throw new ProtocolException("Expected 'Connection' header value 'Upgrade' but was '" + header + "'");
        }
        String header2 = response.header("Upgrade");
        if (!"websocket".equalsIgnoreCase(header2)) {
            throw new ProtocolException("Expected 'Upgrade' header value 'websocket' but was '" + header2 + "'");
        }
        String header3 = response.header("Sec-WebSocket-Accept");
        String base64 = ByteString.encodeUtf8(this.f42029g + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").sha1().base64();
        if (base64.equals(header3)) {
            return;
        }
        throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + base64 + "' but was '" + header3 + "'");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v9 */
    public boolean a() throws IOException {
        Streams streams;
        String str;
        synchronized (this) {
            if (this.f42043u) {
                return false;
            }
            WebSocketWriter webSocketWriter = this.f42033k;
            ByteString poll = this.f42036n.poll();
            int i10 = -1;
            Message message = 0;
            if (poll == null) {
                Object poll2 = this.f42037o.poll();
                if (poll2 instanceof Close) {
                    int i11 = this.f42041s;
                    str = this.f42042t;
                    if (i11 != -1) {
                        Streams streams2 = this.f42035m;
                        this.f42035m = null;
                        this.f42034l.shutdown();
                        message = poll2;
                        i10 = i11;
                        streams = streams2;
                    } else {
                        this.f42040r = this.f42034l.schedule(new CancelRunnable(), ((Close) poll2).f42054c, TimeUnit.MILLISECONDS);
                        i10 = i11;
                        streams = null;
                    }
                } else {
                    if (poll2 == null) {
                        return false;
                    }
                    streams = null;
                    str = null;
                }
                message = poll2;
            } else {
                streams = null;
                str = null;
            }
            try {
                if (poll != null) {
                    webSocketWriter.b(poll);
                } else if (message instanceof Message) {
                    ByteString byteString = message.f42056b;
                    BufferedSink buffer = Okio.buffer(webSocketWriter.a(message.f42055a, byteString.size()));
                    buffer.write(byteString);
                    buffer.close();
                    synchronized (this) {
                        this.f42038p -= byteString.size();
                    }
                } else {
                    if (!(message instanceof Close)) {
                        throw new AssertionError();
                    }
                    Close close = (Close) message;
                    webSocketWriter.a(close.f42052a, close.f42053b);
                    if (streams != null) {
                        this.f42025a.onClosed(this, i10, str);
                    }
                }
                return true;
            } finally {
                Util.closeQuietly(streams);
            }
        }
    }

    public synchronized boolean a(int i10, String str, long j10) {
        WebSocketProtocol.b(i10);
        ByteString byteString = null;
        if (str != null) {
            byteString = ByteString.encodeUtf8(str);
            if (byteString.size() > 123) {
                throw new IllegalArgumentException("reason.size() > 123: " + str);
            }
        }
        if (!this.f42043u && !this.f42039q) {
            this.f42039q = true;
            this.f42037o.add(new Close(i10, byteString, j10));
            c();
            return true;
        }
        return false;
    }

    public void b() {
        synchronized (this) {
            if (this.f42043u) {
                return;
            }
            WebSocketWriter webSocketWriter = this.f42033k;
            int i10 = this.f42047y ? this.f42044v : -1;
            this.f42044v++;
            this.f42047y = true;
            if (i10 == -1) {
                try {
                    webSocketWriter.a(ByteString.EMPTY);
                    return;
                } catch (IOException e2) {
                    failWebSocket(e2, null);
                    return;
                }
            }
            failWebSocket(new SocketTimeoutException("sent ping but didn't receive pong within " + this.f42028f + "ms (after " + (i10 - 1) + " successful ping/pongs)"), null);
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.WebSocket
    public void cancel() {
        this.f42030h.cancel();
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.WebSocket
    public boolean close(int i10, String str) {
        return a(i10, str, 60000L);
    }

    public void connect(OkHttpClient okHttpClient) {
        OkHttpClient build = okHttpClient.newBuilder().eventListener(EventListener.f41398a).protocols(f42024c).build();
        final Request build2 = this.f42026d.newBuilder().header("Upgrade", "websocket").header(HttpHeaders.HEAD_KEY_CONNECTION, "Upgrade").header("Sec-WebSocket-Key", this.f42029g).header("Sec-WebSocket-Version", Constants.VIA_REPORT_TYPE_JOININ_GROUP).build();
        Call newWebSocketCall = Internal.f41598a.newWebSocketCall(build, build2);
        this.f42030h = newWebSocketCall;
        newWebSocketCall.timeout().clearTimeout();
        this.f42030h.enqueue(new Callback() { // from class: com.tencent.cloud.huiyansdkface.okhttp3.internal.ws.RealWebSocket.2
            @Override // com.tencent.cloud.huiyansdkface.okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                RealWebSocket.this.failWebSocket(iOException, null);
            }

            @Override // com.tencent.cloud.huiyansdkface.okhttp3.Callback
            public void onResponse(Call call, Response response) {
                try {
                    RealWebSocket.this.a(response);
                    StreamAllocation streamAllocation = Internal.f41598a.streamAllocation(call);
                    streamAllocation.noNewStreams();
                    Streams newWebSocketStreams = streamAllocation.connection().newWebSocketStreams(streamAllocation);
                    try {
                        RealWebSocket realWebSocket = RealWebSocket.this;
                        realWebSocket.f42025a.onOpen(realWebSocket, response);
                        RealWebSocket.this.initReaderAndWriter("OkHttp WebSocket " + build2.url().redact(), newWebSocketStreams);
                        streamAllocation.connection().socket().setSoTimeout(0);
                        RealWebSocket.this.loopReader();
                    } catch (Exception e2) {
                        RealWebSocket.this.failWebSocket(e2, null);
                    }
                } catch (ProtocolException e10) {
                    RealWebSocket.this.failWebSocket(e10, response);
                    Util.closeQuietly(response);
                }
            }
        });
    }

    public void failWebSocket(Exception exc, Response response) {
        synchronized (this) {
            if (this.f42043u) {
                return;
            }
            this.f42043u = true;
            Streams streams = this.f42035m;
            this.f42035m = null;
            ScheduledFuture<?> scheduledFuture = this.f42040r;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            ScheduledExecutorService scheduledExecutorService = this.f42034l;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdown();
            }
            try {
                this.f42025a.onFailure(this, exc, response);
            } finally {
                Util.closeQuietly(streams);
            }
        }
    }

    public void initReaderAndWriter(String str, Streams streams) throws IOException {
        synchronized (this) {
            this.f42035m = streams;
            this.f42033k = new WebSocketWriter(streams.f42058c, streams.f42060e, this.f42027e);
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, Util.threadFactory(str, false));
            this.f42034l = scheduledThreadPoolExecutor;
            if (this.f42028f != 0) {
                PingRunnable pingRunnable = new PingRunnable();
                long j10 = this.f42028f;
                scheduledThreadPoolExecutor.scheduleAtFixedRate(pingRunnable, j10, j10, TimeUnit.MILLISECONDS);
            }
            if (!this.f42037o.isEmpty()) {
                c();
            }
        }
        this.f42032j = new WebSocketReader(streams.f42058c, streams.f42059d, this);
    }

    public void loopReader() throws IOException {
        while (this.f42041s == -1) {
            this.f42032j.a();
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadClose(int i10, String str) {
        Streams streams;
        if (i10 == -1) {
            throw new IllegalArgumentException();
        }
        synchronized (this) {
            if (this.f42041s != -1) {
                throw new IllegalStateException("already closed");
            }
            this.f42041s = i10;
            this.f42042t = str;
            streams = null;
            if (this.f42039q && this.f42037o.isEmpty()) {
                Streams streams2 = this.f42035m;
                this.f42035m = null;
                ScheduledFuture<?> scheduledFuture = this.f42040r;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(false);
                }
                this.f42034l.shutdown();
                streams = streams2;
            }
        }
        try {
            this.f42025a.onClosing(this, i10, str);
            if (streams != null) {
                this.f42025a.onClosed(this, i10, str);
            }
        } finally {
            Util.closeQuietly(streams);
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadMessage(ByteString byteString) throws IOException {
        this.f42025a.onMessage(this, byteString);
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadMessage(String str) throws IOException {
        this.f42025a.onMessage(this, str);
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.ws.WebSocketReader.FrameCallback
    public synchronized void onReadPing(ByteString byteString) {
        if (!this.f42043u && (!this.f42039q || !this.f42037o.isEmpty())) {
            this.f42036n.add(byteString);
            c();
            this.f42045w++;
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.ws.WebSocketReader.FrameCallback
    public synchronized void onReadPong(ByteString byteString) {
        this.f42046x++;
        this.f42047y = false;
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.WebSocket
    public synchronized long queueSize() {
        return this.f42038p;
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.WebSocket
    public Request request() {
        return this.f42026d;
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.WebSocket
    public boolean send(ByteString byteString) {
        Objects.requireNonNull(byteString, "bytes == null");
        return a(byteString, 2);
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.WebSocket
    public boolean send(String str) {
        Objects.requireNonNull(str, "text == null");
        return a(ByteString.encodeUtf8(str), 1);
    }
}
