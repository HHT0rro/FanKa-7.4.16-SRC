package com.tencent.cloud.huiyansdkface.okhttp3.internal.cache2;

import com.tencent.cloud.huiyansdkface.okhttp3.internal.Util;
import com.tencent.cloud.huiyansdkface.okio.Buffer;
import com.tencent.cloud.huiyansdkface.okio.ByteString;
import com.tencent.cloud.huiyansdkface.okio.Source;
import com.tencent.cloud.huiyansdkface.okio.Timeout;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final class Relay {

    /* renamed from: a, reason: collision with root package name */
    public static final ByteString f41690a = ByteString.encodeUtf8("OkHttp cache v1\n");

    /* renamed from: b, reason: collision with root package name */
    public static final ByteString f41691b = ByteString.encodeUtf8("OkHttp DIRTY :(\n");

    /* renamed from: c, reason: collision with root package name */
    public RandomAccessFile f41692c;

    /* renamed from: d, reason: collision with root package name */
    public Thread f41693d;

    /* renamed from: e, reason: collision with root package name */
    public Source f41694e;

    /* renamed from: g, reason: collision with root package name */
    public long f41696g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f41697h;

    /* renamed from: j, reason: collision with root package name */
    public final long f41699j;

    /* renamed from: k, reason: collision with root package name */
    public int f41700k;

    /* renamed from: l, reason: collision with root package name */
    private final ByteString f41701l;

    /* renamed from: f, reason: collision with root package name */
    public final Buffer f41695f = new Buffer();

    /* renamed from: i, reason: collision with root package name */
    public final Buffer f41698i = new Buffer();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class RelaySource implements Source {

        /* renamed from: b, reason: collision with root package name */
        private final Timeout f41703b = new Timeout();

        /* renamed from: c, reason: collision with root package name */
        private FileOperator f41704c;

        /* renamed from: d, reason: collision with root package name */
        private long f41705d;

        public RelaySource() {
            this.f41704c = new FileOperator(Relay.this.f41692c.getChannel());
        }

        @Override // com.tencent.cloud.huiyansdkface.okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f41704c == null) {
                return;
            }
            RandomAccessFile randomAccessFile = null;
            this.f41704c = null;
            synchronized (Relay.this) {
                Relay relay = Relay.this;
                int i10 = relay.f41700k - 1;
                relay.f41700k = i10;
                if (i10 == 0) {
                    RandomAccessFile randomAccessFile2 = relay.f41692c;
                    relay.f41692c = null;
                    randomAccessFile = randomAccessFile2;
                }
            }
            if (randomAccessFile != null) {
                Util.closeQuietly(randomAccessFile);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0043, code lost:
        
            if (r0 != 2) goto L26;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x0045, code lost:
        
            r2 = java.lang.Math.min(r23, r7 - r21.f41705d);
            r21.f41704c.read(r21.f41705d + 32, r22, r2);
            r21.f41705d += r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x005d, code lost:
        
            return r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x005f, code lost:
        
            r0 = r21.f41702a;
            r12 = r0.f41694e.read(r0.f41695f, r0.f41699j);
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x006d, code lost:
        
            if (r12 != (-1)) goto L38;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x006f, code lost:
        
            r21.f41702a.a(r7);
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x0074, code lost:
        
            r2 = r21.f41702a;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0076, code lost:
        
            monitor-enter(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0077, code lost:
        
            r0 = r21.f41702a;
            r0.f41693d = null;
            r0.notifyAll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x007e, code lost:
        
            monitor-exit(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x007f, code lost:
        
            return -1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x0083, code lost:
        
            r2 = java.lang.Math.min(r12, r23);
            r21.f41702a.f41695f.copyTo(r22, 0, r2);
            r21.f41705d += r2;
            r21.f41704c.write(r7 + 32, r21.f41702a.f41695f.m2929clone(), r12);
            r4 = r21.f41702a;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x00ac, code lost:
        
            monitor-enter(r4);
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x00ad, code lost:
        
            r0 = r21.f41702a;
            r0.f41698i.write(r0.f41695f, r12);
            r7 = r21.f41702a.f41698i.size();
            r0 = r21.f41702a;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x00c4, code lost:
        
            if (r7 <= r0.f41699j) goto L43;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x00c6, code lost:
        
            r0 = r0.f41698i;
            r0.skip(r0.size() - r21.f41702a.f41699j);
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x00d4, code lost:
        
            r5 = r21.f41702a;
            r5.f41696g += r12;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x00db, code lost:
        
            monitor-exit(r4);
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x00dc, code lost:
        
            monitor-enter(r5);
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x00dd, code lost:
        
            r0 = r21.f41702a;
            r0.f41693d = null;
            r0.notifyAll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x00e4, code lost:
        
            monitor-exit(r5);
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x00e5, code lost:
        
            return r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x00ec, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x00ef, code lost:
        
            monitor-enter(r21.f41702a);
         */
        /* JADX WARN: Code restructure failed: missing block: B:62:0x00f0, code lost:
        
            r3 = r21.f41702a;
            r3.f41693d = null;
            r3.notifyAll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:64:0x00f8, code lost:
        
            throw r0;
         */
        @Override // com.tencent.cloud.huiyansdkface.okio.Source
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public long read(com.tencent.cloud.huiyansdkface.okio.Buffer r22, long r23) throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 289
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.cloud.huiyansdkface.okhttp3.internal.cache2.Relay.RelaySource.read(com.tencent.cloud.huiyansdkface.okio.Buffer, long):long");
        }

        @Override // com.tencent.cloud.huiyansdkface.okio.Source
        public Timeout timeout() {
            return this.f41703b;
        }
    }

    private Relay(RandomAccessFile randomAccessFile, Source source, long j10, ByteString byteString, long j11) {
        this.f41692c = randomAccessFile;
        this.f41694e = source;
        this.f41697h = source == null;
        this.f41696g = j10;
        this.f41701l = byteString;
        this.f41699j = j11;
    }

    private void a(ByteString byteString, long j10, long j11) throws IOException {
        Buffer buffer = new Buffer();
        buffer.write(byteString);
        buffer.writeLong(j10);
        buffer.writeLong(j11);
        if (buffer.size() != 32) {
            throw new IllegalArgumentException();
        }
        new FileOperator(this.f41692c.getChannel()).write(0L, buffer, 32L);
    }

    private void b(long j10) throws IOException {
        Buffer buffer = new Buffer();
        buffer.write(this.f41701l);
        new FileOperator(this.f41692c.getChannel()).write(32 + j10, buffer, this.f41701l.size());
    }

    public static Relay edit(File file, Source source, ByteString byteString, long j10) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        Relay relay = new Relay(randomAccessFile, source, 0L, byteString, j10);
        randomAccessFile.setLength(0L);
        relay.a(f41691b, -1L, -1L);
        return relay;
    }

    public static Relay read(File file) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        FileOperator fileOperator = new FileOperator(randomAccessFile.getChannel());
        Buffer buffer = new Buffer();
        fileOperator.read(0L, buffer, 32L);
        if (!buffer.readByteString(r2.size()).equals(f41690a)) {
            throw new IOException("unreadable cache file");
        }
        long readLong = buffer.readLong();
        long readLong2 = buffer.readLong();
        Buffer buffer2 = new Buffer();
        fileOperator.read(readLong + 32, buffer2, readLong2);
        return new Relay(randomAccessFile, null, readLong, buffer2.readByteString(), 0L);
    }

    public void a(long j10) throws IOException {
        b(j10);
        this.f41692c.getChannel().force(false);
        a(f41690a, j10, this.f41701l.size());
        this.f41692c.getChannel().force(false);
        synchronized (this) {
            this.f41697h = true;
        }
        Util.closeQuietly(this.f41694e);
        this.f41694e = null;
    }

    public ByteString metadata() {
        return this.f41701l;
    }

    public Source newSource() {
        synchronized (this) {
            if (this.f41692c == null) {
                return null;
            }
            this.f41700k++;
            return new RelaySource();
        }
    }
}
