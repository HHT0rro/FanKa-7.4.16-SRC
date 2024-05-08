package okio;

import java.io.IOException;
import java.util.zip.Deflater;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: DeflaterSink.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class DeflaterSink implements Sink {
    private boolean closed;
    private final Deflater deflater;
    private final BufferedSink sink;

    public DeflaterSink(@NotNull BufferedSink sink, @NotNull Deflater deflater) {
        s.i(sink, "sink");
        s.i(deflater, "deflater");
        this.sink = sink;
        this.deflater = deflater;
    }

    private final void deflate(boolean z10) {
        Segment writableSegment$okio;
        int deflate;
        Buffer buffer = this.sink.getBuffer();
        while (true) {
            writableSegment$okio = buffer.writableSegment$okio(1);
            if (z10) {
                Deflater deflater = this.deflater;
                byte[] bArr = writableSegment$okio.data;
                int i10 = writableSegment$okio.limit;
                deflate = deflater.deflate(bArr, i10, 8192 - i10, 2);
            } else {
                Deflater deflater2 = this.deflater;
                byte[] bArr2 = writableSegment$okio.data;
                int i11 = writableSegment$okio.limit;
                deflate = deflater2.deflate(bArr2, i11, 8192 - i11);
            }
            if (deflate > 0) {
                writableSegment$okio.limit += deflate;
                buffer.setSize$okio(buffer.size() + deflate);
                this.sink.emitCompleteSegments();
            } else if (this.deflater.needsInput()) {
                break;
            }
        }
        if (writableSegment$okio.pos == writableSegment$okio.limit) {
            buffer.head = writableSegment$okio.pop();
            SegmentPool.recycle(writableSegment$okio);
        }
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closed) {
            return;
        }
        Throwable th = null;
        try {
            finishDeflate$okio();
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            this.deflater.end();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        try {
            this.sink.close();
        } catch (Throwable th4) {
            if (th == null) {
                th = th4;
            }
        }
        this.closed = true;
        if (th != null) {
            throw th;
        }
    }

    public final void finishDeflate$okio() {
        this.deflater.finish();
        deflate(false);
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() throws IOException {
        deflate(true);
        this.sink.flush();
    }

    @Override // okio.Sink
    @NotNull
    public Timeout timeout() {
        return this.sink.timeout();
    }

    @NotNull
    public String toString() {
        return "DeflaterSink(" + ((Object) this.sink) + ')';
    }

    @Override // okio.Sink
    public void write(@NotNull Buffer source, long j10) throws IOException {
        s.i(source, "source");
        Util.checkOffsetAndCount(source.size(), 0L, j10);
        while (j10 > 0) {
            Segment segment = source.head;
            s.f(segment);
            int min = (int) Math.min(j10, segment.limit - segment.pos);
            this.deflater.setInput(segment.data, segment.pos, min);
            deflate(false);
            long j11 = min;
            source.setSize$okio(source.size() - j11);
            int i10 = segment.pos + min;
            segment.pos = i10;
            if (i10 == segment.limit) {
                source.head = segment.pop();
                SegmentPool.recycle(segment);
            }
            j10 -= j11;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DeflaterSink(@NotNull Sink sink, @NotNull Deflater deflater) {
        this(Okio.buffer(sink), deflater);
        s.i(sink, "sink");
        s.i(deflater, "deflater");
    }
}
