package com.alibaba.security.common.http.okio;

import java.io.IOException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
final class PeekSource implements Source {
    private final Buffer buffer;
    private boolean closed;
    private int expectedPos;
    private Segment expectedSegment;
    private long pos;
    private final BufferedSource upstream;

    public PeekSource(BufferedSource bufferedSource) {
        this.upstream = bufferedSource;
        Buffer buffer = bufferedSource.buffer();
        this.buffer = buffer;
        Segment segment = buffer.head;
        this.expectedSegment = segment;
        this.expectedPos = segment != null ? segment.pos : -1;
    }

    @Override // com.alibaba.security.common.http.okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.closed = true;
    }

    @Override // com.alibaba.security.common.http.okio.Source
    public long read(Buffer buffer, long j10) throws IOException {
        Segment segment;
        Segment segment2;
        if (!this.closed) {
            Segment segment3 = this.expectedSegment;
            if (segment3 != null && (segment3 != (segment2 = this.buffer.head) || this.expectedPos != segment2.pos)) {
                throw new IllegalStateException("Peek source is invalid because upstream source was used");
            }
            this.upstream.request(this.pos + j10);
            if (this.expectedSegment == null && (segment = this.buffer.head) != null) {
                this.expectedSegment = segment;
                this.expectedPos = segment.pos;
            }
            long min = Math.min(j10, this.buffer.size - this.pos);
            if (min <= 0) {
                return -1L;
            }
            this.buffer.copyTo(buffer, this.pos, min);
            this.pos += min;
            return min;
        }
        throw new IllegalStateException("closed");
    }

    @Override // com.alibaba.security.common.http.okio.Source
    public Timeout timeout() {
        return this.upstream.timeout();
    }
}
