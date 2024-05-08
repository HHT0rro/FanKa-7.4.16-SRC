package com.google.android.exoplayer2.source.rtsp;

import android.os.Handler;
import android.os.HandlerThread;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.source.rtsp.RtspMessageChannel;
import com.google.android.exoplayer2.source.rtsp.g;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.common.collect.ImmutableList;
import com.google.common.primitives.Ints;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* compiled from: RtspMessageChannel.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class g implements Closeable {

    /* renamed from: h, reason: collision with root package name */
    public static final Charset f21974h = com.google.common.base.c.f25961c;

    /* renamed from: b, reason: collision with root package name */
    public final d f21975b;

    /* renamed from: c, reason: collision with root package name */
    public final Loader f21976c = new Loader("ExoPlayer:RtspMessageChannel:ReceiverLoader");

    /* renamed from: d, reason: collision with root package name */
    public final Map<Integer, b> f21977d = Collections.synchronizedMap(new HashMap());

    /* renamed from: e, reason: collision with root package name */
    public C0203g f21978e;

    /* renamed from: f, reason: collision with root package name */
    public Socket f21979f;

    /* renamed from: g, reason: collision with root package name */
    public volatile boolean f21980g;

    /* compiled from: RtspMessageChannel.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface b {
        void n(byte[] bArr);
    }

    /* compiled from: RtspMessageChannel.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public final class c implements Loader.b<f> {
        public c() {
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void n(f fVar, long j10, long j11, boolean z10) {
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void o(f fVar, long j10, long j11) {
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.b
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Loader.c q(f fVar, long j10, long j11, IOException iOException, int i10) {
            if (!g.this.f21980g) {
                g.this.f21975b.c(iOException);
            }
            return Loader.f22732f;
        }
    }

    /* compiled from: RtspMessageChannel.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface d {
        void a(List<String> list, Exception exc);

        void b(List<String> list);

        void c(Exception exc);
    }

    /* compiled from: RtspMessageChannel.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class e {

        /* renamed from: a, reason: collision with root package name */
        public final List<String> f21982a = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        @RtspMessageChannel.MessageParser.ReadingState
        public int f21983b = 1;

        /* renamed from: c, reason: collision with root package name */
        public long f21984c;

        public static byte[] d(byte b4, DataInputStream dataInputStream) throws IOException {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = {b4, dataInputStream.readByte()};
            byteArrayOutputStream.write(bArr);
            while (true) {
                if (bArr[0] == 13 && bArr[1] == 10) {
                    return byteArrayOutputStream.toByteArray();
                }
                bArr[0] = bArr[1];
                bArr[1] = dataInputStream.readByte();
                byteArrayOutputStream.write(bArr[1]);
            }
        }

        public final ImmutableList<String> a(byte[] bArr) {
            String str;
            com.google.android.exoplayer2.util.a.g(this.f21983b == 3);
            if (bArr.length > 0 && bArr[bArr.length - 1] == 10) {
                if (bArr.length > 1 && bArr[bArr.length - 2] == 13) {
                    str = new String(bArr, 0, bArr.length - 2, g.f21974h);
                } else {
                    str = new String(bArr, 0, bArr.length - 1, g.f21974h);
                }
                this.f21982a.add(str);
                ImmutableList<String> copyOf = ImmutableList.copyOf((Collection) this.f21982a);
                e();
                return copyOf;
            }
            throw new IllegalArgumentException("Message body is empty or does not end with a LF.");
        }

        @Nullable
        public final ImmutableList<String> b(byte[] bArr) throws ParserException {
            com.google.android.exoplayer2.util.a.a(bArr.length >= 2 && bArr[bArr.length - 2] == 13 && bArr[bArr.length - 1] == 10);
            String str = new String(bArr, 0, bArr.length - 2, g.f21974h);
            this.f21982a.add(str);
            int i10 = this.f21983b;
            if (i10 == 1) {
                if (!h.c(str)) {
                    return null;
                }
                this.f21983b = 2;
                return null;
            }
            if (i10 == 2) {
                long d10 = h.d(str);
                if (d10 != -1) {
                    this.f21984c = d10;
                }
                if (!str.isEmpty()) {
                    return null;
                }
                if (this.f21984c > 0) {
                    this.f21983b = 3;
                    return null;
                }
                ImmutableList<String> copyOf = ImmutableList.copyOf((Collection) this.f21982a);
                e();
                return copyOf;
            }
            throw new IllegalStateException();
        }

        public ImmutableList<String> c(byte b4, DataInputStream dataInputStream) throws IOException {
            ImmutableList<String> b10 = b(d(b4, dataInputStream));
            while (b10 == null) {
                if (this.f21983b == 3) {
                    long j10 = this.f21984c;
                    if (j10 > 0) {
                        int c4 = Ints.c(j10);
                        com.google.android.exoplayer2.util.a.g(c4 != -1);
                        byte[] bArr = new byte[c4];
                        dataInputStream.readFully(bArr, 0, c4);
                        b10 = a(bArr);
                    } else {
                        throw new IllegalStateException("Expects a greater than zero Content-Length.");
                    }
                } else {
                    b10 = b(d(dataInputStream.readByte(), dataInputStream));
                }
            }
            return b10;
        }

        public final void e() {
            this.f21982a.clear();
            this.f21983b = 1;
            this.f21984c = 0L;
        }
    }

    /* compiled from: RtspMessageChannel.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public final class f implements Loader.e {

        /* renamed from: a, reason: collision with root package name */
        public final DataInputStream f21985a;

        /* renamed from: b, reason: collision with root package name */
        public final e f21986b = new e();

        /* renamed from: c, reason: collision with root package name */
        public volatile boolean f21987c;

        public f(InputStream inputStream) {
            this.f21985a = new DataInputStream(inputStream);
        }

        public final void a() throws IOException {
            int readUnsignedByte = this.f21985a.readUnsignedByte();
            int readUnsignedShort = this.f21985a.readUnsignedShort();
            byte[] bArr = new byte[readUnsignedShort];
            this.f21985a.readFully(bArr, 0, readUnsignedShort);
            b bVar = (b) g.this.f21977d.get(Integer.valueOf(readUnsignedByte));
            if (bVar == null || g.this.f21980g) {
                return;
            }
            bVar.n(bArr);
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.e
        public void b() {
            this.f21987c = true;
        }

        public final void c(byte b4) throws IOException {
            if (g.this.f21980g) {
                return;
            }
            g.this.f21975b.b(this.f21986b.c(b4, this.f21985a));
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.e
        public void load() throws IOException {
            while (!this.f21987c) {
                byte readByte = this.f21985a.readByte();
                if (readByte == 36) {
                    a();
                } else {
                    c(readByte);
                }
            }
        }
    }

    /* compiled from: RtspMessageChannel.java */
    /* renamed from: com.google.android.exoplayer2.source.rtsp.g$g, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public final class C0203g implements Closeable {

        /* renamed from: b, reason: collision with root package name */
        public final OutputStream f21989b;

        /* renamed from: c, reason: collision with root package name */
        public final HandlerThread f21990c;

        /* renamed from: d, reason: collision with root package name */
        public final Handler f21991d;

        public C0203g(OutputStream outputStream) {
            this.f21989b = outputStream;
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:RtspMessageChannel:Sender");
            this.f21990c = handlerThread;
            handlerThread.start();
            this.f21991d = new Handler(handlerThread.getLooper());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(byte[] bArr, List list) {
            try {
                this.f21989b.write(bArr);
            } catch (Exception e2) {
                if (g.this.f21980g) {
                    return;
                }
                g.this.f21975b.a(list, e2);
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            Handler handler = this.f21991d;
            final HandlerThread handlerThread = this.f21990c;
            Objects.requireNonNull(handlerThread);
            handler.post(new Runnable() { // from class: b6.r
                @Override // java.lang.Runnable
                public final void run() {
                    handlerThread.quit();
                }
            });
            try {
                this.f21990c.join();
            } catch (InterruptedException unused) {
                this.f21990c.interrupt();
            }
        }

        public void d(final List<String> list) {
            final byte[] a10 = h.a(list);
            this.f21991d.post(new Runnable() { // from class: b6.s
                @Override // java.lang.Runnable
                public final void run() {
                    g.C0203g.this.b(a10, list);
                }
            });
        }
    }

    public g(d dVar) {
        this.f21975b = dVar;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f21980g) {
            return;
        }
        try {
            C0203g c0203g = this.f21978e;
            if (c0203g != null) {
                c0203g.close();
            }
            this.f21976c.l();
            Socket socket = this.f21979f;
            if (socket != null) {
                socket.close();
            }
        } finally {
            this.f21980g = true;
        }
    }

    public void e(Socket socket) throws IOException {
        this.f21979f = socket;
        this.f21978e = new C0203g(socket.getOutputStream());
        this.f21976c.n(new f(socket.getInputStream()), new c(), 0);
    }

    public void f(int i10, b bVar) {
        this.f21977d.put(Integer.valueOf(i10), bVar);
    }

    public void g(List<String> list) {
        com.google.android.exoplayer2.util.a.i(this.f21978e);
        this.f21978e.d(list);
    }
}
