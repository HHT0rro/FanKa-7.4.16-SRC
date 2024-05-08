package io.grpc.internal;

import com.google.common.base.o;
import io.grpc.Codec;
import io.grpc.Compressor;
import io.grpc.Drainable;
import io.grpc.KnownLength;
import io.grpc.Status;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.zip.ZipUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class MessageFramer implements Framer {
    private static final byte COMPRESSED = 1;
    private static final int HEADER_LENGTH = 5;
    private static final int NO_MAX_OUTBOUND_MESSAGE_SIZE = -1;
    private static final byte UNCOMPRESSED = 0;
    private WritableBuffer buffer;
    private final WritableBufferAllocator bufferAllocator;
    private boolean closed;
    private long currentMessageWireSize;
    private int messagesBuffered;
    private final Sink sink;
    private final StatsTraceContext statsTraceCtx;
    private int maxOutboundMessageSize = -1;
    private Compressor compressor = Codec.Identity.NONE;
    private boolean messageCompression = true;
    private final OutputStreamAdapter outputStreamAdapter = new OutputStreamAdapter();
    private final ByteBuffer headerScratch = ByteBuffer.allocate(5);
    private int currentMessageSeqNo = -1;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class OutputStreamAdapter extends OutputStream {
        private OutputStreamAdapter() {
        }

        @Override // java.io.OutputStream
        public void write(int i10) {
            write(new byte[]{(byte) i10}, 0, 1);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i10, int i11) {
            MessageFramer.this.writeRaw(bArr, i10, i11);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface Sink {
        void deliverFrame(WritableBuffer writableBuffer, boolean z10, boolean z11, int i10);
    }

    public MessageFramer(Sink sink, WritableBufferAllocator writableBufferAllocator, StatsTraceContext statsTraceContext) {
        this.sink = (Sink) o.s(sink, "sink");
        this.bufferAllocator = (WritableBufferAllocator) o.s(writableBufferAllocator, "bufferAllocator");
        this.statsTraceCtx = (StatsTraceContext) o.s(statsTraceContext, "statsTraceCtx");
    }

    private void commitToSink(boolean z10, boolean z11) {
        WritableBuffer writableBuffer = this.buffer;
        this.buffer = null;
        this.sink.deliverFrame(writableBuffer, z10, z11, this.messagesBuffered);
        this.messagesBuffered = 0;
    }

    private int getKnownLength(InputStream inputStream) throws IOException {
        if ((inputStream instanceof KnownLength) || (inputStream instanceof ByteArrayInputStream)) {
            return inputStream.available();
        }
        return -1;
    }

    private void releaseBuffer() {
        WritableBuffer writableBuffer = this.buffer;
        if (writableBuffer != null) {
            writableBuffer.release();
            this.buffer = null;
        }
    }

    private void verifyNotClosed() {
        if (isClosed()) {
            throw new IllegalStateException("Framer already closed");
        }
    }

    private void writeBufferChain(BufferChainOutputStream bufferChainOutputStream, boolean z10) {
        int readableBytes = bufferChainOutputStream.readableBytes();
        this.headerScratch.clear();
        this.headerScratch.put(z10 ? (byte) 1 : (byte) 0).putInt(readableBytes);
        WritableBuffer allocate = this.bufferAllocator.allocate(5);
        allocate.write(this.headerScratch.array(), 0, this.headerScratch.position());
        if (readableBytes == 0) {
            this.buffer = allocate;
            return;
        }
        this.sink.deliverFrame(allocate, false, false, this.messagesBuffered - 1);
        this.messagesBuffered = 1;
        List list = bufferChainOutputStream.bufferList;
        for (int i10 = 0; i10 < list.size() - 1; i10++) {
            this.sink.deliverFrame((WritableBuffer) list.get(i10), false, false, 0);
        }
        this.buffer = (WritableBuffer) list.get(list.size() - 1);
        this.currentMessageWireSize = readableBytes;
    }

    private int writeCompressed(InputStream inputStream, int i10) throws IOException {
        BufferChainOutputStream bufferChainOutputStream = new BufferChainOutputStream();
        OutputStream compress = this.compressor.compress(bufferChainOutputStream);
        try {
            int writeToOutputStream = writeToOutputStream(inputStream, compress);
            compress.close();
            int i11 = this.maxOutboundMessageSize;
            if (i11 >= 0 && writeToOutputStream > i11) {
                throw Status.RESOURCE_EXHAUSTED.withDescription(String.format(Locale.US, "message too large %d > %d", Integer.valueOf(writeToOutputStream), Integer.valueOf(this.maxOutboundMessageSize))).asRuntimeException();
            }
            writeBufferChain(bufferChainOutputStream, true);
            return writeToOutputStream;
        } catch (Throwable th) {
            compress.close();
            throw th;
        }
    }

    private int writeKnownLengthUncompressed(InputStream inputStream, int i10) throws IOException {
        int i11 = this.maxOutboundMessageSize;
        if (i11 >= 0 && i10 > i11) {
            throw Status.RESOURCE_EXHAUSTED.withDescription(String.format(Locale.US, "message too large %d > %d", Integer.valueOf(i10), Integer.valueOf(this.maxOutboundMessageSize))).asRuntimeException();
        }
        this.headerScratch.clear();
        this.headerScratch.put((byte) 0).putInt(i10);
        if (this.buffer == null) {
            this.buffer = this.bufferAllocator.allocate(this.headerScratch.position() + i10);
        }
        writeRaw(this.headerScratch.array(), 0, this.headerScratch.position());
        return writeToOutputStream(inputStream, this.outputStreamAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void writeRaw(byte[] bArr, int i10, int i11) {
        while (i11 > 0) {
            WritableBuffer writableBuffer = this.buffer;
            if (writableBuffer != null && writableBuffer.writableBytes() == 0) {
                commitToSink(false, false);
            }
            if (this.buffer == null) {
                this.buffer = this.bufferAllocator.allocate(i11);
            }
            int min = Math.min(i11, this.buffer.writableBytes());
            this.buffer.write(bArr, i10, min);
            i10 += min;
            i11 -= min;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static int writeToOutputStream(InputStream inputStream, OutputStream outputStream) throws IOException {
        if (inputStream instanceof Drainable) {
            return ((Drainable) inputStream).drainTo(outputStream);
        }
        long b4 = com.google.common.io.a.b(inputStream, outputStream);
        o.j(b4 <= ZipUtils.UPPER_UNIXTIME_BOUND, "Message size overflow: %s", b4);
        return (int) b4;
    }

    private int writeUncompressed(InputStream inputStream, int i10) throws IOException {
        if (i10 != -1) {
            this.currentMessageWireSize = i10;
            return writeKnownLengthUncompressed(inputStream, i10);
        }
        BufferChainOutputStream bufferChainOutputStream = new BufferChainOutputStream();
        int writeToOutputStream = writeToOutputStream(inputStream, bufferChainOutputStream);
        int i11 = this.maxOutboundMessageSize;
        if (i11 >= 0 && writeToOutputStream > i11) {
            throw Status.RESOURCE_EXHAUSTED.withDescription(String.format(Locale.US, "message too large %d > %d", Integer.valueOf(writeToOutputStream), Integer.valueOf(this.maxOutboundMessageSize))).asRuntimeException();
        }
        writeBufferChain(bufferChainOutputStream, false);
        return writeToOutputStream;
    }

    @Override // io.grpc.internal.Framer
    public void close() {
        if (isClosed()) {
            return;
        }
        this.closed = true;
        WritableBuffer writableBuffer = this.buffer;
        if (writableBuffer != null && writableBuffer.readableBytes() == 0) {
            releaseBuffer();
        }
        commitToSink(true, true);
    }

    @Override // io.grpc.internal.Framer
    public void dispose() {
        this.closed = true;
        releaseBuffer();
    }

    @Override // io.grpc.internal.Framer
    public void flush() {
        WritableBuffer writableBuffer = this.buffer;
        if (writableBuffer == null || writableBuffer.readableBytes() <= 0) {
            return;
        }
        commitToSink(false, true);
    }

    @Override // io.grpc.internal.Framer
    public boolean isClosed() {
        return this.closed;
    }

    @Override // io.grpc.internal.Framer
    public void setMaxOutboundMessageSize(int i10) {
        o.y(this.maxOutboundMessageSize == -1, "max size already set");
        this.maxOutboundMessageSize = i10;
    }

    @Override // io.grpc.internal.Framer
    public void writePayload(InputStream inputStream) {
        int writeUncompressed;
        verifyNotClosed();
        this.messagesBuffered++;
        int i10 = this.currentMessageSeqNo + 1;
        this.currentMessageSeqNo = i10;
        this.currentMessageWireSize = 0L;
        this.statsTraceCtx.outboundMessage(i10);
        boolean z10 = this.messageCompression && this.compressor != Codec.Identity.NONE;
        try {
            int knownLength = getKnownLength(inputStream);
            if (knownLength != 0 && z10) {
                writeUncompressed = writeCompressed(inputStream, knownLength);
            } else {
                writeUncompressed = writeUncompressed(inputStream, knownLength);
            }
            if (knownLength != -1 && writeUncompressed != knownLength) {
                throw Status.INTERNAL.withDescription(String.format("Message length inaccurate %s != %s", Integer.valueOf(writeUncompressed), Integer.valueOf(knownLength))).asRuntimeException();
            }
            long j10 = writeUncompressed;
            this.statsTraceCtx.outboundUncompressedSize(j10);
            this.statsTraceCtx.outboundWireSize(this.currentMessageWireSize);
            this.statsTraceCtx.outboundMessageSent(this.currentMessageSeqNo, this.currentMessageWireSize, j10);
        } catch (IOException e2) {
            throw Status.INTERNAL.withDescription("Failed to frame message").withCause(e2).asRuntimeException();
        } catch (RuntimeException e10) {
            throw Status.INTERNAL.withDescription("Failed to frame message").withCause(e10).asRuntimeException();
        }
    }

    @Override // io.grpc.internal.Framer
    public MessageFramer setCompressor(Compressor compressor) {
        this.compressor = (Compressor) o.s(compressor, "Can't pass an empty compressor");
        return this;
    }

    @Override // io.grpc.internal.Framer
    public MessageFramer setMessageCompression(boolean z10) {
        this.messageCompression = z10;
        return this;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public final class BufferChainOutputStream extends OutputStream {
        private final List<WritableBuffer> bufferList;
        private WritableBuffer current;

        private BufferChainOutputStream() {
            this.bufferList = new ArrayList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int readableBytes() {
            Iterator<WritableBuffer> iterator2 = this.bufferList.iterator2();
            int i10 = 0;
            while (iterator2.hasNext()) {
                i10 += iterator2.next().readableBytes();
            }
            return i10;
        }

        @Override // java.io.OutputStream
        public void write(int i10) throws IOException {
            WritableBuffer writableBuffer = this.current;
            if (writableBuffer != null && writableBuffer.writableBytes() > 0) {
                this.current.write((byte) i10);
            } else {
                write(new byte[]{(byte) i10}, 0, 1);
            }
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i10, int i11) {
            if (this.current == null) {
                WritableBuffer allocate = MessageFramer.this.bufferAllocator.allocate(i11);
                this.current = allocate;
                this.bufferList.add(allocate);
            }
            while (i11 > 0) {
                int min = Math.min(i11, this.current.writableBytes());
                if (min == 0) {
                    WritableBuffer allocate2 = MessageFramer.this.bufferAllocator.allocate(Math.max(i11, this.current.readableBytes() * 2));
                    this.current = allocate2;
                    this.bufferList.add(allocate2);
                } else {
                    this.current.write(bArr, i10, min);
                    i10 += min;
                    i11 -= min;
                }
            }
        }
    }
}
