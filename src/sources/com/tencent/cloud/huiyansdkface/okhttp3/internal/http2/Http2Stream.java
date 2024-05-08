package com.tencent.cloud.huiyansdkface.okhttp3.internal.http2;

import com.tencent.cloud.huiyansdkface.okhttp3.Headers;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.Util;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.Header;
import com.tencent.cloud.huiyansdkface.okio.AsyncTimeout;
import com.tencent.cloud.huiyansdkface.okio.Buffer;
import com.tencent.cloud.huiyansdkface.okio.BufferedSource;
import com.tencent.cloud.huiyansdkface.okio.Sink;
import com.tencent.cloud.huiyansdkface.okio.Source;
import com.tencent.cloud.huiyansdkface.okio.Timeout;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class Http2Stream {

    /* renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ boolean f41942i = true;

    /* renamed from: a, reason: collision with root package name */
    public long f41943a = 0;

    /* renamed from: b, reason: collision with root package name */
    public long f41944b;

    /* renamed from: c, reason: collision with root package name */
    public final int f41945c;

    /* renamed from: d, reason: collision with root package name */
    public final Http2Connection f41946d;

    /* renamed from: e, reason: collision with root package name */
    public final FramingSink f41947e;

    /* renamed from: f, reason: collision with root package name */
    public final StreamTimeout f41948f;

    /* renamed from: g, reason: collision with root package name */
    public final StreamTimeout f41949g;

    /* renamed from: h, reason: collision with root package name */
    public ErrorCode f41950h;

    /* renamed from: j, reason: collision with root package name */
    private final Deque<Headers> f41951j;

    /* renamed from: k, reason: collision with root package name */
    private Header.Listener f41952k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f41953l;

    /* renamed from: m, reason: collision with root package name */
    private final FramingSource f41954m;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public final class FramingSink implements Sink {

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ boolean f41955c = true;

        /* renamed from: a, reason: collision with root package name */
        public boolean f41956a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f41957b;

        /* renamed from: e, reason: collision with root package name */
        private final Buffer f41959e = new Buffer();

        public FramingSink() {
        }

        private void a(boolean z10) throws IOException {
            Http2Stream http2Stream;
            long min;
            Http2Stream http2Stream2;
            synchronized (Http2Stream.this) {
                Http2Stream.this.f41949g.enter();
                while (true) {
                    try {
                        http2Stream = Http2Stream.this;
                        if (http2Stream.f41944b > 0 || this.f41957b || this.f41956a || http2Stream.f41950h != null) {
                            break;
                        } else {
                            http2Stream.d();
                        }
                    } finally {
                    }
                }
                http2Stream.f41949g.exitAndThrowIfTimedOut();
                Http2Stream.this.c();
                min = Math.min(Http2Stream.this.f41944b, this.f41959e.size());
                http2Stream2 = Http2Stream.this;
                http2Stream2.f41944b -= min;
            }
            http2Stream2.f41949g.enter();
            try {
                Http2Stream http2Stream3 = Http2Stream.this;
                http2Stream3.f41946d.writeData(http2Stream3.f41945c, z10 && min == this.f41959e.size(), this.f41959e, min);
            } finally {
            }
        }

        @Override // com.tencent.cloud.huiyansdkface.okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (!f41955c && Thread.holdsLock(Http2Stream.this)) {
                throw new AssertionError();
            }
            synchronized (Http2Stream.this) {
                if (this.f41956a) {
                    return;
                }
                if (!Http2Stream.this.f41947e.f41957b) {
                    if (this.f41959e.size() > 0) {
                        while (this.f41959e.size() > 0) {
                            a(true);
                        }
                    } else {
                        Http2Stream http2Stream = Http2Stream.this;
                        http2Stream.f41946d.writeData(http2Stream.f41945c, true, null, 0L);
                    }
                }
                synchronized (Http2Stream.this) {
                    this.f41956a = true;
                }
                Http2Stream.this.f41946d.flush();
                Http2Stream.this.b();
            }
        }

        @Override // com.tencent.cloud.huiyansdkface.okio.Sink, java.io.Flushable
        public void flush() throws IOException {
            if (!f41955c && Thread.holdsLock(Http2Stream.this)) {
                throw new AssertionError();
            }
            synchronized (Http2Stream.this) {
                Http2Stream.this.c();
            }
            while (this.f41959e.size() > 0) {
                a(false);
                Http2Stream.this.f41946d.flush();
            }
        }

        @Override // com.tencent.cloud.huiyansdkface.okio.Sink
        public Timeout timeout() {
            return Http2Stream.this.f41949g;
        }

        @Override // com.tencent.cloud.huiyansdkface.okio.Sink
        public void write(Buffer buffer, long j10) throws IOException {
            if (!f41955c && Thread.holdsLock(Http2Stream.this)) {
                throw new AssertionError();
            }
            this.f41959e.write(buffer, j10);
            while (this.f41959e.size() >= 16384) {
                a(false);
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public final class FramingSource implements Source {

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ boolean f41960c = true;

        /* renamed from: a, reason: collision with root package name */
        public boolean f41961a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f41962b;

        /* renamed from: e, reason: collision with root package name */
        private final Buffer f41964e = new Buffer();

        /* renamed from: f, reason: collision with root package name */
        private final Buffer f41965f = new Buffer();

        /* renamed from: g, reason: collision with root package name */
        private final long f41966g;

        public FramingSource(long j10) {
            this.f41966g = j10;
        }

        private void a(long j10) {
            if (!f41960c && Thread.holdsLock(Http2Stream.this)) {
                throw new AssertionError();
            }
            Http2Stream.this.f41946d.a(j10);
        }

        public void a(BufferedSource bufferedSource, long j10) throws IOException {
            boolean z10;
            boolean z11;
            boolean z12;
            if (!f41960c && Thread.holdsLock(Http2Stream.this)) {
                throw new AssertionError();
            }
            while (j10 > 0) {
                synchronized (Http2Stream.this) {
                    z10 = this.f41962b;
                    z11 = true;
                    z12 = this.f41965f.size() + j10 > this.f41966g;
                }
                if (z12) {
                    bufferedSource.skip(j10);
                    Http2Stream.this.closeLater(ErrorCode.FLOW_CONTROL_ERROR);
                    return;
                }
                if (z10) {
                    bufferedSource.skip(j10);
                    return;
                }
                long read = bufferedSource.read(this.f41964e, j10);
                if (read == -1) {
                    throw new EOFException();
                }
                j10 -= read;
                synchronized (Http2Stream.this) {
                    if (this.f41965f.size() != 0) {
                        z11 = false;
                    }
                    this.f41965f.writeAll(this.f41964e);
                    if (z11) {
                        Http2Stream.this.notifyAll();
                    }
                }
            }
        }

        @Override // com.tencent.cloud.huiyansdkface.okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            long size;
            Header.Listener listener;
            ArrayList arrayList;
            synchronized (Http2Stream.this) {
                this.f41961a = true;
                size = this.f41965f.size();
                this.f41965f.clear();
                listener = null;
                if (Http2Stream.this.f41951j.isEmpty() || Http2Stream.this.f41952k == null) {
                    arrayList = null;
                } else {
                    ArrayList arrayList2 = new ArrayList(Http2Stream.this.f41951j);
                    Http2Stream.this.f41951j.clear();
                    listener = Http2Stream.this.f41952k;
                    arrayList = arrayList2;
                }
                Http2Stream.this.notifyAll();
            }
            if (size > 0) {
                a(size);
            }
            Http2Stream.this.b();
            if (listener != null) {
                Iterator iterator2 = arrayList.iterator2();
                while (iterator2.hasNext()) {
                    listener.onHeaders((Headers) iterator2.next());
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:61:0x00d3, code lost:
        
            throw new java.io.IOException("stream closed");
         */
        @Override // com.tencent.cloud.huiyansdkface.okio.Source
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public long read(com.tencent.cloud.huiyansdkface.okio.Buffer r17, long r18) throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 247
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.Http2Stream.FramingSource.read(com.tencent.cloud.huiyansdkface.okio.Buffer, long):long");
        }

        @Override // com.tencent.cloud.huiyansdkface.okio.Source
        public Timeout timeout() {
            return Http2Stream.this.f41948f;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class StreamTimeout extends AsyncTimeout {
        public StreamTimeout() {
        }

        public void exitAndThrowIfTimedOut() throws IOException {
            if (exit()) {
                throw newTimeoutException(null);
            }
        }

        @Override // com.tencent.cloud.huiyansdkface.okio.AsyncTimeout
        public IOException newTimeoutException(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        @Override // com.tencent.cloud.huiyansdkface.okio.AsyncTimeout
        public void timedOut() {
            Http2Stream.this.closeLater(ErrorCode.CANCEL);
        }
    }

    public Http2Stream(int i10, Http2Connection http2Connection, boolean z10, boolean z11, Headers headers) {
        ArrayDeque arrayDeque = new ArrayDeque();
        this.f41951j = arrayDeque;
        this.f41948f = new StreamTimeout();
        this.f41949g = new StreamTimeout();
        this.f41950h = null;
        Objects.requireNonNull(http2Connection, "connection == null");
        this.f41945c = i10;
        this.f41946d = http2Connection;
        this.f41944b = http2Connection.f41881l.d();
        FramingSource framingSource = new FramingSource(http2Connection.f41880k.d());
        this.f41954m = framingSource;
        FramingSink framingSink = new FramingSink();
        this.f41947e = framingSink;
        framingSource.f41962b = z11;
        framingSink.f41957b = z10;
        if (headers != null) {
            arrayDeque.add(headers);
        }
        if (isLocallyInitiated() && headers != null) {
            throw new IllegalStateException("locally-initiated streams shouldn't have headers yet");
        }
        if (!isLocallyInitiated() && headers == null) {
            throw new IllegalStateException("remotely-initiated streams should have headers");
        }
    }

    private boolean b(ErrorCode errorCode) {
        if (!f41942i && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            if (this.f41950h != null) {
                return false;
            }
            if (this.f41954m.f41962b && this.f41947e.f41957b) {
                return false;
            }
            this.f41950h = errorCode;
            notifyAll();
            this.f41946d.b(this.f41945c);
            return true;
        }
    }

    public void a() {
        boolean isOpen;
        if (!f41942i && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            this.f41954m.f41962b = true;
            isOpen = isOpen();
            notifyAll();
        }
        if (isOpen) {
            return;
        }
        this.f41946d.b(this.f41945c);
    }

    public void a(long j10) {
        this.f41944b += j10;
        if (j10 > 0) {
            notifyAll();
        }
    }

    public synchronized void a(ErrorCode errorCode) {
        if (this.f41950h == null) {
            this.f41950h = errorCode;
            notifyAll();
        }
    }

    public void a(BufferedSource bufferedSource, int i10) throws IOException {
        if (!f41942i && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        this.f41954m.a(bufferedSource, i10);
    }

    public void a(List<Header> list) {
        boolean isOpen;
        if (!f41942i && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            this.f41953l = true;
            this.f41951j.add(Util.toHeaders(list));
            isOpen = isOpen();
            notifyAll();
        }
        if (isOpen) {
            return;
        }
        this.f41946d.b(this.f41945c);
    }

    public void b() throws IOException {
        boolean z10;
        boolean isOpen;
        if (!f41942i && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            FramingSource framingSource = this.f41954m;
            if (!framingSource.f41962b && framingSource.f41961a) {
                FramingSink framingSink = this.f41947e;
                if (framingSink.f41957b || framingSink.f41956a) {
                    z10 = true;
                    isOpen = isOpen();
                }
            }
            z10 = false;
            isOpen = isOpen();
        }
        if (z10) {
            close(ErrorCode.CANCEL);
        } else {
            if (isOpen) {
                return;
            }
            this.f41946d.b(this.f41945c);
        }
    }

    public void c() throws IOException {
        FramingSink framingSink = this.f41947e;
        if (framingSink.f41956a) {
            throw new IOException("stream closed");
        }
        if (framingSink.f41957b) {
            throw new IOException("stream finished");
        }
        if (this.f41950h != null) {
            throw new StreamResetException(this.f41950h);
        }
    }

    public void close(ErrorCode errorCode) throws IOException {
        if (b(errorCode)) {
            this.f41946d.b(this.f41945c, errorCode);
        }
    }

    public void closeLater(ErrorCode errorCode) {
        if (b(errorCode)) {
            this.f41946d.a(this.f41945c, errorCode);
        }
    }

    public void d() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    public Http2Connection getConnection() {
        return this.f41946d;
    }

    public synchronized ErrorCode getErrorCode() {
        return this.f41950h;
    }

    public int getId() {
        return this.f41945c;
    }

    public Sink getSink() {
        synchronized (this) {
            if (!this.f41953l && !isLocallyInitiated()) {
                throw new IllegalStateException("reply before requesting the sink");
            }
        }
        return this.f41947e;
    }

    public Source getSource() {
        return this.f41954m;
    }

    public boolean isLocallyInitiated() {
        return this.f41946d.f41870a == ((this.f41945c & 1) == 1);
    }

    public synchronized boolean isOpen() {
        if (this.f41950h != null) {
            return false;
        }
        FramingSource framingSource = this.f41954m;
        if (framingSource.f41962b || framingSource.f41961a) {
            FramingSink framingSink = this.f41947e;
            if (framingSink.f41957b || framingSink.f41956a) {
                if (this.f41953l) {
                    return false;
                }
            }
        }
        return true;
    }

    public Timeout readTimeout() {
        return this.f41948f;
    }

    public synchronized void setHeadersListener(Header.Listener listener) {
        this.f41952k = listener;
        if (!this.f41951j.isEmpty() && listener != null) {
            notifyAll();
        }
    }

    public synchronized Headers takeHeaders() throws IOException {
        this.f41948f.enter();
        while (this.f41951j.isEmpty() && this.f41950h == null) {
            try {
                d();
            } catch (Throwable th) {
                this.f41948f.exitAndThrowIfTimedOut();
                throw th;
            }
        }
        this.f41948f.exitAndThrowIfTimedOut();
        if (this.f41951j.isEmpty()) {
            throw new StreamResetException(this.f41950h);
        }
        return this.f41951j.removeFirst();
    }

    public void writeHeaders(List<Header> list, boolean z10) throws IOException {
        boolean z11;
        boolean z12;
        boolean z13;
        if (!f41942i && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        Objects.requireNonNull(list, "headers == null");
        synchronized (this) {
            z11 = true;
            this.f41953l = true;
            if (z10) {
                z12 = false;
                z13 = false;
            } else {
                this.f41947e.f41957b = true;
                z12 = true;
                z13 = true;
            }
        }
        if (!z12) {
            synchronized (this.f41946d) {
                if (this.f41946d.f41879j != 0) {
                    z11 = false;
                }
            }
            z12 = z11;
        }
        this.f41946d.a(this.f41945c, z13, list);
        if (z12) {
            this.f41946d.flush();
        }
    }

    public Timeout writeTimeout() {
        return this.f41949g;
    }
}
