package com.alibaba.security.common.http.okio;

import com.huawei.appgallery.agd.common.constant.SymbolValues;
import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class InflaterSource implements Source {
    private int bufferBytesHeldByInflater;
    private boolean closed;
    private final Inflater inflater;
    private final BufferedSource source;

    public InflaterSource(Source source, Inflater inflater) {
        this(RPOkio.buffer(source), inflater);
    }

    private void releaseInflatedBytes() throws IOException {
        int i10 = this.bufferBytesHeldByInflater;
        if (i10 == 0) {
            return;
        }
        int remaining = i10 - this.inflater.getRemaining();
        this.bufferBytesHeldByInflater -= remaining;
        this.source.skip(remaining);
    }

    @Override // com.alibaba.security.common.http.okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closed) {
            return;
        }
        this.inflater.end();
        this.closed = true;
        this.source.close();
    }

    @Override // com.alibaba.security.common.http.okio.Source
    public long read(Buffer buffer, long j10) throws IOException {
        boolean refill;
        if (j10 >= 0) {
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            if (j10 == 0) {
                return 0L;
            }
            do {
                refill = refill();
                try {
                    Segment writableSegment = buffer.writableSegment(1);
                    int inflate = this.inflater.inflate(writableSegment.data, writableSegment.limit, (int) Math.min(j10, 8192 - writableSegment.limit));
                    if (inflate > 0) {
                        writableSegment.limit += inflate;
                        long j11 = inflate;
                        buffer.size += j11;
                        return j11;
                    }
                    if (!this.inflater.finished() && !this.inflater.needsDictionary()) {
                    }
                    releaseInflatedBytes();
                    if (writableSegment.pos != writableSegment.limit) {
                        return -1L;
                    }
                    buffer.head = writableSegment.pop();
                    SegmentPool.recycle(writableSegment);
                    return -1L;
                } catch (DataFormatException e2) {
                    throw new IOException(e2);
                }
            } while (!refill);
            throw new EOFException("source exhausted prematurely");
        }
        throw new IllegalArgumentException("byteCount < 0: " + j10);
    }

    public final boolean refill() throws IOException {
        if (!this.inflater.needsInput()) {
            return false;
        }
        releaseInflatedBytes();
        if (this.inflater.getRemaining() == 0) {
            if (this.source.exhausted()) {
                return true;
            }
            Segment segment = this.source.buffer().head;
            int i10 = segment.limit;
            int i11 = segment.pos;
            int i12 = i10 - i11;
            this.bufferBytesHeldByInflater = i12;
            this.inflater.setInput(segment.data, i11, i12);
            return false;
        }
        throw new IllegalStateException(SymbolValues.QUESTION_EN_SYMBOL);
    }

    @Override // com.alibaba.security.common.http.okio.Source
    public Timeout timeout() {
        return this.source.timeout();
    }

    public InflaterSource(BufferedSource bufferedSource, Inflater inflater) {
        if (bufferedSource == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (inflater != null) {
            this.source = bufferedSource;
            this.inflater = inflater;
            return;
        }
        throw new IllegalArgumentException("inflater == null");
    }
}
