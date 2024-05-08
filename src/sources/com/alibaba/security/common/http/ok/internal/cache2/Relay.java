package com.alibaba.security.common.http.ok.internal.cache2;

import com.alibaba.security.common.http.ok.internal.Util;
import com.alibaba.security.common.http.okio.Buffer;
import com.alibaba.security.common.http.okio.ByteString;
import com.alibaba.security.common.http.okio.Source;
import com.alibaba.security.common.http.okio.Timeout;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
final class Relay {
    private static final long FILE_HEADER_SIZE = 32;
    public static final ByteString PREFIX_CLEAN = ByteString.encodeUtf8("OkHttp cache v1\n");
    public static final ByteString PREFIX_DIRTY = ByteString.encodeUtf8("OkHttp DIRTY :(\n");
    private static final int SOURCE_FILE = 2;
    private static final int SOURCE_UPSTREAM = 1;
    public final long bufferMaxSize;
    public boolean complete;
    public RandomAccessFile file;
    private final ByteString metadata;
    public int sourceCount;
    public Source upstream;
    public long upstreamPos;
    public Thread upstreamReader;
    public final Buffer upstreamBuffer = new Buffer();
    public final Buffer buffer = new Buffer();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class RelaySource implements Source {
        private FileOperator fileOperator;
        private long sourcePos;
        private final Timeout timeout = new Timeout();

        public RelaySource() {
            this.fileOperator = new FileOperator(Relay.this.file.getChannel());
        }

        @Override // com.alibaba.security.common.http.okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.fileOperator == null) {
                return;
            }
            RandomAccessFile randomAccessFile = null;
            this.fileOperator = null;
            synchronized (Relay.this) {
                Relay relay = Relay.this;
                int i10 = relay.sourceCount - 1;
                relay.sourceCount = i10;
                if (i10 == 0) {
                    RandomAccessFile randomAccessFile2 = relay.file;
                    relay.file = null;
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
        
            r2 = java.lang.Math.min(r23, r7 - r21.sourcePos);
            r21.fileOperator.read(r21.sourcePos + 32, r22, r2);
            r21.sourcePos += r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x005d, code lost:
        
            return r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x005f, code lost:
        
            r0 = r21.this$0;
            r12 = r0.upstream.read(r0.upstreamBuffer, r0.bufferMaxSize);
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x006d, code lost:
        
            if (r12 != (-1)) goto L38;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x006f, code lost:
        
            r21.this$0.commit(r7);
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x0074, code lost:
        
            r2 = r21.this$0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0076, code lost:
        
            monitor-enter(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0077, code lost:
        
            r0 = r21.this$0;
            r0.upstreamReader = null;
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
            r21.this$0.upstreamBuffer.copyTo(r22, 0, r2);
            r21.sourcePos += r2;
            r21.fileOperator.write(r7 + 32, r21.this$0.upstreamBuffer.m1765clone(), r12);
            r4 = r21.this$0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x00ac, code lost:
        
            monitor-enter(r4);
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x00ad, code lost:
        
            r0 = r21.this$0;
            r0.buffer.write(r0.upstreamBuffer, r12);
            r7 = r21.this$0.buffer.size();
            r0 = r21.this$0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x00c4, code lost:
        
            if (r7 <= r0.bufferMaxSize) goto L43;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x00c6, code lost:
        
            r0 = r0.buffer;
            r0.skip(r0.size() - r21.this$0.bufferMaxSize);
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x00d4, code lost:
        
            r5 = r21.this$0;
            r5.upstreamPos += r12;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x00db, code lost:
        
            monitor-exit(r4);
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x00dc, code lost:
        
            monitor-enter(r5);
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x00dd, code lost:
        
            r0 = r21.this$0;
            r0.upstreamReader = null;
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
        
            monitor-enter(r21.this$0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:62:0x00f0, code lost:
        
            r3 = r21.this$0;
            r3.upstreamReader = null;
            r3.notifyAll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:64:0x00f8, code lost:
        
            throw r0;
         */
        @Override // com.alibaba.security.common.http.okio.Source
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public long read(com.alibaba.security.common.http.okio.Buffer r22, long r23) throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 289
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.security.common.http.ok.internal.cache2.Relay.RelaySource.read(com.alibaba.security.common.http.okio.Buffer, long):long");
        }

        @Override // com.alibaba.security.common.http.okio.Source
        public Timeout timeout() {
            return this.timeout;
        }
    }

    private Relay(RandomAccessFile randomAccessFile, Source source, long j10, ByteString byteString, long j11) {
        this.file = randomAccessFile;
        this.upstream = source;
        this.complete = source == null;
        this.upstreamPos = j10;
        this.metadata = byteString;
        this.bufferMaxSize = j11;
    }

    public static Relay edit(File file, Source source, ByteString byteString, long j10) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        Relay relay = new Relay(randomAccessFile, source, 0L, byteString, j10);
        randomAccessFile.setLength(0L);
        relay.writeHeader(PREFIX_DIRTY, -1L, -1L);
        return relay;
    }

    public static Relay read(File file) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        FileOperator fileOperator = new FileOperator(randomAccessFile.getChannel());
        Buffer buffer = new Buffer();
        fileOperator.read(0L, buffer, 32L);
        if (buffer.readByteString(r2.size()).equals(PREFIX_CLEAN)) {
            long readLong = buffer.readLong();
            long readLong2 = buffer.readLong();
            Buffer buffer2 = new Buffer();
            fileOperator.read(readLong + 32, buffer2, readLong2);
            return new Relay(randomAccessFile, null, readLong, buffer2.readByteString(), 0L);
        }
        throw new IOException("unreadable cache file");
    }

    private void writeHeader(ByteString byteString, long j10, long j11) throws IOException {
        Buffer buffer = new Buffer();
        buffer.write(byteString);
        buffer.writeLong(j10);
        buffer.writeLong(j11);
        if (buffer.size() == 32) {
            new FileOperator(this.file.getChannel()).write(0L, buffer, 32L);
            return;
        }
        throw new IllegalArgumentException();
    }

    private void writeMetadata(long j10) throws IOException {
        Buffer buffer = new Buffer();
        buffer.write(this.metadata);
        new FileOperator(this.file.getChannel()).write(32 + j10, buffer, this.metadata.size());
    }

    public void commit(long j10) throws IOException {
        writeMetadata(j10);
        this.file.getChannel().force(false);
        writeHeader(PREFIX_CLEAN, j10, this.metadata.size());
        this.file.getChannel().force(false);
        synchronized (this) {
            this.complete = true;
        }
        Util.closeQuietly(this.upstream);
        this.upstream = null;
    }

    public boolean isClosed() {
        return this.file == null;
    }

    public ByteString metadata() {
        return this.metadata;
    }

    public Source newSource() {
        synchronized (this) {
            if (this.file == null) {
                return null;
            }
            this.sourceCount++;
            return new RelaySource();
        }
    }
}
