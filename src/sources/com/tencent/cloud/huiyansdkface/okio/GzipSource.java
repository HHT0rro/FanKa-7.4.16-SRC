package com.tencent.cloud.huiyansdkface.okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class GzipSource implements Source {
    private static final byte FCOMMENT = 4;
    private static final byte FEXTRA = 2;
    private static final byte FHCRC = 1;
    private static final byte FNAME = 3;
    private static final byte SECTION_BODY = 1;
    private static final byte SECTION_DONE = 3;
    private static final byte SECTION_HEADER = 0;
    private static final byte SECTION_TRAILER = 2;
    private final Inflater inflater;
    private final InflaterSource inflaterSource;
    private final BufferedSource source;
    private int section = 0;
    private final CRC32 crc = new CRC32();

    public GzipSource(Source source) {
        if (source == null) {
            throw new IllegalArgumentException("source == null");
        }
        Inflater inflater = new Inflater(true);
        this.inflater = inflater;
        BufferedSource buffer = Okio.buffer(source);
        this.source = buffer;
        this.inflaterSource = new InflaterSource(buffer, inflater);
    }

    private void checkEqual(String str, int i10, int i11) throws IOException {
        if (i11 != i10) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", str, Integer.valueOf(i11), Integer.valueOf(i10)));
        }
    }

    private void consumeHeader() throws IOException {
        this.source.require(10L);
        byte b4 = this.source.buffer().getByte(3L);
        boolean z10 = ((b4 >> 1) & 1) == 1;
        if (z10) {
            updateCrc(this.source.buffer(), 0L, 10L);
        }
        checkEqual("ID1ID2", 8075, this.source.readShort());
        this.source.skip(8L);
        if (((b4 >> 2) & 1) == 1) {
            this.source.require(2L);
            if (z10) {
                updateCrc(this.source.buffer(), 0L, 2L);
            }
            long readShortLe = this.source.buffer().readShortLe();
            this.source.require(readShortLe);
            if (z10) {
                updateCrc(this.source.buffer(), 0L, readShortLe);
            }
            this.source.skip(readShortLe);
        }
        if (((b4 >> 3) & 1) == 1) {
            long indexOf = this.source.indexOf((byte) 0);
            if (indexOf == -1) {
                throw new EOFException();
            }
            if (z10) {
                updateCrc(this.source.buffer(), 0L, indexOf + 1);
            }
            this.source.skip(indexOf + 1);
        }
        if (((b4 >> 4) & 1) == 1) {
            long indexOf2 = this.source.indexOf((byte) 0);
            if (indexOf2 == -1) {
                throw new EOFException();
            }
            if (z10) {
                updateCrc(this.source.buffer(), 0L, indexOf2 + 1);
            }
            this.source.skip(indexOf2 + 1);
        }
        if (z10) {
            checkEqual("FHCRC", this.source.readShortLe(), (short) this.crc.getValue());
            this.crc.reset();
        }
    }

    private void consumeTrailer() throws IOException {
        checkEqual("CRC", this.source.readIntLe(), (int) this.crc.getValue());
        checkEqual("ISIZE", this.source.readIntLe(), (int) this.inflater.getBytesWritten());
    }

    private void updateCrc(Buffer buffer, long j10, long j11) {
        Segment segment = buffer.head;
        while (true) {
            int i10 = segment.limit;
            int i11 = segment.pos;
            if (j10 < i10 - i11) {
                break;
            }
            j10 -= i10 - i11;
            segment = segment.next;
        }
        while (j11 > 0) {
            int min = (int) Math.min(segment.limit - r7, j11);
            this.crc.update(segment.data, (int) (segment.pos + j10), min);
            j11 -= min;
            segment = segment.next;
            j10 = 0;
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.inflaterSource.close();
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.Source
    public long read(Buffer buffer, long j10) throws IOException {
        if (j10 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j10);
        }
        if (j10 == 0) {
            return 0L;
        }
        if (this.section == 0) {
            consumeHeader();
            this.section = 1;
        }
        if (this.section == 1) {
            long j11 = buffer.size;
            long read = this.inflaterSource.read(buffer, j10);
            if (read != -1) {
                updateCrc(buffer, j11, read);
                return read;
            }
            this.section = 2;
        }
        if (this.section == 2) {
            consumeTrailer();
            this.section = 3;
            if (!this.source.exhausted()) {
                throw new IOException("gzip finished without exhausting source");
            }
        }
        return -1L;
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.Source
    public Timeout timeout() {
        return this.source.timeout();
    }
}
